package com.diego.conoceeldestino.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "horario")
open class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhorario", nullable = false)
    open var id: Int? = null

    @Column(name = "invierno_fecha_init")
    open var inviernoFechaInit: LocalDate? = null

    @Column(name = "invierno_fecha_end")
    open var inviernoFechaEnd: LocalDate? = null

    @Column(name = "invierno_hora_init", length = 45)
    open var inviernoHoraInit: String? = null

    @Column(name = "invierno_hora_end", length = 45)
    open var inviernoHoraEnd: String? = null

    @Column(name = "verano_fecha_init")
    open var veranoFechaInit: LocalDate? = null

    @Column(name = "verano_fecha_end")
    open var veranoFechaEnd: LocalDate? = null

    @Column(name = "verano_hora_init", length = 45)
    open var veranoHoraInit: String? = null

    @Column(name = "verano_hora_end", length = 45)
    open var veranoHoraEnd: String? = null

}