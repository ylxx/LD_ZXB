package com.ld_zxb.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 派大星 on 2016/6/14 0014.
 */
public class SearchEntity implements Serializable{

    /**
     * message : 查询成功
     * success : true
     * entity : {"courseList":[{"logo":"/upload/mavendemo/course/20160108/1452229426687994694.jpg","title":"包含《风险管理》、《金融工具》、《财务分析工具》、《公司战略与财务》、《企业并购与重组》、《全面预算管理》、《财务管理法规与职业道德》等七门课程。\r\n","teacherList":["徐习兵","郭剑花","黄金波","雷宇","潘敏虹","赵国宇","郭葆春","曹中","沈雅琴","佟爱琴","高慧","闵岳"],"name":"IFM（双证）二级","courseId":147,"subjectList":["IFM（双证）"]},{"logo":"/upload/mavendemo/course/20160108/1452229592281834168.jpg","title":"包含《风险管理》、《金融工具》、《财务分析工具》、《公司战略与财务》、《企业并购与重组》、《全面预算管理》、《财务管理法规与职业道德》、《高级财务管理（英语）》等八门课程。\r\n","teacherList":["郭剑花","徐习兵","黄金波","雷宇","潘敏虹","赵国宇","郭葆春","王新","曹中","沈雅琴","佟爱琴","高慧","闵岳"],"name":"IFM（双证）一级","courseId":138,"subjectList":["IFM（双证）"]},{"logo":"/upload/mavendemo/course/20160108/1452229820326184219.jpg","title":"包含《风险管理》、《金融工具》、《财务分析工具》、《公司战略与财务》、《企业并购与重组》、《全面预算管理》、《财务管理法规与职业道德》等八门课程。\r\n","teacherList":["徐习兵","郭剑花","黄金波","雷宇","潘敏虹","赵国宇","郭葆春","曹中","沈雅琴","佟爱琴","高慧","闵岳"],"name":"IFM（单证）中级","courseId":160,"subjectList":["IFM（单证）"]},{"logo":"/upload/mavendemo/course/20160108/1452229963693693456.jpg","title":"包含《风险管理》、《金融工具》、《财务分析工具》、《公司战略与财务》、《企业并购与重组》、《全面预算管理》、《财务管理法规与职业道德》等九门课程。\r\n","teacherList":["郭剑花","潘敏虹","黄金波","雷宇","赵国宇","徐习兵","郭葆春","于海颖 ","佟爱琴","曹中","沈雅琴","高慧","闵岳"],"name":"IFM（单证）高级","courseId":170,"subjectList":["IFM（单证）"]},{"logo":"/upload/mavendemo/course/20160108/1452229453237173879.jpg","title":"包含《风险管理》、《金融工具》、《财务分析工具》、《公司战略与财务》、《企业并购与重组》、《全面预算管理》、《财务管理法规与职业道德》等七门课程。","teacherList":["徐习兵","郭剑花","黄金波","雷宇","潘敏虹","赵国宇","郭葆春","高慧","王新","沈雅琴","闵岳","于海颖 ","佟爱琴","曹中"],"name":"IFM（双证）高配中","courseId":190,"subjectList":["IFM（双证）"]},{"logo":"/upload/mavendemo/course/20150829/1440819885029700840.jpg","title":"本书是国际财务管理师(IFM)资格考试的中文指导教材之一，共包括总论、中国会计法律制度与工作规范、企业财务通则、税收法律制度、西方国家财务管理法律规范、我国财务管理职业道德规范、西方国家财务管理职业道德规范、财务管理职业道德案例分析等八个章节。","teacherList":["郭葆春"],"name":"IFM（双证）高配中-财务管理法规与职业道德","courseId":189,"subjectList":["IFM（双证）"]},{"logo":"/upload/mavendemo/course/20150829/1440818525447650861.jpg","title":"本书是国际财务管理师（IFM）资格考试的中文指导教材之一，共包括预算管理概述、全面预算编制、预算差异分析、预算执行与控制预算执行的必要条件、预算控制与变更、预算考评和激励等七个章节。","teacherList":["闵岳","徐习兵"],"name":"IFM（双证）高配中-全面预算管理","courseId":188,"subjectList":["IFM（双证）"]},{"logo":"/upload/mavendemo/course/20150829/1440817876318693477.jpg","title":"本书是国际财务管理师(IFM)资格考试的中文指导教材之一，共包括企业并购概述、恶意收购与反收购、杠杆收购、垃圾债券、员工持股计划、企业并购中的财务问题及财务风险、企业并购中的法律问题、企业并购中的税务问题、企业并购的实现方式、公司重组、企业并购协同效应的发挥、并购估价、上市企业并购重组过程中的投资者利益保护等十三个章节。","teacherList":["赵国宇"],"name":"IFM（双证）高配中-企业并购与重组","courseId":187,"subjectList":["IFM（双证）"]},{"logo":"/upload/mavendemo/course/20150829/1440815975282962465.jpg","title":"本书是国际财务管理师(IFM)资格考试的中文指导教材之一，共包括货币市场的金融工具、长期固定收益证券、股权证券、衍生金融工具概述、衍生产品的定价方法、远期市场、期货市场、外汇期货市场、期权市场、互换市场、其他金融工具等十一个章节。\r\n","teacherList":["高慧","黄金波"],"name":"IFM（双证）高配中-金融工具","courseId":186,"subjectList":["IFM（双证）"]},{"logo":"/upload/mavendemo/course/20150829/1440815206690701948.jpg","title":"本书是国际财务管理师(IFM)资格考试的中文指导教材之一，共包括公司战略管理与财务、长期投资决策分析\u2014\u2014资本预算、融资决策、营运资本管理和短期融资、跨国经营与财务管理等五个章节。","teacherList":["佟爱琴","雷宇"],"name":"IFM（双证）高配中-公司战略与财务","courseId":185,"subjectList":["IFM（双证）"]}],"totalPage":2}
     */

