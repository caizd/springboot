package cn.caizhongdong.rest.service;

import cn.caizhongdong.domain.User;
import cn.caizhongdong.util.HttpclientUtil;
import cn.caizhongdong.weixin.WxEncryptedData;
import cn.caizhongdong.weixin.WxUserInfoJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caizhongdong on 2017/7/12.
 */
@Service()
public class LoginService {
    private @Value("${appId}")
    String appid;
    private @Value("${appSecret}")
    String appSecret;
    private static final Logger log = LoggerFactory.getLogger(LoginService.class);
    @Autowired
    UserService service;

    public Map loginByCode(String code, WxEncryptedData data) {
        log.trace("login code：" + code);
        Map map = new HashMap();
        try {
            map = HttpclientUtil.getJson("https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=authorization_code");
            String session_key = String.valueOf(map.get("session_key"));
            WxUserInfoJson userInfo = data.decrypt(session_key);
            User user = userInfo.transToUser();
            service.saveUser(user);
            map.clear();
            map.put("openId", user.getOpenId());
        } catch (Exception e) {
            log.error("登陆失败", e);
        }
        return map;
    }
}
