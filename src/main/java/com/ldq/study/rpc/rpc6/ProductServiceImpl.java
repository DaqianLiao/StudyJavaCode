package com.ldq.study.rpc.rpc6;

import com.ldq.study.rpc.common.Product;
import com.ldq.study.rpc.common.ProductService;

public class ProductServiceImpl implements ProductService {
//    public ProductServiceImpl (){}
    @Override
    public Product findById(int id) {
        return new Product(id,"Phone");
    }

    @Override
    public Product save(Product product) {
        return product;
    }
}
