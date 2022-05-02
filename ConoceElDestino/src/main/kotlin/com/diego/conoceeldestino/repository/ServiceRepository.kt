package com.diego.conoceeldestino.repository;

import com.diego.conoceeldestino.entity.Service
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ServiceRepository : CrudRepository<Service, Int>