package nnl.rocks.projects.spkro

import nnl.rocks.projects.spkro.api.PetsApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TestBeans {

    @Bean
    fun petsApi(): PetsApi {
        return PetsApi()
    }

}
