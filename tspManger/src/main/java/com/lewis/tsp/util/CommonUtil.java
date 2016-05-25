package com.lewis.tsp.util;

import com.lewis.tsp.vo.ServiceType;
import com.lewis.tsp.vo.config.IpPortConfig;
import com.lewis.tsp.vo.config.TSPNameConfig;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;

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
                tspNameList = TSPNameConfig.getPriceTspNameList();
            }else if (serviceType == ServiceType.PRODUCT) {
                tspNameList = TSPNameConfig.getProductTspNameList();
            }else if (serviceType == ServiceType.RESOURCE) {
                tspNameList = TSPNameConfig.getResourceTspNameList();
            }else if (serviceType == ServiceType.VARNISH_TRANSMISSION) {
                tspNameList = TSPNameConfig.getUnVarnishTransmissionTspNameList();
            }else if (serviceType == ServiceType.ALL_SERVICE) {
                tspNameList = TSPNameConfig.getAllServiceTspNameList();
            }
        }
        return tspNameList;
    }

}
