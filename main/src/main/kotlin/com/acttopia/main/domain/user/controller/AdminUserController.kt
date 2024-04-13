package com.acttopia.main.domain.user.controller

import com.acttopia.main.domain.user.controller.request.JoinRequest
import com.acttopia.main.domain.user.controller.response.UserIdResponse
import com.acttopia.main.domain.user.model.User
import com.acttopia.main.domain.user.service.CommandUserService
import com.acttopia.main.global.annotation.CommandService
import com.acttopia.main.global.common.basic.response.BasicResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/user")
class AdminUserController(
    private val commandUserService: CommandUserService
) {

    @PostMapping("/join")
    fun join(
        @RequestBody @Valid joinRequest: JoinRequest
    ): ResponseEntity<BasicResponse.BaseResponse> {
        val user = User(
            id = null,
            loginId = joinRequest.loginId,
            slotCount = joinRequest.slotCount ?: 0,
            password = null,
            role = null,
        )

        val userId = commandUserService.saveUser(user, joinRequest.password!!)

        return BasicResponse.ok(
            UserIdResponse(userId))
    }
}