package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.collection.e;
import androidx.collection.f;
import androidx.collection.g;
import androidx.collection.h;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class w0 {

    /* renamed from: h  reason: collision with root package name */
    private static final PorterDuff.Mode f1466h = PorterDuff.Mode.SRC_IN;

    /* renamed from: i  reason: collision with root package name */
    private static w0 f1467i;

    /* renamed from: j  reason: collision with root package name */
    private static final a f1468j = new a(6);

    /* renamed from: a  reason: collision with root package name */
    private WeakHashMap<Context, h<ColorStateList>> f1469a;

    /* renamed from: b  reason: collision with root package name */
    private g<String, b> f1470b;

    /* renamed from: c  reason: collision with root package name */
    private h<String> f1471c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakHashMap<Context, e<WeakReference<Drawable.ConstantState>>> f1472d = new WeakHashMap<>(0);

    /* renamed from: e  reason: collision with root package name */
    private TypedValue f1473e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1474f;

    /* renamed from: g  reason: collision with root package name */
    private c f1475g;

    private static class a extends f<Integer, PorterDuffColorFilter> {
        public a(int i10) {
            super(i10);
        }

        private static int a(int i10, PorterDuff.Mode mode) {
            return ((i10 + 31) * 31) + mode.hashCode();
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter b(int i10, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(a(i10, mode)));
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter c(int i10, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(a(i10, mode)), porterDuffColorFilter);
        }
    }

    private interface b {
        Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface c {
        Drawable a(@NonNull w0 w0Var, @NonNull Context context, int i10);

        ColorStateList b(@NonNull Context context, int i10);

        boolean c(@NonNull Context context, int i10, @NonNull Drawable drawable);

        PorterDuff.Mode d(int i10);

        boolean e(@NonNull Context context, int i10, @NonNull Drawable drawable);
    }

    private synchronized boolean a(@NonNull Context context, long j10, @NonNull Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        e eVar = this.f1472d.get(context);
        if (eVar == null) {
            eVar = new e();
            this.f1472d.put(context, eVar);
        }
        eVar.l(j10, new WeakReference(constantState));
        return true;
    }

    private void b(@NonNull Context context, int i10, @NonNull ColorStateList colorStateList) {
        if (this.f1469a == null) {
            this.f1469a = new WeakHashMap<>();
        }
        h hVar = this.f1469a.get(context);
        if (hVar == null) {
            hVar = new h();
            this.f1469a.put(context, hVar);
        }
        hVar.a(i10, colorStateList);
    }

    private void c(@NonNull Context context) {
        if (!this.f1474f) {
            this.f1474f = true;
            Drawable i10 = i(context, g.b.abc_vector_test);
            if (i10 == null || !p(i10)) {
                this.f1474f = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private static long d(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable e(@NonNull Context context, int i10) {
        Drawable drawable;
        if (this.f1473e == null) {
            this.f1473e = new TypedValue();
        }
        TypedValue typedValue = this.f1473e;
        context.getResources().getValue(i10, typedValue, true);
        long d10 = d(typedValue);
        Drawable h10 = h(context, d10);
        if (h10 != null) {
            return h10;
        }
        c cVar = this.f1475g;
        if (cVar == null) {
            drawable = null;
        } else {
            drawable = cVar.a(this, context, i10);
        }
        if (drawable != null) {
            drawable.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, d10, drawable);
        }
        return drawable;
    }

    private static PorterDuffColorFilter f(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return k(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized w0 g() {
        w0 w0Var;
        synchronized (w0.class) {
            if (f1467i == null) {
                w0 w0Var2 = new w0();
                f1467i = w0Var2;
                o(w0Var2);
            }
            w0Var = f1467i;
        }
        return w0Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.graphics.drawable.Drawable h(@androidx.annotation.NonNull android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, androidx.collection.e<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.f1472d     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002d }
            androidx.collection.e r0 = (androidx.collection.e) r0     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.e(r5)     // Catch:{ all -> 0x002d }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r0.o(r5)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r3)
            return r1
        L_0x002d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.w0.h(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public static synchronized PorterDuffColorFilter k(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter b10;
        synchronized (w0.class) {
            a aVar = f1468j;
            b10 = aVar.b(i10, mode);
            if (b10 == null) {
                b10 = new PorterDuffColorFilter(i10, mode);
                aVar.c(i10, mode, b10);
            }
        }
        return b10;
    }

    private ColorStateList m(@NonNull Context context, int i10) {
        h hVar;
        WeakHashMap<Context, h<ColorStateList>> weakHashMap = this.f1469a;
        if (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) hVar.e(i10);
    }

    private static void o(@NonNull w0 w0Var) {
    }

    private static boolean p(@NonNull Drawable drawable) {
        if ((drawable instanceof androidx.vectordrawable.graphics.drawable.f) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073 A[Catch:{ Exception -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[Catch:{ Exception -> 0x00a2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable q(@androidx.annotation.NonNull android.content.Context r11, int r12) {
        /*
            r10 = this;
            androidx.collection.g<java.lang.String, androidx.appcompat.widget.w0$b> r0 = r10.f1470b
            r1 = 0
            if (r0 == 0) goto L_0x00aa
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00aa
            androidx.collection.h<java.lang.String> r0 = r10.f1471c
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r0.e(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0027
            if (r0 == 0) goto L_0x002f
            androidx.collection.g<java.lang.String, androidx.appcompat.widget.w0$b> r3 = r10.f1470b
            java.lang.Object r0 = r3.get(r0)
            if (r0 != 0) goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            androidx.collection.h r0 = new androidx.collection.h
            r0.<init>()
            r10.f1471c = r0
        L_0x002f:
            android.util.TypedValue r0 = r10.f1473e
            if (r0 != 0) goto L_0x003a
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r10.f1473e = r0
        L_0x003a:
            android.util.TypedValue r0 = r10.f1473e
            android.content.res.Resources r1 = r11.getResources()
            r3 = 1
            r1.getValue(r12, r0, r3)
            long r4 = d(r0)
            android.graphics.drawable.Drawable r6 = r10.h(r11, r4)
            if (r6 == 0) goto L_0x004f
            return r6
        L_0x004f:
            java.lang.CharSequence r7 = r0.string
            if (r7 == 0) goto L_0x00a2
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ".xml"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00a2
            android.content.res.XmlResourceParser r1 = r1.getXml(r12)     // Catch:{ Exception -> 0x00a2 }
            android.util.AttributeSet r7 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x00a2 }
        L_0x0067:
            int r8 = r1.next()     // Catch:{ Exception -> 0x00a2 }
            r9 = 2
            if (r8 == r9) goto L_0x0071
            if (r8 == r3) goto L_0x0071
            goto L_0x0067
        L_0x0071:
            if (r8 != r9) goto L_0x009a
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x00a2 }
            androidx.collection.h<java.lang.String> r8 = r10.f1471c     // Catch:{ Exception -> 0x00a2 }
            r8.a(r12, r3)     // Catch:{ Exception -> 0x00a2 }
            androidx.collection.g<java.lang.String, androidx.appcompat.widget.w0$b> r8 = r10.f1470b     // Catch:{ Exception -> 0x00a2 }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ Exception -> 0x00a2 }
            androidx.appcompat.widget.w0$b r3 = (androidx.appcompat.widget.w0.b) r3     // Catch:{ Exception -> 0x00a2 }
            if (r3 == 0) goto L_0x008f
            android.content.res.Resources$Theme r8 = r11.getTheme()     // Catch:{ Exception -> 0x00a2 }
            android.graphics.drawable.Drawable r1 = r3.a(r11, r1, r7, r8)     // Catch:{ Exception -> 0x00a2 }
            r6 = r1
        L_0x008f:
            if (r6 == 0) goto L_0x00a2
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x00a2 }
            r6.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x00a2 }
            r10.a(r11, r4, r6)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00a2
        L_0x009a:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r0 = "No start tag found"
            r11.<init>(r0)     // Catch:{ Exception -> 0x00a2 }
            throw r11     // Catch:{ Exception -> 0x00a2 }
        L_0x00a2:
            if (r6 != 0) goto L_0x00a9
            androidx.collection.h<java.lang.String> r11 = r10.f1471c
            r11.a(r12, r2)
        L_0x00a9:
            return r6
        L_0x00aa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.w0.q(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private Drawable u(@NonNull Context context, int i10, boolean z10, @NonNull Drawable drawable) {
        ColorStateList l10 = l(context, i10);
        if (l10 != null) {
            if (k0.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable r10 = androidx.core.graphics.drawable.a.r(drawable);
            androidx.core.graphics.drawable.a.o(r10, l10);
            PorterDuff.Mode n10 = n(i10);
            if (n10 == null) {
                return r10;
            }
            androidx.core.graphics.drawable.a.p(r10, n10);
            return r10;
        }
        c cVar = this.f1475g;
        if ((cVar == null || !cVar.e(context, i10, drawable)) && !w(context, i10, drawable) && z10) {
            return null;
        }
        return drawable;
    }

    static void v(Drawable drawable, f1 f1Var, int[] iArr) {
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        boolean z10;
        int[] state = drawable.getState();
        if (k0.a(drawable)) {
            if (drawable.mutate() == drawable) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                return;
            }
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z11 = f1Var.f1272d;
        if (z11 || f1Var.f1271c) {
            if (z11) {
                colorStateList = f1Var.f1269a;
            } else {
                colorStateList = null;
            }
            if (f1Var.f1271c) {
                mode = f1Var.f1270b;
            } else {
                mode = f1466h;
            }
            drawable.setColorFilter(f(colorStateList, mode, iArr));
            return;
        }
        drawable.clearColorFilter();
    }

    public synchronized Drawable i(@NonNull Context context, int i10) {
        return j(context, i10, false);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable j(@NonNull Context context, int i10, boolean z10) {
        Drawable q10;
        c(context);
        q10 = q(context, i10);
        if (q10 == null) {
            q10 = e(context, i10);
        }
        if (q10 == null) {
            q10 = androidx.core.content.a.getDrawable(context, i10);
        }
        if (q10 != null) {
            q10 = u(context, i10, z10, q10);
        }
        if (q10 != null) {
            k0.b(q10);
        }
        return q10;
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList l(@NonNull Context context, int i10) {
        ColorStateList m10;
        m10 = m(context, i10);
        if (m10 == null) {
            c cVar = this.f1475g;
            if (cVar == null) {
                m10 = null;
            } else {
                m10 = cVar.b(context, i10);
            }
            if (m10 != null) {
                b(context, i10, m10);
            }
        }
        return m10;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode n(int i10) {
        c cVar = this.f1475g;
        if (cVar == null) {
            return null;
        }
        return cVar.d(i10);
    }

    public synchronized void r(@NonNull Context context) {
        e eVar = this.f1472d.get(context);
        if (eVar != null) {
            eVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable s(@NonNull Context context, @NonNull s1 s1Var, int i10) {
        Drawable q10 = q(context, i10);
        if (q10 == null) {
            q10 = s1Var.a(i10);
        }
        if (q10 == null) {
            return null;
        }
        return u(context, i10, false, q10);
    }

    public synchronized void t(c cVar) {
        this.f1475g = cVar;
    }

    /* access modifiers changed from: package-private */
    public boolean w(@NonNull Context context, int i10, @NonNull Drawable drawable) {
        c cVar = this.f1475g;
        return cVar != null && cVar.c(context, i10, drawable);
    }
}
