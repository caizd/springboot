package cn.caizhongdong.rest.service;

import cn.caizhongdong.entity.User;
import cn.caizhongdong.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by caizhongdong on 2017/7/5.
 */
@Service()
public class UserService {
    @Autowired
    private UserMapper userMapper;
@Cacheable
public User getUserById(String userId){
    User user =  userMapper.findUserByUserid(userId);
    return user;
}
}