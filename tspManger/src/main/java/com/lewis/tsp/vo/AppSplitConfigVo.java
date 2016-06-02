package com.lewis.tsp.vo;

import java.util.List;

public class AppSplitConfigVo {

    //应用服务类型
    private ServiceType serviceType;
    //允许的地址列表
    private List<String> allowIpPortList;
    //禁止的服务列表
    private List<String> forbiddenIpPortList;
    //服务名称列表
    private List<String> allowTspNameList;

    private List<String> forbiddenTspNameList;

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


    public AppSplitConfigVo() {
    }

    public List<String> getForbiddenIpPortList() {
        return forbiddenIpPortList;
    }

    public void setForbiddenIpPortList(List<String> forbiddenIpPortList) {
        this.forbiddenIpPortList = forbiddenIpPortList;
    }

    public List<String> getAllowTspNameList() {
        return allowTspNameList;
    }

    public void setAllowTspNameList(List<String> allowTspNameList) {
        this.allowTspNameList = allowTspNameList;
    }

    public List<String> getForbiddenTspNameList() {
        return forbiddenTspNameList;
    }

    public void setForbiddenTspNameList(List<String> forbiddenTspNameList) {
        this.forbiddenTspNameList = forbiddenTspNameList;
    }

    @Override
    public String toString() {
        return "AppSplitConfigVo{" +
                "serviceType=" + serviceType +
                ", allowIpPortList=" + allowIpPortList +
                ", forbiddenIpPortList=" + forbiddenIpPortList +
                ", allowTspNameList=" + allowTspNameList +
                ", forbiddenTspNameList=" + forbiddenTspNameList +
                '}';
    }

    public AppSplitConfigVo(ServiceType serviceType, List<String> allowIpPortList, List<String> forbiddenIpPortList, List<String> allowTspNameList, List<String> forbiddenTspNameList) {
        this.serviceType = serviceType;
        this.allowIpPortList = allowIpPortList;
        this.forbiddenIpPortList = forbiddenIpPortList;
        this.allowTspNameList = allowTspNameList;
        this.forbiddenTspNameList = forbiddenTspNameList;
    }

}
