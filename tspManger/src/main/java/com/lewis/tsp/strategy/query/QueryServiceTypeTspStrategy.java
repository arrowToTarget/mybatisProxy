package com.lewis.tsp.strategy.query;

import com.lewis.tsp.tspManger.TSPManager;
import com.lewis.tsp.vo.QueryResultVo;
import com.lewis.tsp.vo.ServiceType;
import java.util.List;

/**
 * Created by zhangminghua on 2016/5/25.
 * 按照服务类型查询Tsp信息
 */
public class QueryServiceTypeTspStrategy {

    public static List<QueryResultVo> queryPriceServiceTypeTsp() {
        List<QueryResultVo> queryResultVos = TSPManager.queryTspProviderInfoByServiceType(ServiceType.PRICE);
        return queryResultVos;
    }

    public static List<QueryResultVo> queryProductServiceTypeTsp() {
        List<QueryResultVo> queryResultVos = TSPManager.queryTspProviderInfoByServiceType(ServiceType.PRODUCT);
        return queryResultVos;
    }

    public static List<QueryResultVo> queryResourceServiceTypeTsp() {
        List<QueryResultVo> queryResultVos = TSPManager.queryTspProviderInfoByServiceType(ServiceType.RESOURCE);
        return queryResultVos;
    }

    public static List<QueryResultVo> queryUnVarnishTransmissionServiceTypeTsp() {
        List<QueryResultVo> queryResultVos = TSPManager.queryTspProviderInfoByServiceType(ServiceType.VARNISH_TRANSMISSION);
        return queryResultVos;
    }

    public static List<QueryResultVo> queryAllServiceTypeTsp() {
        List<QueryResultVo> queryResultVos = TSPManager.queryTspProviderInfoByServiceType(ServiceType.ALL_SERVICE);
        return queryResultVos;
    }
}
