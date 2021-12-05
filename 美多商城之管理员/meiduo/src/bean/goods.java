package bean;//

// Created by Chenglong Shi on 2021/11/30.
// Only can use to study
// Once found commercial or illegal use will be pursued to the end
// Banning plagiarism
// Email:2230307855@qq.com
// 内部可能含有拼音和汉语注释
// by 史成龙
// 方法：
//
public class goods {
    private int gid;
    private String gname;
    private double gprice;
    private String gdate;
    public double getGprice() {
        return gprice;
    }
    public int getGid() {
        return gid;
    }
    public String getGdate() {
        return gdate;
    }
    public String getGname() {
        return gname;
    }
    public void setGdate(String gdate) {
        this.gdate = gdate;
    }
    public void setGid(int gid) {
        this.gid = gid;
    }
    public void setGname(String gname) {
        this.gname = gname;
    }
    public void setGprice(double gprice) {
        this.gprice = gprice;
    }
}
