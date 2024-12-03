package androidx.camera.video.internal;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.l1;
import zf.a;

public interface BufferProvider<T> extends l1<State> {

    public enum State {
        ACTIVE,
        INACTIVE
    }

    @NonNull
    a<T> e();
}
