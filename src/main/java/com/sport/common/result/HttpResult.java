package com.sport.common.result;

import java.util.List;

public class HttpResult<T> {
    private  T obj; // 返回数据对象
    private List<T> data; //返回数据列表
    private boolean success = true; //成功提示
    private String info; //提示

    private Long iTotalRecords;
    private Long iTotalDisplayRecords;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(Long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public Long getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "obj=" + obj +
                ", data=" + data +
                ", success=" + success +
                ", info='" + info + '\'' +
                ", iTotalRecords=" + iTotalRecords +
                ", iTotalDisplayRecords=" + iTotalDisplayRecords +
                '}';
    }
}
