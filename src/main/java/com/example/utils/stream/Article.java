package com.example.utils.stream;

import java.util.List;

/**
 * @Auther: ld
 * @Date: 2019/4/10 14:53
 * @Param ${tags}
 * @Description:
 */
public class Article {
	private final String title;
	private final String author;
	private final List<String> tags;

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public List<String> getTags() {
		return tags;
	}

	public Article(String title, String author, List<String> tags) {
		this.title = title;
		this.author = author;
		this.tags = tags;
	}
}
