package com.acttopia.main.domain.slot.controller

import com.acttopia.main.domain.slot.service.CommandSlotService
import com.acttopia.main.global.common.basic.response.BasicResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/slot")
class AdminSlotController(
    private val commandSlotService: CommandSlotService
) {

    @DeleteMapping("/delete/{slotId}")
    fun deleteSlot(
        @PathVariable slotId: Long
    ): ResponseEntity<BasicResponse.BaseResponse> {
        commandSlotService.deleteSlot(slotId)

        return BasicResponse.ok("슬롯을 삭제하였습니다.")
    }
}