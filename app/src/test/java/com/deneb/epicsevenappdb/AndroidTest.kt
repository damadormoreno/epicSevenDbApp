package com.deneb.epicsevenappdb

import android.app.Application
import android.content.Context
import com.deneb.epicsevenappdb.core.navigation.MainActivity
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(
    manifest=Config.NONE,
    application = AndroidTest.ApplicationStub::class,
    sdk = [21]
)
abstract class AndroidTest {

    @Suppress("LeakingThis")
    @Rule
    @JvmField val injectMocks = InjectMocksRule.create(this@AndroidTest)

    fun context(): Context = RuntimeEnvironment.application

    fun activityContext(): Context = mock(MainActivity::class.java)

    internal class ApplicationStub : Application()
}
