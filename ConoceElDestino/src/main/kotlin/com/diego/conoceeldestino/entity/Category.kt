package com.diego.conoceeldestino.entity

import org.hibernate.Hibernate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "category")
data class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategory", nullable = false)
    val id: Int? = null,

    @Column(name = "name", nullable = false)
    var name: String? = null,

    @Column(name = "short_description", nullable = false)
    var shortDescription: String? = null,

    @Column(name = "long_description", nullable = false, length = 2000)
    var longDescription: String? = null,

    @Column(name = "image", nullable = false)
    var image: ByteArray? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Category

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    fun <T> Optional<T>.unwrap(): T? = orElse(null)

}