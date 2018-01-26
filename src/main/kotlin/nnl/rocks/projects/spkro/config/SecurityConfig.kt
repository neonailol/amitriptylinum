package nnl.rocks.projects.spkro.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer

@Configuration
@EnableResourceServer
class ResourceServerConfig

@Configuration
@EnableAuthorizationServer
class OAuth2Config(
    private val userDetailsService: UserDetailsService,
    private val authenticationManager: AuthenticationManager
) : AuthorizationServerConfigurerAdapter() {

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        endpoints.authenticationManager(authenticationManager)
        endpoints.userDetailsService(userDetailsService)
    }

    override fun configure(clients: ClientDetailsServiceConfigurer) {
        clients
            .inMemory().withClient("petclinic").secret("secret")
            .scopes("read", "write")
            .authorizedGrantTypes("password", "refresh_token")
            .resourceIds("resource")
    }
}
