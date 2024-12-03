package androidx.camera.core;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.utils.ExifData;

public interface l1 {
    int a();

    void b(@NonNull ExifData.b bVar);

    @NonNull
    a2 c();

    @NonNull
    Matrix d() {
        return new Matrix();
    }

    long getTimestamp();
}
