package kg.nurtelecom.design.app

import android.app.Application
import kg.nurtelecom.design.chili2.util.secured.ApplicationSecureGestureDelegate
import kg.nurtelecom.design.chili2.util.secured.OnApplicationSecureGestureListener

class App: Application(), OnApplicationSecureGestureListener by ApplicationSecureGestureDelegate() {

    override fun onCreate() {
        super.onCreate()
        onApplicationCreated(this)
        updateSecureGestureState(true)
    }
}