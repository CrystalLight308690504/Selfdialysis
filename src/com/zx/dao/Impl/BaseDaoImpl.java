package com.zx.dao.Impl;

import com.zx.dao.inter.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

/**
 * 方便userdao的获取泛型类类名,方便通过类查找
 *
 * @param <T>
 * @author zx
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {


    Class<T> clazz;// 泛型类
    @Autowired
    protected HibernateTemplate hibernateTemplate;
    @Autowired
    protected SessionFactory sessionFactory;

    public BaseDaoImpl() {
        // 通过反射得到T的真实类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class) pt.getActualTypeArguments()[0];
    }

    /**
     * 查询实体
     *
     * @param entity
     */
    @Override
    public void save(T entity) {
        hibernateTemplate.save(entity);
    }

    /**
     * 删除实体
     *
     * @param entity
     */
    @Override
    public void delete(T entity) {
        hibernateTemplate.delete(entity);
    }

    /**
     * 根据id数组删除实体
     *
     * @return
     */
    @Override
    public void deleteById(Long id) {
        System.out.println("id....."+id);
        if (null != id) {
          Object oj = hibernateTemplate.get(clazz,id);
          if(oj != null){
              hibernateTemplate.delete(oj);
          }
        }
    }

    /**
     * 通过id 集合删除实体
     *
     * @param ids
     */
    @Override
    public void deleteByIds(Long[] ids) {
        String hql = "delete from "+clazz.getSimpleName()+" where id in (:ids)";
        getSession().createQuery(hql).setParameterList("ids",ids).list();
    }

    /**
     * 更新实体
     *
     * @param entity
     */
    @Override
    public void update(T entity) {
        hibernateTemplate.update(entity);
    }

    /**
     * 根据id查询单个实体
     *
     * @param selectedId
     * @return 查询的单个实体类
     */
    @Override
    public T getById(Long selectedId) {
        return (T) hibernateTemplate.get(clazz, selectedId);
    }

    /**
     * 根据id数组查询多个实体
     *
     * @param selectedIds
     * @return
     */
    @Override
    public List<T> listByIds(Object[] selectedIds) {
        if (null != selectedIds && selectedIds.length != 0) {
            String hql = "select * from " + clazz.getSimpleName() + " where id in (:ids)";
            return (List) hibernateTemplate.find(hql, selectedIds);
        }
        return Collections.EMPTY_LIST;
    }


    /**
     * 查询所有实体
     *
     * @return
     */
    @Override
    public List<T> listAll() {
        String hql = "from " + clazz.getSimpleName()+" as t order by t.writingDate DESC";
        Session session = sessionFactory.getCurrentSession();
        return (List<T>) hibernateTemplate.find(hql);
    }

    protected Session getSession(){
        return  sessionFactory.getCurrentSession();
    }
}
