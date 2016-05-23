package com.lewis.tsp.tspManger;

import com.alibaba.fastjson.JSON;
import com.lewis.tsp.vo.Constants;
import com.lewis.tsp.vo.GetTSPIPRequestVo;
import com.lewis.tsp.vo.TspOperation;
import com.lewis.tsp.vo.TspProviderVo;
import org.apache.commons.collections.bag.SynchronizedSortedBag;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public  class TSPManagerClient {

    public static void main(String[] args) throws Exception {

       String tspName = "BOH.NM.ProductController.baokuanProduct";
        /*
        System.out.println(tspName);
        GetTSPIPRequestVo requestVo = new GetTSPIPRequestVo(tspName);
        Map<String, List<TspProviderVo>> stringListMap = TSPManager.queryTspProviderInfo(requestVo);
        System.out.println(JSON.toJSONString(stringListMap));*/
      // TSPManager.forbiddenOrPermitTsp(tspName,"10.40.50.63:12507", TspOperation.PERMISSION);
        /*List<String>  ipList
                = Arrays.asList("10.40.50.63:12501","10.40.50.63:12502","10.40.50.63:12503","10.40.50.63:12504",
                "10.40.50.63:12505","10.40.50.63:12506","10.40.50.63:12507");
        List<String> tspNames = Arrays.asList("BOH.NM.ProductController.baokuanProduct","BOH.NM.ProductController.getCombinationCalendar");
        TSPManager.forbiddenOrPermitTspOfBatch(tspNames,ipList,TspOperation.PERMISSION);*/
        //System.out.println(JSON.toJSONString(Constants.allAllowIpPortList));
        System.out.println(JSON.toJSONString(Constants.priceAppSplitConfig));
        System.out.println(JSON.toJSONString(Constants.productAppSplitConfig));
        System.out.println(JSON.toJSONString(Constants.resourceAppSplitConfig));
        System.out.println(JSON.toJSONString(Constants.unVarnishTransmissionAppSplitConfig));

    }
}
