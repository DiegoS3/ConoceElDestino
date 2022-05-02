package com.diego.conoceeldestino.service

import com.diego.conoceeldestino.entity.Category
import com.diego.conoceeldestino.entity.Service
import java.util.*

interface ServiceService {

    fun findAllServices(): MutableIterable<Service>
    fun updateService(service: Service): Service?
    fun createService(service: Service): Service?
    fun findServiceByName(name: String): Optional<Service>
    fun findServiceByCategory(category: Category): MutableIterable<Service>
    fun deleteService(name: String): Boolean

}