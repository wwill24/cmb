package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.c0;
import androidx.lifecycle.f;
import androidx.lifecycle.i0;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import androidx.lifecycle.n;
import m1.a;
import r1.c;
import r1.d;

class f0 implements f, d, l0 {

    /* renamed from: a  reason: collision with root package name */
    private final Fragment f5843a;

    /* renamed from: b  reason: collision with root package name */
    private final k0 f5844b;

    /* renamed from: c  reason: collision with root package name */
    private i0.b f5845c;

    /* renamed from: d  reason: collision with root package name */
    private n f5846d = null;

    /* renamed from: e  reason: collision with root package name */
    private c f5847e = null;

    f0(@NonNull Fragment fragment, @NonNull k0 k0Var) {
        this.f5843a = fragment;
        this.f5844b = k0Var;
    }

    /* access modifiers changed from: package-private */
    public void a(@NonNull Lifecycle.Event event) {
        this.f5846d.j(event);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f5846d == null) {
            this.f5846d = new n(this);
            c a10 = c.a(this);
            this.f5847e = a10;
            a10.c();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.f5846d != null;
    }

    /* access modifiers changed from: package-private */
    public void d(Bundle bundle) {
        this.f5847e.d(bundle);
    }

    /* access modifiers changed from: package-private */
    public void e(@NonNull Bundle bundle) {
        this.f5847e.e(bundle);
    }

    /* access modifiers changed from: package-private */
    public void f(@NonNull Lifecycle.State state) {
        this.f5846d.p(state);
    }

    @NonNull
    public a getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = this.f5843a.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            } else if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            } else {
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
        }
        m1.d dVar = new m1.d();
        if (application != null) {
            dVar.c(i0.a.f6038h, application);
        }
        dVar.c(SavedStateHandleSupport.f5977a, this.f5843a);
        dVar.c(SavedStateHandleSupport.f5978b, this);
        if (this.f5843a.getArguments() != null) {
            dVar.c(SavedStateHandleSupport.f5979c, this.f5843a.getArguments());
        }
        return dVar;
    }

    @NonNull
    public i0.b getDefaultViewModelProviderFactory() {
        i0.b defaultViewModelProviderFactory = this.f5843a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.f5843a.mDefaultFactory)) {
            this.f5845c = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f5845c == null) {
            Application application = null;
            Context context = this.f5843a.requireContext().getApplicationContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                } else if (context instanceof Application) {
                    application = (Application) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            Fragment fragment = this.f5843a;
            this.f5845c = new c0(application, fragment, fragment.getArguments());
        }
        return this.f5845c;
    }

    @NonNull
    public Lifecycle getLifecycle() {
        b();
        return this.f5846d;
    }

    @NonNull
    public androidx.savedstate.a getSavedStateRegistry() {
        b();
        return this.f5847e.b();
    }

    @NonNull
    public k0 getViewModelStore() {
        b();
        return this.f5844b;
    }
}
