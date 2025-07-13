package com.example.hello.controller;

import com.example.hello.common.Result;
import com.example.hello.util.MinIOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private MinIOUtil minIOUtil;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<String> uploadFile(@RequestPart("file") MultipartFile file) {
        try {
            String fileUrl = minIOUtil.uploadFile(file);
            return Result.success(fileUrl);
        } catch (Exception e) {
            return Result.error("文件上传失败: " + e.getMessage());
        }
    }
}