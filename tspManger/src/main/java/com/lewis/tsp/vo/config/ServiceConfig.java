package com.lewis.tsp.vo.config;


import com.lewis.tsp.util.CommonUtil;
import com.lewis.tsp.vo.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceConfig {

    //价格服务的 配置
    public static final AppSplitConfigVo priceAppSplitConfig = new AppSplitConfigVo();
    //价格服务的恢复配置
    public static final AppSplitConfigVo priceRecoverAppSplitConfig = new AppSplitConfigVo();

    //产品服务的配置
    public static final AppSplitConfigVo productAppSplitConfig = new AppSplitConfigVo();
    //产品服务的恢复配置
    public static final AppSplitConfigVo productRecoverAppSplitConfig = new AppSplitConfigVo();

    //资源服务的配置
    public static final AppSplitConfigVo resourceAppSplitConfig = new AppSplitConfigVo();
    //资源服务的恢复配置
    public static final AppSplitConfigVo resourceRecoverAppSplitConfig = new AppSplitConfigVo();

    //接口透传服务的配置
    public static final AppSplitConfigVo unVarnishTransmissionAppSplitConfig = new AppSplitConfigVo();
    //接口透传服务的恢复配置
    public static final AppSplitConfigVo unVarnishTransmissionRecoverAppSplitConfig = new AppSplitConfigVo();

    //所有服务的恢复性配置，包含 价格服务、产品服务、资源服务、接口透传服务
    public static final AppSplitConfigVo allServiceRecoverAppSplitConfig = new AppSplitConfigVo();

    public static Map<ServiceTypeEnum,List<Node>> serviceTypeEnum2NodeListOfConfig = new HashMap<ServiceTypeEnum, List<Node>>();

    static {
        priceAppSplitConfig.setServiceType(ServiceType.PRICE);
        priceAppSplitConfig.setAllowIpPortList(IpPortConfig.getPriceAllowedIpPortList());
        priceAppSplitConfig.setForbiddenIpPortList(IpPortConfig.getPriceForbiddenIpPortList());
        priceAppSplitConfig.setAllowTspNameList(TSPNameConfig.getPriceAllowTspNameList());
        priceAppSplitConfig.setForbiddenTspNameList(TSPNameConfig.getPriceForbiddenTspNameList());

        //价格服务的恢复性配置 设置
        priceRecoverAppSplitConfig.setServiceType(ServiceType.PRICE);
        priceRecoverAppSplitConfig.setAllowIpPortList(IpPortConfig.getAllIpPortList());
        priceRecoverAppSplitConfig.setForbiddenIpPortList(null);
        priceRecoverAppSplitConfig.setAllowTspNameList(TSPNameConfig.getPriceAllowTspNameList());

        productAppSplitConfig.setServiceType(ServiceType.PRODUCT);
        productAppSplitConfig.setAllowIpPortList(IpPortConfig.getProductAllowedIpPortList());
        productAppSplitConfig.setForbiddenIpPortList(IpPortConfig.getProductForbiddenIpPortList());
        productAppSplitConfig.setAllowTspNameList(TSPNameConfig.getProductAllowTspNameList());
        productAppSplitConfig.setForbiddenTspNameList(TSPNameConfig.getProductForbiddenTspNameList());
        //产品服务的恢复性配置 设置
        productRecoverAppSplitConfig.setServiceType(ServiceType.PRODUCT);
        productRecoverAppSplitConfig.setAllowIpPortList(IpPortConfig.getAllIpPortList());
        productRecoverAppSplitConfig.setForbiddenIpPortList(null);
        productRecoverAppSplitConfig.setAllowTspNameList(TSPNameConfig.getProductAllowTspNameList());

        resourceAppSplitConfig.setServiceType(ServiceType.RESOURCE);
        resourceAppSplitConfig.setAllowIpPortList(IpPortConfig.getResourceAllowedIpPortList());
        resourceAppSplitConfig.setForbiddenIpPortList(IpPortConfig.getResourceForbiddenIpPortList());
        resourceAppSplitConfig.setAllowTspNameList(TSPNameConfig.getResourceAllowTspNameList());
        resourceAppSplitConfig.setForbiddenTspNameList(TSPNameConfig.getResourceForbiddenTspNameList());
        //资源服务的恢复性配置 设置
        resourceRecoverAppSplitConfig.setServiceType(ServiceType.RESOURCE);
        resourceRecoverAppSplitConfig.setAllowIpPortList(IpPortConfig.getAllIpPortList());
        resourceRecoverAppSplitConfig.setForbiddenIpPortList(null);
        resourceRecoverAppSplitConfig.setAllowTspNameList(TSPNameConfig.getResourceAllowTspNameList());

        unVarnishTransmissionAppSplitConfig.setServiceType(ServiceType.VARNISH_TRANSMISSION);
        unVarnishTransmissionAppSplitConfig.setAllowIpPortList(IpPortConfig.getUnVarnishTransmissionAllowedIpPortList());
        unVarnishTransmissionAppSplitConfig.setForbiddenIpPortList(IpPortConfig.getUnVarnishTransmissionForbiddenIpPortList());
        unVarnishTransmissionAppSplitConfig.setAllowTspNameList(TSPNameConfig.getUnVarnishAllowTransmissionTspNameList());
        unVarnishTransmissionAppSplitConfig.setForbiddenTspNameList(TSPNameConfig.getUnVarnishTransmissionForbiddenTspNameList());
        //接口透传服务的恢复性配置 设置
        unVarnishTransmissionRecoverAppSplitConfig.setServiceType(ServiceType.VARNISH_TRANSMISSION);
        unVarnishTransmissionRecoverAppSplitConfig.setAllowIpPortList(IpPortConfig.getAllIpPortList());
        unVarnishTransmissionRecoverAppSplitConfig.setForbiddenIpPortList(null);
        unVarnishTransmissionRecoverAppSplitConfig.setAllowTspNameList(TSPNameConfig.getUnVarnishAllowTransmissionTspNameList());

        //所有服务的恢复性配置 设置
        allServiceRecoverAppSplitConfig.setServiceType(ServiceType.ALL_SERVICE);
        allServiceRecoverAppSplitConfig.setAllowIpPortList(IpPortConfig.getAllIpPortList());
        allServiceRecoverAppSplitConfig.setForbiddenIpPortList(null);
        allServiceRecoverAppSplitConfig.setAllowTspNameList(TSPNameConfig.getAllServiceTspNameList());
    }

    public static AppSplitConfigVo getPriceAppSplitConfig() {
        return priceAppSplitConfig;
    }

    public static AppSplitConfigVo getPriceRecoverAppSplitConfig() {
        return priceRecoverAppSplitConfig;
    }

    public static AppSplitConfigVo getProductAppSplitConfig() {
        return productAppSplitConfig;
    }

    public static AppSplitConfigVo getProductRecoverAppSplitConfig() {
        return productRecoverAppSplitConfig;
    }

    public static AppSplitConfigVo getResourceAppSplitConfig() {
        return resourceAppSplitConfig;
    }

    public static AppSplitConfigVo getResourceRecoverAppSplitConfig() {
        return resourceRecoverAppSplitConfig;
    }

    public static AppSplitConfigVo getUnVarnishTransmissionAppSplitConfig() {
        return unVarnishTransmissionAppSplitConfig;
    }

    public static AppSplitConfigVo getUnVarnishTransmissionRecoverAppSplitConfig() {
        return unVarnishTransmissionRecoverAppSplitConfig;
    }

    public static AppSplitConfigVo getAllServiceRecoverAppSplitConfig() {
        return allServiceRecoverAppSplitConfig;
    }

    public static Map<ServiceTypeEnum, List<Node>> getServiceTypeEnum2NodeListOfConfig() {
        if (serviceTypeEnum2NodeListOfConfig == null || serviceTypeEnum2NodeListOfConfig.size() == 0) {
            serviceTypeEnum2NodeListOfConfig = CommonUtil.getServiceTypeEnumIPEnumAllNodeListAfterAplit(Constants.configPath);
        }
        return serviceTypeEnum2NodeListOfConfig;
    }
}
