package com.lewis.tsp.util;

import com.alibaba.fastjson.JSON;
import com.lewis.tsp.vo.Constants;
import com.lewis.tsp.vo.Node;
import com.lewis.tsp.vo.ServiceType;
import com.lewis.tsp.vo.ServiceTypeEnum;
import com.lewis.tsp.vo.config.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by zhangminghua on 2016/5/23.
 */
public final class CommonUtil {

    private CommonUtil(){}


    public  static <T> boolean copyCollection(Collection<T> src, Collection<T> dest){
        boolean retFlag = true;
        try {
            if (CollectionUtils.isNotEmpty(src) && dest != null){
                for (T t : src) {
                    if (t instanceof String) {
                        dest.add(t);
                    }
                }
            }
        } catch (Exception e) {
            retFlag = false;
            e.printStackTrace();
        }
        return retFlag;
    }

    public static List<String> builderIpPortList(List<String> ipList,List<String> portList,List<String> ipPortList){
        if (CollectionUtils.isNotEmpty(ipList) && CollectionUtils.isNotEmpty(portList)) {
            for (String ip : ipList) {
                for (String port : portList) {
                    ipPortList.add(ip+":"+port);
                }
            }
        }
        return ipPortList;
    }

    public static List<String> builderIpPortList(String ip,List<String> portList,List<String> ipPortList){
        if (StringUtils.isNotEmpty(ip) && CollectionUtils.isNotEmpty(portList)) {
            for (String port : portList) {
                ipPortList.add(ip+":"+port);
            }
        }
        return ipPortList;
    }

    public static List<String> getTspNameListByServiceType(ServiceType serviceType){
        List<String> tspNameList = null;
        if (serviceType != null) {
            if (serviceType == ServiceType.PRICE) {
                tspNameList = TSPNameConfig.getPriceAllowTspNameList();
            }else if (serviceType == ServiceType.PRODUCT) {
                tspNameList = TSPNameConfig.getProductAllowTspNameList();
            }else if (serviceType == ServiceType.RESOURCE) {
                tspNameList = TSPNameConfig.getResourceAllowTspNameList();
            }else if (serviceType == ServiceType.VARNISH_TRANSMISSION) {
                tspNameList = TSPNameConfig.getUnVarnishAllowTransmissionTspNameList();
            }else if (serviceType == ServiceType.ALL_SERVICE) {
                tspNameList = TSPNameConfig.getAllServiceTspNameList();
            }
        }
        return tspNameList;
    }


