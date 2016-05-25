package com.lewis.tsp.tspManger;

import com.alibaba.fastjson.JSON;
import com.lewis.tsp.util.Base64Util;
import com.lewis.tsp.util.CommonUtil;
import com.lewis.tsp.vo.*;
import org.apache.commons.collections.CollectionUtils;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public final class TSPManager {

    private TSPManager(){

    }

    public static QueryResultVo queryTspProviderInfo(String tspName) throws Exception{
        if (StringUtils.isEmpty(tspName)) {
            throw new IllegalArgumentException("queryTspProviderInfo tspName cannot be empty");
        }
        GetTSPIPRequestVo requestVo = new GetTSPIPRequestVo(tspName);
        try {
            HttpClient httpClient = new HttpClient();
            String url = Constants.URL_GET_TSP_IP_LIST+"?"+ Base64Util.encode(JSON.toJSONString(requestVo));
            HttpMethod httpMethod = new GetMethod(url);
            httpMethod.releaseConnection();
            httpClient.executeMethod(httpMethod);
            InputStream is = httpMethod.getResponseBodyAsStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String readLine = null;
            while ((readLine = br.readLine())!= null){
                sb.append(readLine);
            }
            //String responseString = httpMethod.getResponseBodyAsString();
            String responseString = sb.toString();
            if (StringUtils.isNotEmpty(responseString)) {
                responseString = Base64Util.decode(responseString);
                ResponseVo responseVo = JSON.parseObject(responseString, ResponseVo.class);
                QueryResultVo queryResultVo = classifyTspProviderInfoIntoMap(responseVo.getData(), requestVo.getName());
                return queryResultVo;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<QueryResultVo> queryTspProviderInfoByServiceType(ServiceType serviceType){
        List<QueryResultVo> retList = new LinkedList<QueryResultVo>();
        List<String> tspNameList = CommonUtil.getTspNameListByServiceType(serviceType);
        try {
            if (CollectionUtils.isNotEmpty(tspNameList)) {
                for (String tspName : tspNameList) {
                    retList.add(queryTspProviderInfo(tspName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retList;
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

    private static QueryResultVo classifyTspProviderInfoIntoMap(ResponseVo.ResponseDataVo data, String tspName) {
        if (data != null && data.getCount() > 0) {
            List<TspProviderVo> allTspProviderVoList = data.getRows();
            QueryResultVo queryResultVo = new QueryResultVo();
            queryResultVo.setTspName(tspName);

            SimpleAddressVo  permitAddresssVo = new SimpleAddressVo();
            List<String> permitAddressList = new LinkedList<String>();
            permitAddresssVo.setIpPortList(permitAddressList);
            queryResultVo.setPermitAddress(permitAddresssVo);

            SimpleAddressVo  forbiddenAddresssVo = new SimpleAddressVo();
            List<String> forbiddenAddressList = new LinkedList<String>();

            queryResultVo.setForbiddenAddresss(forbiddenAddresssVo);

            for (TspProviderVo tspProvider : allTspProviderVoList) {

                int ableFlag = tspProvider.getAbleFlag();
                //启用
                if (ableFlag == 0) {

                    permitAddresssVo.setForbiddenOrPermit("已启用");
                    if (!permitAddressList.contains(tspProvider.getProviderAddress())) {
                        permitAddressList.add(tspProvider.getProviderAddress());
                    }

                }else if (ableFlag == 1) {
                    forbiddenAddresssVo.setForbiddenOrPermit("已禁用");
                    if (!forbiddenAddressList.contains(tspProvider.getProviderAddress())) {
                        forbiddenAddressList.add(tspProvider.getProviderAddress());
                    }
                }

            }
            if (CollectionUtils.isNotEmpty(forbiddenAddressList)) {
                forbiddenAddresssVo.setIpPortList(forbiddenAddressList);
            }
            Comparator<String> ipPortComparator = new Comparator<String>() {
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            };
            if (CollectionUtils.isNotEmpty(queryResultVo.getForbiddenAddresss().getIpPortList())) {
                Collections.sort(queryResultVo.getForbiddenAddresss().getIpPortList(), ipPortComparator);
            }
            if (CollectionUtils.isNotEmpty(queryResultVo.getPermitAddress().getIpPortList())) {
                Collections.sort(queryResultVo.getPermitAddress().getIpPortList(), ipPortComparator);
            }
            return queryResultVo;
        }
        return  null;
    }


}
