package nnl.rocks.projects.spkro.pets

data class CreatePetTypeCommand(
    val name: String
)

data class UpdatePetTypeCommand(
    val name: String
)

data class CreatePetCommand(
    val name: String
)

data class UpdatePetCommand(
    val name: String
)