    private String message;
    private boolean success;
    /**
     * courseList : [{"logo":"/upload/mavendemo/course/20160108/1452229426687994694.jpg","title":"包含《风险管理》、《金融工具》、《财务分析工具》、《公司战略与财务》、《企业并购与重组》、《全面预算管理》、《财务管理法规与职业道德》等七门课程。\r\n","teacherList":["徐习兵","郭剑花","黄金波","雷宇","潘敏虹","赵国宇","郭葆春","曹中","沈雅琴","佟爱琴","高慧","闵岳"],"name":"IFM（双证）二级","courseId":147,"subjectList":["IFM（双证）"]},{"logo":"/upload/mavendemo/course/20160108/1452229592281834168.jpg","title":"包含《风险管理》、《金融工具》、《财务分析工具》、《公司战略与财务》、《企业并购与重组》、《全面预算管理》、《财务管理法规与职业道德》、《高级财务管理（英语）》等八门课程。\r\n","teacherList":["郭剑花","徐习兵","黄金波","雷宇","潘敏虹","赵国宇","郭葆春","王新","曹中","沈雅琴","佟爱琴","高慧","闵岳"],"name":"IFM（双证）一级","courseId":138,"subjectList":["IFM（双证）"]},{"logo":"/upload/mavendemo/course/20160108/1452229820326184219.jpg","title":"包含《风险管理》、《金融工具》、《财务分析工具》、《公司战略与财务》、《企业并购与重组》、《全面预算管理》、《财务管理法规与职业道德》等八门课程。\r\n","teacherList":["徐习兵","郭剑花","黄金波","雷宇","潘敏虹","赵国宇","郭葆春","曹中","沈雅琴","佟爱琴","高慧","闵岳"],"name":"IFM（单证）中级","courseId":160,"subjectList":["IFM（单证）"]},{"logo":"/upload/mavendemo/course/20160108/1452229963693693456.jpg","title":"包含《风险管理》、《金融工具》、《财务分析工具》、《公司战略与财务》、《企业并购与重组》、《全面预算管理》、《财务管理法规与职业道德》等九门课程。\r\n","teacherList":["郭剑花","潘敏虹","黄金波","雷宇","赵国宇","徐习兵","郭葆春","于海颖 ","佟爱琴","曹中","沈雅琴","高慧","闵岳"],"name":"IFM（单证）高级","courseId":170,"subjectList":["IFM（单证）"]},{"logo":"/upload/mavendemo/course/20160108/1452229453237173879.jpg","title":"包含《风险管理》、《金融工具》、《财务分析工具》、《公司战略与财务》、《企业并购与重组》、《全面预算管理》、《财务管理法规与职业道德》等七门课程。","teacherList":["徐习兵","郭剑花","黄金波","雷宇","潘敏虹","赵国宇","郭葆春","高慧","王新","沈雅琴","闵岳","于海颖 ","佟爱琴","曹中"],"name":"IFM（双证）高配中","courseId":190,"subjectList":["IFM（双证）"]},{"logo":"/upload/mavendemo/course/20150829/1440819885029700840.jpg","title":"本书是国际财务管理师(IFM)资格考试的中文指导教材之一，共包括总论、中国会计法律制度与工作规范、企业财务通则、税收法律制度、西方国家财务管理法律规范、我国财务管理职业道德规范、西方国家财务管理职业道德规范、财务管理职业道德案例分析等八个章节。","teacherList":["郭葆春"],"name":"IFM（双证）高配中-财务管理法规与职业道德","courseId":189,"subjectList":["IFM（双证）"]},{"logo":"/upload/mavendemo/course/20150829/1440818525447650861.jpg","title":"本书是国际财务管理师（IFM）资格考试的中文指导教材之一，共包括预算管理概述、全面预算编制、预算差异分析、预算执行与控制预算执行的必要条件、预算控制与变更、预算考评和激励等七个章节。","teacherList":["闵岳","徐习兵"],"name":"IFM（双证）高配中-全面预算管理","courseId":188,"subjectList":["IFM（双证）"]},{"logo":"/upload/mavendemo/course/20150829/1440817876318693477.jpg","title":"本书是国际财务管理师(IFM)资格考试的中文指导教材之一，共包括企业并购概述、恶意收购与反收购、杠杆收购、垃圾债券、员工持股计划、企业并购中的财务问题及财务风险、企业并购中的法律问题、企业并购中的税务问题、企业并购的实现方式、公司重组、企业并购协同效应的发挥、并购估价、上市企业并购重组过程中的投资者利益保护等十三个章节。","teacherList":["赵国宇"],"name":"IFM（双证）高配中-企业并购与重组","courseId":187,"subjectList":["IFM（双证）"]},{"logo":"/upload/mavendemo/course/20150829/1440815975282962465.jpg","title":"本书是国际财务管理师(IFM)资格考试的中文指导教材之一，共包括货币市场的金融工具、长期固定收益证券、股权证券、衍生金融工具概述、衍生产品的定价方法、远期市场、期货市场、外汇期货市场、期权市场、互换市场、其他金融工具等十一个章节。\r\n","teacherList":["高慧","黄金波"],"name":"IFM（双证）高配中-金融工具","courseId":186,"subjectList":["IFM（双证）"]},{"logo":"/upload/mavendemo/course/20150829/1440815206690701948.jpg","title":"本书是国际财务管理师(IFM)资格考试的中文指导教材之一，共包括公司战略管理与财务、长期投资决策分析\u2014\u2014资本预算、融资决策、营运资本管理和短期融资、跨国经营与财务管理等五个章节。","teacherList":["佟爱琴","雷宇"],"name":"IFM（双证）高配中-公司战略与财务","courseId":185,"subjectList":["IFM（双证）"]}]
     * totalPage : 2
     */

