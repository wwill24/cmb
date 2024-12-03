package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public interface l1<T> {

    public interface a<T> {
        void a(T t10);

        void onError(@NonNull Throwable th2);
    }

    @NonNull
    zf.a<T> b();

    void c(@NonNull Executor executor, @NonNull a<? super T> aVar);

    void d(@NonNull a<? super T> aVar);
}
