package com.diego.conoceeldestino.service

import com.diego.conoceeldestino.dto.HorarioRequestDTO
import com.diego.conoceeldestino.dto.HorarioResponseDTO
import com.diego.conoceeldestino.entity.Horario

interface HorarioService {
    fun findHorarioById(id: Int): HorarioResponseDTO?
    fun findAllHorario(): List<HorarioResponseDTO>
    fun updateHorario(horarioRequestDTO: HorarioRequestDTO): Horario?
    fun createHorario(horarioRequestDTO: HorarioRequestDTO): Horario?
}