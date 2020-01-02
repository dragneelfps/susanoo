package com.nooblabs.api

import org.http4k.core.RequestContexts
import org.http4k.core.then
import org.http4k.filter.ServerFilters
import org.http4k.routing.routes

class Router(
        private val fooController: FooController
) {

    operator fun invoke() =
            ServerFilters.InitialiseRequestContext(RequestContexts())
                    .then(routes(fooController()))

}
