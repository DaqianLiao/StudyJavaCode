package com.ldq.study.rpc.rpc1;

import com.ldq.study.rpc.common.User;
import com.ldq.study.rpc.common.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User findById(int id) {
        return new User(id,"jack");
    }
    @Override
    public User save(User user) {
        return user;
    }
}
