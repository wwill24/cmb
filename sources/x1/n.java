package x1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.collection.g;
import androidx.core.view.n0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class n implements Cloneable {
    private static final int[] N = {2, 1, 3, 4};
    private static final g O = new a();
    private static ThreadLocal<androidx.collection.a<Animator, d>> P = new ThreadLocal<>();
    private ArrayList<u> B;
    boolean C = false;
    ArrayList<Animator> D = new ArrayList<>();
    private int E = 0;
    private boolean F = false;
    private boolean G = false;
    private ArrayList<f> H = null;
    private ArrayList<Animator> I = new ArrayList<>();
    q J;
    private e K;
    private androidx.collection.a<String, String> L;
    private g M = O;

    /* renamed from: a  reason: collision with root package name */
    private String f18430a = getClass().getName();

    /* renamed from: b  reason: collision with root package name */
    private long f18431b = -1;

    /* renamed from: c  reason: collision with root package name */
    long f18432c = -1;

    /* renamed from: d  reason: collision with root package name */
    private TimeInterpolator f18433d = null;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<Integer> f18434e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    ArrayList<View> f18435f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<String> f18436g = null;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<Class<?>> f18437h = null;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<Integer> f18438j = null;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<View> f18439k = null;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<Class<?>> f18440l = null;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<String> f18441m = null;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList<Integer> f18442n = null;

    /* renamed from: p  reason: collision with root package name */
    private ArrayList<View> f18443p = null;

    /* renamed from: q  reason: collision with root package name */
    private ArrayList<Class<?>> f18444q = null;

    /* renamed from: t  reason: collision with root package name */
    private v f18445t = new v();

    /* renamed from: w  reason: collision with root package name */
    private v f18446w = new v();

    /* renamed from: x  reason: collision with root package name */
    r f18447x = null;

    /* renamed from: y  reason: collision with root package name */
    private int[] f18448y = N;

    /* renamed from: z  reason: collision with root package name */
    private ArrayList<u> f18449z;

    class a extends g {
        a() {
        }

        public Path a(float f10, float f11, float f12, float f13) {
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f12, f13);
            return path;
        }
    }

    class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ androidx.collection.a f18450a;

        b(androidx.collection.a aVar) {
            this.f18450a = aVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f18450a.remove(animator);
            n.this.D.remove(animator);
        }

        public void onAnimationStart(Animator animator) {
            n.this.D.add(animator);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        public void onAnimationEnd(Animator animator) {
            n.this.s();
            animator.removeListener(this);
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        View f18453a;

        /* renamed from: b  reason: collision with root package name */
        String f18454b;

        /* renamed from: c  reason: collision with root package name */
        u f18455c;

        /* renamed from: d  reason: collision with root package name */
        t0 f18456d;

        /* renamed from: e  reason: collision with root package name */
        n f18457e;

        d(View view, String str, n nVar, t0 t0Var, u uVar) {
            this.f18453a = view;
            this.f18454b = str;
            this.f18455c = uVar;
            this.f18456d = t0Var;
            this.f18457e = nVar;
        }
    }

    public static abstract class e {
        public abstract Rect a(@NonNull n nVar);
    }

    public interface f {
        void a(@NonNull n nVar);

        void b(@NonNull n nVar);

        void c(@NonNull n nVar);

        void d(@NonNull n nVar);

        void e(@NonNull n nVar);
    }

    private static androidx.collection.a<Animator, d> C() {
        androidx.collection.a<Animator, d> aVar = P.get();
        if (aVar != null) {
            return aVar;
        }
        androidx.collection.a<Animator, d> aVar2 = new androidx.collection.a<>();
        P.set(aVar2);
        return aVar2;
    }

    private static boolean N(u uVar, u uVar2, String str) {
        Object obj = uVar.f18492a.get(str);
        Object obj2 = uVar2.f18492a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void O(androidx.collection.a<View, u> aVar, androidx.collection.a<View, u> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            View valueAt = sparseArray.valueAt(i10);
            if (valueAt != null && M(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i10))) != null && M(view)) {
                u uVar = aVar.get(valueAt);
                u uVar2 = aVar2.get(view);
                if (!(uVar == null || uVar2 == null)) {
                    this.f18449z.add(uVar);
                    this.B.add(uVar2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void Q(androidx.collection.a<View, u> aVar, androidx.collection.a<View, u> aVar2) {
        u remove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View j10 = aVar.j(size);
            if (j10 != null && M(j10) && (remove = aVar2.remove(j10)) != null && M(remove.f18493b)) {
                this.f18449z.add(aVar.l(size));
                this.B.add(remove);
            }
        }
    }

    private void R(androidx.collection.a<View, u> aVar, androidx.collection.a<View, u> aVar2, androidx.collection.e<View> eVar, androidx.collection.e<View> eVar2) {
        View e10;
        int q10 = eVar.q();
        for (int i10 = 0; i10 < q10; i10++) {
            View r10 = eVar.r(i10);
            if (r10 != null && M(r10) && (e10 = eVar2.e(eVar.k(i10))) != null && M(e10)) {
                u uVar = aVar.get(r10);
                u uVar2 = aVar2.get(e10);
                if (!(uVar == null || uVar2 == null)) {
                    this.f18449z.add(uVar);
                    this.B.add(uVar2);
                    aVar.remove(r10);
                    aVar2.remove(e10);
                }
            }
        }
    }

    private void S(androidx.collection.a<View, u> aVar, androidx.collection.a<View, u> aVar2, androidx.collection.a<String, View> aVar3, androidx.collection.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i10 = 0; i10 < size; i10++) {
            View n10 = aVar3.n(i10);
            if (n10 != null && M(n10) && (view = aVar4.get(aVar3.j(i10))) != null && M(view)) {
                u uVar = aVar.get(n10);
                u uVar2 = aVar2.get(view);
                if (!(uVar == null || uVar2 == null)) {
                    this.f18449z.add(uVar);
                    this.B.add(uVar2);
                    aVar.remove(n10);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void T(v vVar, v vVar2) {
        androidx.collection.a aVar = new androidx.collection.a((g) vVar.f18495a);
        androidx.collection.a aVar2 = new androidx.collection.a((g) vVar2.f18495a);
        int i10 = 0;
        while (true) {
            int[] iArr = this.f18448y;
            if (i10 < iArr.length) {
                int i11 = iArr[i10];
                if (i11 == 1) {
                    Q(aVar, aVar2);
                } else if (i11 == 2) {
                    S(aVar, aVar2, vVar.f18498d, vVar2.f18498d);
                } else if (i11 == 3) {
                    O(aVar, aVar2, vVar.f18496b, vVar2.f18496b);
                } else if (i11 == 4) {
                    R(aVar, aVar2, vVar.f18497c, vVar2.f18497c);
                }
                i10++;
            } else {
                c(aVar, aVar2);
                return;
            }
        }
    }

    private void Z(Animator animator, androidx.collection.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            e(animator);
        }
    }

    private void c(androidx.collection.a<View, u> aVar, androidx.collection.a<View, u> aVar2) {
        for (int i10 = 0; i10 < aVar.size(); i10++) {
            u n10 = aVar.n(i10);
            if (M(n10.f18493b)) {
                this.f18449z.add(n10);
                this.B.add((Object) null);
            }
        }
        for (int i11 = 0; i11 < aVar2.size(); i11++) {
            u n11 = aVar2.n(i11);
            if (M(n11.f18493b)) {
                this.B.add(n11);
                this.f18449z.add((Object) null);
            }
        }
    }

    private static void d(v vVar, View view, u uVar) {
        vVar.f18495a.put(view, uVar);
        int id2 = view.getId();
        if (id2 >= 0) {
            if (vVar.f18496b.indexOfKey(id2) >= 0) {
                vVar.f18496b.put(id2, (Object) null);
            } else {
                vVar.f18496b.put(id2, view);
            }
        }
        String K2 = n0.K(view);
        if (K2 != null) {
            if (vVar.f18498d.containsKey(K2)) {
                vVar.f18498d.put(K2, null);
            } else {
                vVar.f18498d.put(K2, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (vVar.f18497c.i(itemIdAtPosition) >= 0) {
                    View e10 = vVar.f18497c.e(itemIdAtPosition);
                    if (e10 != null) {
                        n0.C0(e10, false);
                        vVar.f18497c.l(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                n0.C0(view, true);
                vVar.f18497c.l(itemIdAtPosition, view);
            }
        }
    }

    private void i(View view, boolean z10) {
        if (view != null) {
            int id2 = view.getId();
            ArrayList<Integer> arrayList = this.f18438j;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id2))) {
                ArrayList<View> arrayList2 = this.f18439k;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.f18440l;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i10 = 0;
                        while (i10 < size) {
                            if (!this.f18440l.get(i10).isInstance(view)) {
                                i10++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        u uVar = new u(view);
                        if (z10) {
                            k(uVar);
                        } else {
                            h(uVar);
                        }
                        uVar.f18494c.add(this);
                        j(uVar);
                        if (z10) {
                            d(this.f18445t, view, uVar);
                        } else {
                            d(this.f18446w, view, uVar);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.f18442n;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id2))) {
                            ArrayList<View> arrayList5 = this.f18443p;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.f18444q;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i11 = 0;
                                    while (i11 < size2) {
                                        if (!this.f18444q.get(i11).isInstance(view)) {
                                            i11++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                                    i(viewGroup.getChildAt(i12), z10);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @NonNull
    public g A() {
        return this.M;
    }

    public q B() {
        return this.J;
    }

    public long D() {
        return this.f18431b;
    }

    @NonNull
    public List<Integer> E() {
        return this.f18434e;
    }

    public List<String> F() {
        return this.f18436g;
    }

    public List<Class<?>> G() {
        return this.f18437h;
    }

    @NonNull
    public List<View> H() {
        return this.f18435f;
    }

    public String[] I() {
        return null;
    }

    public u J(@NonNull View view, boolean z10) {
        v vVar;
        r rVar = this.f18447x;
        if (rVar != null) {
            return rVar.J(view, z10);
        }
        if (z10) {
            vVar = this.f18445t;
        } else {
            vVar = this.f18446w;
        }
        return vVar.f18495a.get(view);
    }

    public boolean K(u uVar, u uVar2) {
        if (uVar == null || uVar2 == null) {
            return false;
        }
        String[] I2 = I();
        if (I2 != null) {
            int length = I2.length;
            int i10 = 0;
            while (i10 < length) {
                if (!N(uVar, uVar2, I2[i10])) {
                    i10++;
                }
            }
            return false;
        }
        for (String N2 : uVar.f18492a.keySet()) {
            if (N(uVar, uVar2, N2)) {
            }
        }
        return false;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean M(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id2 = view.getId();
        ArrayList<Integer> arrayList3 = this.f18438j;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id2))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f18439k;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.f18440l;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (this.f18440l.get(i10).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f18441m != null && n0.K(view) != null && this.f18441m.contains(n0.K(view))) {
            return false;
        }
        if ((this.f18434e.size() == 0 && this.f18435f.size() == 0 && (((arrayList = this.f18437h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f18436g) == null || arrayList2.isEmpty()))) || this.f18434e.contains(Integer.valueOf(id2)) || this.f18435f.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f18436g;
        if (arrayList6 != null && arrayList6.contains(n0.K(view))) {
            return true;
        }
        if (this.f18437h != null) {
            for (int i11 = 0; i11 < this.f18437h.size(); i11++) {
                if (this.f18437h.get(i11).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void U(View view) {
        if (!this.G) {
            for (int size = this.D.size() - 1; size >= 0; size--) {
                a.b(this.D.get(size));
            }
            ArrayList<f> arrayList = this.H;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.H.clone();
                int size2 = arrayList2.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    ((f) arrayList2.get(i10)).d(this);
                }
            }
            this.F = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void V(ViewGroup viewGroup) {
        d dVar;
        boolean z10;
        this.f18449z = new ArrayList<>();
        this.B = new ArrayList<>();
        T(this.f18445t, this.f18446w);
        androidx.collection.a<Animator, d> C2 = C();
        int size = C2.size();
        t0 d10 = d0.d(viewGroup);
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator j10 = C2.j(i10);
            if (!(j10 == null || (dVar = C2.get(j10)) == null || dVar.f18453a == null || !d10.equals(dVar.f18456d))) {
                u uVar = dVar.f18455c;
                View view = dVar.f18453a;
                u J2 = J(view, true);
                u y10 = y(view, true);
                if (J2 == null && y10 == null) {
                    y10 = this.f18446w.f18495a.get(view);
                }
                if (!(J2 == null && y10 == null) && dVar.f18457e.K(uVar, y10)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    if (j10.isRunning() || j10.isStarted()) {
                        j10.cancel();
                    } else {
                        C2.remove(j10);
                    }
                }
            }
        }
        r(viewGroup, this.f18445t, this.f18446w, this.f18449z, this.B);
        a0();
    }

    @NonNull
    public n W(@NonNull f fVar) {
        ArrayList<f> arrayList = this.H;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.H.size() == 0) {
            this.H = null;
        }
        return this;
    }

    @NonNull
    public n X(@NonNull View view) {
        this.f18435f.remove(view);
        return this;
    }

    public void Y(View view) {
        if (this.F) {
            if (!this.G) {
                for (int size = this.D.size() - 1; size >= 0; size--) {
                    a.c(this.D.get(size));
                }
                ArrayList<f> arrayList = this.H;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.H.clone();
                    int size2 = arrayList2.size();
                    for (int i10 = 0; i10 < size2; i10++) {
                        ((f) arrayList2.get(i10)).b(this);
                    }
                }
            }
            this.F = false;
        }
    }

    @NonNull
    public n a(@NonNull f fVar) {
        if (this.H == null) {
            this.H = new ArrayList<>();
        }
        this.H.add(fVar);
        return this;
    }

    /* access modifiers changed from: protected */
    public void a0() {
        j0();
        androidx.collection.a<Animator, d> C2 = C();
        Iterator<Animator> it = this.I.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (C2.containsKey(next)) {
                j0();
                Z(next, C2);
            }
        }
        this.I.clear();
        s();
    }

    @NonNull
    public n b(@NonNull View view) {
        this.f18435f.add(view);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void b0(boolean z10) {
        this.C = z10;
    }

    @NonNull
    public n c0(long j10) {
        this.f18432c = j10;
        return this;
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        for (int size = this.D.size() - 1; size >= 0; size--) {
            this.D.get(size).cancel();
        }
        ArrayList<f> arrayList = this.H;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.H.clone();
            int size2 = arrayList2.size();
            for (int i10 = 0; i10 < size2; i10++) {
                ((f) arrayList2.get(i10)).a(this);
            }
        }
    }

    public void d0(e eVar) {
        this.K = eVar;
    }

    /* access modifiers changed from: protected */
    public void e(Animator animator) {
        if (animator == null) {
            s();
            return;
        }
        if (u() >= 0) {
            animator.setDuration(u());
        }
        if (D() >= 0) {
            animator.setStartDelay(D() + animator.getStartDelay());
        }
        if (x() != null) {
            animator.setInterpolator(x());
        }
        animator.addListener(new c());
        animator.start();
    }

    @NonNull
    public n f0(TimeInterpolator timeInterpolator) {
        this.f18433d = timeInterpolator;
        return this;
    }

    public void g0(g gVar) {
        if (gVar == null) {
            this.M = O;
        } else {
            this.M = gVar;
        }
    }

    public abstract void h(@NonNull u uVar);

    public void h0(q qVar) {
        this.J = qVar;
    }

    @NonNull
    public n i0(long j10) {
        this.f18431b = j10;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void j(u uVar) {
        String[] b10;
        if (this.J != null && !uVar.f18492a.isEmpty() && (b10 = this.J.b()) != null) {
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= b10.length) {
                    z10 = true;
                    break;
                } else if (!uVar.f18492a.containsKey(b10[i10])) {
                    break;
                } else {
                    i10++;
                }
            }
            if (!z10) {
                this.J.a(uVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void j0() {
        if (this.E == 0) {
            ArrayList<f> arrayList = this.H;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.H.clone();
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((f) arrayList2.get(i10)).c(this);
                }
            }
            this.G = false;
        }
        this.E++;
    }

    public abstract void k(@NonNull u uVar);

    /* access modifiers changed from: package-private */
    public String k0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f18432c != -1) {
            str2 = str2 + "dur(" + this.f18432c + ") ";
        }
        if (this.f18431b != -1) {
            str2 = str2 + "dly(" + this.f18431b + ") ";
        }
        if (this.f18433d != null) {
            str2 = str2 + "interp(" + this.f18433d + ") ";
        }
        if (this.f18434e.size() <= 0 && this.f18435f.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f18434e.size() > 0) {
            for (int i10 = 0; i10 < this.f18434e.size(); i10++) {
                if (i10 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f18434e.get(i10);
            }
        }
        if (this.f18435f.size() > 0) {
            for (int i11 = 0; i11 < this.f18435f.size(); i11++) {
                if (i11 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f18435f.get(i11);
            }
        }
        return str3 + ")";
    }

    /* access modifiers changed from: package-private */
    public void l(ViewGroup viewGroup, boolean z10) {
        androidx.collection.a<String, String> aVar;
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        o(z10);
        if ((this.f18434e.size() > 0 || this.f18435f.size() > 0) && (((arrayList = this.f18436g) == null || arrayList.isEmpty()) && ((arrayList2 = this.f18437h) == null || arrayList2.isEmpty()))) {
            for (int i10 = 0; i10 < this.f18434e.size(); i10++) {
                View findViewById = viewGroup.findViewById(this.f18434e.get(i10).intValue());
                if (findViewById != null) {
                    u uVar = new u(findViewById);
                    if (z10) {
                        k(uVar);
                    } else {
                        h(uVar);
                    }
                    uVar.f18494c.add(this);
                    j(uVar);
                    if (z10) {
                        d(this.f18445t, findViewById, uVar);
                    } else {
                        d(this.f18446w, findViewById, uVar);
                    }
                }
            }
            for (int i11 = 0; i11 < this.f18435f.size(); i11++) {
                View view = this.f18435f.get(i11);
                u uVar2 = new u(view);
                if (z10) {
                    k(uVar2);
                } else {
                    h(uVar2);
                }
                uVar2.f18494c.add(this);
                j(uVar2);
                if (z10) {
                    d(this.f18445t, view, uVar2);
                } else {
                    d(this.f18446w, view, uVar2);
                }
            }
        } else {
            i(viewGroup, z10);
        }
        if (!z10 && (aVar = this.L) != null) {
            int size = aVar.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i12 = 0; i12 < size; i12++) {
                arrayList3.add(this.f18445t.f18498d.remove(this.L.j(i12)));
            }
            for (int i13 = 0; i13 < size; i13++) {
                View view2 = (View) arrayList3.get(i13);
                if (view2 != null) {
                    this.f18445t.f18498d.put(this.L.n(i13), view2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o(boolean z10) {
        if (z10) {
            this.f18445t.f18495a.clear();
            this.f18445t.f18496b.clear();
            this.f18445t.f18497c.a();
            return;
        }
        this.f18446w.f18495a.clear();
        this.f18446w.f18496b.clear();
        this.f18446w.f18497c.a();
    }

    /* renamed from: p */
    public n clone() {
        try {
            n nVar = (n) super.clone();
            nVar.I = new ArrayList<>();
            nVar.f18445t = new v();
            nVar.f18446w = new v();
            nVar.f18449z = null;
            nVar.B = null;
            return nVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator q(@NonNull ViewGroup viewGroup, u uVar, u uVar2) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void r(ViewGroup viewGroup, v vVar, v vVar2, ArrayList<u> arrayList, ArrayList<u> arrayList2) {
        int i10;
        boolean z10;
        Animator q10;
        View view;
        Animator animator;
        u uVar;
        u uVar2;
        Animator animator2;
        ViewGroup viewGroup2 = viewGroup;
        androidx.collection.a<Animator, d> C2 = C();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j10 = Long.MAX_VALUE;
        int i11 = 0;
        while (i11 < size) {
            u uVar3 = arrayList.get(i11);
            u uVar4 = arrayList2.get(i11);
            if (uVar3 != null && !uVar3.f18494c.contains(this)) {
                uVar3 = null;
            }
            if (uVar4 != null && !uVar4.f18494c.contains(this)) {
                uVar4 = null;
            }
            if (!(uVar3 == null && uVar4 == null)) {
                if (uVar3 == null || uVar4 == null || K(uVar3, uVar4)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10 && (q10 = q(viewGroup2, uVar3, uVar4)) != null) {
                    if (uVar4 != null) {
                        view = uVar4.f18493b;
                        String[] I2 = I();
                        if (I2 != null && I2.length > 0) {
                            uVar2 = new u(view);
                            Animator animator3 = q10;
                            i10 = size;
                            u uVar5 = vVar2.f18495a.get(view);
                            if (uVar5 != null) {
                                int i12 = 0;
                                while (i12 < I2.length) {
                                    Map<String, Object> map = uVar2.f18492a;
                                    String str = I2[i12];
                                    map.put(str, uVar5.f18492a.get(str));
                                    i12++;
                                    ArrayList<u> arrayList3 = arrayList2;
                                    I2 = I2;
                                }
                            }
                            int size2 = C2.size();
                            int i13 = 0;
                            while (true) {
                                if (i13 >= size2) {
                                    animator2 = animator3;
                                    break;
                                }
                                d dVar = C2.get(C2.j(i13));
                                if (dVar.f18455c != null && dVar.f18453a == view && dVar.f18454b.equals(z()) && dVar.f18455c.equals(uVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i13++;
                            }
                        } else {
                            i10 = size;
                            animator2 = q10;
                            uVar2 = null;
                        }
                        animator = animator2;
                        uVar = uVar2;
                    } else {
                        i10 = size;
                        view = uVar3.f18493b;
                        animator = q10;
                        uVar = null;
                    }
                    if (animator != null) {
                        q qVar = this.J;
                        if (qVar != null) {
                            long c10 = qVar.c(viewGroup2, this, uVar3, uVar4);
                            sparseIntArray.put(this.I.size(), (int) c10);
                            j10 = Math.min(c10, j10);
                        }
                        C2.put(animator, new d(view, z(), this, d0.d(viewGroup), uVar));
                        this.I.add(animator);
                        j10 = j10;
                    }
                    i11++;
                    size = i10;
                }
            }
            i10 = size;
            i11++;
            size = i10;
        }
        if (sparseIntArray.size() != 0) {
            for (int i14 = 0; i14 < sparseIntArray.size(); i14++) {
                Animator animator4 = this.I.get(sparseIntArray.keyAt(i14));
                animator4.setStartDelay((((long) sparseIntArray.valueAt(i14)) - j10) + animator4.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void s() {
        int i10 = this.E - 1;
        this.E = i10;
        if (i10 == 0) {
            ArrayList<f> arrayList = this.H;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.H.clone();
                int size = arrayList2.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((f) arrayList2.get(i11)).e(this);
                }
            }
            for (int i12 = 0; i12 < this.f18445t.f18497c.q(); i12++) {
                View r10 = this.f18445t.f18497c.r(i12);
                if (r10 != null) {
                    n0.C0(r10, false);
                }
            }
            for (int i13 = 0; i13 < this.f18446w.f18497c.q(); i13++) {
                View r11 = this.f18446w.f18497c.r(i13);
                if (r11 != null) {
                    n0.C0(r11, false);
                }
            }
            this.G = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void t(ViewGroup viewGroup) {
        androidx.collection.a<Animator, d> C2 = C();
        int size = C2.size();
        if (viewGroup != null && size != 0) {
            t0 d10 = d0.d(viewGroup);
            androidx.collection.a aVar = new androidx.collection.a((g) C2);
            C2.clear();
            for (int i10 = size - 1; i10 >= 0; i10--) {
                d dVar = (d) aVar.n(i10);
                if (!(dVar.f18453a == null || d10 == null || !d10.equals(dVar.f18456d))) {
                    ((Animator) aVar.j(i10)).end();
                }
            }
        }
    }

    public String toString() {
        return k0("");
    }

    public long u() {
        return this.f18432c;
    }

    public Rect v() {
        e eVar = this.K;
        if (eVar == null) {
            return null;
        }
        return eVar.a(this);
    }

    public e w() {
        return this.K;
    }

    public TimeInterpolator x() {
        return this.f18433d;
    }

    /* access modifiers changed from: package-private */
    public u y(View view, boolean z10) {
        ArrayList<u> arrayList;
        ArrayList<u> arrayList2;
        r rVar = this.f18447x;
        if (rVar != null) {
            return rVar.y(view, z10);
        }
        if (z10) {
            arrayList = this.f18449z;
        } else {
            arrayList = this.B;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i10 = -1;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            u uVar = arrayList.get(i11);
            if (uVar == null) {
                return null;
            }
            if (uVar.f18493b == view) {
                i10 = i11;
                break;
            }
            i11++;
        }
        if (i10 < 0) {
            return null;
        }
        if (z10) {
            arrayList2 = this.B;
        } else {
            arrayList2 = this.f18449z;
        }
        return arrayList2.get(i10);
    }

    @NonNull
    public String z() {
        return this.f18430a;
    }
}
