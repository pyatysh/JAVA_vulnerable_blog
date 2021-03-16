package com.javaAPI.blog_V3.userManagement;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO{

    private final DataSource dataSource;
//    probably, we don't need em - check it!
    private final EntityManager em;

    public UserDAO(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

        public List<UserDTO> unsafeFindUserByUsername(String username, String password) {

            String sql = "SELECT " + "username, password FROM User WHERE username = '" + username + "'" +
                         "AND password = '" + password + "'";


            try (Connection c = dataSource.getConnection();
                 ResultSet rs = c.createStatement()
                         .executeQuery(sql)) {
                List<UserDTO> accounts = new ArrayList<>();
                while (rs.next()) {
                    UserDTO acc = UserDTO.builder()
                            .username(rs.getString("username"))
                            .password(rs.getString("password"))
                            .build();

                    accounts.add(acc);
                }

                return accounts;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
}
