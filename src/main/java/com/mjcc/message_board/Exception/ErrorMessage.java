package com.mjcc.message_board.Exception;
/**
 * @Description: 全局的错误消息
 * @Author: chengcheng
 * @Date: Create in 9:44 2018/11/25
 * @Modified By:
 *  * 错误提示集合类
 *  * 错误码构成：   01程序员编号
 *  * 001该程序员定义的错误码
 *  * 后面再跟上错误信息
 */

public final class ErrorMessage {
    public static final String SYSTEM_EXCEPTION = "系统繁忙，请稍后再试";
    public static final String NOT_LOGIN = "01001_您还未登陆或者登陆已超时，请重新登陆";
    public static final String MOBILE_ALREADY_REGISTER = "01002_该手机号已经被注册了";
    public static final String LOGIC_EXCEPTION = "01003_对不起，你是真的没有我帅";
}