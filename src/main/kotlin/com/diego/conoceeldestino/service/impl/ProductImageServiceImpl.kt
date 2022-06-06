package com.diego.conoceeldestino.service.impl

import com.diego.conoceeldestino.dto.ProductImageDTO
import com.diego.conoceeldestino.dto.ProductImageRequestDTO
import com.diego.conoceeldestino.entity.Product
import com.diego.conoceeldestino.entity.ProductImage
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.repository.ProductImageRepository
import com.diego.conoceeldestino.repository.ProductRepository
import com.diego.conoceeldestino.service.ProductImageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductImageServiceImpl: ProductImageService {

    @Autowired
    private lateinit var productImageRepository: ProductImageRepository

    @Autowired
    private lateinit var productRepository: ProductRepository

    override fun findByProduct(id: Int): List<ProductImageDTO> {
        return try {
            productImageRepository.findByServiceId_IdEquals(id).map { images ->
                val list = images.map {
                    ProductImageDTO(
                        it.idserviceImage,
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

    override fun createImage(productImageRequestDTO: ProductImageRequestDTO): ProductImage {
        try {
            return productImageRepository.save(mapDtoToEntity(productImageRequestDTO))
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun updateImage(productImageRequestDTO: ProductImageRequestDTO): ProductImage {
        try {
            return productImageRepository.save(mapDtoToEntity(productImageRequestDTO))

        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun deleteImage(id: Int): Boolean {
        try {
            productImageRepository.deleteById(id)

            return !productImageRepository.findById(id).isPresent

        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    private fun mapDtoToEntity(productImageRequestDTO: ProductImageRequestDTO): ProductImage {
        val productImage = ProductImage()

        productImage.image = productImageRequestDTO.image
        productImage.serviceId = findProduct(productImageRequestDTO.service_id!!)

        return productImage
    }

    private fun findProduct(id: Int): Product {
        try {
            return productRepository.findById(id).get()
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }
}