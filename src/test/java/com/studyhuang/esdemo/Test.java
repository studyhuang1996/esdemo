package com.studyhuang.esdemo;

import com.studyhuang.esdemo.entity.User;
import com.studyhuang.esdemo.repository.EsRepositoryImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author huang1996
 * @date 2021-01-30 23:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private EsRepositoryImpl<User, String> repository;


    @org.junit.Test
    public void test01() throws Exception {

        User user = new User("23232","huang");
        repository.save(user);
    }
}
