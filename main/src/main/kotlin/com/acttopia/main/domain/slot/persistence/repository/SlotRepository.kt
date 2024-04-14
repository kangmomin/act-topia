package com.acttopia.main.domain.slot.persistence.repository

import com.acttopia.main.domain.slot.persistence.entity.SlotEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SlotRepository: JpaRepository<SlotEntity, Long> {
    fun countSlotEntityByUserId(userId: Long): Long
}