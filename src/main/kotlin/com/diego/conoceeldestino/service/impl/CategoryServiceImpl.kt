package com.diego.conoceeldestino.service.impl

import com.diego.conoceeldestino.entity.Category
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.repository.CategoryRepository
import com.diego.conoceeldestino.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryServiceImpl : CategoryService {

    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    @Throws(ConoceElDestinoException::class)
    override fun findAllCategories(): MutableIterable<Category> {
        try {
            return categoryRepository.findAll()
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun updateCategory(category: Category): Category? {
        try {
            return categoryRepository.findByName(category.name!!)
                .map {
                    it.name = category.name
                    it.image = category.image
                    it.longDescription = category.longDescription
                    it.shortDescription = category.shortDescription
                    return@map categoryRepository.save(it)
                }
                .orElseGet {
                    return@orElseGet categoryRepository.save(category)
                }
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun createCategory(category: Category): Category? {
        try {
            return categoryRepository.findByName(category.name!!).orElse(categoryRepository.save(category))
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun findByName(name: String): Optional<Category> {
        try {
            return categoryRepository.findByName(name)
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun deleteCategory(name: String): Boolean {
        try {
            return findByName(name)
                .map {
                    categoryRepository.delete(it)
                    return@map true
                }.orElseGet{
                    return@orElseGet false
                }
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

}