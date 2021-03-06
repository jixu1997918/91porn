package com.u91porn.rxjava;

import com.u91porn.exception.ApiException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 *
 * @author flymegoc
 * @date 2017/12/1
 */

public abstract class CallBackWrapper<T> implements Observer<T> {

    private static final String TAG = CallBackWrapper.class.getSimpleName();

    @Override
    public void onSubscribe(Disposable d) {
        onBegin(d);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        ApiException apiException = ApiException.handleException(e);
        onError(apiException.getMessage(), apiException.getCode());
    }

    @Override
    public void onComplete() {

    }

    public abstract void onBegin(Disposable d);

    public abstract void onSuccess(T t);

    public abstract void onError(String msg, int code);
}
