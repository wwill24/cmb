package x3;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import i3.e;
import m3.d;

public final class c implements e<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final d f18529a;

    /* renamed from: b  reason: collision with root package name */
    private final e<Bitmap, byte[]> f18530b;

    /* renamed from: c  reason: collision with root package name */
    private final e<w3.c, byte[]> f18531c;

    public c(@NonNull d dVar, @NonNull e<Bitmap, byte[]> eVar, @NonNull e<w3.c, byte[]> eVar2) {
        this.f18529a = dVar;
        this.f18530b = eVar;
        this.f18531c = eVar2;
    }

    @NonNull
    private static l3.c<w3.c> b(@NonNull l3.c<Drawable> cVar) {
        return cVar;
    }

    public l3.c<byte[]> a(@NonNull l3.c<Drawable> cVar, @NonNull e eVar) {
        Drawable drawable = cVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f18530b.a(s3.e.d(((BitmapDrawable) drawable).getBitmap(), this.f18529a), eVar);
        }
        if (drawable instanceof w3.c) {
            return this.f18531c.a(b(cVar), eVar);
        }
        return null;
    }
}
