package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.h0;
import androidx.camera.core.impl.l1;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class StreamInfo {

    /* renamed from: a  reason: collision with root package name */
    static final StreamInfo f3065a = c(0, StreamState.INACTIVE);

    /* renamed from: b  reason: collision with root package name */
    static final Set<Integer> f3066b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{0, -1})));

    /* renamed from: c  reason: collision with root package name */
    static final l1<StreamInfo> f3067c = h0.g(c(0, StreamState.ACTIVE));

    enum StreamState {
        ACTIVE,
        INACTIVE
    }

    StreamInfo() {
    }

    @NonNull
    static StreamInfo c(int i10, @NonNull StreamState streamState) {
        return new k(i10, streamState);
    }

    public abstract int a();

    @NonNull
    public abstract StreamState b();
}
