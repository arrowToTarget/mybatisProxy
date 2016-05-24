package com.lewis.tsp.strategy.factory;

import com.lewis.tsp.strategy.*;
import com.lewis.tsp.vo.ServiceType;
import java.util.List;

/**
 * Created by zhangminghua on 2016/5/24.
 */
public final class StrategyFactory {

    private StrategyFactory(){

    }

    public static PermitForbiddenStrtegy createSingleTspSingleIpPortStrategy(String tspName, String ipPort){

        return new SingleTspSingleIpPortStrategy(tspName,ipPort);
    }

    public static PermitForbiddenStrtegy createSingleTspMultiIpPortStrategy(String tspName, List<String> ipPortList){

        return new SingleTspMultiIpPortStrategy(tspName,ipPortList);
    }

    public static PermitForbiddenStrtegy createServiceSplitTypeStrategy(ServiceType serviceType){

        return new ServiceSpitTypeStrategy(serviceType);
    }

    public static PermitStrategy createAllServiceRecoverStrategy(){

        return new AllServiceRecoverStrategy();
    }


}
