package com.lewis.tsp.vo;

import com.lewis.tsp.vo.config.IPEnum;

/**
 * Created by zhangminghua on 2016/6/2.
 * 二级矩阵中 节点的数据结构
 */
public class Node {

    //该节点属于哪个ip
    private final IPEnum ipEnum;

    //该节点分配了哪种类型的服务
    private final ServiceTypeEnum serviceTypeEnum;

    //服务在这些ip上的状态，是禁用还是启用
    private final TspOperation tspOperation;

    public Node(IPEnum ipEnum, ServiceTypeEnum serviceTypeEnum,TspOperation tspOperation) {
        this.ipEnum = ipEnum;
        this.serviceTypeEnum = serviceTypeEnum;
        this.tspOperation = tspOperation;
    }

    public IPEnum getIpEnum() {
        return ipEnum;
    }

    public ServiceTypeEnum getServiceTypeEnum() {
        return serviceTypeEnum;
    }

    public TspOperation getTspOperation() {
        return tspOperation;
    }

    @Override
    public String toString() {
        return "Node{" +
                "ipEnum=" + ipEnum +
                ", serviceTypeEnum=" + serviceTypeEnum +
                '}';
    }
}
