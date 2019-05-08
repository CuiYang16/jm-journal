package cn.edu.imut.jm.journal.interfaces.facade.controller.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.edu.imut.infrastructrue.util.ResponseVo;
import cn.edu.imut.jm.journal.domain.borrow.valobj.BorrowVo;
import cn.edu.imut.jm.journal.domain.borrow.valobj.User;
import cn.edu.imut.jm.journal.domain.journal.entity.JournalDetails;

@RequestMapping("/journal-borrow")
public interface JournalBorrowControllerApi {

	@RequestMapping(value = "/get-borrows", method = RequestMethod.GET)
	ResponseVo selectBorrows(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize,
			@RequestParam("userId") Integer userId, @RequestParam("isOverdue") Integer isOverdue,
			@RequestParam("isPayment") Integer isPayment);

	@RequestMapping(value = "/back-borrow", method = RequestMethod.POST)
	ResponseVo insertBackBorrow(@RequestBody String json);

	@RequestMapping(value = "/get-users", method = RequestMethod.GET)
	ResponseVo<User> selectAllUser();

	@RequestMapping(value = "/get-journals", method = RequestMethod.GET)
	ResponseVo<JournalDetails> selectJournals();

	@RequestMapping(value = "/return-journal", method = RequestMethod.PUT)
	ResponseVo updateReturnBorrow(@RequestBody String json);

	@RequestMapping(value = "/payment", method = RequestMethod.PUT)
	ResponseVo updateIsPayment(@RequestBody String json);

	@RequestMapping(value = "/del-update", method = RequestMethod.PUT)
	ResponseVo updateBorrowDel(@RequestBody String json);

	@RequestMapping(value = "/del-borrow", method = RequestMethod.DELETE)
	ResponseVo deleteBorrow(@RequestBody String json);

	@RequestMapping(value = "/del-update-mul", method = RequestMethod.PUT)
	ResponseVo updateMultipleBorrowDel(@RequestBody String json);

	@RequestMapping(value = "/del-borrow-mul", method = RequestMethod.DELETE)
	ResponseVo deleteMultipleBorrow(@RequestBody String json);

//	前端请求
	@RequestMapping(value = "/borrow-journal", method = RequestMethod.POST)
	Integer userBorrowJournal(@RequestBody String json);

	@RequestMapping(value = "/get-borrow", method = RequestMethod.GET)
	PageInfo<BorrowVo> selectByUserId(@RequestParam("token") String token,
			@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize,
			@RequestParam("isOverdue") Integer isOverdue, @RequestParam("isPayment") Integer isPayment);

	@RequestMapping(value = "/del-borrow-door", method = RequestMethod.PUT)
	Integer delBorrowDoor(@RequestBody String json);

}
