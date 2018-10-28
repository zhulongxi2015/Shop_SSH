package com.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.po.Category;
import com.shop.service.CategoryService;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.annotations.Parent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;


@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> {

    public String queryJoinAccount(){
        pageMap=new HashMap<String, Object>();
        List<Category> categoryList=categoryService.queryJoinAccount(model.getType(),page,rows);
        pageMap.put("rows",categoryList);
        Long total=categoryService.getCount(model.getType());
        pageMap.put("total",total);
        return "jsonMap";
    }
    public String query(){
        jsonList=categoryService.query();
        return "jsonList";
    }
    public String deleteByIds(){
        categoryService.deleteByIds(ids);
        inputStream=new ByteArrayInputStream("true".getBytes());
        return "stream";
    }
    public void save(){
        categoryService.save(model);
    }
    public void update(){
        categoryService.update(model);

    }
}
