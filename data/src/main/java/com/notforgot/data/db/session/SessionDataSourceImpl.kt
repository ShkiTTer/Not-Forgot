package com.notforgot.data.db.session

import com.notforgot.data.db.session.model.SessionEntity
import com.notforgot.domain.session.SessionDataSource
import com.notforgot.domain.session.model.Session

class SessionDataSourceImpl(
    private val sessionDao: SessionDao
) : SessionDataSource {
    override suspend fun getSession(): Session? {
        return sessionDao.getSession()?.toDomain()
    }

    override suspend fun createSession(session: Session) {
        sessionDao.createSession(SessionEntity.fromDomain(session))
    }

    override suspend fun clearSessions() {
        sessionDao.clearSessions()
    }
}