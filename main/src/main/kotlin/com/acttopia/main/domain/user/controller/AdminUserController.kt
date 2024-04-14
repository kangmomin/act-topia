package com.acttopia.main.domain.user.controller

import com.acttopia.main.domain.user.controller.request.JoinRequest
import com.acttopia.main.domain.user.controller.request.SlotUpdateRequest
import com.acttopia.main.domain.user.controller.response.UserIdResponse
import com.acttopia.main.domain.user.controller.response.UserInfoResponse
import com.acttopia.main.domain.user.model.User
import com.acttopia.main.domain.user.service.CommandUserService
import com.acttopia.main.domain.user.service.QueryUserService
import com.acttopia.main.global.annotation.CommandService
import com.acttopia.main.global.common.basic.response.BasicResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/user")
class AdminUserController(
    private val commandUserService: CommandUserService,
    private val queryUserService: QueryUserService,
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

    @GetMapping("/list")
    fun userList(): ResponseEntity<BasicResponse.BaseResponse> {
        val userList = queryUserService.getList()

        val response = userList.map {
            UserInfoResponse(
                id = it.id!!,
                slotCount = it.slotCount!!,
                loginId = it.loginId!!
            )
        }

        return BasicResponse.ok(response)
    }

    @PatchMapping("/slot")
    fun userSlotUpdate(
        @RequestBody @Valid slotUpdateRequest: SlotUpdateRequest
    ): ResponseEntity<BasicResponse.BaseResponse> {
        commandUserService.updateSlot(slotUpdateRequest.slot!!, slotUpdateRequest.userId!!)

        return BasicResponse.ok("슬롯의 갯수를 수정하였습니다.")
    }
}