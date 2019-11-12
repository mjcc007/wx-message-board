package com.mjcc.message_board.dao;

import com.mjcc.message_board.jooq.tables.pojos.TWordAreaInfo;

import java.util.List;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 9:39 2019/8/8
 * @Modified By:
 */
public interface WordAreaMapper {
    int doInsert(TWordAreaInfo wordAreaInfo);
    Integer doDeleteById(Integer id);
    List<TWordAreaInfo> findByOpenid(String openid);
    TWordAreaInfo findById(Integer id);
}
