package com.mjcc.message_board.Enums;

import lombok.Getter;

/**
 * @Description: 结果枚举
 * @Author: chengcheng
 * @Date: Create in 10:34 2018/11/25
 * @Modified By:
 */
@Getter
public enum ResultEnum {
    WECHAT_MP_ERROR(21, "微信公众访问错误"),
    SHARE_NOT_EXIST(22, "分享不存在"),
    ACCESS_TOKEN_ERROR(23, "token 错误")
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
