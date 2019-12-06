package com.example.atom.dao;

import com.example.atom.pojo.ProductPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {

    ProductPo getProduct(Long id);

    int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity);

}
