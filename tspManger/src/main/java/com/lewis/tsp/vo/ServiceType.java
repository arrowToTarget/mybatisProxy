package com.lewis.tsp.vo;

/**
 * Created by zhangminghua on 2016/5/23.
 */
public enum ServiceType {
    PRICE(Constants.SERVICE_TPYE_PRICE),
    PRODUCT(Constants.SERVICE_TPYE_PRODUCT),
    RESOURCE(Constants.SERVICE_TPYE_RESOURCE),
    VARNISH_TRANSMISSION(Constants.SERVICE_TPYE_VARNISH_TRANSMISSION),
    ALL_SERVICE(Constants.SERVICE_TPYE_ALL_SERVICE);
    ServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    private String serviceType;

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
