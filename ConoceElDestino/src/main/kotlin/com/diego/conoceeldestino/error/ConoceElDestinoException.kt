package com.diego.conoceeldestino.error

import com.diego.conoceeldestino.utils.Constants

class ConoceElDestinoException : Exception {

    /** The custom message.  */
    private var customMessage: String? = null

    /** The id.  */
    private var id: String? = null

    /** The error code.  */
    private var errorCode: String? = null

    /**
     * Gets the custom message.
     *
     * @return the custom message
     */
    fun getCustomMessage(): String {
        val builder = StringBuilder()
        builder.append(if (customMessage != null) customMessage else Constants.ERROR_GENERAL)
        builder.append(" ")
        builder.append(" Id -> ")
        builder.append("(")
        builder.append(id)
        builder.append(")")
        return builder.toString()
    }

    /**
     * Sets the custom message.
     *
     * @param customMessage the new custom message
     */
    fun setCustomMessage(customMessage: String?) {
        this.customMessage = customMessage ?: Constants.ERROR_GENERAL
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    fun setId(id: String?) {
        this.id = id
    }

    /**
     * Gets the error code.
     *
     * @return the error code
     */
    fun getErrorCode(): String? {
        return errorCode
    }

    /**
     * Sets the error code.
     *
     * @param errorCode the new error code
     */
    fun setErrorCode(errorCode: String?) {
        this.errorCode = errorCode
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    fun getId(): String? {
        return id
    }

    /**
     * Instantiates a new people plus exception.
     *
     * @param message the message
     */
    constructor(message: String?) :super(message ?: Constants.ERROR_GENERAL)

    /**
     * Instantiates a new people plus exception.
     *
     * @param message the message
     * @param cause the cause
     */
    constructor(message: String?, cause: Throwable?) : super(message ?: Constants.ERROR_GENERAL, cause)

    /**
     * Instantiates a new people plus exception.
     *
     * @param message the message
     * @param customMessage the custom message
     * @param id the id
     * @param errorCode the error code
     */
    constructor(message: String?, customMessage: String?, id: String?, errorCode: String?): this(message) {
        setCustomMessage(customMessage ?: Constants.ERROR_GENERAL)
        setId(id)
        setErrorCode(errorCode)
    }

    /**
     * Instantiates a new people plus exception.
     *
     * @param message the message
     * @param cause the cause
     * @param customMessage the custom message
     * @param id the id
     * @param errorCode the error code
     */
    constructor(
        message: String?,
        cause: Throwable?,
        customMessage: String?,
        id: String?,
        errorCode: String?
    ) : this(message, cause) {
        setCustomMessage(customMessage ?: Constants.ERROR_GENERAL)
        setId(id)
        setErrorCode(errorCode)
    }

    constructor()

    /**
     * Gets the log trace.
     *
     * @return the log trace
     */
    fun getLogTrace(): String {
        return ". Exception message -> $message"
    }
}