package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.NonNull;
import androidx.core.app.n0;
import androidx.core.view.a0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.b0;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager {
    private static boolean S = false;
    private l A = new d();
    private h0 B = null;
    private h0 C = new e();
    private androidx.activity.result.c<Intent> D;
    private androidx.activity.result.c<IntentSenderRequest> E;
    private androidx.activity.result.c<String[]> F;
    ArrayDeque<LaunchedFragmentInfo> G = new ArrayDeque<>();
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private ArrayList<a> M;
    private ArrayList<Boolean> N;
    private ArrayList<Fragment> O;
    private v P;
    private FragmentStrictMode.b Q;
    private Runnable R = new f();

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<m> f5631a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f5632b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final a0 f5633c = new a0();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<a> f5634d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Fragment> f5635e;

    /* renamed from: f  reason: collision with root package name */
    private final n f5636f = new n(this);

    /* renamed from: g  reason: collision with root package name */
    private OnBackPressedDispatcher f5637g;

    /* renamed from: h  reason: collision with root package name */
    private final androidx.activity.l f5638h = new b(false);

    /* renamed from: i  reason: collision with root package name */
    private final AtomicInteger f5639i = new AtomicInteger();

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, BackStackState> f5640j = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final Map<String, Bundle> f5641k = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final Map<String, Object> f5642l = Collections.synchronizedMap(new HashMap());

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<l> f5643m;

    /* renamed from: n  reason: collision with root package name */
    private final o f5644n = new o(this);

    /* renamed from: o  reason: collision with root package name */
    private final CopyOnWriteArrayList<w> f5645o = new CopyOnWriteArrayList<>();

    /* renamed from: p  reason: collision with root package name */
    private final androidx.core.util.a<Configuration> f5646p = new p(this);

    /* renamed from: q  reason: collision with root package name */
    private final androidx.core.util.a<Integer> f5647q = new q(this);

    /* renamed from: r  reason: collision with root package name */
    private final androidx.core.util.a<androidx.core.app.m> f5648r = new r(this);

    /* renamed from: s  reason: collision with root package name */
    private final androidx.core.util.a<n0> f5649s = new s(this);

    /* renamed from: t  reason: collision with root package name */
    private final a0 f5650t = new c();

    /* renamed from: u  reason: collision with root package name */
    int f5651u = -1;

    /* renamed from: v  reason: collision with root package name */
    private m<?> f5652v;

    /* renamed from: w  reason: collision with root package name */
    private j f5653w;

    /* renamed from: x  reason: collision with root package name */
    private Fragment f5654x;

    /* renamed from: y  reason: collision with root package name */
    Fragment f5655y;

    /* renamed from: z  reason: collision with root package name */
    private l f5656z = null;

    /* renamed from: androidx.fragment.app.FragmentManager$6  reason: invalid class name */
    class AnonymousClass6 implements androidx.lifecycle.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f5657a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y f5658b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Lifecycle f5659c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FragmentManager f5660d;

        public void e(@NonNull androidx.lifecycle.l lVar, @NonNull Lifecycle.Event event) {
            Bundle bundle;
            if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) this.f5660d.f5641k.get(this.f5657a)) != null) {
                this.f5658b.a(this.f5657a, bundle);
                this.f5660d.u(this.f5657a);
            }
            if (event == Lifecycle.Event.ON_DESTROY) {
                this.f5659c.d(this);
                this.f5660d.f5642l.remove(this.f5657a);
            }
        }
    }

    class a implements androidx.activity.result.a<Map<String, Boolean>> {
        a() {
        }

        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: b */
        public void a(Map<String, Boolean> map) {
            int i10;
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                if (((Boolean) arrayList.get(i11)).booleanValue()) {
                    i10 = 0;
                } else {
                    i10 = -1;
                }
                iArr[i11] = i10;
            }
            LaunchedFragmentInfo pollFirst = FragmentManager.this.G.pollFirst();
            if (pollFirst == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("No permissions were requested for ");
                sb2.append(this);
                return;
            }
            String str = pollFirst.f5661a;
            int i12 = pollFirst.f5662b;
            Fragment i13 = FragmentManager.this.f5633c.i(str);
            if (i13 == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Permission request result delivered for unknown Fragment ");
                sb3.append(str);
                return;
            }
            i13.onRequestPermissionsResult(i12, strArr, iArr);
        }
    }

    class b extends androidx.activity.l {
        b(boolean z10) {
            super(z10);
        }

        public void b() {
            FragmentManager.this.F0();
        }
    }

    class c implements a0 {
        c() {
        }

        public void a(@NonNull Menu menu) {
            FragmentManager.this.M(menu);
        }

        public void b(@NonNull Menu menu) {
            FragmentManager.this.Q(menu);
        }

        public boolean c(@NonNull MenuItem menuItem) {
            return FragmentManager.this.L(menuItem);
        }

        public void d(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
            FragmentManager.this.E(menu, menuInflater);
        }
    }

    class d extends l {
        d() {
        }

        @NonNull
        public Fragment a(@NonNull ClassLoader classLoader, @NonNull String str) {
            return FragmentManager.this.w0().b(FragmentManager.this.w0().f(), str, (Bundle) null);
        }
    }

    class e implements h0 {
        e() {
        }

        @NonNull
        public SpecialEffectsController a(@NonNull ViewGroup viewGroup) {
            return new b(viewGroup);
        }
    }

    class f implements Runnable {
        f() {
        }

        public void run() {
            FragmentManager.this.c0(true);
        }
    }

    class g implements w {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f5669a;

        g(Fragment fragment) {
            this.f5669a = fragment;
        }

        public void a(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            this.f5669a.onAttachFragment(fragment);
        }
    }

    class h implements androidx.activity.result.a<ActivityResult> {
        h() {
        }

        /* renamed from: b */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo pollFirst = FragmentManager.this.G.pollFirst();
            if (pollFirst == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("No Activities were started for result for ");
                sb2.append(this);
                return;
            }
            String str = pollFirst.f5661a;
            int i10 = pollFirst.f5662b;
            Fragment i11 = FragmentManager.this.f5633c.i(str);
            if (i11 == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Activity result delivered for unknown Fragment ");
                sb3.append(str);
                return;
            }
            i11.onActivityResult(i10, activityResult.c(), activityResult.a());
        }
    }

    class i implements androidx.activity.result.a<ActivityResult> {
        i() {
        }

        /* renamed from: b */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo pollFirst = FragmentManager.this.G.pollFirst();
            if (pollFirst == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("No IntentSenders were started for ");
                sb2.append(this);
                return;
            }
            String str = pollFirst.f5661a;
            int i10 = pollFirst.f5662b;
            Fragment i11 = FragmentManager.this.f5633c.i(str);
            if (i11 == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Intent Sender result delivered for unknown Fragment ");
                sb3.append(str);
                return;
            }
            i11.onActivityResult(i10, activityResult.c(), activityResult.a());
        }
    }

    static class j extends c.a<IntentSenderRequest, ActivityResult> {
        j() {
        }

        @NonNull
        /* renamed from: a */
        public Intent createIntent(@NonNull Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent a10 = intentSenderRequest.a();
            if (!(a10 == null || (bundleExtra = a10.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                a10.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (a10.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.a(intentSenderRequest.e()).b((Intent) null).c(intentSenderRequest.d(), intentSenderRequest.c()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.J0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CreateIntent created the following intent: ");
                sb2.append(intent);
            }
            return intent;
        }

        @NonNull
        /* renamed from: b */
        public ActivityResult parseResult(int i10, Intent intent) {
            return new ActivityResult(i10, intent);
        }
    }

    public static abstract class k {
        @Deprecated
        public void onFragmentActivityCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, Bundle bundle) {
        }

        public void onFragmentAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void onFragmentCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, Bundle bundle) {
        }

        public void onFragmentDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentDetached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentPaused(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentPreAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        }

        public void onFragmentPreCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, Bundle bundle) {
        }

        public void onFragmentResumed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Bundle bundle) {
        }

        public void onFragmentStarted(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentStopped(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }

        public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, Bundle bundle) {
        }

        public void onFragmentViewDestroyed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        }
    }

    public interface l {
        void onBackStackChanged();
    }

    interface m {
        boolean a(@NonNull ArrayList<a> arrayList, @NonNull ArrayList<Boolean> arrayList2);
    }

    private class n implements m {

        /* renamed from: a  reason: collision with root package name */
        final String f5673a;

        /* renamed from: b  reason: collision with root package name */
        final int f5674b;

        /* renamed from: c  reason: collision with root package name */
        final int f5675c;

        n(String str, int i10, int i11) {
            this.f5673a = str;
            this.f5674b = i10;
            this.f5675c = i11;
        }

        public boolean a(@NonNull ArrayList<a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.f5655y;
            if (fragment != null && this.f5674b < 0 && this.f5673a == null && fragment.getChildFragmentManager().e1()) {
                return false;
            }
            return FragmentManager.this.h1(arrayList, arrayList2, this.f5673a, this.f5674b, this.f5675c);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (p0() <= 0) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (O0(r3.f5654x) == false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r0.f(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = r3.f5638h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void B1() {
        /*
            r3 = this;
            java.util.ArrayList<androidx.fragment.app.FragmentManager$m> r0 = r3.f5631a
            monitor-enter(r0)
            java.util.ArrayList<androidx.fragment.app.FragmentManager$m> r1 = r3.f5631a     // Catch:{ all -> 0x002a }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != 0) goto L_0x0013
            androidx.activity.l r1 = r3.f5638h     // Catch:{ all -> 0x002a }
            r1.f(r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            androidx.activity.l r0 = r3.f5638h
            int r1 = r3.p0()
            if (r1 <= 0) goto L_0x0025
            androidx.fragment.app.Fragment r1 = r3.f5654x
            boolean r1 = r3.O0(r1)
            if (r1 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = 0
        L_0x0026:
            r0.f(r2)
            return
        L_0x002a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.B1():void");
    }

    static Fragment D0(@NonNull View view) {
        Object tag = view.getTag(h1.b.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public static boolean J0(int i10) {
        return S || Log.isLoggable("FragmentManager", i10);
    }

    private boolean K0(@NonNull Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.q();
    }

    private boolean L0() {
        Fragment fragment = this.f5654x;
        if (fragment == null) {
            return true;
        }
        if (!fragment.isAdded() || !this.f5654x.getParentFragmentManager().L0()) {
            return false;
        }
        return true;
    }

    private void N(Fragment fragment) {
        if (fragment != null && fragment.equals(g0(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S0(Configuration configuration) {
        if (L0()) {
            B(configuration, false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T0(Integer num) {
        if (L0() && num.intValue() == 80) {
            H(false);
        }
    }

    /* JADX INFO: finally extract failed */
    private void U(int i10) {
        try {
            this.f5632b = true;
            this.f5633c.d(i10);
            Z0(i10, false);
            for (SpecialEffectsController j10 : v()) {
                j10.j();
            }
            this.f5632b = false;
            c0(true);
        } catch (Throwable th2) {
            this.f5632b = false;
            throw th2;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U0(androidx.core.app.m mVar) {
        if (L0()) {
            I(mVar.a(), false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V0(n0 n0Var) {
        if (L0()) {
            P(n0Var.a(), false);
        }
    }

    private void X() {
        if (this.L) {
            this.L = false;
            y1();
        }
    }

    private void Z() {
        for (SpecialEffectsController j10 : v()) {
            j10.j();
        }
    }

    private void b0(boolean z10) {
        if (this.f5632b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.f5652v == null) {
            if (this.K) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() == this.f5652v.g().getLooper()) {
            if (!z10) {
                r();
            }
            if (this.M == null) {
                this.M = new ArrayList<>();
                this.N = new ArrayList<>();
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    private static void e0(@NonNull ArrayList<a> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i10, int i11) {
        while (i10 < i11) {
            a aVar = arrayList.get(i10);
            if (arrayList2.get(i10).booleanValue()) {
                aVar.z(-1);
                aVar.E();
            } else {
                aVar.z(1);
                aVar.D();
            }
            i10++;
        }
    }

    private void f0(@NonNull ArrayList<a> arrayList, @NonNull ArrayList<Boolean> arrayList2, int i10, int i11) {
        boolean z10 = arrayList.get(i10).f5799r;
        ArrayList<Fragment> arrayList3 = this.O;
        if (arrayList3 == null) {
            this.O = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.O.addAll(this.f5633c.o());
        Fragment A0 = A0();
        boolean z11 = false;
        for (int i12 = i10; i12 < i11; i12++) {
            a aVar = arrayList.get(i12);
            if (!arrayList2.get(i12).booleanValue()) {
                A0 = aVar.F(this.O, A0);
            } else {
                A0 = aVar.I(this.O, A0);
            }
            if (z11 || aVar.f5790i) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        this.O.clear();
        if (!z10 && this.f5651u >= 1) {
            for (int i13 = i10; i13 < i11; i13++) {
                Iterator<b0.a> it = arrayList.get(i13).f5784c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = it.next().f5802b;
                    if (!(fragment == null || fragment.mFragmentManager == null)) {
                        this.f5633c.r(x(fragment));
                    }
                }
            }
        }
        e0(arrayList, arrayList2, i10, i11);
        boolean booleanValue = arrayList2.get(i11 - 1).booleanValue();
        for (int i14 = i10; i14 < i11; i14++) {
            a aVar2 = arrayList.get(i14);
            if (booleanValue) {
                for (int size = aVar2.f5784c.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = aVar2.f5784c.get(size).f5802b;
                    if (fragment2 != null) {
                        x(fragment2).m();
                    }
                }
            } else {
                Iterator<b0.a> it2 = aVar2.f5784c.iterator();
                while (it2.hasNext()) {
                    Fragment fragment3 = it2.next().f5802b;
                    if (fragment3 != null) {
                        x(fragment3).m();
                    }
                }
            }
        }
        Z0(this.f5651u, true);
        for (SpecialEffectsController next : w(arrayList, i10, i11)) {
            next.r(booleanValue);
            next.p();
            next.g();
        }
        while (i10 < i11) {
            a aVar3 = arrayList.get(i10);
            if (arrayList2.get(i10).booleanValue() && aVar3.f5730v >= 0) {
                aVar3.f5730v = -1;
            }
            aVar3.H();
            i10++;
        }
        if (z11) {
            n1();
        }
    }

    private boolean g1(String str, int i10, int i11) {
        c0(false);
        b0(true);
        Fragment fragment = this.f5655y;
        if (fragment != null && i10 < 0 && str == null && fragment.getChildFragmentManager().e1()) {
            return true;
        }
        boolean h12 = h1(this.M, this.N, str, i10, i11);
        if (h12) {
            this.f5632b = true;
            try {
                l1(this.M, this.N);
            } finally {
                s();
            }
        }
        B1();
        X();
        this.f5633c.b();
        return h12;
    }

    private int h0(String str, int i10, boolean z10) {
        ArrayList<a> arrayList = this.f5634d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str != null || i10 >= 0) {
            int size = this.f5634d.size() - 1;
            while (size >= 0) {
                a aVar = this.f5634d.get(size);
                if ((str != null && str.equals(aVar.G())) || (i10 >= 0 && i10 == aVar.f5730v)) {
                    break;
                }
                size--;
            }
            if (size < 0) {
                return size;
            }
            if (z10) {
                while (size > 0) {
                    a aVar2 = this.f5634d.get(size - 1);
                    if ((str == null || !str.equals(aVar2.G())) && (i10 < 0 || i10 != aVar2.f5730v)) {
                        return size;
                    }
                    size--;
                }
                return size;
            } else if (size == this.f5634d.size() - 1) {
                return -1;
            } else {
                return size + 1;
            }
        } else if (z10) {
            return 0;
        } else {
            return this.f5634d.size() - 1;
        }
    }

    @NonNull
    static FragmentManager l0(@NonNull View view) {
        Fragment m02 = m0(view);
        if (m02 == null) {
            Context context = view.getContext();
            h hVar = null;
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                } else if (context instanceof h) {
                    hVar = (h) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (hVar != null) {
                return hVar.getSupportFragmentManager();
            }
            throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
        } else if (m02.isAdded()) {
            return m02.getChildFragmentManager();
        } else {
            throw new IllegalStateException("The Fragment " + m02 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
    }

    private void l1(@NonNull ArrayList<a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                int size = arrayList.size();
                int i10 = 0;
                int i11 = 0;
                while (i10 < size) {
                    if (!arrayList.get(i10).f5799r) {
                        if (i11 != i10) {
                            f0(arrayList, arrayList2, i11, i10);
                        }
                        i11 = i10 + 1;
                        if (arrayList2.get(i10).booleanValue()) {
                            while (i11 < size && arrayList2.get(i11).booleanValue() && !arrayList.get(i11).f5799r) {
                                i11++;
                            }
                        }
                        f0(arrayList, arrayList2, i10, i11);
                        i10 = i11 - 1;
                    }
                    i10++;
                }
                if (i11 != size) {
                    f0(arrayList, arrayList2, i11, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    private static Fragment m0(@NonNull View view) {
        while (view != null) {
            Fragment D0 = D0(view);
            if (D0 != null) {
                return D0;
            }
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
        }
        return null;
    }

    private void n0() {
        for (SpecialEffectsController k10 : v()) {
            k10.k();
        }
    }

    private void n1() {
        if (this.f5643m != null) {
            for (int i10 = 0; i10 < this.f5643m.size(); i10++) {
                this.f5643m.get(i10).onBackStackChanged();
            }
        }
    }

    private boolean o0(@NonNull ArrayList<a> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        synchronized (this.f5631a) {
            if (this.f5631a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f5631a.size();
                boolean z10 = false;
                for (int i10 = 0; i10 < size; i10++) {
                    z10 |= this.f5631a.get(i10).a(arrayList, arrayList2);
                }
                return z10;
            } finally {
                this.f5631a.clear();
                this.f5652v.g().removeCallbacks(this.R);
            }
        }
    }

    static int p1(int i10) {
        if (i10 == 4097) {
            return 8194;
        }
        if (i10 == 8194) {
            return 4097;
        }
        if (i10 == 8197) {
            return 4100;
        }
        if (i10 != 4099) {
            return i10 != 4100 ? 0 : 8197;
        }
        return 4099;
    }

    @NonNull
    private v q0(@NonNull Fragment fragment) {
        return this.P.k(fragment);
    }

    private void r() {
        if (Q0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void s() {
        this.f5632b = false;
        this.N.clear();
        this.M.clear();
    }

    private void t() {
        m<?> mVar = this.f5652v;
        boolean z10 = true;
        if (mVar instanceof l0) {
            z10 = this.f5633c.p().o();
        } else if (mVar.f() instanceof Activity) {
            z10 = true ^ ((Activity) this.f5652v.f()).isChangingConfigurations();
        }
        if (z10) {
            for (BackStackState backStackState : this.f5640j.values()) {
                for (String h10 : backStackState.f5585a) {
                    this.f5633c.p().h(h10);
                }
            }
        }
    }

    private ViewGroup t0(@NonNull Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f5653w.d()) {
            View c10 = this.f5653w.c(fragment.mContainerId);
            if (c10 instanceof ViewGroup) {
                return (ViewGroup) c10;
            }
        }
        return null;
    }

    private Set<SpecialEffectsController> v() {
        HashSet hashSet = new HashSet();
        for (z k10 : this.f5633c.k()) {
            ViewGroup viewGroup = k10.k().mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.o(viewGroup, B0()));
            }
        }
        return hashSet;
    }

    private Set<SpecialEffectsController> w(@NonNull ArrayList<a> arrayList, int i10, int i11) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i10 < i11) {
            Iterator<b0.a> it = arrayList.get(i10).f5784c.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f5802b;
                if (!(fragment == null || (viewGroup = fragment.mContainer) == null)) {
                    hashSet.add(SpecialEffectsController.n(viewGroup, this));
                }
            }
            i10++;
        }
        return hashSet;
    }

    private void w1(@NonNull Fragment fragment) {
        ViewGroup t02 = t0(fragment);
        if (t02 != null && fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() > 0) {
            int i10 = h1.b.visible_removing_fragment_view_tag;
            if (t02.getTag(i10) == null) {
                t02.setTag(i10, fragment);
            }
            ((Fragment) t02.getTag(i10)).setPopDirection(fragment.getPopDirection());
        }
    }

    private void y1() {
        for (z c12 : this.f5633c.k()) {
            c1(c12);
        }
    }

    private void z1(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new g0("FragmentManager"));
        m<?> mVar = this.f5652v;
        if (mVar != null) {
            try {
                mVar.h("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception unused) {
            }
        } else {
            Y("  ", (FileDescriptor) null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    /* access modifiers changed from: package-private */
    public void A() {
        this.I = false;
        this.J = false;
        this.P.q(false);
        U(0);
    }

    public Fragment A0() {
        return this.f5655y;
    }

    public void A1(@NonNull k kVar) {
        this.f5644n.p(kVar);
    }

    /* access modifiers changed from: package-private */
    public void B(@NonNull Configuration configuration, boolean z10) {
        if (z10 && (this.f5652v instanceof androidx.core.content.e)) {
            z1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment next : this.f5633c.o()) {
            if (next != null) {
                next.performConfigurationChanged(configuration);
                if (z10) {
                    next.mChildFragmentManager.B(configuration, true);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public h0 B0() {
        h0 h0Var = this.B;
        if (h0Var != null) {
            return h0Var;
        }
        Fragment fragment = this.f5654x;
        if (fragment != null) {
            return fragment.mFragmentManager.B0();
        }
        return this.C;
    }

    /* access modifiers changed from: package-private */
    public boolean C(@NonNull MenuItem menuItem) {
        if (this.f5651u < 1) {
            return false;
        }
        for (Fragment next : this.f5633c.o()) {
            if (next != null && next.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public FragmentStrictMode.b C0() {
        return this.Q;
    }

    /* access modifiers changed from: package-private */
    public void D() {
        this.I = false;
        this.J = false;
        this.P.q(false);
        U(1);
    }

    /* access modifiers changed from: package-private */
    public boolean E(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        if (this.f5651u < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z10 = false;
        for (Fragment next : this.f5633c.o()) {
            if (next != null && N0(next) && next.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next);
                z10 = true;
            }
        }
        if (this.f5635e != null) {
            for (int i10 = 0; i10 < this.f5635e.size(); i10++) {
                Fragment fragment = this.f5635e.get(i10);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
            }
        }
        this.f5635e = arrayList;
        return z10;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public k0 E0(@NonNull Fragment fragment) {
        return this.P.n(fragment);
    }

    /* access modifiers changed from: package-private */
    public void F() {
        this.K = true;
        c0(true);
        Z();
        t();
        U(-1);
        m<?> mVar = this.f5652v;
        if (mVar instanceof androidx.core.content.f) {
            ((androidx.core.content.f) mVar).removeOnTrimMemoryListener(this.f5647q);
        }
        m<?> mVar2 = this.f5652v;
        if (mVar2 instanceof androidx.core.content.e) {
            ((androidx.core.content.e) mVar2).removeOnConfigurationChangedListener(this.f5646p);
        }
        m<?> mVar3 = this.f5652v;
        if (mVar3 instanceof androidx.core.app.k0) {
            ((androidx.core.app.k0) mVar3).removeOnMultiWindowModeChangedListener(this.f5648r);
        }
        m<?> mVar4 = this.f5652v;
        if (mVar4 instanceof androidx.core.app.l0) {
            ((androidx.core.app.l0) mVar4).removeOnPictureInPictureModeChangedListener(this.f5649s);
        }
        m<?> mVar5 = this.f5652v;
        if ((mVar5 instanceof androidx.core.view.i) && this.f5654x == null) {
            ((androidx.core.view.i) mVar5).removeMenuProvider(this.f5650t);
        }
        this.f5652v = null;
        this.f5653w = null;
        this.f5654x = null;
        if (this.f5637g != null) {
            this.f5638h.d();
            this.f5637g = null;
        }
        androidx.activity.result.c<Intent> cVar = this.D;
        if (cVar != null) {
            cVar.d();
            this.E.d();
            this.F.d();
        }
    }

    /* access modifiers changed from: package-private */
    public void F0() {
        c0(true);
        if (this.f5638h.c()) {
            e1();
        } else {
            this.f5637g.e();
        }
    }

    /* access modifiers changed from: package-private */
    public void G() {
        U(1);
    }

    /* access modifiers changed from: package-private */
    public void G0(@NonNull Fragment fragment) {
        if (J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("hide: ");
            sb2.append(fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            w1(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void H(boolean z10) {
        if (z10 && (this.f5652v instanceof androidx.core.content.f)) {
            z1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment next : this.f5633c.o()) {
            if (next != null) {
                next.performLowMemory();
                if (z10) {
                    next.mChildFragmentManager.H(true);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void H0(@NonNull Fragment fragment) {
        if (fragment.mAdded && K0(fragment)) {
            this.H = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void I(boolean z10, boolean z11) {
        if (z11 && (this.f5652v instanceof androidx.core.app.k0)) {
            z1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment next : this.f5633c.o()) {
            if (next != null) {
                next.performMultiWindowModeChanged(z10);
                if (z11) {
                    next.mChildFragmentManager.I(z10, true);
                }
            }
        }
    }

    public boolean I0() {
        return this.K;
    }

    /* access modifiers changed from: package-private */
    public void J(@NonNull Fragment fragment) {
        Iterator<w> it = this.f5645o.iterator();
        while (it.hasNext()) {
            it.next().a(this, fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void K() {
        for (Fragment next : this.f5633c.l()) {
            if (next != null) {
                next.onHiddenChanged(next.isHidden());
                next.mChildFragmentManager.K();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean L(@NonNull MenuItem menuItem) {
        if (this.f5651u < 1) {
            return false;
        }
        for (Fragment next : this.f5633c.o()) {
            if (next != null && next.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void M(@NonNull Menu menu) {
        if (this.f5651u >= 1) {
            for (Fragment next : this.f5633c.o()) {
                if (next != null) {
                    next.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean M0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.isHidden();
    }

    /* access modifiers changed from: package-private */
    public boolean N0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    /* access modifiers changed from: package-private */
    public void O() {
        U(5);
    }

    /* access modifiers changed from: package-private */
    public boolean O0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (!fragment.equals(fragmentManager.A0()) || !O0(fragmentManager.f5654x)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void P(boolean z10, boolean z11) {
        if (z11 && (this.f5652v instanceof androidx.core.app.l0)) {
            z1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment next : this.f5633c.o()) {
            if (next != null) {
                next.performPictureInPictureModeChanged(z10);
                if (z11) {
                    next.mChildFragmentManager.P(z10, true);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean P0(int i10) {
        return this.f5651u >= i10;
    }

    /* access modifiers changed from: package-private */
    public boolean Q(@NonNull Menu menu) {
        boolean z10 = false;
        if (this.f5651u < 1) {
            return false;
        }
        for (Fragment next : this.f5633c.o()) {
            if (next != null && N0(next) && next.performPrepareOptionsMenu(menu)) {
                z10 = true;
            }
        }
        return z10;
    }

    public boolean Q0() {
        return this.I || this.J;
    }

    /* access modifiers changed from: package-private */
    public void R() {
        B1();
        N(this.f5655y);
    }

    /* access modifiers changed from: package-private */
    public void S() {
        this.I = false;
        this.J = false;
        this.P.q(false);
        U(7);
    }

    /* access modifiers changed from: package-private */
    public void T() {
        this.I = false;
        this.J = false;
        this.P.q(false);
        U(5);
    }

    /* access modifiers changed from: package-private */
    public void V() {
        this.J = true;
        this.P.q(true);
        U(4);
    }

    /* access modifiers changed from: package-private */
    public void W() {
        U(2);
    }

    /* access modifiers changed from: package-private */
    public void W0(@NonNull Fragment fragment, @NonNull String[] strArr, int i10) {
        if (this.F != null) {
            this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, i10));
            this.F.b(strArr);
            return;
        }
        this.f5652v.k(fragment, strArr, i10);
    }

    /* access modifiers changed from: package-private */
    public void X0(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10, Bundle bundle) {
        if (this.D != null) {
            this.G.addLast(new LaunchedFragmentInfo(fragment.mWho, i10));
            if (!(intent == null || bundle == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            this.D.b(intent);
            return;
        }
        this.f5652v.m(fragment, intent, i10, bundle);
    }

    public void Y(@NonNull String str, FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f5633c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f5635e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size2; i10++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(this.f5635e.get(i10).toString());
            }
        }
        ArrayList<a> arrayList2 = this.f5634d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size; i11++) {
                a aVar = this.f5634d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.B(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f5639i.get());
        synchronized (this.f5631a) {
            int size3 = this.f5631a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i12 = 0; i12 < size3; i12++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i12);
                    printWriter.print(": ");
                    printWriter.println(this.f5631a.get(i12));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f5652v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f5653w);
        if (this.f5654x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f5654x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f5651u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.I);
        printWriter.print(" mStopped=");
        printWriter.print(this.J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.K);
        if (this.H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.H);
        }
    }

    /* access modifiers changed from: package-private */
    public void Y0(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2;
        Fragment fragment2 = fragment;
        Bundle bundle2 = bundle;
        if (this.E != null) {
            if (bundle2 != null) {
                if (intent == null) {
                    intent2 = new Intent();
                    intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                } else {
                    intent2 = intent;
                }
                if (J0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("ActivityOptions ");
                    sb2.append(bundle2);
                    sb2.append(" were added to fillInIntent ");
                    sb2.append(intent2);
                    sb2.append(" for fragment ");
                    sb2.append(fragment);
                }
                intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle2);
            } else {
                intent2 = intent;
            }
            IntentSender intentSender2 = intentSender;
            int i14 = i11;
            IntentSenderRequest a10 = new IntentSenderRequest.a(intentSender).b(intent2).c(i12, i11).a();
            int i15 = i10;
            this.G.addLast(new LaunchedFragmentInfo(fragment2.mWho, i10));
            if (J0(2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Fragment ");
                sb3.append(fragment);
                sb3.append("is launching an IntentSender for result ");
            }
            this.E.b(a10);
            return;
        }
        IntentSender intentSender3 = intentSender;
        int i16 = i10;
        this.f5652v.n(fragment, intentSender, i10, intent, i11, i12, i13, bundle);
    }

    /* access modifiers changed from: package-private */
    public void Z0(int i10, boolean z10) {
        m<?> mVar;
        if (this.f5652v == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z10 || i10 != this.f5651u) {
            this.f5651u = i10;
            this.f5633c.t();
            y1();
            if (this.H && (mVar = this.f5652v) != null && this.f5651u == 7) {
                mVar.o();
                this.H = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a0(@NonNull m mVar, boolean z10) {
        if (!z10) {
            if (this.f5652v != null) {
                r();
            } else if (this.K) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }
        synchronized (this.f5631a) {
            if (this.f5652v != null) {
                this.f5631a.add(mVar);
                s1();
            } else if (!z10) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a1() {
        if (this.f5652v != null) {
            this.I = false;
            this.J = false;
            this.P.q(false);
            for (Fragment next : this.f5633c.o()) {
                if (next != null) {
                    next.noteStateNotSaved();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b1(@NonNull FragmentContainerView fragmentContainerView) {
        View view;
        for (z next : this.f5633c.k()) {
            Fragment k10 = next.k();
            if (k10.mContainerId == fragmentContainerView.getId() && (view = k10.mView) != null && view.getParent() == null) {
                k10.mContainer = fragmentContainerView;
                next.b();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public boolean c0(boolean z10) {
        b0(z10);
        boolean z11 = false;
        while (o0(this.M, this.N)) {
            this.f5632b = true;
            try {
                l1(this.M, this.N);
                s();
                z11 = true;
            } catch (Throwable th2) {
                s();
                throw th2;
            }
        }
        B1();
        X();
        this.f5633c.b();
        return z11;
    }

    /* access modifiers changed from: package-private */
    public void c1(@NonNull z zVar) {
        Fragment k10 = zVar.k();
        if (!k10.mDeferStart) {
            return;
        }
        if (this.f5632b) {
            this.L = true;
            return;
        }
        k10.mDeferStart = false;
        zVar.m();
    }

    /* access modifiers changed from: package-private */
    public void d0(@NonNull m mVar, boolean z10) {
        if (!z10 || (this.f5652v != null && !this.K)) {
            b0(z10);
            if (mVar.a(this.M, this.N)) {
                this.f5632b = true;
                try {
                    l1(this.M, this.N);
                } finally {
                    s();
                }
            }
            B1();
            X();
            this.f5633c.b();
        }
    }

    /* access modifiers changed from: package-private */
    public void d1(int i10, int i11, boolean z10) {
        if (i10 >= 0) {
            a0(new n((String) null, i10, i11), z10);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    public boolean e1() {
        return g1((String) null, -1, 0);
    }

    public boolean f1(int i10, int i11) {
        if (i10 >= 0) {
            return g1((String) null, i10, i11);
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    /* access modifiers changed from: package-private */
    public Fragment g0(@NonNull String str) {
        return this.f5633c.f(str);
    }

    /* access modifiers changed from: package-private */
    public boolean h1(@NonNull ArrayList<a> arrayList, @NonNull ArrayList<Boolean> arrayList2, String str, int i10, int i11) {
        boolean z10;
        if ((i11 & 1) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int h02 = h0(str, i10, z10);
        if (h02 < 0) {
            return false;
        }
        for (int size = this.f5634d.size() - 1; size >= h02; size--) {
            arrayList.add(this.f5634d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void i(a aVar) {
        if (this.f5634d == null) {
            this.f5634d = new ArrayList<>();
        }
        this.f5634d.add(aVar);
    }

    public Fragment i0(int i10) {
        return this.f5633c.g(i10);
    }

    public void i1(@NonNull Bundle bundle, @NonNull String str, @NonNull Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            z1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    /* access modifiers changed from: package-private */
    public z j(@NonNull Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.h(fragment, str);
        }
        if (J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("add: ");
            sb2.append(fragment);
        }
        z x10 = x(fragment);
        fragment.mFragmentManager = this;
        this.f5633c.r(x10);
        if (!fragment.mDetached) {
            this.f5633c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (K0(fragment)) {
                this.H = true;
            }
        }
        return x10;
    }

    public Fragment j0(String str) {
        return this.f5633c.h(str);
    }

    public void j1(@NonNull k kVar, boolean z10) {
        this.f5644n.o(kVar, z10);
    }

    public void k(@NonNull w wVar) {
        this.f5645o.add(wVar);
    }

    /* access modifiers changed from: package-private */
    public Fragment k0(@NonNull String str) {
        return this.f5633c.i(str);
    }

    /* access modifiers changed from: package-private */
    public void k1(@NonNull Fragment fragment) {
        if (J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("remove: ");
            sb2.append(fragment);
            sb2.append(" nesting=");
            sb2.append(fragment.mBackStackNesting);
        }
        boolean z10 = !fragment.isInBackStack();
        if (!fragment.mDetached || z10) {
            this.f5633c.u(fragment);
            if (K0(fragment)) {
                this.H = true;
            }
            fragment.mRemoving = true;
            w1(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public void l(@NonNull Fragment fragment) {
        this.P.f(fragment);
    }

    /* access modifiers changed from: package-private */
    public int m() {
        return this.f5639i.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    public void m1(@NonNull Fragment fragment) {
        this.P.p(fragment);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.activity.n} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v36, resolved type: androidx.fragment.app.Fragment} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"SyntheticAccessor"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n(@androidx.annotation.NonNull androidx.fragment.app.m<?> r4, @androidx.annotation.NonNull androidx.fragment.app.j r5, androidx.fragment.app.Fragment r6) {
        /*
            r3 = this;
            androidx.fragment.app.m<?> r0 = r3.f5652v
            if (r0 != 0) goto L_0x016c
            r3.f5652v = r4
            r3.f5653w = r5
            r3.f5654x = r6
            if (r6 == 0) goto L_0x0015
            androidx.fragment.app.FragmentManager$g r5 = new androidx.fragment.app.FragmentManager$g
            r5.<init>(r6)
            r3.k(r5)
            goto L_0x001f
        L_0x0015:
            boolean r5 = r4 instanceof androidx.fragment.app.w
            if (r5 == 0) goto L_0x001f
            r5 = r4
            androidx.fragment.app.w r5 = (androidx.fragment.app.w) r5
            r3.k(r5)
        L_0x001f:
            androidx.fragment.app.Fragment r5 = r3.f5654x
            if (r5 == 0) goto L_0x0026
            r3.B1()
        L_0x0026:
            boolean r5 = r4 instanceof androidx.activity.n
            if (r5 == 0) goto L_0x003b
            r5 = r4
            androidx.activity.n r5 = (androidx.activity.n) r5
            androidx.activity.OnBackPressedDispatcher r0 = r5.getOnBackPressedDispatcher()
            r3.f5637g = r0
            if (r6 == 0) goto L_0x0036
            r5 = r6
        L_0x0036:
            androidx.activity.l r1 = r3.f5638h
            r0.b(r5, r1)
        L_0x003b:
            if (r6 == 0) goto L_0x0046
            androidx.fragment.app.FragmentManager r4 = r6.mFragmentManager
            androidx.fragment.app.v r4 = r4.q0(r6)
            r3.P = r4
            goto L_0x005f
        L_0x0046:
            boolean r5 = r4 instanceof androidx.lifecycle.l0
            if (r5 == 0) goto L_0x0057
            androidx.lifecycle.l0 r4 = (androidx.lifecycle.l0) r4
            androidx.lifecycle.k0 r4 = r4.getViewModelStore()
            androidx.fragment.app.v r4 = androidx.fragment.app.v.l(r4)
            r3.P = r4
            goto L_0x005f
        L_0x0057:
            androidx.fragment.app.v r4 = new androidx.fragment.app.v
            r5 = 0
            r4.<init>(r5)
            r3.P = r4
        L_0x005f:
            androidx.fragment.app.v r4 = r3.P
            boolean r5 = r3.Q0()
            r4.q(r5)
            androidx.fragment.app.a0 r4 = r3.f5633c
            androidx.fragment.app.v r5 = r3.P
            r4.A(r5)
            androidx.fragment.app.m<?> r4 = r3.f5652v
            boolean r5 = r4 instanceof r1.d
            if (r5 == 0) goto L_0x0090
            if (r6 != 0) goto L_0x0090
            r1.d r4 = (r1.d) r4
            androidx.savedstate.a r4 = r4.getSavedStateRegistry()
            androidx.fragment.app.t r5 = new androidx.fragment.app.t
            r5.<init>(r3)
            java.lang.String r0 = "android:support:fragments"
            r4.h(r0, r5)
            android.os.Bundle r4 = r4.b(r0)
            if (r4 == 0) goto L_0x0090
            r3.o1(r4)
        L_0x0090:
            androidx.fragment.app.m<?> r4 = r3.f5652v
            boolean r5 = r4 instanceof androidx.activity.result.d
            if (r5 == 0) goto L_0x0128
            androidx.activity.result.d r4 = (androidx.activity.result.d) r4
            androidx.activity.result.ActivityResultRegistry r4 = r4.getActivityResultRegistry()
            if (r6 == 0) goto L_0x00b2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = r6.mWho
            r5.append(r0)
            java.lang.String r0 = ":"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            goto L_0x00b4
        L_0x00b2:
            java.lang.String r5 = ""
        L_0x00b4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "FragmentManager:"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r1 = "StartActivityForResult"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            c.i r1 = new c.i
            r1.<init>()
            androidx.fragment.app.FragmentManager$h r2 = new androidx.fragment.app.FragmentManager$h
            r2.<init>()
            androidx.activity.result.c r0 = r4.j(r0, r1, r2)
            r3.D = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r1 = "StartIntentSenderForResult"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            androidx.fragment.app.FragmentManager$j r1 = new androidx.fragment.app.FragmentManager$j
            r1.<init>()
            androidx.fragment.app.FragmentManager$i r2 = new androidx.fragment.app.FragmentManager$i
            r2.<init>()
            androidx.activity.result.c r0 = r4.j(r0, r1, r2)
            r3.E = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r5 = "RequestPermissions"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            c.g r0 = new c.g
            r0.<init>()
            androidx.fragment.app.FragmentManager$a r1 = new androidx.fragment.app.FragmentManager$a
            r1.<init>()
            androidx.activity.result.c r4 = r4.j(r5, r0, r1)
            r3.F = r4
        L_0x0128:
            androidx.fragment.app.m<?> r4 = r3.f5652v
            boolean r5 = r4 instanceof androidx.core.content.e
            if (r5 == 0) goto L_0x0135
            androidx.core.content.e r4 = (androidx.core.content.e) r4
            androidx.core.util.a<android.content.res.Configuration> r5 = r3.f5646p
            r4.addOnConfigurationChangedListener(r5)
        L_0x0135:
            androidx.fragment.app.m<?> r4 = r3.f5652v
            boolean r5 = r4 instanceof androidx.core.content.f
            if (r5 == 0) goto L_0x0142
            androidx.core.content.f r4 = (androidx.core.content.f) r4
            androidx.core.util.a<java.lang.Integer> r5 = r3.f5647q
            r4.addOnTrimMemoryListener(r5)
        L_0x0142:
            androidx.fragment.app.m<?> r4 = r3.f5652v
            boolean r5 = r4 instanceof androidx.core.app.k0
            if (r5 == 0) goto L_0x014f
            androidx.core.app.k0 r4 = (androidx.core.app.k0) r4
            androidx.core.util.a<androidx.core.app.m> r5 = r3.f5648r
            r4.addOnMultiWindowModeChangedListener(r5)
        L_0x014f:
            androidx.fragment.app.m<?> r4 = r3.f5652v
            boolean r5 = r4 instanceof androidx.core.app.l0
            if (r5 == 0) goto L_0x015c
            androidx.core.app.l0 r4 = (androidx.core.app.l0) r4
            androidx.core.util.a<androidx.core.app.n0> r5 = r3.f5649s
            r4.addOnPictureInPictureModeChangedListener(r5)
        L_0x015c:
            androidx.fragment.app.m<?> r4 = r3.f5652v
            boolean r5 = r4 instanceof androidx.core.view.i
            if (r5 == 0) goto L_0x016b
            if (r6 != 0) goto L_0x016b
            androidx.core.view.i r4 = (androidx.core.view.i) r4
            androidx.core.view.a0 r5 = r3.f5650t
            r4.addMenuProvider(r5)
        L_0x016b:
            return
        L_0x016c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "Already attached"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.n(androidx.fragment.app.m, androidx.fragment.app.j, androidx.fragment.app.Fragment):void");
    }

    /* access modifiers changed from: package-private */
    public void o(@NonNull Fragment fragment) {
        if (J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("attach: ");
            sb2.append(fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.f5633c.a(fragment);
                if (J0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("add from attach: ");
                    sb3.append(fragment);
                }
                if (K0(fragment)) {
                    this.H = true;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o1(Parcelable parcelable) {
        z zVar;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable != null) {
            Bundle bundle3 = (Bundle) parcelable;
            for (String next : bundle3.keySet()) {
                if (next.startsWith("result_") && (bundle2 = bundle3.getBundle(next)) != null) {
                    bundle2.setClassLoader(this.f5652v.f().getClassLoader());
                    this.f5641k.put(next.substring(7), bundle2);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (String next2 : bundle3.keySet()) {
                if (next2.startsWith("fragment_") && (bundle = bundle3.getBundle(next2)) != null) {
                    bundle.setClassLoader(this.f5652v.f().getClassLoader());
                    arrayList.add((FragmentState) bundle.getParcelable("state"));
                }
            }
            this.f5633c.x(arrayList);
            FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
            if (fragmentManagerState != null) {
                this.f5633c.v();
                Iterator<String> it = fragmentManagerState.f5677a.iterator();
                while (it.hasNext()) {
                    FragmentState B2 = this.f5633c.B(it.next(), (FragmentState) null);
                    if (B2 != null) {
                        Fragment j10 = this.P.j(B2.f5686b);
                        if (j10 != null) {
                            if (J0(2)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("restoreSaveState: re-attaching retained ");
                                sb2.append(j10);
                            }
                            zVar = new z(this.f5644n, this.f5633c, j10, B2);
                        } else {
                            zVar = new z(this.f5644n, this.f5633c, this.f5652v.f().getClassLoader(), u0(), B2);
                        }
                        Fragment k10 = zVar.k();
                        k10.mFragmentManager = this;
                        if (J0(2)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("restoreSaveState: active (");
                            sb3.append(k10.mWho);
                            sb3.append("): ");
                            sb3.append(k10);
                        }
                        zVar.o(this.f5652v.f().getClassLoader());
                        this.f5633c.r(zVar);
                        zVar.u(this.f5651u);
                    }
                }
                for (Fragment next3 : this.P.m()) {
                    if (!this.f5633c.c(next3.mWho)) {
                        if (J0(2)) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("Discarding retained Fragment ");
                            sb4.append(next3);
                            sb4.append(" that was not found in the set of active Fragments ");
                            sb4.append(fragmentManagerState.f5677a);
                        }
                        this.P.p(next3);
                        next3.mFragmentManager = this;
                        z zVar2 = new z(this.f5644n, this.f5633c, next3);
                        zVar2.u(1);
                        zVar2.m();
                        next3.mRemoving = true;
                        zVar2.m();
                    }
                }
                this.f5633c.w(fragmentManagerState.f5678b);
                if (fragmentManagerState.f5679c != null) {
                    this.f5634d = new ArrayList<>(fragmentManagerState.f5679c.length);
                    int i10 = 0;
                    while (true) {
                        BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.f5679c;
                        if (i10 >= backStackRecordStateArr.length) {
                            break;
                        }
                        a c10 = backStackRecordStateArr[i10].c(this);
                        if (J0(2)) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("restoreAllState: back stack #");
                            sb5.append(i10);
                            sb5.append(" (index ");
                            sb5.append(c10.f5730v);
                            sb5.append("): ");
                            sb5.append(c10);
                            PrintWriter printWriter = new PrintWriter(new g0("FragmentManager"));
                            c10.C("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f5634d.add(c10);
                        i10++;
                    }
                } else {
                    this.f5634d = null;
                }
                this.f5639i.set(fragmentManagerState.f5680d);
                String str = fragmentManagerState.f5681e;
                if (str != null) {
                    Fragment g02 = g0(str);
                    this.f5655y = g02;
                    N(g02);
                }
                ArrayList<String> arrayList2 = fragmentManagerState.f5682f;
                if (arrayList2 != null) {
                    for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                        this.f5640j.put(arrayList2.get(i11), fragmentManagerState.f5683g.get(i11));
                    }
                }
                this.G = new ArrayDeque<>(fragmentManagerState.f5684h);
            }
        }
    }

    @NonNull
    public b0 p() {
        return new a(this);
    }

    public int p0() {
        ArrayList<a> arrayList = this.f5634d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        boolean z10 = false;
        for (Fragment next : this.f5633c.l()) {
            if (next != null) {
                z10 = K0(next);
                continue;
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: q1 */
    public Bundle R0() {
        int size;
        Bundle bundle = new Bundle();
        n0();
        Z();
        c0(true);
        this.I = true;
        this.P.q(true);
        ArrayList<String> y10 = this.f5633c.y();
        ArrayList<FragmentState> m10 = this.f5633c.m();
        if (m10.isEmpty()) {
            J0(2);
        } else {
            ArrayList<String> z10 = this.f5633c.z();
            BackStackRecordState[] backStackRecordStateArr = null;
            ArrayList<a> arrayList = this.f5634d;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i10 = 0; i10 < size; i10++) {
                    backStackRecordStateArr[i10] = new BackStackRecordState(this.f5634d.get(i10));
                    if (J0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("saveAllState: adding back stack #");
                        sb2.append(i10);
                        sb2.append(": ");
                        sb2.append(this.f5634d.get(i10));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f5677a = y10;
            fragmentManagerState.f5678b = z10;
            fragmentManagerState.f5679c = backStackRecordStateArr;
            fragmentManagerState.f5680d = this.f5639i.get();
            Fragment fragment = this.f5655y;
            if (fragment != null) {
                fragmentManagerState.f5681e = fragment.mWho;
            }
            fragmentManagerState.f5682f.addAll(this.f5640j.keySet());
            fragmentManagerState.f5683g.addAll(this.f5640j.values());
            fragmentManagerState.f5684h = new ArrayList<>(this.G);
            bundle.putParcelable("state", fragmentManagerState);
            for (String next : this.f5641k.keySet()) {
                bundle.putBundle("result_" + next, this.f5641k.get(next));
            }
            Iterator<FragmentState> it = m10.iterator();
            while (it.hasNext()) {
                FragmentState next2 = it.next();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", next2);
                bundle.putBundle("fragment_" + next2.f5686b, bundle2);
            }
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public j r0() {
        return this.f5653w;
    }

    public Fragment.SavedState r1(@NonNull Fragment fragment) {
        z n10 = this.f5633c.n(fragment.mWho);
        if (n10 == null || !n10.k().equals(fragment)) {
            z1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return n10.r();
    }

    public Fragment s0(@NonNull Bundle bundle, @NonNull String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment g02 = g0(string);
        if (g02 == null) {
            z1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return g02;
    }

    /* access modifiers changed from: package-private */
    public void s1() {
        synchronized (this.f5631a) {
            boolean z10 = true;
            if (this.f5631a.size() != 1) {
                z10 = false;
            }
            if (z10) {
                this.f5652v.g().removeCallbacks(this.R);
                this.f5652v.g().post(this.R);
                B1();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void t1(@NonNull Fragment fragment, boolean z10) {
        ViewGroup t02 = t0(fragment);
        if (t02 != null && (t02 instanceof FragmentContainerView)) {
            ((FragmentContainerView) t02).setDrawDisappearingViewsLast(!z10);
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Fragment fragment = this.f5654x;
        if (fragment != null) {
            sb2.append(fragment.getClass().getSimpleName());
            sb2.append("{");
            sb2.append(Integer.toHexString(System.identityHashCode(this.f5654x)));
            sb2.append("}");
        } else {
            m<?> mVar = this.f5652v;
            if (mVar != null) {
                sb2.append(mVar.getClass().getSimpleName());
                sb2.append("{");
                sb2.append(Integer.toHexString(System.identityHashCode(this.f5652v)));
                sb2.append("}");
            } else {
                sb2.append("null");
            }
        }
        sb2.append("}}");
        return sb2.toString();
    }

    public final void u(@NonNull String str) {
        this.f5641k.remove(str);
        if (J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clearing fragment result with key ");
            sb2.append(str);
        }
    }

    @NonNull
    public l u0() {
        l lVar = this.f5656z;
        if (lVar != null) {
            return lVar;
        }
        Fragment fragment = this.f5654x;
        if (fragment != null) {
            return fragment.mFragmentManager.u0();
        }
        return this.A;
    }

    /* access modifiers changed from: package-private */
    public void u1(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (!fragment.equals(g0(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = state;
    }

    @NonNull
    public List<Fragment> v0() {
        return this.f5633c.o();
    }

    /* access modifiers changed from: package-private */
    public void v1(Fragment fragment) {
        if (fragment == null || (fragment.equals(g0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f5655y;
            this.f5655y = fragment;
            N(fragment2);
            N(this.f5655y);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    @NonNull
    public m<?> w0() {
        return this.f5652v;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public z x(@NonNull Fragment fragment) {
        z n10 = this.f5633c.n(fragment.mWho);
        if (n10 != null) {
            return n10;
        }
        z zVar = new z(this.f5644n, this.f5633c, fragment);
        zVar.o(this.f5652v.f().getClassLoader());
        zVar.u(this.f5651u);
        return zVar;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public LayoutInflater.Factory2 x0() {
        return this.f5636f;
    }

    /* access modifiers changed from: package-private */
    public void x1(@NonNull Fragment fragment) {
        if (J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("show: ");
            sb2.append(fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    /* access modifiers changed from: package-private */
    public void y(@NonNull Fragment fragment) {
        if (J0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("detach: ");
            sb2.append(fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (J0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("remove from detach: ");
                    sb3.append(fragment);
                }
                this.f5633c.u(fragment);
                if (K0(fragment)) {
                    this.H = true;
                }
                w1(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public o y0() {
        return this.f5644n;
    }

    /* access modifiers changed from: package-private */
    public void z() {
        this.I = false;
        this.J = false;
        this.P.q(false);
        U(4);
    }

    /* access modifiers changed from: package-private */
    public Fragment z0() {
        return this.f5654x;
    }

    @SuppressLint({"BanParcelableUsage"})
    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        String f5661a;

        /* renamed from: b  reason: collision with root package name */
        int f5662b;

        class a implements Parcelable.Creator<LaunchedFragmentInfo> {
            a() {
            }

            /* renamed from: a */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            /* renamed from: b */
            public LaunchedFragmentInfo[] newArray(int i10) {
                return new LaunchedFragmentInfo[i10];
            }
        }

        LaunchedFragmentInfo(@NonNull String str, int i10) {
            this.f5661a = str;
            this.f5662b = i10;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f5661a);
            parcel.writeInt(this.f5662b);
        }

        LaunchedFragmentInfo(@NonNull Parcel parcel) {
            this.f5661a = parcel.readString();
            this.f5662b = parcel.readInt();
        }
    }
}
