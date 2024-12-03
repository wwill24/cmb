package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.os.e;
import androidx.core.view.n0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

abstract class SpecialEffectsController {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f5699a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<Operation> f5700b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<Operation> f5701c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    boolean f5702d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f5703e = false;

    static class Operation {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private State f5704a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private LifecycleImpact f5705b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private final Fragment f5706c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private final List<Runnable> f5707d = new ArrayList();
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        private final HashSet<e> f5708e = new HashSet<>();

        /* renamed from: f  reason: collision with root package name */
        private boolean f5709f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f5710g = false;

        enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            @NonNull
            static State b(int i10) {
                if (i10 == 0) {
                    return VISIBLE;
                }
                if (i10 == 4) {
                    return INVISIBLE;
                }
                if (i10 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i10);
            }

            @NonNull
            static State c(@NonNull View view) {
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    return INVISIBLE;
                }
                return b(view.getVisibility());
            }

            /* access modifiers changed from: package-private */
            public void a(@NonNull View view) {
                int i10 = c.f5725a[ordinal()];
                if (i10 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.J0(2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("SpecialEffectsController: Removing view ");
                            sb2.append(view);
                            sb2.append(" from container ");
                            sb2.append(viewGroup);
                        }
                        viewGroup.removeView(view);
                    }
                } else if (i10 == 2) {
                    if (FragmentManager.J0(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("SpecialEffectsController: Setting view ");
                        sb3.append(view);
                        sb3.append(" to VISIBLE");
                    }
                    view.setVisibility(0);
                } else if (i10 == 3) {
                    if (FragmentManager.J0(2)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("SpecialEffectsController: Setting view ");
                        sb4.append(view);
                        sb4.append(" to GONE");
                    }
                    view.setVisibility(8);
                } else if (i10 == 4) {
                    if (FragmentManager.J0(2)) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("SpecialEffectsController: Setting view ");
                        sb5.append(view);
                        sb5.append(" to INVISIBLE");
                    }
                    view.setVisibility(4);
                }
            }
        }

        class a implements e.b {
            a() {
            }

            public void onCancel() {
                Operation.this.b();
            }
        }

        Operation(@NonNull State state, @NonNull LifecycleImpact lifecycleImpact, @NonNull Fragment fragment, @NonNull e eVar) {
            this.f5704a = state;
            this.f5705b = lifecycleImpact;
            this.f5706c = fragment;
            eVar.b(new a());
        }

        /* access modifiers changed from: package-private */
        public final void a(@NonNull Runnable runnable) {
            this.f5707d.add(runnable);
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            if (!h()) {
                this.f5709f = true;
                if (this.f5708e.isEmpty()) {
                    c();
                    return;
                }
                Iterator it = new ArrayList(this.f5708e).iterator();
                while (it.hasNext()) {
                    ((e) it.next()).a();
                }
            }
        }

        public void c() {
            if (!this.f5710g) {
                if (FragmentManager.J0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    sb2.append(this);
                    sb2.append(" has called complete.");
                }
                this.f5710g = true;
                for (Runnable run : this.f5707d) {
                    run.run();
                }
            }
        }

        public final void d(@NonNull e eVar) {
            if (this.f5708e.remove(eVar) && this.f5708e.isEmpty()) {
                c();
            }
        }

        @NonNull
        public State e() {
            return this.f5704a;
        }

        @NonNull
        public final Fragment f() {
            return this.f5706c;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public LifecycleImpact g() {
            return this.f5705b;
        }

        /* access modifiers changed from: package-private */
        public final boolean h() {
            return this.f5709f;
        }

        /* access modifiers changed from: package-private */
        public final boolean i() {
            return this.f5710g;
        }

        public final void j(@NonNull e eVar) {
            l();
            this.f5708e.add(eVar);
        }

        /* access modifiers changed from: package-private */
        public final void k(@NonNull State state, @NonNull LifecycleImpact lifecycleImpact) {
            int i10 = c.f5726b[lifecycleImpact.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    if (FragmentManager.J0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: For fragment ");
                        sb2.append(this.f5706c);
                        sb2.append(" mFinalState = ");
                        sb2.append(this.f5704a);
                        sb2.append(" -> REMOVED. mLifecycleImpact  = ");
                        sb2.append(this.f5705b);
                        sb2.append(" to REMOVING.");
                    }
                    this.f5704a = State.REMOVED;
                    this.f5705b = LifecycleImpact.REMOVING;
                } else if (i10 == 3 && this.f5704a != State.REMOVED) {
                    if (FragmentManager.J0(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("SpecialEffectsController: For fragment ");
                        sb3.append(this.f5706c);
                        sb3.append(" mFinalState = ");
                        sb3.append(this.f5704a);
                        sb3.append(" -> ");
                        sb3.append(state);
                        sb3.append(". ");
                    }
                    this.f5704a = state;
                }
            } else if (this.f5704a == State.REMOVED) {
                if (FragmentManager.J0(2)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("SpecialEffectsController: For fragment ");
                    sb4.append(this.f5706c);
                    sb4.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                    sb4.append(this.f5705b);
                    sb4.append(" to ADDING.");
                }
                this.f5704a = State.VISIBLE;
                this.f5705b = LifecycleImpact.ADDING;
            }
        }

        /* access modifiers changed from: package-private */
        public void l() {
        }

        @NonNull
        public String toString() {
            return "Operation " + "{" + Integer.toHexString(System.identityHashCode(this)) + "} " + "{" + "mFinalState = " + this.f5704a + "} " + "{" + "mLifecycleImpact = " + this.f5705b + "} " + "{" + "mFragment = " + this.f5706c + "}";
        }
    }

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f5721a;

        a(d dVar) {
            this.f5721a = dVar;
        }

        public void run() {
            if (SpecialEffectsController.this.f5700b.contains(this.f5721a)) {
                this.f5721a.e().a(this.f5721a.f().mView);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f5723a;

        b(d dVar) {
            this.f5723a = dVar;
        }

        public void run() {
            SpecialEffectsController.this.f5700b.remove(this.f5723a);
            SpecialEffectsController.this.f5701c.remove(this.f5723a);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5725a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f5726b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        static {
            /*
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5726b = r0
                r1 = 1
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r2 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.ADDING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f5726b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r3 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.REMOVING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f5726b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r4 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.NONE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                androidx.fragment.app.SpecialEffectsController$Operation$State[] r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f5725a = r3
                androidx.fragment.app.SpecialEffectsController$Operation$State r4 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f5725a     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f5725a     // Catch:{ NoSuchFieldError -> 0x004d }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f5725a     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.c.<clinit>():void");
        }
    }

    private static class d extends Operation {
        @NonNull

        /* renamed from: h  reason: collision with root package name */
        private final z f5727h;

        d(@NonNull Operation.State state, @NonNull Operation.LifecycleImpact lifecycleImpact, @NonNull z zVar, @NonNull e eVar) {
            super(state, lifecycleImpact, zVar.k(), eVar);
            this.f5727h = zVar;
        }

        public void c() {
            super.c();
            this.f5727h.m();
        }

        /* access modifiers changed from: package-private */
        public void l() {
            if (g() == Operation.LifecycleImpact.ADDING) {
                Fragment k10 = this.f5727h.k();
                View findFocus = k10.mView.findFocus();
                if (findFocus != null) {
                    k10.setFocusedView(findFocus);
                    if (FragmentManager.J0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("requestFocus: Saved focused view ");
                        sb2.append(findFocus);
                        sb2.append(" for Fragment ");
                        sb2.append(k10);
                    }
                }
                View requireView = f().requireView();
                if (requireView.getParent() == null) {
                    this.f5727h.b();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(k10.getPostOnViewCreatedAlpha());
            } else if (g() == Operation.LifecycleImpact.REMOVING) {
                Fragment k11 = this.f5727h.k();
                View requireView2 = k11.requireView();
                if (FragmentManager.J0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Clearing focus ");
                    sb3.append(requireView2.findFocus());
                    sb3.append(" on view ");
                    sb3.append(requireView2);
                    sb3.append(" for Fragment ");
                    sb3.append(k11);
                }
                requireView2.clearFocus();
            }
        }
    }

    SpecialEffectsController(@NonNull ViewGroup viewGroup) {
        this.f5699a = viewGroup;
    }

    private void a(@NonNull Operation.State state, @NonNull Operation.LifecycleImpact lifecycleImpact, @NonNull z zVar) {
        synchronized (this.f5700b) {
            e eVar = new e();
            Operation h10 = h(zVar.k());
            if (h10 != null) {
                h10.k(state, lifecycleImpact);
                return;
            }
            d dVar = new d(state, lifecycleImpact, zVar, eVar);
            this.f5700b.add(dVar);
            dVar.a(new a(dVar));
            dVar.a(new b(dVar));
        }
    }

    private Operation h(@NonNull Fragment fragment) {
        Iterator<Operation> it = this.f5700b.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    private Operation i(@NonNull Fragment fragment) {
        Iterator<Operation> it = this.f5701c.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    @NonNull
    static SpecialEffectsController n(@NonNull ViewGroup viewGroup, @NonNull FragmentManager fragmentManager) {
        return o(viewGroup, fragmentManager.B0());
    }

    @NonNull
    static SpecialEffectsController o(@NonNull ViewGroup viewGroup, @NonNull h0 h0Var) {
        int i10 = h1.b.special_effects_controller_view_tag;
        Object tag = viewGroup.getTag(i10);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController a10 = h0Var.a(viewGroup);
        viewGroup.setTag(i10, a10);
        return a10;
    }

    private void q() {
        Iterator<Operation> it = this.f5700b.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.g() == Operation.LifecycleImpact.ADDING) {
                next.k(Operation.State.b(next.f().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(@NonNull Operation.State state, @NonNull z zVar) {
        if (FragmentManager.J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SpecialEffectsController: Enqueuing add operation for fragment ");
            sb2.append(zVar.k());
        }
        a(state, Operation.LifecycleImpact.ADDING, zVar);
    }

    /* access modifiers changed from: package-private */
    public void c(@NonNull z zVar) {
        if (FragmentManager.J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SpecialEffectsController: Enqueuing hide operation for fragment ");
            sb2.append(zVar.k());
        }
        a(Operation.State.GONE, Operation.LifecycleImpact.NONE, zVar);
    }

    /* access modifiers changed from: package-private */
    public void d(@NonNull z zVar) {
        if (FragmentManager.J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SpecialEffectsController: Enqueuing remove operation for fragment ");
            sb2.append(zVar.k());
        }
        a(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, zVar);
    }

    /* access modifiers changed from: package-private */
    public void e(@NonNull z zVar) {
        if (FragmentManager.J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SpecialEffectsController: Enqueuing show operation for fragment ");
            sb2.append(zVar.k());
        }
        a(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, zVar);
    }

    /* access modifiers changed from: package-private */
    public abstract void f(@NonNull List<Operation> list, boolean z10);

    /* access modifiers changed from: package-private */
    public void g() {
        if (!this.f5703e) {
            if (!n0.V(this.f5699a)) {
                j();
                this.f5702d = false;
                return;
            }
            synchronized (this.f5700b) {
                if (!this.f5700b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f5701c);
                    this.f5701c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Operation operation = (Operation) it.next();
                        if (FragmentManager.J0(2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("SpecialEffectsController: Cancelling operation ");
                            sb2.append(operation);
                        }
                        operation.b();
                        if (!operation.i()) {
                            this.f5701c.add(operation);
                        }
                    }
                    q();
                    ArrayList arrayList2 = new ArrayList(this.f5700b);
                    this.f5700b.clear();
                    this.f5701c.addAll(arrayList2);
                    boolean J0 = FragmentManager.J0(2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((Operation) it2.next()).l();
                    }
                    f(arrayList2, this.f5702d);
                    this.f5702d = false;
                    boolean J02 = FragmentManager.J0(2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        String str;
        String str2;
        FragmentManager.J0(2);
        boolean V = n0.V(this.f5699a);
        synchronized (this.f5700b) {
            q();
            Iterator<Operation> it = this.f5700b.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
            Iterator it2 = new ArrayList(this.f5701c).iterator();
            while (it2.hasNext()) {
                Operation operation = (Operation) it2.next();
                if (FragmentManager.J0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (V) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f5699a + " is not attached to window. ";
                    }
                    sb2.append(str2);
                    sb2.append("Cancelling running operation ");
                    sb2.append(operation);
                }
                operation.b();
            }
            Iterator it3 = new ArrayList(this.f5700b).iterator();
            while (it3.hasNext()) {
                Operation operation2 = (Operation) it3.next();
                if (FragmentManager.J0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("SpecialEffectsController: ");
                    if (V) {
                        str = "";
                    } else {
                        str = "Container " + this.f5699a + " is not attached to window. ";
                    }
                    sb3.append(str);
                    sb3.append("Cancelling pending operation ");
                    sb3.append(operation2);
                }
                operation2.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        if (this.f5703e) {
            FragmentManager.J0(2);
            this.f5703e = false;
            g();
        }
    }

    /* access modifiers changed from: package-private */
    public Operation.LifecycleImpact l(@NonNull z zVar) {
        Operation.LifecycleImpact lifecycleImpact;
        Operation h10 = h(zVar.k());
        if (h10 != null) {
            lifecycleImpact = h10.g();
        } else {
            lifecycleImpact = null;
        }
        Operation i10 = i(zVar.k());
        if (i10 == null || (lifecycleImpact != null && lifecycleImpact != Operation.LifecycleImpact.NONE)) {
            return lifecycleImpact;
        }
        return i10.g();
    }

    @NonNull
    public ViewGroup m() {
        return this.f5699a;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        synchronized (this.f5700b) {
            q();
            this.f5703e = false;
            int size = this.f5700b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Operation operation = this.f5700b.get(size);
                Operation.State c10 = Operation.State.c(operation.f().mView);
                Operation.State e10 = operation.e();
                Operation.State state = Operation.State.VISIBLE;
                if (e10 == state && c10 != state) {
                    this.f5703e = operation.f().isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(boolean z10) {
        this.f5702d = z10;
    }
}
