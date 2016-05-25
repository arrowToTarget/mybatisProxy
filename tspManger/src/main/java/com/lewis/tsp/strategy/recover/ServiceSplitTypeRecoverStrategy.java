package com.lewis.tsp.strategy.recover;

import com.lewis.tsp.strategy.PermitStrategy;
import com.lewis.tsp.tspManger.TSPManager;
import com.lewis.tsp.util.CommonUtil;
import com.lewis.tsp.vo.ServiceType;
import com.lewis.tsp.vo.TspOperation;
import com.lewis.tsp.vo.config.IpPortConfig;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Created by zhangminghua on 2016/5/25.
 * 按照服务类型来恢复
 */
public class ServiceSplitTypeRecoverStrategy implements PermitStrategy {

    private ServiceType serviceType;

    public ServiceSplitTypeRecoverStrategy(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public void permit() {
        List<String> tspNameList = CommonUtil.getTspNameListByServiceType(serviceType);
        if (CollectionUtils.isNotEmpty(tspNameList)) {
            List<String> allIpPortList = IpPortConfig.getAllIpPortList();
            if (CollectionUtils.isNotEmpty(allIpPortList)) {
                try {
                    TSPManager.forbiddenOrPermitTspOfBatch(tspNameList,allIpPortList, TspOperation.PERMISSION);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