    private EntityBean entity;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public EntityBean getEntity() {
        return entity;
    }

    public void setEntity(EntityBean entity) {
        this.entity = entity;
    }

    public static class EntityBean {
        private int totalPage;
        /**
         * logo : /upload/mavendemo/course/20160108/1452229426687994694.jpg
         * title : 包含《风险管理》、《金融工具》、《财务分析工具》、《公司战略与财务》、《企业并购与重组》、《全面预算管理》、《财务管理法规与职业道德》等七门课程。

         * teacherList : ["徐习兵","郭剑花","黄金波","雷宇","潘敏虹","赵国宇","郭葆春","曹中","沈雅琴","佟爱琴","高慧","闵岳"]
         * name : IFM（双证）二级
         * courseId : 147
         * subjectList : ["IFM（双证）"]
         */

        private List<CourseListBean> courseList;

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public List<CourseListBean> getCourseList() {
            return courseList;
        }

        public void setCourseList(List<CourseListBean> courseList) {
            this.courseList = courseList;
        }

        public static class CourseListBean {
            private String logo;
            private String title;
            private String name;
            private int courseId;
            private List<String> teacherList;
            private List<String> subjectList;

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public List<String> getTeacherList() {
                return teacherList;
            }

            public void setTeacherList(List<String> teacherList) {
                this.teacherList = teacherList;
            }

            public List<String> getSubjectList() {
                return subjectList;
            }

            public void setSubjectList(List<String> subjectList) {
                this.subjectList = subjectList;
            }
        }
    }
}
