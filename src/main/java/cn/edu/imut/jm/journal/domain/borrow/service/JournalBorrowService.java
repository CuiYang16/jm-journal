package cn.edu.imut.jm.journal.domain.borrow.service;

import java.util.List;

import cn.edu.imut.jm.journal.domain.borrow.valobj.BorrowVo;

public interface JournalBorrowService {

//	前端请求
	Integer insertBorrow(Integer userId, Integer journalId);

	List<BorrowVo> selectByUserId(Integer userId);
}
