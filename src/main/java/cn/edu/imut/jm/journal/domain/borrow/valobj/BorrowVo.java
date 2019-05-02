package cn.edu.imut.jm.journal.domain.borrow.valobj;

import cn.edu.imut.jm.journal.domain.borrow.entity.Borrow;
import cn.edu.imut.jm.journal.domain.journal.valobj.JournalDetailVo;

public class BorrowVo extends Borrow {

	private JournalDetailVo journalDetailVo;

	public JournalDetailVo getJournalDetailVo() {
		return journalDetailVo;
	}

	public void setJournalDetailVo(JournalDetailVo journalDetailVo) {
		this.journalDetailVo = journalDetailVo;
	}

	public BorrowVo(JournalDetailVo journalDetailVo) {
		super();
		this.journalDetailVo = journalDetailVo;
	}

	public BorrowVo() {
		super();
	}

}
