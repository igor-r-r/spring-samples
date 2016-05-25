package com.shulyaq.spring.mapper;

import com.shulyaq.spring.model.Info;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoRowMapper implements RowMapper<Info>{
    public Info mapRow(ResultSet resultSet, int i) throws SQLException {
        Info info = new Info();
//        info.setInfo();
        return info;
    }
}
