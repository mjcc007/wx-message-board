package com.mjcc.message_board.service.impl;

import com.mjcc.message_board.Enums.IStatusMessage;
import com.mjcc.message_board.config.FileMessageConfig;
import com.mjcc.message_board.service.FileUpDownService;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Description:
 * @Author: chengcheng
 * @Date: Create in 13:54 2019/8/8
 * @Modified By:
 */
@Service
@Slf4j
public class FileUpDownSericeImpl implements FileUpDownService {

    @Autowired
    private FileMessageConfig config;

    @Override
    public Map<String, Object> uploadPicture(MultipartFile file) throws SerialException {
        try {
            Map<String, Object> resMap = new HashMap<>();
            String[] IMAGE_TYPE = config.getImageType().split(",");
            String path = null;
            String fileSeperator = File.separator;
            boolean flag = false;
            for (String type : IMAGE_TYPE) {
                if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(), type)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                resMap.put("result", IStatusMessage.SystemStatus.SUCCESS.getMessage());
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");

                // 获取文件类型
                String fileType = file.getContentType();
                // 获取文件后缀名称
                String imageName = fileType.substring(fileType.indexOf("/") + 1);
                // 原名称
                String oldFileName = file.getOriginalFilename();
                // 新名称
                String newFileName = uuid + "." + imageName;
                // 年月日文件夹
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                String basedir = simpleDateFormat.format(new Date());
                // 文件压缩  大于4MB
                if(file.getSize() > config.getFileSize()) {
                    // 重新生成
                    String newUUID = UUID.randomUUID().toString().replaceAll("-", "");
                    newFileName =  newUUID + "." + imageName;
                    path = config.getUpPath() + fileSeperator + basedir + fileSeperator + newUUID + "." + imageName;
                    // 目录不存在 创建目录
                    File oldFile = new File(path);
                    if (!oldFile.exists()) {
                        oldFile.mkdirs();
                    }
                    file.transferTo(oldFile);
                    // 压缩图片
                    Thumbnails.of(oldFile).scale(config.getScaleRatio()).toFile(path);
                    // 显示路径
                    resMap.put("path", fileSeperator + basedir + fileSeperator + newUUID + "." + imageName);
                    resMap.put("imgurl", config.getImgServerBase() + basedir + "/" +  newUUID + "."  + imageName);
                } else {
                    path = config.getUpPath() + fileSeperator + basedir + fileSeperator + uuid + "." + imageName;
                    // 如果目录不存在则创建目录
                    File uploadFile = new File(path);
                    if (!uploadFile.exists()) {
                        uploadFile.mkdirs();
                    }
                    file.transferTo(uploadFile);
                    // 显示路径
                    resMap.put("path", fileSeperator + basedir + fileSeperator + uuid + "." + imageName);
                    resMap.put("imgurl", config.getImgServerBase() + basedir + "/" +  uuid + "."  + imageName);
                }
                resMap.put("oldFileName", oldFileName);
                resMap.put("newFileName", newFileName);
                resMap.put("fileSize", file.getSize());
            } else {
                resMap.put("result", "图片格式不正确,支持png|jpg|jpeg");
            }
            return resMap;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SerialException(e.getMessage());
        }
    }

    @Override
    public int delPicture(String imgPath) {
        if (imgPath.isEmpty()) return -1;
        String path = config.getUpPath() + imgPath;
        try {
            File file = new File(path);
            if (file.delete()) {
                log.info(file.getName() + "is deleted");
                return 0;
            } else {
                log.info("delete failed!");
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("delete the image occuer some thing!");
            return -1;
        }
    }
}
