package cn.caizhongdong.mapper;

import cn.caizhongdong.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by caizhongdong on 2017/7/5.
 */
@Mapper
public interface UserMapper {
    @Select("select * from users where userId = #{userId}")
    User findUserByUserid(@Param("userId") String userId);
}
