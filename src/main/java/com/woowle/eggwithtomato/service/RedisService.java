package com.woowle.eggwithtomato.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class RedisService {

    @Cacheable(value = "redis", key = "#key")
    public String redis(String key) {
        return "请设置redis值...";
    }
}
