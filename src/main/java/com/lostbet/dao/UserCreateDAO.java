package com.lostbet.dao;

import com.lostbet.DataBaseConfiguration;
import com.lostbet.entity.UserCreate;
import com.lostbet.util.DataBaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class UserCreateDAO {

    @Autowired
    private DataBaseConfiguration dataSourceConfiguration;


    public Long createUser(UserCreate user) throws Exception{

        PreparedStatement prepStat;
        prepStat = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            conn = DataBaseConnection.getDataSource(dataSourceConfiguration).getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append(
                    "INSERT INTO userdata (userCpf,userName,userEmail,userPassword,userBalance) VALUES (?,?,?,?,?)"
            );

            prepStat = conn.prepareStatement(sql.toString(), Statement.NO_GENERATED_KEYS);

            prepStat.setLong(1, user.getCpf());

            prepStat.setString(2, user.getName());

            prepStat.setString(3, user.getEmail());

            prepStat.setString(4, user.getPassword());

            prepStat.setDouble(5, user.getBalance());

            prepStat.execute();

            return user.getCpf();

        } catch (Exception e) {
            throw e;
        } finally {
            if (prepStat != null) {
                try {
                    prepStat.close();
                } catch (Exception e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e){
                }
            }
        }
    }
}
