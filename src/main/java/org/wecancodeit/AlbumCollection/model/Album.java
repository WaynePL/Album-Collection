package org.wecancodeit.AlbumCollection.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Album {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String image;
	private Collection<Song> songs;
	private String recordLabel;

	@ManyToOne
	private Artist artist;

	public Album(String title, String image, String recordLabel) {
		super();
		this.title = title;
		this.image = image;
		this.recordLabel = recordLabel;
	}

	public Album() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}

	public Collection<Song> getSongs() {
		return songs;
	}

	public String getRecordLabel() {
		return recordLabel;
	}

}
