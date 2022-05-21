package com.diego.conoceeldestino.repository;

import com.diego.conoceeldestino.entity.Horario
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface HorarioRepository : CrudRepository<Horario, Int> {

    @Query(
        """select (count(h) > 0) from Horario h
where h.inviernoFechaInit = ?1 and h.inviernoFechaEnd = ?2 and h.inviernoHoraInit = ?3 and h.inviernoHoraEnd = ?4 and h.veranoFechaInit = ?5 and h.veranoFechaEnd = ?6 and h.veranoHoraInit = ?7 and h.veranoHoraEnd = ?8"""
    )
    fun isSameHorario(
        inviernoFechaInit: LocalDate,
        inviernoFechaEnd: LocalDate,
        inviernoHoraInit: String,
        inviernoHoraEnd: String,
        veranoFechaInit: LocalDate,
        veranoFechaEnd: LocalDate,
        veranoHoraInit: String,
        veranoHoraEnd: String
    ): Boolean

}