    public static Map<String,List<String>>  readProperty(String configLocation){
        Map<String,List<String>> retMap = new HashMap<String, List<String>>();
        Properties properties = new Properties();
        try {
            InputStream is = new FileInputStream(configLocation);
            properties.load(is);
            Iterator<Map.Entry<Object, Object>> it = properties.entrySet().iterator();
            Map<String, IPEnum> ip2IPEnumMap = IpPortConfig.getIp2IPEnumMap();
            while (it.hasNext()){
                Map.Entry<Object, Object> entry = it.next();
                String ipValues = (String)entry.getValue();
                String[] ipValueArray = ipValues.split(",");
                List<String> ipPortList = new LinkedList<String>();
                System.out.println("key ="+entry.getKey()+" values = "+Arrays.toString(ipValueArray));
                if (ipValueArray != null && ipValueArray.length > 0) {
                    for (String ipValue : ipValueArray) {
                        ipPortList.addAll(ip2IPEnumMap.get(ipValue).getIpPortList());
                    }
                }
                retMap.put((String)entry.getKey(),ipPortList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retMap;
    }

    /**
     * 得到配置文件里配置的（服务类型对应哪些ip区间），服务类型所对应的Node列表
     * @param configLocation
     * @return
     */
    public static Map<ServiceTypeEnum,List<Node>> getServiceTypeEnumIPEnumAllNodeListAfterAplit(String configLocation){
        Map<ServiceTypeEnum,List<Node>> retMap =  new HashMap<ServiceTypeEnum, List<Node>>();
        Properties properties = new Properties();
        try {
            InputStream is = new FileInputStream(configLocation);
            properties.load(is);
            Iterator<Map.Entry<Object, Object>> it = properties.entrySet().iterator();
            Map<String, IPEnum> ip2IPEnumMap = IpPortConfig.getIp2IPEnumMap();
            List<Node> allNodes = NodeMatrixConfig.getAllNodes();
            Map<String, ServiceTypeEnum> name2ServiceTypeEnumMap = Constants.getName2ServiceTypeEnumMap();
            while (it.hasNext()){
                Map.Entry<Object, Object> entry = it.next();
                String ipValues = (String)entry.getValue();
                String[] ipValueArray = ipValues.split(",");
                ServiceTypeEnum serviceTypeEnum = name2ServiceTypeEnumMap.get(entry.getKey());
                if (ipValueArray != null && ipValueArray.length > 0) {
                    for (String ipValue : ipValueArray) {
                        IPEnum ipEnum = ip2IPEnumMap.get(ipValue);
                        List<Node> ipNodeList = getIpNodeList(allNodes,ipEnum);
                        putIntoMap(serviceTypeEnum,ipNodeList,retMap);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retMap;
    }


    /**
     * 得到配置文件中 与配置内容相反的配置
     * @return
     */
    public static  Map<ServiceTypeEnum,List<Node>>  getServiceTypeEnumNotBelongsToIPEnumAllNodeListAfterAplit(){
        Map<ServiceTypeEnum,List<Node>> retMap = new HashMap<ServiceTypeEnum, List<Node>>();
        Map<ServiceTypeEnum, List<Node>> mapConfig = ServiceConfig.getServiceTypeEnum2NodeListOfConfig();
        ServiceTypeEnum[] values = ServiceTypeEnum.values();
        if (values != null && values.length > 0) {
            for (ServiceTypeEnum ste : values) {
                List<Node> listNode = new LinkedList<Node>();
                Iterator<Map.Entry<ServiceTypeEnum, List<Node>>> it = mapConfig.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<ServiceTypeEnum, List<Node>> entry = it.next();
                    if (!entry.getKey().equals(ste)) {
                        listNode.addAll(entry.getValue());
                    }
                }
                retMap.put(ste,listNode);
            }
        }
        return retMap;
    }

    /**
     * 在服务类型不在IP区间的Node列表
     * @param serviceTypeEnum
     * @return
     */
    public static List<Node> getServiceTypeEnumNotIpNodeList(ServiceTypeEnum serviceTypeEnum){
        List<Node> retList = new LinkedList<Node>();
        Map<ServiceTypeEnum, List<Node>> map = getServiceTypeEnumNotBelongsToIPEnumAllNodeListAfterAplit();
        List<Node> nodes = map.get(serviceTypeEnum);
        if (CollectionUtils.isNotEmpty(nodes)) {
            for (Node node : nodes) {
                if (node.getServiceTypeEnum().equals(serviceTypeEnum)) {
                    retList.add(node);
                }
            }
        }
        return retList;
    }

    /**
     *  在服务类型所对应的IP区间里,得到属于服务类型所对应的Node列表
     * @param serviceTypeEnum
     * @return
     */
    public static List<Node> getNodeListBelongsToServiceTypeEnum(ServiceTypeEnum serviceTypeEnum){
        List<Node> retList = new LinkedList<Node>();
        Map<ServiceTypeEnum, List<Node>> map = ServiceConfig.getServiceTypeEnum2NodeListOfConfig();
        if (map != null && map.size() > 0) {
            List<Node> nodes = map.get(serviceTypeEnum);
            if (CollectionUtils.isNotEmpty(nodes)) {
                for (Node node : nodes) {
                    if (node.getServiceTypeEnum().equals(serviceTypeEnum)) {
                        retList.add(node);
                    }
                }
            }
        }
        return retList;
    }

    /**
     * 在服务类型所对应的IP区间里,得到不属于服务类型的Node列表
     * @param serviceTypeEnum
     * @return
     */
    public static List<Node> getNodeListNotBelongsToServiceTypeEnum(ServiceTypeEnum serviceTypeEnum){
        List<Node> retList = new LinkedList<Node>();
        Map<ServiceTypeEnum, List<Node>> map = ServiceConfig.getServiceTypeEnum2NodeListOfConfig();
        if (map != null && map.size() > 0) {
            List<Node> nodes = map.get(serviceTypeEnum);
            if (CollectionUtils.isNotEmpty(nodes)) {
                for (Node node : nodes) {
                    if (!node.getServiceTypeEnum().equals(serviceTypeEnum)) {
                        retList.add(node);
                    }
                }
            }
        }
        return retList;
    }

    private static void putIntoMap(ServiceTypeEnum serviceTypeEnum, List<Node> ipNodeList, Map<ServiceTypeEnum, List<Node>> retMap) {
        if (retMap != null && serviceTypeEnum != null && CollectionUtils.isNotEmpty(ipNodeList)) {
            List<Node> nodes = retMap.get(serviceTypeEnum);
            if (nodes == null) {
                nodes = new LinkedList<Node>();
            }
            nodes.addAll(ipNodeList);
            retMap.put(serviceTypeEnum,nodes);
        }
    }


    public static List<Node> getIpNodeList(List<Node> allNodes, IPEnum ipEnum) {
        List<Node> retList = new LinkedList<Node>();
        if (ipEnum != null && CollectionUtils.isNotEmpty(allNodes)) {
            for (Node node : allNodes) {
                if (node.getIpEnum().equals(ipEnum)) {
                    retList.add(node);
                }
            }
        }
        return retList;
    }


    public static void main(String[] args) {
        List<Node> serviceTypeEnumNodeList = getNodeListBelongsToServiceTypeEnum(ServiceTypeEnum.PRODUCT);
        List<Node> nodeListNotBelongsToServiceTypeEnum = getNodeListNotBelongsToServiceTypeEnum(ServiceTypeEnum.PRODUCT);
        System.out.println(JSON.toJSONString(serviceTypeEnumNodeList));
        System.out.println(JSON.toJSONString(nodeListNotBelongsToServiceTypeEnum));
        List<Node> list = getServiceTypeEnumNotIpNodeList(ServiceTypeEnum.PRODUCT);
        System.out.println(JSON.toJSONString(list));
    }

}
