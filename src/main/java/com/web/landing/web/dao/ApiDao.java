package com.web.landing.web.dao;

import com.web.landing.web.vos.ContactVo;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class ApiDao {
    public void contact(Connection connection, ContactVo contactVo) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO `landing`.`contact`(contact_name, contact_email, contact_message) VALUES ((?,?,?))")) {
            preparedStatement.setString(1, contactVo.getName());
            preparedStatement.setString(2, contactVo.getEmail());
            preparedStatement.setString(3, contactVo.getMessage());    
        }
    }
}
