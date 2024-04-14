package com.acttopia.main.domain.slot.controller

import com.acttopia.main.domain.slot.controller.request.AddSlotRequest
import com.acttopia.main.domain.slot.model.Slot
import com.acttopia.main.domain.slot.service.CommandSlotService
import com.acttopia.main.domain.slot.service.QuerySlotService
import com.acttopia.main.global.common.basic.response.BasicResponse
import com.acttopia.main.global.security.principal.PrincipalDetails
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/slot")
class SlotController(
    private val commandSlotService: CommandSlotService,
    private val querySlotService: QuerySlotService,
) {

    @PostMapping("/add")
    fun addSlot(
        @RequestBody @Valid addSlotRequest: AddSlotRequest,
        @AuthenticationPrincipal principalDetails: PrincipalDetails
    ): ResponseEntity<BasicResponse.BaseResponse> {
        val newSlot = Slot(
            id = null,
            mainKeyword = addSlotRequest.mainKeyword,
            subKeyword = addSlotRequest.subKeyword,
            midValue = addSlotRequest.midValue,
            userId = principalDetails.user.id,
        )

        commandSlotService.addSlot(
            newSlot,
            principalDetails.user.slotCount!!
        )

        return BasicResponse.ok("슬롯이 생성되었습니다.")
    }
}