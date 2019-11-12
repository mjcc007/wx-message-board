package com.mjcc.message_board.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 21:00 2019/8/19
 * @Modified By:
 */
@Data
public class NewWord {

    @NotNull(message = "主题id不能为空")
    private Integer       lwForTopicId;
    @NotNull(message = "留言不能为null")
    private String        lwContent;
}
