package com.lewis.tsp.vo;

import com.lewis.tsp.vo.config.TSPNameConfig;
import java.util.List;

/**
 * Created by zhangminghua on 2016/6/2.
 */
public enum ServiceTypeEnum {
    PRICE(TSPNameConfig.getPriceAllowTspNameList()),
    PRODUCT(TSPNameConfig.getProductAllowTspNameList()),
    RESOURCE(TSPNameConfig.getResourceAllowTspNameList()),
    UNVARNISH_TRANSMISSION(TSPNameConfig.getUnVarnishAllowTransmissionTspNameList());
    ServiceTypeEnum(List<String> tspNameList) {
        this.tspNameList = tspNameList;
    }

    private List<String> tspNameList;

    public List<String> getTspNameList() {
        return tspNameList;
    }

    @Override
    public String toString() {
        return "ServiceTypeEnum{" +
                "tspNameList=" + tspNameList +
                '}';
    }
}
