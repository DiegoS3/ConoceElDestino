package com.diego.conoceeldestino.controller

import com.diego.conoceeldestino.dto.HorarioRequestDTO
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.service.impl.HorarioServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rest/api/horario")
class HorarioController {

    @Autowired
    private lateinit var horarioService: HorarioServiceImpl

    @GetMapping
    @Throws(ConoceElDestinoException::class)
    private fun getHorarioByID(
        @RequestParam(name = "name") name: Int
    ): ResponseEntity<Any> {
        val horario = horarioService.findHorarioById(name)
        return ResponseEntity.ok(horario)
    }

    @GetMapping("/search")
    @Throws(ConoceElDestinoException::class)
    private fun getHorarios(
    ): ResponseEntity<Any> {
        val horarioList = horarioService.findAllHorario()
        return ResponseEntity.ok(horarioList)
    }

    @PutMapping
    @Throws(ConoceElDestinoException::class)
    private fun putHorario(
        @RequestBody horarioRequestDTO: HorarioRequestDTO
    ): ResponseEntity<Any> {
        val updatedHorario = horarioService.updateHorario(horarioRequestDTO)
        return ResponseEntity.ok(updatedHorario)
    }

    @PostMapping
    @Throws(ConoceElDestinoException::class)
    private fun postHorario(
        @RequestBody horarioRequestDTO: HorarioRequestDTO
    ): ResponseEntity<Any> {
        val newHorario = horarioService.createHorario(horarioRequestDTO)
        return ResponseEntity.ok(newHorario)
    }
}