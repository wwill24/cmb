package i3;

import androidx.annotation.NonNull;
import androidx.collection.a;
import f4.b;
import java.security.MessageDigest;

public final class e implements b {

    /* renamed from: b  reason: collision with root package name */
    private final a<d<?>, Object> f15465b = new b();

    private static <T> void d(@NonNull d<T> dVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        dVar.g(obj, messageDigest);
    }

    public <T> T a(@NonNull d<T> dVar) {
        return this.f15465b.containsKey(dVar) ? this.f15465b.get(dVar) : dVar.c();
    }

    public void b(@NonNull e eVar) {
        this.f15465b.k(eVar.f15465b);
    }

    @NonNull
    public <T> e c(@NonNull d<T> dVar, @NonNull T t10) {
        this.f15465b.put(dVar, t10);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f15465b.equals(((e) obj).f15465b);
        }
        return false;
    }

    public int hashCode() {
        return this.f15465b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f15465b + '}';
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        for (int i10 = 0; i10 < this.f15465b.size(); i10++) {
            d(this.f15465b.j(i10), this.f15465b.n(i10), messageDigest);
        }
    }
}
