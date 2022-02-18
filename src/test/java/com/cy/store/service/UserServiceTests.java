package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


//@SpringBootTest：表示当前的类是测试类
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {
    // IDEA有检测的功能，接口是不能直接创建Bean的（动态代理）
    @Autowired
    private IUserService userService;
    /**
     * 0.必须被@Test修饰
     * 1.返回类型为void
     * 2.方法参数列表不指定任何类型
     * 3.方法修饰符为public
     */

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("user04");
            user.setPassword("123456");
            userService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login(){
        User user = userService.login("demo00","123");
        System.out.println(user);
    }
    @Test
    public void changePassword(){
        userService.changePassword(3,"demo00","123","1234");
    }
    @Test
    public void getByUid() {
        try {
            Integer uid = 3;
            User user = userService.getByUid(uid);
            System.out.println(user);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void changeInfo() {
        try {
            Integer uid = 3;
            String username = "demo00";
            User user = new User();
            user.setPhone("15512328888");
            user.setEmail("admin03@cy.cn");
            user.setGender(2);
            userService.changeInfo(uid, username, user);
            System.out.println("OK.");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
