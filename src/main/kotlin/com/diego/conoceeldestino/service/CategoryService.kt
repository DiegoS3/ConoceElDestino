package com.diego.conoceeldestino.service

import com.diego.conoceeldestino.entity.Category
import java.util.*

interface CategoryService {

    fun findAllCategories(): MutableIterable<Category>
    fun updateCategory(category: Category): Category?
    fun createCategory(category: Category): Category?
    fun findByName(name: String): Optional<Category>
    fun deleteCategory(name: String): Boolean
}