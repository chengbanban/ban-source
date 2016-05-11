package com.bill99.ian.exception;

/**
 * 自定义业务异常
 * @author haipeng.cheng
 *
 */
public class BusiException extends Exception{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -1738699901868760472L;
	
	private String errorCode;
	
	private String errorMgs;

	public BusiException(String errorCode, String errorMgs) {
		super();
		this.errorCode = errorCode;
		this.errorMgs = errorMgs;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMgs() {
		return errorMgs;
	}

	public void setErrorMgs(String errorMgs) {
		this.errorMgs = errorMgs;
	}

	@Override
	public String toString() {
		return "BusiException [errorCode=" + errorCode + ", errorMgs="
				+ errorMgs + "]";
	}
}
