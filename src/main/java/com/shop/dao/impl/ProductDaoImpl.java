package com.shop.dao.impl;

import com.shop.dao.ProductDao;
import com.shop.po.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("productDao")
public class ProductDaoImpl extends  BaseDaoImpl<Product> implements ProductDao {
    public List<Product> queryJoinCategory(String name, int page, int size) {
        String hql = "from Product p left join fetch p.category  where p.name like:name";
        return getSession().createQuery(hql)
            .setString("name", "%" + name + "%")
            .setFirstResult((page - 1) * size) //从第几个开始显示
            .setMaxResults(size) //显示几个
            .list();
    }

    public Long getCount(String name) {
        String hql = "select count(p) from Product p where p.name like :name";
        return (Long) getSession().createQuery(hql)
            .setString("name", "%" + name + "%")
            .uniqueResult(); //返回一条记录:总记录数
    }

    public void deleteByIds(String ids){
        String hql = "delete from Product p where p.id in (" + ids + ")";
        getSession().createQuery(hql).executeUpdate();
    }
    public List<Product> querByCategoryId(int cid) {
        String hql = "from Product p join fetch p.category "
        + "where p.commend=1 and p.open=1 and p.category.id=:cid order by p.date desc";
        return getSession().createQuery(hql).setInteger("cid",cid).setFirstResult(0).setMaxResults(4).list();
    }
}
