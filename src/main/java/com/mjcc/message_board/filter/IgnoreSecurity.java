package com.mjcc.message_board.filter;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 15:11 2019/8/11
 * @Modified By:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreSecurity {
}