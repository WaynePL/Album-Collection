package org.wecancodeit.AlbumCollection.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Album {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String image;

	@OneToMany(mappedBy = "album")
	private Collection<Song> songs = new ArrayList<Song>();
	private String recordLabel;

	@JsonIgnore
	@ManyToOne
	private Artist artist;

	public Album(String title, String image, String recordLabel, Artist artist) {
		super();
		this.name = title;
		this.image = image;
		this.recordLabel = recordLabel;
		this.artist = artist;
	}

	public Album() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
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
