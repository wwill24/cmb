package x9;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.mparticle.identity.IdentityHttpResponse;
import i3.h;
import java.security.MessageDigest;
import kotlin.jvm.internal.j;
import l3.c;
import org.apache.commons.beanutils.PropertyUtils;
import s3.e;

public final class a implements h<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    private final double f18570b;

    /* renamed from: c  reason: collision with root package name */
    private final float f18571c;

    /* renamed from: d  reason: collision with root package name */
    private final RenderScript f18572d;

    public a(double d10, float f10, RenderScript renderScript) {
        j.g(renderScript, "renderScript");
        this.f18570b = d10;
        this.f18571c = f10;
        this.f18572d = renderScript;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Double.compare(this.f18570b, aVar.f18570b) == 0 && Float.compare(this.f18571c, aVar.f18571c) == 0 && j.b(this.f18572d, aVar.f18572d);
    }

    public int hashCode() {
        return (((Double.hashCode(this.f18570b) * 31) + Float.hashCode(this.f18571c)) * 31) + this.f18572d.hashCode();
    }

    public String toString() {
        return "GlideTransformBlurred(downSample=" + this.f18570b + ", radius=" + this.f18571c + ", renderScript=" + this.f18572d + PropertyUtils.MAPPED_DELIM2;
    }

    public c<Bitmap> transform(Context context, c<Bitmap> cVar, int i10, int i11) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(cVar, "resource");
        Bitmap bitmap = cVar.get();
        j.f(bitmap, "resource.get()");
        Bitmap bitmap2 = bitmap;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, (int) (((double) bitmap2.getWidth()) / this.f18570b), (int) (((double) bitmap2.getHeight()) / this.f18570b), false);
        j.f(createScaledBitmap, "createScaledBitmap(sourc…),\n                false)");
        Allocation createFromBitmap = Allocation.createFromBitmap(this.f18572d, createScaledBitmap, Allocation.MipmapControl.MIPMAP_FULL, 128);
        j.f(createFromBitmap, "createFromBitmap(renderS… Allocation.USAGE_SHARED)");
        Allocation createTyped = Allocation.createTyped(this.f18572d, createFromBitmap.getType());
        j.f(createTyped, "createTyped(renderScript, input.type)");
        Element U8_4 = Element.U8_4(this.f18572d);
        j.f(U8_4, "U8_4(renderScript)");
        ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(this.f18572d, U8_4);
        create.setRadius(this.f18571c);
        create.setInput(createFromBitmap);
        create.forEach(createTyped);
        createTyped.copyTo(createScaledBitmap);
        return new e(createScaledBitmap, com.bumptech.glide.c.c(context).f());
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        j.g(messageDigest, "messageDigest");
        messageDigest.update((byte) hashCode());
    }
}
