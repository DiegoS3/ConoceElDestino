package com.diego.conoceeldestino.controller

import com.diego.conoceeldestino.dto.ProductDto
import com.diego.conoceeldestino.dto.ProductRequestDTO
import com.diego.conoceeldestino.entity.Product
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.service.impl.ProductServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rest/api/product")
class ProductController: BaseController {

    @Autowired
    private lateinit var productService: ProductServiceImpl

    @PostMapping("/search")
    @Throws(ConoceElDestinoException::class)
    @ResponseStatus(HttpStatus.CREATED)
    fun getAllProducts(): List<ProductDto> {
        return productService.findAllProduct()
    }

    @GetMapping
    @Throws(ConoceElDestinoException::class)
    private fun getProductByName(
        @RequestParam(name = "name") name: String
    ): ResponseEntity<Any> {
        val product = productService.findByName(name)
        return ResponseEntity.ok(product)
    }

    @GetMapping("/category/search")
    @Throws(ConoceElDestinoException::class)
    private fun getProducstByCategory(
        @RequestParam(name = "name") name: String
    ): ResponseEntity<Any> {
        val productList = productService.findByCategory(name)
        return ResponseEntity.ok(productList)
    }

    @PutMapping
    @Throws(ConoceElDestinoException::class)
    private fun putProduct(
        @RequestBody product: Product
    ): ResponseEntity<Any> {
        val updateProduct = productService.updateProduct(product)
        return ResponseEntity.ok(updateProduct)
    }

    @PostMapping
    @Throws(ConoceElDestinoException::class)
    private fun postProduct(
        @RequestBody product: ProductRequestDTO
    ): ResponseEntity<Any> {
        val newProduct = productService.createProduct(product)
        return ResponseEntity.ok(newProduct)
    }

    @DeleteMapping
    @Throws(ConoceElDestinoException::class)
    private fun deleteProduct(
        @RequestParam(name = "name") name: String
    ): ResponseEntity.BodyBuilder {
        val isDeleted = productService.deleteProduct(name)
        return if (isDeleted) ResponseEntity.ok()
        else ResponseEntity.badRequest()
    }
}