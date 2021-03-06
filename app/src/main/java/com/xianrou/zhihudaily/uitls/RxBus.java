package com.xianrou.zhihudaily.uitls;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by android studio.
 * user 磊
 * Date 2016/10/11
 * Time 15:40
 * Desc
 */
public class RxBus {

	private static RxBus rxBus;
	private final Subject<Object, Object> _bus = new SerializedSubject<>(PublishSubject.create());

	private RxBus() {
	}

	public static RxBus getInstance() {
		if (rxBus == null) {
			synchronized (RxBus.class) {
				if (rxBus == null) {
					rxBus = new RxBus();
				}
			}
		}
		return rxBus;
	}


	public void send(Object o) {
		_bus.onNext(o);
	}

	public Observable<Object> toObserverable() {
		return _bus;
	}
}