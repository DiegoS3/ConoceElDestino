package com.diego.conoceeldestino.entity

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table(
    name = "category", indexes = [
        Index(name = "name_UNIQUE", columnList = "name", unique = true)
    ]
)
data class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategory", nullable = false)
    val id: Int? = null,

    @Column(name = "name", nullable = false)
    val name: String? = null,

    @Column(name = "short_description", nullable = false)
    val shortDescription: String? = null,

    @Column(name = "long_description", nullable = false, length = 2000)
    val longDescription: String? = null,

    @Column(name = "image", nullable = false)
    val image: ByteArray? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Category

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , shortDescription = $shortDescription , longDescription = $longDescription , image = $image )"
    }

}