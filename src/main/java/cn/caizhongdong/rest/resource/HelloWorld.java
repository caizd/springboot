package cn.caizhongdong.rest.resource;

//import cn.caizhongdong.rest.service.IRegService;
//import org.springframework.beans.factory.annotation.Autowired;

import cn.caizhongdong.entity.User;
import cn.caizhongdong.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Controller

public class HelloWorld {
    @Autowired
    private UserService service;

    @GET
    @Path("/{id}")
    public User getUserById(@PathParam("id") String id) {
        User user = service.getUserById(id);
        return user;
    }
    @PUT
    @Path("/")
    public User getUserById(User user) {
        User user1 = service.updateUserByUserid(user);
        return user1;
    }

}
