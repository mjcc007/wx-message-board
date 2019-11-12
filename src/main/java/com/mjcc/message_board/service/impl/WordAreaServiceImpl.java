package com.mjcc.message_board.service.impl;

import com.mjcc.message_board.dao.WordAreaMapper;
import com.mjcc.message_board.jooq.tables.pojos.TWordAreaInfo;
import com.mjcc.message_board.service.WordAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 9:25 2019/8/8
 * @Modified By:
 */
@Service
public class WordAreaServiceImpl implements WordAreaService {

    @Autowired
    WordAreaMapper wordAreaMapper;

    /** 创建一个留言区 */
    @Override
    public int newWordArea(TWordAreaInfo wordArea) {
        return wordAreaMapper.doInsert(wordArea);
    }

    /** 删除一个留言区 */
    @Override
    public int deleteWordArea(int id) {
        return wordAreaMapper.doDeleteById(id);
    }

    /** 根据用户获取当前用户所有的留言区 */
    @Override
    public List<TWordAreaInfo> finByOpenid(String openid) {
        return wordAreaMapper.findByOpenid(openid);
    }

    /** 根据主题id查找留言区 */
    @Override
    public TWordAreaInfo findByid(Integer topicid) {
        return wordAreaMapper.findById(topicid);
    }
}
