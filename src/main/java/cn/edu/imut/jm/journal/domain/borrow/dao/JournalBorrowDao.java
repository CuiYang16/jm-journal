package cn.edu.imut.jm.journal.domain.borrow.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.edu.imut.jm.journal.domain.borrow.entity.Borrow;
import cn.edu.imut.jm.journal.domain.borrow.valobj.BorrowVo;

@Mapper
public interface JournalBorrowDao {

//	前端请求
	Integer insertBorrow(Borrow borrow);

	List<BorrowVo> selectByUserId(@Param("userId") Integer userId, @Param("isOverdue") Integer isOverdue,
			@Param("isPayment") Integer isPayment);
}
