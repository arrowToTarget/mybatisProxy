package com.lewis.tsp.tspManger;


import com.alibaba.fastjson.JSON;
import com.lewis.tsp.strategy.PermitForbiddenStrtegy;
import com.lewis.tsp.strategy.factory.StrategyFactory;
import com.lewis.tsp.vo.QueryResultVo;
import com.lewis.tsp.vo.config.IpPortConfig;
import com.lewis.tsp.vo.config.TSPNameConfig;

public class TSPManagerClient {

    public static void main(String[] args) throws Exception {

        String tspName = "BOH.NM.ProductController.baokuanProduct";

      /*  PermitForbiddenStrtegy singleTspSingleIpPortStrategy = StrategyFactory.createSingleTspSingleIpPortStrategy(tspName, "10.40.50.62:12501");

        singleTspSingleIpPortStrategy.permit();*/
        PermitForbiddenStrtegy singleTspMultiIpPortStrategy = StrategyFactory.createSingleTspMultiIpPortStrategy(tspName, IpPortConfig.getIpPortAt40List());
        singleTspMultiIpPortStrategy.forbidden();

        QueryResultVo queryResultVo = TSPManager.queryTspProviderInfo(tspName);
        System.out.println(JSON.toJSONString(queryResultVo));

    }
}
