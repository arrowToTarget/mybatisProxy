package com.lewis.tsp.vo;

import com.lewis.tsp.vo.config.IPEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static final String PRICE_IP ="price_ip";
    public static final String PRODUCT_IP ="product_ip";
    public static final String UNVARNISH_TRANSIMISSION_IP ="unvarnish_transmission_ip";
    public static final String RESOURCE_IP ="resource_ip";

    public static final Map<ServiceTypeEnum,List<IPEnum>> serviceType2IpMap = new HashMap<ServiceTypeEnum, List<IPEnum>>();


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

    public static String getPriceIp() {
        return PRICE_IP;
    }

    public static String getProductIp() {
        return PRODUCT_IP;
    }

    public static String getUnvarnishTransimissionIp() {
        return UNVARNISH_TRANSIMISSION_IP;
    }

    public static String getResourceIp() {
        return RESOURCE_IP;
    }
}
