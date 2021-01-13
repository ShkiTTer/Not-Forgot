package com.notforgot.domain.session

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ClearSessionUseCaseImpl(
    private val sessionDataSource: SessionDataSource
) : ClearSessionsUseCase {
    override fun execute(): Flow<Result<Unit>> = flow {
        emit(Result.success(sessionDataSource.clearSessions()))
    }
}