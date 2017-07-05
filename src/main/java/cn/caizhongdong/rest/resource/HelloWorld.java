package cn.caizhongdong.rest.resource;

//import cn.caizhongdong.rest.service.IRegService;
//import org.springframework.beans.factory.annotation.Autowired;
import cn.caizhongdong.entity.User;
import cn.caizhongdong.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/sample")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Controller

public class HelloWorld {
    @Autowired
    private UserService service;

    @GET
    @Path("/hello")
    public User getUserById() {
        User user = service.getUserById("123");
        return user;
    }

}
