package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.integration.okhttp3.a;
import com.coffeemeetsbagel.image_loader.glide.OkHttp3GlideModule;
import java.util.Collections;
import java.util.Set;

final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {

    /* renamed from: a  reason: collision with root package name */
    private final OkHttp3GlideModule f9132a = new OkHttp3GlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        Log.isLoggable("Glide", 3);
    }

    public void a(@NonNull Context context, @NonNull c cVar, @NonNull Registry registry) {
        new a().a(context, cVar, registry);
        this.f9132a.a(context, cVar, registry);
    }

    public void b(@NonNull Context context, @NonNull d dVar) {
        this.f9132a.b(context, dVar);
    }

    public boolean c() {
        return this.f9132a.c();
    }

    @NonNull
    public Set<Class<?>> d() {
        return Collections.emptySet();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: f */
    public a e() {
        return new a();
    }
}
