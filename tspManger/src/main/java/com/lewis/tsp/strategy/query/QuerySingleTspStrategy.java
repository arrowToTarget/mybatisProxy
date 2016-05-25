package com.lewis.tsp.strategy.query;

import com.lewis.tsp.tspManger.TSPManager;
import com.lewis.tsp.vo.QueryResultVo;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by zhangminghua on 2016/5/25.
 * 查询单个tsp服务的策略
 */
public class QuerySingleTspStrategy {

    public static QueryResultVo querySingleTsp(String tspName) {
        if (StringUtils.isNotEmpty(tspName)) {
            QueryResultVo queryResultVo = null;
            try {
                queryResultVo = TSPManager.queryTspProviderInfo(tspName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return queryResultVo;
        }
        return null;
    }
}
