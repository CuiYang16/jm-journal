package cn.edu.imut.jm.journal.interfaces.facade.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.imut.jm.journal.domain.borrow.valobj.BorrowVo;

@RequestMapping("/journal-borrow")
public interface JournalBorrowControllerApi {

//	前端请求
	@RequestMapping(value = "/borrow-journal", method = RequestMethod.POST)
	Integer userBorrowJournal(@RequestBody String json);

	@RequestMapping(value = "/get-borrow", method = RequestMethod.GET)
	List<BorrowVo> selectByUserId(@RequestParam("userId") Integer userId);
}
