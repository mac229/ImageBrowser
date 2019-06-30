package com.maciejkozlowski.imagebrowser.base.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */
class DefaultSchedulersProvider : SchedulersProvider {

    override fun getObserverScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun getSubscriberScheduler(): Scheduler {
        return Schedulers.io()
    }
}
