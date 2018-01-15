package cn.caizhongdong.mapper;

import cn.caizhongdong.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by caizhongdong on 2017/7/5.
 */
@Mapper
public interface UserMapper {
//    @Select("select * from users where userId = #{userId}")
//    User findUserByUserid(@Param("userId") String userId);
    User getUserByOpenId(@Param("openId") String openId);
//
    @Update("update users set nickName=#{name} where id = #{id}")
    int updateUserByUserid(@Param("name") String name,@Param("id") Integer id);

    int saveUser(User user);
}
