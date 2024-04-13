package com.acttopia.main.domain.user.controller

import com.acttopia.main.domain.user.controller.response.UserInfoResponse
import com.acttopia.main.domain.user.service.QueryUserService
import com.acttopia.main.global.common.basic.response.BasicResponse
import com.acttopia.main.global.security.principal.PrincipalDetails
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val queryUserService: QueryUserService
) {

    @GetMapping("/info")
    fun userInfo(
        @AuthenticationPrincipal principalDetails: PrincipalDetails
    ): ResponseEntity<BasicResponse.BaseResponse> {
        val info = queryUserService.getInfo(principalDetails.username!!.toLong())

        val responseDto = UserInfoResponse(
            id = info.id!!,
            loginId = info.loginId!!,
            slotCount = info.slotCount!!
        )

        return BasicResponse.ok(responseDto)
    }
}