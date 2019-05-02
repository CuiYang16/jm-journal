package cn.edu.imut.jm.journal.interfaces.facade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import cn.edu.imut.jm.journal.domain.borrow.service.JournalBorrowService;
import cn.edu.imut.jm.journal.domain.borrow.valobj.BorrowVo;
import cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalBorrowControllerApi;

@RestController
public class JournalBorrowController implements JournalBorrowControllerApi {

	@Autowired
	private JournalBorrowService journalBorrowService;

//	前端请求
	@Override
	public Integer userBorrowJournal(@RequestBody String json) {
		Integer userId = JSON.parseObject(json).getInteger("userId");
		Integer journalId = JSON.parseObject(json).getInteger("journalId");
		return journalBorrowService.insertBorrow(userId, journalId);
	}

	@Override
	public PageInfo<BorrowVo> selectByUserId(@RequestParam("userId") Integer userId,
			@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize,
			@RequestParam("isOverdue") Integer isOverdue, @RequestParam("isPayment") Integer isPayment) {

		return journalBorrowService.selectByUserId(userId, currentPage, pageSize, isOverdue, isPayment);
	}

}
