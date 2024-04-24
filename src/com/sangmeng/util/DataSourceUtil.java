package com.sangmeng.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sangmeng.entity.DataSourceEntity;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceUtil {
    /**
     * dbcp
     * @param dse
     * @return
     * 通过DataSourceEntity实体类对BasicDataSource进行配置，从而获取相应的数据源
     */
    public static DataSource getDataSourceByDBPC(DataSourceEntity dse) throws SQLException {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername(dse.getUsername());
        ds.setPassword(dse.getPassword());
        ds.setUrl(dse.getUrl());
        ds.setDriverClassName(dse.getDriverName());
        ds.setMaxActive(dse.getMaxActive());
        ds.setMaxIdle(dse.getMinIdle());
        ds.setMaxWait(dse.getIntalSize());
        return ds;
    }

    /**
     * dbpc
     * @param filename
     * @return  DataSource
     * 通过以properties为后缀的文件对BasicDataSourceFactory进行配置，从而返回相应的数据源
     */
    public static DataSource getDataSourceByDBPCAndFile(String filename) {
        Properties prop = new Properties();
        try {
            prop.load(new DataSourceUtil().getClass().getClassLoader().getResourceAsStream(filename));
            return  BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * c3p0
     * @param dse
     * @return DataSource
     * 通过DataSource实体类内所包含的参数对ComboPooledDataSource进行配置，从而返回一个数据源
     */
    public static DataSource getDataSourceByC3P0(DataSourceEntity dse) {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setUser(dse.getUsername());
        ds.setPassword(dse.getPassword());
        ds.setJdbcUrl(dse.getUrl());
        ds.setMaxPoolSize(dse.getMaxActive());
        ds.setMinPoolSize(dse.getMinIdle());
        ds.setInitialPoolSize(dse.getIntalSize());
        ds.setMaxIdleTime(dse.getTimeout());
        return  ds;
    }

    /**
     * c3p0
     * @param name
     * @return DataSource
     * 根据c3p0-config.xml文件中的制定的配置信息进行配置，从而返回一个数据源
     */
    public static DataSource getDataSourceByC3P0AndName(String name){
        return new ComboPooledDataSource(name);
    }
}
