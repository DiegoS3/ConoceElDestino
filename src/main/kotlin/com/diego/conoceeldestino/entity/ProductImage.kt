package com.diego.conoceeldestino.entity

import javax.persistence.*

@Entity
@Table(name = "serviceimage")
open class ProductImage {

    @Column(name = "image")
    open var image: ByteArray? = null

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idservice_image", nullable = false)
    open var idserviceImage: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    open var serviceId: Product? = null
}