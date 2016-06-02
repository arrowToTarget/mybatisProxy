package com.lewis.tsp.util;

import com.alibaba.fastjson.JSON;
import com.lewis.tsp.vo.ServiceType;
import com.lewis.tsp.vo.config.IpPortConfig;
import com.lewis.tsp.vo.config.TSPNameConfig;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
            Map<String, List<String>> ip2ipPortConfigMap = null;
            while (it.hasNext()){
                Map.Entry<Object, Object> entry = it.next();
                String ipValues = (String)entry.getValue();
                String[] ipValueArray = ipValues.split(",");
                List<String> ipPortList = new LinkedList<String>();
                System.out.println("key ="+entry.getKey()+" values = "+Arrays.toString(ipValueArray));
                if (ipValueArray != null && ipValueArray.length > 0) {
                    for (String ipValue : ipValueArray) {
                        ipPortList.addAll(ip2ipPortConfigMap.get(ipValue));
                    }
                }
                retMap.put((String)entry.getKey(),ipPortList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retMap;
    }

    public static void main(String[] args) {
        String configPath ="D:/java/sourceCode/mybatisProxy/tspManger/src/config.properties";
        Map<String, List<String>> stringListMap = readProperty(configPath);
        System.out.println(JSON.toJSONString(stringListMap));
    }

}
