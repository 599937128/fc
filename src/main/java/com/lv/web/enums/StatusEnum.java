package com.lv.web.enums;

public enum StatusEnum {

    SUCCESS("200", "请求成功"),

    FAIL("403", "请求数据失败"),
    UNAUTHORIZED("401", "验证身份失败"),
    DISPOSE_FAILED("10000", "请求处理异常"),
    RESULT_DATA_EMPTY("10001", "返回数据为空"),
    SESSION_TIMEOUT("10302", "登录过期"),
    BEHAVIOR_NOT_ALLOWED("10307", "   行为不被允许");

    private String status;
    private String desc;

    StatusEnum(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
