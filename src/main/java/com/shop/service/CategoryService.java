package com.shop.service;

import com.shop.po.Category;

import java.util.List;

public interface CategoryService {
    public void save(Category category);
    public void update(Category category);
    public void delete(int id);
    public Category get(int id);
    public List<Category> query();
}
