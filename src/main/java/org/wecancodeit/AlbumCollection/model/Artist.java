package org.wecancodeit.AlbumCollection.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artist {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String imageURL;

	@OneToMany(mappedBy = "artist")
	private Collection<Album> albums;

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
