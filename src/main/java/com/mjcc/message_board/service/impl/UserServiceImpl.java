package com.mjcc.message_board.service.impl;

import com.mjcc.message_board.dao.UserMapper;
import com.mjcc.message_board.jooq.tables.pojos.TUserInfo;
import com.mjcc.message_board.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 10:26 2019/8/6
 * @Modified By:
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int newUser(TUserInfo userInfo) {
        return userMapper.doInsert(userInfo);
    }

    @Override
    public boolean isHasUser(String openid) {
        TUserInfo userInfo = userMapper.findByoOpenid(openid);
        if (userInfo == null) {
            return false;
        }
        return true;
    }
    @Override
    public int updateUser(TUserInfo userInfo) {
        return userMapper.doUpdate(userInfo);
    }

    @Override
    public TUserInfo getUserByOpenid(String openid) {
        return userMapper.findByoOpenid(openid);
    }
}
