package com.lewis.tsp.template;

import com.alibaba.fastjson.JSON;
import com.lewis.tsp.strategy.query.QuerySingleTspStrategy;
import com.lewis.tsp.tspManger.TSPManager;
import com.lewis.tsp.util.CommonUtil;
import com.lewis.tsp.vo.*;
import com.lewis.tsp.vo.config.IPEnum;
import com.lewis.tsp.vo.config.IpPortConfig;
import com.lewis.tsp.vo.config.TSPNameConfig;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;

/**
 * Created by zhangminghua on 2016/6/3.
 */
public  class AbstractServiceSplit {

    /**
     * 比如要拆分价格：
     * 1.首先根据配置找到价格拆分后归属哪些IP机器[62/63/64]，不归属哪些机器[40/46/96/209]
     * 2.找到属于价格的TSP列表，不属于价格的TSP列表
     * 3.在归属价格的IP机器上，禁用不属于价格的TSP列表；（在禁用开始前，要查询TSP列表在IP机器上的启用状态，如果已经被禁用的，就不需要二次禁用了，即只需要禁用状态为启用的节点）
     *  在不归属价格的IP机器上，禁用属于价格的TSP列表。
     * 3.这样就完成了价格的拆分
     * @param serviceTypeEnum
     */
    public void splitService(ServiceTypeEnum serviceTypeEnum){
        //a.需要在IP范围内开启的Node列表 比如价格 在62、63、64上
        List<Node> needPermitNodeListOnIP = CommonUtil.getNodeListBelongsToServiceTypeEnum(serviceTypeEnum);
        //c.需要在IP范围内禁止的Node列表 比如产品、资源、接口透传 在62、63、64上
        List<Node> needForbiddenNodeListOnIp = CommonUtil.getNodeListNotBelongsToServiceTypeEnum(serviceTypeEnum);
        //b.需要在IP范围外禁止的Node列表 比如价格在40、46、96、209上
        List<Node> needForbiddenNodeListNotOnIp = CommonUtil.getServiceTypeEnumNotIpNodeList(serviceTypeEnum);
        String tspName = getTestTspName(serviceTypeEnum);
        QueryResultVo queryResultVo = QuerySingleTspStrategy.querySingleTsp(tspName);
        //a.需要在IP范围内开启的Node列表 比如价格 在62、63、64上
        List<Node>[] nodeArray = getForbiddenAndPermitNodeListArray(needPermitNodeListOnIP,queryResultVo);
        if (nodeArray != null && nodeArray.length >= 1) {
            //真正应该开启的节点列表
            List<Node> notPermitNodeListOfNeedPermitListOnIp =nodeArray[0];
            if (CollectionUtils.isNotEmpty(notPermitNodeListOfNeedPermitListOnIp)) {
                System.out.println("真正应该开启的节点列表 "+JSON.toJSONString(notPermitNodeListOfNeedPermitListOnIp));
               // doOperation(notPermitNodeListOfNeedPermitListOnIp,TspOperation.PERMISSION);
            }
        }

        //b.需要在IP范围外禁止的Node列表 比如价格在40、46、96、209上
        nodeArray = getForbiddenAndPermitNodeListArray(needForbiddenNodeListNotOnIp, queryResultVo);
        if (nodeArray != null && nodeArray.length == 2) {
            //真正应该禁止的节点列表
            List<Node> notForbiddenNodeListButNeedForbiddenNotOnIp = nodeArray[1];
            if (CollectionUtils.isNotEmpty(notForbiddenNodeListButNeedForbiddenNotOnIp)) {
                System.out.println("真正应该禁止的节点列表 "+JSON.toJSONString(notForbiddenNodeListButNeedForbiddenNotOnIp));
               // doOperation(notForbiddenNodeListButNeedForbiddenNotOnIp,TspOperation.FORBIDDEN);
            }
        }

        //c.需要在IP范围内禁止的Node列表 比如产品、资源、接口透传 在62、63、64上
        String[] testTspNameOnOtherServiceTypeEnum=  getTestTspNameOnOtherServiceTypeEnum(serviceTypeEnum);
        if (testTspNameOnOtherServiceTypeEnum != null && testTspNameOnOtherServiceTypeEnum.length == 3) {
            QueryResultVo queryResultVo1 = QuerySingleTspStrategy.querySingleTsp(testTspNameOnOtherServiceTypeEnum[0]);
            nodeArray = getForbiddenAndPermitNodeListArray(needForbiddenNodeListOnIp, queryResultVo1);
            if (nodeArray != null && nodeArray.length >= 1) {
                List<Node> notForbiddenNodeListButNeedForbiddenNotOnIp = nodeArray[1];
                if (CollectionUtils.isNotEmpty(notForbiddenNodeListButNeedForbiddenNotOnIp)) {
                    System.out.println("真正应该禁止的节点列表1 "+JSON.toJSONString(notForbiddenNodeListButNeedForbiddenNotOnIp));
                    // doOperation(notForbiddenNodeListButNeedForbiddenNotOnIp,TspOperation.FORBIDDEN);
                }
            }

            QueryResultVo queryResultVo2 = QuerySingleTspStrategy.querySingleTsp(testTspNameOnOtherServiceTypeEnum[1]);
            nodeArray = getForbiddenAndPermitNodeListArray(needForbiddenNodeListOnIp, queryResultVo2);
            if (nodeArray != null && nodeArray.length >= 1) {
                List<Node> notForbiddenNodeListButNeedForbiddenNotOnIp = nodeArray[1];
                if (CollectionUtils.isNotEmpty(notForbiddenNodeListButNeedForbiddenNotOnIp)) {
                    System.out.println("真正应该禁止的节点列表2 "+JSON.toJSONString(notForbiddenNodeListButNeedForbiddenNotOnIp));
                    // doOperation(notForbiddenNodeListButNeedForbiddenNotOnIp,TspOperation.FORBIDDEN);
                }
            }

            QueryResultVo queryResultVo3 = QuerySingleTspStrategy.querySingleTsp(testTspNameOnOtherServiceTypeEnum[2]);
            nodeArray = getForbiddenAndPermitNodeListArray(needForbiddenNodeListOnIp, queryResultVo3);
            if (nodeArray != null && nodeArray.length >= 1) {
                List<Node> notForbiddenNodeListButNeedForbiddenNotOnIp = nodeArray[1];
                if (CollectionUtils.isNotEmpty(notForbiddenNodeListButNeedForbiddenNotOnIp)) {
                    System.out.println("真正应该禁止的节点列表3 "+JSON.toJSONString(notForbiddenNodeListButNeedForbiddenNotOnIp));
                    // doOperation(notForbiddenNodeListButNeedForbiddenNotOnIp,TspOperation.FORBIDDEN);
                }
            }
        }
    }

