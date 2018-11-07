package org.wecancodeit.AlbumCollection.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Artist {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String imageURL;
	private Collection<Albums> albums;

	public Artist(String name, String imageURL, Collection<Albums> albums) {

		this.name = name;
		this.imageURL = imageURL;
		this.albums = albums;
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

	public Collection<Albums> getAlbums() {
		return albums;
	}

}
