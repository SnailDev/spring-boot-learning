package com.example.web.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: ming.zhao
 * @Date: 2018-10-03 21:10
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String userName,String email);
}
