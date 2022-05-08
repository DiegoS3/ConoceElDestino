package com.diego.conoceeldestino.controller

import com.diego.conoceeldestino.entity.Category
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.service.impl.CategoryServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rest/api/category")
class CategoryController : BaseController{

    @Autowired
    private lateinit var categoryService: CategoryServiceImpl

    @PostMapping("/search")
    @Throws(ConoceElDestinoException::class)
    @ResponseStatus(HttpStatus.CREATED)
    fun getAllCategories(): MutableIterable<Category> {
        return categoryService.findAllCategories()
    }

    @GetMapping
    @Throws(ConoceElDestinoException::class)
    private fun getCategoryByName(
        @RequestParam(name = "name") name: String
    ): ResponseEntity<Any> {
        val category = categoryService.findByName(name)
        return ResponseEntity.ok(category)
    }

    @PutMapping
    @Throws(ConoceElDestinoException::class)
    private fun putCategory(
        @RequestBody category: Category
    ): ResponseEntity<Any> {
        val updateCategory = categoryService.updateCategory(category)
        return ResponseEntity.ok(updateCategory)
    }

    @PostMapping
    @Throws(ConoceElDestinoException::class)
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
    ): ResponseEntity.BodyBuilder {
        val isDeleted = categoryService.deleteCategory(name)
        return if (isDeleted) ResponseEntity.ok()
        else ResponseEntity.badRequest()
    }

}