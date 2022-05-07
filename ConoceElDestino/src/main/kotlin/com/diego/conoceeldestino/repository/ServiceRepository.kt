package com.diego.conoceeldestino.repository;

import com.diego.conoceeldestino.entity.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ServiceRepository : CrudRepository<Product, Int>