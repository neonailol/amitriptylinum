package nnl.rocks.projects.spkro.pets

import nnl.rocks.projects.spkro.Application
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.UUID

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [Application::class])
@AutoConfigureMockMvc
class GetPetTypesResourceTest {

    @Autowired
    private lateinit var petTypeEntityRepository: PetTypeEntityRepository

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Before
    fun init() {
        petTypeEntityRepository.save(PetTypeEntity(UUID.randomUUID(), "Type1"))
        petTypeEntityRepository.save(PetTypeEntity(UUID.randomUUID(), "Type2"))
        petTypeEntityRepository.save(PetTypeEntity(UUID.randomUUID(), "Type3"))
    }

    @Test
    @Throws(Exception::class)
    fun testGetPetTypeSuccess() {
        this.mockMvc.perform(
            get("/api/v1/pets/types").accept(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(
            status().isOk
        ).andExpect(
            content().contentType("application/json;charset=UTF-8")
        ).andExpect(
            jsonPath("$.pageInfo.elementsCount").value(3)
        )
    }
}
