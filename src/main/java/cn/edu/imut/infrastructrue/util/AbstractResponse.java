package cn.edu.imut.infrastructrue.util;

public  abstract class AbstractResponse {
	private int code=20000;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
