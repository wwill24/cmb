package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.core.util.h;

public abstract class e0 {
    e0() {
    }

    @NonNull
    static e0 d(long j10, long j11, @NonNull b bVar) {
        boolean z10;
        boolean z11 = true;
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.b(z10, "duration must be positive value.");
        if (j11 < 0) {
            z11 = false;
        }
        h.b(z11, "bytes must be positive value.");
        return new j(j10, j11, bVar);
    }

    @NonNull
    public abstract b a();

    public abstract long b();

    public abstract long c();
}
