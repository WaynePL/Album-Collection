package org.wecancodeit.AlbumCollection.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Album {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	public Artist getArtist() {
		return artist;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	@Lob
	private String image;

	@OneToMany(mappedBy = "album")
	private Collection<Song> songs = new ArrayList<Song>();
	private String recordLabel;

	@JsonIgnore
	@ManyToOne
	private Artist artist;

	@OneToMany(mappedBy = "album")
	private Collection<Comment> comments = new ArrayList<Comment>();

	@ManyToMany(mappedBy = "albums")
	private Collection<Tag> tags = new ArrayList<>();

	public Album() {
	}

	public Album(String title, String image, String recordLabel, Artist artist) {
		super();
		this.name = title;
		this.image = image;
		this.recordLabel = recordLabel;
		this.artist = artist;
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
