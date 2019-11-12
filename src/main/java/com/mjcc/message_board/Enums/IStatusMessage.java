package com.mjcc.message_board.Enums;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 14:43 2019/8/8
 * @Modified By:
 */
public interface IStatusMessage {
    String getCode();
    String getMessage();

    enum SystemStatus implements IStatusMessage {

        SUCCESS("1000", "操作成功"), //请求成功
        ERROR("1001", "网络异常，请稍后重试~"),    //请求失败
        FILE_UPLOAD_NULL("1002", "上传文件为null");
        private String code;
        private String message;

        SystemStatus(String code, String message) {
            this.code = code;
            this.message = message;
        }
        public String getCode() {
            return this.code;
        }
        public String getMessage() {
            return this.message;
        }
    }
}
