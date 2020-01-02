package com.nooblabs.api

import org.http4k.server.Jetty
import org.http4k.server.asServer
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.inject

class FooApp : KoinComponent {
    val router: Router by inject()
}

fun init() {
    startKoin {
        modules(listOf(
                fooPersistenceModule,
                fooServiceModule,
                fooControllerModule,
                mainModule
        ))
    }
}

fun main() {
    init()

    val fooApp = FooApp()

    val app = fooApp.router()

    app.asServer(Jetty(9000)).start()
}

