package com.pri.learningframe.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class ObservableTest {

    public static void main(String[] args) {
        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable disposable) {
//                是否取消了订阅
//                System.out.println(disposable.isDisposed());
            }

            @Override
            public void onNext(Object o) {
                System.out.println("1号订阅者" + o);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
        Observer observer2 = new Observer() {
            @Override
            public void onSubscribe(Disposable disposable) {
//                是否取消了订阅
//                System.out.println(disposable.isDisposed());
            }

            @Override
            public void onNext(Object o) {
                System.out.println("2号订阅者" + o);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
//        直接发送一个或指定的几个参数
        Observable<Object> observable = Observable.just("zs");
        observable.subscribe(observer);
        observable.subscribe(observer2);
//        可以通过onNext持续发送多个参数
        Observable.create(new ObservableOnSubscribe<Object>() {

            @Override
            public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
                observableEmitter.onNext("hmm");
                observableEmitter.onNext("ls");
                observableEmitter.onComplete();
            }

        }).subscribe(observer);
    }
}
