package com.lewis.tsp.vo;

import com.lewis.tsp.util.Base64Util;
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

    public static final Map<String,ServiceTypeEnum> name2ServiceTypeEnumMap = new HashMap<String, ServiceTypeEnum>();

    public static final String  configPath ="D:/java/sourceCode/mybatisProxy/tspManger/src/config.properties";

    //查询TSP服务的地址列表信息的URL
    public static final String URL_GET_TSP_IP_LIST ="aHR0cDovL3B1YmxpYy1hcGkuYmoucGxhLnR1bml1Lm9yZy90c2cvcmVnaXN0ZXIvc2VydmljZS9hZGRyZXNzL3F1ZXJ5";

    //禁用、启用TSP服务的URL
    public static final String URL_POST_FORBIDDEN="aHR0cDovL3B1YmxpYy1hcGkuYmoucGxhLnR1bml1Lm9yZy90c2cvcmVnaXN0ZXIvcHJvdmlkZXIvY29uZmln";

    //批量禁用、启用TSP服务的URL
    public static final String URL_POST_FORBIDDEN_BATCH ="aHR0cDovL3B1YmxpYy1hcGkuYmoucGxhLnR1bml1Lm9yZy90c2cvcmVnaXN0ZXIvcHJvdmlkZXIvYmF0Y2gvY29uZmln";


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

    public static String getConfigPath() {
        return configPath;
    }

    public static Map<String, ServiceTypeEnum> getName2ServiceTypeEnumMap() {
        return name2ServiceTypeEnumMap;
    }

    static {
        name2ServiceTypeEnumMap.put(Constants.PRICE_IP,ServiceTypeEnum.PRICE);
        name2ServiceTypeEnumMap.put(Constants.PRODUCT_IP,ServiceTypeEnum.PRODUCT);
        name2ServiceTypeEnumMap.put(Constants.RESOURCE_IP,ServiceTypeEnum.RESOURCE);
        name2ServiceTypeEnumMap.put(Constants.UNVARNISH_TRANSIMISSION_IP,ServiceTypeEnum.UNVARNISH_TRANSMISSION);
    }

}
