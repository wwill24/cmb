package s3;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import f4.k;
import i3.h;
import l3.c;
import m3.d;

public abstract class f implements h<Bitmap> {
    /* access modifiers changed from: protected */
    public abstract Bitmap a(@NonNull d dVar, @NonNull Bitmap bitmap, int i10, int i11);

    @NonNull
    public final c<Bitmap> transform(@NonNull Context context, @NonNull c<Bitmap> cVar, int i10, int i11) {
        if (k.r(i10, i11)) {
            d f10 = com.bumptech.glide.c.c(context).f();
            Bitmap bitmap = cVar.get();
            if (i10 == Integer.MIN_VALUE) {
                i10 = bitmap.getWidth();
            }
            if (i11 == Integer.MIN_VALUE) {
                i11 = bitmap.getHeight();
            }
            Bitmap a10 = a(f10, bitmap, i10, i11);
            if (bitmap.equals(a10)) {
                return cVar;
            }
            return e.d(a10, f10);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i10 + " or height: " + i11 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
