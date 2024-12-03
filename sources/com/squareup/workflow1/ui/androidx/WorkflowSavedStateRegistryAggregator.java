package com.squareup.workflow1.ui.androidx;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.l;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import ci.a;
import ci.c;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import gk.h;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import r1.d;

@Metadata(bv = {}, d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001$\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0017\u001a\u00020\u00042\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015R$\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0014\u0010'\u001a\u00020$8\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8BX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/squareup/workflow1/ui/androidx/WorkflowSavedStateRegistryAggregator;", "", "Lci/a;", "child", "", "n", "l", "Landroid/os/Bundle;", "o", "restoredState", "k", "", "key", "Lr1/d;", "parentOwner", "f", "g", "Landroid/view/View;", "view", "h", "m", "", "keysToKeep", "j", "", "a", "Ljava/util/Map;", "states", "b", "Lr1/d;", "parentRegistryOwner", "c", "Ljava/lang/String;", "parentKey", "d", "children", "com/squareup/workflow1/ui/androidx/WorkflowSavedStateRegistryAggregator$lifecycleObserver$1", "e", "Lcom/squareup/workflow1/ui/androidx/WorkflowSavedStateRegistryAggregator$lifecycleObserver$1;", "lifecycleObserver", "", "i", "()Z", "isRestored", "<init>", "()V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public final class WorkflowSavedStateRegistryAggregator {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Bundle> f23209a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public d f23210b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f23211c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, a> f23212d = new LinkedHashMap();

    /* renamed from: e  reason: collision with root package name */
    private final WorkflowSavedStateRegistryAggregator$lifecycleObserver$1 f23213e = new WorkflowSavedStateRegistryAggregator$lifecycleObserver$1(this);

    /* access modifiers changed from: private */
    public final boolean i() {
        return this.f23209a != null;
    }

    /* access modifiers changed from: private */
    public final void k(Bundle bundle) {
        boolean z10;
        Set<String> keySet;
        if (this.f23209a == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f23209a = new LinkedHashMap();
            if (!(bundle == null || (keySet = bundle.keySet()) == null)) {
                for (String str : keySet) {
                    Map<String, Bundle> map = this.f23209a;
                    j.d(map);
                    Bundle bundle2 = bundle.getBundle(str);
                    j.d(bundle2);
                    Pair a10 = h.a(str, bundle2);
                    map.put(a10.c(), a10.d());
                }
            }
            for (a aVar : this.f23212d.values()) {
                if (aVar.getLifecycle().b() == Lifecycle.State.INITIALIZED) {
                    l(aVar);
                }
            }
            return;
        }
        throw new IllegalStateException("Expected performRestore to be called only once.".toString());
    }

    private final void l(a aVar) {
        Map<String, Bundle> map = this.f23209a;
        if (map != null) {
            aVar.a().d(map.remove(aVar.b()));
        }
    }

    private final void n(a aVar) {
        Map<String, Bundle> map = this.f23209a;
        if (map != null) {
            Bundle bundle = new Bundle();
            aVar.a().e(bundle);
            Pair a10 = h.a(aVar.b(), bundle);
            map.put(a10.c(), a10.d());
        }
    }

    /* access modifiers changed from: private */
    public final Bundle o() {
        Bundle bundle = new Bundle();
        Map<String, Bundle> map = this.f23209a;
        if (map != null) {
            for (a n10 : this.f23212d.values()) {
                n(n10);
            }
            for (Map.Entry next : map.entrySet()) {
                bundle.putBundle((String) next.getKey(), (Bundle) next.getValue());
            }
        }
        return bundle;
    }

    public final void f(String str, d dVar) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(dVar, "parentOwner");
        g();
        this.f23210b = dVar;
        this.f23211c = str;
        if (!i()) {
            androidx.savedstate.a savedStateRegistry = dVar.getSavedStateRegistry();
            j.f(savedStateRegistry, "parentOwner.savedStateRegistry");
            Lifecycle lifecycle = dVar.getLifecycle();
            j.f(lifecycle, "parentOwner.lifecycle");
            try {
                savedStateRegistry.h(str, new c(this));
                lifecycle.a(this.f23213e);
            } catch (IllegalArgumentException e10) {
                throw new IllegalArgumentException("Error registering SavedStateProvider: key \"" + str + "\" is already in use on parent SavedStateRegistryOwner " + dVar + ".\nThis is most easily remedied by giving your container Screen rendering a unique Compatible.compatibilityKey, perhaps by wrapping it with Named.", e10);
            }
        }
    }

    public final void g() {
        Lifecycle lifecycle;
        androidx.savedstate.a savedStateRegistry;
        d dVar = this.f23210b;
        if (!(dVar == null || (savedStateRegistry = dVar.getSavedStateRegistry()) == null)) {
            String str = this.f23211c;
            j.d(str);
            savedStateRegistry.j(str);
        }
        d dVar2 = this.f23210b;
        if (!(dVar2 == null || (lifecycle = dVar2.getLifecycle()) == null)) {
            lifecycle.d(this.f23213e);
        }
        this.f23210b = null;
        this.f23211c = null;
    }

    public final void h(View view, String str) {
        j.g(view, "view");
        j.g(str, SDKConstants.PARAM_KEY);
        l a10 = ViewTreeLifecycleOwner.a(view);
        if (a10 != null) {
            a aVar = new a(str, a10);
            if (this.f23212d.put(str, aVar) == null) {
                d a11 = ViewTreeSavedStateRegistryOwner.a(view);
                if (a11 == null) {
                    ViewTreeSavedStateRegistryOwner.b(view, aVar);
                    l(aVar);
                    return;
                }
                throw new IllegalArgumentException(view + " already has ViewTreeSavedStateRegistryOwner: " + a11);
            }
            throw new IllegalArgumentException(str + " is already in use, it cannot be used to register " + view);
        }
        throw new IllegalArgumentException(("Expected " + view + PropertyUtils.MAPPED_DELIM + str + ") to have a ViewTreeLifecycleOwner. Use WorkflowLifecycleOwner to fix that.").toString());
    }

    public final void j(Collection<String> collection) {
        j.g(collection, "keysToKeep");
        for (String remove : o0.j(this.f23212d.keySet(), collection)) {
            this.f23212d.remove(remove);
        }
        Map<String, Bundle> map = this.f23209a;
        if (map != null) {
            boolean unused = v.A(map.keySet(), o0.j(map.keySet(), collection));
        }
    }

    public final void m(String str) {
        Unit unit;
        j.g(str, SDKConstants.PARAM_KEY);
        a remove = this.f23212d.remove(str);
        if (remove == null) {
            unit = null;
        } else {
            n(remove);
            unit = Unit.f32013a;
        }
        if (unit == null) {
            throw new IllegalArgumentException(j.p("No such child: ", str));
        }
    }
}
