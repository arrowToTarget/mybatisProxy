package com.lewis.tsp.vo;

import com.alibaba.fastjson.JSON;
import java.util.*;

/**
 * Created by zhangminghua on 2016/5/23.
 */
public final class Constants {
    private Constants(){}

    public static final String SERVICE_TPYE_PRICE ="price";

    public static final String SERVICE_TPYE_PRODUCT ="product";

    public static final String SERVICE_TPYE_RESOURCE ="resource";

    public static final String SERVICE_TPYE_VARNISH_TRANSMISSION ="varnish-transmission";

    //查询TSP服务的地址列表信息的URL
    public static final String URL_GET_TSP_IP_LIST ="http://public-api.bj.pla.tuniu.org/tsg/register/service/address/query";

    //禁用、启用TSP服务的URL
    public static final String URL_POST_FORBIDDEN="http://public-api.bj.pla.tuniu.org/tsg/register/provider/config";

    //批量禁用、启用TSP服务的URL
    public static final String URL_POST_FORBIDDEN_BATCH ="http://public-api.bj.pla.tuniu.org/tsg/register/provider/batch/config";

    //14个价格服务
    public static final List<String> priceTspNameList
            = Arrays.asList(
            "BOH.NM.ProductController.getPriceCalendar","BOH.NM.ProductController.queryProductStartPrice",
            "BOH.NM.ProductController.queryProductPromotionInfo","BOH.NM.ProductController.queryDepartureCityInfoWithPrice",
            "BOH.NM.NgResourceController.getBoss3ResCalendar","BOH.NM.ProductController.queryHotelPrices",
            "BOH.NM.NgResourceController.queryFlightLowestCalendar","BOH.NM.ProductController.queryCostCalendar",
            "BOH.NM.ProductController.queryProductPromotionStartPrice","BOH.NM.ProductController.getDistributionPriceCalendar",
            "BOH.NM.HotelChannelController.queryLocalHotelPrices","BOH.NM.ProductController.queryProductDistributionStartPrice",
            "BOH.NM.ProductController.getCombinationCalendar","BOH.NM.NgResourceController.queryResCalendar");

    //30个产品服务
    public static final List<String> productTspNameList
            = Arrays.asList(
            "BOH.NM.ProductController.getDetail","BOH.NM.ProductController.queryCommonProductInfos",
            "BOH.NM.ProductController.queryProductInstallment","BOH.NM.ProductController.getProductType",
            "BOH.NM.GuideController.getProductGuideInfo","BOH.NM.ProductController.getScenicInfo",
            "BOH.NM.ProductController.queryJourneyAndResInfo","BOH.NM.ProductController.queryNewByOriginal",
            "BOH.NM.ProductController.getMultiJourneyInfoAndTranspInfo","BOH.NM.QuestionAndAnswerContoller.getQuestionAndAnswer",
            "BOH.NM.ProductController.getBatchStatus","BOH.NM.ProductController.getBatchDetails",
            "BOH.NM.ProductController.getBatchScenicInfo","BOH.NM.ProductController.getNoticeInfo",
            "BOH.NM.ProductController.getBatchAgencies","BOH.NM.ProductController.getInsuranceInfo",
            "BOH.NM.ProductController.queryMainRouteId","BOH.NM.ProductController.queryList",
            "BOH.NM.ProductController.queryCount","BOH.NM.GuideController.getGuideList",
            "BOH.NM.CategoryByDepartCityControler.getCategoryInfo","BOH.NM.HotelGroupController.queryHotelGrouplist",
            "BOH.NM.HotelGroupController.getHotelGroupsummary","BOH.NM.QuestionAndAnswerContoller.getQuestionType",
            "BOH.NM.ProductController.baokuanProduct","BOH.NM.ProductController.contractLoseInfoQuery",
            "BOH.NM.CompanyController.getByCityCode","BOH.NM.ProductController.queryOriginalByNew",
            "BOH.NM.CityQueryControler.getCities","BOH.NM.HotelGroupController.getHotelGroupHotList");

    //9个资源服务 新加服务c
    public static final List<String> resourceTspNameList
            = Arrays.asList(
            "BOH.NM.NgResourceController.getByResIds","BOH.NM.ProductController.getDetailResources",
            "BOH.NM.FlightTicketChannelController.queryAirportCity","BOH.NM.TrainTicketChannelController.getCities",
            "BOH.NM.ProductController.queryMatchedInsurances","BOH.NM.NgResourceController.getConsulateAndConsularDistrictInfo",
            "BOH.NM.HotelChannelController.queryHotelDetail","BOH.NM.NgResourceController.queryCruiseResDetail",
            "BOH.NM.NgResourceController.queryResList");

