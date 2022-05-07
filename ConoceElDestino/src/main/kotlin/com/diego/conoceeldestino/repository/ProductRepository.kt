package com.diego.conoceeldestino.repository;

import com.diego.conoceeldestino.entity.Product
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductRepository : CrudRepository<Product, Int> {
    @Query("SELECT p FROM Product p WHERE p.name = ?1")
    fun findByName(name: String): Optional<Product>

    @Query("select p from Product p where upper(p.category.name) = upper(?1)")
    fun findByCategory(name: String): Optional<Product>

}