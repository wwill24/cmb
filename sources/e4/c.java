package e4;

import androidx.annotation.NonNull;
import i3.b;
import java.security.MessageDigest;

public final class c implements b {

    /* renamed from: b  reason: collision with root package name */
    private static final c f14576b = new c();

    private c() {
    }

    @NonNull
    public static c a() {
        return f14576b;
    }

    public String toString() {
        return "EmptySignature";
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
    }
}
