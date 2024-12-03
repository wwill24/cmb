package x9;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.mparticle.identity.IdentityHttpResponse;
import i3.h;
import java.security.MessageDigest;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import s3.e;

public final class c implements h<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    private final int f18576b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18577c;

    public c(int i10, int i11) {
        this.f18576b = i10;
        this.f18577c = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f18576b == cVar.f18576b && this.f18577c == cVar.f18577c;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f18576b) * 31) + Integer.hashCode(this.f18577c);
    }

    public String toString() {
        return "GlideTransformRounded(radius=" + this.f18576b + ", margin=" + this.f18577c + PropertyUtils.MAPPED_DELIM2;
    }

    public l3.c<Bitmap> transform(Context context, l3.c<Bitmap> cVar, int i10, int i11) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(cVar, "resource");
        Bitmap bitmap = cVar.get();
        j.f(bitmap, "resource.get()");
        Bitmap bitmap2 = bitmap;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap2, tileMode, tileMode));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap2.getWidth(), bitmap2.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int i12 = this.f18577c;
        RectF rectF = new RectF((float) i12, (float) i12, (float) (bitmap2.getWidth() - this.f18577c), (float) (bitmap2.getHeight() - this.f18577c));
        int i13 = this.f18576b;
        canvas.drawRoundRect(rectF, (float) i13, (float) i13, paint);
        return new e(createBitmap, com.bumptech.glide.c.c(context).f());
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        j.g(messageDigest, "messageDigest");
        messageDigest.update((byte) hashCode());
    }
}
