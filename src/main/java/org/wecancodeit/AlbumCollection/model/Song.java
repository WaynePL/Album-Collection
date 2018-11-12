package org.wecancodeit.AlbumCollection.model;

import java.util.ArrayList;
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

	private String name;
	private String time;

	@JsonIgnore
	@ManyToOne
	private Album album;

	@OneToMany(mappedBy = "song")
	private Collection<Comment> comments = new ArrayList<Comment>();

	@ManyToMany(mappedBy = "songs")
	private Collection<Tag> tags;

	public String getTitle() {
		return name;
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
		this.name = title;
		this.time = time;
		this.album = album;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getTime() {
		return time;
	}

}
