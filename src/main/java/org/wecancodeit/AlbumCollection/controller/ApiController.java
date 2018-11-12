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
import org.wecancodeit.AlbumCollection.model.Comment;
import org.wecancodeit.AlbumCollection.model.Song;
import org.wecancodeit.AlbumCollection.model.Tag;
import org.wecancodeit.AlbumCollection.repositories.AlbumRepository;
import org.wecancodeit.AlbumCollection.repositories.ArtistRepository;
import org.wecancodeit.AlbumCollection.repositories.SongRepository;
import org.wecancodeit.AlbumCollection.repositories.TagRepository;

@RestController
public class ApiController {

	@Autowired
	ArtistRepository artistRepo;

	@Autowired
	AlbumRepository albumRepo;

	@Autowired
	SongRepository songRepo;

	@Autowired
	TagRepository tagRepo;

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

	@PostMapping("api/artist/add")
	public Collection<Artist> addNewArtists(@RequestBody String body) throws JSONException {
		System.out.println(body);
		JSONObject json = new JSONObject(body);
		artistRepo.save(new Artist(json.getString("name"), json.getString("imageUrl")));
		return (Collection<Artist>) artistRepo.findAll();
	}

	@PostMapping("api/album/add")
	public Collection<Album> addNewAlbums(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		Artist artist = artistRepo.findByName(json.getString("artistName"));
		albumRepo.save(
				new Album(json.getString("name"), json.getString("imageUrl"), json.getString("recordLabel"), artist));
		return artist.getAlbums();
	}

	@PostMapping("api/song/add")
	public Collection<Song> addNewSong(@RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		Album album = albumRepo.findByName(json.getString("album"));
		songRepo.save(new Song(json.getString("name"), json.getString("length"), album));
		return album.getSongs();
	}

	@PostMapping("api/artist/{id}/add-tag")
	public Collection<Tag> addArtistTag(@PathVariable(value = "id") Long id, @RequestBody String body)
			throws JSONException {
		JSONObject json = new JSONObject(body);
		Artist artist = artistRepo.findById(id).get();
		System.out.println(new Tag(json.getString("name"), artistRepo.findById(id).get()).getTagName());
		Tag tag = tagRepo.save(new Tag(json.getString("name"), artist));
		System.out.println(tag.getTagName());
		artistRepo.save(artist);
		System.out.println(artist.getTags().size());
		return artist.getTags();
	}

	@PostMapping("api/album/{id}/add-tag")
	public Collection<Tag> addAlbumTag(@PathVariable(value = "id") Long id, @RequestBody String body)
			throws JSONException {
		JSONObject json = new JSONObject(body);
		Album album = albumRepo.findById(id).get();
		tagRepo.save(new Tag(json.getString("name"), album));
		albumRepo.save(album);
		return album.getTags();
	}

	@PostMapping("api/song/{id}/add-tag")
	public Collection<Tag> addSongTag(@PathVariable(value = "id") Long id, @RequestBody String body)
			throws JSONException {
		JSONObject json = new JSONObject(body);
		Song song = songRepo.findById(id).get();
		tagRepo.save(new Tag(json.getString("name"), song));
		songRepo.save(song);
		return song.getTags();
	}

	@PostMapping("api/song/{id}/add-comment")
	public Collection<Comment> addSongComment(@PathVariable(value = "id") Long id, @RequestBody String body)
			throws JSONException {
		JSONObject json = new JSONObject(body);
		Song song = songRepo.findById(id).get();
		tagRepo.save(new Tag(json.getString("name"), song));
		songRepo.save(song);
		return song.getComments();
	}

	@PostMapping("api/album/{id}/add-tag")
	public Collection<Comment> addAlbumComment(@PathVariable(value = "id") Long id, @RequestBody String body)
			throws JSONException {
		JSONObject json = new JSONObject(body);
		Album album = albumRepo.findById(id).get();
		tagRepo.save(new Tag(json.getString("name"), album));
		albumRepo.save(album);
		return album.getComments();
	}

	@PostMapping("api/artist/{id}/add-tag")
	public Collection<Comment> addArtistComment(@PathVariable(value = "id") Long id, @RequestBody String body)
			throws JSONException {
		JSONObject json = new JSONObject(body);
		Artist artist = artistRepo.findById(id).get();
		tagRepo.save(new Tag(json.getString("name"), artist));
		artistRepo.save(artist);
		return artist.getComments();
	}
}
