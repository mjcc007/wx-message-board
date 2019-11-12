package com.mjcc.message_board.config;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 16:23 2019/8/4
 * @Modified By:
 */
@Component
public class WechatAppMpConfig {
    @Autowired
    private WechatAppConfig wechatAppConfig;

    @Bean
    public  WxMaService getMaService() {
        WxMaService wxMaService = new WxMaServiceImpl();
        wxMaService.setWxMaConfig(wxMaInMemoryConfig());
        return wxMaService;
    }
    @Bean
    public WxMaInMemoryConfig wxMaInMemoryConfig() {
        WxMaInMemoryConfig wxMaInMemoryConfig = new WxMaInMemoryConfig();
        wxMaInMemoryConfig.setAppid(wechatAppConfig.getAppid());
        wxMaInMemoryConfig.setSecret(wechatAppConfig.getSecret());
        return wxMaInMemoryConfig;
    }
}
