package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.n;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.s1;
import androidx.core.os.j;
import com.leanplum.internal.Constants;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    static n.a f547a = new n.a(new n.b());

    /* renamed from: b  reason: collision with root package name */
    private static int f548b = -100;

    /* renamed from: c  reason: collision with root package name */
    private static j f549c = null;

    /* renamed from: d  reason: collision with root package name */
    private static j f550d = null;

    /* renamed from: e  reason: collision with root package name */
    private static Boolean f551e = null;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f552f = false;

    /* renamed from: g  reason: collision with root package name */
    private static final androidx.collection.b<WeakReference<f>> f553g = new androidx.collection.b<>();

    /* renamed from: h  reason: collision with root package name */
    private static final Object f554h = new Object();

    /* renamed from: j  reason: collision with root package name */
    private static final Object f555j = new Object();

    static class a {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    static class b {
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    f() {
    }

    static void E(@NonNull f fVar) {
        synchronized (f554h) {
            F(fVar);
        }
    }

    private static void F(@NonNull f fVar) {
        synchronized (f554h) {
            Iterator<WeakReference<f>> it = f553g.iterator();
            while (it.hasNext()) {
                f fVar2 = (f) it.next().get();
                if (fVar2 == fVar || fVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public static void H(boolean z10) {
        s1.c(z10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void P(android.content.Context r3) {
        /*
            boolean r0 = u(r3)
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = androidx.core.os.a.c()
            if (r0 == 0) goto L_0x001c
            boolean r0 = f552f
            if (r0 != 0) goto L_0x0054
            androidx.appcompat.app.n$a r0 = f547a
            androidx.appcompat.app.e r1 = new androidx.appcompat.app.e
            r1.<init>(r3)
            r0.execute(r1)
            goto L_0x0054
        L_0x001c:
            java.lang.Object r0 = f555j
            monitor-enter(r0)
            androidx.core.os.j r1 = f549c     // Catch:{ all -> 0x0055 }
            if (r1 != 0) goto L_0x0040
            androidx.core.os.j r1 = f550d     // Catch:{ all -> 0x0055 }
            if (r1 != 0) goto L_0x0031
            java.lang.String r3 = androidx.appcompat.app.n.b(r3)     // Catch:{ all -> 0x0055 }
            androidx.core.os.j r3 = androidx.core.os.j.b(r3)     // Catch:{ all -> 0x0055 }
            f550d = r3     // Catch:{ all -> 0x0055 }
        L_0x0031:
            androidx.core.os.j r3 = f550d     // Catch:{ all -> 0x0055 }
            boolean r3 = r3.e()     // Catch:{ all -> 0x0055 }
            if (r3 == 0) goto L_0x003b
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            return
        L_0x003b:
            androidx.core.os.j r3 = f550d     // Catch:{ all -> 0x0055 }
            f549c = r3     // Catch:{ all -> 0x0055 }
            goto L_0x0053
        L_0x0040:
            androidx.core.os.j r2 = f550d     // Catch:{ all -> 0x0055 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0055 }
            if (r1 != 0) goto L_0x0053
            androidx.core.os.j r1 = f549c     // Catch:{ all -> 0x0055 }
            f550d = r1     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = r1.g()     // Catch:{ all -> 0x0055 }
            androidx.appcompat.app.n.a(r3, r1)     // Catch:{ all -> 0x0055 }
        L_0x0053:
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
        L_0x0054:
            return
        L_0x0055:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.P(android.content.Context):void");
    }

    static void d(@NonNull f fVar) {
        synchronized (f554h) {
            F(fVar);
            f553g.add(new WeakReference(fVar));
        }
    }

    @NonNull
    public static f h(@NonNull Activity activity, d dVar) {
        return new AppCompatDelegateImpl(activity, dVar);
    }

    @NonNull
    public static f i(@NonNull Dialog dialog, d dVar) {
        return new AppCompatDelegateImpl(dialog, dVar);
    }

    @NonNull
    public static j k() {
        if (androidx.core.os.a.c()) {
            Object o10 = o();
            if (o10 != null) {
                return j.h(b.a(o10));
            }
        } else {
            j jVar = f549c;
            if (jVar != null) {
                return jVar;
            }
        }
        return j.d();
    }

    public static int m() {
        return f548b;
    }

    static Object o() {
        Context l10;
        Iterator<WeakReference<f>> it = f553g.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next().get();
            if (fVar != null && (l10 = fVar.l()) != null) {
                return l10.getSystemService(Constants.Keys.LOCALE);
            }
        }
        return null;
    }

    static j q() {
        return f549c;
    }

    static boolean u(Context context) {
        if (f551e == null) {
            try {
                Bundle bundle = l.a(context).metaData;
                if (bundle != null) {
                    f551e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                f551e = Boolean.FALSE;
            }
        }
        return f551e.booleanValue();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void v(Context context) {
        n.c(context);
        f552f = true;
    }

    public abstract void A();

    public abstract void B(Bundle bundle);

    public abstract void C();

    public abstract void D();

    public abstract boolean G(int i10);

    public abstract void I(int i10);

    public abstract void J(View view);

    public abstract void K(View view, ViewGroup.LayoutParams layoutParams);

    public void L(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void M(Toolbar toolbar);

    public void N(int i10) {
    }

    public abstract void O(CharSequence charSequence);

    public abstract void e(View view, ViewGroup.LayoutParams layoutParams);

    @Deprecated
    public void f(Context context) {
    }

    @NonNull
    public Context g(@NonNull Context context) {
        f(context);
        return context;
    }

    public abstract <T extends View> T j(int i10);

    public Context l() {
        return null;
    }

    public int n() {
        return -100;
    }

    public abstract MenuInflater p();

    public abstract a r();

    public abstract void s();

    public abstract void t();

    public abstract void w(Configuration configuration);

    public abstract void x(Bundle bundle);

    public abstract void y();

    public abstract void z(Bundle bundle);
}
