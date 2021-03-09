package com.ldq.study.pool.connPool;

import java.sql.Connection;

public interface DataSource {

    Connection getConnection();

    void releaseConnection(Connection conn);
}
