package v;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.s1;
import java.util.concurrent.Executor;

public interface i extends s1 {

    /* renamed from: y  reason: collision with root package name */
    public static final Config.a<Executor> f18040y = Config.a.a("camerax.core.thread.backgroundExecutor", Executor.class);

    Executor F(Executor executor) {
        return (Executor) g(f18040y, executor);
    }
}
