package com.mjcc.message_board.service;

import com.mjcc.message_board.jooq.tables.pojos.TUserInfo;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 10:26 2019/8/6
 * @Modified By:
 */
public interface UserService {
    int newUser(TUserInfo userInfo);
    boolean isHasUser(String openid);
    int updateUser(TUserInfo userInfo);
    TUserInfo getUserByOpenid(String openid);
}
