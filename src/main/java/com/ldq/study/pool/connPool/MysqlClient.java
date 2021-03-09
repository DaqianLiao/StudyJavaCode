package com.ldq.study.pool.connPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlClient {

    //查询所有用户
    public static void FindAllUsers() throws SQLException {
        //1、使用连接池建立数据库连接
        MyDataSource dataSource = new MyDataSource();
        Connection conn =dataSource.getConnection();
        //2、创建状态
        Statement state =conn.createStatement();
        //3、查询数据库并返回结果
        ResultSet result =state.executeQuery("select * from address");
        //4、输出查询结果
        while(result.next()){
            System.out.println(result.getString("email"));
        }
        //5、断开数据库连接
        result.close();
        state.close();
        //6、归还数据库连接给连接池
        dataSource.releaseConnection(conn);
    }

    public static void main(String[] args) throws SQLException {
        FindAllUsers();
    }
}
