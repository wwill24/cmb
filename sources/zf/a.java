package zf;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public interface a<V> extends Future<V> {
    void addListener(Runnable runnable, Executor executor);
}
