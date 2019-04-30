package cn.edu.imut.jm.journal.domain.typel.service;

import java.util.List;

import cn.edu.imut.jm.journal.domain.type.entity.JournalType;
import cn.edu.imut.jm.journal.domain.type.valobj.JournalTypeVo;

public interface JournalTypeService {

	List<JournalTypeVo> selectJournalType();

	List<JournalTypeVo> selectChildren(List<Integer> ids);

	JournalType insertJournalType(Integer typeId, JournalType journalType);

	Integer updateJournalType(JournalType journalType);

	Integer deleteJournalType(List<Integer> ids);

	Integer updateToUp(Integer typeId, Integer typeIndex);

	Integer updateToDown(Integer typeId, Integer typeIndex);

	List<JournalTypeVo> selectJournalTypeAll();

//	前端请求
	List<JournalType> selectFirstLevel();
}
