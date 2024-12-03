package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f4560a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<e, SparseArray<d>> f4561b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f4562c = new Object();

    static class a {
        static Drawable a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getDrawable(i10, theme);
        }

        static Drawable b(Resources resources, int i10, int i11, Resources.Theme theme) {
            return resources.getDrawableForDensity(i10, i11, theme);
        }
    }

    static class b {
        static int a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColor(i10, theme);
        }

        @NonNull
        static ColorStateList b(@NonNull Resources resources, int i10, Resources.Theme theme) {
            return resources.getColorStateList(i10, theme);
        }
    }

    static class c {
        static float a(@NonNull Resources resources, int i10) {
            return resources.getFloat(i10);
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f4563a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f4564b;

        /* renamed from: c  reason: collision with root package name */
        final int f4565c;

        d(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration, Resources.Theme theme) {
            int i10;
            this.f4563a = colorStateList;
            this.f4564b = configuration;
            if (theme == null) {
                i10 = 0;
            } else {
                i10 = theme.hashCode();
            }
            this.f4565c = i10;
        }
    }

    private static final class e {

        /* renamed from: a  reason: collision with root package name */
        final Resources f4566a;

        /* renamed from: b  reason: collision with root package name */
        final Resources.Theme f4567b;

        e(@NonNull Resources resources, Resources.Theme theme) {
            this.f4566a = resources;
            this.f4567b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            if (!this.f4566a.equals(eVar.f4566a) || !androidx.core.util.c.a(this.f4567b, eVar.f4567b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return androidx.core.util.c.b(this.f4566a, this.f4567b);
        }
    }

    public static abstract class f {
        @NonNull
        public static Handler e(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(int i10, Handler handler) {
            e(handler).post(new k(this, i10));
        }

        public final void d(@NonNull Typeface typeface, Handler handler) {
            e(handler).post(new j(this, typeface));
        }

        /* renamed from: h */
        public abstract void f(int i10);

        /* renamed from: i */
        public abstract void g(@NonNull Typeface typeface);
    }

    public static final class g {

        static class a {

            /* renamed from: a  reason: collision with root package name */
            private static final Object f4568a = new Object();

            /* renamed from: b  reason: collision with root package name */
            private static Method f4569b;

            /* renamed from: c  reason: collision with root package name */
            private static boolean f4570c;

            /* JADX WARNING: Can't wrap try/catch for region: R(5:6|7|8|9|10) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0018 */
            @android.annotation.SuppressLint({"BanUncheckedReflection"})
            /* Code decompiled incorrectly, please refer to instructions dump. */
            static void a(@androidx.annotation.NonNull android.content.res.Resources.Theme r6) {
                /*
                    java.lang.Object r0 = f4568a
                    monitor-enter(r0)
                    boolean r1 = f4570c     // Catch:{ all -> 0x0029 }
                    r2 = 0
                    if (r1 != 0) goto L_0x001a
                    r1 = 1
                    java.lang.Class<android.content.res.Resources$Theme> r3 = android.content.res.Resources.Theme.class
                    java.lang.String r4 = "rebase"
                    java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x0018 }
                    java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ NoSuchMethodException -> 0x0018 }
                    f4569b = r3     // Catch:{ NoSuchMethodException -> 0x0018 }
                    r3.setAccessible(r1)     // Catch:{ NoSuchMethodException -> 0x0018 }
                L_0x0018:
                    f4570c = r1     // Catch:{ all -> 0x0029 }
                L_0x001a:
                    java.lang.reflect.Method r1 = f4569b     // Catch:{ all -> 0x0029 }
                    if (r1 == 0) goto L_0x0027
                    java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0024 }
                    r1.invoke(r6, r2)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0024 }
                    goto L_0x0027
                L_0x0024:
                    r6 = 0
                    f4569b = r6     // Catch:{ all -> 0x0029 }
                L_0x0027:
                    monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                    return
                L_0x0029:
                    r6 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.h.g.a.a(android.content.res.Resources$Theme):void");
            }
        }

        static class b {
            static void a(@NonNull Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(@NonNull Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                b.a(theme);
            } else {
                a.a(theme);
            }
        }
    }

    private static void a(@NonNull e eVar, int i10, @NonNull ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f4562c) {
            WeakHashMap<e, SparseArray<d>> weakHashMap = f4561b;
            SparseArray sparseArray = weakHashMap.get(eVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                weakHashMap.put(eVar, sparseArray);
            }
            sparseArray.append(i10, new d(colorStateList, eVar.f4566a.getConfiguration(), theme));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList b(@androidx.annotation.NonNull androidx.core.content.res.h.e r5, int r6) {
        /*
            java.lang.Object r0 = f4562c
            monitor-enter(r0)
            java.util.WeakHashMap<androidx.core.content.res.h$e, android.util.SparseArray<androidx.core.content.res.h$d>> r1 = f4561b     // Catch:{ all -> 0x0045 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0045 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0042
            int r2 = r1.size()     // Catch:{ all -> 0x0045 }
            if (r2 <= 0) goto L_0x0042
            java.lang.Object r2 = r1.get(r6)     // Catch:{ all -> 0x0045 }
            androidx.core.content.res.h$d r2 = (androidx.core.content.res.h.d) r2     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x0042
            android.content.res.Configuration r3 = r2.f4564b     // Catch:{ all -> 0x0045 }
            android.content.res.Resources r4 = r5.f4566a     // Catch:{ all -> 0x0045 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0045 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x003f
            android.content.res.Resources$Theme r5 = r5.f4567b     // Catch:{ all -> 0x0045 }
            if (r5 != 0) goto L_0x0031
            int r3 = r2.f4565c     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x003b
        L_0x0031:
            if (r5 == 0) goto L_0x003f
            int r3 = r2.f4565c     // Catch:{ all -> 0x0045 }
            int r5 = r5.hashCode()     // Catch:{ all -> 0x0045 }
            if (r3 != r5) goto L_0x003f
        L_0x003b:
            android.content.res.ColorStateList r5 = r2.f4563a     // Catch:{ all -> 0x0045 }
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return r5
        L_0x003f:
            r1.remove(r6)     // Catch:{ all -> 0x0045 }
        L_0x0042:
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            r5 = 0
            return r5
        L_0x0045:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.h.b(androidx.core.content.res.h$e, int):android.content.res.ColorStateList");
    }

    public static Typeface c(@NonNull Context context, int i10) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i10, new TypedValue(), 0, (f) null, (Handler) null, false, true);
    }

    public static ColorStateList d(@NonNull Resources resources, int i10, Resources.Theme theme) throws Resources.NotFoundException {
        e eVar = new e(resources, theme);
        ColorStateList b10 = b(eVar, i10);
        if (b10 != null) {
            return b10;
        }
        ColorStateList l10 = l(resources, i10, theme);
        if (l10 == null) {
            return b.b(resources, i10, theme);
        }
        a(eVar, i10, l10, theme);
        return l10;
    }

    public static Drawable e(@NonNull Resources resources, int i10, Resources.Theme theme) throws Resources.NotFoundException {
        return a.a(resources, i10, theme);
    }

    public static Drawable f(@NonNull Resources resources, int i10, int i11, Resources.Theme theme) throws Resources.NotFoundException {
        return a.b(resources, i10, i11, theme);
    }

    public static float g(@NonNull Resources resources, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            return c.a(resources, i10);
        }
        TypedValue k10 = k();
        resources.getValue(i10, k10, true);
        if (k10.type == 4) {
            return k10.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i10) + " type #0x" + Integer.toHexString(k10.type) + " is not valid");
    }

    public static Typeface h(@NonNull Context context, int i10) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i10, new TypedValue(), 0, (f) null, (Handler) null, false, false);
    }

    public static Typeface i(@NonNull Context context, int i10, @NonNull TypedValue typedValue, int i11, f fVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i10, typedValue, i11, fVar, (Handler) null, true, false);
    }

    public static void j(@NonNull Context context, int i10, @NonNull f fVar, Handler handler) throws Resources.NotFoundException {
        androidx.core.util.h.g(fVar);
        if (context.isRestricted()) {
            fVar.c(-4, handler);
            return;
        }
        n(context, i10, new TypedValue(), 0, fVar, handler, false, false);
    }

    @NonNull
    private static TypedValue k() {
        ThreadLocal<TypedValue> threadLocal = f4560a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList l(Resources resources, int i10, Resources.Theme theme) {
        if (m(resources, i10)) {
            return null;
        }
        try {
            return c.a(resources, resources.getXml(i10), theme);
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean m(@NonNull Resources resources, int i10) {
        TypedValue k10 = k();
        resources.getValue(i10, k10, true);
        int i11 = k10.type;
        if (i11 < 28 || i11 > 31) {
            return false;
        }
        return true;
    }

    private static Typeface n(@NonNull Context context, int i10, @NonNull TypedValue typedValue, int i11, f fVar, Handler handler, boolean z10, boolean z11) {
        Resources resources = context.getResources();
        int i12 = i10;
        resources.getValue(i10, typedValue, true);
        Typeface o10 = o(context, resources, typedValue, i10, i11, fVar, handler, z10, z11);
        if (o10 != null || fVar != null || z11) {
            return o10;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i10) + " could not be retrieved.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Typeface o(@androidx.annotation.NonNull android.content.Context r15, android.content.res.Resources r16, @androidx.annotation.NonNull android.util.TypedValue r17, int r18, int r19, androidx.core.content.res.h.f r20, android.os.Handler r21, boolean r22, boolean r23) {
        /*
            r2 = r16
            r0 = r17
            r3 = r18
            r10 = r20
            r11 = r21
            java.lang.CharSequence r1 = r0.string
            if (r1 == 0) goto L_0x00a1
            java.lang.String r12 = r1.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r12.startsWith(r1)
            r13 = -3
            r14 = 0
            if (r1 != 0) goto L_0x0022
            if (r10 == 0) goto L_0x0021
            r10.c(r13, r11)
        L_0x0021:
            return r14
        L_0x0022:
            int r1 = r0.assetCookie
            r6 = r19
            android.graphics.Typeface r1 = androidx.core.graphics.e.f(r2, r3, r12, r1, r6)
            if (r1 == 0) goto L_0x0032
            if (r10 == 0) goto L_0x0031
            r10.d(r1, r11)
        L_0x0031:
            return r1
        L_0x0032:
            if (r23 == 0) goto L_0x0035
            return r14
        L_0x0035:
            java.lang.String r1 = r12.toLowerCase()     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0080 }
            java.lang.String r4 = ".xml"
            boolean r1 = r1.endsWith(r4)     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0080 }
            if (r1 == 0) goto L_0x0066
            android.content.res.XmlResourceParser r1 = r2.getXml(r3)     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0080 }
            androidx.core.content.res.e$b r1 = androidx.core.content.res.e.b(r1, r2)     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0080 }
            if (r1 != 0) goto L_0x0051
            if (r10 == 0) goto L_0x0050
            r10.c(r13, r11)     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0080 }
        L_0x0050:
            return r14
        L_0x0051:
            int r5 = r0.assetCookie     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0080 }
            r0 = r15
            r2 = r16
            r3 = r18
            r4 = r12
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            android.graphics.Typeface r0 = androidx.core.graphics.e.c(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0080 }
            return r0
        L_0x0066:
            int r4 = r0.assetCookie     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0080 }
            r0 = r15
            r1 = r16
            r2 = r18
            r3 = r12
            r5 = r19
            android.graphics.Typeface r0 = androidx.core.graphics.e.d(r0, r1, r2, r3, r4, r5)     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0080 }
            if (r10 == 0) goto L_0x007f
            if (r0 == 0) goto L_0x007c
            r10.d(r0, r11)     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0080 }
            goto L_0x007f
        L_0x007c:
            r10.c(r13, r11)     // Catch:{ XmlPullParserException -> 0x008e, IOException -> 0x0080 }
        L_0x007f:
            return r0
        L_0x0080:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to read xml resource "
            r0.append(r1)
            r0.append(r12)
            goto L_0x009b
        L_0x008e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to parse xml resource "
            r0.append(r1)
            r0.append(r12)
        L_0x009b:
            if (r10 == 0) goto L_0x00a0
            r10.c(r13, r11)
        L_0x00a0:
            return r14
        L_0x00a1:
            android.content.res.Resources$NotFoundException r1 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Resource \""
            r4.append(r5)
            java.lang.String r2 = r2.getResourceName(r3)
            r4.append(r2)
            java.lang.String r2 = "\" ("
            r4.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r18)
            r4.append(r2)
            java.lang.String r2 = ") is not a Font: "
            r4.append(r2)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.h.o(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.h$f, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
