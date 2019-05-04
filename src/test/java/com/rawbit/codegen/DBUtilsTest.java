package com.rawbit.codegen;

import com.rawbit.codegen.util.ConnectionFactory;
import com.rawbit.codegen.util.DBType;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class DBUtilsTest {

    // http://www.java2s.com/Code/Java/Database-SQL-JDBC/GetColumnSize.htm

    public static void main(String[] args) throws Exception {

        Connection conn = ConnectionFactory.getConnection(DBType.MYSQL, "127.0.0.1", "3306", "test", "root", "test");

        // ((OracleConnection)conn).setRemarksReporting(true);

        System.out.println("Got Connection.");
        //Statement st = conn.createStatement();

        DatabaseMetaData meta = conn.getMetaData();

        ResultSet rsColumns = meta.getColumns(null, null, "tuser", null);
        while (rsColumns.next()) {
            String columnName = rsColumns.getString("COLUMN_NAME");
            System.out.printf("column name : %s\t\t", columnName);

            String columnType = rsColumns.getString("TYPE_NAME");
            System.out.printf("type : %s\t\t", columnType);

            String comment = rsColumns.getString("REMARKS");
            System.out.printf("comments : %s\n", comment);

        }
        conn.close();
    }
}
