package com.lewis.tsp.strategy;


import com.lewis.tsp.tspManger.TSPManager;
import com.lewis.tsp.vo.TspOperation;
import org.apache.commons.lang3.StringUtils;

/**
 * 单个Tsp 单个实例的策略
 */
public class SingleTspSingleIpPortStrategy implements PermitForbiddenStrtegy {

    private String tspName;

    private String ipPort;

    public SingleTspSingleIpPortStrategy(String tspName, String ipPort) {
        this.tspName = tspName;
        this.ipPort = ipPort;
    }

    public void forbidden() {
        if (StringUtils.isNotEmpty(tspName) && StringUtils.isNotEmpty(ipPort)) {
            try {
                TSPManager.forbiddenOrPermitTsp(tspName,ipPort, TspOperation.FORBIDDEN);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void permit() {
        if (StringUtils.isNotEmpty(tspName) && StringUtils.isNotEmpty(ipPort)) {
            try {
                TSPManager.forbiddenOrPermitTsp(tspName,ipPort,TspOperation.PERMISSION);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
