package com.diego.conoceeldestino.controller

import com.diego.conoceeldestino.error.ConoceElDestinoException
import com.diego.conoceeldestino.error.dto.ConoceElDestinoErrorDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Clase Base de la que deben extender los controladores REST.
 */
@Controller
@RequestMapping("/")
interface BaseController {

    /**
     * Handle people plus exception.
     *
     * @param ppe the ppe
     * @return the response entity
     */
    @ExceptionHandler(ConoceElDestinoException::class)
    fun handleConoceElDestinoException(cede: ConoceElDestinoException?): ResponseEntity<ConoceElDestinoErrorDTO?> {
        val peoplePlusError = ConoceElDestinoErrorDTO(cede!!)
        return ResponseEntity<ConoceElDestinoErrorDTO?>(peoplePlusError, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    /**
     * Handle access denied exception.
     *
     * @param ppe the ppe
     * @return the response entity
     */
    @ExceptionHandler(AccessDeniedException::class)
    fun handleAccessDeniedException(ade: AccessDeniedException): ResponseEntity<Any?> {
        val conoceElDestinoErrorDTO = ConoceElDestinoErrorDTO()
        conoceElDestinoErrorDTO.message = ade.message
        return ResponseEntity(conoceElDestinoErrorDTO, HttpStatus.FORBIDDEN)
    }

    /**
     * Handle exception.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<Any?> {
        val conoceElDestinoErrorDTO = ConoceElDestinoErrorDTO()
        conoceElDestinoErrorDTO.message = e.message
        return ResponseEntity(conoceElDestinoErrorDTO, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    companion object {
        // ************************************************************************
        // Constantes
        /** The Constant HEADERS_ACCEPT.  */ // HEADERS
        const val HEADERS_ACCEPT = "Accept=application/json"

        /** The Constant CONTENT_TYPE.  */
        const val CONTENT_TYPE = "Content-Type"

        /** The Constant APPLICATIONJSON_CHARSET.  */
        const val APPLICATIONJSON_CHARSET = "application/json; charset=utf-8"

        /** The Constant IMAGE.  */
        const val IMAGE = "image/jpeg; charset=utf-8"

        /** The Constant APPLICATIONPDF.  */
        const val APPLICATIONPDF = "application/pdf;"

        /** The Constant APPLICATIONXSLX.  */
        const val APPLICATIONXSLX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"

        /** The Constant APPLICATIONXLS.  */
        const val APPLICATIONXLS = "application/vnd.mx-excel"

        /** The Constant TEXTPLAIN.  */
        const val TEXTPLAIN = "text/plain"

        /** The Constant TEXTCALENDAR.  */
        const val TEXTCALENDAR = "text/calendar"

        /** The Constant MULTIPART.  */
        const val MULTIPART = "multipart/form-data"
    }
}