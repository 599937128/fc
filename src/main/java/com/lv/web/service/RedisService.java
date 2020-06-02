package com.lv.web.service;

import java.util.concurrent.TimeUnit;

public interface RedisService {


    /**
     * 新增redis存储
     *
     * @param key
     * @param value
     * @param time
     * @param timeUnit
     */
    void set(String key, String value, int time, TimeUnit timeUnit);

    /**
     * 获取redis存储
     *
     * @param key
     */
    String get(String key);

    /**
     * 移除redis存储
     */
    void del(String key);


}
