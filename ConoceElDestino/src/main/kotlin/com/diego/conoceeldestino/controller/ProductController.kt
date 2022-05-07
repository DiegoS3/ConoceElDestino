package com.diego.conoceeldestino.controller

import com.diego.conoceeldestino.entity.Product
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.service.impl.ProductServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest/api/service")
class ProductController: BaseController {

    @Autowired
    private lateinit var serviceService: ProductServiceImpl

    @PostMapping("/search")
    @Throws(ConoceElDestinoException::class)
    @ResponseStatus(HttpStatus.CREATED)
    fun getAllServices(): MutableIterable<Product> {
        return serviceService.findAllServices()
    }
}