package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.o1;
import java.util.concurrent.Executor;

public interface x0 {

    public interface a {
        void a(@NonNull x0 x0Var);
    }

    o1 b();

    int c();

    void close();

    void d();

    int e();

    void f(@NonNull a aVar, @NonNull Executor executor);

    o1 g();

    int getHeight();

    Surface getSurface();

    int getWidth();
}
