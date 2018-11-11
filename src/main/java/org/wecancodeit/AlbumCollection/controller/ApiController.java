package org.wecancodeit.AlbumCollection.controller;

import java.util.Collection;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.AlbumCollection.model.Album;
import org.wecancodeit.AlbumCollection.model.Artist;
import org.wecancodeit.AlbumCollection.model.Song;
import org.wecancodeit.AlbumCollection.repositories.AlbumRepository;
import org.wecancodeit.AlbumCollection.repositories.ArtistRepository;
import org.wecancodeit.AlbumCollection.repositories.SongRepository;

@RestController
public class ApiController {

	@Autowired
	ArtistRepository artistRepo;

	@Autowired
	AlbumRepository albumRepo;

	@Autowired
	SongRepository songRepo;

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

	@PostMapping("api/artists/add")
	public Collection<Artist> addNewArtists(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		artistRepo.save(new Artist(json.getString("name"), json.getString("imageUrl")));
		return (Collection<Artist>) artistRepo.findAll();
	}

	@PostMapping("api/album/add")
	public Collection<Album> addNewAlbums(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		albumRepo.save(new Album(json.getString("name"), json.getString("imageUrl"), json.getString("recordLabel"),
				artistRepo.findByName(json.getString("artistName"))));
		return null;
	}

	@PostMapping("api/song/add")
	public Collection<Song> addNewSong(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		songRepo.save(new Song(json.getString("name"), json.getString("length"),
				albumRepo.findByName(json.getString("album"))));
		return null;
	}
}
