package com.shop.utils;

import com.shop.po.FileImage;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.UUID;


//文件上传工具类具体实现
@Component("fileUpload")
public class FileUploadUtil implements FileUpload {
    private String filePath;
    private String fileRealPath;

    //@Value表示去beans.xml文件中找id="prop"的bean，它是通过注解的方式读取properties配置文件的，然后去相应的配置文件中读取key=filePath的值
    @Value("#{prop['filePath']}")
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Value("#{prop['fileRealPath']}")
    public void setFileRealPath(String fileRealPath) {
        this.fileRealPath = fileRealPath;
    }

    //1. 通过文件名获取扩展名
    public String getFileExt(String fileName){
        return FilenameUtils.getExtension(fileName);
    }
    //2. 生成UUID随机数，作为新的文件名
    public String newFileName(String fileName){
        String ext=getFileExt(fileName);
        return UUID.randomUUID().toString()+"."+ext;
    }
    //实现文件上传的功能，返回上传后新的文件名称
    public String uploadFile(FileImage fileImage) {
        System.out.println(fileImage);
        String newFileName=newFileName(fileImage.getFilename());
        try{
            File newFile=new File(fileRealPath,newFileName);
            FileUtils.copyFile(fileImage.getFile(),newFile);
            return  filePath+"\\"+newFileName;
        }catch(Exception e){
                throw new RuntimeException(e);
        }
        finally {
            fileImage.getFile().delete();
        }
    }
}
