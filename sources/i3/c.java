package i3;

import android.content.Context;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Collection;

public class c<T> implements h<T> {

    /* renamed from: b  reason: collision with root package name */
    private final Collection<? extends h<T>> f15459b;

    public c(@NonNull Collection<? extends h<T>> collection) {
        if (!collection.isEmpty()) {
            this.f15459b = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f15459b.equals(((c) obj).f15459b);
        }
        return false;
    }

    public int hashCode() {
        return this.f15459b.hashCode();
    }

    @NonNull
    public l3.c<T> transform(@NonNull Context context, @NonNull l3.c<T> cVar, int i10, int i11) {
        l3.c<T> cVar2 = cVar;
        for (h transform : this.f15459b) {
            l3.c<T> transform2 = transform.transform(context, cVar2, i10, i11);
            if (cVar2 != null && !cVar2.equals(cVar) && !cVar2.equals(transform2)) {
                cVar2.a();
            }
            cVar2 = transform2;
        }
        return cVar2;
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        for (h updateDiskCacheKey : this.f15459b) {
            updateDiskCacheKey.updateDiskCacheKey(messageDigest);
        }
    }
}
