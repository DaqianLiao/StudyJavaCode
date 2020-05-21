package com.ldq.study.rpc.common;

public interface ProductService {
    Product findById(int id);

    Product save(Product product);
}
