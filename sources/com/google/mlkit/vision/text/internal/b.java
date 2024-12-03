package com.google.mlkit.vision.text.internal;

import ah.d;
import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_text_common.zzeb;
import com.google.android.gms.internal.mlkit_vision_text_common.zzec;
import com.google.android.gms.internal.mlkit_vision_text_common.zzee;
import com.google.android.gms.internal.mlkit_vision_text_common.zzkb;
import com.google.android.gms.internal.mlkit_vision_text_common.zzke;
import com.google.android.gms.internal.mlkit_vision_text_common.zzkf;
import com.google.android.gms.internal.mlkit_vision_text_common.zzkj;
import com.google.android.gms.internal.mlkit_vision_text_common.zzkr;
import com.google.android.gms.internal.mlkit_vision_text_common.zzks;
import com.google.android.gms.internal.mlkit_vision_text_common.zzkt;
import com.google.android.gms.internal.mlkit_vision_text_common.zzku;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmk;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmm;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmn;
import com.google.android.gms.internal.mlkit_vision_text_common.zznv;
import com.google.android.gms.internal.mlkit_vision_text_common.zzoc;
import com.google.android.gms.internal.mlkit_vision_text_common.zzog;
import com.google.android.gms.internal.mlkit_vision_text_common.zzoi;
import com.google.android.gms.internal.mlkit_vision_text_common.zzoj;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.f;
import com.google.mlkit.common.sdkinternal.g;
import com.google.mlkit.common.sdkinternal.i;
import com.google.mlkit.common.sdkinternal.n;
import dh.a;

public class b extends f<a, zg.a> {

    /* renamed from: h  reason: collision with root package name */
    private static final n f21573h = new n();

    /* renamed from: i  reason: collision with root package name */
    static boolean f21574i = true;

    /* renamed from: j  reason: collision with root package name */
    private static final d f21575j = d.b();
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final i f21576d;

    /* renamed from: e  reason: collision with root package name */
    private final zzog f21577e;

    /* renamed from: f  reason: collision with root package name */
    private final zzoi f21578f = zzoi.zza(i.c().b());

    /* renamed from: g  reason: collision with root package name */
    private final dh.d f21579g;

    b(@NonNull zzog zzog, @NonNull i iVar, @NonNull dh.d dVar) {
        super(f21573h);
        this.f21577e = zzog;
        this.f21576d = iVar;
        this.f21579g = dVar;
    }

    static i m(Context context, dh.d dVar, zzog zzog) {
        if (com.google.android.gms.common.d.h().b(context) >= 204700000 || dVar.c()) {
            return new d(context, dVar, zzog);
        }
        return new e(context);
    }

    private final void n(zzks zzks, long j10, zg.a aVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j10;
        this.f21577e.zzf(new l(this, elapsedRealtime, zzks, aVar), zzkt.ON_DEVICE_TEXT_DETECT);
        zzec zzec = new zzec();
        zzec.zza(zzks);
        zzec.zzb(Boolean.valueOf(f21574i));
        zzmn zzmn = new zzmn();
        zzmn.zza(a.a(this.f21579g.e()));
        zzec.zzc(zzmn.zzc());
        zzee zzd = zzec.zzd();
        m mVar = new m(this);
        g.d().execute(new zzoc(this.f21577e, zzkt.AGGREGATED_ON_DEVICE_TEXT_DETECTION, zzd, elapsedRealtime, mVar, (byte[]) null));
        long currentTimeMillis = System.currentTimeMillis();
        this.f21578f.zzc(this.f21579g.d(), zzks.zza(), currentTimeMillis - elapsedRealtime, currentTimeMillis);
    }

    public final synchronized void b() throws MlKitException {
        this.f21576d.zzb();
    }

    public final synchronized void d() {
        f21574i = true;
        this.f21576d.zzc();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zznv j(long j10, zzks zzks, zg.a aVar) {
        zzkf zzkf;
        zzkr zzkr;
        zzmk zzmk = new zzmk();
        zzkj zzkj = new zzkj();
        zzkj.zzc(Long.valueOf(j10));
        zzkj.zzd(zzks);
        zzkj.zze(Boolean.valueOf(f21574i));
        Boolean bool = Boolean.TRUE;
        zzkj.zza(bool);
        zzkj.zzb(bool);
        zzmk.zzd(zzkj.zzf());
        d dVar = f21575j;
        int c10 = dVar.c(aVar);
        int d10 = dVar.d(aVar);
        zzke zzke = new zzke();
        if (c10 == -1) {
            zzkf = zzkf.BITMAP;
        } else if (c10 == 35) {
            zzkf = zzkf.YUV_420_888;
        } else if (c10 == 842094169) {
            zzkf = zzkf.YV12;
        } else if (c10 == 16) {
            zzkf = zzkf.NV16;
        } else if (c10 != 17) {
            zzkf = zzkf.UNKNOWN_FORMAT;
        } else {
            zzkf = zzkf.NV21;
        }
        zzke.zza(zzkf);
        zzke.zzb(Integer.valueOf(d10));
        zzmk.zzc(zzke.zzd());
        zzmn zzmn = new zzmn();
        zzmn.zza(a.a(this.f21579g.e()));
        zzmk.zze(zzmn.zzc());
        zzmm zzf = zzmk.zzf();
        zzku zzku = new zzku();
        if (this.f21579g.c()) {
            zzkr = zzkr.TYPE_THICK;
        } else {
            zzkr = zzkr.TYPE_THIN;
        }
        zzku.zze(zzkr);
        zzku.zzh(zzf);
        return zzoj.zzf(zzku);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zznv k(zzee zzee, int i10, zzkb zzkb) {
        zzkr zzkr;
        zzku zzku = new zzku();
        if (this.f21579g.c()) {
            zzkr = zzkr.TYPE_THICK;
        } else {
            zzkr = zzkr.TYPE_THIN;
        }
        zzku.zze(zzkr);
        zzeb zzeb = new zzeb();
        zzeb.zza(Integer.valueOf(i10));
        zzeb.zzc(zzee);
        zzeb.zzb(zzkb);
        zzku.zzd(zzeb.zze());
        return zzoj.zzf(zzku);
    }

    @NonNull
    /* renamed from: l */
    public final synchronized a i(@NonNull zg.a aVar) throws MlKitException {
        zzks zzks;
        a a10;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            a10 = this.f21576d.a(aVar);
            n(zzks.NO_ERROR, elapsedRealtime, aVar);
            f21574i = false;
        } catch (MlKitException e10) {
            if (e10.a() == 14) {
                zzks = zzks.MODEL_NOT_DOWNLOADED;
            } else {
                zzks = zzks.UNKNOWN_ERROR;
            }
            n(zzks, elapsedRealtime, aVar);
            throw e10;
        }
        return a10;
    }
}
