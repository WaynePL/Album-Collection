package org.wecancodeit.AlbumCollection.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {

	public Tag() {
	}

	public Tag(String tagName) {
		this.tagName = tagName;
	}

	@Id
	@GeneratedValue
	private Long id;

	private String tagName;

	@JsonIgnore
	@ManyToMany(mappedBy = "tags")
	private Collection<Album> albums;

	@JsonIgnore
	@ManyToMany(mappedBy = "tags")
	private Collection<Song> songs;

	@JsonIgnore
	@ManyToMany(mappedBy = "tags")
	private Collection<Artist> artists;

	public String getTagName() {
		return tagName;
	}

	public Long getId() {
		return id;
	}

}