package com.ld_zxb.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ParticularCourseEntityVo extends BaseVo implements Serializable{
	private static final long serialVersionUID = -1629011640663014271L;
	
	@JsonProperty(value = "entity")
	private ParticularCourseBodyVo entity;

	@JsonProperty(value = "entity")
	public ParticularCourseBodyVo getEntity() {
		return entity;
	}
	@JsonProperty(value = "entity")
	public void setEntity(ParticularCourseBodyVo entity) {
		this.entity = entity;
	}
	
	
	
	/**Entity**/
	public static class ParticularCourseBodyVo implements Serializable {
		@JsonProperty("course")
		private Course course;
		@JsonProperty("boundCourseList")
		private List<BoundCourseList> boundCourseList = new ArrayList<BoundCourseList>();
		@JsonProperty("catalogList")
		private List<List<CatalogList>> catalogList = new ArrayList<List<CatalogList>>();
		@JsonProperty("isok")
		private Boolean isok;

		/**
		* 
		* @return
		* The course
		*/
		@JsonProperty("course")
		public Course getCourse() {
		return course;
		}

		/**
		* 
		* @param course
		* The course
		*/
		@JsonProperty("course")
		public void setCourse(Course course) {
		this.course = course;
		}

		/**
		* 
		* @return
		* The boundCourseList
		*/
		@JsonProperty("boundCourseList")
		public List<BoundCourseList> getBoundCourseList() {
		return boundCourseList;
		}

		/**
		* 
		* @param boundCourseList
		* The boundCourseList
		*/
		@JsonProperty("boundCourseList")
		public void setBoundCourseList(List<BoundCourseList> boundCourseList) {
		this.boundCourseList = boundCourseList;
		}

		/**
		* 
		* @return
		* The catalogList
		*/
		@JsonProperty("catalogList")
		public List<List<CatalogList>> getCatalogList() {
		return catalogList;
		}

		/**
		* 
		* @param catalogList
		* The catalogList
		*/
		@JsonProperty("catalogList")
		public void setCatalogList(List<List<CatalogList>> catalogList) {
		this.catalogList = catalogList;
		}

		/**
		* 
		* @return
		* The isok
		*/
		@JsonProperty("isok")
		public Boolean getIsok() {
		return isok;
		}

		/**
		* 
		* @param isok
		* The isok
		*/
		@JsonProperty("isok")
		public void setIsok(Boolean isok) {
		this.isok = isok;
		}
        /**Course**/
		public static class Course implements Serializable{
			private static final long serialVersionUID = -1629021642663014270L;
			@JsonProperty("isPay")
			private String isPay;
			@JsonProperty("teacherList")
			private List<TeacherList> teacherList = new ArrayList<TeacherList>();
			@JsonProperty("name")
			private String name;
			@JsonProperty("context")
			private String context;
			@JsonProperty("currentprice")
			private String currentprice;
			@JsonProperty("courseId")
			private String courseId;
			@JsonProperty("courseLogo")
			private String courseLogo;

			/**
			* 
			* @return
			* The isPay
			*/
			@JsonProperty("isPay")
			public String getIsPay() {
			return isPay;
			}

			/**
			* 
			* @param isPay
			* The isPay
			*/
			@JsonProperty("isPay")
			public void setIsPay(String isPay) {
			this.isPay = isPay;
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
			* The context
			*/
			@JsonProperty("context")
			public String getContext() {
			return context;
			}

			/**
			* 
			* @param context
			* The context
			*/
			@JsonProperty("context")
			public void setContext(String context) {
			this.context = context;
			}

			/**
			* 
			* @return
			* The currentprice
			*/
			@JsonProperty("currentprice")
			public String getCurrentprice() {
			return currentprice;
			}

			/**
			* 
			* @param currentprice
			* The currentprice
			*/
			@JsonProperty("currentprice")
			public void setCurrentprice(String currentprice) {
			this.currentprice = currentprice;
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
			* The courseLogo
			*/
			@JsonProperty("courseLogo")
			public String getCourseLogo() {
			return courseLogo;
			}

			/**
			* 
			* @param courseLogo
			* The courseLogo
			*/
			@JsonProperty("courseLogo")
			public void setCourseLogo(String courseLogo) {
			this.courseLogo = courseLogo;
			}
            /**TeacherList**/
			public static class TeacherList implements Serializable{
				private static final long serialVersionUID = -1629027642663014270L;
				@JsonProperty("id")
				private String id;
				@JsonProperty("name")
				private String name;
				@JsonProperty("education")
				private String education;
				@JsonProperty("career")
				private String career;
				@JsonProperty("isStar")
				private String isStar;
				@JsonProperty("picPath")
				private String picPath;
				@JsonProperty("status")
				private String status;
				@JsonProperty("createTime")
				private String createTime;
				@JsonProperty("updateTime")
				private String updateTime;

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

				/**
				* 
				* @return
				* The education
				*/
				@JsonProperty("education")
				public String getEducation() {
				return education;
				}

				/**
				* 
				* @param education
				* The education
				*/
				@JsonProperty("education")
				public void setEducation(String education) {
				this.education = education;
				}

				/**
				* 
				* @return
				* The career
				*/
				@JsonProperty("career")
				public String getCareer() {
				return career;
				}

				/**
				* 
				* @param career
				* The career
				*/
				@JsonProperty("career")
				public void setCareer(String career) {
				this.career = career;
				}

				/**
				* 
				* @return
				* The isStar
				*/
				@JsonProperty("isStar")
				public String getIsStar() {
				return isStar;
				}

				/**
				* 
				* @param isStar
				* The isStar
				*/
				@JsonProperty("isStar")
				public void setIsStar(String isStar) {
				this.isStar = isStar;
				}

				/**
				* 
				* @return
				* The picPath
				*/
				@JsonProperty("picPath")
				public String getPicPath() {
				return picPath;
				}

				/**
				* 
				* @param picPath
				* The picPath
				*/
				@JsonProperty("picPath")
				public void setPicPath(String picPath) {
				this.picPath = picPath;
				}

				/**
				* 
				* @return
				* The status
				*/
				@JsonProperty("status")
				public String getStatus() {
				return status;
				}

				/**
				* 
				* @param status
				* The status
				*/
				@JsonProperty("status")
				public void setStatus(String status) {
				this.status = status;
				}

				/**
				* 
				* @return
				* The createTime
				*/
				@JsonProperty("createTime")
				public String getCreateTime() {
				return createTime;
				}

				/**
				* 
				* @param createTime
				* The createTime
				*/
				@JsonProperty("createTime")
				public void setCreateTime(String createTime) {
				this.createTime = createTime;
				}

				/**
				* 
				* @return
				* The updateTime
				*/
				@JsonProperty("updateTime")
				public String getUpdateTime() {
				return updateTime;
				}

				/**
				* 
				* @param updateTime
				* The updateTime
				*/
				@JsonProperty("updateTime")
				public void setUpdateTime(String updateTime) {
				this.updateTime = updateTime;
				}

				}
			}
		/**BoundCourseList*/
		public static class BoundCourseList implements Serializable{
			private static final long serialVersionUID = -1629011640663014271L;
			@JsonProperty("logo")
			private String logo;
			@JsonProperty("pageViewcount")
			private String pageViewcount;
			@JsonProperty("teahcerList")
			private List<TeahcerList> teahcerList = new ArrayList<TeahcerList>();
			@JsonProperty("courseId")
			private String courseId;
			@JsonProperty("lessionnum")
			private String lessionnum;
			@JsonProperty("courseName")
			private String courseName;

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
			* The pageViewcount
			*/
			@JsonProperty("pageViewcount")
			public String getPageViewcount() {
			return pageViewcount;
			}

			/**
			* 
			* @param pageViewcount
			* The pageViewcount
			*/
			@JsonProperty("pageViewcount")
			public void setPageViewcount(String pageViewcount) {
			this.pageViewcount = pageViewcount;
			}

			/**
			* 
			* @return
			* The teahcerList
			*/
			@JsonProperty("teahcerList")
			public List<TeahcerList> getTeahcerList() {
			return teahcerList;
			}

			/**
			* 
			* @param teahcerList
			* The teahcerList
			*/
			@JsonProperty("teahcerList")
			public void setTeahcerList(List<TeahcerList> teahcerList) {
			this.teahcerList = teahcerList;
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

			/**
			* 
			* @return
			* The courseName
			*/
			@JsonProperty("courseName")
			public String getCourseName() {
			return courseName;
			}

			/**
			* 
			* @param courseName
			* The courseName
			*/
			@JsonProperty("courseName")
			public void setCourseName(String courseName) {
			this.courseName = courseName;
			}
            /**TeahcerList*/
			public static class TeahcerList implements Serializable{
				private static final long serialVersionUID = -1629011640663014271L;
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
		/**CatalogList**/
		public static class CatalogList implements Serializable{
			private static final long serialVersionUID = -1629011640663014271L;
			@JsonProperty("courseName")
			private String courseName;
			@JsonProperty("kpointCourseId")
			private String kpointCourseId;
			@JsonProperty("videoUrl")
			private String videoUrl;
			@JsonProperty("kpointId")
			private String kpointId;
			@JsonProperty("listenSeconds")
			private String listenSeconds;
			@JsonProperty("isfree")
			private String isfree;
			@JsonProperty("childList")
			private List<ChildList> childList = new ArrayList<ChildList>();
			@JsonProperty("listenMinutes")
			private String listenMinutes;
			@JsonProperty("type")
			private String type;
			@JsonProperty("videoName")
			private String videoName;
			@JsonProperty("videoType")
			private String videoType;

			/**
			* 
			* @return
			* The courseName
			*/
			@JsonProperty("courseName")
			public String getCourseName() {
			return courseName;
			}

			/**
			* 
			* @param courseName
			* The courseName
			*/
			@JsonProperty("courseName")
			public void setCourseName(String courseName) {
			this.courseName = courseName;
			}

			/**
			* 
			* @return
			* The kpointCourseId
			*/
			@JsonProperty("kpointCourseId")
			public String getKpointCourseId() {
			return kpointCourseId;
			}

			/**
			* 
			* @param kpointCourseId
			* The kpointCourseId
			*/
			@JsonProperty("kpointCourseId")
			public void setKpointCourseId(String kpointCourseId) {
			this.kpointCourseId = kpointCourseId;
			}

			/**
			* 
			* @return
			* The videoUrl
			*/
			@JsonProperty("videoUrl")
			public String getVideoUrl() {
			return videoUrl;
			}

			/**
			* 
			* @param videoUrl
			* The videoUrl
			*/
			@JsonProperty("videoUrl")
			public void setVideoUrl(String videoUrl) {
			this.videoUrl = videoUrl;
			}

			/**
			* 
			* @return
			* The kpointId
			*/
			@JsonProperty("kpointId")
			public String getKpointId() {
			return kpointId;
			}

			/**
			* 
			* @param kpointId
			* The kpointId
			*/
			@JsonProperty("kpointId")
			public void setKpointId(String kpointId) {
			this.kpointId = kpointId;
			}

			/**
			* 
			* @return
			* The listenSeconds
			*/
			@JsonProperty("listenSeconds")
			public String getListenSeconds() {
			return listenSeconds;
			}

			/**
			* 
			* @param listenSeconds
			* The listenSeconds
			*/
			@JsonProperty("listenSeconds")
			public void setListenSeconds(String listenSeconds) {
			this.listenSeconds = listenSeconds;
			}

			/**
			* 
			* @return
			* The isfree
			*/
			@JsonProperty("isfree")
			public String getIsfree() {
			return isfree;
			}

			/**
			* 
			* @param isfree
			* The isfree
			*/
			@JsonProperty("isfree")
			public void setIsfree(String isfree) {
			this.isfree = isfree;
			}

			/**
			* 
			* @return
			* The childList
			*/
			@JsonProperty("childList")
			public List<ChildList> getChildList() {
			return childList;
			}

			/**
			* 
			* @param childList
			* The childList
			*/
			@JsonProperty("childList")
			public void setChildList(List<ChildList> childList) {
			this.childList = childList;
			}

			/**
			* 
			* @return
			* The listenMinutes
			*/
			@JsonProperty("listenMinutes")
			public String getListenMinutes() {
			return listenMinutes;
			}

			/**
			* 
			* @param listenMinutes
			* The listenMinutes
			*/
			@JsonProperty("listenMinutes")
			public void setListenMinutes(String listenMinutes) {
			this.listenMinutes = listenMinutes;
			}

			/**
			* 
			* @return
			* The type
			*/
			@JsonProperty("type")
			public String getType() {
			return type;
			}

			/**
			* 
			* @param type
			* The type
			*/
			@JsonProperty("type")
			public void setType(String type) {
			this.type = type;
			}

			/**
			* 
			* @return
			* The videoName
			*/
			@JsonProperty("videoName")
			public String getVideoName() {
			return videoName;
			}

			/**
			* 
			* @param videoName
			* The videoName
			*/
			@JsonProperty("videoName")
			public void setVideoName(String videoName) {
			this.videoName = videoName;
			}

			/**
			* 
			* @return
			* The videoType
			*/
			@JsonProperty("videoType")
			public String getVideoType() {
			return videoType;
			}

			/**
			* 
			* @param videoType
			* The videoType
			*/
			@JsonProperty("videoType")
			public void setVideoType(String videoType) {
			this.videoType = videoType;
			}
            /**ChildList**/
			public static class ChildList implements Serializable{
				private static final long serialVersionUID = -1629011640663014271L;
				@JsonProperty("kpointCourseId")
				private String kpointCourseId;
				@JsonProperty("videoUrl")
				private String videoUrl;
				@JsonProperty("kpointId")
				private String kpointId;
				@JsonProperty("listenSeconds")
				private String listenSeconds;
				@JsonProperty("isfree")
				private String isfree;
				@JsonProperty("videoId")
				private String videoId;
				@JsonProperty("listenMinutes")
				private String listenMinutes;
				@JsonProperty("courseId")
				private String courseId;
				@JsonProperty("type")
				private String type;
				@JsonProperty("videoName")
				private String videoName;
				@JsonProperty("videoType")
				private String videoType;

				/**
				* 
				* @return
				* The kpointCourseId
				*/
				@JsonProperty("kpointCourseId")
				public String getKpointCourseId() {
				return kpointCourseId;
				}

				/**
				* 
				* @param kpointCourseId
				* The kpointCourseId
				*/
				@JsonProperty("kpointCourseId")
				public void setKpointCourseId(String kpointCourseId) {
				this.kpointCourseId = kpointCourseId;
				}

				/**
				* 
				* @return
				* The videoUrl
				*/
				@JsonProperty("videoUrl")
				public String getVideoUrl() {
				return videoUrl;
				}

				/**
				* 
				* @param videoUrl
				* The videoUrl
				*/
				@JsonProperty("videoUrl")
				public void setVideoUrl(String videoUrl) {
				this.videoUrl = videoUrl;
				}

				/**
				* 
				* @return
				* The kpointId
				*/
				@JsonProperty("kpointId")
				public String getKpointId() {
				return kpointId;
				}

				/**
				* 
				* @param kpointId
				* The kpointId
				*/
				@JsonProperty("kpointId")
				public void setKpointId(String kpointId) {
				this.kpointId = kpointId;
				}

				/**
				* 
				* @return
				* The listenSeconds
				*/
				@JsonProperty("listenSeconds")
				public String getListenSeconds() {
				return listenSeconds;
				}

				/**
				* 
				* @param listenSeconds
				* The listenSeconds
				*/
				@JsonProperty("listenSeconds")
				public void setListenSeconds(String listenSeconds) {
				this.listenSeconds = listenSeconds;
				}

				/**
				* 
				* @return
				* The isfree
				*/
				@JsonProperty("isfree")
				public String getIsfree() {
				return isfree;
				}

				/**
				* 
				* @param isfree
				* The isfree
				*/
				@JsonProperty("isfree")
				public void setIsfree(String isfree) {
				this.isfree = isfree;
				}

				/**
				* 
				* @return
				* The videoId
				*/
				@JsonProperty("videoId")
				public String getVideoId() {
				return videoId;
				}

				/**
				* 
				* @param videoId
				* The videoId
				*/
				@JsonProperty("videoId")
				public void setVideoId(String videoId) {
				this.videoId = videoId;
				}

				/**
				* 
				* @return
				* The listenMinutes
				*/
				@JsonProperty("listenMinutes")
				public String getListenMinutes() {
				return listenMinutes;
				}

				/**
				* 
				* @param listenMinutes
				* The listenMinutes
				*/
				@JsonProperty("listenMinutes")
				public void setListenMinutes(String listenMinutes) {
				this.listenMinutes = listenMinutes;
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
				* The type
				*/
				@JsonProperty("type")
				public String getType() {
				return type;
				}

				/**
				* 
				* @param type
				* The type
				*/
				@JsonProperty("type")
				public void setType(String type) {
				this.type = type;
				}

				/**
				* 
				* @return
				* The videoName
				*/
				@JsonProperty("videoName")
				public String getVideoName() {
				return videoName;
				}

				/**
				* 
				* @param videoName
				* The videoName
				*/
				@JsonProperty("videoName")
				public void setVideoName(String videoName) {
				this.videoName = videoName;
				}

				/**
				* 
				* @return
				* The videoType
				*/
				@JsonProperty("videoType")
				public String getVideoType() {
				return videoType;
				}

				/**
				* 
				* @param videoType
				* The videoType
				*/
				@JsonProperty("videoType")
				public void setVideoType(String videoType) {
				this.videoType = videoType;
				}

				}
			}
		}
	
}
