package com.coffeemeetsbagel.image_loader.glide;

import android.content.Context;
import com.bumptech.glide.Registry;
import com.bumptech.glide.c;
import com.bumptech.glide.integration.okhttp3.b;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.mparticle.identity.IdentityHttpResponse;
import java.io.InputStream;
import kotlin.jvm.internal.j;
import okhttp3.x;
import p3.g;
import z3.a;

public final class OkHttp3GlideModule extends a {
    public void a(Context context, c cVar, Registry registry) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(cVar, "glide");
        j.g(registry, "registry");
        registry.r(g.class, InputStream.class, new b.a(new x.a().b(new StethoInterceptor()).c()));
    }
}
