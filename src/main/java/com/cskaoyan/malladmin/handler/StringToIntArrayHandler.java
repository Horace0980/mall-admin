package com.cskaoyan.malladmin.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Dankin
 * @Date: 2019/5/23 14:47
 */
public class StringToIntArrayHandler extends BaseTypeHandler<int[]> {

  @Override
  public void setNonNullParameter(PreparedStatement preparedStatement, int index, int[] ints, JdbcType jdbcType) throws SQLException {
    StringBuffer sb = new StringBuffer();
    for (int id:ints) {
      sb.append("[").append(id).append("]");
    }
    String substring = sb.toString().substring(sb.length() - 1);
    System.out.println(substring);
    preparedStatement.setString(index,substring);
  }

  @Override
  public int[] getNullableResult(ResultSet resultSet, String columnLabel) throws SQLException {
    String string = resultSet.getString(columnLabel);
    return leisiwole(string);
  }

  @Override
  public int[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
    String string = resultSet.getString(i);
    return leisiwole(string);
  }

  @Override
  public int[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
    String string = callableStatement.getString(i);

    return leisiwole(string);
  }

  public int[] leisiwole(String string){
    String s = string.replace("[", "");
    String s1 = s.replace("]", "");
    String[] split = s1.split("");
    int length = split.length;
    int[] m = new int[length];
    for (int i = 0; i < length; i++) {
      m[i] = Integer.parseInt(split[i]);
    }
    return m;
  }
}
