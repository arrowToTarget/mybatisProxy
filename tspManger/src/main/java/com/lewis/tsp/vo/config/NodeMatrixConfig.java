package com.lewis.tsp.vo.config;

import com.alibaba.fastjson.JSON;
import com.lewis.tsp.vo.Node;
import com.lewis.tsp.vo.ServiceTypeEnum;
import com.lewis.tsp.vo.TspOperation;
import java.util.*;

/**
 * Created by zhangminghua on 2016/6/2.
 */
public class NodeMatrixConfig {

    private static Node[][] nodeConfig = new Node[7][4];

    public static Node[][] getNodeConfig() {
        return nodeConfig;
    }

    public static final Map<ServiceTypeEnum,List<IPEnum>> serviceTypeEnum2IPEnumListMap = new HashMap<ServiceTypeEnum, List<IPEnum>>();

    public static final Map<ServiceTypeEnum,List<Node>> serviceTypeEnum2BelongsToNodeListMap = new HashMap<ServiceTypeEnum, List<Node>>();

    public static final Map<ServiceTypeEnum,List<Node>> serviceTypeEnum2NotBelongsToNodeListMap = new HashMap<ServiceTypeEnum, List<Node>>();

    public static final List<Node> allNodes = new LinkedList<Node>();

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
        int length = nodeConfig.length;
        for (int i = 0; i < length; i++) {
            Node[] nodes = nodeConfig[i];
            for (int j = 0; j < nodes.length; j++) {
                allNodes.add(nodes[j]);
            }
        }

        ServiceTypeEnum[] serviceTypeEnumValues = ServiceTypeEnum.values();
        if (serviceTypeEnumValues != null && serviceTypeEnumValues.length > 0){
            for (ServiceTypeEnum ste : serviceTypeEnumValues) {
                for (Node node : allNodes) {
                    if (ste.equals(node.getServiceTypeEnum())) {
                        putIntoMap(serviceTypeEnum2BelongsToNodeListMap,node);
                    }
                }
            }
        }
    }

    private static void putIntoMap(Map<ServiceTypeEnum, List<Node>> serviceTypeEnum2BelongsToNodeListMap, Node node) {
        List<Node> nodes = serviceTypeEnum2BelongsToNodeListMap.get(node.getServiceTypeEnum());
        if (nodes == null) {
            nodes = new LinkedList<Node>();
        }
        nodes.add(node);
        serviceTypeEnum2BelongsToNodeListMap.put(node.getServiceTypeEnum(),nodes);
    }

    public static Map<ServiceTypeEnum, List<IPEnum>> getServiceTypeEnum2IPEnumListMap() {
        return serviceTypeEnum2IPEnumListMap;
    }

    public static Map<ServiceTypeEnum, List<Node>> getServiceTypeEnum2BelongsToNodeListMap() {
        return serviceTypeEnum2BelongsToNodeListMap;
    }

    public static Map<ServiceTypeEnum, List<Node>> getServiceTypeEnum2NotBelongsToNodeListMap() {
        return serviceTypeEnum2NotBelongsToNodeListMap;
    }

    public static List<Node> getAllNodes() {
        return allNodes;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(serviceTypeEnum2BelongsToNodeListMap));
    }

}
