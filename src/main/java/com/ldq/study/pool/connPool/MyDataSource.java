package com.ldq.study.pool.connPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;

public class MyDataSource implements DataSource {
    //链表 --- 实现栈结构
    private LinkedList<Connection> dataSources = new LinkedList<Connection>();

    //初始化连接数量
    public MyDataSource() {
        //一次性创建10个连接
        for (int i = 0; i < 10; i++) {
            try {
                //1、装载sqlserver驱动对象
//                DriverManager.registerDriver(new SQLServerDriver());
                //2、通过JDBC建立数据库连接
                Connection con = DriverManager.getConnection(
                        "jdbc:sqlserver://localhost:3306;DatabaseName=customer", "root", "mysqlroot");
                //3、将连接加入连接池中
                dataSources.add(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized Connection getConnection() {
        return dataSources.removeFirst();
    }

    @Override
    public void releaseConnection(Connection conn) {
        dataSources.add(conn);
    }
}
