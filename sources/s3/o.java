package s3;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import i3.b;
import java.security.MessageDigest;
import m3.d;

public class o extends f {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f17457b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(b.f15458a);

    /* access modifiers changed from: protected */
    public Bitmap a(@NonNull d dVar, @NonNull Bitmap bitmap, int i10, int i11) {
        return t.e(dVar, bitmap, i10, i11);
    }

    public boolean equals(Object obj) {
        return obj instanceof o;
    }

    public int hashCode() {
        return 1572326941;
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f17457b);
    }
}
