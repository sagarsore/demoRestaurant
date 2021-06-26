package com.task.Rudolf.task.service;

import com.task.Rudolf.task.Exception.CommonException;
import com.task.Rudolf.task.web.data.ProductDto;

public interface ProductService {
    public void addProduct(ProductDto productDto) throws CommonException, Exception;
}
