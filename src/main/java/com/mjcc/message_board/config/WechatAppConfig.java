package com.mjcc.message_board.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 15:37 2019/8/4
 * @Modified By:
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechatapp")
public class WechatAppConfig {
    /** 设置小程序的appid */
    private String appid;
    /** 设置小程序的secret */
    private String secret;
}
