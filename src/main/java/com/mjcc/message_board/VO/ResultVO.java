package com.mjcc.message_board.VO;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Description: 这是一个包装类  来包装返回数据格式
 * @Author: chengcheng
 * @Date: Create in 12:50 2018/8/1
 * @Modified By:
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer code; // 状态码 0 表示成功，1表示处理中，-1表示失败
    private Object data; // 数据
    private String msg;// 描述
    private boolean success; // 请求是否成功
    /**
     * 服务器当前时间（添加该字段的原因是便于查找定位请求时间，因为实际开发过程中服务器时间可能跟本地时间不一致，加上这个时间戳便于日后定位）
     */
    private Timestamp currentTime;

    public ResultVO() {
    }

    public ResultVO(Integer code, boolean success, Object data, String msg) {
        this.code = code;
        this.success = success;
        this.data = data;
        this.msg = msg;
        this.currentTime = new Timestamp(new DateTime().getMillis());
    }

    // 成功，传入数据
    public static ResultVO buildSuccess() {
        return new ResultVO(0, true, null, "success");
    }

    // 成功，传入数据
    public static ResultVO buildSuccess(Object data) {
        return new ResultVO(0, true, data, "success");
    }

    // 失败，传入描述信息
    public static ResultVO buildError(String msg) {
        return new ResultVO(-1, false, null, msg);
    }

    // 失败，传入描述信息,状态码
    public static ResultVO buildError(String msg, Integer code) {
        return new ResultVO(code, false,null, msg);
    }

    // 成功，传入数据,及描述信息
    public static ResultVO buildSuccess(Object data, String msg) {
        return new ResultVO(0, true, data, msg);
    }

    public static ResultVO buildSuccess(Integer code, String msg) {
        return new ResultVO(code, true, null, msg);
    }
    // 成功，传入数据,及状态码
    public static ResultVO buildSuccess(Object data, int code) {
        return new ResultVO(code, true, data, "");
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public Timestamp getCurrentTime() {
        return currentTime;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return "ResultVO [code=" + code
                + ", success" + success
                + ", data=" + data
                + ", msg=" + msg
                + ", timestamp=" + currentTime
                + "]";
    }
}