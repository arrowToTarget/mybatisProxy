package com.lewis.tsp.strategy.serviceSplit;

import com.lewis.tsp.strategy.factory.StrategyFactory;
import com.lewis.tsp.tspManger.TSPManager;
import com.lewis.tsp.vo.ServiceType;
import com.lewis.tsp.vo.TspOperation;
import com.lewis.tsp.vo.config.IpPortConfig;
import com.lewis.tsp.vo.config.TSPNameConfig;

/**
 * Created by zhangminghua on 2016/6/1.
 * 接口透传服务拆分
 */
public class UnVarnishTransmissionServiceSplit {

    public static void forbidden(){
        try {
            //在209上禁用产品、价格、资源服务
            StrategyFactory.createServiceSplitTypeStrategy(ServiceType.VARNISH_TRANSMISSION).forbidden();

            //在62.63.64.40.46.96上禁用接口透传服务
            TSPManager.forbiddenOrPermitTspOfBatch(TSPNameConfig.getUnVarnishAllowTransmissionTspNameList(), IpPortConfig.getUnVarnishTransmissionForbiddenIpPortList(), TspOperation.FORBIDDEN);
        } catch (Exception e) {

        }
    }

    ////在209上恢复产品、价格、资源服务，在62.63.64.40.46.96上恢复接口透传服务
    public static void permit(){
        try {
            //在209上恢复产品、价格、资源服务
            TSPManager.forbiddenOrPermitTspOfBatch(TSPNameConfig.getUnVarnishTransmissionForbiddenTspNameList(),IpPortConfig.getUnVarnishTransmissionAllowedIpPortList(), TspOperation.PERMISSION);

            //在62.63.64.40.46.96上恢复接口透传服务
            TSPManager.forbiddenOrPermitTspOfBatch(TSPNameConfig.getUnVarnishAllowTransmissionTspNameList(),IpPortConfig.getUnVarnishTransmissionForbiddenIpPortList(), TspOperation.PERMISSION);
        } catch (Exception e) {

        }
    }
}
