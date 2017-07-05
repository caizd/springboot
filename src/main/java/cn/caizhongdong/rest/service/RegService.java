package cn.caizhongdong.rest.service;

import cn.caizhongdong.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by caizhongdong on 2017/7/5.
 */
@Service()
public class UserService {
    @Autowired
    private UserMapper userMapper;


}