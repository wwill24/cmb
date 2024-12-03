package com.google.mlkit.vision.barcode.internal;

import ah.a;
import ah.d;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.mlkit_vision_barcode.zzca;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdw;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdx;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdz;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmu;
import com.google.android.gms.internal.mlkit_vision_barcode.zznc;
import com.google.android.gms.internal.mlkit_vision_barcode.zznd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzne;
import com.google.android.gms.internal.mlkit_vision_barcode.zznf;
import com.google.android.gms.internal.mlkit_vision_barcode.zznr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzra;
import com.google.android.gms.internal.mlkit_vision_barcode.zzri;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzro;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.f;
import com.google.mlkit.common.sdkinternal.g;
import com.google.mlkit.common.sdkinternal.i;
import java.util.Iterator;
import java.util.List;
import vg.b;

public final class h extends f {

    /* renamed from: j  reason: collision with root package name */
    private static final d f21494j = d.b();

    /* renamed from: k  reason: collision with root package name */
    static boolean f21495k = true;

    /* renamed from: d  reason: collision with root package name */
    private final b f21496d;

    /* renamed from: e  reason: collision with root package name */
    private final i f21497e;

    /* renamed from: f  reason: collision with root package name */
    private final zzrl f21498f;

    /* renamed from: g  reason: collision with root package name */
    private final zzrn f21499g;

    /* renamed from: h  reason: collision with root package name */
    private final a f21500h = new a();

    /* renamed from: i  reason: collision with root package name */
    private boolean f21501i;

    public h(i iVar, b bVar, i iVar2, zzrl zzrl) {
        p.l(iVar, "MlKitContext can not be null");
        p.l(bVar, "BarcodeScannerOptions can not be null");
        this.f21496d = bVar;
        this.f21497e = iVar2;
        this.f21498f = zzrl;
        this.f21499g = zzrn.zza(iVar.b());
    }

    private final void m(zznd zznd, long j10, @NonNull zg.a aVar, List list) {
        int i10;
        zzca zzca = new zzca();
        zzca zzca2 = new zzca();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                wg.a aVar2 = (wg.a) it.next();
                zzca.zzd(b.a(aVar2.b()));
                zzca2.zzd(b.b(aVar2.d()));
            }
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - j10;
        this.f21498f.zzf(new f(this, elapsedRealtime, zznd, zzca, zzca2, aVar), zzne.ON_DEVICE_BARCODE_DETECT);
        zzdx zzdx = new zzdx();
        zzdx.zze(zznd);
        zzdx.zzf(Boolean.valueOf(f21495k));
        zzdx.zzg(b.c(this.f21496d));
        zzdx.zzc(zzca.zzf());
        zzdx.zzd(zzca2.zzf());
        zzdz zzh = zzdx.zzh();
        g gVar = new g(this);
        g.d().execute(new zzri(this.f21498f, zzne.AGGREGATED_ON_DEVICE_BARCODE_DETECTION, zzh, elapsedRealtime, gVar));
        long currentTimeMillis = System.currentTimeMillis();
        boolean z10 = this.f21501i;
        long j11 = currentTimeMillis - elapsedRealtime;
        zzrn zzrn = this.f21499g;
        if (true != z10) {
            i10 = 24301;
        } else {
            i10 = 24302;
        }
        zzrn.zzc(i10, zznd.zza(), j11, currentTimeMillis);
    }

    public final synchronized void b() throws MlKitException {
        this.f21501i = this.f21497e.zzc();
    }

    public final synchronized void d() {
        zznc zznc;
        this.f21497e.zzb();
        f21495k = true;
        zzrl zzrl = this.f21498f;
        zznf zznf = new zznf();
        if (this.f21501i) {
            zznc = zznc.TYPE_THICK;
        } else {
            zznc = zznc.TYPE_THIN;
        }
        zznf.zze(zznc);
        zznr zznr = new zznr();
        zznr.zzi(b.c(this.f21496d));
        zznf.zzg(zznr.zzj());
        zzrl.zzd(zzro.zzf(zznf), zzne.ON_DEVICE_BARCODE_CLOSE);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzra j(long j10, zznd zznd, zzca zzca, zzca zzca2, zg.a aVar) {
        zzmo zzmo;
        zznc zznc;
        zznr zznr = new zznr();
        zzmu zzmu = new zzmu();
        zzmu.zzc(Long.valueOf(j10));
        zzmu.zzd(zznd);
        zzmu.zze(Boolean.valueOf(f21495k));
        Boolean bool = Boolean.TRUE;
        zzmu.zza(bool);
        zzmu.zzb(bool);
        zznr.zzh(zzmu.zzf());
        zznr.zzi(b.c(this.f21496d));
        zznr.zze(zzca.zzf());
        zznr.zzf(zzca2.zzf());
        int g10 = aVar.g();
        int d10 = f21494j.d(aVar);
        zzmn zzmn = new zzmn();
        if (g10 == -1) {
            zzmo = zzmo.BITMAP;
        } else if (g10 == 35) {
            zzmo = zzmo.YUV_420_888;
        } else if (g10 == 842094169) {
            zzmo = zzmo.YV12;
        } else if (g10 == 16) {
            zzmo = zzmo.NV16;
        } else if (g10 != 17) {
            zzmo = zzmo.UNKNOWN_FORMAT;
        } else {
            zzmo = zzmo.NV21;
        }
        zzmn.zza(zzmo);
        zzmn.zzb(Integer.valueOf(d10));
        zznr.zzg(zzmn.zzd());
        zznf zznf = new zznf();
        if (this.f21501i) {
            zznc = zznc.TYPE_THICK;
        } else {
            zznc = zznc.TYPE_THIN;
        }
        zznf.zze(zznc);
        zznf.zzg(zznr.zzj());
        return zzro.zzf(zznf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzra k(zzdz zzdz, int i10, zzmj zzmj) {
        zznc zznc;
        zznf zznf = new zznf();
        if (this.f21501i) {
            zznc = zznc.TYPE_THICK;
        } else {
            zznc = zznc.TYPE_THIN;
        }
        zznf.zze(zznc);
        zzdw zzdw = new zzdw();
        zzdw.zza(Integer.valueOf(i10));
        zzdw.zzc(zzdz);
        zzdw.zzb(zzmj);
        zznf.zzd(zzdw.zze());
        return zzro.zzf(zznf);
    }

    /* renamed from: l */
    public final synchronized List i(@NonNull zg.a aVar) throws MlKitException {
        zznd zznd;
        List a10;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f21500h.a(aVar);
        try {
            a10 = this.f21497e.a(aVar);
            m(zznd.NO_ERROR, elapsedRealtime, aVar, a10);
            f21495k = false;
        } catch (MlKitException e10) {
            MlKitException mlKitException = e10;
            if (mlKitException.a() == 14) {
                zznd = zznd.MODEL_NOT_DOWNLOADED;
            } else {
                zznd = zznd.UNKNOWN_ERROR;
            }
            m(zznd, elapsedRealtime, aVar, (List) null);
            throw mlKitException;
        }
        return a10;
    }
}
