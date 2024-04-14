package com.acttopia.main.domain.user.controller.request

import com.fasterxml.jackson.annotation.JsonProperty

class SlotUpdateRequest (
    @JsonProperty("newSlot")
    val slot: Long?,
    val userId: Long?
)