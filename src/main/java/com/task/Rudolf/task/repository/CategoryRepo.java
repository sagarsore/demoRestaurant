package com.task.Rudolf.task.repository;

import com.task.Rudolf.task.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CategoryRepo extends JpaRepository<Category,Long> {
    @Query( "select o from Category o where id in :ids" )
    Set<Category> findByCategoryIds(@Param("ids") Set<Long> categories);
}
