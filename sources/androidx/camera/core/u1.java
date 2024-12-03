package androidx.camera.core;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.utils.ExifData;

public abstract class u1 implements l1 {
    @NonNull
    public static l1 e(@NonNull a2 a2Var, long j10, int i10, @NonNull Matrix matrix) {
        return new h(a2Var, j10, i10, matrix);
    }

    public abstract int a();

    public void b(@NonNull ExifData.b bVar) {
        bVar.m(a());
    }

    @NonNull
    public abstract a2 c();

    @NonNull
    public abstract Matrix d();

    public abstract long getTimestamp();
}
