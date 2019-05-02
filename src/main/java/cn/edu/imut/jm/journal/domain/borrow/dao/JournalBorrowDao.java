package cn.edu.imut.jm.journal.domain.borrow.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.edu.imut.jm.journal.domain.borrow.entity.Borrow;
import cn.edu.imut.jm.journal.domain.borrow.valobj.BorrowVo;

@Mapper
public interface JournalBorrowDao {

//	前端请求
	Integer insertBorrow(Borrow borrow);

	List<BorrowVo> selectByUserId(Integer userId);
}
