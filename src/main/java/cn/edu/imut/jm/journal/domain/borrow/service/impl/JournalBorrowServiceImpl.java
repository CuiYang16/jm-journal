package cn.edu.imut.jm.journal.domain.borrow.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.imut.jm.journal.domain.borrow.dao.JournalBorrowDao;
import cn.edu.imut.jm.journal.domain.borrow.entity.Borrow;
import cn.edu.imut.jm.journal.domain.borrow.service.JournalBorrowService;
import cn.edu.imut.jm.journal.domain.borrow.valobj.BorrowManageVo;
import cn.edu.imut.jm.journal.domain.borrow.valobj.BorrowVo;
import cn.edu.imut.jm.journal.domain.borrow.valobj.User;
import cn.edu.imut.jm.journal.domain.journal.entity.JournalDetails;

@Service
public class JournalBorrowServiceImpl implements JournalBorrowService {

	@Autowired
	private JournalBorrowDao journalBorrowDao;

	@Override
	public PageInfo<BorrowManageVo> selectBorrows(Integer pageNum, Integer pageSize, Integer userId, Integer isOverdue,
			Integer isPayment) {
		PageHelper.startPage(pageNum, pageSize);
		List<BorrowManageVo> selectBorrows = journalBorrowDao.selectBorrows(userId, isOverdue, isPayment);
		PageInfo<BorrowManageVo> pageInfo = new PageInfo<BorrowManageVo>(selectBorrows);
		pageInfo.setPageNum(pageNum);
		pageInfo.setPageSize(pageSize);
		return pageInfo;
	}

	@Override
	public Integer insertBackBorrow(Integer userId, Integer journalId) {
		if (userId != null && journalId != null && userId != 0 && journalId != 0) {
			Borrow overdue = journalBorrowDao.selecrtOverdue(userId);
			if (overdue != null && overdue.getBorrowId() != null && overdue.getBorrowId() != 0) {
				return 50008;
			}
			List<Borrow> notReturn = journalBorrowDao.selectNotReturn(userId);
			if (notReturn.size() >= 10) {
				return 50010;
			}
			Borrow borrow = new Borrow();
			borrow.setUserId(userId);
			borrow.setJournalId(journalId);
			borrow.setBorrowTime(new Date());
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, +2);
			borrow.setReturnTime(c.getTime());
			Integer insertBorrow = journalBorrowDao.insertBorrow(borrow);
			if (insertBorrow == 1) {
				journalBorrowDao.updateInventory(journalId);
			}
			return insertBorrow;
		}
		return null;
	}

	@Override
	public List<User> selectAllUser() {

		return journalBorrowDao.selectAllUser();
	}

	@Override
	public List<JournalDetails> selectJournals() {

		return journalBorrowDao.selectJournals();
	}

	@Override
	public Integer updateReturnBorrow(Borrow borrow, Integer isPayment) {
		borrow.setRealityReturn(new Date());
		borrow.setRealityDays((int) (new Date().getTime() - borrow.getBorrowTime().getTime()) / (24 * 3600 * 1000));
		borrow.setIsOverdue(new Date().getTime() > borrow.getReturnTime().getTime() ? true : false);

		if (borrow.getIsOverdue()) {
			borrow.setOverdueDays((int) (new Date().getTime() - borrow.getReturnTime().getTime()) / (24 * 3600 * 1000));
			borrow.setPenalty(new BigDecimal(
					((int) (new Date().getTime() - borrow.getReturnTime().getTime()) / (24 * 3600 * 1000) * 0.5)));
			borrow.setIsPayment(isPayment == 1 ? true : false);
		}
		return journalBorrowDao.updateReturnBorrow(borrow);
	}

	@Override
	public Integer updateIsPayment(Integer borrowId) {
		if (borrowId != null && borrowId != null) {
			return journalBorrowDao.updateIsPayment(borrowId);
		}
		return null;
	}

	@Override
	public Integer updateBorrowDel(Integer borrowId) {
		if (borrowId != null && borrowId != 0) {
			return journalBorrowDao.updateBorrowDel(borrowId);
		}
		return null;
	}

	@Override
	public Integer deleteBorrow(Integer borrowId) {
		if (borrowId != null && borrowId != 0) {
			return journalBorrowDao.deleteBorrow(borrowId);
		}
		return null;
	}

	@Override
	public Integer updateMultipleBorrowDel(List<Integer> ids) {
		if (ids != null && ids.size() > 0) {
			return journalBorrowDao.updateMultipleBorrowDel(ids);
		}
		return null;
	}

	@Override
	public Integer deleteMultipleBorrow(List<Integer> ids) {
		if (ids != null && ids.size() > 0) {
			return journalBorrowDao.deleteMultipleBorrow(ids);
		}
		return null;
	}

//	前端请求
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer insertBorrow(Integer userId, Integer journalId) {
		if (userId != null && journalId != null && userId != 0 && journalId != 0) {
			Borrow overdue = journalBorrowDao.selecrtOverdue(userId);
			if (overdue != null && overdue.getBorrowId() != null && overdue.getBorrowId() != 0) {
				return 50008;
			}

			List<Borrow> notReturn = journalBorrowDao.selectNotReturn(userId);
			if (notReturn.size() >= 10) {
				return 50010;
			}
			Borrow borrow = new Borrow();
			borrow.setUserId(userId);
			borrow.setJournalId(journalId);
			borrow.setBorrowTime(new Date());
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, +2);
			borrow.setReturnTime(c.getTime());
			Integer insertBorrow = journalBorrowDao.insertBorrow(borrow);
			if (insertBorrow == 1) {
				journalBorrowDao.updateInventory(journalId);
			}
			return insertBorrow;
		}
		return null;
	}

	@Override
	public PageInfo<BorrowVo> selectByUserId(Integer userId, Integer currentPage, Integer pageSize, Integer isOverdue,
			Integer isPayment) {
		if (userId != null && userId != 0 && currentPage != null && currentPage != 0 && pageSize != null
				&& pageSize != 0) {
			PageHelper.startPage(currentPage, pageSize);
			List<BorrowVo> selectByUserId = journalBorrowDao.selectByUserId(userId, isOverdue, isPayment);
			PageInfo<BorrowVo> pageInfo = new PageInfo<BorrowVo>(selectByUserId);
			pageInfo.setPageNum(currentPage);
			pageInfo.setPageSize(pageSize);
			return pageInfo;
		}
		return null;
	}

}
