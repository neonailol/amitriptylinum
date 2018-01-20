package nnl.rocks.projects.spkro.pets.rest

import nnl.rocks.projects.spkro.ApplicationTest
import nnl.rocks.projects.spkro.exists
import org.junit.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

class CreatePetTypeResourceTest : ApplicationTest() {

    @Test
    fun `can create new pet type`() {

        mockMvc.perform(
            MockMvcRequestBuilders
                .post("/api/v1/pets/types")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{\"name\":\"Name\"}")
        ).andExpect(
            MockMvcResultMatchers.status().isCreated
        ).andExpect(
            MockMvcResultMatchers.header().exists("location")
        ).andDo {
            val id = it.response.getHeaderValue("location")
            mockMvc.perform(
                MockMvcRequestBuilders
                    .get("/api/v1/pets/types/$id")
                    .accept(MediaType.APPLICATION_JSON_VALUE)
            ).andExpect(
                MockMvcResultMatchers.status().isOk
            ).andExpect(
                MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8")
            ).andExpect(
                MockMvcResultMatchers.jsonPath("$.id").value(id)
            ).andExpect(
                MockMvcResultMatchers.jsonPath("$.name").value("Name")
            )
        }
    }
}
