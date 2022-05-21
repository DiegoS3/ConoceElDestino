package com.diego.conoceeldestino.service.impl

import com.diego.conoceeldestino.dto.ProductImageDTO
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.repository.ProductImageRepository
import com.diego.conoceeldestino.service.ProductImageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductImageServiceImpl: ProductImageService {

    @Autowired
    private lateinit var productImageRepository: ProductImageRepository

    override fun findByProduct(id: Int): List<ProductImageDTO> {
        return try {
            productImageRepository.findByService_IdEquals(id).map { images ->
                val list = images.map {
                    ProductImageDTO(
                        it.id,
                        it.image
                    )
                }
                return@map list
            }.orElseGet {
                throw ConoceElDestinoException()
            }
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }
}