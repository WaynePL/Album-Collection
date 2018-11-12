package org.wecancodeit.AlbumCollection.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Artist {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String imageURL;

	@OneToMany(mappedBy = "artist")
	private Collection<Album> albums = new ArrayList<Album>();

	@ManyToMany(mappedBy = "artists")
	private Collection<Tag> tags;

	@OneToMany(mappedBy = "artist")
	private Collection<Comment> comments = new ArrayList<Comment>();

	public Collection<Tag> getTags() {
		return tags;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public Artist() {
	}

	public Artist(String name, String imageURL) {

		this.name = name;
		this.imageURL = imageURL;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImageURL() {
		return imageURL;
	}

	public Collection<Album> getAlbums() {
		return albums;
	}

}
