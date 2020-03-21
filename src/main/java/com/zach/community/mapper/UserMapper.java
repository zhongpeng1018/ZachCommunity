package com.zach.community.mapper;

import com.zach.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zach - 吸柒
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user(account_id,name,token,create_time,update_time) values(#{accountId},#{name},#{token},#{createTime},#{updateTime})")
    int addUser(User user);

    @Select("select * from user where account_id = #{accountId}")
    User findByAccountId(String accountId);

    @Select("select * from user where token = #{token}")
    User findByToken(String token);
}
