package com.ld_zxb.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class CollectCourseEntityVo extends BaseVo implements Serializable{
	private static final long serialVersionUID = -1621211640663714271L;
	@JsonProperty("entity")
	private Entity entity;
	@JsonProperty("entity")
	public Entity getEntity() {
		return entity;
	}
	/**
	 * 
	 * @param entity
	 * The entity
	 */
	@JsonProperty("entity")
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	public static class Entity implements Serializable{
		private static final long serialVersionUID = -1621211640664714271L;
		@JsonProperty("courseList")
		private List<CourseList> courseList = new ArrayList<CourseList>();
		@JsonProperty("totalPageSize")
		private int totalPageSize;

		/**
		 * 
		 * @return
		 * The courseList
		 */
		@JsonProperty("courseList")
		public List<CourseList> getCourseList() {
			return courseList;
		}

		/**
		 * 
		 * @param courseList
		 * The courseList
		 */
		@JsonProperty("courseList")
		public void setCourseList(List<CourseList> courseList) {
			this.courseList = courseList;
		}

		/**
		 * 
		 * @return
		 * The totalPageSize
		 */
		@JsonProperty("totalPageSize")
		public int getTotalPageSize() {
			return totalPageSize;
		}

		/**
		 * 
		 * @param totalPageSize
		 * The totalPageSize
		 */
		@JsonProperty("totalPageSize")
		public void setTotalPageSize(int totalPageSize) {
			this.totalPageSize = totalPageSize;
		}
       /**CourseList*/
		public static class CourseList implements Serializable{
			private static final long serialVersionUID = -1621211640654714271L;
			@JsonProperty("logo")
			private String logo;
			@JsonProperty("title")
			private String title;
			@JsonProperty("favouriteId")
			private String favouriteId;
			@JsonProperty("name")
			private String name;
			@JsonProperty("loseAbsTime")
			private String loseAbsTime;
			@JsonProperty("courseId")
			private String courseId;

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
			* The favouriteId
			*/
			@JsonProperty("favouriteId")
			public String getFavouriteId() {
			return favouriteId;
			}

			/**
			* 
			* @param favouriteId
			* The favouriteId
			*/
			@JsonProperty("favouriteId")
			public void setFavouriteId(String favouriteId) {
			this.favouriteId = favouriteId;
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
			* The loseAbsTime
			*/
			@JsonProperty("loseAbsTime")
			public String getLoseAbsTime() {
			return loseAbsTime;
			}

			/**
			* 
			* @param loseAbsTime
			* The loseAbsTime
			*/
			@JsonProperty("loseAbsTime")
			public void setLoseAbsTime(String loseAbsTime) {
			this.loseAbsTime = loseAbsTime;
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

			}
	}
}
