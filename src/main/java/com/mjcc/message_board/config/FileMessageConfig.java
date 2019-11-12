package com.mjcc.message_board.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 13:05 2019/8/8
 * @Modified By:
 */
@Data
@Component
@ConfigurationProperties(prefix = "message")
//@PropertySource("classpath:file-message.yml")
public class FileMessageConfig {
    /** 压缩大小 */
    private long fileSize;
    /** 压缩比例 */
    private double scaleRatio;
    /** 图片服务器访问路径 */
    private String imgServerBase;
    /** 保存路径 */
    private String upPath;
    /** 图片类型 */
    private String imageType;
}
