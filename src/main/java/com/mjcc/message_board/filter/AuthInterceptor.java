package com.mjcc.message_board.filter;

import com.alibaba.druid.util.StringUtils;
import com.mjcc.message_board.Enums.ResultEnum;
import com.mjcc.message_board.Exception.CommonException;
import com.mjcc.message_board.model.UserInfo;
import com.mjcc.message_board.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 15:13 2019/8/11
 * @Modified By:
 */
@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    RedisService redisService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String requestPath = request.getRequestURI();
//        log.debug("requestIp: " + getIpAddress(request));
        log.info("Method: " + method.getName() + ", IgnoreSecurity: " + method.isAnnotationPresent(IgnoreSecurity.class));
        log.info("requestPath: " + requestPath);
        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
            return true;
        }
        String token = request.getHeader("token");
        log.info("token: " + token);
        if (StringUtils.isEmpty(token)) {
            throw new CommonException(ResultEnum.ACCESS_TOKEN_ERROR);
        }

        // set the openid to request
        String openid = String.valueOf(redisService.get(token));
        UserInfo userInfo = new UserInfo();
        userInfo.setOpenid(openid);
        log.info(openid);
        log.info(userInfo.getOpenid());
        log.info("set user info ........");
        request.setAttribute("currentUser", userInfo);

        return true;
    }
}
