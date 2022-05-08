package com.diego.conoceeldestino

import com.diego.conoceeldestino.repository.CategoryRepository
import com.diego.conoceeldestino.repository.ProductRepository
import com.diego.conoceeldestino.service.impl.CategoryServiceImpl
import com.diego.conoceeldestino.service.impl.ProductServiceImpl
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ConoceelDestinoConfiguration {

    @Bean
    fun databaseInitializer(categoryRepository: CategoryRepository,
                            categoryService: CategoryServiceImpl,
                            productRepository: ProductRepository,
                            productService: ProductServiceImpl
    ) = ApplicationRunner {


    }
}