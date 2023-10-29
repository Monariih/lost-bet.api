package com.lostbet.dao;

import com.lostbet.DataBaseConfiguration;
import com.lostbet.entity.User;
import com.lostbet.util.DataBaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDAO {

    @Autowired
    private DataBaseConfiguration dataBaseConfiguration;

    public User updateUser(Long cpf, User user) throws SQLException {

        PreparedStatement prepStat = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            conn = DataBaseConnection.getDataSource(dataBaseConfiguration).getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append(
                "UPDATE userdata SET userbalance = ? WHERE userCpf = ?"
            );

            prepStat = conn.prepareStatement(sql.toString());

            prepStat.setDouble(1, user.getBalance());
            prepStat.setLong(2, cpf);

            prepStat.execute();

            return user;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
            }
            if (prepStat != null) {
                try {
                    prepStat.close();
                } catch (Exception e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
    }
    public User getUser(Long cpf) throws SQLException {

        PreparedStatement prepStat = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            conn = DataBaseConnection.getDataSource(dataBaseConfiguration).getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT userCpf, userName, userEmail, userPassword, userBalance FROM userdata WHERE userCpf = (?)");

            prepStat = conn.prepareStatement(sql.toString());

            prepStat.setLong(1, cpf);

            rs = prepStat.executeQuery();

            User user = new User();

            rs.next();
            user.setCpf(rs.getLong("userCpf"));
            user.setName(rs.getString("userName"));
            user.setEmail(rs.getString("userEmail"));
            user.setPassword(rs.getString("userPassword"));
            user.setBalance(rs.getDouble("userBalance"));

            return user;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
            }
            if (prepStat != null) {
                try {
                    prepStat.close();
                } catch (Exception e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public List<User> getAllUsers() throws SQLException {

        PreparedStatement prepStat = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            conn = DataBaseConnection.getDataSource(dataBaseConfiguration).getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT * FROM userdata ");

            prepStat = conn.prepareStatement(sql.toString());

            rs = prepStat.executeQuery();

            List<User> users = new ArrayList<User>();

            while (rs.next()) {
                User user = new User();
                user.setCpf(rs.getLong("userCpf"));
                user.setName(rs.getString("userName"));
                user.setEmail(rs.getString("userEmail"));
                user.setPassword(rs.getString("userPassword"));
                user.setBalance(rs.getDouble("userBalance"));
                users.add(user);
            }

            return users;

        } catch (Exception e){
            e.printStackTrace();
            try {
                throw e;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            if (rs != null){
                try {
                    rs.close();
                }catch (Exception e){
                }
            }
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
