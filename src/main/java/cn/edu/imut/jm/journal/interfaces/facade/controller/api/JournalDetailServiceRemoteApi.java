package cn.edu.imut.jm.journal.interfaces.facade.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.imut.jm.journal.domain.journal.valobj.JournalDetailVo;

@RequestMapping("/journal-detail")
public interface JournalDetailServiceRemoteApi {

	@RequestMapping(value = "/fair-journals", method = RequestMethod.GET)
	List<JournalDetailVo> selectJournals();
}
