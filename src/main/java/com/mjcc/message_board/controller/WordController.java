package com.mjcc.message_board.controller;

import com.mjcc.message_board.Enums.ReplyTypeEnum;
import com.mjcc.message_board.model.NewReply;
import com.mjcc.message_board.model.NewWord;
import com.mjcc.message_board.VO.ResultVO;
import com.mjcc.message_board.VO.WordListVO;
import com.mjcc.message_board.filter.CurrentUser;
import com.mjcc.message_board.jooq.tables.pojos.TReply;
import com.mjcc.message_board.jooq.tables.pojos.TUserInfo;
import com.mjcc.message_board.jooq.tables.pojos.TWords;
import com.mjcc.message_board.model.UserInfo;
import com.mjcc.message_board.service.UserService;
import com.mjcc.message_board.service.WordAreaService;
import com.mjcc.message_board.service.WordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 20:38 2019/8/19
 * @Modified By:
 */
@RestController
@RequestMapping("/word/")
@Slf4j
public class WordController {

    @Autowired
    WordService wordService;

    @Autowired
    WordAreaService wordAreaService;

    @Autowired
    UserService userService;

    @PostMapping("/newword")
    public ResultVO CreateNewWord(@CurrentUser UserInfo redisUserInfo, @RequestBody @Valid NewWord newWord, BindingResult result) {
        if(result.hasErrors()) {
            return ResultVO.buildError(result.getFieldError().getDefaultMessage());
        }
        TUserInfo userInfo = userService.getUserByOpenid(redisUserInfo.getOpenid());
        TWords words = new TWords();
        words.setLwContent(newWord.getLwContent());
        words.setLwOpenid(userInfo.getOpenid());
        words.setLwHeadImgurl(userInfo.getHeadImgurl());
        words.setLwName(userInfo.getNickname());
        words.setLwForTopicId(newWord.getLwForTopicId());
        words.setLwZan(0);
        words.setLwCai(0);
        wordService.newWord(words);
        return ResultVO.buildSuccess(0, "创建成功");
    }

    @PostMapping("/newReply")
    public ResultVO CreateNewReply(@CurrentUser UserInfo redisUserInfo, @RequestBody NewReply newreply) {
        TUserInfo userInfo = userService.getUserByOpenid(redisUserInfo.getOpenid());

        System.out.println(newreply);
        String destOpenid = new String();
        if ((int)newreply.getLr_type() == ReplyTypeEnum.COMMENT_TYPE.getCode()) {
            TWords words = wordService.getWordByID(newreply.getLr_dest_id());
            destOpenid = words.getLwOpenid();
        }
        if ((int)newreply.getLr_type() == ReplyTypeEnum.REPLY_TYPE.getCode()) {
            TReply ttreply = wordService.getReplyByID(newreply.getLr_dest_id());
            destOpenid = ttreply.getLrOpenid();
        }

        TReply reply = new TReply();
        reply.setLrCai(0);
        reply.setLrZan(0);
        reply.setLrCommentId(newreply.getLr_comment_id());
        reply.setLrContent(newreply.getLrContent());
        reply.setLrType(newreply.getLr_type());
        reply.setLrDestId(newreply.getLr_dest_id());
        reply.setLrDestOpenid(destOpenid);
        reply.setLrHeadImgurl(userInfo.getHeadImgurl());
        reply.setLrName(userInfo.getNickname());
        reply.setLrOpenid(userInfo.getOpenid());
        wordService.newReply(reply);

        return ResultVO.buildSuccess(0, "reply success");
    }


    @GetMapping("/wordList")
    //@CurrentUser UserInfo redisUserInfo
    public ResultVO getWordList(@CurrentUser UserInfo redisUserInfo, @RequestParam("topicid") Integer topicId) {

        /** chechk the topic id */
        if (wordAreaService.findByid(topicId) == null) return ResultVO.buildError("can not find the topic!", -1);

        /** get add word */
        List<TWords> words = wordService.getAllWordByTopicId(topicId);
        System.out.println(words);

        /** get all reply */
        List<TReply> replys = wordService.getAllReplyByTopicId(topicId);
        System.out.println(replys);

        /** package the data */
        List<WordListVO> wordListVOS = new ArrayList<>();
        for (TWords tWords : words) {
            WordListVO wordListVO = new WordListVO();
            wordListVO.setWord(tWords);
            List<TReply> subReplys = new ArrayList<>();
            for (TReply reply : replys) {
                if (reply.getLrCommentId().equals(tWords.getLwId())) {
                    subReplys.add(reply);
                }
            }
            wordListVO.setSubWords(subReplys);
            wordListVOS.add(wordListVO);
        }
        return ResultVO.buildSuccess(wordListVOS, "查询成功");
    }

    @GetMapping("/zan")
    public ResultVO doZan(@CurrentUser UserInfo redisUserInfo, @RequestParam("id") Integer id, @RequestParam("type") Short type) {
        if ((int)type == ReplyTypeEnum.COMMENT_TYPE.getCode()) {
            wordService.wordZan(id);
        }
        if ((int)type == ReplyTypeEnum.REPLY_TYPE.getCode()) {
            wordService.replyZan(id);
        }
        return ResultVO.buildSuccess(0, "success");
    }

    @GetMapping("/cai")
    public ResultVO doCai(@CurrentUser UserInfo redisUserInfo, @RequestParam("id") Integer id, @RequestParam("type") Short type) {
        if ((int)type == ReplyTypeEnum.COMMENT_TYPE.getCode()) {
            wordService.wordCai(id);
        }
        if ((int)type == ReplyTypeEnum.REPLY_TYPE.getCode()) {
            wordService.replyCai(id);
        }
        return ResultVO.buildSuccess(0, "success");
    }
}
