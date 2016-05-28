package com.lewis.tsp.strategy.forbidden;

import com.lewis.tsp.strategy.PermitForbiddenStrtegy;
import com.lewis.tsp.tspManger.TSPManager;
import com.lewis.tsp.vo.TspOperation;
import com.lewis.tsp.vo.config.IPPortEnum;
import com.lewis.tsp.vo.config.TSPNameConfig;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangminghua on 2016/5/28.
 */
public class SimpleIpPortAllServiceStrtegy implements PermitForbiddenStrtegy {

    private IPPortEnum ipPortEnum;

    public SimpleIpPortAllServiceStrtegy(IPPortEnum ipPortEnum) {
        this.ipPortEnum = ipPortEnum;
    }

    public void forbidden() {
        List<String> ipPortList = new ArrayList<String>();
        ipPortList.add(ipPortEnum.getIpPort());
        try {
            TSPManager.forbiddenOrPermitTspOfBatch(TSPNameConfig.getAllServiceTspNameList(),ipPortList, TspOperation.FORBIDDEN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void permit() {
        List<String> ipPortList = new ArrayList<String>();
        ipPortList.add(ipPortEnum.getIpPort());
        try {
            TSPManager.forbiddenOrPermitTspOfBatch(TSPNameConfig.getAllServiceTspNameList(),ipPortList,TspOperation.PERMISSION);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
