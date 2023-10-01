package com.lostbet.util;

import com.lostbet.DataBaseConfiguration;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class DataBaseConnection {
    private static DataSource dataSource;

    public static DataSource getDataSource(DataBaseConfiguration configuration){

        if (dataSource == null){
            BasicDataSource dataSourceBasic = new BasicDataSource();

            dataSourceBasic.setDriverClassName(configuration.getDriverClassName());

            dataSourceBasic.setUsername(configuration.getUsername());

            dataSourceBasic.setPassword(configuration.getPassword());

            dataSourceBasic.setUrl(configuration.getUrl());


            dataSource = dataSourceBasic;

            return dataSource;

        } else {

            return dataSource;

        }
    }
}
