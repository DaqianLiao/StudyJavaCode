package com.ldq.study.rpc.common;

public interface UserService {
    User findById(int id);
    User save(User user);
}
