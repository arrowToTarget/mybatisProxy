package com.lewis.tsp.strategy.factory;

import com.lewis.tsp.strategy.*;
import com.lewis.tsp.strategy.forbidden.ServiceSpitTypeStrategy;
import com.lewis.tsp.strategy.forbidden.SingleTspMultiIpPortStrategy;
import com.lewis.tsp.strategy.forbidden.SingleTspSingleIpPortStrategy;
import com.lewis.tsp.strategy.recover.AllServiceRecoverStrategy;
import com.lewis.tsp.strategy.recover.ServiceSplitTypeRecoverStrategy;
import com.lewis.tsp.strategy.recover.SingleTspRecoverStrategy;
import com.lewis.tsp.vo.ServiceType;
import java.util.List;

/**
 * Created by zhangminghua on 2016/5/24.
 */
public final class StrategyFactory {

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

    public static PermitStrategy createSingleTspRecoverStrategy(String tspName){
        return new SingleTspRecoverStrategy(tspName);
    }

    public static PermitStrategy createServiceSplitTypeRecoverStrategy(ServiceType serviceType){
        return new ServiceSplitTypeRecoverStrategy(serviceType);
    }


}
