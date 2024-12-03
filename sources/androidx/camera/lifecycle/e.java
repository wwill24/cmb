package androidx.camera.lifecycle;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraX;
import androidx.camera.core.UseCase;
import androidx.camera.core.f3;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.p0;
import androidx.camera.core.impl.utils.p;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.k3;
import androidx.camera.core.l;
import androidx.camera.core.m;
import androidx.camera.core.r;
import androidx.camera.core.v;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import u.c;
import u.d;
import u.f;

public final class e {

    /* renamed from: h  reason: collision with root package name */
    private static final e f2983h = new e();

    /* renamed from: a  reason: collision with root package name */
    private final Object f2984a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private v.b f2985b = null;

    /* renamed from: c  reason: collision with root package name */
    private zf.a<CameraX> f2986c;

    /* renamed from: d  reason: collision with root package name */
    private zf.a<Void> f2987d = f.h(null);

    /* renamed from: e  reason: collision with root package name */
    private final LifecycleCameraRepository f2988e = new LifecycleCameraRepository();

    /* renamed from: f  reason: collision with root package name */
    private CameraX f2989f;

    /* renamed from: g  reason: collision with root package name */
    private Context f2990g;

    class a implements c<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CallbackToFutureAdapter.a f2991a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CameraX f2992b;

        a(CallbackToFutureAdapter.a aVar, CameraX cameraX) {
            this.f2991a = aVar;
            this.f2992b = cameraX;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            this.f2991a.c(this.f2992b);
        }

        public void onFailure(@NonNull Throwable th2) {
            this.f2991a.f(th2);
        }
    }

    private e() {
    }

    @NonNull
    public static zf.a<e> f(@NonNull Context context) {
        h.g(context);
        return f.o(f2983h.g(context), new b(context), androidx.camera.core.impl.utils.executor.a.a());
    }

    private zf.a<CameraX> g(@NonNull Context context) {
        synchronized (this.f2984a) {
            zf.a<CameraX> aVar = this.f2986c;
            if (aVar != null) {
                return aVar;
            }
            zf.a<CameraX> a10 = CallbackToFutureAdapter.a(new c(this, new CameraX(context, this.f2985b)));
            this.f2986c = a10;
            return a10;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ e h(Context context, CameraX cameraX) {
        e eVar = f2983h;
        eVar.k(cameraX);
        eVar.l(androidx.camera.core.impl.utils.h.a(context));
        return eVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object j(CameraX cameraX, CallbackToFutureAdapter.a aVar) throws Exception {
        synchronized (this.f2984a) {
            f.b(d.a(this.f2987d).e(new d(cameraX), androidx.camera.core.impl.utils.executor.a.a()), new a(aVar, cameraX), androidx.camera.core.impl.utils.executor.a.a());
        }
        return "ProcessCameraProvider-initializeCameraX";
    }

    private void k(CameraX cameraX) {
        this.f2989f = cameraX;
    }

    private void l(Context context) {
        this.f2990g = context;
    }

    @NonNull
    public l d(@NonNull androidx.lifecycle.l lVar, @NonNull r rVar, @NonNull f3 f3Var) {
        return e(lVar, rVar, f3Var.c(), f3Var.a(), (UseCase[]) f3Var.b().toArray(new UseCase[0]));
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public l e(@NonNull androidx.lifecycle.l lVar, @NonNull r rVar, k3 k3Var, @NonNull List<m> list, @NonNull UseCase... useCaseArr) {
        androidx.camera.core.impl.r rVar2;
        androidx.camera.core.impl.r a10;
        androidx.lifecycle.l lVar2 = lVar;
        UseCase[] useCaseArr2 = useCaseArr;
        p.a();
        r.a c10 = r.a.c(rVar);
        int length = useCaseArr2.length;
        int i10 = 0;
        while (true) {
            rVar2 = null;
            if (i10 >= length) {
                break;
            }
            r G = useCaseArr2[i10].g().G((r) null);
            if (G != null) {
                Iterator<androidx.camera.core.p> it = G.c().iterator();
                while (it.hasNext()) {
                    c10.a(it.next());
                }
            }
            i10++;
        }
        LinkedHashSet<CameraInternal> a11 = c10.b().a(this.f2989f.e().a());
        if (!a11.isEmpty()) {
            LifecycleCamera c11 = this.f2988e.c(lVar, CameraUseCaseAdapter.w(a11));
            Collection<LifecycleCamera> e10 = this.f2988e.e();
            for (UseCase useCase : useCaseArr2) {
                for (LifecycleCamera next : e10) {
                    if (next.q(useCase) && next != c11) {
                        throw new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", new Object[]{useCase}));
                    }
                }
            }
            if (c11 == null) {
                c11 = this.f2988e.b(lVar, new CameraUseCaseAdapter(a11, this.f2989f.d(), this.f2989f.g()));
            }
            Iterator<androidx.camera.core.p> it2 = rVar.c().iterator();
            while (it2.hasNext()) {
                androidx.camera.core.p next2 = it2.next();
                if (!(next2.a() == androidx.camera.core.p.f2852a || (a10 = p0.a(next2.a()).a(c11.b(), this.f2990g)) == null)) {
                    if (rVar2 == null) {
                        rVar2 = a10;
                    } else {
                        throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
                    }
                }
            }
            c11.m(rVar2);
            if (useCaseArr2.length == 0) {
                return c11;
            }
            this.f2988e.a(c11, k3Var, list, Arrays.asList(useCaseArr));
            return c11;
        }
        throw new IllegalArgumentException("Provided camera selector unable to resolve a camera for the given use case");
    }

    public void m() {
        p.a();
        this.f2988e.k();
    }
}
