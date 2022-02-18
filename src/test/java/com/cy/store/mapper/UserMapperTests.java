package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

//@SpringBootTest：表示当前的类是测试类
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {
    // IDEA有检测的功能，接口是不能直接创建Bean的（动态代理）
    @Autowired
    private UserMapper userMapper;
    /**
     * 0.必须被@Test修饰
     * 1.返回类型为void
     * 2.方法参数列表不指定任何类型
     * 3.方法修饰符为public
     */

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("user05");
        user.setPassword("123456");
        Integer rows = userMapper.insert(user);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUsername() {
        String username = "user05";
        User result = userMapper.findByUsername(username);
        System.out.println(result);
    }
    @Test
    public void updatePasswordByUid() {
        Integer uid = 1;
        String password = "654321";
        String modifiedUser = "普通管理员";
        Date modifiedTime = new Date();
        Integer rows = userMapper.updatePasswordByUid(uid, password, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUid() {
        Integer uid = 1;
        User result = userMapper.findByUid(uid);
        System.out.println(result);
    }

    @Test
    public void updateInfoByUid() {
        User user = new User();
        user.setUid(3);
        user.setPhone("17858802222");
        user.setEmail("admin@cy.com");
        user.setGender(1);
        user.setModifiedUser("系统管理员");
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        System.out.println("rows=" + rows);
    }

}
