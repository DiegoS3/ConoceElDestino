package com.diego.conoceeldestino.error

import org.hibernate.exception.ConstraintViolationException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.io.IOException
import java.util.*
import java.util.stream.Collectors
import javax.servlet.http.HttpServletResponse
import kotlin.collections.LinkedHashMap


@ControllerAdvice
class CustomGlobalExceptionHandler: ResponseEntityExceptionHandler() {

    // Let Spring BasicErrorController handle the exception, we just override the status code
    @ExceptionHandler(ConoceElDestinoException::class)
    @Throws(IOException::class)
    fun springHandleNotFound(response: HttpServletResponse) {
        response.sendError(HttpStatus.NOT_FOUND.value())
    }

    @ExceptionHandler(ConoceElDestinoUnSupportedFieldPatchException::class)
    @Throws(
        IOException::class
    )
    fun springUnSupportedFieldPatch(response: HttpServletResponse) {
        response.sendError(HttpStatus.METHOD_NOT_ALLOWED.value())
    }

    // @Validate For Validating Path Variables and Request Parameters
    @ExceptionHandler(ConstraintViolationException::class)
    @Throws(IOException::class)
    fun constraintViolationException(response: HttpServletResponse) {
        response.sendError(HttpStatus.BAD_REQUEST.value())
    }

    // error handle for @Valid
    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val body: MutableMap<String, Any> = LinkedHashMap()
        body["timestamp"] = Date()
        body["status"] = status.value()

        //Get all errors
        val errors = ex.bindingResult
            .fieldErrors
            .stream()
            .map { x: FieldError -> x.defaultMessage }
            .collect(Collectors.toList())
        body["errors"] = errors
        return ResponseEntity(body, headers, status)

        //Map<String, String> fieldErrors = ex.getBindingResult().getFieldErrors().stream().collect(
        //        Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }

}