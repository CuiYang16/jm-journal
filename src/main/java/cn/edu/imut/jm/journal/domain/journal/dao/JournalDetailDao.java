package cn.edu.imut.jm.journal.domain.journal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.edu.imut.jm.journal.domain.journal.entity.JournalDetails;
import cn.edu.imut.jm.journal.domain.journal.entity.JournalImages;
import cn.edu.imut.jm.journal.domain.journal.valobj.CheckValue;
import cn.edu.imut.jm.journal.domain.journal.valobj.JournalBorrowVo;
import cn.edu.imut.jm.journal.domain.journal.valobj.JournalDetailVo;

@Mapper
public interface JournalDetailDao {

	List<JournalDetailVo> selectJournalDetails(@Param("isBorrow") Integer isBorrow,
			@Param("isDelete") Integer isDelete);

	List<JournalDetailVo> selectJournals();

	JournalDetailVo selectJouanalById(Integer journalId);

	Integer updateJournalImage(@Param("journalId") Integer journalId, @Param("journalImg") String journalImg);

	Integer insertJournalDetail(JournalDetails journalDetails);

	String getImgUrl(Integer journalId);

	Integer insertJouranlImgs(JournalImages journalImage);

	List<JournalImages> getImages(Integer journalId);

	Integer updateJournalDetail(JournalDetails journalDetails);

	Integer delImgs(Integer journalId);

	Integer updateJournalDetailDel(Integer journalId);

	Integer deleteJournal(Integer journalId);

	Integer updateMultipleJournalDetailDel(List<Integer> ids);

	Integer deleteMultipleJournal(List<Integer> ids);

	Integer journalCount();

	Integer okJournalCount();

//	前端请求
	List<JournalDetailVo> getJournalDetails();

	List<JournalDetailVo> getJournalDetailByCheck(@Param("checkValue") CheckValue checkValue,
			@Param("dateSort") Integer dateSort);

	List<JournalDetailVo> getJournalDetailBySearch(@Param("searchType") String searchType,
			@Param("typeValue") String typeValue, @Param("dateSort") Integer dateSort);

	List<JournalBorrowVo> getBorrowList();
}
