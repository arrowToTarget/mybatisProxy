package com.lewis.tsp.strategy.serviceSplit;

import com.lewis.tsp.strategy.factory.StrategyFactory;
import com.lewis.tsp.tspManger.TSPManager;
import com.lewis.tsp.vo.ServiceType;
import com.lewis.tsp.vo.TspOperation;
import com.lewis.tsp.vo.config.IpPortConfig;
import com.lewis.tsp.vo.config.TSPNameConfig;

/**
 * Created by zhangminghua on 2016/6/1.
 * 资源拆分
 */
public class ResourceServiceSplit {

    public static void forbidden(){
        try {
            //在96上禁用价格、产品、接口透传服务
            StrategyFactory.createServiceSplitTypeStrategy(ServiceType.RESOURCE).forbidden();
            //在62、63、64、40、46、209上禁用资源服务
            TSPManager.forbiddenOrPermitTspOfBatch(TSPNameConfig.getResourceAllowTspNameList(), IpPortConfig.getResourceForbiddenIpPortList(), TspOperation.FORBIDDEN);
        } catch (Exception e) {

        }
    }

    //在96服务器上恢复 价格、资源、接口透传服务，在62、63、64、40、46、209上恢复产品服务
    public static void permit(){
        try {
            //在96上恢复产品、价格、透传服务
            TSPManager.forbiddenOrPermitTspOfBatch(TSPNameConfig.getResourceForbiddenTspNameList(),IpPortConfig.getResourceAllowedIpPortList(), TspOperation.PERMISSION);

            //在62、63、64、40、46、209上恢复资源服务
            TSPManager.forbiddenOrPermitTspOfBatch(TSPNameConfig.getResourceAllowTspNameList(),IpPortConfig.getResourceForbiddenIpPortList(), TspOperation.PERMISSION);
        } catch (Exception e) {

        }
    }
}
