package com.lewis.tsp.strategy.serviceSplit;

import com.lewis.tsp.strategy.factory.StrategyFactory;
import com.lewis.tsp.tspManger.TSPManager;
import com.lewis.tsp.vo.ServiceType;
import com.lewis.tsp.vo.TspOperation;
import com.lewis.tsp.vo.config.IpPortConfig;
import com.lewis.tsp.vo.config.TSPNameConfig;

/**
 * Created by zhangminghua on 2016/6/1.
 * 价格服务拆分
 */
public class PriceServiceSplit {

    //在62/63/64上禁用产品、资源、透传服务，在40、46、96、209上禁用价格服务
    public static void forbidden()  {
        try {
            // 在62/63/64上禁用产品、资源、透传服务
            StrategyFactory.createServiceSplitTypeStrategy(ServiceType.PRICE).forbidden();

            //在40、46、96、209上禁用价格服务
            TSPManager.forbiddenOrPermitTspOfBatch(TSPNameConfig.getPriceAllowTspNameList(),IpPortConfig.getPriceForbiddenIpPortList(), TspOperation.FORBIDDEN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //在62/63/64上恢复产品、资源、透传服务，在40、46、96、209上恢复价格服务
    public static void permit(){
        try {
            //在62/63/64上恢复产品、资源、透传服务
            TSPManager.forbiddenOrPermitTspOfBatch(TSPNameConfig.getPriceForbiddenTspNameList(),IpPortConfig.getPriceAllowedIpPortList(), TspOperation.PERMISSION);

            //在40、46、96、209上恢复价格服务
            TSPManager.forbiddenOrPermitTspOfBatch(TSPNameConfig.getPriceAllowTspNameList(),IpPortConfig.getPriceForbiddenIpPortList(), TspOperation.PERMISSION);
        } catch (Exception e) {

        }
    }


}
