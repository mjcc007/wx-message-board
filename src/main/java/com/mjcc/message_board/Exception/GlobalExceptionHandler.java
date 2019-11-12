package com.mjcc.message_board.Exception;

import com.alibaba.fastjson.JSONObject;
import com.mjcc.message_board.VO.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 全局的异常统一处理
 * @Author: chengcheng
 * @Date: Create in 9:44 2018/11/25
 * @Modified By:
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object logicExceptionHandler(HttpServletRequest request, Exception e, HttpServletResponse response) {
        //系统级异常，错误码固定为-1，提示语固定为系统繁忙，请稍后再试
        ResultVO result = new ResultVO(-1, false, e.getMessage(), ErrorMessage.SYSTEM_EXCEPTION);
        //如果是业务逻辑异常，返回具体的错误码与提示信息
        if (e instanceof CommonException) {
            CommonException wxException = (CommonException) e;
            result.setCode(wxException.getCode());
            result.setMsg(wxException.getMessage());
        } else {
            //对系统级异常进行日志记录
            log.error("系统异常:" + e.getMessage(), e);
        }
        return JSONObject.toJSON(result);
    }
}
