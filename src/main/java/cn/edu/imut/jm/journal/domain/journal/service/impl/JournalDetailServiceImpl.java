package cn.edu.imut.jm.journal.domain.journal.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.imut.jm.journal.domain.journal.dao.JournalDetailDao;
import cn.edu.imut.jm.journal.domain.journal.entity.JournalDetails;
import cn.edu.imut.jm.journal.domain.journal.entity.JournalImages;
import cn.edu.imut.jm.journal.domain.journal.service.JournalDetailService;
import cn.edu.imut.jm.journal.domain.journal.valobj.CheckValue;
import cn.edu.imut.jm.journal.domain.journal.valobj.JournalBorrowVo;
import cn.edu.imut.jm.journal.domain.journal.valobj.JournalDetailVo;

@Service
public class JournalDetailServiceImpl implements JournalDetailService {

	@Autowired
	private JournalDetailDao journalDetailDao;

	@Override
	public PageInfo<JournalDetailVo> selectJournalDetails(Integer pageNum, Integer pageSize, Integer isBorrow,
			Integer isDelete) {
		PageHelper.startPage(pageNum, pageSize);
		List<JournalDetailVo> journalDetails = journalDetailDao.selectJournalDetails(isBorrow, isDelete);
		PageInfo<JournalDetailVo> pageInfo = new PageInfo<JournalDetailVo>(journalDetails);
		pageInfo.setPageNum(pageNum);
		pageInfo.setPageSize(pageSize);
		return pageInfo;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer updateJournalImage(Integer journalId, String journalImg) {
		if (journalId != null && journalId != 0 && journalImg != null && journalImg.length() > 0) {
			return journalDetailDao.updateJournalImage(journalId, journalImg);
		}
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer insertJournalDetail(JournalDetails journalDetails) {
		if (journalDetails != null) {
			return journalDetailDao.insertJournalDetail(journalDetails);
		}
		return null;
	}

	@Override
	public JournalDetailVo selectJouanalById(Integer journalId) {
		if (journalId != null && journalId != 0) {
			return journalDetailDao.selectJouanalById(journalId);
		}
		return null;
	}

	@Override
	public String getImgUrl(Integer journalId) {
		if (journalId != null && journalId != 0) {
			return journalDetailDao.getImgUrl(journalId);
		}
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer insertJouranlImgs(JournalImages journalImage) {
		if (journalImage != null) {
			return journalDetailDao.insertJouranlImgs(journalImage);
		}
		return null;
	}

	@Override
	public List<JournalImages> getImages(Integer journalId) {
		if (journalId != null && journalId != 0) {
			return journalDetailDao.getImages(journalId);
		}
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer updateJournalDetail(JournalDetails journalDetails) {
		if (journalDetails != null) {
			return journalDetailDao.updateJournalDetail(journalDetails);
		}
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer delImgs(Integer journalId) {
		if (journalId != null && journalId != 0) {
			return journalDetailDao.delImgs(journalId);
		}
		return null;
	}

	@Override
//	假删除
	@Transactional(rollbackFor = Exception.class)
	public Integer delJournalDetail(Integer journalId) {
		if (journalId != null && journalId != 0) {
			return journalDetailDao.updateJournalDetailDel(journalId);
		}
		return null;
	}

//假删
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer updateMultipleJournalDetailDel(List<Integer> ids) {
		if (ids != null && ids.size() > 0) {
			return journalDetailDao.updateMultipleJournalDetailDel(ids);
		}
		return null;
	}

//真删
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer deleteJournal(Integer journalId) {
		Integer deleteJournal = null;
		try {
			if (journalId != null && journalId != 0) {
				deleteJournal = journalDetailDao.deleteJournal(journalId);
			}
		} catch (Exception e) {
			return -1;
		}

		return deleteJournal;
	}

	// 真删
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer deleteMultipleJournal(List<Integer> ids) {

		Integer deleteMultipleJournal = null;
		try {
			if (ids != null && ids.size() > 0) {
				deleteMultipleJournal = journalDetailDao.deleteMultipleJournal(ids);
			}
		} catch (Exception e) {
			return -1;
		}

		return deleteMultipleJournal;
	}

	@Override
	public List<JournalDetailVo> selectJournals() {

		return journalDetailDao.selectJournals();
	}

	@Override
	public String journalChart() {
		Integer journalCount = journalDetailDao.journalCount();
		Integer okJournalCount = journalDetailDao.okJournalCount();
		return journalCount + "," + okJournalCount;
	};

//	前端请求
	@Override
	public List<JournalDetailVo> getJournalDetails() {

		return journalDetailDao.getJournalDetails();
	}

	@Override
	public PageInfo<JournalDetailVo> getJournalDetailByCheck(CheckValue checkValue, Integer currentPage,
			Integer pageSize, Integer dateSort) {

		if (checkValue != null) {
			if (checkValue.getTime() != null) {
				Calendar cl = Calendar.getInstance();
				Calendar cl2 = Calendar.getInstance();
				switch (checkValue.getTime()) {
				case 1:
					cl.add(Calendar.MONTH, -1);
					checkValue.setEndTime(cl.getTime());
					checkValue.setStartTime(null);
					break;

				case 2:
					cl.add(Calendar.MONTH, -3);
					checkValue.setEndTime(cl.getTime());
					cl2.add(Calendar.MONTH, -1);
					checkValue.setStartTime(cl2.getTime());
					break;
				case 3:
					cl.add(Calendar.MONTH, -6);
					checkValue.setEndTime(cl.getTime());
					cl2.add(Calendar.MONTH, -3);
					checkValue.setStartTime(cl2.getTime());
					break;
				case 4:
					cl.add(Calendar.MONTH, -9);
					checkValue.setEndTime(cl.getTime());
					cl2.add(Calendar.MONTH, -6);
					checkValue.setStartTime(cl2.getTime());
					break;
				case 5:
					checkValue.setEndTime(null);
					cl2.add(Calendar.YEAR, -1);
					checkValue.setStartTime(cl2.getTime());
					break;
				default:
					checkValue.setEndTime(null);
					checkValue.setStartTime(null);
					break;
				}
			}
//			String searchType = StringUtils.subString(searchValue, null, "-*-");
//			String typeValue = StringUtils.subString(searchValue, "-*-", null);

			PageHelper.startPage(currentPage, pageSize);
			List<JournalDetailVo> journalDetailByCheck = journalDetailDao.getJournalDetailByCheck(checkValue, dateSort);
			PageInfo<JournalDetailVo> pageInfo = new PageInfo<JournalDetailVo>(journalDetailByCheck);
			pageInfo.setPageNum(currentPage);
			pageInfo.setPageSize(pageSize);

			return pageInfo;
		}
		return null;
	}

	@Override
	public PageInfo<JournalDetailVo> getJournalDetailBySearch(Integer currentPage, Integer pageSize, String searchValue,
			Integer dateSort) {
		String searchType = StringUtils.subString(searchValue, null, "-*-");
		String typeValue = StringUtils.subString(searchValue, "-*-", null);
		PageHelper.startPage(currentPage, pageSize);
		List<JournalDetailVo> journalDetailByCheck = journalDetailDao.getJournalDetailBySearch(searchType, typeValue,
				dateSort);
		PageInfo<JournalDetailVo> pageInfo = new PageInfo<JournalDetailVo>(journalDetailByCheck);
		pageInfo.setPageNum(currentPage);
		pageInfo.setPageSize(pageSize);
		return pageInfo;
	}

	@Override
	public List<JournalBorrowVo> getBorrowList() {
		return journalDetailDao.getBorrowList();
	}

}
