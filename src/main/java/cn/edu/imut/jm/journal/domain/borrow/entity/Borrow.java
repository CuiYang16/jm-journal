package cn.edu.imut.jm.journal.domain.borrow.entity;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Borrow {
    /**
     * 借阅表
     */
    private Integer borrowId;

    /**
     * 借阅时间
     */
    private Date borrowTime;

    /**
     * 应归还时间
     */
    private Date returnTime;

    /**
     * 实际归还实际
     */
    private Date realityReturn;

    /**
     * 实际借阅天数
     */
    private Integer realityDays;

    /**
     * 是否逾期
     */
    private Boolean isOverdue;

    /**
     * 逾期天数
     */
    private Integer overdueDays;

    /**
     * 罚金
     */
    private BigDecimal penalty;

    /**
     * 是否缴纳
     */
    private Boolean isPayment;

    /**
     * 是否删除
     */
    private Boolean isDelete;

    /**
     * 用户外键
     */
    private Integer userId;

    /**
     * 资料外键
     */
    private Integer journalId;

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Date getRealityReturn() {
        return realityReturn;
    }

    public void setRealityReturn(Date realityReturn) {
        this.realityReturn = realityReturn;
    }

    public Integer getRealityDays() {
        return realityDays;
    }

    public void setRealityDays(Integer realityDays) {
        this.realityDays = realityDays;
    }

    public Boolean getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(Boolean isOverdue) {
        this.isOverdue = isOverdue;
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public BigDecimal getPenalty() {
        return penalty;
    }

    public void setPenalty(BigDecimal penalty) {
        this.penalty = penalty;
    }

    public Boolean getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(Boolean isPayment) {
        this.isPayment = isPayment;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}