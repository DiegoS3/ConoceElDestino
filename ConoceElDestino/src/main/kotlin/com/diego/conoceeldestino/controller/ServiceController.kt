package com.diego.conoceeldestino.controller

import com.diego.conoceeldestino.entity.Service
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.service.impl.ServiceServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest/api/service")
class ServiceController: BaseController {

    @Autowired
    private lateinit var serviceService: ServiceServiceImpl

    @PostMapping("/search")
    @Throws(ConoceElDestinoException::class)
    @ResponseStatus(HttpStatus.CREATED)
    fun getAllServices(): MutableIterable<Service> {
        return serviceService.findAllServices()
    }
}