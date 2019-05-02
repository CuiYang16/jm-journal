package cn.edu.imut.jm.journal.domain.borrow.service;

import com.github.pagehelper.PageInfo;

import cn.edu.imut.jm.journal.domain.borrow.valobj.BorrowVo;

public interface JournalBorrowService {

//	前端请求
	Integer insertBorrow(Integer userId, Integer journalId);

	PageInfo<BorrowVo> selectByUserId(Integer userId, Integer currentPage, Integer pageSize, Integer isOverdue,
			Integer isPayment);
}
