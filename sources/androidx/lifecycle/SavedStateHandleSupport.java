package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.i0;
import androidx.savedstate.a;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import m1.a;
import r1.d;

public final class SavedStateHandleSupport {

    /* renamed from: a  reason: collision with root package name */
    public static final a.b<d> f5977a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final a.b<l0> f5978b = new c();

    /* renamed from: c  reason: collision with root package name */
    public static final a.b<Bundle> f5979c = new a();

    public static final class a implements a.b<Bundle> {
        a() {
        }
    }

    public static final class b implements a.b<d> {
        b() {
        }
    }

    public static final class c implements a.b<l0> {
        c() {
        }
    }

    public static final a0 a(m1.a aVar) {
        j.g(aVar, "<this>");
        d dVar = (d) aVar.a(f5977a);
        if (dVar != null) {
            l0 l0Var = (l0) aVar.a(f5978b);
            if (l0Var != null) {
                Bundle bundle = (Bundle) aVar.a(f5979c);
                String str = (String) aVar.a(i0.c.f6045d);
                if (str != null) {
                    return b(dVar, l0Var, str, bundle);
                }
                throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            }
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    private static final a0 b(d dVar, l0 l0Var, String str, Bundle bundle) {
        SavedStateHandlesProvider d10 = d(dVar);
        b0 e10 = e(l0Var);
        a0 a0Var = e10.f().get(str);
        if (a0Var != null) {
            return a0Var;
        }
        a0 a10 = a0.f5992f.a(d10.b(str), bundle);
        e10.f().put(str, a10);
        return a10;
    }

    public static final <T extends d & l0> void c(T t10) {
        boolean z10;
        j.g(t10, "<this>");
        Lifecycle.State b10 = t10.getLifecycle().b();
        if (b10 == Lifecycle.State.INITIALIZED || b10 == Lifecycle.State.CREATED) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (t10.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(t10.getSavedStateRegistry(), (l0) t10);
            t10.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            t10.getLifecycle().a(new SavedStateHandleAttacher(savedStateHandlesProvider));
        }
    }

    public static final SavedStateHandlesProvider d(d dVar) {
        SavedStateHandlesProvider savedStateHandlesProvider;
        j.g(dVar, "<this>");
        a.c c10 = dVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        if (c10 instanceof SavedStateHandlesProvider) {
            savedStateHandlesProvider = (SavedStateHandlesProvider) c10;
        } else {
            savedStateHandlesProvider = null;
        }
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final b0 e(l0 l0Var) {
        Class cls = b0.class;
        j.g(l0Var, "<this>");
        m1.c cVar = new m1.c();
        cVar.a(l.b(cls), SavedStateHandleSupport$savedStateHandlesVM$1$1.f5980a);
        return (b0) new i0(l0Var, cVar.b()).b("androidx.lifecycle.internal.SavedStateHandlesVM", cls);
    }
}
