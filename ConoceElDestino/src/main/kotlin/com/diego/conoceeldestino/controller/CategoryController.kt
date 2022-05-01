package com.diego.conoceeldestino.controller

import com.diego.conoceeldestino.entity.Category
import com.diego.conoceeldestino.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/rest/api/category")
class CategoryController {

    @Autowired
    private lateinit var categoryService: CategoryService

    @GetMapping("/search")
    fun getAllCategories(): ResponseEntity<Any> {
        val listCategory = categoryService.findAllCategories()
        return ResponseEntity.ok(listCategory)
    }
}