package r3;

import android.content.Context;
import androidx.annotation.NonNull;
import i3.h;
import java.security.MessageDigest;

public final class c<T> implements h<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final h<?> f17271b = new c();

    private c() {
    }

    @NonNull
    public static <T> c<T> a() {
        return (c) f17271b;
    }

    @NonNull
    public l3.c<T> transform(@NonNull Context context, @NonNull l3.c<T> cVar, int i10, int i11) {
        return cVar;
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
    }
}
