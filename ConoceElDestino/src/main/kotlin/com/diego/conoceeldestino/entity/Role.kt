package com.diego.conoceeldestino.entity

import javax.persistence.*

@Entity
@Table(
    name = "role", indexes = [
        Index(name = "role_name", columnList = "role_name", unique = true)
    ]
)
open class Role {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "role_name")
    open var roleName: String? = null

    @Column(name = "role_description")
    open var roleDescription: String? = null
}