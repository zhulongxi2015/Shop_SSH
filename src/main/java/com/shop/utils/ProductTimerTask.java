package com.shop.utils;

import com.shop.po.Category;
import com.shop.po.Product;
import com.shop.service.CategoryService;
import com.shop.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
@Component//把该对象交给Spring管理
public class ProductTimerTask extends TimerTask {
    @Resource
    private ProductService productService;//注入productService
    @Resource
    private CategoryService categoryService;//注入categoryService
    private ServletContext servletContext=null;//定义一个ServletContext对象，因为我们更新了后台数据后，需要存入application域里面
    //通过监听器将这个application对象set进来，因为这里是无法拿application对象的
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public void run() {
        System.out.println("----run----");
        List<List<Product>> bigList = new ArrayList<List<Product>>(); //bigList中存放一个装有Category类的list
        // 1. 查询出热点类别
        for(Category category : categoryService.queryByHot(true)) {
            //根据热点类别id获取推荐商品信息
            List<Product> lst = productService.querByCategoryId(category.getId());
            bigList.add(lst); //将装有category的list放到bigList中
        }
        // 2. 把查询的bigList交给application内置对象
        servletContext.setAttribute("bigList", bigList); //假设我们已经拿到了application对象
    }
}
