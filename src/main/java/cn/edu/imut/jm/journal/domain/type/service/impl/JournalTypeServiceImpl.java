package cn.edu.imut.jm.journal.domain.type.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.imut.jm.journal.domain.type.dao.JournalTypeDao;
import cn.edu.imut.jm.journal.domain.type.entity.JournalType;
import cn.edu.imut.jm.journal.domain.type.valobj.JournalTypeVo;
import cn.edu.imut.jm.journal.domain.typel.service.JournalTypeService;

@Service
public class JournalTypeServiceImpl implements JournalTypeService {

	@Autowired
	private JournalTypeDao journalTypeDao;

	@Override
	public List<JournalTypeVo> selectJournalType() {
		List<JournalTypeVo> list = journalTypeDao.selectJournalType();

		return list;
	}

	@Override
	public List<JournalTypeVo> selectChildren(List<Integer> ids) {
		if (ids != null && ids.size() > 0) {
			return journalTypeDao.selectChildren(ids);
		}
		return null;
	}

	@Override
	public JournalType insertJournalType(Integer typeId, JournalType journalType) {
		if (typeId != null && journalType != null && typeId != 0) {
			Integer queryLikeId = journalTypeDao.queryLikeId(typeId);
			Integer queryMaxIndex = journalTypeDao.queryMaxIndex();

			journalType.setParentId(typeId);
			journalType.setTypeId(
					queryLikeId != null && queryLikeId != 0 ? queryLikeId + 1 : Integer.valueOf(typeId + "001"));
			int length = journalType.getTypeId().toString().length();
			journalType.setTypeLevel((length / 3) + 1 <= 1 ? 1 : (length / 3) + 1 <= 2 && (length / 3) + 1 > 1 ? 2 : 3);
			journalType.setTypeIndex(journalType.getTypeLevel() == 1 ? queryMaxIndex + 1 : null);
			Integer insertJournalType = journalTypeDao.insertJournalType(journalType);
			if (insertJournalType == 1) {
				return journalType;
			}

		}

		return null;
	}

	@Override
	public Integer updateJournalType(JournalType journalType) {
		if (journalType != null && journalType.getTypeName() != null && !journalType.getTypeName().isEmpty()) {
			return journalTypeDao.updateJournalType(journalType);
		}
		return null;
	}

	@Override
	public Integer deleteJournalType(List<Integer> ids) {
		if (ids != null && ids.size() > 0) {
			return journalTypeDao.deleteJournalType(ids);
		}
		return null;
	}

	@Override
	public Integer updateToUp(Integer typeId, Integer typeIndex) {
		if (typeId != null && typeId != 0 && typeIndex != null && typeIndex != 0) {
			return journalTypeDao.updateToUp(typeId, typeIndex);
		}
		return null;
	}

	@Override
	public Integer updateToDown(Integer typeId, Integer typeIndex) {
		if (typeId != null && typeId != 0 && typeIndex != null && typeIndex != 0) {
			return journalTypeDao.updateToDown(typeId, typeIndex);
		}
		return null;
	}

	@Override
	public List<JournalTypeVo> selectJournalTypeAll() {

		return journalTypeDao.selectJournalTypeAll();
	}

}
