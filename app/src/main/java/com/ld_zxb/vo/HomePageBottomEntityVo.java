package com.ld_zxb.vo;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class HomePageBottomEntityVo extends BaseVo implements Serializable{
	private static final long serialVersionUID = -1629011640663014271L;
	
	@JsonProperty(value = "entity")
	private  HomePageBottomEntityBodyVo entity;
	
	@JsonProperty(value = "entity")
	public HomePageBottomEntityBodyVo getEntity() {
		return entity;
	}
	@JsonProperty(value = "entity")
	public void setEntity(HomePageBottomEntityBodyVo entity) {
		this.entity = entity;
	}
	
	
	
}
