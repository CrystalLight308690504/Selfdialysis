package com.zx.service.impl;

import com.zx.entity.User;
import com.zx.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zx.dao.inter.UserDao;

import java.util.List;


@Transactional
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
	private UserDao userDao;
	@Override
	public void save(User user) {
        userDao.save(user);
	}

	@Override
	public void delete(User user) {

	}

    @Override
    public void deleteById(Long deleteId) {

    }

    @Override
	public void update(User entity) {
		userDao.update(entity);
	}

	@Override
	public List listAll() {
		return userDao.listAll();
	}
	@Override
	public User getByName(String name) {
		return userDao.getByName(name);
	}
}
