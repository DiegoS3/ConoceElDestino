package com.diego.conoceeldestino.controller

import com.diego.conoceeldestino.entity.Category
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.service.impl.CategoryServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/rest/api/category")
class CategoryController {

    @Autowired
    private lateinit var categoryService: CategoryServiceImpl

    @GetMapping("/search")
    private fun getAllCategories(): ResponseEntity<Any> {
        val listCategory = categoryService.findAllCategories()
        return ResponseEntity.ok(listCategory)
    }

    @GetMapping
    private fun getCategoryByName(
        @RequestParam(name = "name") name: String
    ): ResponseEntity<Any> {
        val category = categoryService.findByName(name)
        return ResponseEntity.ok(category)
    }

    @PutMapping
    private fun putCategory(
        @RequestBody category: Category
    ): ResponseEntity<Any> {
        val updateCategory = categoryService.updateCategory(category)
        return ResponseEntity.ok(updateCategory)
    }

    @PostMapping
    private fun postCategory(
        @RequestBody category: Category
    ): ResponseEntity<Any> {
        val updateCategory = categoryService.createCategory(category)
        return ResponseEntity.ok(updateCategory)
    }

    @DeleteMapping
    @Throws(ConoceElDestinoException::class)
    private fun deleteCategory(
        @RequestParam(name = "name") name: String
    ):  ResponseEntity<Any>  {
        val isDeleted = categoryService.deleteCategory(name)
        return ResponseEntity.ok(isDeleted)
    }

}