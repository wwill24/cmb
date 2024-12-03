package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.collection.e;
import androidx.core.view.n0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.b0;
import androidx.fragment.app.h;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.i;
import androidx.lifecycle.l;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.coffeemeetsbagel.models.NetworkProfile;

public abstract class FragmentStateAdapter extends RecyclerView.Adapter<a> implements b {

    /* renamed from: d  reason: collision with root package name */
    final Lifecycle f7225d;

    /* renamed from: e  reason: collision with root package name */
    final FragmentManager f7226e;

    /* renamed from: f  reason: collision with root package name */
    final e<Fragment> f7227f;

    /* renamed from: g  reason: collision with root package name */
    private final e<Fragment.SavedState> f7228g;

    /* renamed from: h  reason: collision with root package name */
    private final e<Integer> f7229h;

    /* renamed from: j  reason: collision with root package name */
    private FragmentMaxLifecycleEnforcer f7230j;

    /* renamed from: k  reason: collision with root package name */
    boolean f7231k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7232l;

    class FragmentMaxLifecycleEnforcer {

        /* renamed from: a  reason: collision with root package name */
        private ViewPager2.i f7238a;

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView.i f7239b;

        /* renamed from: c  reason: collision with root package name */
        private i f7240c;

        /* renamed from: d  reason: collision with root package name */
        private ViewPager2 f7241d;

        /* renamed from: e  reason: collision with root package name */
        private long f7242e = -1;

        class a extends ViewPager2.i {
            a() {
            }

            public void a(int i10) {
                FragmentMaxLifecycleEnforcer.this.d(false);
            }

            public void c(int i10) {
                FragmentMaxLifecycleEnforcer.this.d(false);
            }
        }

        class b extends d {
            b() {
                super((a) null);
            }

            public void a() {
                FragmentMaxLifecycleEnforcer.this.d(true);
            }
        }

        FragmentMaxLifecycleEnforcer() {
        }

        @NonNull
        private ViewPager2 a(@NonNull RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        /* access modifiers changed from: package-private */
        public void b(@NonNull RecyclerView recyclerView) {
            this.f7241d = a(recyclerView);
            a aVar = new a();
            this.f7238a = aVar;
            this.f7241d.g(aVar);
            b bVar = new b();
            this.f7239b = bVar;
            FragmentStateAdapter.this.D(bVar);
            AnonymousClass3 r22 = new i() {
                public void e(@NonNull l lVar, @NonNull Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.f7240c = r22;
            FragmentStateAdapter.this.f7225d.a(r22);
        }

        /* access modifiers changed from: package-private */
        public void c(@NonNull RecyclerView recyclerView) {
            a(recyclerView).n(this.f7238a);
            FragmentStateAdapter.this.F(this.f7239b);
            FragmentStateAdapter.this.f7225d.d(this.f7240c);
            this.f7241d = null;
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z10) {
            int currentItem;
            Fragment e10;
            boolean z11;
            if (!FragmentStateAdapter.this.Z() && this.f7241d.getScrollState() == 0 && !FragmentStateAdapter.this.f7227f.j() && FragmentStateAdapter.this.g() != 0 && (currentItem = this.f7241d.getCurrentItem()) < FragmentStateAdapter.this.g()) {
                long h10 = FragmentStateAdapter.this.h(currentItem);
                if ((h10 != this.f7242e || z10) && (e10 = FragmentStateAdapter.this.f7227f.e(h10)) != null && e10.isAdded()) {
                    this.f7242e = h10;
                    b0 p10 = FragmentStateAdapter.this.f7226e.p();
                    Fragment fragment = null;
                    for (int i10 = 0; i10 < FragmentStateAdapter.this.f7227f.q(); i10++) {
                        long k10 = FragmentStateAdapter.this.f7227f.k(i10);
                        Fragment r10 = FragmentStateAdapter.this.f7227f.r(i10);
                        if (r10.isAdded()) {
                            if (k10 != this.f7242e) {
                                p10.w(r10, Lifecycle.State.STARTED);
                            } else {
                                fragment = r10;
                            }
                            if (k10 == this.f7242e) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            r10.setMenuVisibility(z11);
                        }
                    }
                    if (fragment != null) {
                        p10.w(fragment, Lifecycle.State.RESUMED);
                    }
                    if (!p10.q()) {
                        p10.k();
                    }
                }
            }
        }
    }

    class a implements View.OnLayoutChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FrameLayout f7247a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f7248b;

        a(FrameLayout frameLayout, a aVar) {
            this.f7247a = frameLayout;
            this.f7248b = aVar;
        }

        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            if (this.f7247a.getParent() != null) {
                this.f7247a.removeOnLayoutChangeListener(this);
                FragmentStateAdapter.this.V(this.f7248b);
            }
        }
    }

