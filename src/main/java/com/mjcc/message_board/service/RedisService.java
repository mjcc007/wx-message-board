package com.mjcc.message_board.service;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 16:10 2019/8/6
 * @Modified By:
 */
public interface RedisService {
    /** 存储数据 */
    boolean set(String key, String value);
    /** 存储数据并设置过期时间 */
    boolean set(String key, String value, long time);

    /** 获取数据 */
    Object get(String key);

    /** 设置有效天数 */
    boolean expire(String key, long time);

    /** 根据key获取过期时间 */
    long getExpire(String key);

    /** 移除数据 */
    boolean remove(String... key);
}
