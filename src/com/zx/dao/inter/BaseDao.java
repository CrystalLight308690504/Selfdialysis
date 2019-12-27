package com.zx.dao.inter;


import java.util.List;

/**
 * Dao基础接口
 *
 * @param <T> 需要操作的实体类泛型
 */
public interface BaseDao<T> {

    /**
     * 查询实体
     *
     * @param entity
     */
    void save(T entity);

    /**
     * 删除实体
     *
     * @param entity
     */
    void delete(T entity);

    /**
     * 通过id删除实体
     *
     * @param id
     */
    void deleteById(Long id);

    /**
     * 通过id 集合删除实体
     *
     * @param id
     */
    void deleteByIds(Long[] id);

    /**
     * 更新实体
     *
     * @param entity
     */
    void update(T entity);

    /**
     * 根据id查询单个实体
     *
     * @param selectedId
     * @return 查询的单个实体类
     */
    T getById(Long selectedId);

    /**
     * 根据id数组查询多个实体
     *
     * @param selectedIds
     * @return
     */
    List<T> listByIds(Object[] selectedIds);

    /**
     * 查询所有实体
     *
     * @return
     */
    List<T> listAll();

}