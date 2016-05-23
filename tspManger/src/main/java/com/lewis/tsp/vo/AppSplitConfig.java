package com.lewis.tsp.vo;

import java.util.List;

public class AppSplitConfig {

    //应用服务类型
    private ServiceType serviceType;
    //允许的地址列表
    private List<String> allowIpPortList;
    //禁止的服务列表
    private List<String> forbiddenIpPortList;
    //服务名称列表
    private List<String> tspNameList;

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<String> getAllowIpPortList() {
        return allowIpPortList;
    }

    public void setAllowIpPortList(List<String> allowIpPortList) {
        this.allowIpPortList = allowIpPortList;
    }

    public List<String> getTspNameList() {
        return tspNameList;
    }

    public void setTspNameList(List<String> tspNameList) {
        this.tspNameList = tspNameList;
    }

    public AppSplitConfig() {
    }

    public List<String> getForbiddenIpPortList() {
        return forbiddenIpPortList;
    }

    public void setForbiddenIpPortList(List<String> forbiddenIpPortList) {
        this.forbiddenIpPortList = forbiddenIpPortList;
    }

    @Override
    public String toString() {
        return "AppSplitConfig{" +
                "serviceType=" + serviceType +
                ", allowIpPortList=" + allowIpPortList +
                ", forbiddenIpPortList=" + forbiddenIpPortList +
                ", tspNameList=" + tspNameList +
                '}';
    }

    public AppSplitConfig(ServiceType serviceType, List<String> allowIpPortList, List<String> forbiddenIpPortList, List<String> tspNameList) {
        this.serviceType = serviceType;
        this.allowIpPortList = allowIpPortList;
        this.forbiddenIpPortList = forbiddenIpPortList;
        this.tspNameList = tspNameList;
    }


}
