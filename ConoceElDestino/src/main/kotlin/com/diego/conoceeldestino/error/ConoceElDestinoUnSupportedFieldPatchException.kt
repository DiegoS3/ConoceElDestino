package com.diego.conoceeldestino.error


class ConoceElDestinoUnSupportedFieldPatchException(keys: Set<String>): RuntimeException("Field $keys update is not allow.") {
}