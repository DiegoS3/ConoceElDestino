package com.diego.conoceeldestino.entity

import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import javax.persistence.*

@Entity
@Table(name = "user")
open class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "name", nullable = false)
    open var name: String? = null

    @Column(name = "last_name", nullable = false)
    open var last_name: String? = null

    @Column(name = "user_name", nullable = false)
    open var user_name: String? = null

    @Column(name = "created_at")
    open var created_at: String = DateTimeFormatter
        .ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")
        .withZone(ZoneOffset.UTC)
        .format(Instant.now())

    @Column(name = "email", nullable = false)
    open var email: String? = null

    @Column(name = "phone", nullable = false)
    open var phone: String? = null
}