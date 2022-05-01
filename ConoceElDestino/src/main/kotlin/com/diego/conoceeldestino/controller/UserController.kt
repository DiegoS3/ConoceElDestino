package com.diego.conoceeldestino.controller

import com.diego.conoceeldestino.entity.User
import com.diego.conoceeldestino.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/rest/api/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

//    @GetMapping
//    fun findAllUsers() : ResponseEntity<Any>{
//        return try {
//            val listUsers = userService.findAllUser()
//            ResponseEntity(listUsers, HttpStatus.CREATED)
//        } catch (e: Exception) {
//            ResponseEntity<Any>(null, HttpStatus.INTERNAL_SERVER_ERROR)
//        }
//    }
//
//    @GetMapping("/{username}")
//    fun findUserByUsername(@PathVariable("username") username: String) : ResponseEntity<Any> {
//
//        val userExist = userService.existsByUsername(username)
//        val userData : Optional<User>?
//        println(userExist)
//        return if (userExist){
//            userData = userService.findByUsername(username)
//            ResponseEntity(userData.get(), HttpStatus.OK)
//        } else
//            ResponseEntity(HttpStatus.NOT_FOUND)
//    }
//
//    @PostMapping
//    fun insertUser(@RequestBody user: User): ResponseEntity<Any> {
//        println(UUID.randomUUID())
//        return try {
//            val newUser: User = userService.insertUser(user)
//            println(newUser.id)
//            ResponseEntity(newUser, HttpStatus.CREATED)
//        } catch (e: Exception) {
//            println(e.printStackTrace())
//            ResponseEntity<Any>(null, HttpStatus.INTERNAL_SERVER_ERROR)
//        }
//    }
//
//    @PutMapping("/{id}")
//    fun updateUser(@PathVariable("id") id : UUID, @RequestBody user: User): ResponseEntity<Any> {
//        val userData = userService.findById(id)
//        return if (userData.isPresent){
//            ResponseEntity(userService.updateUser(user), HttpStatus.OK)
//        } else
//            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
//    }

}