package com.woowle.eggwithtomato.controller;

import com.woowle.eggwithtomato.common.VO.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试通用redis返回
 *
 * @author JiangaoXia
 * @date 2018/12/24 9:31
 */
@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("reids")
    public Result redis(@RequestParam("key") String key, String value) {
        if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
            redisTemplate.opsForValue().set(key, value);
        } else {
            value = (String) redisTemplate.opsForValue().get(key);
        }
        return Result.success(value);
    }
}
