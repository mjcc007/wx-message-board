package com.mjcc.message_board.controller;

import com.mjcc.message_board.VO.ResultVO;
import com.mjcc.message_board.jooq.tables.pojos.TWords;
import com.mjcc.message_board.model.WordAreaInfo;
import com.mjcc.message_board.filter.CurrentUser;
import com.mjcc.message_board.jooq.tables.pojos.TWordAreaInfo;
import com.mjcc.message_board.model.UserInfo;
import com.mjcc.message_board.service.FileUpDownService;
import com.mjcc.message_board.service.WordAreaService;
import com.mjcc.message_board.service.WordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 13:46 2019/8/13
 * @Modified By:
 */
@RestController
@RequestMapping("/wordarea/")
@Slf4j
public class WordAreaController {

    @Autowired
    WordAreaService wordAreaService;
    @Autowired
    WordService wordService;

    @Autowired
    private FileUpDownService fileUpDownService;

    @PostMapping("/new")
    public ResultVO createNewWordArea(@CurrentUser UserInfo redisUserInfo, @RequestBody WordAreaInfo wordAreaInfo) {
        if (wordAreaInfo.getArticleTitle().isEmpty() ) return ResultVO.buildError("title can not null!");
        String openid = redisUserInfo.getOpenid();
        if (openid.isEmpty()) return ResultVO.buildError("can not find this user!");
        TWordAreaInfo twordAreaInfo = new TWordAreaInfo();
        BeanUtils.copyProperties(wordAreaInfo, twordAreaInfo);
        twordAreaInfo.setOpenid(openid);
        wordAreaService.newWordArea(twordAreaInfo);
        log.info("create a new word area! title = " + twordAreaInfo.getArticleTitle());
        return ResultVO.buildSuccess(0, "创建成功");
    }

    @PostMapping("/all")
    public ResultVO getAllWordArea(@CurrentUser UserInfo redisUserInfo) {
        String openid = redisUserInfo.getOpenid();
        if (openid.isEmpty()) return ResultVO.buildError("can not find this user!");
        return ResultVO.buildSuccess(wordAreaService.finByOpenid(openid));
    }

    @PostMapping("/del")
    public ResultVO delAWordArea(@CurrentUser UserInfo redisUserInfo, @RequestBody TWordAreaInfo tWordAreaInfo) {
        String openid = redisUserInfo.getOpenid();
        if (openid.isEmpty()) return ResultVO.buildError("can not find this user!");

        if (tWordAreaInfo.getArticleId() == null) return ResultVO.buildError("can not found the word area!", -1);
        // 删除留言区
        wordAreaService.deleteWordArea(tWordAreaInfo.getArticleId());
        log.info("delete the word area id = " +  tWordAreaInfo.getArticleId() + " title = " + tWordAreaInfo.getArticleTitle());

        //删除相关留言
        List<TWords> allWords = wordService.getAllWordByTopicId(tWordAreaInfo.getArticleId());
        for (TWords tWords : allWords) {
            wordService.delReplyByCommentId(tWords.getLwId());
        }
        wordService.getAllWordByTopicId(tWordAreaInfo.getArticleId());

        // todo 删除相关图片资源
        String imgUrl = tWordAreaInfo.getArticleImg();
        String[] test = imgUrl.split("//");
        String[] splitArr = test[1].split("/");
        String fileSeperator = File.separator;
        String imgPath = fileSeperator + splitArr[splitArr.length - 2] + fileSeperator + splitArr[splitArr.length - 1];
        fileUpDownService.delPicture(imgPath);

        return ResultVO.buildSuccess(tWordAreaInfo.getArticleId(), "删除成功");
    }

    @GetMapping("/getone")
    public ResultVO getOneWordAreaByTopicid(@CurrentUser UserInfo redisUserInfo, @RequestParam("topicid") Integer topicId) {
        if(topicId == null) return ResultVO.buildError("topic can not null!", -1);
        return ResultVO.buildSuccess(wordAreaService.findByid(topicId));
    }
}
