package com.lizi.utils;
/*
 * @author lizi

 * @date  2020/7/10 17:50
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDataUtil {
    public static void main(String[] args) {
        Connection conn = JdbcDataUtil.getConn(
                "jdbc:mysql://localhost:3309/crm?characterEncoding=utf8&useSSL=false&zeroDateTimeBehavior=convertToNull&tinyInt1isBit=false",
                "root", "123456");
    }
    //链接数据库
    public static Connection getConn(String url, String username, String pwd){
        Connection conn=null;
        try {
            conn = DriverManager.getConnection(url,username,pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
            return conn;
    }


    //关闭数据库
    public static void closeConn(Connection conn){
        try {
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //将sql的执行结果返回成Object数组
    public static Object[][] getData(Connection conn, String query) {
        Object[][] data = null;

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();//sql是select的
            ResultSetMetaData meta = rs.getMetaData();//customer_name=sdfff,name=111
                                                      // customer_name=aaa,name=222
                                                      // customer_name=ccc
            int column = meta.getColumnCount();//得到查询结果为2列
            List<Object[]> list = new ArrayList<Object[]>();
            while (rs.next()) {
                Object[] oa = new Object[column];
                for (int i = 1; i <= column; i++) {
                    oa[i - 1] = rs.getObject(i);//分别得到customer_name=sdfff和name=111
                }
                list.add(oa);//list的每一行是一维数组，包含2个值
            }
            if (list.size() > 0) {
                data = new Object[list.size()][column];
                for (int i = 0; i < list.size(); i++) {
                    data[i] = list.get(i);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
    //executeUpdate方法可以执行新增、更新、删除三种sql语句
    public static int executeUpdate(Connection conn ,String sql){
        Statement stmt =null;
        try {
            stmt=conn.createStatement();
            stmt.executeUpdate(sql);
            int updateCount = stmt.getUpdateCount();//可以获取更新了多少条记录
            return updateCount;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }


}
