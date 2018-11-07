package org.wecancodeit.AlbumCollection.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Song {

	@Id
	@GeneratedValue
	private Long id;

	private String title;
	private String time;

	@ManyToOne
	private Album album;

	public Song(String title, String time) {
		this.title = title;
		this.time = time;
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
