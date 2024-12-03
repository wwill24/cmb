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
import s3.e;

public final class d implements h<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    private final int f18578b;

    public d(int i10) {
        this.f18578b = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && this.f18578b == ((d) obj).f18578b;
    }

    public int hashCode() {
        return Integer.hashCode(this.f18578b);
    }

    public String toString() {
        return "GlideTransformRoundedBottom(radius=" + this.f18578b + PropertyUtils.MAPPED_DELIM2;
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
        int i12 = this.f18578b;
        canvas.drawRoundRect(rectF, (float) i12, (float) i12, paint);
        canvas.drawRect(0.0f, 0.0f, (float) bitmap2.getWidth(), (float) this.f18578b, paint);
        return new e(createBitmap, com.bumptech.glide.c.c(context).f());
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        j.g(messageDigest, "messageDigest");
        messageDigest.update((byte) hashCode());
    }
}
