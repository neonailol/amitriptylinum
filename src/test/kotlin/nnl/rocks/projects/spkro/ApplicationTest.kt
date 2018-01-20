package nnl.rocks.projects.spkro

import nnl.rocks.projects.spkro.pets.PetTypeEntity
import nnl.rocks.projects.spkro.pets.PetTypeEntityRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.util.AssertionErrors.assertTrue
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.result.HeaderResultMatchers
import java.util.UUID

@RunWith(SpringRunner::class)
@AutoConfigureMockMvc
@SpringBootTest(classes = [Application::class])
class ApplicationTest {

    @Autowired
    internal lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var petTypeEntityRepository: PetTypeEntityRepository

    @Test
    fun contextLoads() {
    }

    @Before
    fun init() {
        petTypeEntityRepository.deleteAll()
        petTypeEntityRepository.save(PetTypeEntity(UUID.randomUUID(), "Type1"))
        petTypeEntityRepository.save(PetTypeEntity(UUID.randomUUID(), "Type2"))
        petTypeEntityRepository.save(PetTypeEntity(UUID.randomUUID(), "Type3"))
    }
}

fun HeaderResultMatchers.exists(name: String): ResultMatcher {
    return ResultMatcher { result ->
        assertTrue(
            "Response should not header '$name'",
            result.response.containsHeader(name)
        )
    }
}
