package com.diego.conoceeldestino.repository;

import com.diego.conoceeldestino.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByUsernameEquals(username: String): User

    fun existsByUsernameAndEmail(username: String, email: String): Boolean

}