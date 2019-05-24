package com.cskaoyan.malladmin.bean.stat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author:ZCH
 * @Date:2019/5/23 20:16
 */
public class CountVo {
    private String[] columns;
    private List<Map> rows;

    public CountVo() {
    }

    public CountVo(String[] columns, List<Map> rows) {
        this.columns = columns;
        this.rows = rows;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public List<Map> getRows() {
        return rows;
    }

    public void setRows(List<Map> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "CountVo{" +
                "columns=" + Arrays.toString(columns) +
                ", rows=" + rows +
                '}';
    }
}
