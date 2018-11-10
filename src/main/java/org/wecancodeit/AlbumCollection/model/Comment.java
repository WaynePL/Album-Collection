package org.wecancodeit.AlbumCollection.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Long id;

	@Lob
	private String text;

	@JsonIgnore
	@ManyToOne
	private Album album;

	public Comment() {
	}

	public Comment(String text, Album album) {
		this.text = text;
		this.album = album;
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public Album getAlbum() {
		return album;
	}

}
