package cn.edu.imut.jm.journal.interfaces.facade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.imut.jm.journal.domain.journal.service.JournalDetailService;
import cn.edu.imut.jm.journal.domain.journal.valobj.JournalDetailVo;
import cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailServiceRemoteApi;

@RestController
public class JournalDetailServiceRemote implements JournalDetailServiceRemoteApi {

	@Autowired
	private JournalDetailService journalDetailService;

	@Override
	public List<JournalDetailVo> selectJournals() {

		return journalDetailService.selectJournals();
	}

}
