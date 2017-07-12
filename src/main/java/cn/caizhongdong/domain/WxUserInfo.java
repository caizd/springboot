package cn.caizhongdong.domain;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 微信获取用户信息解密后的数据
 *
 * @author du
 */
public class WxUserInfo implements Serializable {
    private static final long serialVersionUID = 4551851932988487317L;
    @JsonIgnore
    private String wxOpenId;
    private String nickName;
    /**
     * 性别 0：未知、1：男、2：女
     */
    private String language;
    private Integer sex; //
    private String city;
    private String province;
    private String country;
    private String headImgUrl;
    @JsonIgnore
    private String wxUnionId;
    @JsonIgnore
    private String appId;

    public WxUserInfo() {
    }

    public WxUserInfo(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getWxUnionId() {
        return wxUnionId;
    }

    public void setWxUnionId(String wxUnionId) {
        this.wxUnionId = wxUnionId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }


}