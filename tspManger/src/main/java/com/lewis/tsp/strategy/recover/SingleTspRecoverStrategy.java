package com.lewis.tsp.strategy.recover;

import com.lewis.tsp.strategy.PermitStrategy;
import com.lewis.tsp.tspManger.TSPManager;
import com.lewis.tsp.vo.TspOperation;
import com.lewis.tsp.vo.config.IpPortConfig;
import org.apache.commons.lang3.StringUtils;
import java.util.List;

/**
 * Created by zhangminghua on 2016/5/25.
 * 单个服务的恢复策略
 */
public class SingleTspRecoverStrategy implements PermitStrategy {

    String tspName;

    public SingleTspRecoverStrategy(String tspName) {
        this.tspName = tspName;
    }

    public void permit() {
        if (StringUtils.isNotEmpty(tspName)) {
            List<String> allIpPortList = IpPortConfig.getAllIpPortList();
            try {
                TSPManager.forbiddenOrPermitTspOfBatchAtSingleTsp(tspName,allIpPortList, TspOperation.PERMISSION);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
