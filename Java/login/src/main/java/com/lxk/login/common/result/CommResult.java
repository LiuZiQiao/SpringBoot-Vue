package com.lxk.login.common.result;

import com.lxk.login.common.Contant;

import java.io.Serializable;

public class CommResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 0:成功/1:失败/2:未登录
     */
    private Integer code = Contant.RESULT_SUCCESS;
    /**
     * 返回内容
     */
    private Object content;
    /**
     * code为1时错误信息内容
     */
    private String message = "";

    public CommResult() {
    }

    public CommResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static CommResult ok() {
        CommResult result = new CommResult();
        return result;
    }

    public static CommResult ok(Object data) {
        CommResult result = new CommResult();
        result.setContent(data);
        return result;
    }

    public static CommResult error() {
        CommResult result = new CommResult();
        result.setCode(Contant.RESULT_FAILED);
        return result;
    }

    public static CommResult error(String message) {
        CommResult result = new CommResult();
        result.setCode(Contant.RESULT_FAILED);
        result.setMessage(message);
        return result;
    }

    public static CommResult error(Integer code, String message) {
        CommResult result = new CommResult();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static CommResult error(Object data) {
        CommResult result = new CommResult();
        result.setCode(Contant.RESULT_FAILED);
        result.setContent(data);
        return result;
    }
}
