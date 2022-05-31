package com.diego.conoceeldestino.service.impl

import com.diego.conoceeldestino.dto.HorarioRequestDTO
import com.diego.conoceeldestino.dto.HorarioResponseDTO
import com.diego.conoceeldestino.entity.Horario
import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.repository.HorarioRepository
import com.diego.conoceeldestino.service.HorarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class HorarioServiceImpl : HorarioService {

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

    override fun findAllHorario(): List<HorarioResponseDTO> {
        try {
            val horarioList = horarioRepository.findAll()
            val list = horarioList.map {
                HorarioResponseDTO(
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
            }
            return list
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun updateHorario(horarioRequestDTO: HorarioRequestDTO): Horario? {
        try {
            return horarioRepository.save(mapDtoToEntity(horarioRequestDTO))

        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }

    override fun createHorario(horarioRequestDTO: HorarioRequestDTO): Horario? {
        try {
            val exitsHorario = checkExistsHorario(horarioRequestDTO)
            return if (!exitsHorario) {
                horarioRepository.save(mapDtoToEntity(horarioRequestDTO))
            } else {
                throw ConoceElDestinoException("No se ha podido crear el horario porque ya existe")
            }
        } catch (e: Exception) {
            throw ConoceElDestinoException(e.message)
        }
    }


    private fun mapDtoToEntity(horarioRequestDTO: HorarioRequestDTO): Horario {
        val horario = Horario()
        horario.inviernoFechaInit =
            LocalDate.parse(horarioRequestDTO.inviernoFechaInit, DateTimeFormatter.BASIC_ISO_DATE)
        horario.inviernoFechaEnd = LocalDate.parse(horarioRequestDTO.inviernoFechaEnd, DateTimeFormatter.BASIC_ISO_DATE)
        horario.inviernoHoraInit = horarioRequestDTO.inviernoHoraInit!!
        horario.inviernoHoraEnd = horarioRequestDTO.inviernoHoraEnd!!
        horario.veranoFechaInit = LocalDate.parse(horarioRequestDTO.veranoFechaInit, DateTimeFormatter.BASIC_ISO_DATE)
        horario.veranoFechaEnd = LocalDate.parse(horarioRequestDTO.veranoFechaEnd, DateTimeFormatter.BASIC_ISO_DATE)
        horario.veranoHoraInit = horarioRequestDTO.veranoHoraInit!!
        horario.veranoHoraEnd = horarioRequestDTO.veranoHoraEnd!!

        return horario
    }

    private fun checkExistsHorario(horarioRequestDTO: HorarioRequestDTO): Boolean {
        return horarioRepository.isSameHorario(
            LocalDate.parse(horarioRequestDTO.inviernoFechaInit, DateTimeFormatter.BASIC_ISO_DATE),
            LocalDate.parse(horarioRequestDTO.inviernoFechaEnd, DateTimeFormatter.BASIC_ISO_DATE),
            horarioRequestDTO.inviernoHoraInit!!,
            horarioRequestDTO.inviernoHoraEnd!!,
            LocalDate.parse(horarioRequestDTO.veranoFechaInit, DateTimeFormatter.BASIC_ISO_DATE),
            LocalDate.parse(horarioRequestDTO.veranoFechaEnd, DateTimeFormatter.BASIC_ISO_DATE),
            horarioRequestDTO.veranoHoraInit!!,
            horarioRequestDTO.veranoHoraEnd!!,
        )
    }

}