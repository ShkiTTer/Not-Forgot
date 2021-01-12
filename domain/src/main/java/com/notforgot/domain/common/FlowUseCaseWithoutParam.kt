package com.notforgot.domain.common

import kotlinx.coroutines.flow.Flow

interface FlowUseCaseWithoutParam<out R> {
    operator fun invoke(): Flow<Result<R>> = execute().handleOn()
    fun execute(): Flow<Result<R>>
}