package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.lifecycle.Lifecycle;
import i.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public class n extends Lifecycle {

    /* renamed from: j  reason: collision with root package name */
    public static final a f6048j = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final boolean f6049b;

    /* renamed from: c  reason: collision with root package name */
    private j.a<k, b> f6050c;

    /* renamed from: d  reason: collision with root package name */
    private Lifecycle.State f6051d;

    /* renamed from: e  reason: collision with root package name */
    private final WeakReference<l> f6052e;

    /* renamed from: f  reason: collision with root package name */
    private int f6053f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6054g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6055h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<Lifecycle.State> f6056i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final n a(l lVar) {
            j.g(lVar, "owner");
            return new n(lVar, false, (DefaultConstructorMarker) null);
        }

        public final Lifecycle.State b(Lifecycle.State state, Lifecycle.State state2) {
            j.g(state, "state1");
            return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private Lifecycle.State f6057a;

        /* renamed from: b  reason: collision with root package name */
        private i f6058b;

        public b(k kVar, Lifecycle.State state) {
            j.g(state, "initialState");
            j.d(kVar);
            this.f6058b = q.f(kVar);
            this.f6057a = state;
        }

        public final void a(l lVar, Lifecycle.Event event) {
            j.g(event, "event");
            Lifecycle.State c10 = event.c();
            this.f6057a = n.f6048j.b(this.f6057a, c10);
            i iVar = this.f6058b;
            j.d(lVar);
            iVar.e(lVar, event);
            this.f6057a = c10;
        }

        public final Lifecycle.State b() {
            return this.f6057a;
        }
    }

    private n(l lVar, boolean z10) {
        this.f6049b = z10;
        this.f6050c = new j.a<>();
        this.f6051d = Lifecycle.State.INITIALIZED;
        this.f6056i = new ArrayList<>();
        this.f6052e = new WeakReference<>(lVar);
    }

    public /* synthetic */ n(l lVar, boolean z10, DefaultConstructorMarker defaultConstructorMarker) {
        this(lVar, z10);
    }

    private final void e(l lVar) {
        Iterator<Map.Entry<k, b>> descendingIterator = this.f6050c.descendingIterator();
        j.f(descendingIterator, "observerMap.descendingIterator()");
        while (descendingIterator.hasNext() && !this.f6055h) {
            Map.Entry next = descendingIterator.next();
            j.f(next, "next()");
            k kVar = (k) next.getKey();
            b bVar = (b) next.getValue();
            while (bVar.b().compareTo(this.f6051d) > 0 && !this.f6055h && this.f6050c.contains(kVar)) {
                Lifecycle.Event a10 = Lifecycle.Event.Companion.a(bVar.b());
                if (a10 != null) {
                    o(a10.c());
                    bVar.a(lVar, a10);
                    n();
                } else {
                    throw new IllegalStateException("no event down from " + bVar.b());
                }
            }
        }
    }

    private final Lifecycle.State f(k kVar) {
        Lifecycle.State state;
        b value;
        Map.Entry<k, b> n10 = this.f6050c.n(kVar);
        Lifecycle.State state2 = null;
        if (n10 == null || (value = n10.getValue()) == null) {
            state = null;
        } else {
            state = value.b();
        }
        if (!this.f6056i.isEmpty()) {
            ArrayList<Lifecycle.State> arrayList = this.f6056i;
            state2 = arrayList.get(arrayList.size() - 1);
        }
        a aVar = f6048j;
        return aVar.b(aVar.b(this.f6051d, state), state2);
    }

    public static final n g(l lVar) {
        return f6048j.a(lVar);
    }

    @SuppressLint({"RestrictedApi"})
    private final void h(String str) {
        if (this.f6049b && !c.g().b()) {
            throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
        }
    }

    private final void i(l lVar) {
        j.b<K, V>.d f10 = this.f6050c.f();
        j.f(f10, "observerMap.iteratorWithAdditions()");
        while (f10.hasNext() && !this.f6055h) {
            Map.Entry entry = (Map.Entry) f10.next();
            k kVar = (k) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f6051d) < 0 && !this.f6055h && this.f6050c.contains(kVar)) {
                o(bVar.b());
                Lifecycle.Event b10 = Lifecycle.Event.Companion.b(bVar.b());
                if (b10 != null) {
                    bVar.a(lVar, b10);
                    n();
                } else {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
            }
        }
    }

    private final boolean k() {
        if (this.f6050c.size() == 0) {
            return true;
        }
        Map.Entry<k, b> b10 = this.f6050c.b();
        j.d(b10);
        Lifecycle.State b11 = b10.getValue().b();
        Map.Entry<k, b> g10 = this.f6050c.g();
        j.d(g10);
        Lifecycle.State b12 = g10.getValue().b();
        if (b11 == b12 && this.f6051d == b12) {
            return true;
        }
        return false;
    }

    private final void m(Lifecycle.State state) {
        boolean z10;
        Lifecycle.State state2 = this.f6051d;
        if (state2 != state) {
            if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                this.f6051d = state;
                if (this.f6054g || this.f6053f != 0) {
                    this.f6055h = true;
                    return;
                }
                this.f6054g = true;
                q();
                this.f6054g = false;
                if (this.f6051d == Lifecycle.State.DESTROYED) {
                    this.f6050c = new j.a<>();
                    return;
                }
                return;
            }
            throw new IllegalStateException(("no event down from " + this.f6051d + " in component " + this.f6052e.get()).toString());
        }
    }

    private final void n() {
        ArrayList<Lifecycle.State> arrayList = this.f6056i;
        arrayList.remove(arrayList.size() - 1);
    }

    private final void o(Lifecycle.State state) {
        this.f6056i.add(state);
    }

    private final void q() {
        l lVar = this.f6052e.get();
        if (lVar != null) {
            while (!k()) {
                this.f6055h = false;
                Lifecycle.State state = this.f6051d;
                Map.Entry<k, b> b10 = this.f6050c.b();
                j.d(b10);
                if (state.compareTo(b10.getValue().b()) < 0) {
                    e(lVar);
                }
                Map.Entry<k, b> g10 = this.f6050c.g();
                if (!this.f6055h && g10 != null && this.f6051d.compareTo(g10.getValue().b()) > 0) {
                    i(lVar);
                }
            }
            this.f6055h = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
    }

    public void a(k kVar) {
        l lVar;
        boolean z10;
        j.g(kVar, "observer");
        h("addObserver");
        Lifecycle.State state = this.f6051d;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        b bVar = new b(kVar, state2);
        if (this.f6050c.j(kVar, bVar) == null && (lVar = this.f6052e.get()) != null) {
            if (this.f6053f != 0 || this.f6054g) {
                z10 = true;
            } else {
                z10 = false;
            }
            Lifecycle.State f10 = f(kVar);
            this.f6053f++;
            while (bVar.b().compareTo(f10) < 0 && this.f6050c.contains(kVar)) {
                o(bVar.b());
                Lifecycle.Event b10 = Lifecycle.Event.Companion.b(bVar.b());
                if (b10 != null) {
                    bVar.a(lVar, b10);
                    n();
                    f10 = f(kVar);
                } else {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
            }
            if (!z10) {
                q();
            }
            this.f6053f--;
        }
    }

    public Lifecycle.State b() {
        return this.f6051d;
    }

    public void d(k kVar) {
        j.g(kVar, "observer");
        h("removeObserver");
        this.f6050c.m(kVar);
    }

    public void j(Lifecycle.Event event) {
        j.g(event, "event");
        h("handleLifecycleEvent");
        m(event.c());
    }

    public void l(Lifecycle.State state) {
        j.g(state, "state");
        h("markState");
        p(state);
    }

    public void p(Lifecycle.State state) {
        j.g(state, "state");
        h("setCurrentState");
        m(state);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public n(l lVar) {
        this(lVar, true);
        j.g(lVar, "provider");
    }
}
