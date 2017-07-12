package cn.caizhongdong.rest.resource;

import cn.caizhongdong.rest.service.LoginService;
import cn.caizhongdong.weixin.WxEncryptedData;
import cn.caizhongdong.weixin.WxUserInfoJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Controller

public class Login {
    @Autowired
    LoginService loginService;

    @POST
    @Path("/{code}")
    public Map getUserById(@PathParam("code") String code, WxEncryptedData data) throws Exception {

        Map map = loginService.loginByCode(code, data);

        return map;
    }
}
