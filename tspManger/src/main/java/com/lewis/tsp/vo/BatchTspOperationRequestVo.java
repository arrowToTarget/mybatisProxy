package com.lewis.tsp.vo;

import java.util.List;

/**
 * Created by zhangminghua on 2016/5/23.
 */
public class BatchTspOperationRequestVo {

    private String uid = "2846";

    private String token;

    private String nickname ="彭绍康";

    private double r = 0.8663694023776364;

    private List<TspName2ProviderAddress> providerList;
    //1启用 2禁用
    private int forbidOper;

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

    public List<TspName2ProviderAddress> getProviderList() {
        return providerList;
    }

    public void setProviderList(List<TspName2ProviderAddress> providerList) {
        this.providerList = providerList;
    }

    public int getForbidOper() {
        return forbidOper;
    }

    public void setForbidOper(int forbidOper) {
        this.forbidOper = forbidOper;
    }

    @Override
    public String toString() {
        return "BatchTspOperationRequestVo{" +
                "uid='" + uid + '\'' +
                ", token='" + token + '\'' +
                ", nickname='" + nickname + '\'' +
                ", r=" + r +
                ", providerList=" + providerList +
                ", forbidOper=" + forbidOper +
                '}';
    }

    public static class TspName2ProviderAddress{

        private String name;

        private String providerAddress;

        public TspName2ProviderAddress(String name, String providerAddress) {
            this.name = name;
            this.providerAddress = providerAddress;
        }

        public String getProviderAddress() {
            return providerAddress;
        }

        public void setProviderAddress(String providerAddress) {
            this.providerAddress = providerAddress;
        }

        public String getName() {

            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public TspName2ProviderAddress() {

        }


        @Override
        public String toString() {
            return "TspName2ProviderAddress{" +
                    "name='" + name + '\'' +
                    ", providerAddress='" + providerAddress + '\'' +
                    '}';
        }
    }


}
