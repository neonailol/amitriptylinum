package nnl.rocks.projects.spkro.visits

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import nnl.rocks.projects.spkro.core.PageInfo
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

    @ApiModelProperty("Name", required = true)
    val name: String
)

fun VisitEntity.toVisitVM(): VisitVM = VisitVM(id = id, name = name)
