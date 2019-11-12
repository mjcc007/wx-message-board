package com.mjcc.message_board.service;

import com.mjcc.message_board.jooq.tables.pojos.TWordAreaInfo;

import java.util.List;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 9:25 2019/8/8
 * @Modified By:
 */
public interface WordAreaService {
    int newWordArea(TWordAreaInfo wordArea);
    int deleteWordArea(int id);
    List<TWordAreaInfo> finByOpenid(String openid);
    TWordAreaInfo findByid(Integer topicid);
}
