package com.acttopia.main.global.security

import com.acttopia.main.domain.user.model.constant.UserRole
import com.acttopia.main.global.security.filter.ExceptionFilter
import com.acttopia.main.global.security.jwt.JwtAuthFilter
import com.acttopia.main.global.security.handler.CustomAccessDeniedHandler
import com.acttopia.main.global.security.handler.CustomAuthenticationEntryPoint
import com.acttopia.main.global.security.jwt.JwtParser
import com.acttopia.main.global.security.principal.PrincipalDetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.core.GrantedAuthorityDefaults
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.web.cors.CorsUtils

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtParser: JwtParser,
    private val principalDetailsService: PrincipalDetailsService,
    private val exceptionFilter: ExceptionFilter
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.httpBasic { it.disable() }
            .cors {}
            .csrf { it.disable() }
            .authorizeHttpRequests {
                it.requestMatchers(RequestMatcher { req ->
                    CorsUtils.isPreFlightRequest(req)
                }).permitAll()

                it.requestMatchers("/user/login", "/user/join", "/master/c/*").permitAll()
                    .requestMatchers("/admin/**").hasRole(UserRole.ADMIN.toString())
                    .anyRequest().authenticated()
            }
            .formLogin { it.disable() }
            .exceptionHandling {
                it.authenticationEntryPoint(CustomAuthenticationEntryPoint())
                    .accessDeniedHandler(CustomAccessDeniedHandler())
            }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .addFilterBefore(JwtAuthFilter(jwtParser, principalDetailsService), UsernamePasswordAuthenticationFilter::class.java)
            .addFilterBefore(exceptionFilter, JwtAuthFilter::class.java)

        return http.build()
    }

    @Bean
    fun grantedAuthorityDefaults(): GrantedAuthorityDefaults {
        return GrantedAuthorityDefaults("") // Remove the ROLE_ prefix
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}