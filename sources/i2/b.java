package i2;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public interface b {
    @NonNull
    Executor a();

    @NonNull
    a b();

    void c(@NonNull Runnable runnable) {
        b().execute(runnable);
    }
}
