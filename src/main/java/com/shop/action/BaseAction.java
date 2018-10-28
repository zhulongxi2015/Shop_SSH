package com.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.po.FileImage;
import com.shop.service.AccountService;
import com.shop.service.CategoryService;
import com.shop.service.ProductService;
import com.shop.utils.FileUpload;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
//@Namespace("/")
//@ParentPackage("base")
@Controller("baseAction")
@Lazy(true)
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T> {
    @Resource
    protected CategoryService categoryService;
    @Resource
    protected AccountService accountService;
    @Resource
    protected ProductService productService;
   /* public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }*/
    protected  Map<String,Object> request;
    protected Map<String,Object> session;
    protected  Map<String,Object> application;
    protected  T model;

    protected Integer page;
    protected  Integer rows;
    protected Map<String,Object> pageMap=null;

    protected  String ids;
    protected InputStream inputStream;


    //封装了图片信息的类
    protected FileImage fileImage;


    //上传文件工具类
    @Resource
    protected FileUpload fileUpload;
    //用来装有将要被打包成json格式返回给前台的数据，下面要实现get方法
    protected List<T> jsonList = null;

    public void setApplication(Map<String, Object> application) {
        this.application=application;
    }

    public void setRequest(Map<String, Object> request) {
        this.request=request;
    }

    public void setSession(Map<String, Object> session) {
        this.session=session;
    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
    public Map<String, Object> getPageMap() {
        return pageMap;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public List<T> getJsonList() {
        return jsonList;
    }

    public FileImage getFileImage() {
        return fileImage;
    }

    public void setFileImage(FileImage fileImage) {
        this.fileImage = fileImage;
    }

    public T getModel() {
        ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
        Class clazz=(Class)type.getActualTypeArguments()[0];
        try{
            model=(T)clazz.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return model;
    }
}
