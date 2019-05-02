package cn.edu.imut.jm.journal.domain.borrow.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.imut.jm.journal.domain.borrow.dao.JournalBorrowDao;
import cn.edu.imut.jm.journal.domain.borrow.entity.Borrow;
import cn.edu.imut.jm.journal.domain.borrow.service.JournalBorrowService;
import cn.edu.imut.jm.journal.domain.borrow.valobj.BorrowVo;

@Service
public class JournalBorrowServiceImpl implements JournalBorrowService {

	@Autowired
	private JournalBorrowDao journalBorrowDao;

//	前端请求
	@Override
	public Integer insertBorrow(Integer userId, Integer journalId) {
		Borrow borrow = new Borrow();
		borrow.setUserId(userId);
		borrow.setJournalId(journalId);
		borrow.setBorrowTime(new Date());
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, +2);
		borrow.setReturnTime(c.getTime());
		return journalBorrowDao.insertBorrow(borrow);
	}

	@Override
	public List<BorrowVo> selectByUserId(Integer userId) {
		if (userId != null && userId != 0) {
			return journalBorrowDao.selectByUserId(userId);
		}
		return null;
	}

}
