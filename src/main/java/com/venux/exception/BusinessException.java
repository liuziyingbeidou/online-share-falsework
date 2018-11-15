/**
  * @Title: BusinessException.java
  * @Package apollo.erp.base.exception
  * @author jiangjinlong
  * @date 2014-5-17 下午2:12:59
  * @version V1.0
  * Copyright: Copyright (c) 2014
  * Company:北京宅急送快运股份有限公司
  */
package com.venux.exception;

/**
 * @Description: 自定义业务异常
 */
public class BusinessException extends Exception{
	private static final long serialVersionUID = 1L;

	public BusinessException() {
		super();
	}
	public BusinessException(String message) {
		super(message);
	}
	public BusinessException(Throwable cause) {
		super(cause);
	}
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
	public BusinessException(Enum<?> code,Object ...parms) {
		super(assembleMessage(code,parms));
    }
	public BusinessException(Enum<?> code,Throwable cause,Object ...parms) {
		super(assembleMessage(code,parms),cause);
	}
	public static String assembleMessage(Enum<?> code,Object ...parms) {
		StringBuilder sb = new StringBuilder();
		sb.append(code.toString()).append(",");
		
		for (Object obj : parms) {
			sb.append(obj.toString()).append(" ");
		}
		return sb.toString();
	}
	
}
