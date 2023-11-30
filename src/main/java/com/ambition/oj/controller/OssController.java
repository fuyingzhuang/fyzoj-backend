package com.ambition.oj.controller;

import com.ambition.oj.common.BaseResponse;
import com.ambition.oj.common.ResultUtils;
import com.ambition.oj.service.OssService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Ambition
 * @date 2023/11/30 17:35
 */
@RestController
@RequestMapping("/file/oss")
public class OssController {

    @Resource
    private OssService ossService;


    /**
     * 上传头像的方法
     */
    @PostMapping("/upload")
    public BaseResponse<String> uploadFile(@RequestPart("file") MultipartFile multipartFile, HttpServletRequest request) {

//        获取上传文件 MultipartFile  返回上传文件的oss路径
        String url = ossService.uploadFileAvatar(multipartFile);
        System.out.println(url);
        return ResultUtils.success(url);
    }
}
