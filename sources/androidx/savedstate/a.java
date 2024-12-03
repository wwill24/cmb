package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.l;
import androidx.savedstate.Recreator;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import r1.d;

@SuppressLint({"RestrictedApi"})
public final class a {

    /* renamed from: g  reason: collision with root package name */
    private static final b f6977g = new b((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final j.b<String, c> f6978a = new j.b<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f6979b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f6980c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6981d;

    /* renamed from: e  reason: collision with root package name */
    private Recreator.b f6982e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6983f = true;

    /* renamed from: androidx.savedstate.a$a  reason: collision with other inner class name */
    public interface C0077a {
        void a(d dVar);
    }

    private static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface c {
        Bundle a();
    }

    /* access modifiers changed from: private */
    public static final void d(a aVar, l lVar, Lifecycle.Event event) {
        j.g(aVar, "this$0");
        j.g(lVar, "<anonymous parameter 0>");
        j.g(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            aVar.f6983f = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            aVar.f6983f = false;
        }
    }

    public final Bundle b(String str) {
        Bundle bundle;
        j.g(str, SDKConstants.PARAM_KEY);
        if (this.f6981d) {
            Bundle bundle2 = this.f6980c;
            if (bundle2 == null) {
                return null;
            }
            if (bundle2 != null) {
                bundle = bundle2.getBundle(str);
            } else {
                bundle = null;
            }
            Bundle bundle3 = this.f6980c;
            if (bundle3 != null) {
                bundle3.remove(str);
            }
            Bundle bundle4 = this.f6980c;
            boolean z10 = false;
            if (bundle4 != null && !bundle4.isEmpty()) {
                z10 = true;
            }
            if (!z10) {
                this.f6980c = null;
            }
            return bundle;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    public final c c(String str) {
        j.g(str, SDKConstants.PARAM_KEY);
        Iterator<Map.Entry<String, c>> it = this.f6978a.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            j.f(next, "components");
            c cVar = (c) next.getValue();
            if (j.b((String) next.getKey(), str)) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(Lifecycle lifecycle) {
        j.g(lifecycle, "lifecycle");
        if (!this.f6979b) {
            lifecycle.a(new r1.b(this));
            this.f6979b = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
    }

    public final void f(Bundle bundle) {
        Bundle bundle2;
        if (!this.f6979b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        } else if (!this.f6981d) {
            if (bundle != null) {
                bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            } else {
                bundle2 = null;
            }
            this.f6980c = bundle2;
            this.f6981d = true;
        } else {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
    }

    public final void g(Bundle bundle) {
        j.g(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f6980c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        j.b<K, V>.d f10 = this.f6978a.f();
        j.f(f10, "this.components.iteratorWithAdditions()");
        while (f10.hasNext()) {
            Map.Entry entry = (Map.Entry) f10.next();
            bundle2.putBundle((String) entry.getKey(), ((c) entry.getValue()).a());
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
        }
    }

    public final void h(String str, c cVar) {
        boolean z10;
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(cVar, "provider");
        if (this.f6978a.j(str, cVar) == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void i(Class<? extends C0077a> cls) {
        j.g(cls, "clazz");
        if (this.f6983f) {
            Recreator.b bVar = this.f6982e;
            if (bVar == null) {
                bVar = new Recreator.b(this);
            }
            this.f6982e = bVar;
            try {
                cls.getDeclaredConstructor(new Class[0]);
                Recreator.b bVar2 = this.f6982e;
                if (bVar2 != null) {
                    String name = cls.getName();
                    j.f(name, "clazz.name");
                    bVar2.b(name);
                }
            } catch (NoSuchMethodException e10) {
                throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
    }

    public final void j(String str) {
        j.g(str, SDKConstants.PARAM_KEY);
        this.f6978a.m(str);
    }
}
