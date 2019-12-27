package com.zx.dao.inter;

import com.zx.dao.inter.BaseDao;
import com.zx.entity.User;

public interface  UserDao extends BaseDao<User> {

    User getByName(String name);
}
