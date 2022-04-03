package com.diego.conoceeldestino.entity

import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Index
import javax.persistence.Table

@Entity
@Table(
    name = "user_role", indexes = [
        Index(name = "role_id", columnList = "role_id"),
        Index(name = "user_id", columnList = "user_id")
    ]
)
open class UserRole {
    @EmbeddedId
    open var id: UserRoleId? = null
}