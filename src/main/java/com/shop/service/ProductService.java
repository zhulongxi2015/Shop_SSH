package com.shop.service;

import com.shop.po.Product;

import java.util.List;

public interface ProductService {
    public void save(Product product);
    public void update(Product product);
    public List<Product> queryJoinCategory(String name, int page, int size);
    public Long getCount(String name);
    public void deleteByIds(String ids);
    public List<Product> querByCategoryId(int cid);
}
