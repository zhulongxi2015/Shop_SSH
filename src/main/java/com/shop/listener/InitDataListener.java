package com.shop.listener;

import com.shop.po.Category;
import com.shop.po.Product;
import com.shop.service.CategoryService;
import com.shop.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

//@Component //监听器是web层的组件，它是tomcat实例化的，不是Spring实例化的。不能放到Spring中
public class InitDataListener implements ServletContextListener {
    private CategoryService categoryService;
    private ProductService productService;
    private ApplicationContext applicationContext;
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        applicationContext= WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        categoryService=(CategoryService) applicationContext.getBean("categoryService");
        productService=(ProductService)applicationContext.getBean("productService");
        List <List<Product>> bigList=new ArrayList<List<Product>>();//bigList中存放一个装有Category类的list
        for( Category category: categoryService.queryByHot(true)){
            System.out.println(1);
            List<Product> list=productService.querByCategoryId(category.getId());
            bigList.add(list);//将装有category的list放到bigList中
        }
        // 2. 把查询的bigList交给application内置对象
        servletContextEvent.getServletContext().setAttribute("bigList",bigList);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
