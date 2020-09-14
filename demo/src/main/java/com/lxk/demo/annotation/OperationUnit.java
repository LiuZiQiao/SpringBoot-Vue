package com.lxk.demo.annotation;/**
 * @Description TODO
 * @Author liuxk@e6yun.com
 * @Created Date: 2020/8/27 16:54
 * @ClassName OperationUnit
 * @Remark
 */

/**
 * @Description TODO
 * @Author liuxk@e6yun.com
 * @Created Date: 2020/8/27 16:54
 * @ClassName OperationUnit
 * @Remark
 */

public enum OperationUnit {

    /**
     * 被操作的单元
     */
    UNKNOWN("unknown"),
    USER("user"),
    Redis("redis");

    private String value;

    OperationUnit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
