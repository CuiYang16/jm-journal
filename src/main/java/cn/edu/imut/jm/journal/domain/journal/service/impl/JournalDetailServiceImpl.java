package cn.edu.imut.jm.journal.domain.journal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.imut.jm.journal.domain.journal.dao.JournalDetailDao;
import cn.edu.imut.jm.journal.domain.journal.entity.JournalDetails;
import cn.edu.imut.jm.journal.domain.journal.entity.JournalImages;
import cn.edu.imut.jm.journal.domain.journal.service.JournalDetailService;
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
	public Integer delImgs(Integer journalId) {
		if (journalId != null && journalId != 0) {
			return journalDetailDao.delImgs(journalId);
		}
		return null;
	}

	@Override
//	假删除
	public Integer delJournalDetail(Integer journalId) {
		if (journalId != null && journalId != 0) {
			return journalDetailDao.updateJournalDetailDel(journalId);
		}
		return null;
	}

//假删
	@Override
	public Integer updateMultipleJournalDetailDel(List<Integer> ids) {
		if (ids != null && ids.size() > 0) {
			return journalDetailDao.updateMultipleJournalDetailDel(ids);
		}
		return null;
	}

//真删
	@Override
	public Integer deleteJournal(Integer journalId) {
		if (journalId != null && journalId != 0) {
			return journalDetailDao.deleteJournal(journalId);
		}
		return null;
	}

	// 真删
	@Override
	public Integer deleteMultipleJournal(List<Integer> ids) {
		if (ids != null && ids.size() > 0) {
			return journalDetailDao.deleteMultipleJournal(ids);
		}
		return null;
	}

	@Override
	public List<JournalDetailVo> selectJournals() {

		return journalDetailDao.selectJournals();
	}

//	前端请求
	@Override
	public List<JournalDetailVo> getJournalDetails() {

		return journalDetailDao.getJournalDetails();
	}

}
