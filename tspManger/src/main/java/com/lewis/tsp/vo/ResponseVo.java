package com.lewis.tsp.vo;

import java.util.List;

/**
 * Created by zhangminghua on 2016/5/23.
 */
public class ResponseVo {
    private boolean success ;

    private String msg;

    private int errorCode;

    private ResponseDataVo data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public ResponseDataVo getData() {
        return data;
    }

    public void setData(ResponseDataVo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseVo{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", errorCode=" + errorCode +
                ", data=" + data +
                '}';
    }

    public static class ResponseDataVo {
        int count;

        private List<TspProviderVo> rows;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<TspProviderVo> getRows() {
            return rows;
        }

        public void setRows(List<TspProviderVo> rows) {
            this.rows = rows;
        }

        @Override
        public String toString() {
            return "ResponseDataVo{" +
                    "count=" + count +
                    ", rows=" + rows +
                    '}';
        }

    }
}


