package com.studyhuang.esdemo.entity;

import com.studyhuang.esdemo.annotation.EsId;
import com.studyhuang.esdemo.annotation.EsIndex;

/**
 * @author huang1996
 * @date 2021-01-30 21:44
 */
@EsIndex(indexName = "user")
public class User {

    @EsId
    private String userId;

    private String userName;

    public User() {

    }

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
