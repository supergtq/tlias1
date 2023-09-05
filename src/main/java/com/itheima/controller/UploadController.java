package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
//本地存储
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
//        log.info("文件上传：{},{},{}",username ,age ,image);
//        //获取原始文件名
//       String originalFilename=image.getOriginalFilename();
//       //构造唯一的文件名 uuid（通用唯一识别码）
//
//        //将文件存储在指定的磁盘目录中
//        image.transferTo(new File("D:\\"+originalFilename));
//
//        return  Result.success();
@PostMapping("/upload")
public Result upload(MultipartFile image) throws IOException {
              log.info("文件上传，文件名:{}",image.getOriginalFilename());
              String url =aliOSSUtils.upload(image);
              log.info("文件上传完成，文件访问的url为:{}",url);

              return  Result.success(url);
            }
}
