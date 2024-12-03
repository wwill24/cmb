package v2;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import c3.f;
import c3.j;
import com.airbnb.lottie.d0;
import java.io.IOException;
import java.util.Map;

public class b {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f18059e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Context f18060a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18061b;

    /* renamed from: c  reason: collision with root package name */
    private com.airbnb.lottie.b f18062c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, d0> f18063d;

    public b(Drawable.Callback callback, String str, com.airbnb.lottie.b bVar, Map<String, d0> map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.f18061b = str;
        } else {
            this.f18061b = str + '/';
        }
        this.f18063d = map;
        d(bVar);
        if (!(callback instanceof View)) {
            this.f18060a = null;
        } else {
            this.f18060a = ((View) callback).getContext().getApplicationContext();
        }
    }

    private Bitmap c(String str, Bitmap bitmap) {
        synchronized (f18059e) {
            this.f18063d.get(str).f(bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        d0 d0Var = this.f18063d.get(str);
        if (d0Var == null) {
            return null;
        }
        Bitmap a10 = d0Var.a();
        if (a10 != null) {
            return a10;
        }
        com.airbnb.lottie.b bVar = this.f18062c;
        if (bVar != null) {
            Bitmap a11 = bVar.a(d0Var);
            if (a11 != null) {
                c(str, a11);
            }
            return a11;
        }
        Context context = this.f18060a;
        if (context == null) {
            return null;
        }
        String b10 = d0Var.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!b10.startsWith("data:") || b10.indexOf("base64,") <= 0) {
            try {
                if (!TextUtils.isEmpty(this.f18061b)) {
                    AssetManager assets = context.getAssets();
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(assets.open(this.f18061b + b10), (Rect) null, options);
                        if (decodeStream != null) {
                            return c(str, j.l(decodeStream, d0Var.e(), d0Var.c()));
                        }
                        f.c("Decoded image `" + str + "` is null.");
                        return null;
                    } catch (IllegalArgumentException e10) {
                        f.d("Unable to decode image `" + str + "`.", e10);
                        return null;
                    }
                } else {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
            } catch (IOException e11) {
                f.d("Unable to open asset.", e11);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(b10.substring(b10.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e12) {
                f.d("data URL did not have correct base64 format.", e12);
                return null;
            }
        }
    }

    public boolean b(Context context) {
        return (context == null && this.f18060a == null) || this.f18060a.equals(context);
    }

    public void d(com.airbnb.lottie.b bVar) {
        this.f18062c = bVar;
    }
}
