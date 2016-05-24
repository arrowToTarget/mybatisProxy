package com.lewis.tsp.strategy;

import com.lewis.tsp.tspManger.OperationTspService;
import com.lewis.tsp.vo.ServiceType;
import com.lewis.tsp.vo.config.ServiceConfig;

/**
 * Created by zhangminghua on 2016/5/24.
 */
public class ServiceSpitTypeStrategy implements PermitForbiddenStrtegy {

    private ServiceType serviceType;

    public ServiceSpitTypeStrategy(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public void forbidden() {
        if (serviceType != null) {
            if (serviceType == ServiceType.PRICE) {
                OperationTspService.forbiddenTspService(ServiceConfig.getPriceAppSplitConfig());
            }else if (serviceType == ServiceType.PRODUCT) {
                OperationTspService.forbiddenTspService(ServiceConfig.getProductAppSplitConfig());
            }else if (serviceType == ServiceType.RESOURCE) {
                OperationTspService.forbiddenTspService(ServiceConfig.getResourceAppSplitConfig());

            }else if (serviceType == ServiceType.VARNISH_TRANSMISSION) {
                OperationTspService.forbiddenTspService(ServiceConfig.getUnVarnishTransmissionAppSplitConfig());
            }
        }
    }

    public void permit() {
        if (serviceType != null) {
            if (serviceType == ServiceType.PRICE) {
                OperationTspService.permitTspService(ServiceConfig.getPriceAppSplitConfig());
            }else if (serviceType == ServiceType.PRODUCT) {
                OperationTspService.permitTspService(ServiceConfig.getProductAppSplitConfig());
            }else if (serviceType == ServiceType.RESOURCE) {
                OperationTspService.permitTspService(ServiceConfig.getResourceAppSplitConfig());
            }else if (serviceType == ServiceType.VARNISH_TRANSMISSION) {
                OperationTspService.permitTspService(ServiceConfig.getUnVarnishTransmissionAppSplitConfig());
            }
        }
    }
}
