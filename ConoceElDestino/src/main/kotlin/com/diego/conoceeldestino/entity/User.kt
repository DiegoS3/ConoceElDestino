package com.diego.conoceeldestino.entity

import java.time.Instant
import javax.persistence.*

@Entity
@Table(
    name = "user", indexes = [
        Index(name = "username", columnList = "username", unique = true)
    ]
)
open class User {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "name")
    open var name: String? = null

    @Column(name = "last_name")
    open var lastName: String? = null

    @Column(name = "username", nullable = false)
    open var username: String? = null

    @Column(name = "password", nullable = false)
    open var password: String? = null

    @Column(name = "created_at", nullable = false)
    open var createdAt: Instant? = null

    @Column(name = "email", nullable = false)
    open var email: String? = null

    @Column(name = "phone")
    open var phone: Long? = null
}