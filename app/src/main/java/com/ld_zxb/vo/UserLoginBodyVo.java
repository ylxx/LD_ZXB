package com.ld_zxb.vo;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;


public class UserLoginBodyVo extends BaseVo implements Serializable{
	// 具体信息
	
	private static final long serialVersionUID = 8776102410038328641L;
	private SftUserMdlVo body;

	@JsonProperty(value = "entity")
	public SftUserMdlVo getBody() {
		return body;
	}
    
	@JsonSetter(value = "entity")
	public void setBody(SftUserMdlVo body) {
		this.body = body;
	}
//  	public UserLoginBodyVo(SftUserMdlVo body) {
//		super();
//		this.body = body;
//	} 
}
