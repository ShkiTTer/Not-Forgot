package com.notforgot.domain.session

import com.notforgot.domain.session.model.Session

interface SessionDataSource {
    suspend fun getSession(): Session?
    suspend fun createSession(session: Session)
    suspend fun clearSessions()
}