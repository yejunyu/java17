package com.yejunyu;

import com.alibaba.fastjson.JSON;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yejunyu
 * @Date: Created in 2023/6/29
 * @Description: TODO
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final String CALLBACK_KEY = "account:deviceBind:deviceImei:%s";

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private UserRepository userRepository;

    @Test
    public void test1() {
        String key = "key1";
        String o = redisTemplate.boundValueOps(key).get();
        System.out.println(o);
        String s = stringRedisTemplate.opsForValue().get(key);
        System.out.println(s);

    }

    @Test
    public void test2() {
        User u = new User();
        u.id = "id123";
        u.callbackUrl = "callback";
        u.isCallBack = 1;
        u.isPayCallback = 1;
        userRepository.save(u);
    }

    @Test
    public void test3() {
        User u = new User();
        u.setId("id123");
        u.setCallbackUrl("callbcak");
        u.setIsCallBack(1);
        u.setIsPayCallback(1);
        String jsonString = JSON.toJSONString(u);
        System.out.println("xxxxxxxxxxxxxx");
        System.out.println(jsonString);
        Set<String> todayTasks = redisTemplate.boundSetOps("key1").members();
        System.out.println(todayTasks);
        todayTasks.addAll(todayTasks);
        System.out.println(todayTasks);
    }

    @Test
    public void test4() {
        String CALLBACK_KEY = "account:deviceBind:deviceImei:%s";
        String deviceImei = "123";
//        String key = String.format(CALLBACK_KEY, "c5fea8d69555e0709e037a66fa61d6fd");
        String key = String.format(CALLBACK_KEY, deviceImei);
        System.out.println(key);
        Map<Object, Object> entries1 = redisTemplate.opsForHash().entries(key);
        System.out.println(entries1);
        Map<Object, Object> entries = redisTemplate.boundHashOps(key).entries();
        System.out.println(entries);
    }

    @Test
    public void test9() {
        User user = new User();
        System.out.println(user.getIsPayCallback());
        if (Objects.equals(user.isCallBack, 1)) {
            System.out.println("11111");
        }
        if (!Objects.equals(user.getIsCallBack(), 1)) {
            System.out.println("22222");
        }
    }

    private String getChannelCallbackSetTodayKey() {
        String todayStr = LocalDate.now().format(formatter);
        return String.format(CALLBACK_KEY, todayStr);
    }

    @Test
    public void test5() {
        String CALLBACK_KEY = "account:deviceBind:deviceImei:%s";
        String deviceImei = "123";
        String key = String.format(CALLBACK_KEY, deviceImei);
        String channelCallbackSetTodayKey = getChannelCallbackSetTodayKey();
        redisTemplate.executePipelined(new SessionCallback<String>() {
            @Override
            @SuppressWarnings("unchecked")
            public String execute(RedisOperations op) throws DataAccessException {
                op.boundSetOps(channelCallbackSetTodayKey).add(deviceImei);
                op.boundHashOps(key).putAll(Map.of("deviceImei", deviceImei, "isRetention", 1,
                        "appChannel", "toutiao", "userId", "123123999"));
                op.expire(channelCallbackSetTodayKey, 1, TimeUnit.DAYS);
                op.expire(key, 1, TimeUnit.DAYS);
                return null;
            }
        });
    }
}
