package com.shop.dao;

import com.shop.po.Category;

import java.util.List;

public interface CategoryDao extends BaseDao<Category> {
        /*
        * 只要添加CategoryService本身需要的新的方法即可，公共方法已经在BaseService中了
        */
    public List<Category> queryJoinAccount(String type,int page,int size);
    public Long getCount(String type);
    public void deleteByIds(String ids);
    public List<Category> queryByHot(boolean hot);
}
