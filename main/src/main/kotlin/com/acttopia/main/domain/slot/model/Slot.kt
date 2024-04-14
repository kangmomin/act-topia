package com.acttopia.main.domain.slot.model

import com.acttopia.main.domain.slot.persistence.entity.SlotEntity
import com.acttopia.main.global.common.basic.model.BasicModelConverter
import com.acttopia.main.global.common.basic.model.BasicTime

class Slot (
    var id: Long?,
    var mainKeyword: String?,
    var subKeyword: String?,
    var midValue: Long?,
    var userId: Long?
): BasicTime(), BasicModelConverter<Slot, SlotEntity> {
    override fun toEntity() =
        SlotEntity(
            id = this.id,
            mainKeyword = this.mainKeyword,
            subKeyword = this.subKeyword,
            midValue = this.midValue,
            userId = this.userId,
        ).let {
            it.createdAt = this.createdAt
            it.updatedAt = this.updatedAt
            it
        }
}