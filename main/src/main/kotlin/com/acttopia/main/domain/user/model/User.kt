package com.acttopia.main.domain.user.model

import com.acttopia.main.domain.user.model.constant.UserRole
import com.acttopia.main.domain.user.persistence.entity.UserEntity
import com.acttopia.main.global.common.basic.model.BasicModelConverter
import com.acttopia.main.global.common.basic.model.BasicTime

class User (
    var id: Long?,
    var loginId: String?,
    var password: String?,
    var role: UserRole?,
    var slotCount: Long?
): BasicModelConverter<User, UserEntity>, BasicTime() {
    override fun toEntity(): UserEntity =
        UserEntity(
            id = this.id,
            loginId = this.loginId,
            password = this.password,
            role = this.role,
            slotCount = this.slotCount
        )
}