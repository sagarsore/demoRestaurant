package com.task.Rudolf.task.repository;

import com.task.Rudolf.task.entities.Category;
import com.task.Rudolf.task.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ProductRepo extends JpaRepository<Product,Long> {
    @Query( "select o from Product o where id in :ids" )
    Set<Product> findByProductIds(@Param("ids") Set<Long> products);
}
