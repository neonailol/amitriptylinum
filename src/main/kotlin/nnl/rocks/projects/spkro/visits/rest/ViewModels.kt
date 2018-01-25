package nnl.rocks.projects.spkro.visits

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import nnl.rocks.projects.spkro.core.PageInfo
import java.time.LocalDateTime
import java.util.UUID

@ApiModel(description = "Page of visits")
class VisitsVM(

    @ApiModelProperty("Pageable info", required = true)
    val pageInfo: PageInfo,

    @ApiModelProperty("Content", required = true)
    val elements: List<VisitVM>
)

@ApiModel(description = "Visit")
class VisitVM(

    @ApiModelProperty("Id", required = true)
    val id: UUID,

    @ApiModelProperty("Date", required = true)
    val date: LocalDateTime
)

fun VisitEntity.toVisitVM(): VisitVM = VisitVM(id = id, date = date)
