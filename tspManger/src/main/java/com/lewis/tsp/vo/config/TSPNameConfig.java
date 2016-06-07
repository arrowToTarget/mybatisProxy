package com.lewis.tsp.vo.config;

import com.lewis.tsp.util.CommonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class TSPNameConfig {

    //14个价格服务
    public static final List<String> priceAllowTspNameList
            = Arrays.asList(
            "BOH.NM.ProductController.getPriceCalendar","BOH.NM.ProductController.queryProductStartPrice",
            "BOH.NM.ProductController.queryProductPromotionInfo","BOH.NM.ProductController.queryDepartureCityInfoWithPrice",
            "BOH.NM.NgResourceController.getBoss3ResCalendar","BOH.NM.ProductController.queryHotelPrices",
            "BOH.NM.NgResourceController.queryFlightLowestCalendar","BOH.NM.ProductController.queryCostCalendar",
            "BOH.NM.ProductController.queryProductPromotionStartPrice","BOH.NM.ProductController.getDistributionPriceCalendar",
            "BOH.NM.HotelChannelController.queryLocalHotelPrices","BOH.NM.ProductController.queryProductDistributionStartPrice",
            "BOH.NM.ProductController.getCombinationCalendar","BOH.NM.NgResourceController.queryResCalendar");

    //30个产品服务
    public static final List<String> productAllowTspNameList
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

    //9个资源服务
    public static final List<String> resourceAllowTspNameList
            = Arrays.asList(
            "BOH.NM.NgResourceController.getByResIds","BOH.NM.ProductController.getDetailResources",
            "BOH.NM.FlightTicketChannelController.queryAirportCity","BOH.NM.TrainTicketChannelController.getCities",
            "BOH.NM.ProductController.queryMatchedInsurances","BOH.NM.NgResourceController.getConsulateAndConsularDistrictInfo",
            "BOH.NM.HotelChannelController.queryHotelDetail","BOH.NM.NgResourceController.queryCruiseResDetail",
            "BOH.NM.NgResourceController.queryResList");

    //34个透传服务
    public static final List<String> unVarnishAllowTransmissionTspNameList
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


    public static final List<String> testTspNameList
            = Arrays.asList("BOH.NM.ProductController.baokuanProduct","BOH.NM.FlightTicketChannelController.flightIndivPreferential",
            "BOH.NM.HotelChannelController.queryInternationalHotelBookingInfo","BOH.NM.ProductController.getCombinationCalendar",
            "BOH.NM.HotelChannelController.queryConfigLowerPrice");

    public static final String testPriceTspName="BOH.NM.ProductController.getPriceCalendar";
    public static final String testProductTspName="BOH.NM.ProductController.getDetail";
    public static final String testResourceTspName="BOH.NM.NgResourceController.getByResIds";
    public static final String testUnvarnishTransmissionTspName="BOH.NM.FlightTicketChannelController.queryFlightIndivPriceCalendar";
    public static final List<String> allServiceTspNameList = new LinkedList<String>();

    public static final List<String> priceForbiddenTspNameList = new LinkedList<String>();
    public static final List<String> productForbiddenTspNameList = new LinkedList<String>();
    public static final List<String> resourceForbiddenTspNameList = new LinkedList<String>();
    public static final List<String> unVarnishTransmissionForbiddenTspNameList = new LinkedList<String>();

    static {
        allServiceTspNameList.addAll(priceAllowTspNameList);
        allServiceTspNameList.addAll(productAllowTspNameList);
        allServiceTspNameList.addAll(resourceAllowTspNameList);
        allServiceTspNameList.addAll(unVarnishAllowTransmissionTspNameList);

        List<String> tmpAllServiceTspNameList = new LinkedList<String>();
        CommonUtil.copyCollection(allServiceTspNameList,tmpAllServiceTspNameList);
        tmpAllServiceTspNameList.removeAll(priceAllowTspNameList);
        priceForbiddenTspNameList.addAll(tmpAllServiceTspNameList);

        tmpAllServiceTspNameList.clear();
        CommonUtil.copyCollection(allServiceTspNameList,tmpAllServiceTspNameList);
        tmpAllServiceTspNameList.removeAll(productAllowTspNameList);
        productForbiddenTspNameList.addAll(tmpAllServiceTspNameList);

        tmpAllServiceTspNameList.clear();
        CommonUtil.copyCollection(allServiceTspNameList,tmpAllServiceTspNameList);
        tmpAllServiceTspNameList.removeAll(resourceAllowTspNameList);
        resourceForbiddenTspNameList.addAll(tmpAllServiceTspNameList);

        tmpAllServiceTspNameList.clear();
        CommonUtil.copyCollection(allServiceTspNameList,tmpAllServiceTspNameList);
        tmpAllServiceTspNameList.removeAll(unVarnishAllowTransmissionTspNameList);
        unVarnishTransmissionForbiddenTspNameList.addAll(tmpAllServiceTspNameList);
    }

    public static List<String> getPriceAllowTspNameList() {
        return priceAllowTspNameList;
    }

    public static List<String> getProductAllowTspNameList() {
        return productAllowTspNameList;
    }

    public static List<String> getResourceAllowTspNameList() {
        return resourceAllowTspNameList;
    }

    public static List<String> getUnVarnishAllowTransmissionTspNameList() {
        return unVarnishAllowTransmissionTspNameList;
    }

    public static List<String> getAllServiceTspNameList() {
        return allServiceTspNameList;
    }

    public static List<String> getPriceForbiddenTspNameList() {
        return priceForbiddenTspNameList;
    }

    public static List<String> getProductForbiddenTspNameList() {
        return productForbiddenTspNameList;
    }

    public static List<String> getResourceForbiddenTspNameList() {
        return resourceForbiddenTspNameList;
    }

    public static List<String> getUnVarnishTransmissionForbiddenTspNameList() {
        return unVarnishTransmissionForbiddenTspNameList;
    }

    public static String getTestPriceTspName() {
        return testPriceTspName;
    }

    public static String getTestProductTspName() {
        return testProductTspName;
    }

    public static String getTestResourceTspName() {
        return testResourceTspName;
    }

    public static String getTestUnvarnishTransmissionTspName() {
        return testUnvarnishTransmissionTspName;
    }


}
