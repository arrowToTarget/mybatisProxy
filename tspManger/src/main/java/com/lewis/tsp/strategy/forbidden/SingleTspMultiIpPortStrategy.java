package com.lewis.tsp.strategy.forbidden;

import com.lewis.tsp.strategy.PermitForbiddenStrtegy;
import com.lewis.tsp.tspManger.TSPManager;
import com.lewis.tsp.vo.TspOperation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.List;

/**
 * Created by zhangminghua on 2016/5/24.
 * 单个Tsp 多个实例的策略
 */
public class SingleTspMultiIpPortStrategy implements PermitForbiddenStrtegy {

    private String tspName;

    private List<String> ipPortList;

    public SingleTspMultiIpPortStrategy(String tspName, List<String> ipPortList) {
        this.tspName = tspName;
        this.ipPortList = ipPortList;
    }

    public void forbidden() {
        if (StringUtils.isNotEmpty(tspName) && CollectionUtils.isNotEmpty(ipPortList)) {
            try {
                TSPManager.forbiddenOrPermitTspOfBatchAtSingleTsp(tspName,ipPortList, TspOperation.FORBIDDEN);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void permit() {
        if (StringUtils.isNotEmpty(tspName) && CollectionUtils.isNotEmpty(ipPortList)) {
            try {
                TSPManager.forbiddenOrPermitTspOfBatchAtSingleTsp(tspName,ipPortList,TspOperation.PERMISSION);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
