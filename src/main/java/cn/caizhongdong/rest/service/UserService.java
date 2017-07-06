package cn.caizhongdong.rest.service;

import cn.caizhongdong.entity.User;
import cn.caizhongdong.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by caizhongdong on 2017/7/5.
 */
@Service()
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "user", key="123")
    public User getUserById(String userId) {
        User user = userMapper.findUserByUserid(userId);
        return user;
    }
    @CachePut(value = "user", key="123")
    public User updateUserByUserid(User user){
        int count = userMapper.updateUserByUserid(user.getName(),user.getUserId());
        if(count>0){
            return user;
        }
        return null;
    }

}