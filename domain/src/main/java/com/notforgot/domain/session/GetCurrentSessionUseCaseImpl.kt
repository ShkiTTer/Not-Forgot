package com.notforgot.domain.session

import com.notforgot.domain.session.model.Session
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCurrentSessionUseCaseImpl(
    private val sessionDataSource: SessionDataSource
) : GetCurrentSessionUseCase {
    override fun execute(): Flow<Result<Session?>> = flow {
        emit(Result.success(sessionDataSource.getSession()))
    }
}