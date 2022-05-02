package com.diego.conoceeldestino.service.impl

import com.diego.conoceeldestino.entity.Category
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.repository.CategoryRepository
import com.diego.conoceeldestino.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl: CategoryService{

    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    override fun findAllCategories(): MutableIterable<Category> {
        return categoryRepository.findAll()
    }

    override fun updateCategory(category: Category): Category? {
        return categoryRepository.findByName(category.name!!)
            .map {
                it.name = category.name
                it.image = category.image
                it.longDescription = category.longDescription
                it.shortDescription = category.shortDescription
                return@map categoryRepository.save(category)
            }
            .orElseGet {
                return@orElseGet categoryRepository.save(category)
            }
    }

    override fun createCategory(category: Category): Category? {
        return categoryRepository.findByName(category.name!!).orElse(categoryRepository.save(category) )
    }

    override fun findByName(name: String): Category? {
        return categoryRepository.findByName(name).orElseThrow { ConoceElDestinoException(Category::class, name) }
    }

    override fun deleteCategory(name: String): Boolean{
        return try {
            val existCategory: Category? = findByName(name)
            categoryRepository.delete(existCategory!!)
            true
        } catch (cede: ConoceElDestinoException) {
            false
        }
    }

}