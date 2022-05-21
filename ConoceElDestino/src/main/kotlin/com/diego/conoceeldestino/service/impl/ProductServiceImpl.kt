package com.diego.conoceeldestino.service.impl

import com.diego.conoceeldestino.dto.ProductDto
import com.diego.conoceeldestino.dto.ProductImageDTO
import com.diego.conoceeldestino.dto.ProductRequestDTO
import com.diego.conoceeldestino.entity.Category
import com.diego.conoceeldestino.entity.Product
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.repository.CategoryRepository
import com.diego.conoceeldestino.repository.ProductImageRepository
import com.diego.conoceeldestino.repository.ProductRepository
import com.diego.conoceeldestino.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl : ProductService {

    @Autowired
    private lateinit var productRepository: ProductRepository

    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    @Autowired
    private lateinit var productImageRepository: ProductImageRepository

    override fun findAllProduct(): List<ProductDto> {
        try {
            val productList = productRepository.findAll()
            val list  = productList.map {
                ProductDto(
                    it.id,
                    it.name,
                    it.shortDescription,
                    it.longDescription,
                    it.included?.split('.')?.toTypedArray(),
                    it.notIncluded?.split('.')?.toTypedArray(),
                    it.price,
                    it.duration,
                    it.departure,
                    it.arrival,
                    it.distance,
                    it.place,
                    it.horario,
                    getImages(it)
                )
            }
            return list
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun updateProduct(product: Product): Product? {
        try {
            return productRepository.findByName(product.name!!)
                .map {
                    product.category = it.category
                    return@map productRepository.save(product)
                }
                .orElseGet {
                    return@orElseGet productRepository.save(product)
                }
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun createProduct(product: ProductRequestDTO): Product? {
        try {
            return productRepository.findByName(product.name!!)
                .orElse(createProductWithCategory(product))
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun findByName(name: String): Optional<Product> {
        try {
            return productRepository.findByName(name)
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun findByCategory(name: String): List<ProductDto> {
        return try {
            productRepository.findByCategory(name).map { products ->
                val list = products.map {
                    ProductDto(
                        it.id,
                        it.name,
                        it.shortDescription,
                        it.longDescription,
                        it.included?.split('.')?.toTypedArray(),
                        it.notIncluded?.split('.')?.toTypedArray(),
                        it.price,
                        it.duration,
                        it.departure,
                        it.arrival,
                        it.distance,
                        it.place,
                        it.horario,
                        getImages(it)
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

    override fun deleteProduct(name: String): Boolean {
        try {
            return findByName(name)
                .map {
                    productRepository.delete(it)
                    return@map true
                }.orElseGet {
                    return@orElseGet false
                }
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    private fun createProductWithCategory(product: ProductRequestDTO): Product? {
        try {
            var category: Category?
            val productEntity = Product()
            categoryRepository.findByName(product.nameCategory!!).map {
                category = Category(
                    it.id,
                    it.name,
                    it.shortDescription,
                    it.longDescription,
                    it.image
                )
                productEntity.name = product.name
                productEntity.category = category
                productEntity.shortDescription = product.shortDescription
                productEntity.longDescription = product.longDescription
                productEntity.included = product.included
                productEntity.notIncluded = product.notIncluded
                productEntity.price = product.price
                productEntity.duration = product.duration
                productEntity.departure = product.departure
                productEntity.arrival = product.arrival
                productEntity.distance = product.distance
                productEntity.place = product.place
                productEntity.place = product.place
                productEntity.horario = product.horario

                return@map productRepository.save(productEntity)
            }.orElseGet{
                 throw ConoceElDestinoException()
            }

        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
        return null
    }

    private fun getImages(product: Product): MutableList<ProductImageDTO> {
        val listImage: MutableList<ProductImageDTO> = mutableListOf()
        productImageRepository.findByService_IdEquals(product.id!!).map { list ->
            list.forEach {
                listImage.add(ProductImageDTO(it.id, it.image))
            }
        }
        return listImage
    }
}