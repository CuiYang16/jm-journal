package cn.edu.imut.jm.journal.interfaces.facade.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.imut.infrastructrue.util.ResponseVo;
import cn.edu.imut.jm.journal.domain.type.entity.JournalType;
import cn.edu.imut.jm.journal.domain.type.valobj.JournalTypeVo;

@RequestMapping("/journal-type")
public interface JournalTypeServiceRemoteApi {

	@RequestMapping(value = "/get-type", method = RequestMethod.GET)
	ResponseVo<JournalTypeVo> selectJournalType();

	@RequestMapping(value = "/get-type-children", method = { RequestMethod.GET, RequestMethod.POST })
	ResponseVo<JournalTypeVo> selectChildren(@RequestBody String json);

	@RequestMapping(value = "/insert-type", method = { RequestMethod.POST })
	ResponseVo insertJournalType(@RequestBody String json);

	@RequestMapping(value = "/update-type", method = { RequestMethod.PUT })
	ResponseVo updateJournalType(@RequestBody String json);

	@RequestMapping(value = "/delete-type", method = { RequestMethod.DELETE })
	ResponseVo deleteJournalType(@RequestBody String json);

	@RequestMapping(value = "/update/toup", method = { RequestMethod.PUT })
	ResponseVo updateToUp(@RequestBody String json);

	@RequestMapping(value = "/update/todown", method = { RequestMethod.PUT })
	ResponseVo updateToDown(@RequestBody String json);

	@RequestMapping(value = "/get-alltype", method = RequestMethod.GET)
	ResponseVo<JournalTypeVo> selectJournalTypeAll();

//	前端请求
	@RequestMapping(value = "/get/f-type", method = RequestMethod.GET)
	List<JournalType> selectFirstLevel();
}
