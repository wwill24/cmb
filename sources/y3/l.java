package y3;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import f4.k;
import java.util.HashMap;
import java.util.Map;

public class l implements Handler.Callback {

    /* renamed from: i  reason: collision with root package name */
    private static final b f18647i = new a();

    /* renamed from: a  reason: collision with root package name */
    private volatile h f18648a;

    /* renamed from: b  reason: collision with root package name */
    final Map<FragmentManager, k> f18649b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final Map<androidx.fragment.app.FragmentManager, o> f18650c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Handler f18651d;

    /* renamed from: e  reason: collision with root package name */
    private final b f18652e;

    /* renamed from: f  reason: collision with root package name */
    private final androidx.collection.a<View, Fragment> f18653f = new androidx.collection.a<>();

    /* renamed from: g  reason: collision with root package name */
    private final androidx.collection.a<View, android.app.Fragment> f18654g = new androidx.collection.a<>();

    /* renamed from: h  reason: collision with root package name */
    private final Bundle f18655h = new Bundle();

    class a implements b {
        a() {
        }

        @NonNull
        public h a(@NonNull c cVar, @NonNull h hVar, @NonNull m mVar, @NonNull Context context) {
            return new h(cVar, hVar, mVar, context);
        }
    }

    public interface b {
        @NonNull
        h a(@NonNull c cVar, @NonNull h hVar, @NonNull m mVar, @NonNull Context context);
    }

    public l(b bVar) {
        this.f18652e = bVar == null ? f18647i : bVar;
        this.f18651d = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    private static void a(@NonNull Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private static Activity b(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @NonNull
    @Deprecated
    private h c(@NonNull Context context, @NonNull FragmentManager fragmentManager, android.app.Fragment fragment, boolean z10) {
        k i10 = i(fragmentManager, fragment, z10);
        h e10 = i10.e();
        if (e10 != null) {
            return e10;
        }
        h a10 = this.f18652e.a(c.c(context), i10.c(), i10.f(), context);
        i10.k(a10);
        return a10;
    }

    @NonNull
    private h g(@NonNull Context context) {
        if (this.f18648a == null) {
            synchronized (this) {
                if (this.f18648a == null) {
                    this.f18648a = this.f18652e.a(c.c(context.getApplicationContext()), new b(), new g(), context.getApplicationContext());
                }
            }
        }
        return this.f18648a;
    }

    @NonNull
    private k i(@NonNull FragmentManager fragmentManager, android.app.Fragment fragment, boolean z10) {
        k kVar = (k) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (kVar == null && (kVar = this.f18649b.get(fragmentManager)) == null) {
            kVar = new k();
            kVar.j(fragment);
            if (z10) {
                kVar.c().d();
            }
            this.f18649b.put(fragmentManager, kVar);
            fragmentManager.beginTransaction().add(kVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f18651d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return kVar;
    }

    @NonNull
    private o k(@NonNull androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z10) {
        o oVar = (o) fragmentManager.j0("com.bumptech.glide.manager");
        if (oVar == null && (oVar = this.f18650c.get(fragmentManager)) == null) {
            oVar = new o();
            oVar.J0(fragment);
            if (z10) {
                oVar.B0().d();
            }
            this.f18650c.put(fragmentManager, oVar);
            fragmentManager.p().e(oVar, "com.bumptech.glide.manager").j();
            this.f18651d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return oVar;
    }

    private static boolean l(Context context) {
        Activity b10 = b(context);
        if (b10 == null || !b10.isFinishing()) {
            return true;
        }
        return false;
    }

    @NonNull
    private h m(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z10) {
        o k10 = k(fragmentManager, fragment, z10);
        h D0 = k10.D0();
        if (D0 != null) {
            return D0;
        }
        h a10 = this.f18652e.a(c.c(context), k10.B0(), k10.E0(), context);
        k10.L0(a10);
        return a10;
    }

    @NonNull
    public h d(@NonNull Activity activity) {
        if (k.o()) {
            return e(activity.getApplicationContext());
        }
        a(activity);
        return c(activity, activity.getFragmentManager(), (android.app.Fragment) null, l(activity));
    }

    @NonNull
    public h e(@NonNull Context context) {
        if (context != null) {
            if (k.p() && !(context instanceof Application)) {
                if (context instanceof androidx.fragment.app.h) {
                    return f((androidx.fragment.app.h) context);
                }
                if (context instanceof Activity) {
                    return d((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return e(contextWrapper.getBaseContext());
                    }
                }
            }
            return g(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @NonNull
    public h f(@NonNull androidx.fragment.app.h hVar) {
        if (k.o()) {
            return e(hVar.getApplicationContext());
        }
        a(hVar);
        return m(hVar, hVar.getSupportFragmentManager(), (Fragment) null, l(hVar));
    }

    /* access modifiers changed from: package-private */
    @NonNull
    @Deprecated
    public k h(Activity activity) {
        return i(activity.getFragmentManager(), (android.app.Fragment) null, l(activity));
    }

    public boolean handleMessage(Message message) {
        Object obj;
        Object obj2;
        Object obj3;
        int i10 = message.what;
        Object obj4 = null;
        boolean z10 = true;
        if (i10 == 1) {
            obj3 = (FragmentManager) message.obj;
            obj2 = this.f18649b.remove(obj3);
        } else if (i10 != 2) {
            z10 = false;
            obj = null;
            if (z10 && obj4 == null && Log.isLoggable("RMRetriever", 5)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to remove expected request manager fragment, manager: ");
                sb2.append(obj);
            }
            return z10;
        } else {
            obj3 = (androidx.fragment.app.FragmentManager) message.obj;
            obj2 = this.f18650c.remove(obj3);
        }
        Object obj5 = obj3;
        obj4 = obj2;
        obj = obj5;
        StringBuilder sb22 = new StringBuilder();
        sb22.append("Failed to remove expected request manager fragment, manager: ");
        sb22.append(obj);
        return z10;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public o j(Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        return k(fragmentManager, (Fragment) null, l(context));
    }
}
