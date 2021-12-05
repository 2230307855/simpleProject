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
import bean.people;
import dao.my_peopleDao;
import db.db_conn_destroy;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class people_tools implements my_peopleDao {
    @Override
    public people is_exist_people(String pid) {
        people p=null;
        PreparedStatement pstt=null;
        String sql="select ppassword from people where pid=?";
        pstt= db_conn_destroy.greatQuery(sql);
        try {
            pstt.setString(1,pid);
            ResultSet rs=pstt.executeQuery();
            while(rs.next()){
                String password=rs.getString(1);
                p=new people();
                p.setPid(pid);
               p.setPpassword(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
}
