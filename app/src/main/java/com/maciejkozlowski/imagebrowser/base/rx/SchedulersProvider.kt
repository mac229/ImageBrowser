package com.maciejkozlowski.imagebrowser.base.rx

import io.reactivex.Scheduler

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */
interface SchedulersProvider {

    fun getObserverScheduler(): Scheduler

    fun getSubscriberScheduler(): Scheduler
}
