package com.acttopia.main.domain.user.persistence.entity

import com.acttopia.main.domain.user.model.User
import com.acttopia.main.domain.user.model.constant.UserRole
import com.acttopia.main.global.common.basic.entity.BasicTimeEntity
import com.acttopia.main.global.common.basic.model.BasicEntityConverter
import jakarta.persistence.*

@Entity
@Table(name = "user_table")
class UserEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(nullable = false,)
    var loginId: String?,

    @Column(
        nullable = false,
        columnDefinition = "TEXT")
    var password: String?,

    @Column(nullable = false,)
    var role: UserRole?,
    var slotCount: Long?,
): BasicEntityConverter<User, UserEntity>, BasicTimeEntity() {
    override fun toDomain(): User =
        User(
            id = this.id,
            loginId = this.loginId,
            password = this.password,
            role = this.role,
            slotCount = this.slotCount,
        )
}