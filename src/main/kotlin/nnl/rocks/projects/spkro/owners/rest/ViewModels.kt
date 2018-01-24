package nnl.rocks.projects.spkro.owners

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import nnl.rocks.projects.spkro.core.PageInfo
import java.util.UUID

@ApiModel(description = "Page of owners")
class OwnersVM(

    @ApiModelProperty("Pageable info", required = true)
    val pageInfo: PageInfo,

    @ApiModelProperty("Content", required = true)
    val elements: List<OwnerVM>
)

@ApiModel(description = "Owner")
class OwnerVM(

    @ApiModelProperty("Id", required = true)
    val id: UUID,

    @ApiModelProperty("Name", required = true)
    val name: String
)

fun OwnerEntity.toOwnerVM(): OwnerVM = OwnerVM(id = id, name = name)
