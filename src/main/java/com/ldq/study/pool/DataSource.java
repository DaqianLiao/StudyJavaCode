package com.ldq.study.pool;

import java.sql.Connection;

public interface DataSource {

    Connection getConnection();

    void releaseConnection(Connection conn);
}
