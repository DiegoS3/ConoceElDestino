package com.diego.conoceeldestino.repository
import com.diego.conoceeldestino.entity.ProductImage
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductImageRepository : CrudRepository<ProductImage, Int> {
    fun findByServiceId_IdEquals(id: Int): Optional<MutableIterable<ProductImage>>

}