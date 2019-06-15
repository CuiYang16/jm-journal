package cn.edu.imut.jm.journal.interfaces.facade.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import cn.edu.imut.infrastructrue.util.ResponseVo;
import cn.edu.imut.jm.journal.domain.journal.entity.JournalDetails;
import cn.edu.imut.jm.journal.domain.journal.entity.JournalImages;
import cn.edu.imut.jm.journal.domain.journal.service.JournalDetailService;
import cn.edu.imut.jm.journal.domain.journal.valobj.CheckValue;
import cn.edu.imut.jm.journal.domain.journal.valobj.JournalBorrowVo;
import cn.edu.imut.jm.journal.domain.journal.valobj.JournalDetailVo;
import cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi;

@RestController

public class JournalDetailController implements JournalDetailControllerApi {
	private static final String JOURNAL_IMG_FILE_PATH = "F:/MyWorkSpace/bishe-vue/journal-door/static/journal-img/";
	// private static final String JOURNAL_IMG_FILE_PATH =
	// "C:/Users/Administrator/Desktop/journal-door/static/journal-img/";
	@Autowired
	private JournalDetailService journalDetailService;

	/**
	 * @Title: selectJournalDetails
	 * @Description: 分页条件查询杂志期刊详情信息
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#selectJournalDetails(java.lang.Integer,
	 *           java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	public ResponseVo<JournalDetailVo> selectJournalDetails(@RequestParam("pageNum") Integer pageNum,
			@RequestParam("pageSize") Integer pageSize, @RequestParam("isBorrow") Integer isBorrow,
			@RequestParam("isDelete") Integer isDelete) {
		if (isBorrow == 2) {
			isBorrow = null;
		}
		if (isDelete == 2) {
			isDelete = null;
		}
		return new ResponseVo<JournalDetailVo>(
				journalDetailService.selectJournalDetails(pageNum, pageSize, isBorrow, isDelete));
	}

	/**
	 * 
	 * @Title: updateJournalImage
	 * @Description: 更新杂志封面图片信息
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#updateJournalImage(java.lang.Integer,
	 *           org.springframework.web.multipart.MultipartFile)
	 */
	public ResponseVo updateJournalImage(@RequestParam("journalId") Integer journalId,
			@RequestParam("file") MultipartFile journalImage) {

		if (journalImage == null || journalImage.isEmpty()) {
			return new ResponseVo<>(0, "文件为空");
		}
		String fileName = System.currentTimeMillis() + "-journal"
				+ journalImage.getOriginalFilename().substring(journalImage.getOriginalFilename().lastIndexOf("."));
		String filePath = JOURNAL_IMG_FILE_PATH + fileName;
		File file = new File(filePath);
		if (!file.getParentFile().exists()) { // 判断文件父目录是否存在
			file.getParentFile().mkdir();
		}
		if (journalImage.getOriginalFilename().endsWith(".jpg") || journalImage.getOriginalFilename().endsWith(".jpeg")
				|| journalImage.getOriginalFilename().endsWith(".png")) {
			try {
				journalImage.transferTo(file);
				return new ResponseVo<>(journalDetailService.updateJournalImage(journalId, fileName), fileName);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return new ResponseVo(0, "上传失败，请重试");
			}
		} else {
			return new ResponseVo(0, "上传失败，只允许上传.jpg/.jpeg/.png图片");
		}
	}

	/**
	 * 
	 * @Title: insertJournalDetail
	 * @Description: 新增杂志期刊
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#insertJournalDetail(java.lang.String)
	 */
	@Override
	public ResponseVo insertJournalDetail(@RequestBody String json) {
		JournalDetails journalDetails = JSON.toJavaObject(JSON.parseObject(json).getJSONObject("journalDetails"),
				JournalDetails.class);
		Integer insertJournalDetail = journalDetailService.insertJournalDetail(journalDetails);
		if (insertJournalDetail == 1) {
			JournalDetailVo selectJouanalById = journalDetailService.selectJouanalById(journalDetails.getJournalId());

			return new ResponseVo<>(journalDetails.getJournalId(), selectJouanalById, "添加杂志信息成功!");
		}
		return new ResponseVo<>(0, "添加失败，请刷新重试!");
	}

