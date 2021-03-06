package com.lewis.tsp.strategy.forbidden;

import com.alibaba.fastjson.JSON;
import com.lewis.tsp.tspManger.TSPManager;
import com.lewis.tsp.vo.AppSplitConfigVo;
import com.lewis.tsp.vo.TspOperation;
import org.apache.commons.collections.CollectionUtils;
import java.util.List;

/**
 * Created by zhangminghua on 2016/5/24.
 */
public final class OperationTspService {

    //禁用服务
    public static void forbiddenTspService(AppSplitConfigVo appSplitConfigVo){
        doForbiddenTspService(appSplitConfigVo);
    }

    //启用服务
    public static void permitTspService(AppSplitConfigVo appSplitConfigVo){
        doPermitTspService(appSplitConfigVo);
    }

    private static void doForbiddenTspService(AppSplitConfigVo appSplitConfig) {
        try {
            if (appSplitConfig != null) {
                List<String> allowIpPortList = appSplitConfig.getAllowIpPortList();
                List<String> tspNameList = appSplitConfig.getForbiddenTspNameList();
                if (CollectionUtils.isNotEmpty(tspNameList)) {
                    if (CollectionUtils.isNotEmpty(allowIpPortList)) {
                        TSPManager.forbiddenOrPermitTspOfBatch(tspNameList, allowIpPortList, TspOperation.FORBIDDEN);
                    }
                }
                System.out.println("禁用 tspName "+ JSON.toJSONString(tspNameList)+" 在实例 "+JSON.toJSONString(allowIpPortList)+" 成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void doPermitTspService(AppSplitConfigVo appSplitConfig){
        try {
            if (appSplitConfig != null) {
                List<String> allowIpPortList = appSplitConfig.getAllowIpPortList();
                List<String> tspNameList = appSplitConfig.getAllowTspNameList();
                if (CollectionUtils.isNotEmpty(tspNameList)) {
                    if (CollectionUtils.isNotEmpty(allowIpPortList)) {
                        TSPManager.forbiddenOrPermitTspOfBatch(tspNameList, allowIpPortList, TspOperation.PERMISSION);
                    }
                }
                System.out.println("启用 tspName "+ JSON.toJSONString(tspNameList)+" 在实例 "+JSON.toJSONString(allowIpPortList)+" 成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
