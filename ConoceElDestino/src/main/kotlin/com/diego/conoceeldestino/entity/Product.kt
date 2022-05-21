package com.diego.conoceeldestino.entity

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "service")
open class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idservice", nullable = false)
    open var id: Int? = null

    @Column(name = "name", nullable = false)
    open var name: String? = null

    @Column(name = "short_description", nullable = false)
    open var shortDescription: String? = null

    @Column(name = "long_description", nullable = false, length = 5000)
    open var longDescription: String? = null

    @Column(name = "included", nullable = false, length = 2000)
    open var included: String? = null

    @Column(name = "not_included", nullable = false, length = 2000)
    open var notIncluded: String? = null

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    open var price: BigDecimal? = null

    @Column(name = "duration", nullable = false)
    open var duration: Double? = null

    @Column(name = "departure", nullable = false)
    open var departure: String? = null

    @Column(name = "arrival", nullable = false)
    open var arrival: String? = null

    @Column(name = "distance")
    open var distance: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category")
    open var category: Category? = null

    @Column(name = "place", nullable = false)
    open var place: String? = null

    @JoinColumn(name = "horario")
    open var horario: Int? = null
}