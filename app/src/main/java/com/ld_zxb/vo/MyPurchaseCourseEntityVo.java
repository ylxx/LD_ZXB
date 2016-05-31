package com.ld_zxb.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class MyPurchaseCourseEntityVo extends BaseVo implements Serializable{
	private static final long serialVersionUID = 8775602410038328321L;
	@JsonProperty("entity")
	private List<PurchaseCourseBody> entity = new ArrayList<PurchaseCourseBody>();
	@JsonProperty("entity")
	public List<PurchaseCourseBody> getPurchaseCourseBody() {
	return entity;
	}

	/**
	* 
	* @param entity
	* The entity
	*/
	@JsonProperty("entity")
	public void setPurchaseCourseBody(List<PurchaseCourseBody> entity) {
	this.entity = entity;
	}
	public static class PurchaseCourseBody implements Serializable{
		private static final long serialVersionUID = 8775602310038328321L;
		@JsonProperty("logo")
		private String logo;
		@JsonProperty("title")
		private String title;
		@JsonProperty("teacherList")
		private List<TeacherList> teacherList = new ArrayList<TeacherList>();
		@JsonProperty("name")
		private String name;
		@JsonProperty("courseId")
		private String courseId;
		@JsonProperty("lessionnum")
		private String lessionnum;

		/**
		* 
		* @return
		* The logo
		*/
		@JsonProperty("logo")
		public String getLogo() {
		return logo;
		}

		/**
		* 
		* @param logo
		* The logo
		*/
		@JsonProperty("logo")
		public void setLogo(String logo) {
		this.logo = logo;
		}

		/**
		* 
		* @return
		* The title
		*/
		@JsonProperty("title")
		public String getTitle() {
		return title;
		}

		/**
		* 
		* @param title
		* The title
		*/
		@JsonProperty("title")
		public void setTitle(String title) {
		this.title = title;
		}

		/**
		* 
		* @return
		* The teacherList
		*/
		@JsonProperty("teacherList")
		public List<TeacherList> getTeacherList() {
		return teacherList;
		}

		/**
		* 
		* @param teacherList
		* The teacherList
		*/
		@JsonProperty("teacherList")
		public void setTeacherList(List<TeacherList> teacherList) {
		this.teacherList = teacherList;
		}

		/**
		* 
		* @return
		* The name
		*/
		@JsonProperty("name")
		public String getName() {
		return name;
		}

		/**
		* 
		* @param name
		* The name
		*/
		@JsonProperty("name")
		public void setName(String name) {
		this.name = name;
		}

		/**
		* 
		* @return
		* The courseId
		*/
		@JsonProperty("courseId")
		public String getCourseId() {
		return courseId;
		}

		/**
		* 
		* @param courseId
		* The courseId
		*/
		@JsonProperty("courseId")
		public void setCourseId(String courseId) {
		this.courseId = courseId;
		}

		/**
		* 
		* @return
		* The lessionnum
		*/
		@JsonProperty("lessionnum")
		public String getLessionnum() {
		return lessionnum;
		}

		/**
		* 
		* @param lessionnum
		* The lessionnum
		*/
		@JsonProperty("lessionnum")
		public void setLessionnum(String lessionnum) {
		this.lessionnum = lessionnum;
		}
		public static class TeacherList implements Serializable{
			private static final long serialVersionUID = 8775608310038328321L;
			@JsonProperty("id")
			private String id;
			@JsonProperty("name")
			private String name;

			/**
			* 
			* @return
			* The id
			*/
			@JsonProperty("id")
			public String getId() {
			return id;
			}

			/**
			* 
			* @param id
			* The id
			*/
			@JsonProperty("id")
			public void setId(String id) {
			this.id = id;
			}

			/**
			* 
			* @return
			* The name
			*/
			@JsonProperty("name")
			public String getName() {
			return name;
			}

			/**
			* 
			* @param name
			* The name
			*/
			@JsonProperty("name")
			public void setName(String name) {
			this.name = name;
			}

			}
		}
}
