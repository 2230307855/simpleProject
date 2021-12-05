package db_util;//

// Created by Chenglong Shi on 2021/11/30.
// Only can use to study
// Once found commercial or illegal use will be pursued to the end
// Banning plagiarism
// Email:2230307855@qq.com
// 内部可能含有拼音和汉语注释
// by 史成龙
// 方法：
//
import bean.goods;
import dao.my_goodsDao;
import db.db_conn_destroy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class goods_tools implements my_goodsDao{
    @Override
    public int addGoods(goods gd) {
        boolean k = true;
        PreparedStatement psmt=null;
        String sql="insert into goods (gid,gname,gprice,gdate) values (?,?,?,?)";
        psmt= db_conn_destroy.greatQuery(sql);
        try {
            psmt.setInt(1,gd.getGid());
            psmt.setString(2,gd.getGname());
            psmt.setDouble(3,gd.getGprice());
            psmt.setString(4,gd.getGdate());
            k=psmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            psmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(k){
            System.out.println("failed!");
            return 0;
        }
        else {
            System.out.println("ok!");
            return 1;
        }
    }

    @Override
    public ArrayList<goods> selectAllGoods() {
        ArrayList<goods> list=new ArrayList<goods>();
        String sql="select * from goods";
        ResultSet rs=null;
        rs=db_conn_destroy.lowQuery(sql);
        try{
            while(rs.next()){
                goods gd=new goods();
                gd.setGid(rs.getInt(1));
                gd.setGname(rs.getString(2));
                gd.setGprice(rs.getDouble(3));
                gd.setGdate(rs.getString(4));
                list.add(gd);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        db_conn_destroy.destroyConnection();
        return list;
    }

    @Override
    public int deleteGoods(int gid) {
        int result=0;
        String sql="delete from goods where gid=?";
        PreparedStatement psttmt=db_conn_destroy.greatQuery(sql);
        try {
            psttmt.setInt(1,gid);
            result=psttmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            psttmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result==0){
            System.out.println("failed!");
            return 0;
        }
        else{
            System.out.println("ok!");
            return 1;
        }
    }

    @Override
    public boolean updateGoods(int gid,String name,double price,String date1) {
        int re=0;
        String sql="update goods set gname=?,gprice=?,gdate=? where gid=?";
        PreparedStatement psttmt=db_conn_destroy.greatQuery(sql);
        try {
            psttmt.setString(1,name);
            psttmt.setDouble(2,price);
            psttmt.setString(3,date1);
            psttmt.setInt(4,gid);
            re=psttmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            psttmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(re==0) {
            System.out.println("failed!");
            return false;
        }
        else {
            System.out.println("ok!");
            return true;
        }
    }
}
