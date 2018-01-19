package nnl.rocks.projects.spkro.pets

import nnl.rocks.projects.spkro.Application
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.web.PageableHandlerMethodArgumentResolver
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [Application::class])
class GetPetTypesResourceTest {

    @Autowired
    private lateinit var getPetTypesResource: GetPetTypesResource

    @Autowired
    private lateinit var pageableArgumentResolver: PageableHandlerMethodArgumentResolver

    private lateinit var mockMvc: MockMvc

    @Before
    fun init() {
        this.mockMvc =
            MockMvcBuilders
                .standaloneSetup(getPetTypesResource)
                .setCustomArgumentResolvers(pageableArgumentResolver)
                .build()
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
        )
    }
}
