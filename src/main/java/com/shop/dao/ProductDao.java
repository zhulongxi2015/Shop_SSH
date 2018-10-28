package com.shop.dao;

import com.shop.po.Product;

import java.util.List;

public interface ProductDao extends BaseDao<Product> {
    public List<Product> queryJoinCategory(String name, int page, int size);
    public Long getCount(String name);
    public void deleteByIds(String ids);
    //根据热点类别查询推荐商品（仅仅查询前4个）
    public List<Product> querByCategoryId(int cid);
}
