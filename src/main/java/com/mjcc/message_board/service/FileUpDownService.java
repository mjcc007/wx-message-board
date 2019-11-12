package com.mjcc.message_board.service;

import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialException;
import java.util.Map;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 13:13 2019/8/8
 * @Modified By:
 */
public interface FileUpDownService {
    Map<String, Object> uploadPicture(MultipartFile file) throws SerialException;
    int delPicture(String imgPath);
}
