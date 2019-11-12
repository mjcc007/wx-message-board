package com.mjcc.message_board.service.impl;

import com.mjcc.message_board.jooq.tables.pojos.TReply;
import com.mjcc.message_board.jooq.tables.pojos.TWords;
import com.mjcc.message_board.jooq.tables.records.TWordsRecord;
import com.mjcc.message_board.service.WordService;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.TableRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 13:50 2019/8/19
 * @Modified By:
 */
@Service
@Slf4j
public class WordServiceImpl implements WordService {

    @Autowired
    DSLContext create;

    com.mjcc.message_board.jooq.tables.TWords table = com.mjcc.message_board.jooq.tables.TWords.T_WORDS.as("table");
    com.mjcc.message_board.jooq.tables.TReply replyTable = com.mjcc.message_board.jooq.tables.TReply.T_REPLY.as("replyTable");
    /** add a new word */
    @Override
    public int newWord(TWords words) {
        TWordsRecord record = create.newRecord(table, words);
        return record.insert();
    }

    /** 根据topicId 删除所有评论 */
    @Override
    public int delWordByTopicID(Integer topicId) {
        return create.delete(table)
                .where(table.LW_FOR_TOPIC_ID.eq(topicId))
                .execute();
    }

    /** 获取该主题下的所有评论 */
    @Override
    public List<TWords> getAllWordByTopicId(Integer topicId) {
        return create.select()
                .from(table)
                .where(table.LW_FOR_TOPIC_ID.eq(topicId))
                .orderBy(table.LW_ZAN.desc())
                .fetchInto(TWords.class);
    }

    /** 获取该评论下的所有回复 */
    @Override
    public List<TReply> getAllReplyByWordID(Integer wordId) {
        return create.select()
                .from(replyTable)
                .where(replyTable.LR_COMMENT_ID.eq(wordId))
                .orderBy(replyTable.LR_DATE)
                .fetchInto(TReply.class);
    }

    /** 根据主题id查找该主题id下所有的评论的回复 */
    @Override
    public List<TReply> getAllReplyByTopicId(Integer topicId) {
        return create.select()
                .from(replyTable)
                .where(replyTable.LR_COMMENT_ID.in(create.select(table.LW_ID)
                        .from(table)
                        .where(table.LW_FOR_TOPIC_ID.eq(topicId))
                        .orderBy(table.LW_ZAN.desc())
                )).fetchInto(TReply.class);
    }

    /** 根据id获取评论 */
    @Override
    public TWords getWordByID(Integer id) {
        return create.select()
                .from(table)
                .where(table.LW_ID.eq(id))
                .fetchOneInto(TWords.class);
    }

    /** 根据id获取回复 */
    @Override
    public TReply getReplyByID(Integer id) {
        return create.select()
                .from(replyTable)
                .where(replyTable.LR_ID.eq(id))
                .fetchOneInto(TReply.class);
    }

    /** 添加一个新的回复 */
    @Override
    public int newReply(TReply reply) {
        TableRecord record = create.newRecord(replyTable, reply);
        return record.insert();
    }


    /** 删除所有回复根据目标word */
    public int delReplyByCommentId(Integer commentId) {
        return create.delete(replyTable)
                .where(replyTable.LR_COMMENT_ID.eq(commentId))
                .execute();
    }
    /** word赞 */
    @Override
    public int wordZan(Integer id) {
        return create.update(table)
                .set(table.LW_ZAN, table.LW_ZAN.add(1))
                .where(table.LW_ID.eq(id))
                .execute();
    }
    /** word 踩 */
    @Override
    public int wordCai(Integer id) {
        return create.update(table)
                .set(table.LW_CAI, table.LW_CAI.add(1))
                .where(table.LW_ID.eq(id))
                .execute();
    }

    /**  reply 赞 */
    @Override
    public int replyZan(Integer id) {
        return create.update(replyTable)
                .set(replyTable.LR_ZAN, replyTable.LR_ZAN.add(1))
                .where(replyTable.LR_ID.eq(id))
                .execute();
    }
    /** reply 踩 */
        @Override
        public int replyCai(Integer id) {
        return create.update(replyTable)
                .set(replyTable.LR_CAI, replyTable.LR_CAI.add(1))
                .where(replyTable.LR_ID.eq(id))
                .execute();
    }
}
