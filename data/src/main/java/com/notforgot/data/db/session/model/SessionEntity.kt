package com.notforgot.data.db.session.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.notforgot.domain.session.model.Session

@Entity(tableName = "Sessions")
data class SessionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val email: String,
    val accessToken: String
) {

    companion object {
        fun fromDomain(data: Session): SessionEntity = SessionEntity(
            email = data.email,
            accessToken = data.accessToken
        )
    }

    fun toDomain(): Session = Session(
        email = email,
        accessToken = accessToken
    )
}
