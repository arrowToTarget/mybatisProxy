package com.lewis.tsp.vo;


/**
 * Created by zhangminghua on 2016/5/24.
 */
public class QueryResultVo {

    private String tspName;

    private SimpleAddressVo forbiddenAddresss;

    private SimpleAddressVo permitAddress;

    public QueryResultVo(String tspName, SimpleAddressVo forbiddenAddresss, SimpleAddressVo permitAddress) {
        this.tspName = tspName;
        this.forbiddenAddresss = forbiddenAddresss;
        this.permitAddress = permitAddress;
    }

    public String getTspName() {
        return tspName;
    }

    public void setTspName(String tspName) {
        this.tspName = tspName;
    }

    public SimpleAddressVo getForbiddenAddresss() {
        return forbiddenAddresss;
    }

    public void setForbiddenAddresss(SimpleAddressVo forbiddenAddresss) {
        this.forbiddenAddresss = forbiddenAddresss;
    }

    public SimpleAddressVo getPermitAddress() {
        return permitAddress;
    }

    public void setPermitAddress(SimpleAddressVo permitAddress) {
        this.permitAddress = permitAddress;
    }

    public QueryResultVo() {
    }
}
