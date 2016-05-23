package com.lewis.tsp.vo;

import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;

/**
 * Created by zhangminghua on 2016/5/23.
 */
public final class CommonUtil {

    private CommonUtil(){}


    public  static <T> boolean copyCollection(Collection<T> src, Collection<T> dest){
        boolean retFlag = true;
        try {
            if (CollectionUtils.isNotEmpty(src) && dest != null){
                for (T t : src) {
                    if (t instanceof String) {
                        dest.add(t);
                    }
                }
            }
        } catch (Exception e) {
            retFlag = false;
            e.printStackTrace();
        }
        return retFlag;
    }
}
