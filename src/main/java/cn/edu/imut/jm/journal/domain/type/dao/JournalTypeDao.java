package cn.edu.imut.jm.journal.domain.type.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.edu.imut.jm.journal.domain.type.entity.JournalType;
import cn.edu.imut.jm.journal.domain.type.valobj.JournalTypeVo;

@Mapper
public interface JournalTypeDao {

	List<JournalTypeVo> selectJournalType();

	List<JournalTypeVo> selectChildren(List<Integer> ids);

	Integer queryLikeId(Integer typeId);

	Integer queryMaxIndex();

	Integer insertJournalType(JournalType journalType);

	Integer updateJournalType(JournalType journalType);

	Integer deleteJournalType(List<Integer> ids);

	Integer updateToUp(@Param("typeId") Integer typeId, @Param("typeIndex") Integer typeIndex);

	Integer updateToDown(@Param("typeId") Integer typeId, @Param("typeIndex") Integer typeIndex);

	List<JournalTypeVo> selectJournalTypeAll();
}
