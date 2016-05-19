package com.ld_zxb.vo;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;

/**
 * 用户数据
 * 
 * @author DC
 * 
 */
public class UserLoginVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1910937797583395969L;
	/**
	 * 用户id
	 */
	private String userId;
	private String useAddrContact;
	private String useName;
	private String useMobilePhones;

	@JsonProperty(value = "useId")
	public String getUserId() {
		return userId;
	}

	@JsonSetter(value = "useId")
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JsonProperty(value = "useAddrContact")
	public String getUseAddrContact() {
		return useAddrContact;
	}

	@JsonSetter(value = "useAddrContact")
	public void setUseAddrContact(String useAddrContact) {
		this.useAddrContact = useAddrContact;
	}
	@JsonProperty(value = "useLoginName")
	public String getUseName() {
		return useName;
	}
	@JsonSetter(value = "useLoginName")
	public void setUseName(String useName) {
		this.useName = useName;
	}
	@JsonProperty(value = "useMobilePhones")
	public String getUseMobilePhones() {
		return useMobilePhones;
	}
	@JsonSetter(value = "useMobilePhones")
	public void setUseMobilePhones(String useMobilePhones) {
		this.useMobilePhones = useMobilePhones;
	}


}
