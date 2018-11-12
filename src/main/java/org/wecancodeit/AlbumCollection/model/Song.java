package org.wecancodeit.AlbumCollection.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Song {

	@Id
	@GeneratedValue
	private Long id;

	private String title;
	private String time;

	@JsonIgnore
	@ManyToOne
	private Album album;

	@OneToMany(mappedBy = "song")
	private Collection<Comment> comments;

	@ManyToMany(mappedBy = "songs")
	private Collection<Tag> tags;

	public String getTitle() {
		return title;
	}

	public Album getAlbum() {
		return album;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	public Song() {
	}

	public Song(String title, String time, Album album) {
		this.title = title;
		this.time = time;
		this.album = album;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return title;
	}

	public String getTime() {
		return time;
	}

}
