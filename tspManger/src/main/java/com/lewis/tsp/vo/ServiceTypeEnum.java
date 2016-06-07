package com.lewis.tsp.vo;

import com.lewis.tsp.vo.config.TSPNameConfig;
import java.util.List;

/**
 * Created by zhangminghua on 2016/6/2.
 */
public enum ServiceTypeEnum {
    PRICE(Constants.PRICE_IP,TSPNameConfig.getPriceAllowTspNameList()),
    PRODUCT(Constants.PRODUCT_IP,TSPNameConfig.getProductAllowTspNameList()),
    RESOURCE(Constants.RESOURCE_IP,TSPNameConfig.getResourceAllowTspNameList()),
    UNVARNISH_TRANSMISSION(Constants.UNVARNISH_TRANSIMISSION_IP,TSPNameConfig.getUnVarnishAllowTransmissionTspNameList());
    ServiceTypeEnum(String name,List<String> tspNameList) {
        this.name = name;
        this.tspNameList = tspNameList;
    }

    private List<String> tspNameList;

    private String name;

    public List<String> getTspNameList() {
        return tspNameList;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ServiceTypeEnum{" +
                "tspNameList=" + tspNameList +
                ", name='" + name + '\'' +
                '}';
    }
}
