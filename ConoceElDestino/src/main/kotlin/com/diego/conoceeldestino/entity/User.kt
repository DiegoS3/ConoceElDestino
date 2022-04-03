package com.diego.conoceeldestino.entity

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import java.time.Instant
import java.util.*
import javax.persistence.*


@Entity
@Table(
    name = "user", indexes = [
        Index(name = "username", columnList = "username", unique = true)
    ]
)
open class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    open var id: UUID? = null

    @Column(name = "name")
    open var name: String? = null

    @Column(name = "last_name")
    open var lastName: String? = null

    @Column(name = "username", nullable = false)
    open var username: String? = null

    @Column(name = "password", nullable = false)
    open var password: String? = null

    @Column(name = "created_at")
    open var createdAt: Instant? = null

    @Column(name = "email", nullable = false)
    open var email: String? = null

    @Column(name = "phone")
    open var phone: Long? = null
}