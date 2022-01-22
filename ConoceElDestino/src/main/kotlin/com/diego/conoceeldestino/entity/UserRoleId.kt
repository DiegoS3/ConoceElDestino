package com.diego.conoceeldestino.entity

import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Entity

@Embeddable
open class UserRoleId : Serializable {
    @Column(name = "role_id")
    open var roleId: Long? = null

    @Column(name = "user_id")
    open var userId: Long? = null

    override fun hashCode(): Int = Objects.hash(roleId, userId)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as UserRoleId

        return roleId == other.roleId &&
                userId == other.userId
    }

    companion object {
        private const val serialVersionUID = 6689762328316317036L
    }
}