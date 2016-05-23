package com.lewis.tsp.vo;

/**
 * Created by zhangminghua on 2016/5/23.
 */
public class TspProviderVo {

    private String providerAddress;

    private int loadBalanceWeight ;

    private int ableFlag;

    private String region;

    private int maxConcurrency;

    private String vgroups;

    private String vgroupNames;

    private String sessionAddress;

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    public int getLoadBalanceWeight() {
        return loadBalanceWeight;
    }

    public void setLoadBalanceWeight(int loadBalanceWeight) {
        this.loadBalanceWeight = loadBalanceWeight;
    }

    public int getAbleFlag() {
        return ableFlag;
    }

    public void setAbleFlag(int ableFlag) {
        this.ableFlag = ableFlag;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getMaxConcurrency() {
        return maxConcurrency;
    }

    public void setMaxConcurrency(int maxConcurrency) {
        this.maxConcurrency = maxConcurrency;
    }

    public String getVgroups() {
        return vgroups;
    }

    public void setVgroups(String vgroups) {
        this.vgroups = vgroups;
    }

    public String getVgroupNames() {
        return vgroupNames;
    }

    public void setVgroupNames(String vgroupNames) {
        this.vgroupNames = vgroupNames;
    }

    public String getSessionAddress() {
        return sessionAddress;
    }

    public void setSessionAddress(String sessionAddress) {
        this.sessionAddress = sessionAddress;
    }

    @Override
    public String toString() {
        return "TspProviderVo{" +
                "providerAddress='" + providerAddress + '\'' +
                ", loadBalanceWeight=" + loadBalanceWeight +
                ", ableFlag=" + ableFlag +
                ", region='" + region + '\'' +
                ", maxConcurrency=" + maxConcurrency +
                ", vgroups='" + vgroups + '\'' +
                ", vgroupNames='" + vgroupNames + '\'' +
                ", sessionAddress='" + sessionAddress + '\'' +
                '}';
    }
}
