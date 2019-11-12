package com.mjcc.message_board.service;

import com.mjcc.message_board.jooq.tables.pojos.TReply;
import com.mjcc.message_board.jooq.tables.pojos.TWords;

import java.util.List;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 13:49 2019/8/19
 * @Modified By:
 */
public interface WordService {
    /** add a new word */
    int newWord(TWords words);

    /** 根据topicId 删除所有评论 */
    int delWordByTopicID(Integer topicId);

    /** 添加一个新的回复 */
    int newReply(TReply reply);

    /** 删除所有回复根据目标word */
    int delReplyByCommentId(Integer commentId);

    /** 获取该主题下的所有评论 */
    List<TWords> getAllWordByTopicId(Integer topicId);

    /** 获取该评论下的所有回复 */
    List<TReply> getAllReplyByWordID(Integer wordId);

    /** 根据主题id查找该主题id下所有的评论的回复 */
    List<TReply> getAllReplyByTopicId(Integer topicId);

    /** 根据id获取评论 */
    TWords getWordByID(Integer id);

    /** 根据id获取回复 */
    TReply getReplyByID(Integer id);

    /** word赞 */
    int wordZan(Integer id);

    /** word 踩 */
    int wordCai(Integer id);

    /**  reply 赞 */
    int replyZan(Integer id);

    /** reply 踩 */
    int replyCai(Integer id);

}
