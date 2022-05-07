package com.diego.conoceeldestino.service.impl

import com.diego.conoceeldestino.entity.Category
import com.diego.conoceeldestino.entity.Product
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.repository.ServiceRepository
import com.diego.conoceeldestino.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl: ProductService {

    @Autowired
    private lateinit var serviceRepository: ServiceRepository

    override fun findAllServices(): MutableIterable<Product> {
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

    override fun updateService(product: Product): Product? {
        TODO("Not yet implemented")
    }

    override fun createService(product: Product): Product? {
        TODO("Not yet implemented")
    }

    override fun findServiceByName(name: String): Optional<Product> {
        TODO("Not yet implemented")
    }

    override fun findServiceByCategory(category: Category): MutableIterable<Product> {
        TODO("Not yet implemented")
    }

    override fun deleteService(name: String): Boolean {
        TODO("Not yet implemented")
    }
}