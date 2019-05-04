package com.rawbit.codegen.db;

import com.google.common.collect.ImmutableMap;
import com.rawbit.codegen.util.DBType;

/**
 * Different database types to java types map
 * Yuanlin.bao 2019-05-04
 */
public class DB2JavaDataType {

    /**
     * see mysql connector-j-reference
     * https://docs.oracle.com/cd/E17952_01/connector-j-en/connector-j-reference-type-conversions.html
     */
    private static final ImmutableMap<String, String> MYSQL_JAVA_DATA_TYPE_MAP = new ImmutableMap.Builder<String, String>()
            .put("BIT", "Boolean")
            .put("TINYINT", "Integer")
            .put("TINYINT UNSIGNED", "Integer")
            .put("SMALLINT", "Integer")
            .put("SMALLINT UNSIGNED", "Integer")
            .put("MEDIUMINT", "Integer")
            .put("MEDIUMINT UNSIGNED", "Long")
            .put("INT", "Integer")
            .put("INT UNSIGNED", "Long")
            .put("INTEGER", "Integer")
            .put("INTEGER UNSIGNED", "Long")
            .put("BIGINT", "Long")
            .put("BIGINT UNSIGNED", "BigInteger")
            .put("FLOAT", "Float")
            .put("DOUBLE", "Double")
            .put("DECIMAL", "BigDecimal")
            .put("DATE", "Date")
            .put("DATETIME", "Date")
            .put("TIMESTAMP", "Date")
            .put("TIME", "Date")
            .put("YEAR", "Date")
            .put("CHAR", "String")
            .put("VARCHAR", "String")
            .put("BINARY", "byte[]")
            .put("VARBINARY", "byte[]")
            .put("BLOB", "byte[]")
            .put("TINYBLOB", "byte[]")
            .put("MEDIUMBLOB", "byte[]")
            .put("LONGBLOB", "byte[]")
            .build();

    /**
     * see prostgresql connector-j-reference
     *
     */
    private static final ImmutableMap<String, String> POSTGRESQL_JAVA_DATA_TYPE_MAP = new ImmutableMap.Builder<String, String>()
            .put("BIT", "Boolean")
            .put("TINYINT", "Integer")
            .put("SMALLINT", "Integer")
            .put("SMALLINT UNSIGNED", "Integer")
            .put("MEDIUMINT", "Integer")
            .put("MEDIUMINT UNSIGNED", "Long")
            .put("INT", "Integer")
            .put("INTEGER", "Integer")
            .put("INT UNSIGNED", "Long")
            .put("INTEGER UNSIGNED", "Long")
            .put("BIGINT", "Long")
            .put("BIGINT UNSIGNED", "BigInteger")
            .put("FLOAT", "Float")
            .put("DOUBLE", "Double")
            .put("DECIMAL", "BigDecimal")
            .put("DATE", "Date")
            .put("DATETIME", "Date")
            .put("TIMESTAMP", "Date")
            .put("TIME", "Date")
            .put("YEAR", "Date")
            .put("CHAR", "String")
            .put("VARCHAR", "String")
            .put("BINARY", "byte[]")
            .put("VARBINARY", "byte[]")
            .put("BLOB", "byte[]")
            .put("TINYBLOB", "byte[]")
            .put("MEDIUMBLOB", "byte[]")
            .put("LONGBLOB", "byte[]")
            .build();

    public static String getJavaType(DBType dbType, String dataType) {

        if (DBType.MYSQL == dbType) {
            return MYSQL_JAVA_DATA_TYPE_MAP.get(dataType);
        }

        if (DBType.POSTGRESQL == dbType) {
            return MYSQL_JAVA_DATA_TYPE_MAP.get(dataType);
        }

        return null;
    }
}
