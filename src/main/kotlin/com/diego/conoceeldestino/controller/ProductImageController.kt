package com.diego.conoceeldestino.controller

import com.diego.conoceeldestino.dto.ProductImageRequestDTO
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.service.impl.ProductImageServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rest/api/images")
class ProductImageController: BaseController {

    @Autowired
    private lateinit var productImageService: ProductImageServiceImpl

    @GetMapping("/search")
    @Throws(ConoceElDestinoException::class)
    private fun getImageList(
        @RequestParam(name = "name") name: Int
    ): ResponseEntity<Any> {
        val imageList = productImageService.findByProduct(name)
        return ResponseEntity.ok(imageList)
    }

    @PostMapping
    @Throws(ConoceElDestinoException::class)
    private fun createImage(
        @RequestBody productImageRequestDTO: ProductImageRequestDTO
    ): ResponseEntity<Any> {
        val image = productImageService.createImage(productImageRequestDTO)
        return ResponseEntity.ok(image)
    }
    @PutMapping
    @Throws(ConoceElDestinoException::class)
    private fun updateImage(
        @RequestBody productImageRequestDTO: ProductImageRequestDTO
    ): ResponseEntity<Any> {
        val image = productImageService.updateImage(productImageRequestDTO)
        return ResponseEntity.ok(image)
    }
    @DeleteMapping
    @Throws(ConoceElDestinoException::class)
    private fun deleteImage(
        @RequestParam(name = "id") id: Int
    ): ResponseEntity<Any> {
        val image = productImageService.deleteImage(id)
        return ResponseEntity.ok(image)
    }


}