package x9;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import com.mparticle.identity.IdentityHttpResponse;
import i3.h;
import java.security.MessageDigest;
import kotlin.jvm.internal.j;
import l3.c;
import org.apache.commons.beanutils.PropertyUtils;
import s3.e;

public final class b implements h<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    private final int f18573b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18574c;

    /* renamed from: d  reason: collision with root package name */
    private final int f18575d;

    public b(int i10, int i11, int i12) {
        this.f18573b = i10;
        this.f18574c = i11;
        this.f18575d = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f18573b == bVar.f18573b && this.f18574c == bVar.f18574c && this.f18575d == bVar.f18575d;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f18573b) * 31) + Integer.hashCode(this.f18574c)) * 31) + Integer.hashCode(this.f18575d);
    }

    public String toString() {
        return "GlideTransformCropCircleWithBorder(spaceSize=" + this.f18573b + ", ringWidth=" + this.f18574c + ", ringColor=" + this.f18575d + PropertyUtils.MAPPED_DELIM2;
    }

    public c<Bitmap> transform(Context context, c<Bitmap> cVar, int i10, int i11) {
        Bitmap bitmap;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(cVar, "resource");
        Bitmap bitmap2 = cVar.get();
        j.f(bitmap2, "resource.get()");
        Bitmap bitmap3 = bitmap2;
        int min = Math.min(bitmap3.getWidth(), bitmap3.getHeight());
        int i12 = this.f18573b + this.f18574c;
        int i13 = (i12 * 2) + min;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap3, (bitmap3.getWidth() - min) / 2, (bitmap3.getHeight() - min) / 2, min, min);
        if (bitmap3.getConfig() == null) {
            bitmap = Bitmap.createBitmap(i13, i13, Bitmap.Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(i13, i13, bitmap3.getConfig());
        }
        Canvas canvas = new Canvas(bitmap);
        float f10 = (float) i12;
        canvas.translate(f10, f10);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        float f11 = ((float) min) / 2.0f;
        canvas.drawCircle(f11, f11, f11, paint);
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(this.f18575d);
        paint2.setStrokeWidth((float) this.f18574c);
        paint2.setAntiAlias(true);
        canvas.drawCircle(f11, f11, ((float) this.f18573b) + f11 + ((float) (this.f18574c / 2)), paint2);
        createBitmap.recycle();
        e d10 = e.d(bitmap, com.bumptech.glide.c.c(context).f());
        j.d(d10);
        return d10;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        j.g(messageDigest, "messageDigest");
        messageDigest.update((byte) hashCode());
    }
}
