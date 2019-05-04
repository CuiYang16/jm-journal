package cn.edu.imut.jm.journal.domain.borrow.valobj;

import cn.edu.imut.jm.journal.domain.borrow.entity.Borrow;
import cn.edu.imut.jm.journal.domain.journal.entity.JournalDetails;

public class BorrowManageVo extends Borrow {
	private JournalDetails journalDetails;
	private User user;

	public JournalDetails getJournalDetails() {
		return journalDetails;
	}

	public void setJournalDetails(JournalDetails journalDetails) {
		this.journalDetails = journalDetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
