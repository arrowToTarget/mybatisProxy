package com.lewis.tsp.strategy;

import com.lewis.tsp.tspManger.OperationTspService;
import com.lewis.tsp.vo.AppSplitConfigVo;
import com.lewis.tsp.vo.config.ServiceConfig;

/**
 * Created by zhangminghua on 2016/5/24.
 */
public class AllServiceRecoverStrategy implements PermitStrategy {

    public void permit() {
        AppSplitConfigVo allServiceRecoverAppSplitConfig = ServiceConfig.getAllServiceRecoverAppSplitConfig();
        OperationTspService.permitTspService(allServiceRecoverAppSplitConfig);
    }
}
