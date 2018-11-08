package org.wecancodeit.AlbumCollection;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.AlbumCollection.model.Album;
import org.wecancodeit.AlbumCollection.model.Artist;
import org.wecancodeit.AlbumCollection.model.Song;
import org.wecancodeit.AlbumCollection.repositories.AlbumRepository;
import org.wecancodeit.AlbumCollection.repositories.ArtistRepository;
import org.wecancodeit.AlbumCollection.repositories.SongRepository;

@Service
public class MusicPopulator implements CommandLineRunner {

	@Resource
	ArtistRepository artistRepo;

	@Resource
	AlbumRepository albumRepo;

	@Resource
	SongRepository songRepo;

	@Override
	public void run(String... args) throws Exception {

		Artist artistOne = artistRepo.save(new Artist("The Who", ""));
		Album albumOne = albumRepo.save(new Album("The Kids Are Alright", "", "Brunswick", artistOne));
		Song songOne = songRepo.save(new Song("My Generation", "4:31", albumOne));
		Album albumTwo = albumRepo.save(new Album("Who Are You", "", "MCA", artistOne));
		Song songTwo = songRepo.save(new Song("Who Are You", "6:16", albumTwo));

	}
}
