package com.web.landing.web.services;

import com.web.landing.web.dao.ApiDao;
import com.web.landing.web.vos.ContactVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class ApiService {
    private final ApiDao apiDao;
    private final DataSource dataSource;

    @Autowired
    public ApiService(ApiDao apiDao, DataSource dataSource) {
        this.apiDao = apiDao;
        this.dataSource = dataSource;
    }

    public void contact(ContactVo contactVo) throws SQLException {
        try (Connection connection = this.dataSource.getConnection()) {
            this.apiDao.contact(connection, contactVo);
        }
    }
}
