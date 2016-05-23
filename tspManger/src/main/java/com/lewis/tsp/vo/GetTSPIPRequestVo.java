package com.lewis.tsp.vo;

/**
 * Created by zhangminghua on 2016/5/23.
 */
public class GetTSPIPRequestVo {

    private String uid = "2846";

    private String token;

    private String nicknam="彭绍康";

    private double r =0.24894067785880736;

    private String name;

    private int start = 0;

    private int limit = 1000;

    private String sortname;

    private String sortorder;

    public GetTSPIPRequestVo() {
    }

    @Override
    public String toString() {
        return "GetTSPIPRequestVo{" +
                "uid='" + uid + '\'' +
                ", token='" + token + '\'' +
                ", nicknam='" + nicknam + '\'' +
                ", r=" + r +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", limit=" + limit +
                ", sortname='" + sortname + '\'' +
                ", sortorder='" + sortorder + '\'' +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNicknam() {
        return nicknam;
    }

    public void setNicknam(String nicknam) {
        this.nicknam = nicknam;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
    }

    public String getSortorder() {
        return sortorder;
    }

    public void setSortorder(String sortorder) {
        this.sortorder = sortorder;
    }

    public GetTSPIPRequestVo(String name) {
        this.name = name;
    }
}
