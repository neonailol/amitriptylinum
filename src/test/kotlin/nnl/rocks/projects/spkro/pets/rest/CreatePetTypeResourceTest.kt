package nnl.rocks.projects.spkro.pets.rest

import nnl.rocks.projects.spkro.ApplicationTest
import nnl.rocks.projects.spkro.andExpect
import nnl.rocks.projects.spkro.api.CreatePetTypeRB
import nnl.rocks.projects.spkro.exists
import org.junit.Test
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class CreatePetTypeResourceTest : ApplicationTest() {

    @Test
    fun `can create new pet type`() {

        mockMvc.perform(
            petsApi.createPetType(CreatePetTypeRB("Name"))
        ).andExpect(
            status().isCreated,
            header().exists("location")
        ).andDo {
            val id = it.response.getHeaderValue("location")
            mockMvc.perform(
                petsApi.getPetType(id)
            ).andExpect(
                status().isOk,
                content().contentType("application/json;charset=UTF-8"),
                jsonPath("$.id").value(id),
                jsonPath("$.name").value("Name")
            )
        }
    }
}
