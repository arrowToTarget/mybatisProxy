package com.lewis.tsp.vo;

/**
 * Created by zhangminghua on 2016/5/23.
 */
public class TspOperationRequsetVo {

    private String uid = "2846";

    private String token;

    private String nickname ="彭绍康";

    private double r = 0.8663694023776364;

    private String name;

    private String providerAddress;

    //1启用 2禁用
    private int forbidOper;

    @Override
    public String toString() {
        return "TspOperationRequsetVo{" +
                "uid='" + uid + '\'' +
                ", token='" + token + '\'' +
                ", nickname='" + nickname + '\'' +
                ", r=" + r +
                ", name='" + name + '\'' +
                ", providerAddress='" + providerAddress + '\'' +
                ", forbidOper=" + forbidOper +
                '}';
    }

    public TspOperationRequsetVo() {
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    public int getForbidOper() {
        return forbidOper;
    }

    public void setForbidOper(int forbidOper) {
        this.forbidOper = forbidOper;
    }
}
