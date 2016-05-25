package com.lewis.tsp.strategy.recover;

import com.lewis.tsp.strategy.PermitStrategy;
import com.lewis.tsp.strategy.forbidden.OperationTspService;
import com.lewis.tsp.vo.AppSplitConfigVo;
import com.lewis.tsp.vo.config.ServiceConfig;

/**
 * Created by zhangminghua on 2016/5/24.
 * 所有服务的恢复策略
 */
public class AllServiceRecoverStrategy implements PermitStrategy {

    public void permit() {
        AppSplitConfigVo allServiceRecoverAppSplitConfig = ServiceConfig.getAllServiceRecoverAppSplitConfig();
        OperationTspService.permitTspService(allServiceRecoverAppSplitConfig);
    }
}
