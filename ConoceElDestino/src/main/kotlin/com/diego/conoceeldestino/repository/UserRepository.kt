package com.diego.conoceeldestino.repository;

import com.diego.conoceeldestino.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, UUID> {

    fun findByUsernameEquals(username: String): Optional<User>

    fun existsByUsernameAndEmail(username: String, email: String): Boolean

    fun existsByUsername(username: String): Boolean

    fun findByUsername(username: String): Optional<User>

}