package com.lewis.tsp.tspManger;

import com.alibaba.fastjson.JSON;
import com.lewis.tsp.util.Base64Util;
import com.lewis.tsp.vo.*;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.*;


public final class TSPManager {

    private TSPManager(){

    }

    public static Map<String,List<TspProviderVo>> queryTspProviderInfo(GetTSPIPRequestVo requestVo) throws Exception{
        if (requestVo == null || StringUtils.isEmpty(requestVo.getName())) {
            throw new IllegalArgumentException("queryTspProviderInfo tspName cannot be empty");
        }
        Map<String,List<TspProviderVo>>  ip2tspProviderIpPortMap = new HashMap<String,List<TspProviderVo>>();
        try {
            HttpClient httpClient = new HttpClient();
            String url = Constants.URL_GET_TSP_IP_LIST+"?"+ Base64Util.encode(JSON.toJSONString(requestVo));
            HttpMethod httpMethod = new GetMethod(url);
            httpMethod.releaseConnection();
            httpClient.executeMethod(httpMethod);
            String responseString = httpMethod.getResponseBodyAsString();
            if (StringUtils.isNotEmpty(responseString)) {
                responseString = Base64Util.decode(responseString);
                ResponseVo responseVo = JSON.parseObject(responseString, ResponseVo.class);
                classifyTspProviderInfoIntoMap(responseVo.getData(),ip2tspProviderIpPortMap,requestVo.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ip2tspProviderIpPortMap;
    }

    public static void forbiddenOrPermitTsp(String tspName, String allowIpPort, TspOperation tspOperation) throws Exception{
        if (StringUtils.isEmpty(tspName) || StringUtils.isEmpty(allowIpPort)) {
            throw new IllegalArgumentException("forbiddenOrPermitTsp tspName ["+tspName+"] or allowIpPort ["+allowIpPort+"] cannot be empty");
        }
        DefaultHttpClient httpClient = new DefaultHttpClient();
        TspOperationRequsetVo requsetVo = new TspOperationRequsetVo();
        requsetVo.setName(tspName);
        requsetVo.setProviderAddress(allowIpPort);
        requsetVo.setForbidOper(tspOperation.getOperCode());
        String param = JSON.toJSONString(requsetVo);
        System.out.println(param);
        HttpPost req = new HttpPost(Constants.URL_POST_FORBIDDEN);
        req.setEntity(new StringEntity(Base64Util.encode(param)));
        CloseableHttpResponse response = httpClient.execute(req);
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String result = responseHandler.handleResponse(response);
        result = Base64Util.decode(result);
        System.out.println(result);
        httpClient.getConnectionManager().shutdown();
    }

    public static void forbiddenOrPermitTspOfBatchAtSingleTsp(String tspName,List<String> allowIPPortList,TspOperation tspOperation) throws Exception{
        if (StringUtils.isEmpty(tspName)) {
            throw new IllegalArgumentException("forbiddenOrPermitTspOfBatchAtSingleTsp tspName ["+tspName+"] cannot be empty");
        }
        if (allowIPPortList == null || allowIPPortList.size() == 0) {
            throw new IllegalArgumentException("forbiddenOrPermitTspOfBatchAtSingleTsp allowIPPortList cannot be empty");
        }
        DefaultHttpClient httpClient = new DefaultHttpClient();
        BatchTspOperationRequestVo requestVo = new BatchTspOperationRequestVo();
        requestVo.setForbidOper(tspOperation.getOperCode());
        List<BatchTspOperationRequestVo.TspName2ProviderAddress> list = new LinkedList<BatchTspOperationRequestVo.TspName2ProviderAddress>();
        for (String ipPort : allowIPPortList) {
            list.add(new BatchTspOperationRequestVo.TspName2ProviderAddress(tspName,ipPort));
        }
        requestVo.setProviderList(list);
        HttpPost req = new HttpPost(Constants.URL_POST_FORBIDDEN_BATCH);
        req.setEntity(new StringEntity(Base64Util.encode(JSON.toJSONString(requestVo))));
        CloseableHttpResponse response = httpClient.execute(req);
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String result = responseHandler.handleResponse(response);
        result = Base64Util.decode(result);
        System.out.println("forbiddenOrPermitTspOfBatch result is "+ result);
        httpClient.getConnectionManager().shutdown();
    }

    public static void forbiddenOrPermitTspOfBatch(List<String> tspNames,List<String> allowIPPortList,TspOperation tspOperation) throws Exception{
        if (tspNames == null || tspNames.size() == 0) {
            throw new IllegalArgumentException("forbiddenOrPermitTspOfBatch tspNames cannot be empty");
        }
        if (allowIPPortList == null || allowIPPortList.size() == 0) {
            throw new IllegalArgumentException("forbiddenOrPermitTspOfBatch allowIPPortList cannot be empty");
        }
        DefaultHttpClient httpClient = new DefaultHttpClient();
        BatchTspOperationRequestVo requestVo = new BatchTspOperationRequestVo();
        requestVo.setForbidOper(tspOperation.getOperCode());
        List<BatchTspOperationRequestVo.TspName2ProviderAddress> list = new LinkedList<BatchTspOperationRequestVo.TspName2ProviderAddress>();
        for (String ipPort : allowIPPortList) {
            for (String tspName : tspNames) {
                list.add(new BatchTspOperationRequestVo.TspName2ProviderAddress(tspName,ipPort));
            }
        }
        requestVo.setProviderList(list);
        HttpPost req = new HttpPost(Constants.URL_POST_FORBIDDEN_BATCH);
        req.setEntity(new StringEntity(Base64Util.encode(JSON.toJSONString(requestVo))));
        CloseableHttpResponse response = httpClient.execute(req);
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String result = responseHandler.handleResponse(response);
        result = Base64Util.decode(result);
        System.out.println(result);
        httpClient.getConnectionManager().shutdown();
    }

    private static void classifyTspProviderInfoIntoMap(ResponseVo.ResponseDataVo data, Map<String, List<TspProviderVo>> ip2tspProviderIpMap,String tspName) {
        if (data != null && data.getCount() > 0) {
            List<TspProviderVo> allTspProviderVoList = data.getRows();
            for (TspProviderVo tspProvider : allTspProviderVoList) {
                String ip_port = tspProvider.getProviderAddress();
                String ip = null;
                if (StringUtils.isNotEmpty(ip_port)) {
                    ip = ip_port.substring(0, ip_port.indexOf(":"));
                    ip +="_"+tspName;
                }
                if (StringUtils.isNotEmpty(ip)) {
                    List<TspProviderVo> tspProviderVoList = ip2tspProviderIpMap.get(ip);
                    if (tspProviderVoList == null) {
                        tspProviderVoList = new LinkedList<TspProviderVo>();
                    }
                    tspProviderVoList.add(tspProvider);
                    ip2tspProviderIpMap.put(ip,tspProviderVoList);
                }
            }
        }
    }


}
