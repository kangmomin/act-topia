package com.acttopia.main.domain.slot.persistence.entity

import com.acttopia.main.domain.slot.model.Slot
import com.acttopia.main.global.common.basic.entity.BasicTimeEntity
import com.acttopia.main.global.common.basic.model.BasicEntityConverter
import jakarta.persistence.*

@Entity
@Table(name = "slot")
class SlotEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slotId")
    var id: Long?,

    @Column(nullable = false)
    var mainKeyword: String?,

    @Column(nullable = false)
    var subKeyword: String?,

    @Column(nullable = false)
    var midValue: Long?,

    @Column(nullable = false,)
    var userId: Long?,
): BasicTimeEntity(), BasicEntityConverter<Slot, SlotEntity> {
    override fun toDomain() =
        Slot(
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