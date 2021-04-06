package com.automattic.android.tracks.fakes

import com.automattic.android.tracks.BuildConfig
import com.automattic.android.tracks.crashlogging.CrashLoggingDataProvider
import com.automattic.android.tracks.crashlogging.CrashLoggingException
import com.automattic.android.tracks.crashlogging.CrashLoggingUser
import java.util.Locale

class FakeDataProvider(
    override val sentryDSN: String = BuildConfig.SENTRY_TEST_PROJECT_DSN,
    override val buildType: String = "testBuildType",
    override val releaseName: String = "testReleaseName",
    override val locale: Locale? = Locale.US,
    override val enableCrashLoggingLogs: Boolean = true,
    override val toDropIfLastException: CrashLoggingException? = null,
    var user: CrashLoggingUser? = testUser1,
    var userHasOptOut: Boolean = false,
) : CrashLoggingDataProvider {

    override fun userProvider(): CrashLoggingUser? {
        return user
    }

    override fun userHasOptOutProvider(): Boolean {
        return userHasOptOut
    }
}
