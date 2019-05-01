package cn.edu.imut.jm.journal.domain.journal.valobj;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CheckValue {

	private Integer type;
	private Integer level;
	private Integer cycle;
	private Integer area;
	private Integer time;
	private Date startTime;
	private Date endTime;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getCycle() {
		return cycle;
	}

	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Date getStartTime() {

		return startTime;
	}

	public void setStartTime(Date startTime) {

		this.startTime = startTime;
	}

	public Date getEndTime() {

		return endTime;
	}

	public void setEndTime(Date endTime) {

		this.endTime = endTime;
	}

	public CheckValue(Integer type, Integer level, Integer cycle, Integer area, Integer time) {
		super();
		this.type = type;
		this.level = level;
		this.cycle = cycle;
		this.area = area;
		this.time = time;
	}

	public CheckValue() {
		super();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
