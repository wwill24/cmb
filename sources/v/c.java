package v;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.l1;

public final class c implements l1 {

    /* renamed from: a  reason: collision with root package name */
    private final p f18034a;

    public c(@NonNull p pVar) {
        this.f18034a = pVar;
    }

    public int a() {
        return 0;
    }

    public void b(@NonNull ExifData.b bVar) {
        this.f18034a.b(bVar);
    }

    @NonNull
    public a2 c() {
        return this.f18034a.c();
    }

    @NonNull
    public Matrix d() {
        return new Matrix();
    }

    @NonNull
    public p e() {
        return this.f18034a;
    }

    public long getTimestamp() {
        return this.f18034a.getTimestamp();
    }
}