    private String[] getTestTspNameOnOtherServiceTypeEnum(ServiceTypeEnum serviceTypeEnum) {
        String[] retArray = new String[3];
        if (serviceTypeEnum == ServiceTypeEnum.PRICE) {
            retArray[0] = TSPNameConfig.getTestProductTspName();
            retArray[1] = TSPNameConfig.getTestResourceTspName();
            retArray[2] = TSPNameConfig.getTestUnvarnishTransmissionTspName();
        }else if (serviceTypeEnum == ServiceTypeEnum.PRODUCT) {
            retArray[0] = TSPNameConfig.getTestPriceTspName();
            retArray[1] = TSPNameConfig.getTestResourceTspName();
            retArray[2] = TSPNameConfig.getTestUnvarnishTransmissionTspName();
        }else if (serviceTypeEnum == ServiceTypeEnum.RESOURCE) {
            retArray[0] = TSPNameConfig.getTestPriceTspName();
            retArray[1] = TSPNameConfig.getTestProductTspName();
            retArray[2] = TSPNameConfig.getTestUnvarnishTransmissionTspName();
        }else if (serviceTypeEnum == ServiceTypeEnum.UNVARNISH_TRANSMISSION) {
            retArray[0] = TSPNameConfig.getTestPriceTspName();
            retArray[1] = TSPNameConfig.getTestProductTspName();
            retArray[2] = TSPNameConfig.getTestResourceTspName();
        }
        return retArray;
    }

    private String getTestTspName(ServiceTypeEnum serviceTypeEnum) {
        String tspName = null;
        if (serviceTypeEnum == ServiceTypeEnum.PRICE) {
            tspName = TSPNameConfig.getTestPriceTspName();
        }else if (serviceTypeEnum == ServiceTypeEnum.PRODUCT) {
            tspName = TSPNameConfig.getTestProductTspName();
        }else if (serviceTypeEnum == ServiceTypeEnum.RESOURCE) {
            tspName = TSPNameConfig.getTestResourceTspName();
        }else if (serviceTypeEnum == ServiceTypeEnum.UNVARNISH_TRANSMISSION) {
            tspName = TSPNameConfig.getTestUnvarnishTransmissionTspName();
        }
        return tspName;
    }

