package com.java.spring.springsecurityjwt.service;


import com.java.spring.springsecurityjwt.dto.ProductRequestDto;
import com.java.spring.springsecurityjwt.dto.ProductResponseDto;
import com.java.spring.springsecurityjwt.exception.ProductExistsException;
import com.java.spring.springsecurityjwt.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
     /*
        CREATE PRODUCT
     */

    ProductResponseDto save(

            ProductRequestDto request

    ) throws ProductExistsException;

    /*
        GET ALL PRODUCTS
     */

    List<ProductResponseDto> getAll();

    /*
        GET PRODUCT BY ID
     */

    ProductResponseDto getById(

            int id

    ) throws ProductNotFoundException;

    /*
        UPDATE PRODUCT
     */

    ProductResponseDto update(

            int id,

            ProductRequestDto request

    ) throws ProductNotFoundException;

    /*
        DELETE PRODUCT
     */

    void deleteById(

            int id

    ) throws ProductNotFoundException;
}
