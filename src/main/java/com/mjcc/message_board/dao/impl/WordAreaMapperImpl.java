package com.mjcc.message_board.dao.impl;

import com.mjcc.message_board.dao.WordAreaMapper;
import com.mjcc.message_board.jooq.tables.pojos.TWordAreaInfo;
import com.mjcc.message_board.jooq.tables.records.TWordAreaInfoRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 9:40 2019/8/8
 * @Modified By:
 */
@Repository
public class WordAreaMapperImpl implements WordAreaMapper {

    @Autowired
    DSLContext create;

    com.mjcc.message_board.jooq.tables.TWordAreaInfo table = com.mjcc.message_board.jooq.tables.TWordAreaInfo.T_WORD_AREA_INFO.as("table");

    @Override
    public int doInsert(TWordAreaInfo wordAreaInfo) {
        TWordAreaInfoRecord record = create.newRecord(table, wordAreaInfo);
        return record.insert();
    }

    @Override
    public Integer doDeleteById(Integer id) {
        return create.delete(table)
                .where(table.ARTICLE_ID.eq(id))
                .execute();
    }

    @Override
    public List<TWordAreaInfo> findByOpenid(String openid) {
        return create.select()
                .from(table)
                .where(table.OPENID.eq(openid))
                .orderBy(table.CREATE_TIME.desc())
                .fetchInto(TWordAreaInfo.class);
    }

    @Override
    public TWordAreaInfo findById(Integer id) {
        return create.select()
                .from(table)
                .where(table.ARTICLE_ID.eq(id))
                .fetchOneInto(TWordAreaInfo.class);
    }


}
