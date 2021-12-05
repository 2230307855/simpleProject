package dao;//

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
import java.util.ArrayList;
public interface my_goodsDao {
    public int addGoods(goods gd);
    public ArrayList<goods> selectAllGoods();
    public int deleteGoods(int gid);
    public boolean updateGoods(int gid,String name,double price,String date1);
}
