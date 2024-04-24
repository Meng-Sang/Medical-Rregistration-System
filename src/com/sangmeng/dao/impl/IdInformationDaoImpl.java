package com.sangmeng.dao.impl;

import com.sangmeng.dao.IdInformationDao;
import com.sangmeng.entity.DataSourceEntity;
import com.sangmeng.entity.IdInformation;
import com.sangmeng.util.DataSourceUtil;
import com.sangmeng.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class IdInformationDaoImpl implements IdInformationDao {

    @Override
    public IdInformation queryByUsername(String username) {
        IdInformation idInformation = null;
        QueryRunner runner = new QueryRunner();
        String sql = "select * from idinformations where username=?";
        try {
            Connection conn = JDBCUtil.getConnection();
            idInformation=runner.query(conn,sql, new BeanHandler<IdInformation>(IdInformation.class),new Object[]{username});
        } catch (SQLException e) {
            return idInformation;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return idInformation;
    }

    @Override
    public int update(IdInformation idInformation,String sql,Object...objs) {
        QueryRunner runner = new QueryRunner();
        int result = 1;
        try {
            Connection conn = JDBCUtil.getConnection();
            runner.execute(conn,sql,objs);
        } catch (SQLException e) {
            e.printStackTrace();
            return -result;
        }
        return result;
    }
}
