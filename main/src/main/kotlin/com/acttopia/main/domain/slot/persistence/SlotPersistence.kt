package com.acttopia.main.domain.slot.persistence

import com.acttopia.main.domain.slot.model.Slot
import com.acttopia.main.domain.slot.persistence.entity.SlotEntity
import com.acttopia.main.domain.slot.persistence.repository.SlotRepository
import org.springframework.data.repository.findByIdOrNull
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

    fun update(newSlot: Slot): Slot? {
        val slot = slotRepository.findByIdOrNull(newSlot.id!!) ?: return null

        slot.mainKeyword = newSlot.mainKeyword
        slot.subKeyword = newSlot.subKeyword
        slot.midValue = newSlot.midValue

        return slot.toDomain()
    }

    fun list(userId: Long): List<Slot> {
        return slotRepository.findAllByUserIdOrderByUpdatedAtAsc(userId).map {
            it.toDomain()
        }
    }

    fun delete(slotId: Long): String? {
        val slot = slotRepository.findByIdOrNull(slotId) ?: return null

        slotRepository.delete(slot)
        return "success"
    }
}