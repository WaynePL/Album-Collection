package org.wecancodeit.AlbumCollection.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.AlbumCollection.model.Album;
import org.wecancodeit.AlbumCollection.model.Artist;
import org.wecancodeit.AlbumCollection.repositories.AlbumRepository;
import org.wecancodeit.AlbumCollection.repositories.ArtistRepository;

@RestController
public class ApiController {

	@Autowired
	ArtistRepository artistRepo;

	@Autowired
	AlbumRepository albumRepo;

	@GetMapping("/api/artist/{id}")
	public Artist getOneArtist(@PathVariable(value = "id") Long id) {
		return artistRepo.findById(id).get();
	}

	@GetMapping("/api/artists")
	public Collection<Artist> getAllArtists() {
		return (Collection<Artist>) artistRepo.findAll();
	}

	@GetMapping("/api/albums")
	public Collection<Album> getAllAlbums() {
		return (Collection<Album>) albumRepo.findAll();
	}
}
