package com.nooblabs.api

import com.nooblabs.common.Foo
import com.nooblabs.service.FooService
import org.http4k.core.Body
import org.http4k.core.Method.GET
import org.http4k.core.Method.POST
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.NOT_FOUND
import org.http4k.core.Status.Companion.OK
import org.http4k.format.Jackson.auto
import org.http4k.routing.bind
import org.http4k.routing.path
import org.http4k.routing.routes


class FooController(private val fooService: FooService) {

    operator fun invoke(prefix: String = "") = prefix bind routes(
            "/randomFoo" bind GET to getRandomFoo(),
            "/saveFoo" bind POST to saveFoo(),
            "/foo/{name}" bind GET to getFooByName(),
            "/foo" bind GET to getAllFoos()
    )

    fun getRandomFoo() = { request: Request ->
        FooLens(fooService.getRandomFoo(), Response(OK))
    }

    fun saveFoo() = { request: Request ->
        val newFoo = FooLens(request)
        fooService.saveFoo(newFoo.name)
        Response(OK)
    }

    fun getFooByName() = { request: Request ->
        val name = request.path("name")
        name?.let {
            fooService.getFooByName(it)?.let { foo ->
                FooLens(foo, Response(OK))
            }
        } ?: Response(NOT_FOUND)

    }

    fun getAllFoos() = { request: Request ->
        FooListLens(fooService.getAllFoos(), Response(OK))
    }

    companion object {
        private val FooLens = Body.auto<Foo>().toLens()
        private val FooListLens = Body.auto<List<Foo>>().toLens()
    }
}






