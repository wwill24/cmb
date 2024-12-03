package xh;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class b {
    public static final /* synthetic */ int a(Drawable drawable) {
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return 0;
    }

    public static final /* synthetic */ int d(Drawable drawable) {
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return 0;
    }

    public static final /* synthetic */ boolean e(Drawable[] drawableArr) {
        j.g(drawableArr, "<this>");
        return (drawableArr[0] == null && drawableArr[2] == null) ? false : true;
    }

    public static final /* synthetic */ Drawable f(Drawable drawable, Context context, Integer num, Integer num2) {
        j.g(drawable, "<this>");
        j.g(context, IdentityHttpResponse.CONTEXT);
        if (num == null || num2 == null) {
            return drawable;
        }
        Bitmap createBitmap = Bitmap.createBitmap(num.intValue(), num2.intValue(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, num.intValue(), num2.intValue());
        drawable.draw(canvas);
        return new BitmapDrawable(context.getResources(), createBitmap);
    }

    public static final /* synthetic */ Drawable g(Drawable drawable, Integer num) {
        j.g(drawable, "<this>");
        if (num != null) {
            a.o(a.r(drawable), ColorStateList.valueOf(num.intValue()));
        }
        return drawable;
    }
}
