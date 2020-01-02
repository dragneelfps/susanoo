package com.nooblabs.persistence

import com.nooblabs.common.Foo

class FooRepository {

    private val foos = ArrayList<Foo>()

    fun saveFoo(name: String) = Foo(name).also { foos.add(it) }

    fun getFoo(index: Int) = foos[index]

    fun getCount() = foos.size

    fun getFooByName(name: String) = foos.firstOrNull { it.name == name }
    fun getAllFoos(): List<Foo> = foos
}
