package com.rawbit.codegen.util;

/**
 * Define all supported RDBs
 * Yuanlin.bao 2019-05-04
 */
public enum DBType {

    MYSQL(1, "mysql"),
    ORACLE(2, "oracle"),
    POSTGRESQL(3, "postgresql");

    final int code;
    final String desc;

    private DBType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static DBType getByValue(int value) {
        for (DBType code : values()) {
            if (code.getCode() == value) {
                return code;
            }
        }
        return null;
    }
}
