package com.mjcc.message_board.Exception;
import com.mjcc.message_board.Enums.ResultEnum;


/**
 * @Description: 微信操作的异常处理
 * @Author: chengcheng
 * @Date: Create in 23:22 2018/12/15
 * @Modified By:
 */
public class CommonException extends RuntimeException{
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public CommonException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    public CommonException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
