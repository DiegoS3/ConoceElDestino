package com.diego.conoceeldestino.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "role")
open class Role {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "role_name")
    open var roleName: String? = null

    @Column(name = "role_description")
    open var roleDescription: String? = null
}