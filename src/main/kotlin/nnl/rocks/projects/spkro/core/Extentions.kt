package nnl.rocks.projects.spkro.core

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpHeaders.LOCATION
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.UUID

fun <T> responseEntityCreated(id: UUID): ResponseEntity<T> {
    val headers = HttpHeaders()
    headers.set(LOCATION, id.toString())
    return ResponseEntity(headers, HttpStatus.CREATED)
}
