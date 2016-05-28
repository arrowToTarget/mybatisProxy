package com.lewis.tsp.vo.config;

/**
 * Created by zhangminghua on 2016/5/28.
 */
public enum IPPortEnum {
    IPPort62_01(IpPortConfig.getIpPort6201()),
    IPPort62_02(IpPortConfig.getIpPort6202()),
    IPPort62_03(IpPortConfig.getIpPort6203()),
    IPPort62_04(IpPortConfig.getIpPort6204()),
    IPPort62_05(IpPortConfig.getIpPort6205()),
    IPPort62_06(IpPortConfig.getIpPort6206()),
    IPPort62_07(IpPortConfig.getIpPort6207()),

    IPPort63_01(IpPortConfig.getIpPort6301()),
    IPPort63_02(IpPortConfig.getIpPort6302()),
    IPPort63_03(IpPortConfig.getIpPort6303()),
    IPPort63_04(IpPortConfig.getIpPort6304()),
    IPPort63_05(IpPortConfig.getIpPort6305()),
    IPPort63_06(IpPortConfig.getIpPort6306()),
    IPPort63_07(IpPortConfig.getIpPort6307()),

    IPPort64_01(IpPortConfig.getIpPort6401()),
    IPPort64_02(IpPortConfig.getIpPort6402()),
    IPPort64_03(IpPortConfig.getIpPort6403()),
    IPPort64_04(IpPortConfig.getIpPort6404()),
    IPPort64_05(IpPortConfig.getIpPort6405()),
    IPPort64_06(IpPortConfig.getIpPort6406()),
    IPPort64_07(IpPortConfig.getIpPort6407()),

    IPPort40_01(IpPortConfig.getIpPort4001()),
    IPPort40_02(IpPortConfig.getIpPort4002()),
    IPPort40_03(IpPortConfig.getIpPort4003()),
    IPPort40_04(IpPortConfig.getIpPort4004()),
    IPPort40_05(IpPortConfig.getIpPort4005()),
    IPPort40_06(IpPortConfig.getIpPort4006()),
    IPPort40_07(IpPortConfig.getIpPort4007()),

    IPPort46_01(IpPortConfig.getIpPort4601()),
    IPPort46_02(IpPortConfig.getIpPort4602()),
    IPPort46_03(IpPortConfig.getIpPort4603()),
    IPPort46_04(IpPortConfig.getIpPort4604()),
    IPPort46_05(IpPortConfig.getIpPort4605()),
    IPPort46_06(IpPortConfig.getIpPort4606()),
    IPPort46_07(IpPortConfig.getIpPort4607()),

    IPPort96_01(IpPortConfig.getIpPort9601()),
    IPPort96_02(IpPortConfig.getIpPort9602()),
    IPPort96_03(IpPortConfig.getIpPort9603()),
    IPPort96_04(IpPortConfig.getIpPort9604()),
    IPPort96_05(IpPortConfig.getIpPort9605()),
    IPPort96_06(IpPortConfig.getIpPort9606()),
    IPPort96_07(IpPortConfig.getIpPort9607()),

    IPPort209_01(IpPortConfig.getIpPort20901()),
    IPPort209_02(IpPortConfig.getIpPort20902()),
    IPPort209_03(IpPortConfig.getIpPort20903()),
    IPPort209_04(IpPortConfig.getIpPort20904()),
    IPPort209_05(IpPortConfig.getIpPort20905()),
    IPPort209_06(IpPortConfig.getIpPort20906()),
    IPPort209_07(IpPortConfig.getIpPort20907());


    private String ipPort;

    IPPortEnum(String ipPort) {
        this.ipPort = ipPort;
    }

    public String getIpPort() {

        return ipPort;
    }
}
