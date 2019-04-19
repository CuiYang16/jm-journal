package cn.edu.imut.jm.journal.domain.journal.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.edu.imut.jm.journal.domain.journal.entity.JournalDetails;
import cn.edu.imut.jm.journal.domain.journal.entity.JournalImages;
import cn.edu.imut.jm.journal.domain.journal.valobj.JournalDetailVo;

public interface JournalDetailService {

	PageInfo<JournalDetailVo> selectJournalDetails(Integer pageNum, Integer pageSize);

	JournalDetailVo selectJouanalById(Integer journalId);

	Integer updateJournalImage(Integer journalId, String journalImg);

	Integer insertJournalDetail(JournalDetails journalDetails);

	String getImgUrl(Integer journalId);

	Integer insertJouranlImgs(JournalImages journalImage);

	List<JournalImages> getImages(Integer journalId);

	Integer updateJournalDetail(JournalDetails journalDetails);

	Integer delImgs(Integer journalId);

	Integer delJournalDetail(Integer journalId);

	Integer deleteJournal(Integer journalId);

	Integer updateMultipleJournalDetailDel(List<Integer> ids);

	Integer deleteMultipleJournal(List<Integer> ids);
}
