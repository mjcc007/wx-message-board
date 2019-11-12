package com.mjcc.message_board.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 13:28 2019/8/23
 * @Modified By:
 */
@Data
public class NewReply {
    /** 回复目标id */
    private Integer       lr_dest_id;
    /** 回复内容 */
    private String        lrContent;
    /** 在那个根评论下 */
    private Integer       lr_comment_id;
    /** 回复目标的类型 是对评论还是对回复的回复*/
    private Short         lr_type;
}
