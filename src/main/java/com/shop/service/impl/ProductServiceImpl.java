package com.shop.service.impl;

import com.shop.dao.ProductDao;
import com.shop.po.Product;
import com.shop.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;

    public void save(Product product) {
        productDao.save(product);
    }

    public void update(Product product) {
        productDao.update(product);
    }

    public List<Product> queryJoinCategory(String name, int page, int size) {
        return productDao.queryJoinCategory(name,page,size);
    }

    public Long getCount(String name) {
        return productDao.getCount(name);
    }

    public void deleteByIds(String ids) {
        productDao.deleteByIds(ids);
    }
    public List<Product> querByCategoryId(int cid){
        return productDao.querByCategoryId(cid);
    }
}
