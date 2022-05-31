package com.diego.conoceeldestino.repository;

import com.diego.conoceeldestino.entity.Category
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryRepository : CrudRepository<Category, Int> {
    @Query("SELECT c FROM Category c WHERE c.name = ?1")
    fun findByName(name: String): Optional<Category>
}