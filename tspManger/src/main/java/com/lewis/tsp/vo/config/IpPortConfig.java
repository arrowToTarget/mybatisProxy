package com.lewis.tsp.vo.config;

import com.alibaba.fastjson.JSON;
import com.lewis.tsp.util.CommonUtil;
import java.util.*;

/**
 * Created by zhangminghua on 2016/5/24.
 */
public class IpPortConfig {

    public static final String IP_62 ="10.40.50.62";
    public static final String IP_63 ="10.40.50.63";
    public static final String IP_64 ="10.40.50.64";
    public static final String IP_40 ="10.40.189.40";
    public static final String IP_46 ="10.40.189.46";
    public static final String IP_96 ="10.40.189.96";
    public static final String IP_209 ="10.40.190.209";

    public static final String PORT_12501="12501";
    public static final String PORT_12502="12502";
    public static final String PORT_12503="12503";
    public static final String PORT_12504="12504";
    public static final String PORT_12505="12505";
    public static final String PORT_12506="12506";
    public static final String PORT_12507="12507";

    public static final String IP_PORT_62_01 = IP_62+":"+PORT_12501;
    public static final String IP_PORT_62_02 = IP_62+":"+PORT_12502;
    public static final String IP_PORT_62_03 = IP_62+":"+PORT_12503;
    public static final String IP_PORT_62_04 = IP_62+":"+PORT_12504;
    public static final String IP_PORT_62_05 = IP_62+":"+PORT_12505;
    public static final String IP_PORT_62_06 = IP_62+":"+PORT_12506;
    public static final String IP_PORT_62_07 = IP_62+":"+PORT_12507;

    public static final String IP_PORT_63_01 = IP_63+":"+PORT_12501;
    public static final String IP_PORT_63_02 = IP_63+":"+PORT_12502;
    public static final String IP_PORT_63_03 = IP_63+":"+PORT_12503;
    public static final String IP_PORT_63_04 = IP_63+":"+PORT_12504;
    public static final String IP_PORT_63_05 = IP_63+":"+PORT_12505;
    public static final String IP_PORT_63_06 = IP_63+":"+PORT_12506;
    public static final String IP_PORT_63_07 = IP_63+":"+PORT_12507;

    public static final String IP_PORT_64_01 = IP_64+":"+PORT_12501;
    public static final String IP_PORT_64_02 = IP_64+":"+PORT_12502;
    public static final String IP_PORT_64_03 = IP_64+":"+PORT_12503;
    public static final String IP_PORT_64_04 = IP_64+":"+PORT_12504;
    public static final String IP_PORT_64_05 = IP_64+":"+PORT_12505;
    public static final String IP_PORT_64_06 = IP_64+":"+PORT_12506;
    public static final String IP_PORT_64_07 = IP_64+":"+PORT_12507;

    public static final String IP_PORT_40_01 = IP_40+":"+PORT_12501;
    public static final String IP_PORT_40_02 = IP_40+":"+PORT_12502;
    public static final String IP_PORT_40_03 = IP_40+":"+PORT_12503;
    public static final String IP_PORT_40_04 = IP_40+":"+PORT_12504;
    public static final String IP_PORT_40_05 = IP_40+":"+PORT_12505;
    public static final String IP_PORT_40_06 = IP_40+":"+PORT_12506;
    public static final String IP_PORT_40_07 = IP_40+":"+PORT_12507;


    public static final String IP_PORT_46_01 = IP_46+":"+PORT_12501;
    public static final String IP_PORT_46_02 = IP_46+":"+PORT_12502;
    public static final String IP_PORT_46_03 = IP_46+":"+PORT_12503;
    public static final String IP_PORT_46_04 = IP_46+":"+PORT_12504;
    public static final String IP_PORT_46_05 = IP_46+":"+PORT_12505;
    public static final String IP_PORT_46_06 = IP_46+":"+PORT_12506;
    public static final String IP_PORT_46_07 = IP_46+":"+PORT_12507;

    public static final String IP_PORT_96_01 = IP_96+":"+PORT_12501;
    public static final String IP_PORT_96_02 = IP_96+":"+PORT_12502;
    public static final String IP_PORT_96_03 = IP_96+":"+PORT_12503;
    public static final String IP_PORT_96_04 = IP_96+":"+PORT_12504;
    public static final String IP_PORT_96_05 = IP_96+":"+PORT_12505;
    public static final String IP_PORT_96_06 = IP_96+":"+PORT_12506;
    public static final String IP_PORT_96_07 = IP_96+":"+PORT_12507;

