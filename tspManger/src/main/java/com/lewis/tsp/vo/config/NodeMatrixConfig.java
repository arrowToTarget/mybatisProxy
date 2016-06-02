package com.lewis.tsp.vo.config;

import com.lewis.tsp.vo.Node;
import com.lewis.tsp.vo.ServiceTypeEnum;
import com.lewis.tsp.vo.TspOperation;

/**
 * Created by zhangminghua on 2016/6/2.
 */
public class NodeMatrixConfig {

    private static Node[][] nodeConfig = new Node[7][4];

    public static Node[][] getNodeConfig() {
        return nodeConfig;
    }

    static {
        IPEnum[] ipEnumsValues = IPEnum.values();
        ServiceTypeEnum[] serviceTypeValues = ServiceTypeEnum.values();
        if (ipEnumsValues != null && ipEnumsValues.length > 0 && serviceTypeValues != null && serviceTypeValues.length >0) {
            for (int i = 0; i < ipEnumsValues.length; i++) {
                for (int j = 0; j < serviceTypeValues.length; j++) {
                    nodeConfig[i][j] = new Node(ipEnumsValues[i],serviceTypeValues[j], TspOperation.PERMISSION);
                }
            }
        }
    }

}
