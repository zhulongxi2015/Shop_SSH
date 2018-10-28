package com.shop.test;

import com.shop.po.Category;
import com.shop.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring.xml")
public class CategoryServiceImplTest {
    @Autowired
    private CategoryService categoryService;
    @Test
    public void testQuery(){
        for(Category c:categoryService.queryJoinAccount("n",1,2)){
            System.out.println(c);
            System.out.println(c.getAccount());
        }
    }
}
