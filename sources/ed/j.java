package ed;

import android.annotation.SuppressLint;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

abstract class j {
    @SuppressLint({"ThreadPoolCreation"})
    static Executor a() {
        return new n(Executors.newSingleThreadExecutor());
    }
}
