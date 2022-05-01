package com.diego.conoceeldestino.repository;

import com.diego.conoceeldestino.entity.Category
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Int>{
    @Query("select * from category")
    fun findCategories(): List<Category>
}