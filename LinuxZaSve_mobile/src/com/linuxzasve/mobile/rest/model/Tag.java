package com.linuxzasve.mobile.rest.model;

public class Tag {
	private int id;
	private String slug;
	private String title;
	private String description;
	private String post_count;

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(final String slug) {
		this.slug = slug;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getPost_count() {
		return post_count;
	}

	public void setPost_count(final String post_count) {
		this.post_count = post_count;
	}

	public Tag() {
	}
}
