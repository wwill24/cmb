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
import l3.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class e implements h<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    private final int f18579b;

    public e(int i10) {
        this.f18579b = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && this.f18579b == ((e) obj).f18579b;
    }

    public int hashCode() {
        return Integer.hashCode(this.f18579b);
    }

    public String toString() {
        return "GlideTransformRoundedTop(radius=" + this.f18579b + PropertyUtils.MAPPED_DELIM2;
    }

    public c<Bitmap> transform(Context context, c<Bitmap> cVar, int i10, int i11) {
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
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap2.getWidth(), (float) bitmap2.getHeight());
        int i12 = this.f18579b;
        canvas.drawRoundRect(rectF, (float) i12, (float) i12, paint);
        canvas.drawRect(0.0f, (float) this.f18579b, (float) bitmap2.getWidth(), (float) bitmap2.getHeight(), paint);
        return new s3.e(createBitmap, com.bumptech.glide.c.c(context).f());
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        j.g(messageDigest, "messageDigest");
        messageDigest.update((byte) hashCode());
    }
}
