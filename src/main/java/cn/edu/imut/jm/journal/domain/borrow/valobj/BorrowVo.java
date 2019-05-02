package cn.edu.imut.jm.journal.domain.borrow.valobj;

import cn.edu.imut.jm.journal.domain.borrow.entity.Borrow;
import cn.edu.imut.jm.journal.domain.journal.entity.JournalDetails;

public class BorrowVo extends Borrow {

	private JournalDetails journalDetails;

	public JournalDetails getJournalDetails() {
		return journalDetails;
	}

	public void setJournalDetails(JournalDetails journalDetails) {
		this.journalDetails = journalDetails;
	}

	public BorrowVo() {
		super();
	}

}
