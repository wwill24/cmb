package rd;

import android.net.Uri;
import com.google.android.gms.common.internal.p;
import java.util.HashSet;
import java.util.List;

final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f41870a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ u f41871b;

    o(u uVar, k kVar) {
        this.f41871b = uVar;
        this.f41870a = kVar;
    }

    public final void run() {
        this.f41870a.d().a(this.f41870a);
        for (v zza : this.f41871b.f41877b) {
            zza.zza();
        }
        k kVar = this.f41870a;
        p.j("deliver should be called from worker thread");
        p.b(kVar.m(), "Measurement must be submitted");
        List<w> f10 = kVar.f();
        if (!f10.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (w next : f10) {
                Uri zzb = next.zzb();
                if (!hashSet.contains(zzb)) {
                    hashSet.add(zzb);
                    next.a(kVar);
                }
            }
        }
    }
}
