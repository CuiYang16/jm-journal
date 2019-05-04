package cn.edu.imut.jm.journal.domain.journal.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class JournalDetails {
	/**
	 * 资料表
	 */
	private Integer journalId;

	/**
	 * 资料名称
	 */
	private String journalName;

	/**
	 * 杂志图片
	 */
	private String journalImg;

	/**
	 * 作者（可多个）
	 */
	private String author;

	/**
	 * 杂志级别
	 */
	private Integer journalLevel;

	/**
	 * 入库时间
	 */
	private Date journalJoinTime;

	/**
	 * 出版时间
	 */
	private Date publishTime;

	/**
	 * 卷号
	 */
	private Integer reelNumber;

	/**
	 * 期号（yyyy-mm）
	 */
	private String issue;

	/**
	 * 总期号
	 */
	private Integer totalIssue;

	/**
	 * 国内统一刊号(CNxx-xxxx/xx)
	 */
	private String cn;

	/**
	 * 国际标准书号
	 */
	private String isbn;

	/**
	 * 国际标准刊号（ISSN xxxx-xxxx）
	 */
	private String issn;

	/**
	 * 出版周期
	 */
	private Integer publicationCycle;

	/**
	 * 出版社
	 */
	private String publishingHouse;

	/**
	 * 主办
	 */
	private String journalHost;

	/**
	 * 是否是国外
	 */
	private Boolean isForeign;

	/**
	 * 出版地区
	 * 
	 */
	private Integer publishingArea;

	/**
	 * 出版语言
	 * 
	 */
	private Integer jounalLanguage;

	/**
	 * 国外代号（mxxxx）
	 */
	private String foreignCodes;

	/**
	 * 国内代号(x-xxx)
	 */
	private String domesticCode;

	/**
	 * 开本
	 */
	private Integer format;

	/**
	 * 页数
	 */
	private Integer pageNumber;

	/**
	 * 库存
	 */
	private Integer inventory;
	/**
	 * 是否可借阅
	 */
	private Boolean isBorrow;

	/**
	 * 价格
	 */
	private BigDecimal price;

	/**
	 * 描述简介
	 */
	private String description;

	/**
	 * 是否已删除
	 */
	private Boolean isDelete;

	/**
	 * 资料类别外键
	 */
	private Integer typeId;

	/**
	 * 资料类别外键（数组）
	 */
	private String journalType;

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public String getJournalName() {
		return journalName;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName == null ? null : journalName.trim();
	}

	public String getJournalImg() {
		return journalImg;
	}

	public void setJournalImg(String journalImg) {
		this.journalImg = journalImg == null ? null : journalImg.trim();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author == null ? null : author.trim();
	}

	public Integer getJournalLevel() {
		return journalLevel;
	}

	public void setJournalLevel(Integer journalLevel) {
		this.journalLevel = journalLevel;
	}

	public Date getJournalJoinTime() {
		return journalJoinTime;
	}

	public void setJournalJoinTime(Date journalJoinTime) {
		this.journalJoinTime = journalJoinTime;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Integer getReelNumber() {
		return reelNumber;
	}

	public void setReelNumber(Integer reelNumber) {
		this.reelNumber = reelNumber;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue == null ? null : issue.trim();
	}

	public Integer getTotalIssue() {
		return totalIssue;
	}

	public void setTotalIssue(Integer totalIssue) {
		this.totalIssue = totalIssue;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn == null ? null : cn.trim();
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn == null ? null : isbn.trim();
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn == null ? null : issn.trim();
	}

	public Integer getPublicationCycle() {
		return publicationCycle;
	}

	public void setPublicationCycle(Integer publicationCycle) {
		this.publicationCycle = publicationCycle;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse == null ? null : publishingHouse.trim();
	}

	public String getJournalHost() {
		return journalHost;
	}

	public void setJournalHost(String journalHost) {
		this.journalHost = journalHost == null ? null : journalHost.trim();
	}

	public Boolean getIsForeign() {
		return isForeign;
	}

	public void setIsForeign(Boolean isForeign) {
		this.isForeign = isForeign;
	}

	public Integer getPublishingArea() {
		return publishingArea;
	}

	public void setPublishingArea(Integer publishingArea) {
		this.publishingArea = publishingArea;
	}

	public Integer getJounalLanguage() {
		return jounalLanguage;
	}

	public void setJounalLanguage(Integer jounalLanguage) {
		this.jounalLanguage = jounalLanguage;
	}

	public String getForeignCodes() {
		return foreignCodes;
	}

	public void setForeignCodes(String foreignCodes) {
		this.foreignCodes = foreignCodes == null ? null : foreignCodes.trim();
	}

	public String getDomesticCode() {
		return domesticCode;
	}

	public void setDomesticCode(String domesticCode) {
		this.domesticCode = domesticCode == null ? null : domesticCode.trim();
	}

	public Integer getFormat() {
		return format;
	}

	public void setFormat(Integer format) {
		this.format = format;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Boolean getIsBorrow() {
		return isBorrow;
	}

	public void setIsBorrow(Boolean isBorrow) {
		this.isBorrow = isBorrow;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getJournalType() {
		return journalType;
	}

	public void setJournalType(String journalType) {
		this.journalType = journalType == null ? null : journalType.trim();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}