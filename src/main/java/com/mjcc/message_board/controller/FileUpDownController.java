package com.mjcc.message_board.controller;

import com.mjcc.message_board.Enums.IStatusMessage;
import com.mjcc.message_board.VO.ResultVO;
import com.mjcc.message_board.filter.CurrentUser;
import com.mjcc.message_board.filter.IgnoreSecurity;
import com.mjcc.message_board.model.UserInfo;
import com.mjcc.message_board.service.FileUpDownService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Description:  upload images controller
 * @Author: chengcheng
 * @Date: Create in 14:57 2019/8/8
 * @Modified By:
 */
@RestController
@RequestMapping("/upload")
@Slf4j
public class FileUpDownController {
    @Autowired
    private FileUpDownService fileUpDownService;

    @IgnoreSecurity
    @PostMapping(value = "/setFileUpload")
    @ResponseBody
    private ResultVO upload(@RequestParam("file") MultipartFile file, HttpServletRequest httpServletRequest) {
        try {
            if (!file.isEmpty()) {
                Map<String, Object> picMap = fileUpDownService.uploadPicture(file);
                if (IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(picMap.get("result"))) {
                    log.info("uplaod the named " + picMap.get("path") + " success!");
                    return ResultVO.buildSuccess(picMap);
                } else {
                    return ResultVO.buildError(IStatusMessage.SystemStatus.ERROR.getMessage());
                }
            } else {
                log.info(">>>>>>上传图片为空文件");
                return ResultVO.buildError("afsdf");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.buildError("未知错误");
        }
    }

    @GetMapping(value = "delFileUpload")
    private ResultVO delimg(@CurrentUser UserInfo redisUserInfo, @RequestParam("filePath") String filePath) {
        if (0 == fileUpDownService.delPicture(filePath)) return ResultVO.buildSuccess("delete success!");
        return ResultVO.buildError("delete failed!");
    }
}
