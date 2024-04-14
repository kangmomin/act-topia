package com.acttopia.main.domain.slot.controller

import com.acttopia.main.domain.slot.controller.request.AddSlotRequest
import com.acttopia.main.domain.slot.controller.request.UpdateSlotRequest
import com.acttopia.main.domain.slot.controller.response.SlotInfoResponse
import com.acttopia.main.domain.slot.model.Slot
import com.acttopia.main.domain.slot.service.CommandSlotService
import com.acttopia.main.domain.slot.service.QuerySlotService
import com.acttopia.main.global.common.basic.response.BasicResponse
import com.acttopia.main.global.security.principal.PrincipalDetails
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
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

    @PatchMapping("/update")
    fun updateSlot(
        @RequestBody @Valid updateSlotRequest: UpdateSlotRequest,
        @AuthenticationPrincipal principalDetails: PrincipalDetails
    ): ResponseEntity<BasicResponse.BaseResponse> {
        val newSlot = Slot(
            id = updateSlotRequest.slotId,
            userId = principalDetails.user.id,
            subKeyword = updateSlotRequest.subKeyword,
            mainKeyword = updateSlotRequest.mainKeyword,
            midValue = updateSlotRequest.midValue
        )

        commandSlotService.updateSlot(newSlot)

        return BasicResponse.ok("슬롯을 업데이트 하였습니다.")
    }

    @GetMapping("/list")
    fun mySlots(
        @AuthenticationPrincipal principalDetails: PrincipalDetails
    ): ResponseEntity<BasicResponse.BaseResponse> {
        val mySlots = querySlotService.mySlots(principalDetails.user.id!!)

        val response = mySlots.map {
            SlotInfoResponse(
                slotId = it.id!!,
                mainKeyword = it.mainKeyword!!,
                subKeyword = it.subKeyword!!,
                midValue = it.midValue!!,
            )
        }
        return BasicResponse.ok(response)
    }
}