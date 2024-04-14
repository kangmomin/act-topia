package com.acttopia.main.domain.slot.persistence

import com.acttopia.main.domain.slot.model.Slot
import com.acttopia.main.domain.slot.persistence.entity.SlotEntity
import com.acttopia.main.domain.slot.persistence.repository.SlotRepository
import org.springframework.stereotype.Component

@Component
class SlotPersistence(
    private val slotRepository: SlotRepository
) {
    /**
     * validation 할게 없어서 일단은 비워둠
     */
    fun valid(newSlot: Slot): Boolean = true
    fun create(slot: SlotEntity): Long? {
        return slotRepository.save(slot).id
    }

    fun slotCount(userId: Long) =
        slotRepository.countSlotEntityByUserId(userId)
}