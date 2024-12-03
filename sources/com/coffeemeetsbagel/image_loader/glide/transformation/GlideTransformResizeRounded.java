package com.coffeemeetsbagel.image_loader.glide.transformation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Keep;
import com.mparticle.identity.IdentityHttpResponse;
import i3.h;
import java.security.MessageDigest;
import kotlin.jvm.internal.j;
import l3.c;
import org.apache.commons.beanutils.PropertyUtils;
import s3.e;

@Keep
public final class GlideTransformResizeRounded implements h<Bitmap> {
    private final int margin;
    private final int radius;
    private final int targetWidth;

    public GlideTransformResizeRounded(int i10, int i11, int i12) {
        this.radius = i10;
        this.margin = i11;
        this.targetWidth = i12;
    }

    private final int component1() {
        return this.radius;
    }

    private final int component2() {
        return this.margin;
    }

    private final int component3() {
        return this.targetWidth;
    }

    public static /* synthetic */ GlideTransformResizeRounded copy$default(GlideTransformResizeRounded glideTransformResizeRounded, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = glideTransformResizeRounded.radius;
        }
        if ((i13 & 2) != 0) {
            i11 = glideTransformResizeRounded.margin;
        }
        if ((i13 & 4) != 0) {
            i12 = glideTransformResizeRounded.targetWidth;
        }
        return glideTransformResizeRounded.copy(i10, i11, i12);
    }

    public final GlideTransformResizeRounded copy(int i10, int i11, int i12) {
        return new GlideTransformResizeRounded(i10, i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlideTransformResizeRounded)) {
            return false;
        }
        GlideTransformResizeRounded glideTransformResizeRounded = (GlideTransformResizeRounded) obj;
        return this.radius == glideTransformResizeRounded.radius && this.margin == glideTransformResizeRounded.margin && this.targetWidth == glideTransformResizeRounded.targetWidth;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.radius) * 31) + Integer.hashCode(this.margin)) * 31) + Integer.hashCode(this.targetWidth);
    }

    public String toString() {
        return "GlideTransformResizeRounded(radius=" + this.radius + ", margin=" + this.margin + ", targetWidth=" + this.targetWidth + PropertyUtils.MAPPED_DELIM2;
    }

    public c<Bitmap> transform(Context context, c<Bitmap> cVar, int i10, int i11) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(cVar, "resource");
        Bitmap bitmap = cVar.get();
        j.f(bitmap, "resource.get()");
        Bitmap bitmap2 = bitmap;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        double height = ((double) bitmap2.getHeight()) / ((double) bitmap2.getWidth());
        int i12 = this.targetWidth;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, i12, (int) (((double) i12) * height), false);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(createScaledBitmap, tileMode, tileMode));
        Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap.getWidth(), createScaledBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int i13 = this.margin;
        RectF rectF = new RectF((float) i13, (float) i13, (float) (createScaledBitmap.getWidth() - this.margin), (float) (createScaledBitmap.getHeight() - this.margin));
        int i14 = this.radius;
        canvas.drawRoundRect(rectF, (float) i14, (float) i14, paint);
        return new e(createBitmap, com.bumptech.glide.c.c(context).f());
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        j.g(messageDigest, "messageDigest");
        messageDigest.update((byte) hashCode());
    }
}
