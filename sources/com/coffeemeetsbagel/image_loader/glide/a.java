package com.coffeemeetsbagel.image_loader.glide;

import android.widget.ImageView;
import com.bumptech.glide.g;
import com.coffeemeetsbagel.image_loader.glide.GlideImageLoader;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f13982a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GlideImageLoader.c f13983b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageView f13984c;

    public /* synthetic */ a(g gVar, GlideImageLoader.c cVar, ImageView imageView) {
        this.f13982a = gVar;
        this.f13983b = cVar;
        this.f13984c = imageView;
    }

    public final void run() {
        GlideImageLoader.h(this.f13982a, this.f13983b, this.f13984c);
    }
}
