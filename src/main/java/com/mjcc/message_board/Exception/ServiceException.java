package com.mjcc.message_board.Exception;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 14:37 2019/8/8
 * @Modified By:
 */
public class ServiceException extends Exception {

    public ServiceException() {
        super();
    }
    public ServiceException(String message){
        super(message);
    }
    public ServiceException(Throwable throwable){
        super(throwable);
    }
    public ServiceException(String message ,Throwable throwable){
        super(message, throwable);
    }
}
