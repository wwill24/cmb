package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.j;
import java.util.concurrent.TimeUnit;

public abstract class f<R extends j> {

    public interface a {
        void a(@NonNull Status status);
    }

    public void addStatusListener(@NonNull a aVar) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public abstract R await();

    @NonNull
    public abstract R await(long j10, @NonNull TimeUnit timeUnit);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(@NonNull k<? super R> kVar);

    public abstract void setResultCallback(@NonNull k<? super R> kVar, long j10, @NonNull TimeUnit timeUnit);

    @NonNull
    public <S extends j> n<S> then(@NonNull m<? super R, ? extends S> mVar) {
        throw new UnsupportedOperationException();
    }
}
