package com.ld_zxb.entity;

import java.io.Serializable;

/**
 * Created by 派大星 on 2016/6/2 0002.
 */
public class MineEntity implements Serializable{

    /**
     * message : 查询成功
     * success : true
     * entity : {"id":27604,"nickname":"","email":"1078952142@qq.com","emailIsavalible":0,"mobile":"13810250440","mobileIsavalible":0,"password":"40d628dc4880d42b93972c1e640d301b","isavalible":0,"customerkey":"","createdate":"2016-05-26 14:31:36","userip":"221.216.94.29","gender":0,"weiBoNum":0,"fansNum":0,"attentionNum":0,"msgNum":0,"sysMsgNum":0,"lastSystemTime":"2016-05-26 14:31:36","unreadFansNum":0,"showname":"1078952142@qq.com","userInfo":"","cusId":27604,"commonFriendNum":0,"friendId":0,"mutual":0,"cusNum":0,"current":0,"registerFrom":"appFrom","age":0,"marry":0,"provinceName":"","cityName":"","countyName":""}
     */

    private String message;
    private boolean success;
    /**
     * id : 27604
     * nickname :
     * email : 1078952142@qq.com
     * emailIsavalible : 0
     * mobile : 13810250440
     * mobileIsavalible : 0
     * password : 40d628dc4880d42b93972c1e640d301b
     * isavalible : 0
     * customerkey :
     * createdate : 2016-05-26 14:31:36
     * userip : 221.216.94.29
     * gender : 0
     * weiBoNum : 0
     * fansNum : 0
     * attentionNum : 0
     * msgNum : 0
     * sysMsgNum : 0
     * lastSystemTime : 2016-05-26 14:31:36
     * unreadFansNum : 0
     * showname : 1078952142@qq.com
     * userInfo :
     * cusId : 27604
     * commonFriendNum : 0
     * friendId : 0
     * mutual : 0
     * cusNum : 0
     * current : 0
     * registerFrom : appFrom
     * age : 0
     * marry : 0
     * provinceName :
     * cityName :
     * countyName :
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
        private int id;
        private String nickname;
        private String email;
        private int emailIsavalible;
        private String mobile;
        private int mobileIsavalible;
        private String password;
        private int isavalible;
        private String customerkey;
        private String createdate;
        private String userip;
        private int gender;
        private int weiBoNum;
        private int fansNum;
        private int attentionNum;
        private int msgNum;
        private int sysMsgNum;
        private String lastSystemTime;
        private int unreadFansNum;
        private String showname;
        private String userInfo;
        private int cusId;
        private int commonFriendNum;
        private int friendId;
        private int mutual;
        private int cusNum;
        private int current;
        private String registerFrom;
        private int age;
        private int marry;
        private String provinceName;
        private String cityName;
        private String countyName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getEmailIsavalible() {
            return emailIsavalible;
        }

        public void setEmailIsavalible(int emailIsavalible) {
            this.emailIsavalible = emailIsavalible;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getMobileIsavalible() {
            return mobileIsavalible;
        }

        public void setMobileIsavalible(int mobileIsavalible) {
            this.mobileIsavalible = mobileIsavalible;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getIsavalible() {
            return isavalible;
        }

        public void setIsavalible(int isavalible) {
            this.isavalible = isavalible;
        }

        public String getCustomerkey() {
            return customerkey;
        }

        public void setCustomerkey(String customerkey) {
            this.customerkey = customerkey;
        }

        public String getCreatedate() {
            return createdate;
        }

        public void setCreatedate(String createdate) {
            this.createdate = createdate;
        }

        public String getUserip() {
            return userip;
        }

        public void setUserip(String userip) {
            this.userip = userip;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getWeiBoNum() {
            return weiBoNum;
        }

        public void setWeiBoNum(int weiBoNum) {
            this.weiBoNum = weiBoNum;
        }

        public int getFansNum() {
            return fansNum;
        }

        public void setFansNum(int fansNum) {
            this.fansNum = fansNum;
        }

        public int getAttentionNum() {
            return attentionNum;
        }

        public void setAttentionNum(int attentionNum) {
            this.attentionNum = attentionNum;
        }

        public int getMsgNum() {
            return msgNum;
        }

        public void setMsgNum(int msgNum) {
            this.msgNum = msgNum;
        }

        public int getSysMsgNum() {
            return sysMsgNum;
        }

        public void setSysMsgNum(int sysMsgNum) {
            this.sysMsgNum = sysMsgNum;
        }

        public String getLastSystemTime() {
            return lastSystemTime;
        }

        public void setLastSystemTime(String lastSystemTime) {
            this.lastSystemTime = lastSystemTime;
        }

        public int getUnreadFansNum() {
            return unreadFansNum;
        }

        public void setUnreadFansNum(int unreadFansNum) {
            this.unreadFansNum = unreadFansNum;
        }

        public String getShowname() {
            return showname;
        }

        public void setShowname(String showname) {
            this.showname = showname;
        }

        public String getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(String userInfo) {
            this.userInfo = userInfo;
        }

        public int getCusId() {
            return cusId;
        }

        public void setCusId(int cusId) {
            this.cusId = cusId;
        }

        public int getCommonFriendNum() {
            return commonFriendNum;
        }

        public void setCommonFriendNum(int commonFriendNum) {
            this.commonFriendNum = commonFriendNum;
        }

        public int getFriendId() {
            return friendId;
        }

        public void setFriendId(int friendId) {
            this.friendId = friendId;
        }

        public int getMutual() {
            return mutual;
        }

        public void setMutual(int mutual) {
            this.mutual = mutual;
        }

        public int getCusNum() {
            return cusNum;
        }

        public void setCusNum(int cusNum) {
            this.cusNum = cusNum;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public String getRegisterFrom() {
            return registerFrom;
        }

        public void setRegisterFrom(String registerFrom) {
            this.registerFrom = registerFrom;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getMarry() {
            return marry;
        }

        public void setMarry(int marry) {
            this.marry = marry;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getCountyName() {
            return countyName;
        }

        public void setCountyName(String countyName) {
            this.countyName = countyName;
        }
    }
}
