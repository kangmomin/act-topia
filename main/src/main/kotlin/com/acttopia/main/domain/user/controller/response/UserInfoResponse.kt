package com.acttopia.main.domain.user.controller.response

import com.fasterxml.jackson.annotation.JsonProperty

class UserInfoResponse (
    @JsonProperty("user_id")
    val id: Long,

    @JsonProperty("slot_count")
    val slotCount: Long,

    @JsonProperty("login_id")
    val loginId: String,
)