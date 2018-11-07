package org.wecancodeit.AlbumCollection.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
