package com.shop.listener;

import com.shop.po.Category;
import com.shop.po.Product;
import com.shop.service.CategoryService;
import com.shop.service.ProductService;
import com.shop.utils.ProductTimerTask;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

//@Component //监听器是web层的组件，它是tomcat实例化的，不是Spring实例化的。不能放到Spring中
public class InitDataListener implements ServletContextListener {

    private ProductTimerTask productTimerTask;
    private ApplicationContext applicationContext;
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        applicationContext=WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        productTimerTask=(ProductTimerTask)applicationContext.getBean("productTimerTask");
        //把内置对象交给productTimerTask,因为productTimerTask里面是拿不到application的，只能通过监听器set给它
        productTimerTask.setServletContext(servletContextEvent.getServletContext());

        //通过设置定时器，让首页的数据每个一小时同步一次（配置为守护线程）
        new Timer(true).schedule(productTimerTask,0,1000*60*2);//每个一小时执行一次productTimerTask任务，即更新一下后台数据
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
