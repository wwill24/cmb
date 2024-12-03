package s3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import i3.h;
import java.security.MessageDigest;
import l3.c;
import m3.d;

public class m implements h<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    private final h<Bitmap> f17455b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17456c;

    public m(h<Bitmap> hVar, boolean z10) {
        this.f17455b = hVar;
        this.f17456c = z10;
    }

    private c<Drawable> b(Context context, c<Bitmap> cVar) {
        return q.d(context.getResources(), cVar);
    }

    public h<BitmapDrawable> a() {
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof m) {
            return this.f17455b.equals(((m) obj).f17455b);
        }
        return false;
    }

    public int hashCode() {
        return this.f17455b.hashCode();
    }

    @NonNull
    public c<Drawable> transform(@NonNull Context context, @NonNull c<Drawable> cVar, int i10, int i11) {
        d f10 = com.bumptech.glide.c.c(context).f();
        Drawable drawable = cVar.get();
        c<Bitmap> a10 = l.a(f10, drawable, i10, i11);
        if (a10 != null) {
            c<Bitmap> transform = this.f17455b.transform(context, a10, i10, i11);
            if (!transform.equals(a10)) {
                return b(context, transform);
            }
            transform.a();
            return cVar;
        } else if (!this.f17456c) {
            return cVar;
        } else {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f17455b.updateDiskCacheKey(messageDigest);
    }
}
