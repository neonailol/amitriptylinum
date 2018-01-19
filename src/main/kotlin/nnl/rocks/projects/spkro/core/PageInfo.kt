package nnl.rocks.projects.spkro.core

import org.springframework.data.domain.Page

data class PageInfo(
    var page: Int,
    var pageSize: Int,
    var elementsCount: Int,
    var totalElements: Long,
    var totalPages: Int
)

fun Page<*>.toPageInfo(): PageInfo {
    with(this) {
        return PageInfo(
            page = number,
            pageSize = size,
            elementsCount = numberOfElements,
            totalElements = totalElements,
            totalPages = totalPages
        )
    }
}
