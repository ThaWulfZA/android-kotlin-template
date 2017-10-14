package io.bffcorreia.kotlintemplate.domain

import io.reactivex.Observable
import io.reactivex.Scheduler

abstract class UseCase<T> constructor(private val subscribeOn: Scheduler,
    private val observeOn: Scheduler) {

  protected abstract fun buildUseCaseObservable(): Observable<T>

  fun observable(): Observable<T> {
    return buildUseCaseObservable()
        .subscribeOn(subscribeOn)
        .observeOn(observeOn)
  }
}

