package androidx.databinding;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import androidx.lifecycle.v;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public abstract class ViewDataBinding extends a implements z1.a {
    private static final ReferenceQueue<ViewDataBinding> B = new ReferenceQueue<>();
    /* access modifiers changed from: private */
    public static final View.OnAttachStateChangeListener C = new f();

    /* renamed from: n  reason: collision with root package name */
    static int f4967n = Build.VERSION.SDK_INT;

    /* renamed from: p  reason: collision with root package name */
    private static final int f4968p = 8;

    /* renamed from: q  reason: collision with root package name */
    private static final boolean f4969q = true;

    /* renamed from: t  reason: collision with root package name */
    private static final d f4970t = new a();

    /* renamed from: w  reason: collision with root package name */
    private static final d f4971w = new b();

    /* renamed from: x  reason: collision with root package name */
    private static final d f4972x = new c();

    /* renamed from: y  reason: collision with root package name */
    private static final d f4973y = new d();

    /* renamed from: z  reason: collision with root package name */
    private static final c<Object, ViewDataBinding, Void> f4974z = new e();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f4975a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f4976b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4977c;

    /* renamed from: d  reason: collision with root package name */
    private i[] f4978d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final View f4979e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4980f;

    /* renamed from: g  reason: collision with root package name */
    private Choreographer f4981g;

    /* renamed from: h  reason: collision with root package name */
    private final Choreographer.FrameCallback f4982h;

    /* renamed from: j  reason: collision with root package name */
    private Handler f4983j;

    /* renamed from: k  reason: collision with root package name */
    protected final f f4984k;

    /* renamed from: l  reason: collision with root package name */
    private ViewDataBinding f4985l;

    /* renamed from: m  reason: collision with root package name */
    private l f4986m;

    static class OnStartListener implements k {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<ViewDataBinding> f4987a;

        @v(Lifecycle.Event.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = this.f4987a.get();
            if (viewDataBinding != null) {
                viewDataBinding.l();
            }
        }
    }

    class a implements d {
        a() {
        }
    }

    class b implements d {
        b() {
        }
    }

    class c implements d {
        c() {
        }
    }

    class d implements d {
        d() {
        }
    }

    class e extends c<Object, ViewDataBinding, Void> {
        e() {
        }
    }

    class f implements View.OnAttachStateChangeListener {
        f() {
        }

        @TargetApi(19)
        public void onViewAttachedToWindow(View view) {
            ViewDataBinding.o(view).f4975a.run();
            view.removeOnAttachStateChangeListener(this);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            synchronized (this) {
                boolean unused = ViewDataBinding.this.f4976b = false;
            }
            ViewDataBinding.z();
            if (!ViewDataBinding.this.f4979e.isAttachedToWindow()) {
                ViewDataBinding.this.f4979e.removeOnAttachStateChangeListener(ViewDataBinding.C);
                ViewDataBinding.this.f4979e.addOnAttachStateChangeListener(ViewDataBinding.C);
                return;
            }
            ViewDataBinding.this.l();
        }
    }

    class h implements Choreographer.FrameCallback {
        h() {
        }

        public void doFrame(long j10) {
            ViewDataBinding.this.f4975a.run();
        }
    }

    protected static class i {

        /* renamed from: a  reason: collision with root package name */
        public final String[][] f4990a;

        /* renamed from: b  reason: collision with root package name */
        public final int[][] f4991b;

        /* renamed from: c  reason: collision with root package name */
        public final int[][] f4992c;

        public i(int i10) {
            this.f4990a = new String[i10][];
            this.f4991b = new int[i10][];
            this.f4992c = new int[i10][];
        }

        public void a(int i10, String[] strArr, int[] iArr, int[] iArr2) {
            this.f4990a[i10] = strArr;
            this.f4991b[i10] = iArr;
            this.f4992c[i10] = iArr2;
        }
    }

    protected ViewDataBinding(f fVar, View view, int i10) {
        this.f4975a = new g();
        this.f4976b = false;
        this.f4977c = false;
        this.f4984k = fVar;
        this.f4978d = new i[i10];
        this.f4979e = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        } else if (f4969q) {
            this.f4981g = Choreographer.getInstance();
            this.f4982h = new h();
        } else {
            this.f4982h = null;
            this.f4983j = new Handler(Looper.myLooper());
        }
    }

    private static f h(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof f) {
            return (f) obj;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    private void j() {
        if (this.f4980f) {
            A();
        } else if (p()) {
            this.f4980f = true;
            this.f4977c = false;
            i();
            this.f4980f = false;
        }
    }

    protected static void k(ViewDataBinding viewDataBinding) {
        viewDataBinding.j();
    }

    private static int m(String str, int i10, i iVar, int i11) {
        CharSequence subSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = iVar.f4990a[i11];
        int length = strArr.length;
        while (i10 < length) {
            if (TextUtils.equals(subSequence, strArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    private static int n(ViewGroup viewGroup, int i10) {
        String str;
        String str2 = (String) viewGroup.getChildAt(i10).getTag();
        String substring = str2.substring(0, str2.length() - 1);
        int length = substring.length();
        int childCount = viewGroup.getChildCount();
        for (int i11 = i10 + 1; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt.getTag() instanceof String) {
                str = (String) childAt.getTag();
            } else {
                str = null;
            }
            if (str != null && str.startsWith(substring)) {
                if (str.length() == str2.length() && str.charAt(str.length() - 1) == '0') {
                    return i10;
                }
                if (s(str, length)) {
                    i10 = i11;
                }
            }
        }
        return i10;
    }

    static ViewDataBinding o(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(b1.a.dataBinding);
        }
        return null;
    }

    protected static <T extends ViewDataBinding> T q(@NonNull LayoutInflater layoutInflater, int i10, ViewGroup viewGroup, boolean z10, Object obj) {
        return g.e(layoutInflater, i10, viewGroup, z10, h(obj));
    }

    private static boolean s(String str, int i10) {
        int length = str.length();
        if (length == i10) {
            return false;
        }
        while (i10 < length) {
            if (!Character.isDigit(str.charAt(i10))) {
                return false;
            }
            i10++;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x010e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void t(androidx.databinding.f r17, android.view.View r18, java.lang.Object[] r19, androidx.databinding.ViewDataBinding.i r20, android.util.SparseIntArray r21, boolean r22) {
        /*
            r6 = r17
            r0 = r18
            r7 = r20
            r8 = r21
            androidx.databinding.ViewDataBinding r1 = o(r18)
            if (r1 == 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.Object r1 = r18.getTag()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x001a
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            java.lang.String r9 = "layout"
            r2 = -1
            r11 = 1
            if (r22 == 0) goto L_0x004b
            if (r1 == 0) goto L_0x004b
            boolean r3 = r1.startsWith(r9)
            if (r3 == 0) goto L_0x004b
            r3 = 95
            int r3 = r1.lastIndexOf(r3)
            if (r3 <= 0) goto L_0x0047
            int r3 = r3 + r11
            boolean r4 = s(r1, r3)
            if (r4 == 0) goto L_0x0047
            int r1 = x(r1, r3)
            r3 = r19[r1]
            if (r3 != 0) goto L_0x0042
            r19[r1] = r0
        L_0x0042:
            if (r7 != 0) goto L_0x0045
            r1 = r2
        L_0x0045:
            r3 = r11
            goto L_0x0049
        L_0x0047:
            r1 = r2
            r3 = 0
        L_0x0049:
            r12 = r1
            goto L_0x0069
        L_0x004b:
            if (r1 == 0) goto L_0x0067
            java.lang.String r3 = "binding_"
            boolean r3 = r1.startsWith(r3)
            if (r3 == 0) goto L_0x0067
            int r3 = f4968p
            int r1 = x(r1, r3)
            r3 = r19[r1]
            if (r3 != 0) goto L_0x0061
            r19[r1] = r0
        L_0x0061:
            if (r7 != 0) goto L_0x0064
            r1 = r2
        L_0x0064:
            r12 = r1
            r3 = r11
            goto L_0x0069
        L_0x0067:
            r12 = r2
            r3 = 0
        L_0x0069:
            if (r3 != 0) goto L_0x007f
            int r1 = r18.getId()
            if (r1 <= 0) goto L_0x007f
            if (r8 == 0) goto L_0x007f
            int r1 = r8.get(r1, r2)
            if (r1 < 0) goto L_0x007f
            r2 = r19[r1]
            if (r2 != 0) goto L_0x007f
            r19[r1] = r0
        L_0x007f:
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x0119
            r13 = r0
            android.view.ViewGroup r13 = (android.view.ViewGroup) r13
            int r14 = r13.getChildCount()
            r0 = 0
            r1 = 0
        L_0x008c:
            if (r0 >= r14) goto L_0x0119
            android.view.View r2 = r13.getChildAt(r0)
            if (r12 < 0) goto L_0x00fc
            java.lang.Object r3 = r2.getTag()
            boolean r3 = r3 instanceof java.lang.String
            if (r3 == 0) goto L_0x00fc
            java.lang.Object r3 = r2.getTag()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "_0"
            boolean r4 = r3.endsWith(r4)
            if (r4 == 0) goto L_0x00fc
            boolean r4 = r3.startsWith(r9)
            if (r4 == 0) goto L_0x00fc
            r4 = 47
            int r4 = r3.indexOf(r4)
            if (r4 <= 0) goto L_0x00fc
            int r3 = m(r3, r1, r7, r12)
            if (r3 < 0) goto L_0x00fc
            int r1 = r3 + 1
            int[][] r4 = r7.f4991b
            r4 = r4[r12]
            r4 = r4[r3]
            int[][] r5 = r7.f4992c
            r5 = r5[r12]
            r3 = r5[r3]
            int r5 = n(r13, r0)
            if (r5 != r0) goto L_0x00dc
            androidx.databinding.ViewDataBinding r3 = androidx.databinding.g.a(r6, r2, r3)
            r19[r4] = r3
            r10 = r0
            r0 = r11
            r11 = r1
            goto L_0x00ff
        L_0x00dc:
            int r5 = r5 - r0
            int r5 = r5 + r11
            android.view.View[] r15 = new android.view.View[r5]
            r10 = 0
        L_0x00e1:
            if (r10 >= r5) goto L_0x00ef
            int r11 = r0 + r10
            android.view.View r11 = r13.getChildAt(r11)
            r15[r10] = r11
            int r10 = r10 + 1
            r11 = 1
            goto L_0x00e1
        L_0x00ef:
            androidx.databinding.ViewDataBinding r3 = androidx.databinding.g.b(r6, r15, r3)
            r19[r4] = r3
            int r5 = r5 + -1
            int r0 = r0 + r5
            r10 = r0
            r11 = r1
            r0 = 1
            goto L_0x00ff
        L_0x00fc:
            r10 = r0
            r11 = r1
            r0 = 0
        L_0x00ff:
            if (r0 != 0) goto L_0x010e
            r5 = 0
            r0 = r17
            r1 = r2
            r2 = r19
            r3 = r20
            r4 = r21
            t(r0, r1, r2, r3, r4, r5)
        L_0x010e:
            r0 = 1
            int r1 = r10 + 1
            r16 = r11
            r11 = r0
            r0 = r1
            r1 = r16
            goto L_0x008c
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.t(androidx.databinding.f, android.view.View, java.lang.Object[], androidx.databinding.ViewDataBinding$i, android.util.SparseIntArray, boolean):void");
    }

    protected static Object[] w(f fVar, View view, int i10, i iVar, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i10];
        t(fVar, view, objArr, iVar, sparseIntArray, true);
        return objArr;
    }

    private static int x(String str, int i10) {
        int length = str.length();
        int i11 = 0;
        while (i10 < length) {
            i11 = (i11 * 10) + (str.charAt(i10) - '0');
            i10++;
        }
        return i11;
    }

    /* access modifiers changed from: private */
    public static void z() {
        while (true) {
            Reference<? extends ViewDataBinding> poll = B.poll();
            if (poll == null) {
                return;
            }
            if (poll instanceof i) {
                ((i) poll).a();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        if (f4969q == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        r2.f4981g.postFrameCallback(r2.f4982h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        r2.f4983j.post(r2.f4975a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A() {
        /*
            r2 = this;
            androidx.databinding.ViewDataBinding r0 = r2.f4985l
            if (r0 == 0) goto L_0x0008
            r0.A()
            goto L_0x003b
        L_0x0008:
            androidx.lifecycle.l r0 = r2.f4986m
            if (r0 == 0) goto L_0x001d
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            androidx.lifecycle.Lifecycle$State r0 = r0.b()
            androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED
            boolean r0 = r0.b(r1)
            if (r0 != 0) goto L_0x001d
            return
        L_0x001d:
            monitor-enter(r2)
            boolean r0 = r2.f4976b     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0024
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            return
        L_0x0024:
            r0 = 1
            r2.f4976b = r0     // Catch:{ all -> 0x003c }
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            boolean r0 = f4969q
            if (r0 == 0) goto L_0x0034
            android.view.Choreographer r0 = r2.f4981g
            android.view.Choreographer$FrameCallback r1 = r2.f4982h
            r0.postFrameCallback(r1)
            goto L_0x003b
        L_0x0034:
            android.os.Handler r0 = r2.f4983j
            java.lang.Runnable r1 = r2.f4975a
            r0.post(r1)
        L_0x003b:
            return
        L_0x003c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.A():void");
    }

    /* access modifiers changed from: protected */
    public void B(ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.f4985l = this;
        }
    }

    /* access modifiers changed from: protected */
    public void D(View view) {
        view.setTag(b1.a.dataBinding, this);
    }

    @NonNull
    public View getRoot() {
        return this.f4979e;
    }

    /* access modifiers changed from: protected */
    public abstract void i();

    public void l() {
        ViewDataBinding viewDataBinding = this.f4985l;
        if (viewDataBinding == null) {
            j();
        } else {
            viewDataBinding.l();
        }
    }

    public abstract boolean p();

    public abstract void r();

    protected ViewDataBinding(Object obj, View view, int i10) {
        this(h(obj), view, i10);
    }
}
