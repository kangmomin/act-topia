package com.acttopia.main.domain.slot.controller.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

class UpdateSlotRequest (
    @field: NotNull(message = "슬롯 아이디를 찾을 수 없습니다.")
    val slotId: Long?,

    @field: NotEmpty(message = "메인 키워드가 입려되지 않았습니다.")
    val mainKeyword: String?,
    @field: NotEmpty(message = "서브 키워드가 입력되지 않았습니다.")
    val subKeyword: String?,

    @field: NotNull(message = "미드 값이 입력되지 않았습니다.")
    val midValue: Long?,
)
