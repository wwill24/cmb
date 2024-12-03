package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentRuntime;
import com.google.mlkit.common.internal.MlKitComponentDiscoveryService;

public class i {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f21406b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static i f21407c;

    /* renamed from: a  reason: collision with root package name */
    private ComponentRuntime f21408a;

    private i() {
    }

    @NonNull
    public static i c() {
        boolean z10;
        i iVar;
        synchronized (f21406b) {
            if (f21407c != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            p.p(z10, "MlKitContext has not been initialized");
            iVar = (i) p.k(f21407c);
        }
        return iVar;
    }

    @NonNull
    public static i d(@NonNull Context context) {
        boolean z10;
        i iVar;
        synchronized (f21406b) {
            if (f21407c == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            p.p(z10, "MlKitContext is already initialized");
            i iVar2 = new i();
            f21407c = iVar2;
            Context e10 = e(context);
            ComponentRuntime build = ComponentRuntime.builder(TaskExecutors.MAIN_THREAD).addLazyComponentRegistrars(ComponentDiscovery.forContext(e10, MlKitComponentDiscoveryService.class).discoverLazy()).addComponent(Component.of(e10, Context.class, (Class<? super T>[]) new Class[0])).addComponent(Component.of(iVar2, i.class, (Class<? super T>[]) new Class[0])).build();
            iVar2.f21408a = build;
            build.initializeEagerComponents(true);
            iVar = f21407c;
        }
        return iVar;
    }

    private static Context e(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    @NonNull
    public <T> T a(@NonNull Class<T> cls) {
        boolean z10;
        if (f21407c == this) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.p(z10, "MlKitContext has been deleted");
        p.k(this.f21408a);
        return this.f21408a.get(cls);
    }

    @NonNull
    public Context b() {
        return (Context) a(Context.class);
    }
}
