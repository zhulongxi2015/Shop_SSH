package com.shop.dao.impl;

import com.shop.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.runners.Parameterized;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository("baseDao")
@Lazy(true)
public class BaseDaoImpl<T> implements BaseDao<T> {
    private  Class clazz;
    public BaseDaoImpl(){
        ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
        clazz=(Class)type.getActualTypeArguments()[0];
    }
    /* Spring3时代，为整合Hibernate3提供了HibernateTemplate， 为Dao提供了工具类：HibernateDaoSupport。
     Spring4进行了扩展，不再推荐使用HibernateTemplate，HibernateDaoSupport来实现Dao组件，而是使用SessionFactory的getSession()获取session，然后进行持久化。
    */

    /*
    * openSession ，是打开一个新的session对象，而且每次使用都是打开一个新的session，假如连续使用多次，则获得的session不是同一个对象，并且使用完需要调用close方法关闭session。
      getCurrentSession ，是获取当前上下文一个session对象，当第一次使用此方法时，会自动产生一个session对象，并且连续使用多次时，得到的session都是同一个对象，并且事务提交会自动close，不需要像openSession一样自己调用close方法关闭session
     所以，使用getCurrentSession 就要进行事务管理配置.
    * */
    @Resource
    private SessionFactory sessionFactory;
    /*public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/
    protected Session getSession() {
        //从当前线程获取session，如果没有则创建一个新的session
        return sessionFactory.openSession();
    }
    public void save(T t) {
        getSession().save(t);
    }

    public void update(T t) {
        getSession().update(t);
    }

    public void delete(int id) {
        String hql="delete "+clazz.getSimpleName()+" as c where c.id=:id" ;
        getSession().createQuery(hql).setInteger("id",id).executeUpdate();
    }

    public T get(int id) {
        return (T)getSession().get(clazz,id);
    }

    public List<T> query() {
        String hql="from "+clazz.getSimpleName();
        return getSession().createQuery(hql).list();
    }
}
