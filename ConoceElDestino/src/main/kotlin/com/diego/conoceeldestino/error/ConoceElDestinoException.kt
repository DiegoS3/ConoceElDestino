package com.diego.conoceeldestino.error

class ConoceElDestinoException() : RuntimeException() {

    constructor(type: Any, id: Long) : this() {
        throw RuntimeException("${type.javaClass.name} id not found : $id")
    }

    constructor(type: Any, name: String) : this() {
        throw RuntimeException("$type name not found : $name")
    }
}