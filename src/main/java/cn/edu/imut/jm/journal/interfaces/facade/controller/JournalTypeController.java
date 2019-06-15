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

	/**
	 * 
	 * @Title: selectJournalType
	 * @Description: 查询前两级类别
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalTypeServiceRemoteApi#selectJournalType()
	 */
	@Override
	public ResponseVo<JournalTypeVo> selectJournalType() {
		return new ResponseVo<JournalTypeVo>(journalTypeService.selectJournalType());
	}

	/**
	 * 
	 * @Title: selectChildren
	 * @Description: 查询子集
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalTypeServiceRemoteApi#selectChildren(java.lang.String)
	 */
	@Override
	public ResponseVo<JournalTypeVo> selectChildren(@RequestBody String json) {
		List<Integer> ids = JSON.parseArray(JSON.toJSONString(JSON.parseObject(json).getJSONArray("ids")),
				Integer.class);
		return new ResponseVo<>(journalTypeService.selectChildren(ids));
	}

	/**
	 * 
	 * @Title: insertJournalType
	 * @Description: 新增类别
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalTypeServiceRemoteApi#insertJournalType(java.lang.String)
	 */
	@Override
	public ResponseVo insertJournalType(@RequestBody String json) {
		Integer typeId = JSON.parseObject(json).getInteger("typeId");
		JournalType journalType = JSON.toJavaObject(JSON.parseObject(json).getJSONObject("journalType"),
				JournalType.class);

		return new ResponseVo<>(journalTypeService.insertJournalType(typeId, journalType));
	}

	/**
	 * 
	 * @Title: updateJournalType
	 * @Description: 编辑类别
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalTypeServiceRemoteApi#updateJournalType(java.lang.String)
	 */
	@Override
	public ResponseVo updateJournalType(@RequestBody String json) {
		JournalType journalType = JSON.toJavaObject(JSON.parseObject(json).getJSONObject("journalType"),
				JournalType.class);

		return new ResponseVo<>(journalTypeService.updateJournalType(journalType));
	}

	/**
	 * 
	 * @Title: deleteJournalType
	 * @Description: 删除类别
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalTypeServiceRemoteApi#deleteJournalType(java.lang.String)
	 */
	@Override
	public ResponseVo deleteJournalType(@RequestBody String json) {
		List<Integer> ids = JSON.parseArray(JSON.toJSONString(JSON.parseObject(json).getJSONArray("ids")),
				Integer.class);
		return new ResponseVo<>(journalTypeService.deleteJournalType(ids));
	}

	/**
	 * 
	 * @Title: updateToUp
	 * @Description: 顶级上移
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalTypeServiceRemoteApi#updateToUp(java.lang.String)
	 */
	@Override
	public ResponseVo updateToUp(@RequestBody String json) {
		Integer typeIndex = JSON.parseObject(json).getInteger("typeIndex");
		Integer typeId = JSON.parseObject(json).getInteger("typeId");
		return new ResponseVo<>(journalTypeService.updateToUp(typeId, typeIndex));
	}

	/**
	 * 
	 * @Title: updateToDown
	 * @Description: 顶级下移
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalTypeServiceRemoteApi#updateToDown(java.lang.String)
	 */
	@Override
	public ResponseVo updateToDown(@RequestBody String json) {
		Integer typeIndex = JSON.parseObject(json).getInteger("typeIndex");
		Integer typeId = JSON.parseObject(json).getInteger("typeId");
		return new ResponseVo<>(journalTypeService.updateToDown(typeId, typeIndex));
	}

	/**
	 * 
	 * @Title: selectJournalTypeAll
	 * @Description: 查询所有类别信息
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalTypeServiceRemoteApi#selectJournalTypeAll()
	 */
	@Override
	public ResponseVo<JournalTypeVo> selectJournalTypeAll() {

		return new ResponseVo<JournalTypeVo>(journalTypeService.selectJournalTypeAll());
	}

//	前端请求
	/**
	 * 
	 * @Title: selectFirstLevel
	 * @Description: 查询所有一级
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalTypeServiceRemoteApi#selectFirstLevel()
	 */
	@Override
	public List<JournalType> selectFirstLevel() {

		return journalTypeService.selectFirstLevel();
	}

}
