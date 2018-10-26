package com.shop.test;

import com.shop.po.Category;
import com.shop.service.CategoryService;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    private CategoryService categoryService;
    @Before
    public void before(){
        ApplicationContext context =new  ClassPathXmlApplicationContext("spring.xml");
        categoryService=(CategoryService)context.getBean("categoryService");
    }
    @org.junit.Test
    public void test(){
        Category category=new Category();
        category.setHot(new Byte("1"));
        category.setType("电子产品");
        System.out.print("test");
        //categoryService.save(category);
    }
}
