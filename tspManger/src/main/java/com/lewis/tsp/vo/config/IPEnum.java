package com.lewis.tsp.vo.config;


import java.util.List;

/**
 * Created by zhangminghua on 2016/5/28.
 */
public enum IPEnum {
    IP_62(IpPortConfig.getIpPortAt62List()),
    IP_63(IpPortConfig.getIpPortAt63List()),
    IP_64(IpPortConfig.getIpPortAt64List()),
    IP_40(IpPortConfig.getIpPortAt40List()),
    IP_46(IpPortConfig.getIpPortAt46List()),
    IP_96(IpPortConfig.getIpPortAt96List()),
    IP_209(IpPortConfig.getIpPortAt209List());

    IPEnum(List<String> ipPortList) {
        this.ipPortList = ipPortList;
    }

    private List<String> ipPortList;

    public List<String> getIpPortList() {
        return ipPortList;
    }

    @Override
    public String toString() {
        return "IPEnum{" +
                "ipPortList=" + ipPortList +
                '}';
    }
}
