package s3;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import i3.b;
import java.security.MessageDigest;
import m3.d;

public class k extends f {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f17453b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(b.f15458a);

    /* access modifiers changed from: protected */
    public Bitmap a(@NonNull d dVar, @NonNull Bitmap bitmap, int i10, int i11) {
        return t.c(dVar, bitmap, i10, i11);
    }

    public boolean equals(Object obj) {
        return obj instanceof k;
    }

    public int hashCode() {
        return -670243078;
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f17453b);
    }
}
