package com.mjcc.message_board.VO;

import com.mjcc.message_board.jooq.tables.pojos.TReply;
import com.mjcc.message_board.jooq.tables.pojos.TWords;
import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 14:39 2019/8/22
 * @Modified By:
 */
@Data
public class WordListVO {
    /** 评论 */
    private TWords word;

    /** 子评论 */
    private List<TReply> subWords;
}
