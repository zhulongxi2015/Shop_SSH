package com.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.po.Category;
import com.shop.service.CategoryService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.annotations.Parent;
import org.springframework.stereotype.Controller;


@Controller("categoryAction")
public class CategoryAction extends BaseAction<Category> {
    @Action(value = "index",results = {@Result(name="index",location = "/index.jsp")})
    public String index(){
        Category category=new Category();
        category.setHot(new Byte("1"));
        category.setType("洗衣机");
        categoryService.save(category);
        return "index";
    }
}
