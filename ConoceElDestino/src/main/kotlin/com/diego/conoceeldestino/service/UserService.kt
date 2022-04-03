package com.diego.conoceeldestino.service

import com.diego.conoceeldestino.entity.User
import com.diego.conoceeldestino.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    fun insertUser(user: User) = userRepository.save(user)

    fun updateUser(user: User) = userRepository.save(user)

    fun findById(id : UUID): Optional<User> = userRepository.findById(id)

    fun findByUsernameEquals(username: String): Optional<User> = userRepository.findByUsernameEquals(username)

    fun findByUsername(username: String): Optional<User> = userRepository.findByUsername(username)

    fun existsByUsername(username: String): Boolean = userRepository.existsByUsername(username)

    fun findAllUser(): List<User> = userRepository.findAll()

    fun existsByUsernameAndEmail(username: String, email: String): Boolean = userRepository.existsByUsernameAndEmail(username, email)

}