    //开启这些节点上面的服务
    private void doOperation(List<Node> notPermitNodeListOfNeedPermitListOnIp,TspOperation tspOperation) {
        try {
            if (CollectionUtils.isNotEmpty(notPermitNodeListOfNeedPermitListOnIp)) {
                for (Node node : notPermitNodeListOfNeedPermitListOnIp) {
                    List<String> ipPortList = node.getIpEnum().getIpPortList();
                    List<String> tspNameList = node.getServiceTypeEnum().getTspNameList();
                    TSPManager.forbiddenOrPermitTspOfBatch(tspNameList, ipPortList, tspOperation);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取在该节点被禁用和被启用的NodeList的数组，
     * @param needPermitNodeListOnIP
     * @param queryResultVo
     * @return
     */
    private List<Node>[] getForbiddenAndPermitNodeListArray(List<Node> needPermitNodeListOnIP, QueryResultVo queryResultVo) {
        List<Node>[] retArray = new List[2];
        SimpleAddressVo forbiddenAddresss = queryResultVo.getForbiddenAddresss();
        SimpleAddressVo permitAddress = queryResultVo.getPermitAddress();
        if (forbiddenAddresss != null) {
            List<String> ipPortList = forbiddenAddresss.getIpPortList();
            List<Node> ipNodeList = getNodes(needPermitNodeListOnIP, ipPortList);
            retArray[0] =ipNodeList;
        }
        if (permitAddress != null) {
            List<String> ipPortList = permitAddress.getIpPortList();
            List<Node> ipNodeList = getNodes(needPermitNodeListOnIP,ipPortList);
            retArray[1]=ipNodeList;
        }
        return retArray;
    }

    private List<Node> getNodes(List<Node> needPermitNodeListOnIP, List<String> ipPortList) {
        List<Node> ipNodeList = null;
        if (CollectionUtils.isNotEmpty(ipPortList)) {
            Map<String, IPEnum> ip2IPEnumMap = IpPortConfig.getIp2IPEnumMap();
            for (String ipPort : ipPortList) {
                String allIPString = ipPort.substring(0, ipPort.indexOf(":"));
                String  simpleIP = allIPString.split("\\.")[3];
                IPEnum ipEnum = ip2IPEnumMap.get(simpleIP);
                 ipNodeList = CommonUtil.getIpNodeList(needPermitNodeListOnIP, ipEnum);
            }
        }
        return ipNodeList;
    }


    /*public void splitService(ServiceTypeEnum serviceTypeEnum){
        //1.首先根据配置找到价格拆分后归属哪些IP机器[62/63/64]，不归属哪些机器[40/46/96/209]
        Map<String, List<String>> stringListMap = CommonUtil.readProperty(Constants.getConfigPath());
        List<String>[] ipPortListArray = getBelongsToServiceIpPortList(serviceTypeEnum,stringListMap);
        if (ipPortListArray != null && ipPortListArray.length >= 2) {
            List<String> belongsToServiceIpPortList = ipPortListArray[0];
            List<String> notBelongsToServiceIpPortList = ipPortListArray[1];


            //2.找到属于价格的TSP列表，不属于价格的TSP列表
            List<String> belongsToServiceTspNameList = serviceTypeEnum.getTspNameList();
            List<String> notBelongsToServiceTspNameList = getNotBelongsToServiceTspNameList(serviceTypeEnum);
            System.out.println("belongsToServiceIpPortList ="+ JSON.toJSONString(belongsToServiceIpPortList));
            System.out.println("notBelongsToServiceIpPortList ="+ JSON.toJSONString(notBelongsToServiceIpPortList));
            System.out.println("belongsToServiceTspNameList="+JSON.toJSONString(belongsToServiceTspNameList));
            System.out.println("notBelongsToServiceTspNameList="+JSON.toJSONString(notBelongsToServiceTspNameList));

            //3.在归属价格的IP机器上，禁用不属于价格的TSP列表；
            //在禁用开始前，要查询TSP列表在IP机器上的启用状态，如果已经被禁用的，就不需要二次禁用了，即只需要禁用状态为启用的节点


            //4.  在不归属价格的IP机器上，禁用属于价格的TSP列表
        }
    }*/

    public static void main(String[] args) {

        new AbstractServiceSplit().splitService(ServiceTypeEnum.PRICE);
    }

    private List<String> getNotBelongsToServiceTspNameList(ServiceTypeEnum serviceTypeEnum) {
        List<String> retList = new LinkedList<String>();
        if (serviceTypeEnum != null) {
            ServiceTypeEnum[] values = ServiceTypeEnum.values();
            if (values != null && values.length > 0) {
                for (ServiceTypeEnum ste : values) {
                    if (!ste.name().equals(serviceTypeEnum.name())) {
                        retList.addAll(ste.getTspNameList());
                    }
                }
            }
        }
        return retList;
    }

    private List<String>[] getBelongsToServiceIpPortList(ServiceTypeEnum serviceTypeEnum, Map<String, List<String>> stringListMap) {
        List<String> belongsToServiceIpPortList = new LinkedList<String>();
        List<String> notBelongsToServiceIpPortList = new LinkedList<String>();
        if (serviceTypeEnum != null && stringListMap != null) {
            System.out.println("name = "+serviceTypeEnum.name());
            Iterator<Map.Entry<String, List<String>>> it = stringListMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, List<String>> entry = it.next();
                System.out.println("key = "+entry.getKey());
                if (serviceTypeEnum.getName().equals(entry.getKey())) {
                    belongsToServiceIpPortList.addAll(entry.getValue());
                }else{
                    notBelongsToServiceIpPortList.addAll(entry.getValue());
                }
            }
        }
        List<String>[] retArray= new List[]{belongsToServiceIpPortList, notBelongsToServiceIpPortList};
        return retArray;
    }

}
