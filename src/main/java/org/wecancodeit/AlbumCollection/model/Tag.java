package org.wecancodeit.AlbumCollection.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {

	public Tag() {
	}

	@Id
	@GeneratedValue
	private Long id;

	private String tagName;

	@JsonIgnore
	@ManyToMany
	private Collection<Artist> artists = new ArrayList<Artist>();

	@JsonIgnore
	@ManyToMany
	private Collection<Album> albums = new ArrayList<Album>();

	@JsonIgnore
	@ManyToMany
	private Collection<Song> songs = new ArrayList<Song>();

	public Tag(String tagName, Artist artist) {
		this.tagName = tagName;
		System.out.println(artists);
		artists.add(artist);
	}

	public Tag(String tagName, Album album) {
		this.tagName = tagName;
		albums.add(album);
	}

	public Tag(String tagName, Song song) {
		this.tagName = tagName;
		songs.add(song);
	}

	public String getTagName() {
		return tagName;
	}

	public Long getId() {
		return id;
	}

}