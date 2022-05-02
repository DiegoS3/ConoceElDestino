package com.diego.conoceeldestino.service.impl

import com.diego.conoceeldestino.entity.Category
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.repository.ServiceRepository
import com.diego.conoceeldestino.service.ServiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class ServiceServiceImpl: ServiceService {

    @Autowired
    private lateinit var serviceRepository: ServiceRepository

    override fun findAllServices(): MutableIterable<com.diego.conoceeldestino.entity.Service> {
        try {
            val serviceList = serviceRepository.findAll()
            serviceList.map {
                it.duration = it.duration?.div(60)
            }
            return serviceList
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun updateService(service: com.diego.conoceeldestino.entity.Service): com.diego.conoceeldestino.entity.Service? {
        TODO("Not yet implemented")
    }

    override fun createService(service: com.diego.conoceeldestino.entity.Service): com.diego.conoceeldestino.entity.Service? {
        TODO("Not yet implemented")
    }

    override fun findServiceByName(name: String): Optional<com.diego.conoceeldestino.entity.Service> {
        TODO("Not yet implemented")
    }

    override fun findServiceByCategory(category: Category): MutableIterable<com.diego.conoceeldestino.entity.Service> {
        TODO("Not yet implemented")
    }

    override fun deleteService(name: String): Boolean {
        TODO("Not yet implemented")
    }
}