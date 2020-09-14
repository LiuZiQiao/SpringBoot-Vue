package com.lxk.execltest.upload;
/**
 * @Description TODO
 * @Author liuxk@e6yun.com
 * @Created Date: 2020/9/5 14:27
 * @ClassName TRest
 * @Remark
 */

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RequestMapping("uploadFile")
public class UplaodController{

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("uploadFile") MultipartFile uploadFile, @RequestParam("aiIdCard")String aiIdCard, HttpServletRequest request){
        //定义上传文件存放的路径
        String path=request.getSession().getServletContext().getRealPath("/uploadFile/");
        System.out.println(path);
        //定义文件在上传路径中的文件夹名称
        File folder=new File(path+aiIdCard);
        //检测folder是否是文件夹，不是就创建
        if (!folder.isDirectory()) {
        folder.mkdirs();
        }
        //获取文件的原始名称
        String oldName = uploadFile.getOriginalFilename();
        //oldName.substring(oldName.lastIndexOf("."))   获取文件的后缀名
        //生成新的文件名（下面根据自己需要决定是否使用）
        //String newName ="定义新名字" + oldName.substring(oldName.lastIndexOf("."));
        //文件保存操作
        uploadFile.transferTo(new File(folder, oldName));
        //返回保存的url，根据url可以进行文件查看或者下载
        String filePath = request.getScheme() + "://" + request.getServerName() + ":" +request.getServerPort() + "/uploadFile/" + aiIdCard +"/"+ oldName;
    }
}