    public static final String IP_PORT_209_01 = IP_209+":"+PORT_12501;
    public static final String IP_PORT_209_02 = IP_209+":"+PORT_12502;
    public static final String IP_PORT_209_03 = IP_209+":"+PORT_12503;
    public static final String IP_PORT_209_04 = IP_209+":"+PORT_12504;
    public static final String IP_PORT_209_05 = IP_209+":"+PORT_12505;
    public static final String IP_PORT_209_06 = IP_209+":"+PORT_12506;
    public static final String IP_PORT_209_07 = IP_209+":"+PORT_12507;

    public static final List<String>  allIpList = Arrays.asList(IP_62,IP_63,IP_64,IP_40,IP_46,IP_96,IP_209);

    public static final List<String> allPortList  = Arrays.asList(PORT_12501,PORT_12502,PORT_12503,PORT_12504,PORT_12505,PORT_12506,PORT_12507);

    public static final List<String> allIpPortList = new LinkedList<String>();
    public static final List<String> ipPortAt62List = new LinkedList<String>();
    public static final List<String> ipPortAt63List = new LinkedList<String>();
    public static final List<String> ipPortAt64List = new LinkedList<String>();
    public static final List<String> ipPortAt40List = new LinkedList<String>();
    public static final List<String> ipPortAt46List = new LinkedList<String>();
    public static final List<String> ipPortAt96List = new LinkedList<String>();
    public static final List<String> ipPortAt209List = new LinkedList<String>();



    public static final List<String> priceAllowedIpList = Arrays.asList(IP_62,IP_63,IP_64);

    public static final List<String> productAllowedIpList = Arrays.asList(IP_40,IP_46);

    public static final List<String> resourceAllowedIpList = Arrays.asList(IP_96);

    public static final List<String> unVarnishTransmissionAllowedIpList = Arrays.asList(IP_209);

    public static final List<String> priceAllowedPortList = new ArrayList<String>();

    public static final List<String> productAllowedPortList = new ArrayList<String>();

    public static final List<String> resourceAllowedPortList = new ArrayList<String>();

    public static final List<String> unVarnishTransmissionAllowedPortList = new ArrayList<String>();

    public static final List<String> priceAllowedIpPortList = new ArrayList<String>();
    public static final List<String> priceForbiddenIpPortList = new ArrayList<String>();

    public static final List<String> productAllowedIpPortList = new ArrayList<String>();
    public static final List<String> productForbiddenIpPortList = new ArrayList<String>();

    public static final List<String> resourceAllowedIpPortList = new ArrayList<String>();
    public static final List<String> resourceForbiddenIpPortList = new ArrayList<String>();

    public static final List<String> unVarnishTransmissionAllowedIpPortList = new ArrayList<String>();
    public static final List<String> unVarnishTransmissionForbiddenIpPortList = new ArrayList<String>();

    static {
        CommonUtil.copyCollection(allPortList, priceAllowedPortList);
        CommonUtil.copyCollection(allPortList, productAllowedPortList);
        CommonUtil.copyCollection(allPortList, resourceAllowedPortList);
        CommonUtil.copyCollection(allPortList, unVarnishTransmissionAllowedPortList);

        CommonUtil.builderIpPortList(allIpList,allPortList,allIpPortList);
        CommonUtil.builderIpPortList(priceAllowedIpList,priceAllowedPortList,priceAllowedIpPortList);
        CommonUtil.builderIpPortList(productAllowedIpList,productAllowedPortList,productAllowedIpPortList);
        CommonUtil.builderIpPortList(resourceAllowedIpList,resourceAllowedPortList,resourceAllowedIpPortList);
        CommonUtil.builderIpPortList(unVarnishTransmissionAllowedIpList,unVarnishTransmissionAllowedPortList,unVarnishTransmissionAllowedIpPortList);

        CommonUtil.builderIpPortList(IP_62,allPortList,ipPortAt62List);
        CommonUtil.builderIpPortList(IP_63,allPortList,ipPortAt63List);
        CommonUtil.builderIpPortList(IP_64,allPortList,ipPortAt64List);
        CommonUtil.builderIpPortList(IP_40,allPortList,ipPortAt40List);
        CommonUtil.builderIpPortList(IP_46,allPortList,ipPortAt46List);
        CommonUtil.builderIpPortList(IP_96,allPortList,ipPortAt96List);
        CommonUtil.builderIpPortList(IP_209,allPortList,ipPortAt209List);

        List<String> tmpAllIpPortList = new LinkedList<String>();
        CommonUtil.copyCollection(allIpPortList,tmpAllIpPortList);
        tmpAllIpPortList.removeAll(priceAllowedIpPortList);
        priceForbiddenIpPortList.addAll(tmpAllIpPortList);

        tmpAllIpPortList.clear();
        CommonUtil.copyCollection(allIpPortList,tmpAllIpPortList);
        tmpAllIpPortList.removeAll(productAllowedIpPortList);
        productForbiddenIpPortList.addAll(tmpAllIpPortList);

        tmpAllIpPortList.clear();
        CommonUtil.copyCollection(allIpPortList,tmpAllIpPortList);
        tmpAllIpPortList.removeAll(resourceAllowedIpPortList);
        resourceForbiddenIpPortList.addAll(tmpAllIpPortList);

        tmpAllIpPortList.clear();
        CommonUtil.copyCollection(allIpPortList,tmpAllIpPortList);
        tmpAllIpPortList.removeAll(unVarnishTransmissionAllowedIpPortList);
        unVarnishTransmissionForbiddenIpPortList.addAll(tmpAllIpPortList);


    }

