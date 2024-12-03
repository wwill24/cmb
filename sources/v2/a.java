package v2;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import c3.f;
import java.util.HashMap;
import java.util.Map;
import w2.b;
import w2.h;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final h<String> f18054a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<h<String>, Typeface> f18055b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Typeface> f18056c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final AssetManager f18057d;

    /* renamed from: e  reason: collision with root package name */
    private String f18058e = ".ttf";

    public a(Drawable.Callback callback, com.airbnb.lottie.a aVar) {
        if (!(callback instanceof View)) {
            f.c("LottieDrawable must be inside of a view for images to work.");
            this.f18057d = null;
            return;
        }
        this.f18057d = ((View) callback).getContext().getAssets();
    }

    private Typeface a(b bVar) {
        String a10 = bVar.a();
        Typeface typeface = this.f18056c.get(a10);
        if (typeface != null) {
            return typeface;
        }
        bVar.c();
        bVar.b();
        if (bVar.d() != null) {
            return bVar.d();
        }
        Typeface createFromAsset = Typeface.createFromAsset(this.f18057d, "fonts/" + a10 + this.f18058e);
        this.f18056c.put(a10, createFromAsset);
        return createFromAsset;
    }

    private Typeface e(Typeface typeface, String str) {
        int i10;
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        if (contains && contains2) {
            i10 = 3;
        } else if (contains) {
            i10 = 2;
        } else if (contains2) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        if (typeface.getStyle() == i10) {
            return typeface;
        }
        return Typeface.create(typeface, i10);
    }

    public Typeface b(b bVar) {
        this.f18054a.b(bVar.a(), bVar.c());
        Typeface typeface = this.f18055b.get(this.f18054a);
        if (typeface != null) {
            return typeface;
        }
        Typeface e10 = e(a(bVar), bVar.c());
        this.f18055b.put(this.f18054a, e10);
        return e10;
    }

    public void c(String str) {
        this.f18058e = str;
    }

    public void d(com.airbnb.lottie.a aVar) {
    }
}
