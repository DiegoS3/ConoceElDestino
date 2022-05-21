package com.diego.conoceeldestino.service

import com.diego.conoceeldestino.entity.Horario

interface HorarioService {
    fun findHorarioById(id: Int): Horario
}