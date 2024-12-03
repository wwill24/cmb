package e4;

import androidx.annotation.NonNull;
import f4.j;
import i3.b;
import java.security.MessageDigest;

public final class d implements b {

    /* renamed from: b  reason: collision with root package name */
    private final Object f14577b;

    public d(@NonNull Object obj) {
        this.f14577b = j.d(obj);
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f14577b.equals(((d) obj).f14577b);
        }
        return false;
    }

    public int hashCode() {
        return this.f14577b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f14577b + '}';
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f14577b.toString().getBytes(b.f15458a));
    }
}
