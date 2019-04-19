package cn.edu.imut.jm.journal.domain.journal.valobj;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import cn.edu.imut.jm.journal.domain.journal.entity.JournalImages;
import cn.edu.imut.jm.journal.domain.type.entity.JournalType;

public class JournalDetailVo {
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

	private JournalType type;

	private List<JournalImages> journalImages;

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
		this.journalName = journalName;
	}

	public String getJournalImg() {
		return journalImg;
	}

	public void setJournalImg(String journalImg) {
		this.journalImg = journalImg;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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
		this.issue = issue;
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
		this.cn = cn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
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
		this.publishingHouse = publishingHouse;
	}

	public String getJournalHost() {
		return journalHost;
	}

	public void setJournalHost(String journalHost) {
		this.journalHost = journalHost;
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
		this.foreignCodes = foreignCodes;
	}

	public String getDomesticCode() {
		return domesticCode;
	}

	public void setDomesticCode(String domesticCode) {
		this.domesticCode = domesticCode;
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
		this.description = description;
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
		this.journalType = journalType;
	}

	public JournalType getType() {
		return type;
	}

	public void setType(JournalType type) {
		this.type = type;
	}

	public List<JournalImages> getJournalImages() {
		return journalImages;
	}

	public void setJournalImages(List<JournalImages> journalImages) {
		this.journalImages = journalImages;
	}

	public JournalDetailVo(Integer journalId, String journalName, String journalImg, String author,
			Integer journalLevel, Date journalJoinTime, Date publishTime, Integer reelNumber, String issue,
			Integer totalIssue, String cn, String isbn, String issn, Integer publicationCycle, String publishingHouse,
			String journalHost, Boolean isForeign, Integer publishingArea, Integer jounalLanguage, String foreignCodes,
			String domesticCode, Integer format, Integer pageNumber, Boolean isBorrow, BigDecimal price,
			String description, Boolean isDelete, Integer typeId, String journalType, JournalType type,
			List<JournalImages> journalImages) {
		super();
		this.journalId = journalId;
		this.journalName = journalName;
		this.journalImg = journalImg;
		this.author = author;
		this.journalLevel = journalLevel;
		this.journalJoinTime = journalJoinTime;
		this.publishTime = publishTime;
		this.reelNumber = reelNumber;
		this.issue = issue;
		this.totalIssue = totalIssue;
		this.cn = cn;
		this.isbn = isbn;
		this.issn = issn;
		this.publicationCycle = publicationCycle;
		this.publishingHouse = publishingHouse;
		this.journalHost = journalHost;
		this.isForeign = isForeign;
		this.publishingArea = publishingArea;
		this.jounalLanguage = jounalLanguage;
		this.foreignCodes = foreignCodes;
		this.domesticCode = domesticCode;
		this.format = format;
		this.pageNumber = pageNumber;
		this.isBorrow = isBorrow;
		this.price = price;
		this.description = description;
		this.isDelete = isDelete;
		this.typeId = typeId;
		this.journalType = journalType;
		this.type = type;
		this.journalImages = journalImages;
	}

	public JournalDetailVo() {
		super();
	}

}
