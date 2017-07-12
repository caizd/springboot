package cn.caizhongdong.rest.service;

import cn.caizhongdong.domain.User;
import cn.caizhongdong.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.beans.Transient;

/**
 * Created by caizhongdong on 2017/7/5.
 */
@Service()
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //    @Cacheable(value = "user", key="123")
//    public User getUserById(String userId) {
//        User user = userMapper.findUserByUserid(userId);
//        return user;
//    }
    @Cacheable(value = "user", key = "#openId")
    public User getUserByOpenId(String openId) {
        User user = userMapper.getUserByOpenId(openId);
        return user;
    }

    //    @CachePut(value = "user", key="123")
//    public User updateUserByUserid(User user){
//        int count = userMapper.updateUserByUserid(user.getName(),user.getUserId());
//        if(count>0){
//            return user;
//        }
//        return null;
//    }
    @CachePut(value = "user", key = "#user.openId")
    @Transient
    public User saveUser(User user) {
        User user1 = userMapper.getUserByOpenId(user.getOpenId());
        if (user1 == null) {
            userMapper.saveUser(user);
        }
        return user;
    }

}