package com.onedev.hiltplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var someClass: SomeClass2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doAThing())
    }
}

class SomeClass2
@Inject
constructor(
    private val someInterface: SomeInterface,
    private val gson: Gson
) {
    fun doAThing(): String {
        return "Look I Got : ${someInterface.getAThing()}"
    }
}

class SomeInterfaceImpl
@Inject
constructor(
    private val text: String
) : SomeInterface {
    override fun getAThing(): String {
        return "A Thing $text"
    }
}

interface SomeInterface {
    fun getAThing(): String
}