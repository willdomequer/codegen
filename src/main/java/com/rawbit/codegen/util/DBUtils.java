package com.rawbit.codegen.util;

import com.rawbit.codegen.db.DB2JavaDataType;
import com.rawbit.codegen.db.TableField;
import com.rawbit.codegen.db.TableInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

    private static final Logger logger = LoggerFactory.getLogger(DBUtils.class);

    public static List<TableInfo> getTableInfo(DBType dbType, String host, String port, String db,
                                               List<String> tableList, String user, String password) {

        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection(dbType, host, port, db, user, password);
            DatabaseMetaData meta = conn.getMetaData();

            List<TableInfo> tableInfoList = new ArrayList<>();

            for (String table : tableList) {

                TableInfo tableInfo = new TableInfo();
                tableInfo.setName(table);
                List<TableField> fieldList = new ArrayList<>();
                tableInfo.setFieldList(fieldList);

                ResultSet rs = meta.getPrimaryKeys(null, null, table.toUpperCase());
                if (rs.next()) {
                    String pk = rs.getString("COLUMN_NAME");
                    tableInfo.setPrimaryKey(pk);
                }

                ResultSet rsColumns = meta.getColumns(null, null, table, null);
                while (rsColumns.next()) {
                    TableField field = new TableField();

                    String columnName = rsColumns.getString("COLUMN_NAME");
                    field.setName(toCamelStyle(columnName));
                    // 去除下划线

                    String columnType = rsColumns.getString("TYPE_NAME");
                    field.setDataType(DB2JavaDataType.getJavaType(dbType, columnType));

                    String comment = rsColumns.getString("REMARKS");
                    field.setComment(comment);

                    fieldList.add(field);
                }
                tableInfoList.add(tableInfo);
            }
            return tableInfoList;
        }
        catch (NullPointerException | SQLException e) {
            if (e instanceof NullPointerException) {
                logger.error("Failed to get DatabaseMetaData for " + dbType.getDesc(), e);
            } else {
                logger.warn("Failled in DBUtils.getTableInfo()", e);
            }
            return null;
        }
        finally {
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String toCamelStyle(String field) {

        String[] strArray = field.split("[-_]");
        if (strArray.length < 2) {
            return field;
        }

        String result = strArray[0];
        for (int i = 1; i < strArray.length; i++) {

            String res = strArray[i].substring(1);
            String firstChar = strArray[i].substring(0, 1).toUpperCase();
            result += firstChar + res;
        }
        return result;
    }
}
