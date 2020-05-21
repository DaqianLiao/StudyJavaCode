package com.ldq.study.rpc.rpc6;

import com.ldq.study.rpc.common.User;
import com.ldq.study.rpc.common.UserService;

public class UserServiceImpl implements UserService {
//    public UserServiceImpl(){}
    @Override
    public User findById(int id) {
        return new User(id,"jack");
    }
    @Override
    public User save(User user) {
        return user;
    }
}
