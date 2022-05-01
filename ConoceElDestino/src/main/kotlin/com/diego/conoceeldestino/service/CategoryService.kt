package com.diego.conoceeldestino.service

import com.diego.conoceeldestino.entity.Category
import com.diego.conoceeldestino.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired

class CategoryService {

    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    fun findAllCategories(): List<Category> {
        return categoryRepository.findCategories()
    }

}