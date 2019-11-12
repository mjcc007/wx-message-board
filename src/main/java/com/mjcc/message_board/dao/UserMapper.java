package com.mjcc.message_board.dao;

import com.mjcc.message_board.jooq.tables.pojos.TUserInfo;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 10:28 2019/8/6
 * @Modified By:
 */
public interface UserMapper {
    TUserInfo fetchOneByOpenid(String value);
    TUserInfo findByoOpenid(String openid);
    int doInsert(TUserInfo userInfo);
    int doUpdate(TUserInfo userInfo);
}
