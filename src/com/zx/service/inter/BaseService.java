package com.zx.service.inter;

import java.util.List;

public interface BaseService<T> {
    void save(T entity);
    void delete(T entity);
    void deleteById(Long deleteId);
    void update(T entity);
    List listAll();
}
