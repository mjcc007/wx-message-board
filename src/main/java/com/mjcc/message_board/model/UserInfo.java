package com.mjcc.message_board.model;

import com.mjcc.message_board.jooq.tables.TUserInfo;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 21:11 2019/8/6
 * @Modified By:
 */
@Data
public class UserInfo {
    private String        openid;
    private String        nickname;
    private Short         sex;
    private String        mProvince;
    private String        mCity;
    private String        mCountry;
    private String        mLanguage;
    private String        headImgurl;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String skey;
}