    public static String getIp62() {
        return IP_62;
    }

    public static String getIp63() {
        return IP_63;
    }

    public static String getIp64() {
        return IP_64;
    }

    public static String getIp40() {
        return IP_40;
    }

    public static String getIp46() {
        return IP_46;
    }

    public static String getIp96() {
        return IP_96;
    }

    public static String getIp209() {
        return IP_209;
    }

    public static String getPort12501() {
        return PORT_12501;
    }

    public static String getPort12502() {
        return PORT_12502;
    }

    public static String getPort12503() {
        return PORT_12503;
    }

    public static String getPort12504() {
        return PORT_12504;
    }

    public static String getPort12505() {
        return PORT_12505;
    }

    public static String getPort12506() {
        return PORT_12506;
    }

    public static String getPort12507() {
        return PORT_12507;
    }

    public static List<String> getAllIpList() {
        return allIpList;
    }

    public static List<String> getAllPortList() {
        return allPortList;
    }

    public static List<String> getAllIpPortList() {
        return allIpPortList;
    }

    public static List<String> getPriceAllowedIpList() {
        return priceAllowedIpList;
    }

    public static List<String> getProductAllowedIpList() {
        return productAllowedIpList;
    }

    public static List<String> getResourceAllowedIpList() {
        return resourceAllowedIpList;
    }

    public static List<String> getUnVarnishTransmissionAllowedIpList() {
        return unVarnishTransmissionAllowedIpList;
    }

    public static List<String> getPriceAllowedPortList() {
        return priceAllowedPortList;
    }

    public static List<String> getProductAllowedPortList() {
        return productAllowedPortList;
    }

    public static List<String> getResourceAllowedPortList() {
        return resourceAllowedPortList;
    }

    public static List<String> getUnVarnishTransmissionAllowedPortList() {
        return unVarnishTransmissionAllowedPortList;
    }

    public static List<String> getPriceAllowedIpPortList() {
        return priceAllowedIpPortList;
    }

    public static List<String> getPriceForbiddenIpPortList() {
        return priceForbiddenIpPortList;
    }

    public static List<String> getProductAllowedIpPortList() {
        return productAllowedIpPortList;
    }

    public static List<String> getProductForbiddenIpPortList() {
        return productForbiddenIpPortList;
    }

    public static List<String> getResourceAllowedIpPortList() {
        return resourceAllowedIpPortList;
    }

    public static List<String> getResourceForbiddenIpPortList() {
        return resourceForbiddenIpPortList;
    }

    public static List<String> getUnVarnishTransmissionAllowedIpPortList() {
        return unVarnishTransmissionAllowedIpPortList;
    }

    public static List<String> getUnVarnishTransmissionForbiddenIpPortList() {
        return unVarnishTransmissionForbiddenIpPortList;
    }

    public static List<String> getIpPortAt62List() {
        return ipPortAt62List;
    }

    public static List<String> getIpPortAt63List() {
        return ipPortAt63List;
    }

    public static List<String> getIpPortAt64List() {
        return ipPortAt64List;
    }

    public static List<String> getIpPortAt40List() {
        return ipPortAt40List;
    }

    public static List<String> getIpPortAt46List() {
        return ipPortAt46List;
    }

    public static List<String> getIpPortAt96List() {
        return ipPortAt96List;
    }

    public static List<String> getIpPortAt209List() {
        return ipPortAt209List;
    }

