package com.mjcc.message_board.dao.impl;

import com.mjcc.message_board.dao.UserMapper;
import com.mjcc.message_board.jooq.tables.daos.TUserInfoDao;
import com.mjcc.message_board.jooq.tables.pojos.TUserInfo;
import com.mjcc.message_board.jooq.tables.records.TUserInfoRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 10:30 2019/8/6
 * @Modified By:
 */
@Repository
public class UserMapperImp extends TUserInfoDao implements UserMapper {

    @Autowired
    DSLContext create;

    com.mjcc.message_board.jooq.tables.TUserInfo table = com.mjcc.message_board.jooq.tables.TUserInfo.T_USER_INFO.as("table");
    @Override
    public int doInsert(TUserInfo userInfo) {
        TUserInfoRecord record = create.newRecord(table, userInfo);
        return record.insert();
    }

    @Override
    public TUserInfo findByoOpenid(String openid) {
        TUserInfo userInfo = create.select()
                .from(table)
                .where(table.OPENID.eq(openid))
                .fetchOneInto(TUserInfo.class);
        return userInfo;
    }

    @Override
    public int doUpdate(TUserInfo userInfo) {
        return create.update(table)
                .set(table.OPENID, userInfo.getOpenid())
                .set(table.HEAD_IMGURL, userInfo.getHeadImgurl())
                .set(table.M_CITY, userInfo.getMCity())
                .set(table.M_COUNTRY, userInfo.getMCountry())
                .set(table.M_LANGUAGE, userInfo.getMLanguage())
                .set(table.NICKNAME, userInfo.getNickname())
                .set(table.M_PROVINCE, userInfo.getMProvince())
                .set(table.SEX, userInfo.getSex())
                .set(table.UPDATE_TIME, userInfo.getUpdateTime())
                .where(table.OPENID.eq(userInfo.getOpenid()))
                .execute();
    }
}
