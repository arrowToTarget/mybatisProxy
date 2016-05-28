package com.lewis.tsp.strategy.forbidden;

import com.lewis.tsp.strategy.PermitForbiddenStrtegy;
import com.lewis.tsp.tspManger.TSPManager;
import com.lewis.tsp.vo.config.IPEnum;
import com.lewis.tsp.vo.TspOperation;
import com.lewis.tsp.vo.config.TSPNameConfig;

/**
 * Created by zhangminghua on 2016/5/28.
 * 单个机器所有服务的禁用和启用
 */
public class SimpleIpAllServiceStrategy implements PermitForbiddenStrtegy {

    private IPEnum ipEnum;

    public SimpleIpAllServiceStrategy(IPEnum ipEnum) {
        this.ipEnum = ipEnum;
    }

    public void forbidden() {
        try {
            TSPManager.forbiddenOrPermitTspOfBatch(TSPNameConfig.getAllServiceTspNameList(),this.ipEnum.getIpPortList(), TspOperation.FORBIDDEN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void permit() {
        try {
            TSPManager.forbiddenOrPermitTspOfBatch(TSPNameConfig.getAllServiceTspNameList(),this.ipEnum.getIpPortList(), TspOperation.PERMISSION);

        } catch (Exception e) {

        }
    }
}
