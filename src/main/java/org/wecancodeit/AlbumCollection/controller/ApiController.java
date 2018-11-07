package org.wecancodeit.AlbumCollection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.AlbumCollection.model.Artist;
import org.wecancodeit.AlbumCollection.repositories.ArtistRepository;

@RestController
public class ApiController {

	@Autowired
	ArtistRepository artistRepo;

	@GetMapping("/api/artist/{id}")
	public Artist getOneArtist(@PathVariable(value = "id") Long id) {
		return artistRepo.findById(id).get();
	}
}
