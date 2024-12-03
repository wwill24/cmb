package androidx.camera.core.impl;

import androidx.annotation.NonNull;

final class f extends q0 {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2515a;

    f(Object obj) {
        if (obj != null) {
            this.f2515a = obj;
            return;
        }
        throw new NullPointerException("Null value");
    }

    @NonNull
    public Object b() {
        return this.f2515a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q0) {
            return this.f2515a.equals(((q0) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f2515a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Identifier{value=" + this.f2515a + "}";
    }
}
