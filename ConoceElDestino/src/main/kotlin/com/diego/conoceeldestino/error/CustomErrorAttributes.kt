package com.diego.conoceeldestino.error

import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes
import org.springframework.web.context.request.WebRequest
import org.springframework.boot.web.error.ErrorAttributeOptions.Include
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class CustomErrorAttributes: DefaultErrorAttributes() {

    private val dateFormat: DateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
    private val includeException: Boolean? = null

    override fun getErrorAttributes(webRequest: WebRequest?, includeStackTrace: ErrorAttributeOptions): Map<String, Any>? {

        var includeStackTrace = includeStackTrace
        // Let Spring handle the error first, we will modify later :)
        val errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace)

        // format & update timestamp
        val timestamp = errorAttributes["timestamp"]
        if (timestamp == null) {
            errorAttributes["timestamp"] = dateFormat.format(Date())
        } else {
            errorAttributes["timestamp"] = dateFormat.format(timestamp as Date?)
        }

        if (this.includeException != null) {
            includeStackTrace = includeStackTrace.including(Include.EXCEPTION)
        }
        if (!includeStackTrace.isIncluded(Include.EXCEPTION)) {
            errorAttributes.remove("exception")
        }
        if (!includeStackTrace.isIncluded(Include.STACK_TRACE)) {
            errorAttributes.remove("trace")
        }
        if (!includeStackTrace.isIncluded(Include.MESSAGE) && errorAttributes["message"] != null) {
            errorAttributes["message"] = ""
        }
        if (!includeStackTrace.isIncluded(Include.BINDING_ERRORS)) {
            errorAttributes.remove("errors")
        }

        // insert a new key
        errorAttributes["version"] = "1.2"
        return errorAttributes
    }

}