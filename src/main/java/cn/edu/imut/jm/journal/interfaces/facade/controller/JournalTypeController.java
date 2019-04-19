package cn.edu.imut.jm.journal.interfaces.facade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.edu.imut.infrastructrue.util.ResponseVo;
import cn.edu.imut.jm.journal.domain.type.entity.JournalType;
import cn.edu.imut.jm.journal.domain.type.valobj.JournalTypeVo;
import cn.edu.imut.jm.journal.domain.typel.service.JournalTypeService;
import cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalTypeServiceRemoteApi;

@RestController

public class JournalTypeController implements JournalTypeServiceRemoteApi {

	@Autowired
	private JournalTypeService journalTypeService;

	@Override

	public ResponseVo<JournalTypeVo> selectJournalType() {

		return new ResponseVo<JournalTypeVo>(journalTypeService.selectJournalType());
	}

	@Override

	public ResponseVo<JournalTypeVo> selectChildren(@RequestBody String json) {
		List<Integer> ids = JSON.parseArray(JSON.toJSONString(JSON.parseObject(json).getJSONArray("ids")),
				Integer.class);
		return new ResponseVo<>(journalTypeService.selectChildren(ids));
	}

	@Override
	public ResponseVo insertJournalType(@RequestBody String json) {
		Integer typeId = JSON.parseObject(json).getInteger("typeId");
		JournalType journalType = JSON.toJavaObject(JSON.parseObject(json).getJSONObject("journalType"),
				JournalType.class);

		return new ResponseVo<>(journalTypeService.insertJournalType(typeId, journalType));
	}

	@Override
	public ResponseVo updateJournalType(@RequestBody String json) {
		JournalType journalType = JSON.toJavaObject(JSON.parseObject(json).getJSONObject("journalType"),
				JournalType.class);

		return new ResponseVo<>(journalTypeService.updateJournalType(journalType));
	}

	@Override
	public ResponseVo deleteJournalType(@RequestBody String json) {
		List<Integer> ids = JSON.parseArray(JSON.toJSONString(JSON.parseObject(json).getJSONArray("ids")),
				Integer.class);
		return new ResponseVo<>(journalTypeService.deleteJournalType(ids));
	}

	@Override
	public ResponseVo updateToUp(@RequestBody String json) {
		Integer typeIndex = JSON.parseObject(json).getInteger("typeIndex");
		Integer typeId = JSON.parseObject(json).getInteger("typeId");
		return new ResponseVo<>(journalTypeService.updateToUp(typeId, typeIndex));
	}

	@Override
	public ResponseVo updateToDown(@RequestBody String json) {
		Integer typeIndex = JSON.parseObject(json).getInteger("typeIndex");
		Integer typeId = JSON.parseObject(json).getInteger("typeId");
		return new ResponseVo<>(journalTypeService.updateToDown(typeId, typeIndex));
	}

	@Override
	public ResponseVo<JournalTypeVo> selectJournalTypeAll() {

		return new ResponseVo<JournalTypeVo>(journalTypeService.selectJournalTypeAll());
	}

}
