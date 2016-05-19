package com.ld_zxb.vo;

import org.codehaus.jackson.annotate.JsonSetter;

import java.io.Serializable;

public class RegisterVo extends BaseVo implements Serializable{
	private static final long serialVersionUID = -1629011640663014271L;

	private String code;
	private RegisterBodyVo data;

	@JsonSetter(value = "code")
	public String getCode() {
		return code;
	}
	@JsonSetter(value = "code")
	public void setCode(String code) {
		this.code = code;
	}
	@JsonSetter(value = "data")
	public RegisterBodyVo getData() {
		return data;
	}
	@JsonSetter(value = "data")
	public void setData(RegisterBodyVo data) {
		this.data = data;
	}


	public class RegisterBodyVo implements Serializable{
		private static final long serialVersionUID = -1629011640663014271L;

		private String phone;
		private String password;

		@JsonSetter(value = "phone")
		public String getPhone() {
			return phone;
		}
		@JsonSetter(value = "phone")
		public void setPhone(String phone) {
			this.phone = phone;
		}
		@JsonSetter(value = "password")
		public String getPassword() {
			return password;
		}
		@JsonSetter(value = "password")
		public void setPassword(String password) {
			this.password = password;
		}


	}

}
