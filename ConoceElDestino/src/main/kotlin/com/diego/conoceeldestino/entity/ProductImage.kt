package com.diego.conoceeldestino.entity

import javax.persistence.*

@Entity
@Table(name = "serviceimage")
open class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idserviceImage", nullable = false)
    open var id: Int? = null

    @Column(name = "image")
    open var image: ByteArray? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serviceId")
    open var service: Product? = null
}