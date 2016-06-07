package com.ld_zxb.entity;

import java.util.List;

/**
 * Created by 派大星 on 2016/6/1 0001.
 */
public class InformationEntity {

    /**
     * message : 查询成功
     * success : true
     * entity : {"articleList":[{"picture":"/upload/eduplat/article/20151009/1444373151796912992.jpg","id":32,"author":"中国总会计师协会","createTime":"2015-10-09 14:46:42","title":"多屏学习 学习时间由你掌控","updateTime":"2015-10-09 14:55:00","description":"·手机、Ipad、电脑三屏合一\r\n·课程考点重点多屏学习 随时随地学习好轻松\r\n·考点浓缩，高频考题、考点切片分析，保证效率最大化，只讲考试关键点，去掉冗余内容，只取精华\r\n\r\n\r\n\r\n当今社会，科学技术迅猛发展，信息知识获取的渠道、效率和便捷程度越来 越受到人们的关注。为了适应社会的发展，人们的求知思维也在不断变化，终身学习这一观点己被普遍接受。\r\n\r\n在信息技术迅速发展的当今社会，我们的学习不...","clickTimes":1444,"type":1,"meta":"资讯"},{"picture":"/upload/eduplat/article/20151009/1444372918847582242.jpg","id":31,"author":"中国总会计师协会","createTime":"2015-10-09 14:42:29","title":"专业题库 实战必备","updateTime":"2015-10-09 14:42:29","description":"对于某些行业来说，职称的高低在很大程度上决定着工资的收入以及其他福利的多少。高级职称年薪超中级职称2-3倍已是司空见惯。可以说，职称高低对这部分从业者的生活而言至关重要。然而，不可否认的是，受工作和生活的压力的影响，从业者已经很难有更多精力去轻松应对那些专业性很高的行业职称考试了。\r\n\r\n\r\n\r\n据调查，有超过55%职称考试者先后经历过两次甚至两次以上考试而未通过。然而有些人凭借着朗顿在线教育的帮...","clickTimes":1603,"type":1,"meta":"资讯"},{"picture":"/upload/eduplat/article/20151009/1444372491867941813.jpg","id":30,"author":"中国总会计师协会","createTime":"2015-10-09 14:37:17","title":"国际财务管理师（IFM）定位前瞻，含金量高","updateTime":"2015-10-09 14:39:25","description":"\r\n\r\n国际财务管理协会（International Financial Management Association，英文缩写IFMA）是一家专业从事财务管理理论和应用研究、推动财务管理全球化、研究和推广财务管理职业标准的全球性财经专业团体。其前身为国际管理会计师协会。IFMA一贯秉承的宗旨是：推动财务管理全球化，研究和推广全球适用的财务管理职业知识体系和认证标准，为各国培养现代企业管理所必需的...","clickTimes":4314,"type":1,"meta":"资讯"}],"totalPageSize":6}
     */

    private String message;
    private boolean success;
    /**
     * articleList : [{"picture":"/upload/eduplat/article/20151009/1444373151796912992.jpg","id":32,"author":"中国总会计师协会","createTime":"2015-10-09 14:46:42","title":"多屏学习 学习时间由你掌控","updateTime":"2015-10-09 14:55:00","description":"·手机、Ipad、电脑三屏合一\r\n·课程考点重点多屏学习 随时随地学习好轻松\r\n·考点浓缩，高频考题、考点切片分析，保证效率最大化，只讲考试关键点，去掉冗余内容，只取精华\r\n\r\n\r\n\r\n当今社会，科学技术迅猛发展，信息知识获取的渠道、效率和便捷程度越来 越受到人们的关注。为了适应社会的发展，人们的求知思维也在不断变化，终身学习这一观点己被普遍接受。\r\n\r\n在信息技术迅速发展的当今社会，我们的学习不...","clickTimes":1444,"type":1,"meta":"资讯"},{"picture":"/upload/eduplat/article/20151009/1444372918847582242.jpg","id":31,"author":"中国总会计师协会","createTime":"2015-10-09 14:42:29","title":"专业题库 实战必备","updateTime":"2015-10-09 14:42:29","description":"对于某些行业来说，职称的高低在很大程度上决定着工资的收入以及其他福利的多少。高级职称年薪超中级职称2-3倍已是司空见惯。可以说，职称高低对这部分从业者的生活而言至关重要。然而，不可否认的是，受工作和生活的压力的影响，从业者已经很难有更多精力去轻松应对那些专业性很高的行业职称考试了。\r\n\r\n\r\n\r\n据调查，有超过55%职称考试者先后经历过两次甚至两次以上考试而未通过。然而有些人凭借着朗顿在线教育的帮...","clickTimes":1603,"type":1,"meta":"资讯"},{"picture":"/upload/eduplat/article/20151009/1444372491867941813.jpg","id":30,"author":"中国总会计师协会","createTime":"2015-10-09 14:37:17","title":"国际财务管理师（IFM）定位前瞻，含金量高","updateTime":"2015-10-09 14:39:25","description":"\r\n\r\n国际财务管理协会（International Financial Management Association，英文缩写IFMA）是一家专业从事财务管理理论和应用研究、推动财务管理全球化、研究和推广财务管理职业标准的全球性财经专业团体。其前身为国际管理会计师协会。IFMA一贯秉承的宗旨是：推动财务管理全球化，研究和推广全球适用的财务管理职业知识体系和认证标准，为各国培养现代企业管理所必需的...","clickTimes":4314,"type":1,"meta":"资讯"}]
     * totalPageSize : 6
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
        private int totalPageSize;
        /**
         * picture : /upload/eduplat/article/20151009/1444373151796912992.jpg
         * id : 32
         * author : 中国总会计师协会
         * createTime : 2015-10-09 14:46:42
         * title : 多屏学习 学习时间由你掌控
         * updateTime : 2015-10-09 14:55:00
         * description : ·手机、Ipad、电脑三屏合一
         ·课程考点重点多屏学习 随时随地学习好轻松
         ·考点浓缩，高频考题、考点切片分析，保证效率最大化，只讲考试关键点，去掉冗余内容，只取精华



         当今社会，科学技术迅猛发展，信息知识获取的渠道、效率和便捷程度越来 越受到人们的关注。为了适应社会的发展，人们的求知思维也在不断变化，终身学习这一观点己被普遍接受。

         在信息技术迅速发展的当今社会，我们的学习不...
         * clickTimes : 1444
         * type : 1
         * meta : 资讯
         */

        private List<ArticleListBean> articleList;

        public int getTotalPageSize() {
            return totalPageSize;
        }

        public void setTotalPageSize(int totalPageSize) {
            this.totalPageSize = totalPageSize;
        }

        public List<ArticleListBean> getArticleList() {
            return articleList;
        }

        public void setArticleList(List<ArticleListBean> articleList) {
            this.articleList = articleList;
        }

        public static class ArticleListBean {
            private String picture;
            private int id;
            private String author;
            private String createTime;
            private String title;
            private String updateTime;
            private String description;
            private int clickTimes;
            private int type;
            private String meta;

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getClickTimes() {
                return clickTimes;
            }

            public void setClickTimes(int clickTimes) {
                this.clickTimes = clickTimes;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getMeta() {
                return meta;
            }

            public void setMeta(String meta) {
                this.meta = meta;
            }
        }
    }
}