	/**
	 * 
	 * @Title: selectJouanalById
	 * @Description: 根据id查杂志期刊
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#selectJouanalById(java.lang.Integer)
	 */
	@Override
	public ResponseVo selectJouanalById(@RequestParam("journalId") Integer journalId) {

		return new ResponseVo<>(1, journalDetailService.selectJouanalById(journalId), "查询成功");

	}

	/**
	 * 
	 * @Title: getImgUrl
	 * @Description: 获取杂志封面图片
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#getImgUrl(java.lang.Integer)
	 */
	@Override
	public ResponseVo getImgUrl(@RequestParam("journalId") Integer journalId) {

		return new ResponseVo<>(journalDetailService.getImgUrl(journalId));
	}

	/**
	 * 
	 * @Title: insertJouranlImgs
	 * @Description: 插入杂志期刊附属图片
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#insertJouranlImgs(java.lang.Integer,
	 *           org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public ResponseVo insertJouranlImgs(@RequestParam("journalId") Integer journalId,
			@RequestParam("file") MultipartFile journalImage) {
		if (journalImage == null || journalImage.isEmpty()) {
			return new ResponseVo<>(0, "文件为空");
		}
		String fileName = System.currentTimeMillis() + "-journal-addition"
				+ journalImage.getOriginalFilename().substring(journalImage.getOriginalFilename().lastIndexOf("."));
		String filePath = JOURNAL_IMG_FILE_PATH + fileName;
		File file = new File(filePath);
		if (!file.getParentFile().exists()) { // 判断文件父目录是否存在
			file.getParentFile().mkdir();
		}
		if (journalImage.getOriginalFilename().endsWith(".jpg") || journalImage.getOriginalFilename().endsWith(".jpeg")
				|| journalImage.getOriginalFilename().endsWith(".png")) {
			try {
				journalImage.transferTo(file);
				return new ResponseVo<>(
						journalDetailService.insertJouranlImgs(new JournalImages(fileName, filePath, journalId)));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return new ResponseVo(0, "上传失败，请重试");
			}
		} else {
			return new ResponseVo(0, "上传失败，只允许上传.jpg/.jpeg/.png图片");
		}
	}

	/**
	 * 
	 * @Title: getImages
	 * @Description:获取杂志附属图片
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#getImages(java.lang.Integer)
	 */
	@Override
	public ResponseVo<JournalImages> getImages(@RequestParam("journalId") Integer journalId) {

		return new ResponseVo<JournalImages>(journalDetailService.getImages(journalId));
	}

	/**
	 * 
	 * @Title: updateJournalDetail
	 * @Description: 编辑杂志期刊信息
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#updateJournalDetail(java.lang.String)
	 */
	@Override
	public ResponseVo updateJournalDetail(@RequestBody String json) {
		JournalDetails journalDetails = JSON.toJavaObject(JSON.parseObject(json).getJSONObject("journalDetails"),
				JournalDetails.class);
		Integer updateJournalDetail = journalDetailService.updateJournalDetail(journalDetails);
		if (updateJournalDetail == 1) {
			JournalDetailVo selectJouanalById = journalDetailService.selectJouanalById(journalDetails.getJournalId());

			return new ResponseVo<>(journalDetails.getJournalId(), selectJouanalById, "编辑杂志信息成功!");
		}
		return new ResponseVo(0, "编辑失败，请刷新重试!");
	}

	/**
	 * ]
	 * 
	 * @Title: delImages
	 * @Description: 根据杂志期刊id删除本地图片
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#delImages(java.lang.Integer)
	 */
	@Override
	public ResponseVo delImages(@PathVariable("journalId") Integer journalId) {
		File file = null;
		List<JournalImages> images = journalDetailService.getImages(journalId);
		Integer delImgs = journalDetailService.delImgs(journalId);
		if (delImgs > 0) {
			for (JournalImages journalImages : images) {
				file = new File(journalImages.getUrl());
				if (file.exists() && file.isFile()) {
					if (!file.delete()) {
						return new ResponseVo<>(0, "图片操作失败");
					}

				}
			}
			return new ResponseVo<>(1);
		}
		return new ResponseVo<>(0, "图片操作失败");
	}