    class b extends FragmentManager.k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f7250a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FrameLayout f7251b;

        b(Fragment fragment, FrameLayout frameLayout) {
            this.f7250a = fragment;
            this.f7251b = frameLayout;
        }

        public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, Bundle bundle) {
            if (fragment == this.f7250a) {
                fragmentManager.A1(this);
                FragmentStateAdapter.this.G(view, this.f7251b);
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
            fragmentStateAdapter.f7231k = false;
            fragmentStateAdapter.L();
        }
    }

    private static abstract class d extends RecyclerView.i {
        private d() {
        }

        public abstract void a();

        public final void b(int i10, int i11) {
            a();
        }

        public final void c(int i10, int i11, Object obj) {
            a();
        }

        public final void d(int i10, int i11) {
            a();
        }

        public final void e(int i10, int i11, int i12) {
            a();
        }

        public final void f(int i10, int i11) {
            a();
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    public FragmentStateAdapter(@NonNull h hVar) {
        this(hVar.getSupportFragmentManager(), hVar.getLifecycle());
    }

    @NonNull
    private static String J(@NonNull String str, long j10) {
        return str + j10;
    }

    private void K(int i10) {
        long h10 = h(i10);
        if (!this.f7227f.c(h10)) {
            Fragment I = I(i10);
            I.setInitialSavedState(this.f7228g.e(h10));
            this.f7227f.l(h10, I);
        }
    }

    private boolean M(long j10) {
        View view;
        if (this.f7229h.c(j10)) {
            return true;
        }
        Fragment e10 = this.f7227f.e(j10);
        if (e10 == null || (view = e10.getView()) == null) {
            return false;
        }
        if (view.getParent() != null) {
            return true;
        }
        return false;
    }

    private static boolean N(@NonNull String str, @NonNull String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private Long O(int i10) {
        Long l10 = null;
        for (int i11 = 0; i11 < this.f7229h.q(); i11++) {
            if (this.f7229h.r(i11).intValue() == i10) {
                if (l10 == null) {
                    l10 = Long.valueOf(this.f7229h.k(i11));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }
        return l10;
    }

    private static long U(@NonNull String str, @NonNull String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void W(long j10) {
        ViewParent parent;
        Fragment e10 = this.f7227f.e(j10);
        if (e10 != null) {
            if (!(e10.getView() == null || (parent = e10.getView().getParent()) == null)) {
                ((FrameLayout) parent).removeAllViews();
            }
            if (!H(j10)) {
                this.f7228g.o(j10);
            }
            if (!e10.isAdded()) {
                this.f7227f.o(j10);
            } else if (Z()) {
                this.f7232l = true;
            } else {
                if (e10.isAdded() && H(j10)) {
                    this.f7228g.l(j10, this.f7226e.r1(e10));
                }
                this.f7226e.p().r(e10).k();
                this.f7227f.o(j10);
            }
        }
    }

    private void X() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final c cVar = new c();
        this.f7225d.a(new i() {
            public void e(@NonNull l lVar, @NonNull Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(cVar);
                    lVar.getLifecycle().d(this);
                }
            }
        });
        handler.postDelayed(cVar, 10000);
    }

    private void Y(Fragment fragment, @NonNull FrameLayout frameLayout) {
        this.f7226e.j1(new b(fragment, frameLayout), false);
    }

    /* access modifiers changed from: package-private */
    public void G(@NonNull View view, @NonNull FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    public boolean H(long j10) {
        return j10 >= 0 && j10 < ((long) g());
    }

    @NonNull
    public abstract Fragment I(int i10);

    /* access modifiers changed from: package-private */
    public void L() {
        if (this.f7232l && !Z()) {
            androidx.collection.b<Long> bVar = new androidx.collection.b<>();
            for (int i10 = 0; i10 < this.f7227f.q(); i10++) {
                long k10 = this.f7227f.k(i10);
                if (!H(k10)) {
                    bVar.add(Long.valueOf(k10));
                    this.f7229h.o(k10);
                }
            }
            if (!this.f7231k) {
                this.f7232l = false;
                for (int i11 = 0; i11 < this.f7227f.q(); i11++) {
                    long k11 = this.f7227f.k(i11);
                    if (!M(k11)) {
                        bVar.add(Long.valueOf(k11));
                    }
                }
            }
            for (Long longValue : bVar) {
                W(longValue.longValue());
            }
        }
    }

    /* renamed from: P */
    public final void v(@NonNull a aVar, int i10) {
        long s10 = aVar.s();
        int id2 = aVar.W().getId();
        Long O = O(id2);
        if (!(O == null || O.longValue() == s10)) {
            W(O.longValue());
            this.f7229h.o(O.longValue());
        }
        this.f7229h.l(s10, Integer.valueOf(id2));
        K(i10);
        FrameLayout W = aVar.W();
        if (n0.V(W)) {
            if (W.getParent() == null) {
                W.addOnLayoutChangeListener(new a(W, aVar));
            } else {
                throw new IllegalStateException("Design assumption violated.");
            }
        }
        L();
    }

    @NonNull
    /* renamed from: Q */
    public final a x(@NonNull ViewGroup viewGroup, int i10) {
        return a.V(viewGroup);
    }

    /* renamed from: R */
    public final boolean z(@NonNull a aVar) {
        return true;
    }

    /* renamed from: S */
    public final void A(@NonNull a aVar) {
        V(aVar);
        L();
    }

    /* renamed from: T */
    public final void C(@NonNull a aVar) {
        Long O = O(aVar.W().getId());
        if (O != null) {
            W(O.longValue());
            this.f7229h.o(O.longValue());
        }
    }

    /* access modifiers changed from: package-private */
    public void V(@NonNull final a aVar) {
        Fragment e10 = this.f7227f.e(aVar.s());
        if (e10 != null) {
            FrameLayout W = aVar.W();
            View view = e10.getView();
            if (!e10.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            } else if (e10.isAdded() && view == null) {
                Y(e10, W);
            } else if (!e10.isAdded() || view.getParent() == null) {
                if (e10.isAdded()) {
                    G(view, W);
                } else if (!Z()) {
                    Y(e10, W);
                    b0 p10 = this.f7226e.p();
                    p10.e(e10, NetworkProfile.FEMALE + aVar.s()).w(e10, Lifecycle.State.STARTED).k();
                    this.f7230j.d(false);
                } else if (!this.f7226e.I0()) {
                    this.f7225d.a(new i() {
                        public void e(@NonNull l lVar, @NonNull Lifecycle.Event event) {
                            if (!FragmentStateAdapter.this.Z()) {
                                lVar.getLifecycle().d(this);
                                if (n0.V(aVar.W())) {
                                    FragmentStateAdapter.this.V(aVar);
                                }
                            }
                        }
                    });
                }
            } else if (view.getParent() != W) {
                G(view, W);
            }
        } else {
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean Z() {
        return this.f7226e.Q0();
    }

    @NonNull
    public final Parcelable a() {
        Bundle bundle = new Bundle(this.f7227f.q() + this.f7228g.q());
        for (int i10 = 0; i10 < this.f7227f.q(); i10++) {
            long k10 = this.f7227f.k(i10);
            Fragment e10 = this.f7227f.e(k10);
            if (e10 != null && e10.isAdded()) {
                this.f7226e.i1(bundle, J("f#", k10), e10);
            }
        }
        for (int i11 = 0; i11 < this.f7228g.q(); i11++) {
            long k11 = this.f7228g.k(i11);
            if (H(k11)) {
                bundle.putParcelable(J("s#", k11), this.f7228g.e(k11));
            }
        }
        return bundle;
    }

    public final void b(@NonNull Parcelable parcelable) {
        if (!this.f7228g.j() || !this.f7227f.j()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String next : bundle.keySet()) {
            if (N(next, "f#")) {
                this.f7227f.l(U(next, "f#"), this.f7226e.s0(bundle, next));
            } else if (N(next, "s#")) {
                long U = U(next, "s#");
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(next);
                if (H(U)) {
                    this.f7228g.l(U, savedState);
                }
            } else {
                throw new IllegalArgumentException("Unexpected key in savedState: " + next);
            }
        }
        if (!this.f7227f.j()) {
            this.f7232l = true;
            this.f7231k = true;
            L();
            X();
        }
    }

    public long h(int i10) {
        return (long) i10;
    }

    public void u(@NonNull RecyclerView recyclerView) {
        boolean z10;
        if (this.f7230j == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        androidx.core.util.h.a(z10);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.f7230j = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.b(recyclerView);
    }

    public void y(@NonNull RecyclerView recyclerView) {
        this.f7230j.c(recyclerView);
        this.f7230j = null;
    }

    public FragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        this.f7227f = new e<>();
        this.f7228g = new e<>();
        this.f7229h = new e<>();
        this.f7231k = false;
        this.f7232l = false;
        this.f7226e = fragmentManager;
        this.f7225d = lifecycle;
        super.E(true);
    }
}
