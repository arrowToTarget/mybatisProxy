package com.lewis.tsp.strategy.serviceSplit;

import com.lewis.tsp.strategy.factory.StrategyFactory;
import com.lewis.tsp.tspManger.TSPManager;
import com.lewis.tsp.vo.ServiceType;
import com.lewis.tsp.vo.TspOperation;
import com.lewis.tsp.vo.config.IpPortConfig;
import com.lewis.tsp.vo.config.TSPNameConfig;

/**
 * Created by zhangminghua on 2016/6/1.
 * 产品拆分
 */
public class ProductServiceSplit {

    //在40、46服务器上禁用 价格、资源、接口透传服务，在62、63、64、 96/209上禁用产品服务
    public static void forbidden(){
        try {
            //在40、46服务器上禁用 价格、资源、接口透传服务
            StrategyFactory.createServiceSplitTypeStrategy(ServiceType.PRODUCT).forbidden();
            //在62、63、64、 96/209上禁用产品服务
            TSPManager.forbiddenOrPermitTspOfBatch(TSPNameConfig.getProductAllowTspNameList(), IpPortConfig.getProductForbiddenIpPortList(), TspOperation.FORBIDDEN);
        } catch (Exception e) {

        }
    }

    //在40、46服务器上恢复 价格、资源、接口透传服务，在62、63、64、 96/209上恢复产品服务
    public static void permit(){
        try {
            //在40、46上恢复产品、资源、透传服务
            TSPManager.forbiddenOrPermitTspOfBatch(TSPNameConfig.getProductForbiddenTspNameList(),IpPortConfig.getProductAllowedIpPortList(), TspOperation.PERMISSION);

            //在62、63、64、 96/209上恢复产品服务
            TSPManager.forbiddenOrPermitTspOfBatch(TSPNameConfig.getPriceAllowTspNameList(),IpPortConfig.getProductForbiddenIpPortList(), TspOperation.PERMISSION);
        } catch (Exception e) {

        }
    }


}
