package w3;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import g3.a;
import m3.d;

public final class b implements a.C0161a {

    /* renamed from: a  reason: collision with root package name */
    private final d f18196a;

    /* renamed from: b  reason: collision with root package name */
    private final m3.b f18197b;

    public b(d dVar, m3.b bVar) {
        this.f18196a = dVar;
        this.f18197b = bVar;
    }

    @NonNull
    public byte[] a(int i10) {
        m3.b bVar = this.f18197b;
        if (bVar == null) {
            return new byte[i10];
        }
        return (byte[]) bVar.c(i10, byte[].class);
    }

    @NonNull
    public Bitmap b(int i10, int i11, @NonNull Bitmap.Config config) {
        return this.f18196a.e(i10, i11, config);
    }

    @NonNull
    public int[] c(int i10) {
        m3.b bVar = this.f18197b;
        if (bVar == null) {
            return new int[i10];
        }
        return (int[]) bVar.c(i10, int[].class);
    }

    public void d(@NonNull Bitmap bitmap) {
        this.f18196a.c(bitmap);
    }

    public void e(@NonNull byte[] bArr) {
        m3.b bVar = this.f18197b;
        if (bVar != null) {
            bVar.put(bArr);
        }
    }

    public void f(@NonNull int[] iArr) {
        m3.b bVar = this.f18197b;
        if (bVar != null) {
            bVar.put(iArr);
        }
    }
}
