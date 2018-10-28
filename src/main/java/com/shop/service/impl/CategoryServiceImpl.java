package com.shop.service.impl;

import com.shop.dao.CategoryDao;
import com.shop.po.Category;
import com.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    /*public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }*/

    public void save(Category category) {
        this.categoryDao.save(category);
    }

    public void update(Category category) {
        this.categoryDao.update(category);
    }

    public void delete(int id) {
        this.categoryDao.delete(id);
    }

    public Category get(int id) {
       return this.categoryDao.get(id);
    }

    public List<Category> query() {
        return this.categoryDao.query();
    }
    public List<Category> queryJoinAccount(String type,int page,int size){
        return categoryDao.queryJoinAccount(type,page,size);
    }
    public Long getCount(String type){
        return categoryDao.getCount(type);
    }

    public void deleteByIds(String ids) {
        categoryDao.deleteByIds(ids);
    }
    public List<Category> queryByHot(boolean hot) {
        return categoryDao.queryByHot(hot);
    }
}
