package com.lewis.tsp.vo;

import java.util.List;

/**
 * Created by zhangminghua on 2016/5/24.
 */
public class SimpleAddressVo {

    private String forbiddenOrPermit;

    private List<String> ipPortList;

    public String getForbiddenOrPermit() {
        return forbiddenOrPermit;
    }

    public void setForbiddenOrPermit(String forbiddenOrPermit) {
        this.forbiddenOrPermit = forbiddenOrPermit;
    }

    public List<String> getIpPortList() {
        return ipPortList;
    }

    public void setIpPortList(List<String> ipPortList) {
        this.ipPortList = ipPortList;
    }
}