    //34个透传服务
    public static final List<String> unVarnishTransmissionTspNameList
            = Arrays.asList(
            "BOH.NM.FlightTicketChannelController.queryFlightIndivPriceCalendar","BOH.NM.NgResourceController.queryResourceRelation",
            "BOH.NM.FlightTicketChannelController.queryFlightIndivRecommended","BOH.NM.FlightTicketChannelController.queryHotCity",
            "BOH.NM.FlightTicketChannelController.flightIndivSpecialOffer","BOH.NM.NgResourceController.queryFlightIndivIntLowest",
            "BOH.NM.FlightTicketChannelController.searchFlightInt","BOH.NM.NgResourceController.queryStockResourceTotalOccupationOutLeftInfo",
            "BOH.NM.HotelChannelController.queryRatePlanV3","BOH.NM.FlightTicketChannelController.searchFlightIntNew",
            "BOH.NM.FlightTicketChannelController.flightIndivVerify","BOH.NM.FlightTicketChannelController.fuzzyMatch",
            "BOH.NM.HotelChannelController.queryHotelConfigList","BOH.NM.NgResourceController.queryFlightIndiv",
            "BOH.NM.HotelChannelController.queryHotelList","BOH.NM.FlightTicketChannelController.queryBestBuy",
            "BOH.NM.FlightTicketChannelController.checkCabinAndPrice","BOH.NM.FlightTicketChannelController.queryFlightIndivRefundAndReissue",
            "BOH.NM.HotelChannelController.saveResource","BOH.NM.HotelChannelController.queryResourceDetailV3",
            "BOH.NM.FlightTicketChannelController.queryFareRemarkNew","BOH.NM.FlightTicketChannelController.queryFareRemark",
            "BOH.NM.FlightTicketChannelController.queryFlightSpecialInquiry","BOH.NM.HotelChannelController.queryInternationalHotelDetail",
            "BOH.NM.FlightTicketChannelController.flightIndivPreferential","BOH.NM.HotelChannelController.queryInternationalHotelBookingInfo",
            "BOH.NM.HotelChannelController.queryConfigLowerPrice","BOH.NM.NgResourceController.queryFlightIndivPreferential",
            "BOH.NM.FlightTicketChannelController.queryRuleById","BOH.NM.TrainTicketChannelController.queryTrainInfo",
            "BOH.NM.ProductController.baokuanProductRes","BOH.NM.ProductController.baokuanProductUpgrade",
            "BOH.NM.FlightTicketChannelController.queryStartPrice","BOH.NM.NgResourceController.queryFlightIndivInt");


    //价格服务 允许开启的服务地址
    public static final List<String> priceAllowIpPortList
            = Arrays.asList(
            "10.40.50.62:12501","10.40.50.62:12502","10.40.50.62:12503","10.40.50.62:12504","10.40.50.62:12505","10.40.50.62:12506","10.40.50.62:12507",
            "10.40.50.63:12501","10.40.50.63:12502","10.40.50.63:12503","10.40.50.63:12504","10.40.50.63:12505","10.40.50.63:12506","10.40.50.63:12507",
            "10.40.50.64:12501","10.40.50.64:12502","10.40.50.64:12503","10.40.50.64:12504","10.40.50.64:12505","10.40.50.64:12506","10.40.50.64:12507");

    //产品服务 允许开启的服务地址
    public static final List<String> productAllowIpPortList
            = Arrays.asList(
            "10.40.189.40:12501","10.40.189.40:12502","10.40.189.40:12503","10.40.189.40:12504","10.40.189.40:12505","10.40.189.40:12506","10.40.189.40:12507",
            "10.40.189.46:12501","10.40.189.46:12502","10.40.189.46:12503","10.40.189.46:12504","10.40.189.46:12505","10.40.189.46:12506","10.40.189.46:12507");

    //资源服务 允许开启的服务地址
    public static final List<String> resourceAllowIpPortList
            = Arrays.asList("10.40.189.96:12501","10.40.189.96:12502","10.40.189.96:12503","10.40.189.96:12504","10.40.189.96:12505","10.40.189.96:12506","10.40.189.96:12507");

    //接口透传服务 允许开启的服务地址
    public static final List<String> unVarnishTransmissionAllowIpPortList
            = Arrays.asList("10.40.190.209:12501","10.40.190.209:12502","10.40.190.209:12503","10.40.190.209:12504","10.40.190.209:12505","10.40.190.209:12506","10.40.190.209:12507");

    //BOH 总的服务地址
    public static final List<String> allAllowIpPortList = new LinkedList<String>();

    //价格服务 禁止开启的服务地址
    public static final List<String> priceForbiddenIpPortList = new LinkedList<String>();

    //产品服务 禁止开启的服务地址
    public static final List<String> productForbiddenIpPortList = new LinkedList<String>();

    //资源服务 禁止开启的服务地址
    public static final List<String> resourceForbiddenIpPortList = new LinkedList<String>();

    //接口透传服务 禁止开启的服务地址
    public static final List<String> unVarnishTransmissionForbiddenIpPortList = new LinkedList<String>();

