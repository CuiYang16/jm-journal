package cn.edu.imut.jm.journal.interfaces.facade.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;

import cn.edu.imut.infrastructrue.util.ResponseVo;
import cn.edu.imut.jm.journal.domain.journal.entity.JournalImages;
import cn.edu.imut.jm.journal.domain.journal.valobj.JournalBorrowVo;
import cn.edu.imut.jm.journal.domain.journal.valobj.JournalDetailVo;

@RequestMapping("/journal-detail")
public interface JournalDetailControllerApi {

	@RequestMapping(value = "/get-journals", method = RequestMethod.GET)
	ResponseVo<JournalDetailVo> selectJournalDetails(@RequestParam("pageNum") Integer pageNum,
			@RequestParam("pageSize") Integer pageSize, @RequestParam("isBorrow") Integer isBorrow,
			@RequestParam("isDelete") Integer isDelete);

	@RequestMapping(value = "/get-journal", method = RequestMethod.GET)
	ResponseVo selectJouanalById(@RequestParam("journalId") Integer journalId);

	@RequestMapping(value = "/get-img", method = RequestMethod.GET)
	ResponseVo getImgUrl(@RequestParam("journalId") Integer journalId);

	@RequestMapping(value = "/upload/jounal-img", method = { RequestMethod.POST, RequestMethod.GET })
	public ResponseVo updateJournalImage(@RequestParam("journalId") Integer journalId,
			@RequestParam("file") MultipartFile journalImage);

	@RequestMapping(value = "/insert-journals", method = RequestMethod.POST)
	ResponseVo insertJournalDetail(@RequestBody String json);

	@RequestMapping(value = "/upload/jounal-imgs", method = { RequestMethod.POST, RequestMethod.GET })
	ResponseVo insertJouranlImgs(@RequestParam("journalId") Integer journalId,
			@RequestParam("file") MultipartFile journalImage);

	@RequestMapping(value = "/get-imgs", method = RequestMethod.GET)
	ResponseVo<JournalImages> getImages(@RequestParam("journalId") Integer journalId);

	@RequestMapping(value = "/del-imgs/{journalId}", method = RequestMethod.DELETE)
	ResponseVo delImages(@PathVariable("journalId") Integer journalId);

	@RequestMapping(value = "/update-journals", method = RequestMethod.PUT)
	ResponseVo updateJournalDetail(@RequestBody String json);

//	真删
	@RequestMapping(value = "/del-journals", method = RequestMethod.DELETE)
	ResponseVo deleteJournal(@RequestBody String json);

//假删
	@RequestMapping(value = "/del-journal", method = RequestMethod.PUT)
	ResponseVo delJournalDetail(@RequestBody String json);

//真批量删
	@RequestMapping(value = "/del-mul-journals", method = RequestMethod.DELETE)
	ResponseVo deleteMultipleJournal(@RequestBody String json);

//	假批量删
	@RequestMapping(value = "/del-mul-journal", method = RequestMethod.PUT)
	ResponseVo updateMultipleJournalDetailDel(@RequestBody String json);

	@RequestMapping(value = "/get-journal-chart", method = RequestMethod.GET)
	ResponseVo journalChart();

//	前端请求
	@RequestMapping(value = "/get/new-journal", method = RequestMethod.GET)
	List<JournalDetailVo> getJournalDetails();

	@RequestMapping(value = "/get/check-journal", method = { RequestMethod.POST, RequestMethod.GET })
	PageInfo<JournalDetailVo> getJournalDetailByCheck(@RequestBody String json);

	@RequestMapping(value = "/get/search-journal", method = { RequestMethod.GET })
	PageInfo<JournalDetailVo> getJournalDetailBySearch(@RequestParam("currentPage") Integer currentPage,
			@RequestParam("pageSize") Integer pageSize, @RequestParam("searchValue") String searchValue,
			@RequestParam("dateSort") Integer dateSort);

	@RequestMapping(value = "/get/journal-borrow", method = { RequestMethod.GET })
	List<JournalBorrowVo> getBorrowList();
}
