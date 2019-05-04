package com.rawbit.codegen.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {


    private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    private static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String POSTGRESQL_DRIVER = "org.postgresql.Driver";

    // load all db driver at initialization
    static {
        try {
            Class.forName(MYSQL_DRIVER);
            // Class.forName(ORACLE_DRIVER);
            // Class.forName(POSTGRESQL_DRIVER);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(DBType dbType, String host, String port, String db, String username, String password) throws SQLException {

        String url;

        switch (dbType) {
            case MYSQL:
                url = String.format("jdbc:mysql://%s:%s/%s", host, port, db);
                break;
            case ORACLE:
                url = String.format("jdbc:oracle:thin:@%s:%s:%s", host, port, db);
                break;
            case POSTGRESQL:
                url = String.format("jdbc:postgresql://%s:%s/%s", host, port, db);
                break;
            default:
                System.out.println("Error dbType");
                return null;
        }
        return DriverManager.getConnection(url, username, password);
    }
}
