package cn.edu.imut.infrastructrue.util;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.edu.imut.jm.journal.domain.journal.valobj.JournalDetailVo;
import cn.edu.imut.jm.journal.domain.type.entity.JournalType;

public class ResponseVo<E> extends AbstractResponse {

	private List<E> list;
	private Integer val;
	private JournalType journalType;
	private JournalDetailVo journalDetailVo;
	private String str;
	private PageInfo<E> pageInfo;

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public Integer getVal() {
		return val;
	}

	public void setVal(Integer val) {
		this.val = val;
	}

	public JournalType getJournalType() {
		return journalType;
	}

	public void setJournalType(JournalType journalType) {
		this.journalType = journalType;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public JournalDetailVo getJournalDetailVo() {
		return journalDetailVo;
	}

	public void setJournalDetailVO(JournalDetailVo journalDetailVo) {
		this.journalDetailVo = journalDetailVo;
	}

	public PageInfo<E> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<E> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public void setJournalDetailVo(JournalDetailVo journalDetailVo) {
		this.journalDetailVo = journalDetailVo;
	}

	public ResponseVo(List<E> list, Integer val) {
		super();
		this.list = list;
		this.val = val;
	}

	public ResponseVo(List<E> list) {
		super();
		this.list = list;
	}

	public ResponseVo(Integer val) {
		super();
		this.val = val;
	}

	public ResponseVo(JournalType journalType) {
		super();
		this.journalType = journalType;
	}

	public ResponseVo(String str) {
		super();
		this.str = str;
	}

	public ResponseVo(Integer val, String str) {
		super();
		this.val = val;
		this.str = str;
	}

	public ResponseVo(Integer val, JournalDetailVo journalDetailVo, String str) {
		super();
		this.val = val;
		this.journalDetailVo = journalDetailVo;
		this.str = str;
	}

	public ResponseVo(PageInfo<E> pageInfo) {
		super();
		this.pageInfo = pageInfo;
	}

	public ResponseVo() {
		super();
	}

}
