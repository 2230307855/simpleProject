package db;//

// Created by Chenglong Shi on 2021/11/30.
// Only can use to study
// Once found commercial or illegal use will be pursued to the end
// Banning plagiarism
// Email:2230307855@qq.com
// 内部可能含有拼音和汉语注释
// by 史成龙
// 方法：
//
import java.sql.*;
public class db_conn_destroy {
    private static final String MySQLDriver="com.mysql.cj.jdbc.Driver";
    private static final String MySQLURL="jdbc:mysql://localhost:3306/meiduo?characterEncoding=utf-8&serverTimezone=UTC&useSSL=true";
    private static final String UserName="root";
    private static final String Password="199911huiyi.";

    protected static Connection conn=null;
    protected static Statement sttmt=null;
    protected static ResultSet rs=null;
    //执行低效查询
    public static ResultSet lowQuery(String sql){
        try {
            sttmt=getConnection().createStatement();
            rs=sttmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    //高效的数据库查询
    public static PreparedStatement greatQuery(String sql){
        PreparedStatement pstt=null;
        try {
            pstt=getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstt;
    }
    //获得数据库的连接
    public static synchronized Connection getConnection(){
        try {
            Class.forName(MySQLDriver);
            try {
                conn= DriverManager.getConnection(MySQLURL,UserName,Password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
        return conn;
    }
    //回滚函数
    public static void rollback(){
        try {
            getConnection().rollback();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    //销毁数据库的连接
    public static void destroyConnection(){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(sttmt!=null){
            try {
                sttmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
