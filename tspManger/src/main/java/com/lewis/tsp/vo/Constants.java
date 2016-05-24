package com.lewis.tsp.vo;

/**
 * Created by zhangminghua on 2016/5/23.
 */
public final class Constants {

    private Constants(){}

    public static final String SERVICE_TPYE_PRICE ="price";

    public static final String SERVICE_TPYE_PRODUCT ="product";

    public static final String SERVICE_TPYE_RESOURCE ="resource";

    public static final String SERVICE_TPYE_VARNISH_TRANSMISSION ="varnish-transmission";

    public static final String SERVICE_TPYE_ALL_SERVICE = "all-service";

    //查询TSP服务的地址列表信息的URL
    public static final String URL_GET_TSP_IP_LIST ="http://public-api.bj.pla.tuniu.org/tsg/register/service/address/query";

    //禁用、启用TSP服务的URL
    public static final String URL_POST_FORBIDDEN="http://public-api.bj.pla.tuniu.org/tsg/register/provider/config";

    //批量禁用、启用TSP服务的URL
    public static final String URL_POST_FORBIDDEN_BATCH ="http://public-api.bj.pla.tuniu.org/tsg/register/provider/batch/config";


    public static String getServiceTpyePrice() {
        return SERVICE_TPYE_PRICE;
    }

    public static String getServiceTpyeProduct() {
        return SERVICE_TPYE_PRODUCT;
    }

    public static String getServiceTpyeResource() {
        return SERVICE_TPYE_RESOURCE;
    }

    public static String getServiceTpyeVarnishTransmission() {
        return SERVICE_TPYE_VARNISH_TRANSMISSION;
    }

    public static String getUrlGetTspIpList() {
        return URL_GET_TSP_IP_LIST;
    }

    public static String getUrlPostForbidden() {
        return URL_POST_FORBIDDEN;
    }

    public static String getUrlPostForbiddenBatch() {
        return URL_POST_FORBIDDEN_BATCH;
    }

    public static String getServiceTpyeAllService() {
        return SERVICE_TPYE_ALL_SERVICE;
    }

}
