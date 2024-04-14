package com.acttopia.main.domain.slot.service

import com.acttopia.main.domain.slot.model.Slot
import com.acttopia.main.domain.slot.persistence.SlotPersistence
import com.acttopia.main.global.annotation.ReadOnlyService

@ReadOnlyService
class QuerySlotService(
    private val slotPersistence: SlotPersistence
) {
    fun mySlots(userId: Long): List<Slot> {
        return slotPersistence.list(userId)
    }
}