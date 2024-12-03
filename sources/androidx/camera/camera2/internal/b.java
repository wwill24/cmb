package androidx.camera.camera2.internal;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.f2;

final class b extends Camera2CameraImpl.g {

    /* renamed from: a  reason: collision with root package name */
    private final String f1678a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f1679b;

    /* renamed from: c  reason: collision with root package name */
    private final SessionConfig f1680c;

    /* renamed from: d  reason: collision with root package name */
    private final f2<?> f1681d;

    /* renamed from: e  reason: collision with root package name */
    private final Size f1682e;

    b(String str, Class<?> cls, SessionConfig sessionConfig, f2<?> f2Var, Size size) {
        if (str != null) {
            this.f1678a = str;
            if (cls != null) {
                this.f1679b = cls;
                if (sessionConfig != null) {
                    this.f1680c = sessionConfig;
                    if (f2Var != null) {
                        this.f1681d = f2Var;
                        this.f1682e = size;
                        return;
                    }
                    throw new NullPointerException("Null useCaseConfig");
                }
                throw new NullPointerException("Null sessionConfig");
            }
            throw new NullPointerException("Null useCaseType");
        }
        throw new NullPointerException("Null useCaseId");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public SessionConfig c() {
        return this.f1680c;
    }

    /* access modifiers changed from: package-private */
    public Size d() {
        return this.f1682e;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public f2<?> e() {
        return this.f1681d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Camera2CameraImpl.g)) {
            return false;
        }
        Camera2CameraImpl.g gVar = (Camera2CameraImpl.g) obj;
        if (this.f1678a.equals(gVar.f()) && this.f1679b.equals(gVar.g()) && this.f1680c.equals(gVar.c()) && this.f1681d.equals(gVar.e())) {
            Size size = this.f1682e;
            if (size == null) {
                if (gVar.d() == null) {
                    return true;
                }
            } else if (size.equals(gVar.d())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public String f() {
        return this.f1678a;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Class<?> g() {
        return this.f1679b;
    }

    public int hashCode() {
        int i10;
        int hashCode = (((((((this.f1678a.hashCode() ^ 1000003) * 1000003) ^ this.f1679b.hashCode()) * 1000003) ^ this.f1680c.hashCode()) * 1000003) ^ this.f1681d.hashCode()) * 1000003;
        Size size = this.f1682e;
        if (size == null) {
            i10 = 0;
        } else {
            i10 = size.hashCode();
        }
        return hashCode ^ i10;
    }

    public String toString() {
        return "UseCaseInfo{useCaseId=" + this.f1678a + ", useCaseType=" + this.f1679b + ", sessionConfig=" + this.f1680c + ", useCaseConfig=" + this.f1681d + ", surfaceResolution=" + this.f1682e + "}";
    }
}
