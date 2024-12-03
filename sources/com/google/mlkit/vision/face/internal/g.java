package com.google.mlkit.vision.face.internal;

import ah.a;
import ah.d;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import bh.e;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.mlkit_vision_face.zzdk;
import com.google.android.gms.internal.mlkit_vision_face.zzdl;
import com.google.android.gms.internal.mlkit_vision_face.zzdn;
import com.google.android.gms.internal.mlkit_vision_face.zzjv;
import com.google.android.gms.internal.mlkit_vision_face.zzke;
import com.google.android.gms.internal.mlkit_vision_face.zzkf;
import com.google.android.gms.internal.mlkit_vision_face.zzkj;
import com.google.android.gms.internal.mlkit_vision_face.zzkr;
import com.google.android.gms.internal.mlkit_vision_face.zzks;
import com.google.android.gms.internal.mlkit_vision_face.zzkt;
import com.google.android.gms.internal.mlkit_vision_face.zzku;
import com.google.android.gms.internal.mlkit_vision_face.zzlj;
import com.google.android.gms.internal.mlkit_vision_face.zzll;
import com.google.android.gms.internal.mlkit_vision_face.zznr;
import com.google.android.gms.internal.mlkit_vision_face.zzny;
import com.google.android.gms.internal.mlkit_vision_face.zzoc;
import com.google.android.gms.internal.mlkit_vision_face.zzoe;
import com.google.android.gms.internal.mlkit_vision_face.zzof;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.f;
import com.google.mlkit.common.sdkinternal.i;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class g extends f {

    /* renamed from: j  reason: collision with root package name */
    static final AtomicBoolean f21555j = new AtomicBoolean(true);

    /* renamed from: k  reason: collision with root package name */
    private static final d f21556k = d.b();

    /* renamed from: d  reason: collision with root package name */
    private final e f21557d;

    /* renamed from: e  reason: collision with root package name */
    private final zzoc f21558e;

    /* renamed from: f  reason: collision with root package name */
    private final zzoe f21559f;

    /* renamed from: g  reason: collision with root package name */
    private final b f21560g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f21561h;

    /* renamed from: i  reason: collision with root package name */
    private final a f21562i = new a();

    public g(@NonNull zzoc zzoc, @NonNull e eVar, @NonNull b bVar) {
        p.l(eVar, "FaceDetectorOptions can not be null");
        this.f21557d = eVar;
        this.f21558e = zzoc;
        this.f21560g = bVar;
        this.f21559f = zzoe.zza(i.c().b());
    }

    static void m(@NonNull List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((bh.a) it.next()).g(-1);
        }
    }

    private final synchronized void n(zzks zzks, long j10, zg.a aVar, int i10, int i11) {
        int i12;
        synchronized (this) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - j10;
            this.f21558e.zzf(new e(this, elapsedRealtime, zzks, i10, i11, aVar), zzkt.ON_DEVICE_FACE_DETECT);
            zzdl zzdl = new zzdl();
            zzdl.zzc(zzks);
            zzdl.zzd(Boolean.valueOf(f21555j.get()));
            zzdl.zza(Integer.valueOf(i10));
            zzdl.zze(Integer.valueOf(i11));
            zzdl.zzb(h.a(this.f21557d));
            zzdn zzf = zzdl.zzf();
            f fVar = new f(this);
            com.google.mlkit.common.sdkinternal.g.d().execute(new zzny(this.f21558e, zzkt.AGGREGATED_ON_DEVICE_FACE_DETECTION, zzf, elapsedRealtime, fVar, (byte[]) null));
            long currentTimeMillis = System.currentTimeMillis();
            boolean z10 = this.f21561h;
            long j11 = currentTimeMillis - elapsedRealtime;
            zzoe zzoe = this.f21559f;
            if (true != z10) {
                i12 = 24303;
            } else {
                i12 = 24304;
            }
            zzoe.zzc(i12, zzks.zza(), j11, currentTimeMillis);
        }
    }

    public final synchronized void b() throws MlKitException {
        this.f21561h = this.f21560g.zzd();
    }

    public final synchronized void d() {
        zzkr zzkr;
        this.f21560g.zzb();
        f21555j.set(true);
        zzoc zzoc = this.f21558e;
        zzku zzku = new zzku();
        if (this.f21561h) {
            zzkr = zzkr.TYPE_THICK;
        } else {
            zzkr = zzkr.TYPE_THIN;
        }
        zzku.zze(zzkr);
        zzoc.zzd(zzof.zzf(zzku), zzkt.ON_DEVICE_FACE_CLOSE);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zznr j(long j10, zzks zzks, int i10, int i11, zg.a aVar) {
        zzkf zzkf;
        zzkr zzkr;
        zzlj zzlj = new zzlj();
        zzkj zzkj = new zzkj();
        zzkj.zzc(Long.valueOf(j10));
        zzkj.zzd(zzks);
        zzkj.zze(Boolean.valueOf(f21555j.get()));
        Boolean bool = Boolean.TRUE;
        zzkj.zza(bool);
        zzkj.zzb(bool);
        zzlj.zzg(zzkj.zzf());
        zzlj.zze(h.a(this.f21557d));
        zzlj.zzd(Integer.valueOf(i10));
        zzlj.zzh(Integer.valueOf(i11));
        d dVar = f21556k;
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
        zzlj.zzf(zzke.zzd());
        zzll zzi = zzlj.zzi();
        zzku zzku = new zzku();
        if (this.f21561h) {
            zzkr = zzkr.TYPE_THICK;
        } else {
            zzkr = zzkr.TYPE_THIN;
        }
        zzku.zze(zzkr);
        zzku.zzg(zzi);
        return zzof.zzf(zzku);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zznr k(zzdn zzdn, int i10, zzjv zzjv) {
        zzkr zzkr;
        zzku zzku = new zzku();
        if (this.f21561h) {
            zzkr = zzkr.TYPE_THICK;
        } else {
            zzkr = zzkr.TYPE_THIN;
        }
        zzku.zze(zzkr);
        zzdk zzdk = new zzdk();
        zzdk.zza(Integer.valueOf(i10));
        zzdk.zzc(zzdn);
        zzdk.zzb(zzjv);
        zzku.zzd(zzdk.zze());
        return zzof.zzf(zzku);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0108 A[Catch:{ MlKitException -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x010a A[Catch:{ MlKitException -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0111 A[Catch:{ MlKitException -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0113 A[Catch:{ MlKitException -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0139  */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List i(@androidx.annotation.NonNull zg.a r21) throws com.google.mlkit.common.MlKitException {
        /*
            r20 = this;
            r8 = r20
            r9 = r21
            monitor-enter(r20)
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0148 }
            ah.a r0 = r8.f21562i     // Catch:{ all -> 0x0148 }
            r0.a(r9)     // Catch:{ all -> 0x0148 }
            com.google.mlkit.vision.face.internal.b r0 = r8.f21560g     // Catch:{ MlKitException -> 0x012b }
            android.util.Pair r0 = r0.a(r9)     // Catch:{ MlKitException -> 0x012b }
            java.lang.Object r1 = r0.first     // Catch:{ MlKitException -> 0x012b }
            java.util.List r1 = (java.util.List) r1     // Catch:{ MlKitException -> 0x012b }
            java.lang.Object r0 = r0.second     // Catch:{ MlKitException -> 0x012b }
            java.util.List r0 = (java.util.List) r0     // Catch:{ MlKitException -> 0x012b }
            if (r1 != 0) goto L_0x002b
            if (r0 == 0) goto L_0x0021
            goto L_0x002b
        L_0x0021:
            com.google.mlkit.common.MlKitException r0 = new com.google.mlkit.common.MlKitException     // Catch:{ MlKitException -> 0x012b }
            java.lang.String r1 = "No detector is enabled"
            r2 = 13
            r0.<init>(r1, r2)     // Catch:{ MlKitException -> 0x012b }
            throw r0     // Catch:{ MlKitException -> 0x012b }
        L_0x002b:
            if (r1 != 0) goto L_0x0038
            java.lang.Object r2 = com.google.android.gms.common.internal.p.k(r0)     // Catch:{ MlKitException -> 0x012b }
            java.util.List r2 = (java.util.List) r2     // Catch:{ MlKitException -> 0x012b }
        L_0x0033:
            r9 = r2
            r18 = r10
            goto L_0x0104
        L_0x0038:
            if (r0 != 0) goto L_0x0041
            java.lang.Object r2 = com.google.android.gms.common.internal.p.k(r1)     // Catch:{ MlKitException -> 0x012b }
            java.util.List r2 = (java.util.List) r2     // Catch:{ MlKitException -> 0x012b }
            goto L_0x0033
        L_0x0041:
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ MlKitException -> 0x012b }
            r2.<init>()     // Catch:{ MlKitException -> 0x012b }
            java.util.Iterator r3 = r0.iterator()     // Catch:{ MlKitException -> 0x012b }
        L_0x004a:
            boolean r4 = r3.hasNext()     // Catch:{ MlKitException -> 0x012b }
            if (r4 == 0) goto L_0x00fc
            java.lang.Object r4 = r3.next()     // Catch:{ MlKitException -> 0x012b }
            bh.a r4 = (bh.a) r4     // Catch:{ MlKitException -> 0x012b }
            java.util.Iterator r5 = r1.iterator()     // Catch:{ MlKitException -> 0x012b }
            r6 = 0
        L_0x005b:
            boolean r7 = r5.hasNext()     // Catch:{ MlKitException -> 0x012b }
            if (r7 == 0) goto L_0x00eb
            java.lang.Object r7 = r5.next()     // Catch:{ MlKitException -> 0x012b }
            bh.a r7 = (bh.a) r7     // Catch:{ MlKitException -> 0x012b }
            android.graphics.Rect r13 = r4.a()     // Catch:{ MlKitException -> 0x012b }
            if (r13 == 0) goto L_0x00d8
            android.graphics.Rect r13 = r7.a()     // Catch:{ MlKitException -> 0x012b }
            if (r13 == 0) goto L_0x00d8
            android.graphics.Rect r13 = r4.a()     // Catch:{ MlKitException -> 0x012b }
            android.graphics.Rect r14 = r7.a()     // Catch:{ MlKitException -> 0x012b }
            boolean r15 = r13.intersect(r14)     // Catch:{ MlKitException -> 0x012b }
            if (r15 == 0) goto L_0x00d8
            int r15 = r13.right     // Catch:{ MlKitException -> 0x012b }
            int r12 = r14.right     // Catch:{ MlKitException -> 0x012b }
            int r12 = java.lang.Math.min(r15, r12)     // Catch:{ MlKitException -> 0x012b }
            int r15 = r13.left     // Catch:{ MlKitException -> 0x012b }
            r16 = r3
            int r3 = r14.left     // Catch:{ MlKitException -> 0x012b }
            int r3 = java.lang.Math.max(r15, r3)     // Catch:{ MlKitException -> 0x012b }
            int r12 = r12 - r3
            int r3 = r13.bottom     // Catch:{ MlKitException -> 0x012b }
            int r15 = r14.bottom     // Catch:{ MlKitException -> 0x012b }
            int r3 = java.lang.Math.min(r3, r15)     // Catch:{ MlKitException -> 0x012b }
            int r15 = r13.top     // Catch:{ MlKitException -> 0x012b }
            r17 = r5
            int r5 = r14.top     // Catch:{ MlKitException -> 0x012b }
            int r5 = java.lang.Math.max(r15, r5)     // Catch:{ MlKitException -> 0x012b }
            int r3 = r3 - r5
            int r12 = r12 * r3
            r18 = r10
            double r9 = (double) r12
            int r3 = r13.right     // Catch:{ MlKitException -> 0x0129 }
            int r5 = r13.left     // Catch:{ MlKitException -> 0x0129 }
            int r3 = r3 - r5
            int r5 = r13.bottom     // Catch:{ MlKitException -> 0x0129 }
            int r11 = r13.top     // Catch:{ MlKitException -> 0x0129 }
            int r5 = r5 - r11
            int r3 = r3 * r5
            double r11 = (double) r3     // Catch:{ MlKitException -> 0x0129 }
            int r3 = r14.right     // Catch:{ MlKitException -> 0x0129 }
            int r5 = r14.left     // Catch:{ MlKitException -> 0x0129 }
            int r3 = r3 - r5
            int r5 = r14.bottom     // Catch:{ MlKitException -> 0x0129 }
            int r13 = r14.top     // Catch:{ MlKitException -> 0x0129 }
            int r5 = r5 - r13
            int r3 = r3 * r5
            double r13 = (double) r3     // Catch:{ MlKitException -> 0x0129 }
            double r11 = r11 + r13
            double r11 = r11 - r9
            double r9 = r9 / r11
            r11 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 <= 0) goto L_0x00de
            android.util.SparseArray r3 = r4.e()     // Catch:{ MlKitException -> 0x0129 }
            r7.f(r3)     // Catch:{ MlKitException -> 0x0129 }
            r6 = 1
            goto L_0x00de
        L_0x00d8:
            r16 = r3
            r17 = r5
            r18 = r10
        L_0x00de:
            r2.add(r7)     // Catch:{ MlKitException -> 0x0129 }
            r9 = r21
            r3 = r16
            r5 = r17
            r10 = r18
            goto L_0x005b
        L_0x00eb:
            r16 = r3
            r18 = r10
            if (r6 != 0) goto L_0x00f4
            r2.add(r4)     // Catch:{ MlKitException -> 0x0129 }
        L_0x00f4:
            r9 = r21
            r3 = r16
            r10 = r18
            goto L_0x004a
        L_0x00fc:
            r18 = r10
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ MlKitException -> 0x0129 }
            r3.<init>(r2)     // Catch:{ MlKitException -> 0x0129 }
            r9 = r3
        L_0x0104:
            com.google.android.gms.internal.mlkit_vision_face.zzks r2 = com.google.android.gms.internal.mlkit_vision_face.zzks.NO_ERROR     // Catch:{ MlKitException -> 0x0129 }
            if (r0 != 0) goto L_0x010a
            r6 = 0
            goto L_0x010f
        L_0x010a:
            int r0 = r0.size()     // Catch:{ MlKitException -> 0x0129 }
            r6 = r0
        L_0x010f:
            if (r1 != 0) goto L_0x0113
            r7 = 0
            goto L_0x0118
        L_0x0113:
            int r0 = r1.size()     // Catch:{ MlKitException -> 0x0129 }
            r7 = r0
        L_0x0118:
            r1 = r20
            r3 = r18
            r5 = r21
            r1.n(r2, r3, r5, r6, r7)     // Catch:{ MlKitException -> 0x0129 }
            java.util.concurrent.atomic.AtomicBoolean r0 = f21555j     // Catch:{ MlKitException -> 0x0129 }
            r1 = 0
            r0.set(r1)     // Catch:{ MlKitException -> 0x0129 }
            monitor-exit(r20)
            return r9
        L_0x0129:
            r0 = move-exception
            goto L_0x012e
        L_0x012b:
            r0 = move-exception
            r18 = r10
        L_0x012e:
            int r1 = r0.a()     // Catch:{ all -> 0x0148 }
            r2 = 14
            if (r1 != r2) goto L_0x0139
            com.google.android.gms.internal.mlkit_vision_face.zzks r1 = com.google.android.gms.internal.mlkit_vision_face.zzks.MODEL_NOT_DOWNLOADED     // Catch:{ all -> 0x0148 }
            goto L_0x013b
        L_0x0139:
            com.google.android.gms.internal.mlkit_vision_face.zzks r1 = com.google.android.gms.internal.mlkit_vision_face.zzks.UNKNOWN_ERROR     // Catch:{ all -> 0x0148 }
        L_0x013b:
            r2 = r1
            r6 = 0
            r7 = 0
            r1 = r20
            r3 = r18
            r5 = r21
            r1.n(r2, r3, r5, r6, r7)     // Catch:{ all -> 0x0148 }
            throw r0     // Catch:{ all -> 0x0148 }
        L_0x0148:
            r0 = move-exception
            monitor-exit(r20)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.face.internal.g.i(zg.a):java.util.List");
    }
}
