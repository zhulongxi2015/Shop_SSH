package com.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.service.CategoryService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.Map;
@Namespace("/")
@ParentPackage("struts-default")
@Controller("baseAction")
@Lazy(true)
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T> {
    @Resource
    protected CategoryService categoryService;
   /* public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }*/
    protected  Map<String,Object> request;
    protected Map<String,Object> session;
    protected  Map<String,Object> application;
    protected  T model;

    public void setApplication(Map<String, Object> application) {
        this.application=application;
    }

    public void setRequest(Map<String, Object> request) {
        this.request=request;
    }

    public void setSession(Map<String, Object> session) {
        this.session=session;
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
