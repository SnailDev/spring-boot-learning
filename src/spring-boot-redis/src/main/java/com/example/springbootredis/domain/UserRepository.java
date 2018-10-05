package com.example.springbootredis.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: ming.zhao
 * @Date: 2018-10-05 21:02
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserName(String userName);
}
