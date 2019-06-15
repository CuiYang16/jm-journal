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

	/**
	 * 
	 * @Title: selectBorrows
	 * @Description: 分页条件查询
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalBorrowControllerApi#selectBorrows(java.lang.Integer,
	 *           java.lang.Integer, java.lang.Integer, java.lang.Integer,
	 *           java.lang.Integer)
	 */
	@Override
	public ResponseVo<BorrowManageVo> selectBorrows(@RequestParam("pageNum") Integer pageNum,
			@RequestParam("pageSize") Integer pageSize, @RequestParam("userId") Integer userId,
			@RequestParam("isOverdue") Integer isOverdue, @RequestParam("isPayment") Integer isPayment) {

		return new ResponseVo<>(journalBorrowService.selectBorrows(pageNum, pageSize, userId, isOverdue, isPayment));
	}

	/**
	 * 
	 * @Title: insertBackBorrow
	 * @Description: 后台新增借阅
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalBorrowControllerApi#insertBackBorrow(java.lang.String)
	 */
	@Override
	public ResponseVo insertBackBorrow(@RequestBody String json) {
		Integer userId = JSON.parseObject(json).getInteger("userId");
		Integer journalId = JSON.parseObject(json).getInteger("journalId");
		return new ResponseVo<>(journalBorrowService.insertBackBorrow(userId, journalId));
	}

	/**
	 * 
	 * @Title: selectAllUser
	 * @Description: 查询所有用户信息
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalBorrowControllerApi#selectAllUser()
	 */
	@Override
	public ResponseVo<User> selectAllUser() {

		return new ResponseVo<>(journalBorrowService.selectAllUser());
	}

	/**
	 * 
	 * @Title: selectJournals
	 * @Description: 查询所有杂志期刊
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalBorrowControllerApi#selectJournals()
	 */
	@Override
	public ResponseVo<JournalDetails> selectJournals() {

		return new ResponseVo<>(journalBorrowService.selectJournals());
	}

	/**
	 * 
	 * @Title: updateReturnBorrow
	 * @Description: 归还
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalBorrowControllerApi#updateReturnBorrow(java.lang.String)
	 */
	@Override
	public ResponseVo updateReturnBorrow(@RequestBody String json) {
		Borrow borrow = JSON.toJavaObject(JSON.parseObject(json).getJSONObject("borrow"), Borrow.class);
		Integer isPayment = JSON.parseObject(json).getInteger("isPayment");
		return new ResponseVo<>(journalBorrowService.updateReturnBorrow(borrow, isPayment));
	}

	/**
	 * 
	 * @Title: updateIsPayment
	 * @Description: 支付罚金
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalBorrowControllerApi#updateIsPayment(java.lang.String)
	 */
	@Override
	public ResponseVo updateIsPayment(@RequestBody String json) {
		Integer borrowId = JSON.parseObject(json).getInteger("borrowId");
		return new ResponseVo<>(journalBorrowService.updateIsPayment(borrowId));
	}

	/**
	 * 
	 * @Title: updateBorrowDel
	 * @Description: 去激活
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalBorrowControllerApi#updateBorrowDel(java.lang.String)
	 */
	@Override
	public ResponseVo updateBorrowDel(@RequestBody String json) {
		Integer borrowId = JSON.parseObject(json).getInteger("borrowId");
		return new ResponseVo<>(journalBorrowService.updateBorrowDel(borrowId));
	}

	/**
	 * 
	 * @Title: deleteBorrow
	 * @Description: 彻底删除
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalBorrowControllerApi#deleteBorrow(java.lang.String)
	 */
	@Override
	public ResponseVo deleteBorrow(@RequestBody String json) {
		Integer borrowId = JSON.parseObject(json).getInteger("borrowId");
		return new ResponseVo<>(journalBorrowService.deleteBorrow(borrowId));
	}

	/**
	 * 
	 * @Title: updateMultipleBorrowDel
	 * @Description: 批量去激活
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalBorrowControllerApi#updateMultipleBorrowDel(java.lang.String)
	 */
	@Override
	public ResponseVo updateMultipleBorrowDel(@RequestBody String json) {
		List<Integer> ids = JSON.parseArray(JSON.toJSONString(JSON.parseObject(json).getJSONArray("delIds")),
				Integer.class);
		return new ResponseVo<>(journalBorrowService.updateMultipleBorrowDel(ids));
	}

	/**
	 * 
	 * @Title: deleteMultipleBorrow
	 * @Description: 批量删除
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalBorrowControllerApi#deleteMultipleBorrow(java.lang.String)
	 */
	@Override
	public ResponseVo deleteMultipleBorrow(@RequestBody String json) {
		List<Integer> ids = JSON.parseArray(JSON.toJSONString(JSON.parseObject(json).getJSONArray("delIds")),
				Integer.class);
		return new ResponseVo<>(journalBorrowService.deleteMultipleBorrow(ids));
	}

	/**
	 *
	 * @Title: borrowCount
	 * @Description: 在借数量
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalBorrowControllerApi#borrowCount()
	 */
	@Override
	public ResponseVo borrowCount() {

		return new ResponseVo<>(journalBorrowService.borrowCount());
	}

//	前端请求
	/**
	 * 
	 * @Title: userBorrowJournal
	 * @Description: 门户借阅
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalBorrowControllerApi#userBorrowJournal(java.lang.String)
	 */
	@Override
	public Integer userBorrowJournal(@RequestBody String json) {
		String token = JSON.parseObject(json).getString("token");
		Integer journalId = JSON.parseObject(json).getInteger("journalId");
		Integer userId = JwtTokenUtil.getUserId(token);
		return journalBorrowService.insertBorrow(userId, journalId);
	}

	/**
	 * 
	 * @Title: selectByUserId
	 * @Description: 根据用户id查询借阅信息
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalBorrowControllerApi#selectByUserId(java.lang.String,
	 *           java.lang.Integer, java.lang.Integer, java.lang.Integer,
	 *           java.lang.Integer)
	 */
	@Override
	public PageInfo<BorrowVo> selectByUserId(@RequestParam("token") String token,
			@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize,
			@RequestParam("isOverdue") Integer isOverdue, @RequestParam("isPayment") Integer isPayment) {
		Integer userId = JwtTokenUtil.getUserId(token);
		return journalBorrowService.selectByUserId(userId, currentPage, pageSize, isOverdue, isPayment);
	}

	/**
	 * 
	 * @Title: delBorrowDoor
	 * @Description: 门户删除借阅记录，去激活
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalBorrowControllerApi#delBorrowDoor(java.lang.String)
	 */
	@Override
	public Integer delBorrowDoor(@RequestBody String json) {
		Integer borrowId = JSON.parseObject(json).getInteger("borrowId");
		return journalBorrowService.updateBorrowDel(borrowId);
	}

}
