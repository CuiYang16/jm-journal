package cn.edu.imut.jm.journal.domain.borrow.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.edu.imut.jm.journal.domain.borrow.entity.Borrow;
import cn.edu.imut.jm.journal.domain.borrow.valobj.BorrowManageVo;
import cn.edu.imut.jm.journal.domain.borrow.valobj.BorrowVo;
import cn.edu.imut.jm.journal.domain.borrow.valobj.User;
import cn.edu.imut.jm.journal.domain.journal.entity.JournalDetails;

@Mapper
public interface JournalBorrowDao {

	List<BorrowManageVo> selectBorrows(@Param("userId") Integer userId, @Param("isOverdue") Integer isOverdue,
			@Param("isPayment") Integer isPayment);

	List<User> selectAllUser();

	List<JournalDetails> selectJournals();

	Integer updateInventory(Integer journalId);

	Integer updateReturnBorrow(Borrow borrow);

	Borrow selecrtOverdue(Integer userId);

	List<Borrow> selectNotReturn(Integer userId);

	Integer updateIsPayment(Integer borrowId);

	Integer updateBorrowDel(Integer borrowId);

	Integer deleteBorrow(Integer borrowId);

	Integer updateMultipleBorrowDel(List<Integer> ids);

	Integer deleteMultipleBorrow(List<Integer> ids);

//	前端请求
	Integer insertBorrow(Borrow borrow);

	List<BorrowVo> selectByUserId(@Param("userId") Integer userId, @Param("isOverdue") Integer isOverdue,
			@Param("isPayment") Integer isPayment);

}
