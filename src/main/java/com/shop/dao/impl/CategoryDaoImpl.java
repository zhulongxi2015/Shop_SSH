package com.shop.dao.impl;

import com.shop.dao.CategoryDao;
import com.shop.po.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category>  implements CategoryDao {
     /*
     * 只需实现CategoryService接口中新增的方法即可，公共方法已经在BaseServiceImpl中实现了
     */

}
