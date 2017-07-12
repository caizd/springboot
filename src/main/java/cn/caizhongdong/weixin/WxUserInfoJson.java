package cn.caizhongdong.weixin;

import cn.caizhongdong.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 微信获取用户信息解密后的数据
 *
 * @author du
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WxUserInfoJson {
    public String openId;
    public String nickName;
    /**
     * 性别 0：未知、1：男、2：女
     */
    public Integer gender; //
    public String city;
    public String province;
    public String country;
    public String avatarUrl;
    public String unionId;
    public Watermark watermark;

    public User transToUser() {
        User wx = new User();

        wx.setOpenId(this.openId);
        wx.setNickName(this.nickName);
        wx.setGender(this.gender);
        wx.setCity(this.city);
        wx.setProvince(this.province);
        wx.setCountry(this.country);
        wx.setAvatarUrl(this.avatarUrl);
        wx.setUnionId(this.unionId);
        return wx;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Watermark {
    public String appid;
}