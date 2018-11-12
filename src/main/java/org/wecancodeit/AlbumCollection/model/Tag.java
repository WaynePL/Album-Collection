package org.wecancodeit.AlbumCollection.model;

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

	public Tag(String tagName, Artist artist) {
		this.tagName = tagName;
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

	@Id
	@GeneratedValue
	private Long id;

	private String tagName;

	@JsonIgnore
	@ManyToMany
	private Collection<Artist> artists;

	@JsonIgnore
	@ManyToMany
	private Collection<Album> albums;

	@JsonIgnore
	@ManyToMany
	private Collection<Song> songs;

	public String getTagName() {
		return tagName;
	}

	public Long getId() {
		return id;
	}

}