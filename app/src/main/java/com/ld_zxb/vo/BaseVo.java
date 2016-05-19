package com.ld_zxb.vo;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;

/**
 * <pre>
 * 业务名:
 * 功能说明:
 * 编写日期:	2015年11月20日17:44:42
 * 作者:	DC
 *
 * 历史记录
 * 1、修改日期：
 *    修改人：
 *    修改内容：
 * </pre>
 */
public class BaseVo implements Serializable{
	private static final long serialVersionUID = -1629011640663014271L;

	private boolean success;
	// 错误信息
	private String message;

	@JsonSetter(value = "message")
	public String getMessage() {
		return message;
	}
	@JsonSetter(value = "message")
	public void setMessage(String message) {
		this.message = message;
	}
	@JsonProperty(value = "success")
	public boolean getSuccess() {
		return success;
	}
	@JsonSetter(value = "success")
	public void setSuccess(boolean success) {
		this.success = success;
	}

}
