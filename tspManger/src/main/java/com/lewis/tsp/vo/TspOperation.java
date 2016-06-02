package com.lewis.tsp.vo;

/**
 * Created by zhangminghua on 2016/5/23.
 */
public enum TspOperation {

    PERMISSION(1),FORBIDDEN(2);
    private int operCode;

    public int getOperCode() {
        return operCode;
    }

    TspOperation(int operCode) {
        this.operCode = operCode;
    }
}
