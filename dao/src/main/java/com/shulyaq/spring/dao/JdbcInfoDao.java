package com.shulyaq.spring.dao;

import com.shulyaq.spring.model.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcInfoDao {
    private static final String ABOUT_SQL = "select * from info where type = 'about'";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Info getAboutInfo() {
        return null;
    }
}
