package androidx.core.util;

import androidx.annotation.NonNull;

public class d<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final F f4735a;

    /* renamed from: b  reason: collision with root package name */
    public final S f4736b;

    public d(F f10, S s10) {
        this.f4735a = f10;
        this.f4736b = s10;
    }

    @NonNull
    public static <A, B> d<A, B> a(A a10, B b10) {
        return new d<>(a10, b10);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!c.a(dVar.f4735a, this.f4735a) || !c.a(dVar.f4736b, this.f4736b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        F f10 = this.f4735a;
        int i10 = 0;
        int hashCode = f10 == null ? 0 : f10.hashCode();
        S s10 = this.f4736b;
        if (s10 != null) {
            i10 = s10.hashCode();
        }
        return hashCode ^ i10;
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.f4735a + " " + this.f4736b + "}";
    }
}
