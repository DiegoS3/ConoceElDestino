package com.diego.conoceeldestino.service.impl

import com.diego.conoceeldestino.dto.HorarioResponseDTO
import com.diego.conoceeldestino.entity.Horario
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.repository.HorarioRepository
import com.diego.conoceeldestino.service.HorarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HorarioServiceImpl: HorarioService {

    @Autowired
    private lateinit var horarioRepository: HorarioRepository

    override fun findHorarioById(id: Int): HorarioResponseDTO? {
        return try {
            horarioRepository.findById(id).map {
                return@map HorarioResponseDTO(
                    it.id,
                    it.inviernoFechaInit!!.month.name,
                    it.inviernoFechaEnd!!.month.name,
                    it.inviernoHoraInit,
                    it.inviernoHoraEnd,
                    it.veranoFechaInit!!.month.name,
                    it.veranoFechaEnd!!.month.name,
                    it.veranoHoraInit,
                    it.veranoHoraEnd
                )
            }.orElseGet {
                throw ConoceElDestinoException()
            }
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }


}