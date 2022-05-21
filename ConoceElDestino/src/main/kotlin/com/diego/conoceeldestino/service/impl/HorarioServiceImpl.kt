package com.diego.conoceeldestino.service.impl

import com.diego.conoceeldestino.entity.Horario
import com.diego.conoceeldestino.repository.HorarioRepository
import com.diego.conoceeldestino.service.HorarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HorarioServiceImpl: HorarioService {

    @Autowired
    private lateinit var horarioRepository: HorarioRepository

    override fun findHorarioById(id: Int): Horario {
        TODO("Not yet implemented")
    }


}