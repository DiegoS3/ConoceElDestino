package com.diego.conoceeldestino.dto

import java.io.Serializable

data class RoleDto(val id: Long? = null, val roleName: String? = null, val roleDescription: String? = null) :
    Serializable
