package androidx.camera.core.impl;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import u.c;
import u.f;

public final class o0 {

    class a implements c<List<Surface>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f2572a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CallbackToFutureAdapter.a f2573b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ScheduledFuture f2574c;

        a(boolean z10, CallbackToFutureAdapter.a aVar, ScheduledFuture scheduledFuture) {
            this.f2572a = z10;
            this.f2573b = aVar;
            this.f2574c = scheduledFuture;
        }

        /* renamed from: a */
        public void onSuccess(List<Surface> list) {
            ArrayList arrayList = new ArrayList(list);
            if (this.f2572a) {
                arrayList.removeAll(Collections.singleton((Object) null));
            }
            this.f2573b.c(arrayList);
            this.f2574c.cancel(true);
        }

        public void onFailure(@NonNull Throwable th2) {
            this.f2573b.c(Collections.unmodifiableList(Collections.emptyList()));
            this.f2574c.cancel(true);
        }
    }

    public static void e(@NonNull List<DeferrableSurface> list) {
        for (DeferrableSurface d10 : list) {
            d10.d();
        }
    }

    public static void f(@NonNull List<DeferrableSurface> list) throws DeferrableSurface.SurfaceClosedException {
        if (!list.isEmpty()) {
            int i10 = 0;
            do {
                try {
                    list.get(i10).j();
                    i10++;
                } catch (DeferrableSurface.SurfaceClosedException e10) {
                    for (int i11 = i10 - 1; i11 >= 0; i11--) {
                        list.get(i11).d();
                    }
                    throw e10;
                }
            } while (i10 < list.size());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void g(zf.a aVar, CallbackToFutureAdapter.a aVar2, long j10) {
        if (!aVar.isDone()) {
            aVar2.f(new TimeoutException("Cannot complete surfaceList within " + j10));
            aVar.cancel(true);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object j(List list, ScheduledExecutorService scheduledExecutorService, Executor executor, long j10, boolean z10, CallbackToFutureAdapter.a aVar) throws Exception {
        zf.a n10 = f.n(list);
        ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new l0(executor, n10, aVar, j10), j10, TimeUnit.MILLISECONDS);
        aVar.a(new m0(n10), executor);
        f.b(n10, new a(z10, aVar, schedule), executor);
        return "surfaceList";
    }

    @NonNull
    public static zf.a<List<Surface>> k(@NonNull Collection<DeferrableSurface> collection, boolean z10, long j10, @NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService) {
        ArrayList arrayList = new ArrayList();
        for (DeferrableSurface h10 : collection) {
            arrayList.add(f.j(h10.h()));
        }
        return CallbackToFutureAdapter.a(new k0(arrayList, scheduledExecutorService, executor, j10, z10));
    }
}
