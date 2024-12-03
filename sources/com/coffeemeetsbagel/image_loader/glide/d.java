package com.coffeemeetsbagel.image_loader.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import y3.m;

public class d extends h {
    public d(@NonNull c cVar, @NonNull y3.h hVar, @NonNull m mVar, @NonNull Context context) {
        super(cVar, hVar, mVar, context);
    }

    @NonNull
    /* renamed from: D */
    public <ResourceType> c<ResourceType> e(@NonNull Class<ResourceType> cls) {
        return new c<>(this.f9200a, this, cls, this.f9201b);
    }

    @NonNull
    /* renamed from: E */
    public c<Bitmap> h() {
        return (c) super.h();
    }

    @NonNull
    /* renamed from: F */
    public c<Drawable> n() {
        return (c) super.n();
    }

    @NonNull
    /* renamed from: G */
    public c<w3.c> o() {
        return (c) super.o();
    }

    @NonNull
    /* renamed from: H */
    public c<Drawable> t(Integer num) {
        return (c) super.t(num);
    }

    @NonNull
    /* renamed from: I */
    public c<Drawable> u(String str) {
        return (c) super.u(str);
    }

    /* access modifiers changed from: protected */
    public void z(@NonNull b4.c cVar) {
        if (cVar instanceof b) {
            super.z(cVar);
        } else {
            super.z(new b().a(cVar));
        }
    }
}
