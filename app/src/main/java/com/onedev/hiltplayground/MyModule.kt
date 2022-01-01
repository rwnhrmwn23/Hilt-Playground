package com.onedev.hiltplayground

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MyModule {

    @Singleton
    @Provides
    fun provideSomeString(): String {
        return "Some String"
    }

    @Singleton
    @Provides
    fun provideSomeInterface(text: String): SomeInterface {
        return SomeInterfaceImpl(text)
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }
}