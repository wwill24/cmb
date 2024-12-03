package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.core.os.e;
import androidx.core.view.b2;
import androidx.core.view.k0;
import androidx.core.view.n0;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class b extends SpecialEffectsController {

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5736a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.fragment.app.SpecialEffectsController$Operation$State[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5736a = r0
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5736a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5736a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5736a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.b.a.<clinit>():void");
        }
    }

    /* renamed from: androidx.fragment.app.b$b  reason: collision with other inner class name */
    class C0058b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f5737a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SpecialEffectsController.Operation f5738b;

        C0058b(List list, SpecialEffectsController.Operation operation) {
            this.f5737a = list;
            this.f5738b = operation;
        }

        public void run() {
            if (this.f5737a.contains(this.f5738b)) {
                this.f5737a.remove(this.f5738b);
                b.this.s(this.f5738b);
            }
        }
    }

    class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f5740a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f5741b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f5742c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SpecialEffectsController.Operation f5743d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ k f5744e;

        c(ViewGroup viewGroup, View view, boolean z10, SpecialEffectsController.Operation operation, k kVar) {
            this.f5740a = viewGroup;
            this.f5741b = view;
            this.f5742c = z10;
            this.f5743d = operation;
            this.f5744e = kVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f5740a.endViewTransition(this.f5741b);
            if (this.f5742c) {
                this.f5743d.e().a(this.f5741b);
            }
            this.f5744e.a();
            if (FragmentManager.J0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animator from operation ");
                sb2.append(this.f5743d);
                sb2.append(" has ended.");
            }
        }
    }

    class d implements e.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Animator f5746a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SpecialEffectsController.Operation f5747b;

        d(Animator animator, SpecialEffectsController.Operation operation) {
            this.f5746a = animator;
            this.f5747b = operation;
        }

        public void onCancel() {
            this.f5746a.end();
            if (FragmentManager.J0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animator from operation ");
                sb2.append(this.f5747b);
                sb2.append(" has been canceled.");
            }
        }
    }

    class e implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpecialEffectsController.Operation f5749a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f5750b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f5751c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ k f5752d;

        class a implements Runnable {
            a() {
            }

            public void run() {
                e eVar = e.this;
                eVar.f5750b.endViewTransition(eVar.f5751c);
                e.this.f5752d.a();
            }
        }

        e(SpecialEffectsController.Operation operation, ViewGroup viewGroup, View view, k kVar) {
            this.f5749a = operation;
            this.f5750b = viewGroup;
            this.f5751c = view;
            this.f5752d = kVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f5750b.post(new a());
            if (FragmentManager.J0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animation from operation ");
                sb2.append(this.f5749a);
                sb2.append(" has ended.");
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            if (FragmentManager.J0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animation from operation ");
                sb2.append(this.f5749a);
                sb2.append(" has reached onAnimationStart.");
            }
        }
    }

    class f implements e.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f5755a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f5756b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f5757c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SpecialEffectsController.Operation f5758d;

        f(View view, ViewGroup viewGroup, k kVar, SpecialEffectsController.Operation operation) {
            this.f5755a = view;
            this.f5756b = viewGroup;
            this.f5757c = kVar;
            this.f5758d = operation;
        }

        public void onCancel() {
            this.f5755a.clearAnimation();
            this.f5756b.endViewTransition(this.f5755a);
            this.f5757c.a();
            if (FragmentManager.J0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animation from operation ");
                sb2.append(this.f5758d);
                sb2.append(" has been cancelled.");
            }
        }
    }

    class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SpecialEffectsController.Operation f5760a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SpecialEffectsController.Operation f5761b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f5762c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ androidx.collection.a f5763d;

        g(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean z10, androidx.collection.a aVar) {
            this.f5760a = operation;
            this.f5761b = operation2;
            this.f5762c = z10;
            this.f5763d = aVar;
        }

        public void run() {
            c0.a(this.f5760a.f(), this.f5761b.f(), this.f5762c, this.f5763d, false);
        }
    }

    class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e0 f5765a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f5766b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Rect f5767c;

        h(e0 e0Var, View view, Rect rect) {
            this.f5765a = e0Var;
            this.f5766b = view;
            this.f5767c = rect;
        }

        public void run() {
            this.f5765a.h(this.f5766b, this.f5767c);
        }
    }

    class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f5769a;

        i(ArrayList arrayList) {
            this.f5769a = arrayList;
        }

        public void run() {
            c0.d(this.f5769a, 4);
        }
    }

    class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f5771a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SpecialEffectsController.Operation f5772b;

        j(m mVar, SpecialEffectsController.Operation operation) {
            this.f5771a = mVar;
            this.f5772b = operation;
        }

        public void run() {
            this.f5771a.a();
            if (FragmentManager.J0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Transition for operation ");
                sb2.append(this.f5772b);
                sb2.append("has completed");
            }
        }
    }

    private static class k extends l {

        /* renamed from: c  reason: collision with root package name */
        private boolean f5774c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f5775d = false;

        /* renamed from: e  reason: collision with root package name */
        private i.a f5776e;

        k(@NonNull SpecialEffectsController.Operation operation, @NonNull androidx.core.os.e eVar, boolean z10) {
            super(operation, eVar);
            this.f5774c = z10;
        }

        /* access modifiers changed from: package-private */
        public i.a e(@NonNull Context context) {
            boolean z10;
            if (this.f5775d) {
                return this.f5776e;
            }
            Fragment f10 = b().f();
            if (b().e() == SpecialEffectsController.Operation.State.VISIBLE) {
                z10 = true;
            } else {
                z10 = false;
            }
            i.a b10 = i.b(context, f10, z10, this.f5774c);
            this.f5776e = b10;
            this.f5775d = true;
            return b10;
        }
    }

    private static class l {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final SpecialEffectsController.Operation f5777a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final androidx.core.os.e f5778b;

        l(@NonNull SpecialEffectsController.Operation operation, @NonNull androidx.core.os.e eVar) {
            this.f5777a = operation;
            this.f5778b = eVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f5777a.d(this.f5778b);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public SpecialEffectsController.Operation b() {
            return this.f5777a;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.core.os.e c() {
            return this.f5778b;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State c10 = SpecialEffectsController.Operation.State.c(this.f5777a.f().mView);
            SpecialEffectsController.Operation.State e10 = this.f5777a.e();
            if (c10 == e10 || (c10 != (state = SpecialEffectsController.Operation.State.VISIBLE) && e10 != state)) {
                return true;
            }
            return false;
        }
    }

    private static class m extends l {

        /* renamed from: c  reason: collision with root package name */
        private final Object f5779c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f5780d;

        /* renamed from: e  reason: collision with root package name */
        private final Object f5781e;

        m(@NonNull SpecialEffectsController.Operation operation, @NonNull androidx.core.os.e eVar, boolean z10, boolean z11) {
            super(operation, eVar);
            Object obj;
            Object obj2;
            boolean z12;
            if (operation.e() == SpecialEffectsController.Operation.State.VISIBLE) {
                if (z10) {
                    obj2 = operation.f().getReenterTransition();
                } else {
                    obj2 = operation.f().getEnterTransition();
                }
                this.f5779c = obj2;
                if (z10) {
                    z12 = operation.f().getAllowReturnTransitionOverlap();
                } else {
                    z12 = operation.f().getAllowEnterTransitionOverlap();
                }
                this.f5780d = z12;
            } else {
                if (z10) {
                    obj = operation.f().getReturnTransition();
                } else {
                    obj = operation.f().getExitTransition();
                }
                this.f5779c = obj;
                this.f5780d = true;
            }
            if (!z11) {
                this.f5781e = null;
            } else if (z10) {
                this.f5781e = operation.f().getSharedElementReturnTransition();
            } else {
                this.f5781e = operation.f().getSharedElementEnterTransition();
            }
        }

        private e0 f(Object obj) {
            if (obj == null) {
                return null;
            }
            e0 e0Var = c0.f5816a;
            if (e0Var != null && e0Var.e(obj)) {
                return e0Var;
            }
            e0 e0Var2 = c0.f5817b;
            if (e0Var2 != null && e0Var2.e(obj)) {
                return e0Var2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        /* access modifiers changed from: package-private */
        public e0 e() {
            e0 f10 = f(this.f5779c);
            e0 f11 = f(this.f5781e);
            if (f10 != null && f11 != null && f10 != f11) {
                throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f5779c + " which uses a different Transition  type than its shared element transition " + this.f5781e);
            } else if (f10 != null) {
                return f10;
            } else {
                return f11;
            }
        }

        public Object g() {
            return this.f5781e;
        }

        /* access modifiers changed from: package-private */
        public Object h() {
            return this.f5779c;
        }

        public boolean i() {
            return this.f5781e != null;
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return this.f5780d;
        }
    }

    b(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(@NonNull List<k> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z10, @NonNull Map<SpecialEffectsController.Operation, Boolean> map) {
        int i10;
        boolean z11;
        int i11;
        boolean z12;
        SpecialEffectsController.Operation operation;
        ViewGroup m10 = m();
        Context context = m10.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator<k> it = list.iterator();
        boolean z13 = false;
        while (true) {
            i10 = 2;
            if (!it.hasNext()) {
                break;
            }
            k next = it.next();
            if (next.d()) {
                next.a();
            } else {
                i.a e10 = next.e(context);
                if (e10 == null) {
                    next.a();
                } else {
                    Animator animator = e10.f5853b;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        SpecialEffectsController.Operation b10 = next.b();
                        Fragment f10 = b10.f();
                        if (Boolean.TRUE.equals(map.get(b10))) {
                            if (FragmentManager.J0(2)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Ignoring Animator set on ");
                                sb2.append(f10);
                                sb2.append(" as this Fragment was involved in a Transition.");
                            }
                            next.a();
                        } else {
                            if (b10.e() == SpecialEffectsController.Operation.State.GONE) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            List<SpecialEffectsController.Operation> list3 = list2;
                            if (z12) {
                                list3.remove(b10);
                            }
                            View view = f10.mView;
                            m10.startViewTransition(view);
                            c cVar = r0;
                            View view2 = view;
                            SpecialEffectsController.Operation operation2 = b10;
                            Animator animator2 = animator;
                            c cVar2 = new c(m10, view2, z12, operation2, next);
                            animator2.addListener(cVar2);
                            animator2.setTarget(view2);
                            animator2.start();
                            if (FragmentManager.J0(2)) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Animator from operation ");
                                operation = operation2;
                                sb3.append(operation);
                                sb3.append(" has started.");
                            } else {
                                operation = operation2;
                            }
                            next.c().b(new d(animator2, operation));
                            z13 = true;
                        }
                    }
                }
            }
            Map<SpecialEffectsController.Operation, Boolean> map2 = map;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            k kVar = (k) it2.next();
            SpecialEffectsController.Operation b11 = kVar.b();
            Fragment f11 = b11.f();
            if (z10) {
                if (FragmentManager.J0(i10)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Ignoring Animation set on ");
                    sb4.append(f11);
                    sb4.append(" as Animations cannot run alongside Transitions.");
                }
                kVar.a();
            } else if (z13) {
                if (FragmentManager.J0(i10)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Ignoring Animation set on ");
                    sb5.append(f11);
                    sb5.append(" as Animations cannot run alongside Animators.");
                }
                kVar.a();
            } else {
                View view3 = f11.mView;
                Animation animation = (Animation) androidx.core.util.h.g(((i.a) androidx.core.util.h.g(kVar.e(context))).f5852a);
                if (b11.e() != SpecialEffectsController.Operation.State.REMOVED) {
                    view3.startAnimation(animation);
                    kVar.a();
                    z11 = z13;
                    i11 = i10;
                } else {
                    m10.startViewTransition(view3);
                    e eVar = r0;
                    z11 = z13;
                    i.b bVar = new i.b(animation, m10, view3);
                    e eVar2 = new e(b11, m10, view3, kVar);
                    bVar.setAnimationListener(eVar);
                    view3.startAnimation(bVar);
                    i11 = 2;
                    if (FragmentManager.J0(2)) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("Animation from operation ");
                        sb6.append(b11);
                        sb6.append(" has started.");
                    }
                }
                androidx.core.os.e c10 = kVar.c();
                k kVar2 = kVar;
                f fVar = r0;
                f fVar2 = new f(view3, m10, kVar2, b11);
                c10.b(fVar);
                i10 = i11;
                z13 = z11;
            }
        }
    }

    @NonNull
    private Map<SpecialEffectsController.Operation, Boolean> x(@NonNull List<m> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z10, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        View view;
        View view2;
        Object obj;
        SpecialEffectsController.Operation operation3;
        SpecialEffectsController.Operation operation4;
        Object obj2;
        Object obj3;
        androidx.collection.a aVar;
        SpecialEffectsController.Operation operation5;
        e0 e0Var;
        View view3;
        Rect rect;
        ArrayList arrayList3;
        SpecialEffectsController.Operation operation6;
        ArrayList arrayList4;
        boolean z11 = z10;
        SpecialEffectsController.Operation operation7 = operation;
        SpecialEffectsController.Operation operation8 = operation2;
        HashMap hashMap = new HashMap();
        e0 e0Var2 = null;
        for (m next : list) {
            if (!next.d()) {
                e0 e10 = next.e();
                if (e0Var2 == null) {
                    e0Var2 = e10;
                } else if (!(e10 == null || e0Var2 == e10)) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + next.b().f() + " returned Transition " + next.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (e0Var2 == null) {
            for (m next2 : list) {
                hashMap.put(next2.b(), Boolean.FALSE);
                next2.a();
            }
            return hashMap;
        }
        View view4 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        androidx.collection.a aVar2 = new androidx.collection.a();
        Object obj4 = null;
        View view5 = null;
        boolean z12 = false;
        for (m next3 : list) {
            if (!next3.i() || operation7 == null || operation8 == null) {
                aVar = aVar2;
                arrayList4 = arrayList6;
                operation6 = operation7;
                arrayList3 = arrayList5;
                rect = rect2;
                view3 = view4;
                e0Var = e0Var2;
                operation5 = operation8;
                view5 = view5;
            } else {
                Object u10 = e0Var2.u(e0Var2.f(next3.g()));
                ArrayList<String> sharedElementSourceNames = operation2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.f().getSharedElementTargetNames();
                Object obj5 = u10;
                View view6 = view5;
                int i10 = 0;
                while (i10 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i10));
                    ArrayList<String> arrayList7 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i10));
                    }
                    i10++;
                    sharedElementTargetNames = arrayList7;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.f().getSharedElementTargetNames();
                if (!z11) {
                    operation.f().getExitTransitionCallback();
                    operation2.f().getEnterTransitionCallback();
                } else {
                    operation.f().getEnterTransitionCallback();
                    operation2.f().getExitTransitionCallback();
                }
                int i11 = 0;
                for (int size = sharedElementSourceNames.size(); i11 < size; size = size) {
                    aVar2.put(sharedElementSourceNames.get(i11), sharedElementTargetNames2.get(i11));
                    i11++;
                }
                if (FragmentManager.J0(2)) {
                    Iterator<String> it = sharedElementTargetNames2.iterator();
                    while (it.hasNext()) {
                        Iterator<String> it2 = it;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Name: ");
                        sb2.append(it.next());
                        it = it2;
                    }
                    Iterator<String> it3 = sharedElementSourceNames.iterator();
                    while (it3.hasNext()) {
                        Iterator<String> it4 = it3;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Name: ");
                        sb3.append(it3.next());
                        it3 = it4;
                    }
                }
                androidx.collection.a aVar3 = new androidx.collection.a();
                u(aVar3, operation.f().mView);
                aVar3.r(sharedElementSourceNames);
                aVar2.r(aVar3.keySet());
                androidx.collection.a aVar4 = new androidx.collection.a();
                u(aVar4, operation2.f().mView);
                aVar4.r(sharedElementTargetNames2);
                aVar4.r(aVar2.values());
                c0.c(aVar2, aVar4);
                v(aVar3, aVar2.keySet());
                v(aVar4, aVar2.values());
                if (aVar2.isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    aVar = aVar2;
                    arrayList4 = arrayList6;
                    operation6 = operation7;
                    arrayList3 = arrayList5;
                    rect = rect2;
                    view3 = view4;
                    e0Var = e0Var2;
                    view5 = view6;
                    obj4 = null;
                    operation5 = operation8;
                } else {
                    c0.a(operation2.f(), operation.f(), z11, aVar3, true);
                    ArrayList<String> arrayList8 = sharedElementSourceNames;
                    g gVar = r0;
                    ViewGroup m10 = m();
                    Object obj6 = obj5;
                    androidx.collection.a aVar5 = aVar4;
                    View view7 = view6;
                    androidx.collection.a aVar6 = aVar3;
                    aVar = aVar2;
                    ArrayList arrayList9 = arrayList6;
                    g gVar2 = new g(operation2, operation, z10, aVar5);
                    k0.a(m10, gVar2);
                    arrayList5.addAll(aVar6.values());
                    if (!arrayList8.isEmpty()) {
                        View view8 = (View) aVar6.get(arrayList8.get(0));
                        e0Var2.p(obj6, view8);
                        view5 = view8;
                    } else {
                        view5 = view7;
                    }
                    arrayList4 = arrayList9;
                    arrayList4.addAll(aVar5.values());
                    if (!sharedElementTargetNames2.isEmpty()) {
                        View view9 = (View) aVar5.get(sharedElementTargetNames2.get(0));
                        if (view9 != null) {
                            k0.a(m(), new h(e0Var2, view9, rect2));
                            z12 = true;
                        }
                    }
                    e0Var2.s(obj6, view4, arrayList5);
                    arrayList3 = arrayList5;
                    rect = rect2;
                    view3 = view4;
                    e0Var = e0Var2;
                    e0Var2.n(obj6, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null, obj6, arrayList4);
                    Boolean bool = Boolean.TRUE;
                    operation6 = operation;
                    hashMap.put(operation6, bool);
                    operation5 = operation2;
                    hashMap.put(operation5, bool);
                    obj4 = obj6;
                }
            }
            operation7 = operation6;
            arrayList5 = arrayList3;
            rect2 = rect;
            view4 = view3;
            operation8 = operation5;
            aVar2 = aVar;
            z11 = z10;
            arrayList6 = arrayList4;
            e0Var2 = e0Var;
        }
        View view10 = view5;
        androidx.collection.a aVar7 = aVar2;
        ArrayList arrayList10 = arrayList6;
        SpecialEffectsController.Operation operation9 = operation7;
        ArrayList arrayList11 = arrayList5;
        Rect rect3 = rect2;
        View view11 = view4;
        e0 e0Var3 = e0Var2;
        boolean z13 = false;
        SpecialEffectsController.Operation operation10 = operation8;
        ArrayList arrayList12 = new ArrayList();
        Object obj7 = null;
        Object obj8 = null;
        for (m next4 : list) {
            if (next4.d()) {
                hashMap.put(next4.b(), Boolean.FALSE);
                next4.a();
            } else {
                Object f10 = e0Var3.f(next4.h());
                SpecialEffectsController.Operation b10 = next4.b();
                boolean z14 = (obj4 == null || !(b10 == operation9 || b10 == operation10)) ? z13 : true;
                if (f10 == null) {
                    if (!z14) {
                        hashMap.put(b10, Boolean.FALSE);
                        next4.a();
                    }
                    List<SpecialEffectsController.Operation> list3 = list2;
                    arrayList = arrayList10;
                    arrayList2 = arrayList11;
                    view = view11;
                    obj = obj7;
                    operation3 = operation10;
                    view2 = view10;
                } else {
                    ArrayList arrayList13 = new ArrayList();
                    Object obj9 = obj7;
                    t(arrayList13, b10.f().mView);
                    if (z14) {
                        if (b10 == operation9) {
                            arrayList13.removeAll(arrayList11);
                        } else {
                            arrayList13.removeAll(arrayList10);
                        }
                    }
                    if (arrayList13.isEmpty()) {
                        e0Var3.a(f10, view11);
                        arrayList = arrayList10;
                        arrayList2 = arrayList11;
                        view = view11;
                        operation4 = b10;
                        obj3 = obj8;
                        operation3 = operation10;
                        List<SpecialEffectsController.Operation> list4 = list2;
                        obj2 = obj9;
                    } else {
                        e0Var3.b(f10, arrayList13);
                        view = view11;
                        obj2 = obj9;
                        SpecialEffectsController.Operation operation11 = b10;
                        arrayList2 = arrayList11;
                        obj3 = obj8;
                        arrayList = arrayList10;
                        operation3 = operation10;
                        e0Var3.n(f10, f10, arrayList13, (Object) null, (ArrayList<View>) null, (Object) null, (ArrayList<View>) null);
                        if (operation11.e() == SpecialEffectsController.Operation.State.GONE) {
                            operation4 = operation11;
                            list2.remove(operation4);
                            ArrayList arrayList14 = new ArrayList(arrayList13);
                            arrayList14.remove(operation4.f().mView);
                            e0Var3.m(f10, operation4.f().mView, arrayList14);
                            k0.a(m(), new i(arrayList13));
                        } else {
                            List<SpecialEffectsController.Operation> list5 = list2;
                            operation4 = operation11;
                        }
                    }
                    if (operation4.e() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList12.addAll(arrayList13);
                        if (z12) {
                            e0Var3.o(f10, rect3);
                        }
                        view2 = view10;
                    } else {
                        view2 = view10;
                        e0Var3.p(f10, view2);
                    }
                    hashMap.put(operation4, Boolean.TRUE);
                    if (next4.j()) {
                        obj8 = e0Var3.k(obj3, f10, (Object) null);
                        obj = obj2;
                    } else {
                        obj = e0Var3.k(obj2, f10, (Object) null);
                        obj8 = obj3;
                    }
                }
                operation10 = operation3;
                obj7 = obj;
                view10 = view2;
                view11 = view;
                arrayList11 = arrayList2;
                arrayList10 = arrayList;
                z13 = false;
            }
        }
        ArrayList arrayList15 = arrayList10;
        ArrayList arrayList16 = arrayList11;
        SpecialEffectsController.Operation operation12 = operation10;
        Object j10 = e0Var3.j(obj8, obj7, obj4);
        if (j10 == null) {
            return hashMap;
        }
        for (m next5 : list) {
            if (!next5.d()) {
                Object h10 = next5.h();
                SpecialEffectsController.Operation b11 = next5.b();
                boolean z15 = obj4 != null && (b11 == operation9 || b11 == operation12);
                if (h10 != null || z15) {
                    if (!n0.W(m())) {
                        if (FragmentManager.J0(2)) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("SpecialEffectsController: Container ");
                            sb4.append(m());
                            sb4.append(" has not been laid out. Completing operation ");
                            sb4.append(b11);
                        }
                        next5.a();
                    } else {
                        e0Var3.q(next5.b().f(), j10, next5.c(), new j(next5, b11));
                    }
                }
            }
        }
        if (!n0.W(m())) {
            return hashMap;
        }
        c0.d(arrayList12, 4);
        ArrayList arrayList17 = arrayList15;
        ArrayList<String> l10 = e0Var3.l(arrayList17);
        if (FragmentManager.J0(2)) {
            Iterator it5 = arrayList16.iterator();
            while (it5.hasNext()) {
                View view12 = (View) it5.next();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("View: ");
                sb5.append(view12);
                sb5.append(" Name: ");
                sb5.append(n0.K(view12));
            }
            Iterator it6 = arrayList17.iterator();
            while (it6.hasNext()) {
                View view13 = (View) it6.next();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("View: ");
                sb6.append(view13);
                sb6.append(" Name: ");
                sb6.append(n0.K(view13));
            }
        }
        e0Var3.c(m(), j10);
        e0Var3.r(m(), arrayList16, arrayList17, l10, aVar7);
        c0.d(arrayList12, 0);
        e0Var3.t(obj4, arrayList16, arrayList17);
        return hashMap;
    }

    private void y(@NonNull List<SpecialEffectsController.Operation> list) {
        Fragment f10 = list.get(list.size() - 1).f();
        for (SpecialEffectsController.Operation next : list) {
            next.f().mAnimationInfo.f5608c = f10.mAnimationInfo.f5608c;
            next.f().mAnimationInfo.f5609d = f10.mAnimationInfo.f5609d;
            next.f().mAnimationInfo.f5610e = f10.mAnimationInfo.f5610e;
            next.f().mAnimationInfo.f5611f = f10.mAnimationInfo.f5611f;
        }
    }

    /* access modifiers changed from: package-private */
    public void f(@NonNull List<SpecialEffectsController.Operation> list, boolean z10) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation next : list) {
            SpecialEffectsController.Operation.State c10 = SpecialEffectsController.Operation.State.c(next.f().mView);
            int i10 = a.f5736a[next.e().ordinal()];
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                if (c10 == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                    operation = next;
                }
            } else if (i10 == 4 && c10 != SpecialEffectsController.Operation.State.VISIBLE) {
                operation2 = next;
            }
        }
        if (FragmentManager.J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Executing operations from ");
            sb2.append(operation);
            sb2.append(" to ");
            sb2.append(operation2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<SpecialEffectsController.Operation> arrayList3 = new ArrayList<>(list);
        y(list);
        for (SpecialEffectsController.Operation next2 : list) {
            androidx.core.os.e eVar = new androidx.core.os.e();
            next2.j(eVar);
            arrayList.add(new k(next2, eVar, z10));
            androidx.core.os.e eVar2 = new androidx.core.os.e();
            next2.j(eVar2);
            boolean z11 = false;
            if (z10) {
                if (next2 != operation) {
                    arrayList2.add(new m(next2, eVar2, z10, z11));
                    next2.a(new C0058b(arrayList3, next2));
                }
            } else if (next2 != operation2) {
                arrayList2.add(new m(next2, eVar2, z10, z11));
                next2.a(new C0058b(arrayList3, next2));
            }
            z11 = true;
            arrayList2.add(new m(next2, eVar2, z10, z11));
            next2.a(new C0058b(arrayList3, next2));
        }
        Map<SpecialEffectsController.Operation, Boolean> x10 = x(arrayList2, arrayList3, z10, operation, operation2);
        w(arrayList, arrayList3, x10.containsValue(Boolean.TRUE), x10);
        for (SpecialEffectsController.Operation s10 : arrayList3) {
            s(s10);
        }
        arrayList3.clear();
        if (FragmentManager.J0(2)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Completed executing operations from ");
            sb3.append(operation);
            sb3.append(" to ");
            sb3.append(operation2);
        }
    }

    /* access modifiers changed from: package-private */
    public void s(@NonNull SpecialEffectsController.Operation operation) {
        operation.e().a(operation.f().mView);
    }

    /* access modifiers changed from: package-private */
    public void t(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!b2.a(viewGroup)) {
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = viewGroup.getChildAt(i10);
                    if (childAt.getVisibility() == 0) {
                        t(arrayList, childAt);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(viewGroup);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    /* access modifiers changed from: package-private */
    public void u(Map<String, View> map, @NonNull View view) {
        String K = n0.K(view);
        if (K != null) {
            map.put(K, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v(@NonNull androidx.collection.a<String, View> aVar, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(n0.K((View) it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
