package com.rawbit.codegen.db;

import java.util.ArrayList;
import java.util.List;

public class TableInfo {

    private String name;
    private String primaryKey;
    private List<TableField> fieldList = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public List<TableField> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<TableField> fieldList) {
        this.fieldList = fieldList;
    }
}
