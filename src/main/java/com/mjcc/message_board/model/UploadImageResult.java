package com.mjcc.message_board.model;

import lombok.Data;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 22:49 2019/8/10
 * @Modified By:
 */
@Data
public class UploadImageResult {

    private String result;
    private String path;
    private String imgurl;
    private String fileSize;
    private String ewFileName;
    private String oldFileName;
}
