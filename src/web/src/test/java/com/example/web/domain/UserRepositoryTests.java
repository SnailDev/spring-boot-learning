package com.example.web.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.util.Date;

/**
 * @Author: ming.zhao
 * @Date: 2018-10-03 21:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("aa1", "aa@gmail.com", "aa", "aa123456", formattedDate));
        userRepository.save(new User("bb1", "bb@gmail.com", "bb", "bb123456", formattedDate));
        userRepository.save(new User("cc1", "cc@gmail.com", "cc", "cc123456", formattedDate));

        Assert.assertEquals(3,userRepository.findAll().size());
        Assert.assertEquals("bb",userRepository.findByUserNameOrEmail("bb","bb@gmail.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa1"));
    }
}
