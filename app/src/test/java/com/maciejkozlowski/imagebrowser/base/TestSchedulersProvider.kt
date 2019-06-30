package com.maciejkozlowski.imagebrowser.base

import com.maciejkozlowski.imagebrowser.base.rx.SchedulersProvider
import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */
class TestSchedulersProvider : SchedulersProvider {

    val testScheduler = TestScheduler()

    override fun getObserverScheduler(): Scheduler {
        return testScheduler
    }

    override fun getSubscriberScheduler(): Scheduler {
        return testScheduler
    }
}
