package com.mjcc.message_board.Enums;

import lombok.Getter;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 14:02 2019/8/23
 * @Modified By:
 */
@Getter
public enum ReplyTypeEnum {
    REPLY_TYPE(1, "回复的是回复"),
    COMMENT_TYPE(0, "回复的是评论"),
    ;
    private Integer code;
    private String message;

    ReplyTypeEnum (Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
