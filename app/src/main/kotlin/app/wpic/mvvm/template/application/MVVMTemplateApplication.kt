package app.wpic.mvvm.template.application

import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.os.StrictMode.VmPolicy
import androidx.multidex.MultiDexApplication
import app.wpic.mvvm.presentation.datastore.DataStoreManager
import app.wpic.mvvmtemplate.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class MVVMTemplateApplication : MultiDexApplication() {

    @Inject
    lateinit var dataStoreManager: DataStoreManager

    override fun onCreate() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork() // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build()
            )
            StrictMode.setVmPolicy(
                VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    //.penaltyDeath() //TODO
                    .build()
            )
        }
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}