package com.diego.conoceeldestino.service

import com.diego.conoceeldestino.dto.HorarioResponseDTO

interface HorarioService {
    fun findHorarioById(id: Int): HorarioResponseDTO?
}