package com.zx.service.inter;

import com.zx.service.inter.BaseService;
import com.zx.entity.User;

public interface UserService  extends BaseService<User> {
    User getByName(String name);
}
