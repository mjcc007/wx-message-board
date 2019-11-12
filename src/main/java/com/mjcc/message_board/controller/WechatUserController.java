package com.mjcc.message_board.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.mjcc.message_board.VO.ResultVO;
import com.mjcc.message_board.config.WechatAppMpConfig;
import com.mjcc.message_board.filter.IgnoreSecurity;
import com.mjcc.message_board.jooq.tables.pojos.TUserInfo;
import com.mjcc.message_board.model.UserInfo;
import com.mjcc.message_board.service.RedisService;
import com.mjcc.message_board.service.UserService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 16:35 2019/8/4
 * @Modified By:
 */
@RestController
@RequestMapping("/wx/user/")
@Slf4j
public class WechatUserController {

    @Autowired
    WechatAppMpConfig wechatAppMpConfig;

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;
    /**
     *  登录接口
     * */
    @IgnoreSecurity
    @GetMapping("/login")
    public ResultVO login(@RequestParam("code") String code,
                          @RequestParam("rawData") String rawData,
                          @RequestParam("signature") String signature,
                          @RequestParam("encrypteData") String encryptData,
                          @RequestParam("iv") String iv) {
        if (StringUtils.isEmpty(code)) {
            return ResultVO.buildError("code is null");
        }
        final  WxMaService wxMaService = wechatAppMpConfig.getMaService();
        try {
            // 获取openid 和 session_key
            WxMaJscode2SessionResult sessionResult = wxMaService.getUserService().getSessionInfo(code);
            // 判断信息是否正确
            if (!wxMaService.getUserService().checkUserInfo(sessionResult.getSessionKey(), rawData, signature)) {
                return ResultVO.buildError("user check failed!");
            }
            // 解密用户信息
            WxMaUserInfo userInfo = wxMaService.getUserService().getUserInfo(sessionResult.getSessionKey(), encryptData, iv);
            // 组装用户信息
            TUserInfo tuserInfo  = new TUserInfo();
            BeanUtils.copyProperties(tuserInfo, userInfo);
            tuserInfo.setOpenid(userInfo.getOpenId());
            tuserInfo.setNickname(userInfo.getNickName());
            tuserInfo.setMCity(userInfo.getCity());
            tuserInfo.setMCountry(userInfo.getCountry());
            tuserInfo.setHeadImgurl(userInfo.getAvatarUrl());
            tuserInfo.setMLanguage(userInfo.getLanguage());
            tuserInfo.setMProvince(userInfo.getProvince());
            tuserInfo.setUpdateTime(LocalDateTime.now());
            System.out.println(tuserInfo);
            UserInfo viewUserInfo = new UserInfo();
            BeanUtils.copyProperties(tuserInfo, viewUserInfo);

            // 用户已经存在
            if (userService.isHasUser(userInfo.getOpenId())) {
                tuserInfo.setUpdateTime(LocalDateTime.now());
                userService.updateUser(tuserInfo);
                viewUserInfo.setSkey(String.valueOf(redisService.get(userInfo.getOpenId())));
                return ResultVO.buildSuccess(viewUserInfo);
            }
            // 用户不存在
            // uuid生成唯一key，用于维护微信小程序用户与服务端的会话
            String skey = UUID.randomUUID().toString();
            viewUserInfo.setSkey(skey);
            userService.newUser(tuserInfo);
            redisService.set(skey, userInfo.getOpenId());
            redisService.set(userInfo.getOpenId(), skey);
            return ResultVO.buildSuccess(viewUserInfo);
        } catch (WxErrorException e) {
            log.error(e.getMessage(), e);
            return ResultVO.buildError(e.getMessage());
        }
    }
}
