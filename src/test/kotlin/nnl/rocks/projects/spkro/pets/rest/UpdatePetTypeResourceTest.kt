package nnl.rocks.projects.spkro.pets.rest

import nnl.rocks.projects.spkro.ApplicationTest
import nnl.rocks.projects.spkro.api.UpdatePetTypeRB
import nnl.rocks.projects.spkro.pets.PetTypeEntity
import org.junit.Test
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.UUID

class UpdatePetTypeResourceTest : ApplicationTest() {

    @Test
    fun `can update existing pet type`() {
        val petTypeId = UUID.randomUUID()
        val petTypeName = "UpdatePetTypeResourceTest"

        petTypeEntityRepository.save(PetTypeEntity(petTypeId, petTypeName))

        mockMvc.perform(
            petsApi.updatePetType(petTypeId, UpdatePetTypeRB(petTypeName))
        ).andExpect(
            MockMvcResultMatchers.status().isNoContent
        )
    }
}