	/**
	 * 
	 * @Title: delJournalDetail
	 * @Description: 去激活
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#delJournalDetail(java.lang.String)
	 */
	@Override
	public ResponseVo delJournalDetail(@RequestBody String json) {
		Integer journalId = JSON.parseObject(json).getInteger("journalId");
		return new ResponseVo<>(journalDetailService.delJournalDetail(journalId));
	}

	/**
	 * 
	 * @Title: deleteJournal
	 * @Description: 彻底删除
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#deleteJournal(java.lang.String)
	 */
	@Override
	public ResponseVo deleteJournal(@RequestBody String json) {
		Integer journalId = JSON.parseObject(json).getInteger("journalId");
		return new ResponseVo<>(journalDetailService.deleteJournal(journalId));
	}

	/**
	 * 
	 * @Title: deleteMultipleJournal
	 * @Description: 批量彻底删除
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#deleteMultipleJournal(java.lang.String)
	 */
	@Override
	public ResponseVo deleteMultipleJournal(@RequestBody String json) {
		List<Integer> ids = JSON.parseArray(JSON.toJSONString(JSON.parseObject(json).getJSONArray("delIds")),
				Integer.class);
		return new ResponseVo<>(journalDetailService.deleteMultipleJournal(ids));
	}

	/**
	 * 
	 * @Title: updateMultipleJournalDetailDel
	 * @Description: 批量彻底删除
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#updateMultipleJournalDetailDel(java.lang.String)
	 */
	@Override
	public ResponseVo updateMultipleJournalDetailDel(@RequestBody String json) {
		List<Integer> ids = JSON.parseArray(JSON.toJSONString(JSON.parseObject(json).getJSONArray("delIds")),
				Integer.class);
		return new ResponseVo<>(journalDetailService.updateMultipleJournalDetailDel(ids));
	}

	/**
	 * 
	 * @Title: journalChart
	 * @Description: 杂志统计信息，包括杂志期刊总数和可借阅数
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#journalChart()
	 */
	@Override
	public ResponseVo journalChart() {

		return new ResponseVo<>(journalDetailService.journalChart());
	}

//	前端请求
	/**
	 * 
	 * @Title: getJournalDetails
	 * @Description: 门户网站首页获取杂志期刊信息
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#getJournalDetails()
	 */
	@Override
	public List<JournalDetailVo> getJournalDetails() {
		return journalDetailService.getJournalDetails();
	}

	/**
	 * 
	 * @Title: getJournalDetailByCheck
	 * @Description: 条件列表查询
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#getJournalDetailByCheck(java.lang.String)
	 */
	@Override
	public PageInfo<JournalDetailVo> getJournalDetailByCheck(@RequestBody String json) {
		CheckValue checkValue = JSON.toJavaObject(JSON.parseObject(json).getJSONObject("checkValue"), CheckValue.class);
		Integer currentPage = JSON.parseObject(json).getInteger("currentPage");
		Integer pageSize = JSON.parseObject(json).getInteger("pageSize");
		Integer dateSort = JSON.parseObject(json).getInteger("dateSort");
		return journalDetailService.getJournalDetailByCheck(checkValue, currentPage, pageSize, dateSort);
	}

	/**
	 * 
	 * @Title: getJournalDetailBySearch
	 * @Description: 搜索框查询
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#getJournalDetailBySearch(java.lang.Integer,
	 *           java.lang.Integer, java.lang.String, java.lang.Integer)
	 */
	@Override
	public PageInfo<JournalDetailVo> getJournalDetailBySearch(@RequestParam("currentPage") Integer currentPage,
			@RequestParam("pageSize") Integer pageSize, @RequestParam("searchValue") String searchValue,
			@RequestParam("dateSort") Integer dateSort) {

		return journalDetailService.getJournalDetailBySearch(currentPage, pageSize, searchValue, dateSort);
	}

	/**
	 * 
	 * @Title: getBorrowList
	 * @Description: 借阅列表
	 * @override @see
	 *           cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailControllerApi#getBorrowList()
	 */
	@Override
	public List<JournalBorrowVo> getBorrowList() {

		return journalDetailService.getBorrowList();
	}

}
