package org.wecancodeit.AlbumCollection;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.AlbumCollection.model.Artist;
import org.wecancodeit.AlbumCollection.repositories.ArtistRepository;

@Service
public class MusicPopulator implements CommandLineRunner {

	@Resource
	ArtistRepository artistRepo;

	@Override
	public void run(String... args) throws Exception {

		artistRepo.save(new Artist("The Who", ""));
	}
}
