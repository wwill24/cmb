package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.x1;

final class i extends x1.a {

    /* renamed from: a  reason: collision with root package name */
    private final Throwable f2548a;

    i(Throwable th2) {
        if (th2 != null) {
            this.f2548a = th2;
            return;
        }
        throw new NullPointerException("Null error");
    }

    @NonNull
    public Throwable a() {
        return this.f2548a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x1.a) {
            return this.f2548a.equals(((x1.a) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.f2548a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "ErrorWrapper{error=" + this.f2548a + "}";
    }
}
