package coil.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.decode.d;
import coil.size.Scale;
import coil.size.b;
import coil.size.g;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J0\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0006H\u0007¨\u0006\u0013"}, d2 = {"Lcoil/util/m;", "", "Landroid/graphics/Bitmap;", "bitmap", "Landroid/graphics/Bitmap$Config;", "config", "", "b", "allowInexactSize", "Lcoil/size/g;", "size", "Lcoil/size/Scale;", "scale", "c", "Landroid/graphics/drawable/Drawable;", "drawable", "a", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f8436a = new m();

    private m() {
    }

    private final boolean b(Bitmap bitmap, Bitmap.Config config) {
        return bitmap.getConfig() == a.e(config);
    }

    private final boolean c(boolean z10, Bitmap bitmap, g gVar, Scale scale) {
        int i10;
        int i11;
        if (z10) {
            return true;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (b.b(gVar)) {
            i10 = bitmap.getWidth();
        } else {
            i10 = j.A(gVar.d(), scale);
        }
        if (b.b(gVar)) {
            i11 = bitmap.getHeight();
        } else {
            i11 = j.A(gVar.c(), scale);
        }
        if (d.c(width, height, i10, i11, scale) == 1.0d) {
            return true;
        }
        return false;
    }

    public final Bitmap a(Drawable drawable, Bitmap.Config config, g gVar, Scale scale, boolean z10) {
        int i10;
        int i11;
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (b(bitmap, config) && c(z10, bitmap, gVar, scale)) {
                return bitmap;
            }
        }
        Drawable mutate = drawable.mutate();
        int q10 = j.q(mutate);
        int i12 = 512;
        if (q10 <= 0) {
            q10 = 512;
        }
        int j10 = j.j(mutate);
        if (j10 > 0) {
            i12 = j10;
        }
        if (b.b(gVar)) {
            i10 = q10;
        } else {
            i10 = j.A(gVar.d(), scale);
        }
        if (b.b(gVar)) {
            i11 = i12;
        } else {
            i11 = j.A(gVar.c(), scale);
        }
        double c10 = d.c(q10, i12, i10, i11, scale);
        int a10 = c.a(((double) q10) * c10);
        int a11 = c.a(c10 * ((double) i12));
        Bitmap createBitmap = Bitmap.createBitmap(a10, a11, a.e(config));
        j.f(createBitmap, "createBitmap(width, height, config)");
        Rect bounds = mutate.getBounds();
        int i13 = bounds.left;
        int i14 = bounds.top;
        int i15 = bounds.right;
        int i16 = bounds.bottom;
        mutate.setBounds(0, 0, a10, a11);
        mutate.draw(new Canvas(createBitmap));
        mutate.setBounds(i13, i14, i15, i16);
        return createBitmap;
    }
}
