package cn.edu.imut.jm.journal.domain.journal.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class JournalImages {
	/**
	 * 
	 */
	private Integer imagesId;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String url;

	/**
	 * 
	 */
	private Integer journalId;

	public Integer getImagesId() {
		return imagesId;
	}

	public void setImagesId(Integer imagesId) {
		this.imagesId = imagesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public JournalImages(Integer imagesId, String name, String url, Integer journalId) {
		super();
		this.imagesId = imagesId;
		this.name = name;
		this.url = url;
		this.journalId = journalId;
	}

	public JournalImages(String name, String url, Integer journalId) {
		super();
		this.name = name;
		this.url = url;
		this.journalId = journalId;
	}

	public JournalImages() {
		super();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}