package cn.edu.imut.jm.journal.domain.borrow.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.edu.imut.jm.journal.domain.borrow.entity.Borrow;
import cn.edu.imut.jm.journal.domain.borrow.valobj.BorrowManageVo;
import cn.edu.imut.jm.journal.domain.borrow.valobj.BorrowVo;
import cn.edu.imut.jm.journal.domain.borrow.valobj.User;
import cn.edu.imut.jm.journal.domain.journal.entity.JournalDetails;

public interface JournalBorrowService {

	PageInfo<BorrowManageVo> selectBorrows(Integer pageNum, Integer pageSize, Integer userId, Integer isOverdue,
			Integer isPayment);

	Integer insertBackBorrow(Integer userId, Integer journalId);

	List<User> selectAllUser();

	List<JournalDetails> selectJournals();

	Integer updateReturnBorrow(Borrow borrow, Integer isPayment);

	Integer updateIsPayment(Integer borrowId);

	Integer updateBorrowDel(Integer borrowId);

	Integer deleteBorrow(Integer borrowId);

	Integer updateMultipleBorrowDel(List<Integer> ids);

	Integer deleteMultipleBorrow(List<Integer> ids);

//	前端请求
	Integer insertBorrow(Integer userId, Integer journalId);

	PageInfo<BorrowVo> selectByUserId(Integer userId, Integer currentPage, Integer pageSize, Integer isOverdue,
			Integer isPayment);
}
