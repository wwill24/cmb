package a0;

import a0.m;
import android.opengl.EGLSurface;
import androidx.annotation.NonNull;

final class a extends m.a {

    /* renamed from: a  reason: collision with root package name */
    private final EGLSurface f8a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10c;

    a(EGLSurface eGLSurface, int i10, int i11) {
        if (eGLSurface != null) {
            this.f8a = eGLSurface;
            this.f9b = i10;
            this.f10c = i11;
            return;
        }
        throw new NullPointerException("Null eglSurface");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public EGLSurface a() {
        return this.f8a;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f10c;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f9b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m.a)) {
            return false;
        }
        m.a aVar = (m.a) obj;
        if (this.f8a.equals(aVar.a()) && this.f9b == aVar.c() && this.f10c == aVar.b()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f8a.hashCode() ^ 1000003) * 1000003) ^ this.f9b) * 1000003) ^ this.f10c;
    }

    public String toString() {
        return "OutputSurface{eglSurface=" + this.f8a + ", width=" + this.f9b + ", height=" + this.f10c + "}";
    }
}
