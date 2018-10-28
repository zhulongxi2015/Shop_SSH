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
    public List<Category> queryJoinAccount(String type,int page,int size) {
        String hql="from Category c left join fetch c.account where c.type like :type";
        return getSession().createQuery(hql).setString("type","%"+type+"%")
                .setFirstResult((page-1)*size).setMaxResults(size).list();
    }
    public Long getCount(String type){
        String hql = "select count(c) from Category c where c.type like :type";
        return (Long)getSession().createQuery(hql).setString("type", "%" + type + "%").uniqueResult(); //返回一条记录:总记录数
    }

    public void deleteByIds(String ids) {
        String hql="delete Category where id in("+ids+")";
        getSession().createQuery(hql).executeUpdate();
    }
    public List<Category> queryByHot(boolean hot) {
        String hql = "from Category c where c.hot=:hot";
        return getSession().createQuery(hql)
                .setInteger("hot", (hot?1:0))
                .list();
    }
}
