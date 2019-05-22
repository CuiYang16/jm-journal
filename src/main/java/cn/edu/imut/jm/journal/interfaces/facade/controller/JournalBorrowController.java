package cn.edu.imut.jm.journal.interfaces.facade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import cn.edu.imut.infrastructrue.util.JwtTokenUtil;
import cn.edu.imut.infrastructrue.util.ResponseVo;
import cn.edu.imut.jm.journal.domain.borrow.entity.Borrow;
import cn.edu.imut.jm.journal.domain.borrow.service.JournalBorrowService;
import cn.edu.imut.jm.journal.domain.borrow.valobj.BorrowManageVo;
import cn.edu.imut.jm.journal.domain.borrow.valobj.BorrowVo;
import cn.edu.imut.jm.journal.domain.borrow.valobj.User;
import cn.edu.imut.jm.journal.domain.journal.entity.JournalDetails;
import cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalBorrowControllerApi;

@RestController
public class JournalBorrowController implements JournalBorrowControllerApi {

	@Autowired
	private JournalBorrowService journalBorrowService;

	@Override
	public ResponseVo<BorrowManageVo> selectBorrows(@RequestParam("pageNum") Integer pageNum,
			@RequestParam("pageSize") Integer pageSize, @RequestParam("userId") Integer userId,
			@RequestParam("isOverdue") Integer isOverdue, @RequestParam("isPayment") Integer isPayment) {

		return new ResponseVo<>(journalBorrowService.selectBorrows(pageNum, pageSize, userId, isOverdue, isPayment));
	}

	@Override
	public ResponseVo insertBackBorrow(@RequestBody String json) {
		Integer userId = JSON.parseObject(json).getInteger("userId");
		Integer journalId = JSON.parseObject(json).getInteger("journalId");
		return new ResponseVo<>(journalBorrowService.insertBackBorrow(userId, journalId));
	}

	@Override
	public ResponseVo<User> selectAllUser() {

		return new ResponseVo<>(journalBorrowService.selectAllUser());
	}

	@Override
	public ResponseVo<JournalDetails> selectJournals() {

		return new ResponseVo<>(journalBorrowService.selectJournals());
	}

	@Override
	public ResponseVo updateReturnBorrow(@RequestBody String json) {
		Borrow borrow = JSON.toJavaObject(JSON.parseObject(json).getJSONObject("borrow"), Borrow.class);
		Integer isPayment = JSON.parseObject(json).getInteger("isPayment");
		return new ResponseVo<>(journalBorrowService.updateReturnBorrow(borrow, isPayment));
	}

	@Override
	public ResponseVo updateIsPayment(@RequestBody String json) {
		Integer borrowId = JSON.parseObject(json).getInteger("borrowId");
		return new ResponseVo<>(journalBorrowService.updateIsPayment(borrowId));
	}

	@Override
	public ResponseVo updateBorrowDel(@RequestBody String json) {
		Integer borrowId = JSON.parseObject(json).getInteger("borrowId");
		return new ResponseVo<>(journalBorrowService.updateBorrowDel(borrowId));
	}

	@Override
	public ResponseVo deleteBorrow(@RequestBody String json) {
		Integer borrowId = JSON.parseObject(json).getInteger("borrowId");
		return new ResponseVo<>(journalBorrowService.deleteBorrow(borrowId));
	}

	@Override
	public ResponseVo updateMultipleBorrowDel(@RequestBody String json) {
		List<Integer> ids = JSON.parseArray(JSON.toJSONString(JSON.parseObject(json).getJSONArray("delIds")),
				Integer.class);
		return new ResponseVo<>(journalBorrowService.updateMultipleBorrowDel(ids));
	}

	@Override
	public ResponseVo deleteMultipleBorrow(@RequestBody String json) {
		List<Integer> ids = JSON.parseArray(JSON.toJSONString(JSON.parseObject(json).getJSONArray("delIds")),
				Integer.class);
		return new ResponseVo<>(journalBorrowService.deleteMultipleBorrow(ids));
	}

	@Override
	public ResponseVo borrowCount() {

		return new ResponseVo<>(journalBorrowService.borrowCount());
	}

//	前端请求
	@Override
	public Integer userBorrowJournal(@RequestBody String json) {
		String token = JSON.parseObject(json).getString("token");
		Integer journalId = JSON.parseObject(json).getInteger("journalId");
		Integer userId = JwtTokenUtil.getUserId(token);
		return journalBorrowService.insertBorrow(userId, journalId);
	}

	@Override
	public PageInfo<BorrowVo> selectByUserId(@RequestParam("token") String token,
			@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize,
			@RequestParam("isOverdue") Integer isOverdue, @RequestParam("isPayment") Integer isPayment) {
		Integer userId = JwtTokenUtil.getUserId(token);
		return journalBorrowService.selectByUserId(userId, currentPage, pageSize, isOverdue, isPayment);
	}

	@Override
	public Integer delBorrowDoor(@RequestBody String json) {
		Integer borrowId = JSON.parseObject(json).getInteger("borrowId");
		return journalBorrowService.updateBorrowDel(borrowId);
	}

}
