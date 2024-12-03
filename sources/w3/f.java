package w3;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import i3.h;
import java.security.MessageDigest;
import l3.c;
import s3.e;

public class f implements h<c> {

    /* renamed from: b  reason: collision with root package name */
    private final h<Bitmap> f18210b;

    /* JADX WARNING: type inference failed for: r1v0, types: [i3.h<android.graphics.Bitmap>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(i3.h<android.graphics.Bitmap> r1) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.Object r1 = f4.j.d(r1)
            i3.h r1 = (i3.h) r1
            r0.f18210b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.f.<init>(i3.h):void");
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f18210b.equals(((f) obj).f18210b);
        }
        return false;
    }

    public int hashCode() {
        return this.f18210b.hashCode();
    }

    @NonNull
    public c<c> transform(@NonNull Context context, @NonNull c<c> cVar, int i10, int i11) {
        c cVar2 = cVar.get();
        e eVar = new e(cVar2.e(), com.bumptech.glide.c.c(context).f());
        c<Bitmap> transform = this.f18210b.transform(context, eVar, i10, i11);
        if (!eVar.equals(transform)) {
            eVar.a();
        }
        cVar2.m(this.f18210b, transform.get());
        return cVar;
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f18210b.updateDiskCacheKey(messageDigest);
    }
}
