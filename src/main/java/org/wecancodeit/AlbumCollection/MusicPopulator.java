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

		Artist theWho = artistRepo.save(new Artist("The Who", "the-who.jpeg"));
		Album kidsAreAlright = albumRepo
				.save(new Album("The Kids Are Alright", "kids-are-alright.jpg", "Brunswick", theWho));
		songRepo.save(new Song("My Generation", "4:31", kidsAreAlright));
		songRepo.save(new Song("My Wife", "6:18", kidsAreAlright));
		songRepo.save(new Song("Baba O'Reilly", "5:29", kidsAreAlright));

		Album whoAreYou = albumRepo.save(new Album("Who Are You", "who-are-you.jpg", "MCA", theWho));
		songRepo.save(new Song("Who Are You", "6:16", whoAreYou));
		songRepo.save(new Song("New Song", "4:18", whoAreYou));
		songRepo.save(new Song("Sister Disco", "4:20", whoAreYou));

		Artist queen = artistRepo.save(new Artist("Queen", "queen.jpg"));
		Album queen40 = albumRepo
				.save(new Album("Queen 40 Limited Edition", "queen40.jpg", "Universal Music Group", queen));
		songRepo.save(new Song("Killer Queen", "2:59", queen40));
		songRepo.save(new Song("Bohemian Rhapsody", "5:54", queen40));
		songRepo.save(new Song("Stone Cold Crazy", "2:13", queen40));

		Album theGame = albumRepo.save(new Album("The Game", "the-game.jpg", "EMI Records Ltd.", queen));
		songRepo.save(new Song("Another One Bites The Dust", "3:35", theGame));
		songRepo.save(new Song("Crazy Little Thing Called Love", "2:44", theGame));
		songRepo.save(new Song("Dragon Attack", "2:44", theGame));

	}
}
