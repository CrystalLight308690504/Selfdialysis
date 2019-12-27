package com.zx.dao.Impl;

import com.zx.dao.inter.UserDao;
import com.zx.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User getByName(String name) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("name", name));
        List list = criteria.list();
        if(list.isEmpty()){
            return null;
        }else {
            return (User) list.get(0);
        }
    }
}
