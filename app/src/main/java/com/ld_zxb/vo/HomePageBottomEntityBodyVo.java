package com.ld_zxb.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class HomePageBottomEntityBodyVo implements Serializable{
	private static final long serialVersionUID = -1629011640663014271L;
	
	@JsonProperty("courseList")
	private List<CourseList> courseList;
	@JsonProperty("totalPage")
	private int totalPage;
	
	@JsonProperty("courseList")
	public List<CourseList> getCourseList() {
		return courseList;
	}

	@JsonProperty("courseList")
	public void setCourseList(List<CourseList> courseList) {
		this.courseList = courseList;
	}

	@JsonProperty("totalPage")
	public int getTotalPage() {
		return totalPage;
	}

	@JsonProperty("totalPage")
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	
	public static class CourseList {

		@JsonProperty("logo")
		private String logo;
		@JsonProperty("title")
		private String title;
		@JsonProperty("teacherList")
		private List<String> teacherList = new ArrayList<String>();
		@JsonProperty("name")
		private String name;
		@JsonProperty("courseId")
		private Integer courseId;
		@JsonProperty("subjectList")
		private List<String> subjectList = new ArrayList<String>();

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
		public List<String> getTeacherList() {
		return teacherList;
		}

		/**
		* 
		* @param teacherList
		* The teacherList
		*/
		@JsonProperty("teacherList")
		public void setTeacherList(List<String> teacherList) {
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
		public Integer getCourseId() {
		return courseId;
		}

		/**
		* 
		* @param courseId
		* The courseId
		*/
		@JsonProperty("courseId")
		public void setCourseId(Integer courseId) {
		this.courseId = courseId;
		}

		/**
		* 
		* @return
		* The subjectList
		*/
		@JsonProperty("subjectList")
		public List<String> getSubjectList() {
		return subjectList;
		}

		/**
		* 
		* @param subjectList
		* The subjectList
		*/
		@JsonProperty("subjectList")
		public void setSubjectList(List<String> subjectList) {
		this.subjectList = subjectList;
		}

		}
}