    public static String getIpPort6201() {
        return IP_PORT_62_01;
    }

    public static String getIpPort6202() {
        return IP_PORT_62_02;
    }

    public static String getIpPort6203() {
        return IP_PORT_62_03;
    }

    public static String getIpPort6204() {
        return IP_PORT_62_04;
    }

    public static String getIpPort6205() {
        return IP_PORT_62_05;
    }

    public static String getIpPort6206() {
        return IP_PORT_62_06;
    }

    public static String getIpPort6207() {
        return IP_PORT_62_07;
    }

    public static String getIpPort6301() {
        return IP_PORT_63_01;
    }

    public static String getIpPort6302() {
        return IP_PORT_63_02;
    }

    public static String getIpPort6303() {
        return IP_PORT_63_03;
    }

    public static String getIpPort6304() {
        return IP_PORT_63_04;
    }

    public static String getIpPort6305() {
        return IP_PORT_63_05;
    }

    public static String getIpPort6306() {
        return IP_PORT_63_06;
    }

    public static String getIpPort6307() {
        return IP_PORT_63_07;
    }

    public static String getIpPort6401() {
        return IP_PORT_64_01;
    }

    public static String getIpPort6402() {
        return IP_PORT_64_02;
    }

    public static String getIpPort6403() {
        return IP_PORT_64_03;
    }

    public static String getIpPort6404() {
        return IP_PORT_64_04;
    }

    public static String getIpPort6405() {
        return IP_PORT_64_05;
    }

    public static String getIpPort6406() {
        return IP_PORT_64_06;
    }

    public static String getIpPort6407() {
        return IP_PORT_64_07;
    }

    public static String getIpPort4001() {
        return IP_PORT_40_01;
    }

    public static String getIpPort4002() {
        return IP_PORT_40_02;
    }

    public static String getIpPort4003() {
        return IP_PORT_40_03;
    }

    public static String getIpPort4004() {
        return IP_PORT_40_04;
    }

    public static String getIpPort4005() {
        return IP_PORT_40_05;
    }

    public static String getIpPort4006() {
        return IP_PORT_40_06;
    }

    public static String getIpPort4007() {
        return IP_PORT_40_07;
    }

    public static String getIpPort4601() {
        return IP_PORT_46_01;
    }

    public static String getIpPort4602() {
        return IP_PORT_46_02;
    }

    public static String getIpPort4603() {
        return IP_PORT_46_03;
    }

    public static String getIpPort4604() {
        return IP_PORT_46_04;
    }

    public static String getIpPort4605() {
        return IP_PORT_46_05;
    }

    public static String getIpPort4606() {
        return IP_PORT_46_06;
    }

    public static String getIpPort4607() {
        return IP_PORT_46_07;
    }

    public static String getIpPort9601() {
        return IP_PORT_96_01;
    }

    public static String getIpPort9602() {
        return IP_PORT_96_02;
    }

    public static String getIpPort9603() {
        return IP_PORT_96_03;
    }

    public static String getIpPort9604() {
        return IP_PORT_96_04;
    }

    public static String getIpPort9605() {
        return IP_PORT_96_05;
    }

    public static String getIpPort9606() {
        return IP_PORT_96_06;
    }

    public static String getIpPort9607() {
        return IP_PORT_96_07;
    }

    public static String getIpPort20901() {
        return IP_PORT_209_01;
    }

    public static String getIpPort20902() {
        return IP_PORT_209_02;
    }

    public static String getIpPort20903() {
        return IP_PORT_209_03;
    }

    public static String getIpPort20904() {
        return IP_PORT_209_04;
    }

    public static String getIpPort20905() {
        return IP_PORT_209_05;
    }

    public static String getIpPort20906() {
        return IP_PORT_209_06;
    }

    public static String getIpPort20907() {
        return IP_PORT_209_07;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(allIpPortList));
        System.out.println(JSON.toJSONString(priceAllowedIpPortList));
        System.out.println(JSON.toJSONString(priceForbiddenIpPortList));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(JSON.toJSONString(productAllowedIpPortList));
        System.out.println(JSON.toJSONString(productForbiddenIpPortList));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(JSON.toJSONString(resourceAllowedIpPortList));
        System.out.println(JSON.toJSONString(resourceForbiddenIpPortList));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(JSON.toJSONString(unVarnishTransmissionAllowedIpPortList));
        System.out.println(JSON.toJSONString(unVarnishTransmissionForbiddenIpPortList));

    }
}
