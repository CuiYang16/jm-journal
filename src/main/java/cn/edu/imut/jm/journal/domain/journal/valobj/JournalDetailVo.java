package cn.edu.imut.jm.journal.domain.journal.valobj;

import java.util.List;

import cn.edu.imut.jm.journal.domain.journal.entity.JournalDetails;
import cn.edu.imut.jm.journal.domain.journal.entity.JournalImages;
import cn.edu.imut.jm.journal.domain.type.entity.JournalType;

public class JournalDetailVo extends JournalDetails {

	private JournalType type;

	private List<JournalImages> journalImages;

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

	public JournalDetailVo() {
		super();
	}

}
