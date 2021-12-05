package service;//

// Created by Chenglong Shi on 2021/11/30.
// Only can use to study
// Once found commercial or illegal use will be pursued to the end
// Banning plagiarism
// Email:2230307855@qq.com
// 内部可能含有拼音和汉语注释
// by 史成龙
// 方法：
//
import db_util.*;
import bean.*;

import java.util.ArrayList;

public class dbtest {
    public static void main(String[] args) {
        goods_tools gt=new goods_tools();
        people_tools pt=new people_tools();
//        查看
        ArrayList<goods> gl=gt.selectAllGoods();
        for(goods g:gl) System.out.println(g.getGid()+" "+g.getGname()+" "+g.getGprice()+" "+g.getGdate());
        //增加
//        goods newg=new goods();
//        newg.setGid(4); newg.setGname("苹果"); newg.setGprice(3.24); newg.setGdate("2021-11-30");
//        System.out.println(gt.addGoods(newg));
        //删除
//        System.out.println(gt.deleteGoods(4));
        //更新
//        System.out.println(gt.updateGoods(4,"苹果",4.0,"2021-11-30"));
        //
//        people p=pt.is_exist_people("11");
//        if(p==null) System.out.println("null");
    }
}
