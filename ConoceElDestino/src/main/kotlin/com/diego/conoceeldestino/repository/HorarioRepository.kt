package com.diego.conoceeldestino.repository;

import com.diego.conoceeldestino.entity.Horario
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HorarioRepository : CrudRepository<Horario, Int> {
}