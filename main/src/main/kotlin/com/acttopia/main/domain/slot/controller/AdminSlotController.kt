package com.acttopia.main.domain.slot.controller

import com.acttopia.main.domain.slot.controller.response.SlotInfoResponse
import com.acttopia.main.domain.slot.service.CommandSlotService
import com.acttopia.main.domain.slot.service.QuerySlotService
import com.acttopia.main.global.common.basic.response.BasicResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/slot")
class AdminSlotController(
    private val commandSlotService: CommandSlotService,
    private val querySlotService: QuerySlotService
) {

    @DeleteMapping("/delete/{slotId}")
    fun deleteSlot(
        @PathVariable slotId: Long
    ): ResponseEntity<BasicResponse.BaseResponse> {
        commandSlotService.deleteSlot(slotId)

        return BasicResponse.ok("슬롯을 삭제하였습니다.")
    }

    @GetMapping("/{userId}/list")
    fun getUsersSlots(
        @PathVariable userId: Long
    ): ResponseEntity<BasicResponse.BaseResponse> {
        val slots = querySlotService.mySlots(userId)

        val response = slots.map {
            SlotInfoResponse(
                slotId = it.id!!,
                midValue = it.midValue!!,
                subKeyword = it.subKeyword!!,
                mainKeyword = it.mainKeyword!!
            )
        }

        return BasicResponse.ok(response)
    }
}