    //价格服务的 配置
    public static AppSplitConfig priceAppSplitConfig = new AppSplitConfig();

    //产品服务的配置
    public static AppSplitConfig productAppSplitConfig = new AppSplitConfig();

    //资源服务的配置
    public static AppSplitConfig resourceAppSplitConfig = new AppSplitConfig();

    //接口透传服务的配置
    public static AppSplitConfig unVarnishTransmissionAppSplitConfig = new AppSplitConfig();

    static {
        allAllowIpPortList.addAll(priceAllowIpPortList);
        allAllowIpPortList.addAll(productAllowIpPortList);
        allAllowIpPortList.addAll(resourceAllowIpPortList);
        allAllowIpPortList.addAll(unVarnishTransmissionAllowIpPortList);

        //设置价格服务 禁止的IP
        List<String> tmpAllowIpPortList = new ArrayList<String>(allAllowIpPortList.size());
        CommonUtil.copyCollection(allAllowIpPortList,tmpAllowIpPortList);
        tmpAllowIpPortList.removeAll(priceAllowIpPortList);
        priceForbiddenIpPortList.addAll(tmpAllowIpPortList);

        //设置产品服务 禁止的IP
        tmpAllowIpPortList.clear();
        CommonUtil.copyCollection(allAllowIpPortList,tmpAllowIpPortList);
        tmpAllowIpPortList.removeAll(productAllowIpPortList);
        productForbiddenIpPortList.addAll(tmpAllowIpPortList);

        //设置资源服务 禁止的IP
        tmpAllowIpPortList.clear();
        CommonUtil.copyCollection(allAllowIpPortList,tmpAllowIpPortList);
        tmpAllowIpPortList.removeAll(resourceAllowIpPortList);
        resourceForbiddenIpPortList.addAll(tmpAllowIpPortList);

        //设置接口透传服务 禁止的IP
        tmpAllowIpPortList.clear();
        CommonUtil.copyCollection(allAllowIpPortList,tmpAllowIpPortList);
        tmpAllowIpPortList.removeAll(unVarnishTransmissionAllowIpPortList);
        unVarnishTransmissionForbiddenIpPortList.addAll(tmpAllowIpPortList);


        priceAppSplitConfig.setServiceType(ServiceType.PRICE);
        priceAppSplitConfig.setAllowIpPortList(priceAllowIpPortList);
        priceAppSplitConfig.setForbiddenIpPortList(priceForbiddenIpPortList);
        priceAppSplitConfig.setTspNameList(priceTspNameList);

        productAppSplitConfig.setServiceType(ServiceType.PRODUCT);
        productAppSplitConfig.setAllowIpPortList(productAllowIpPortList);
        productAppSplitConfig.setForbiddenIpPortList(productForbiddenIpPortList);
        productAppSplitConfig.setTspNameList(productTspNameList);

        resourceAppSplitConfig.setServiceType(ServiceType.RESOURCE);
        resourceAppSplitConfig.setAllowIpPortList(resourceAllowIpPortList);
        resourceAppSplitConfig.setForbiddenIpPortList(resourceForbiddenIpPortList);
        resourceAppSplitConfig.setTspNameList(resourceTspNameList);

        unVarnishTransmissionAppSplitConfig.setServiceType(ServiceType.VARNISH_TRANSMISSION);
        unVarnishTransmissionAppSplitConfig.setAllowIpPortList(unVarnishTransmissionAllowIpPortList);
        unVarnishTransmissionAppSplitConfig.setForbiddenIpPortList(unVarnishTransmissionForbiddenIpPortList);
        unVarnishTransmissionAppSplitConfig.setTspNameList(unVarnishTransmissionTspNameList);
    }



    public static void main(String[] args) {
        System.out.println("price Allow ip:"+JSON.toJSONString(priceAllowIpPortList));
        System.out.println("price Forbidden ip:"+JSON.toJSONString(priceForbiddenIpPortList));
        System.out.println("============================");
        System.out.println("product Allow ip:"+JSON.toJSONString(productAllowIpPortList));
        System.out.println("product Forbidden ip:"+JSON.toJSONString(productForbiddenIpPortList));
        System.out.println("============================");
        System.out.println("resource Allow ip:"+JSON.toJSONString(resourceAllowIpPortList));
        System.out.println("resource Forbidden ip:"+JSON.toJSONString(resourceForbiddenIpPortList));
        System.out.println("============================");
        System.out.println("varnish-transmission Allow ip:"+JSON.toJSONString(unVarnishTransmissionAllowIpPortList));
        System.out.println("varnish-transmission Forbidden ip:"+JSON.toJSONString(unVarnishTransmissionForbiddenIpPortList));
        System.out.println("============================");
        System.out.println("all "+JSON.toJSONString(allAllowIpPortList));
    }





}
