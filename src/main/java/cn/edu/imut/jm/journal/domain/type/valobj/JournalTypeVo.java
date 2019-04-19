package cn.edu.imut.jm.journal.domain.type.valobj;

import java.util.List;

public class JournalTypeVo {

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

	private Integer parentId;

	private List<JournalTypeVo> children;

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
		this.typeName = typeName;
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
		this.typeDescribe = typeDescribe;
	}

	public List<JournalTypeVo> getChildren() {
		return children;
	}

	public void setChildren(List<JournalTypeVo> children) {
		this.children = children;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public JournalTypeVo(Integer typeId, String typeName, Integer typeLevel, Integer typeIndex, String typeDescribe,
			Integer parentId, List<JournalTypeVo> children) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeLevel = typeLevel;
		this.typeIndex = typeIndex;
		this.typeDescribe = typeDescribe;
		this.parentId = parentId;
		this.children = children;
	}

	public JournalTypeVo() {
		super();
	}

}
