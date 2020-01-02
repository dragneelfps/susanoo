package com.nooblabs.api

import com.nooblabs.persistence.FooRepository
import com.nooblabs.service.FooService
import org.koin.dsl.module

val fooPersistenceModule = module {
    single { FooRepository() }
}

val fooServiceModule = module {
    single { FooService(get()) }
}

val fooControllerModule = module {
    single { FooController(get()) }
}

val mainModule = module {
    single { Router(get()) }
}
