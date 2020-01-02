package com.nooblabs.service

import com.nooblabs.persistence.FooRepository
import kotlin.random.Random

class FooService(private val fooRepository: FooRepository) {

    private val random = Random

    fun getRandomFoo() = fooRepository.getFoo(random.nextInt(fooRepository.getCount()))

    fun saveFoo(name: String) = fooRepository.saveFoo(name)

    fun getFooByName(name: String) = fooRepository.getFooByName(name)
    fun getAllFoos() = fooRepository.getAllFoos()

}
