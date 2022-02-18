package com.cy.store.mapper;

import com.cy.store.entity.User;

import java.util.Date;

/**
 * 用户模块的持久层接口
 */
public interface UserMapper {
    Integer insert(User user);
    User findByUsername(String username);
    Integer updatePasswordByUid(Integer uid, String password, String modifiedUser, Date modifiedTime);
    User findByUid(Integer uid);
    Integer updateInfoByUid(User user);
}
