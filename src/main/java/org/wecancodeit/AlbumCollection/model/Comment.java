package org.wecancodeit.AlbumCollection.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Long id;

	private int rating;

	@Lob
	private String text;

	@JsonIgnore
	@ManyToOne
	private Album album;

	@JsonIgnore
	@ManyToOne
	private Artist artist;

	@JsonIgnore
	@ManyToOne
	private Song song;

	private String username;

	public Comment() {
	}

	public Comment(String username, int rating, String text, Artist artist) {
		this.username = username;
		this.text = text;
		this.rating = rating;
	}

	public Comment(String username, int rating, String text, Album album) {
		this.username = username;
		this.text = text;
		this.rating = rating;
	}

	public Comment(String username, int rating, String text, Song song) {
		this.username = username;
		this.text = text;
		this.rating = rating;
	}

	public Comment(String username, String text) {
		this.username = username;
		this.text = text;
	}

	public String getUsername() {
		return username;
	}

	public Artist getArtist() {
		return artist;
	}

	public Song getSong() {
		return song;
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public Album getAlbum() {
		return album;
	}

	public int getRating() {
		return rating;
	}

}
