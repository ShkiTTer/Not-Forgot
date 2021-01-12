package com.notforgot.domain.common

import kotlinx.coroutines.flow.Flow

interface FlowUseCase<in P, out R> {
    operator fun invoke(param: P): Flow<Result<R>> = execute(param).handleOn()
    fun execute(param: P): Flow<Result<R>>
}