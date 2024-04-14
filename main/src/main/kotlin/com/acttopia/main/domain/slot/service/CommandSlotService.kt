package com.acttopia.main.domain.slot.service

import com.acttopia.main.domain.slot.exception.SlotConflictException
import com.acttopia.main.domain.slot.model.Slot
import com.acttopia.main.domain.slot.persistence.SlotPersistence
import com.acttopia.main.global.annotation.CommandService

@CommandService
class CommandSlotService(
    private val slotPersistence: SlotPersistence
) {
    fun addSlot(newSlot: Slot, slotCount: Long?): Long? {
        if (!slotPersistence.valid(newSlot)) throw SlotConflictException()

        return slotPersistence.create(newSlot.toEntity())
    }
}