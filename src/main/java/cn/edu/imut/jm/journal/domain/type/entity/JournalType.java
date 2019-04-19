package cn.edu.imut.jm.journal.domain.type.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class JournalType {
	/**
	 * 资料类别表(三级)
	 */
	private Integer typeId;

	/**
	 * 资料类别名
	 */
	private String typeName;

	/**
	 * 类别级别
	 */
	private Integer typeLevel;

	/**
	 * 排序索引
	 */
	private Integer typeIndex;

	/**
	 * 类别描述
	 */
	private String typeDescribe;

	/**
	 * 
	 */
	private Integer parentId;

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName == null ? null : typeName.trim();
	}

	public Integer getTypeLevel() {
		return typeLevel;
	}

	public void setTypeLevel(Integer typeLevel) {
		this.typeLevel = typeLevel;
	}

	public Integer getTypeIndex() {
		return typeIndex;
	}

	public void setTypeIndex(Integer typeIndex) {
		this.typeIndex = typeIndex;
	}

	public String getTypeDescribe() {
		return typeDescribe;
	}

	public void setTypeDescribe(String typeDescribe) {
		this.typeDescribe = typeDescribe == null ? null : typeDescribe.trim();
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}