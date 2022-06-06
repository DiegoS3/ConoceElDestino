package com.diego.conoceeldestino.service.impl

import com.diego.conoceeldestino.dto.*
import com.diego.conoceeldestino.entity.Category
import com.diego.conoceeldestino.entity.Product
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.repository.CategoryRepository
import com.diego.conoceeldestino.repository.HorarioRepository
import com.diego.conoceeldestino.repository.ProductImageRepository
import com.diego.conoceeldestino.repository.ProductRepository
import com.diego.conoceeldestino.service.HorarioService
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

    @Autowired
    private lateinit var horarioService: HorarioService

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
                    it.priceIndi,
                    it.priceGroup,
                    it.duration,
                    it.departure,
                    it.arrival,
                    it.distance,
                    it.place,
                    it.category?.name,
                    getHorario(it),
                    getImages(it)
                )
            }
            return list
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun updateProduct(product: ProductRequestDTO): Product? {
        try {
            return productRepository.findByName(product.name!!)
                .map { productFounded ->
                    categoryRepository.findByName(product.nameCategory!!).map {
                        val category = Category(
                            it.id,
                            it.name,
                            it.shortDescription,
                            it.longDescription,
                            it.image
                        )
                        productFounded.name = product.name
                        productFounded.category = category
                        productFounded.shortDescription = product.shortDescription
                        productFounded.longDescription = product.longDescription
                        productFounded.included = product.included
                        productFounded.notIncluded = product.notIncluded
                        productFounded.priceIndi = product.priceIndi
                        productFounded.priceGroup = product.priceGroup
                        productFounded.duration = product.duration
                        productFounded.departure = product.departure
                        productFounded.arrival = product.arrival
                        productFounded.distance = product.distance
                        productFounded.place = product.place
                        productFounded.horario = product.horario
                    }
                    return@map productRepository.save(productFounded)
                }
                .orElseGet {
                    return@orElseGet createProductWithCategory(product)!!
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

    override fun findByName(name: String): Optional<ProductDto> {
        try {
            return productRepository.findByName(name).map {
                    ProductDto(
                        it.id,
                        it.name,
                        it.shortDescription,
                        it.longDescription,
                        it.included?.split('.')?.toTypedArray(),
                        it.notIncluded?.split('.')?.toTypedArray(),
                        it.priceIndi,
                        it.priceGroup,
                        it.duration,
                        it.departure,
                        it.arrival,
                        it.distance,
                        it.place,
                        it.category?.name,
                        getHorario(it),
                        getImages(it)
                    )
                }
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
                        it.priceIndi,
                        it.priceGroup,
                        it.duration,
                        it.departure,
                        it.arrival,
                        it.distance,
                        it.place,
                        it.category?.name,
                        getHorario(it),
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
                    productRepository.deleteById(it.id!!)
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
                productEntity.priceIndi = product.priceIndi
                productEntity.priceGroup = product.priceGroup
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
        productImageRepository.findByServiceIdEquals(product.id!!).map { list ->
            list.forEach {
                listImage.add(ProductImageDTO(it.idserviceImage, it.image))
            }
        }
        return listImage
    }

    private fun getHorario(product: Product): HorarioResponseDTO? {
        return horarioService.findHorarioById(product.horario!!)
    }
}