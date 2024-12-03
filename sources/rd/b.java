package rd;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.gtm.zzbv;
import com.google.android.gms.internal.gtm.zzez;
import com.google.android.gms.internal.gtm.zzft;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class b extends e {

    /* renamed from: k  reason: collision with root package name */
    private static List<Runnable> f41835k = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private boolean f41836f;

    /* renamed from: g  reason: collision with root package name */
    private Set<y> f41837g = new HashSet();

    /* renamed from: h  reason: collision with root package name */
    private boolean f41838h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f41839i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f41840j;

    public b(zzbv zzbv) {
        super(zzbv);
    }

    @NonNull
    public static b j(@NonNull Context context) {
        return zzbv.zzg(context).zzc();
    }

    public static void n() {
        synchronized (b.class) {
            List<Runnable> list = f41835k;
            if (list != null) {
                for (Runnable run : list) {
                    run.run();
                }
                f41835k = null;
            }
        }
    }

    @TargetApi(14)
    public void h(@NonNull Application application) {
        if (!this.f41838h) {
            application.registerActivityLifecycleCallbacks(new h(this));
            this.f41838h = true;
        }
    }

    public boolean i() {
        return this.f41840j;
    }

    public boolean k() {
        return this.f41839i;
    }

    @NonNull
    public d l(@NonNull String str) {
        d dVar;
        synchronized (this) {
            dVar = new d(e(), str, (zzez) null);
            dVar.zzX();
        }
        return dVar;
    }

    public void m(boolean z10) {
        this.f41839i = z10;
    }

    public final void o() {
        zzft zzq = e().zzq();
        zzq.zzf();
        if (zzq.zze()) {
            m(zzq.zzc());
        }
        zzq.zzf();
        this.f41836f = true;
    }

    /* access modifiers changed from: package-private */
    public final void p(Activity activity) {
        for (y b10 : this.f41837g) {
            b10.b(activity);
        }
    }

    /* access modifiers changed from: package-private */
    public final void q(Activity activity) {
        for (y c10 : this.f41837g) {
            c10.c(activity);
        }
    }

    public final boolean r() {
        return this.f41836f;
    }

    /* access modifiers changed from: package-private */
    public final void s(y yVar) {
        this.f41837g.add(yVar);
        Context zza = e().zza();
        if (zza instanceof Application) {
            h((Application) zza);
        }
    }

    /* access modifiers changed from: package-private */
    public final void t(y yVar) {
        this.f41837g.remove(yVar);
    }
}
