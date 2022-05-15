package com.diego.conoceeldestino.controller

import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.service.impl.ProductImageServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

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


}