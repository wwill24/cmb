package androidx.camera.core;

import android.media.ImageReader;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.x0;

public final class q1 {
    @NonNull
    public static x0 a(int i10, int i11, int i12, int i13) {
        return new d(ImageReader.newInstance(i10, i11, i12, i13));
    }
}
