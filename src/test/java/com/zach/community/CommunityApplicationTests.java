package com.zach.community;

import com.zach.community.mapper.UserMapper;
import com.zach.community.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

@SpringBootTest
class CommunityApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {

        User user = new User();
        user.setAccountId("admin");
        user.setName("管理员");
        user.setToken(UUID.randomUUID().toString());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        int i = userMapper.addUser(user);
        System.out.println(i);

    }

}
