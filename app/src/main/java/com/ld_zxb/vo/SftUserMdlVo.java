package com.ld_zxb.vo;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;
/**
 * 
 * @author DC
 * 用户信息实体类
 *
 */
public class SftUserMdlVo implements Serializable{
	private static final long serialVersionUID = 8776102410038328641L;
	private int  id;//用户标示
	private String nickname;//用户登录名字
	private String mobile;//手机号码
//	private String email;//用户邮箱
	
	@JsonProperty(value = "id") 
	public int getId() {
		return id;
	}
	@JsonSetter(value = "id") 
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	@JsonProperty(value = "nickname") 
	public String getNickname() {
		return nickname;
	}
	@JsonSetter(value = "nickname") 
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
//	
//	
//	@JsonProperty(value = "email")  
//	public String getEmail() {
//		return email;
//	}
//	@JsonSetter(value = "email") 
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	
//	
//	
//	public SftUserMdlVo(int id, String nickname, String mobile,
//			String email) {
//		super();
//		this.id = id;
//		this.nickname = nickname;
//		this.mobile = mobile;
//		this.email = email;
//	}
// 
//	
   

}
