package androidx.camera.video.internal.encoder;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.video.internal.BufferProvider;
import java.util.concurrent.Executor;

public interface j {

    public interface a extends b, BufferProvider<b1> {
    }

    public interface b {
    }

    public interface c extends b {

        public interface a {
            void a(@NonNull Surface surface);
        }

        void a(@NonNull Executor executor, @NonNull a aVar);
    }

    @NonNull
    b a();

    void b(@NonNull k kVar, @NonNull Executor executor);

    void c(long j10);

    void d();

    void pause();

    void release();

    void start();

    void stop();
}
