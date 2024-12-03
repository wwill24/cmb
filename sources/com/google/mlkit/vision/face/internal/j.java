package com.google.mlkit.vision.face.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Pair;
import bh.e;
import com.google.android.gms.common.d;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_face.zzh;
import com.google.android.gms.internal.mlkit_vision_face.zzj;
import com.google.android.gms.internal.mlkit_vision_face.zzks;
import com.google.android.gms.internal.mlkit_vision_face.zzl;
import com.google.android.gms.internal.mlkit_vision_face.zzm;
import com.google.android.gms.internal.mlkit_vision_face.zzoc;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.l;
import java.util.List;
import pe.b;
import zg.a;

final class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f21565a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f21566b;

    /* renamed from: c  reason: collision with root package name */
    private final e f21567c;

    /* renamed from: d  reason: collision with root package name */
    private final int f21568d;

    /* renamed from: e  reason: collision with root package name */
    private final zzoc f21569e;

    /* renamed from: f  reason: collision with root package name */
    private zzj f21570f;

    /* renamed from: g  reason: collision with root package name */
    private zzj f21571g;

    j(Context context, e eVar, zzoc zzoc) {
        this.f21566b = context;
        this.f21567c = eVar;
        this.f21568d = d.h().b(context);
        this.f21569e = zzoc;
    }

    static int b(int i10) {
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        throw new IllegalArgumentException("Invalid classification type: " + i10);
    }

    static int c(int i10) {
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        throw new IllegalArgumentException("Invalid landmark type: " + i10);
    }

    private static int d(int i10) {
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        throw new IllegalArgumentException("Invalid mode type: " + i10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00a5 A[LOOP:0: B:12:0x00a3->B:13:0x00a5, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List e(com.google.android.gms.internal.mlkit_vision_face.zzj r15, zg.a r16) throws com.google.mlkit.common.MlKitException {
        /*
            r14 = this;
            com.google.android.gms.internal.mlkit_vision_face.zzp r11 = new com.google.android.gms.internal.mlkit_vision_face.zzp     // Catch:{ RemoteException -> 0x00b9 }
            int r2 = r16.l()     // Catch:{ RemoteException -> 0x00b9 }
            int r3 = r16.h()     // Catch:{ RemoteException -> 0x00b9 }
            r4 = 0
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ RemoteException -> 0x00b9 }
            int r0 = r16.k()     // Catch:{ RemoteException -> 0x00b9 }
            int r7 = ah.b.a(r0)     // Catch:{ RemoteException -> 0x00b9 }
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ RemoteException -> 0x00b9 }
            int r0 = r16.g()     // Catch:{ RemoteException -> 0x00b9 }
            r1 = 35
            r12 = 0
            if (r0 != r1) goto L_0x0089
            r13 = r14
            int r0 = r13.f21568d     // Catch:{ RemoteException -> 0x00b7 }
            r1 = 201500000(0xc02a560, float:1.0064601E-31)
            if (r0 < r1) goto L_0x008a
            android.media.Image$Plane[] r0 = r16.j()     // Catch:{ RemoteException -> 0x00b7 }
            java.lang.Object r0 = com.google.android.gms.common.internal.p.k(r0)     // Catch:{ RemoteException -> 0x00b7 }
            android.media.Image$Plane[] r0 = (android.media.Image.Plane[]) r0     // Catch:{ RemoteException -> 0x00b7 }
            r1 = r0[r12]     // Catch:{ RemoteException -> 0x00b7 }
            java.nio.ByteBuffer r1 = r1.getBuffer()     // Catch:{ RemoteException -> 0x00b7 }
            pe.a r2 = pe.b.g(r1)     // Catch:{ RemoteException -> 0x00b7 }
            r1 = 1
            r3 = r0[r1]     // Catch:{ RemoteException -> 0x00b7 }
            java.nio.ByteBuffer r3 = r3.getBuffer()     // Catch:{ RemoteException -> 0x00b7 }
            pe.a r3 = pe.b.g(r3)     // Catch:{ RemoteException -> 0x00b7 }
            r4 = 2
            r5 = r0[r4]     // Catch:{ RemoteException -> 0x00b7 }
            java.nio.ByteBuffer r5 = r5.getBuffer()     // Catch:{ RemoteException -> 0x00b7 }
            pe.a r5 = pe.b.g(r5)     // Catch:{ RemoteException -> 0x00b7 }
            r6 = r0[r12]     // Catch:{ RemoteException -> 0x00b7 }
            int r6 = r6.getPixelStride()     // Catch:{ RemoteException -> 0x00b7 }
            r7 = r0[r1]     // Catch:{ RemoteException -> 0x00b7 }
            int r7 = r7.getPixelStride()     // Catch:{ RemoteException -> 0x00b7 }
            r8 = r0[r4]     // Catch:{ RemoteException -> 0x00b7 }
            int r8 = r8.getPixelStride()     // Catch:{ RemoteException -> 0x00b7 }
            r9 = r0[r12]     // Catch:{ RemoteException -> 0x00b7 }
            int r9 = r9.getRowStride()     // Catch:{ RemoteException -> 0x00b7 }
            r1 = r0[r1]     // Catch:{ RemoteException -> 0x00b7 }
            int r10 = r1.getRowStride()     // Catch:{ RemoteException -> 0x00b7 }
            r0 = r0[r4]     // Catch:{ RemoteException -> 0x00b7 }
            int r0 = r0.getRowStride()     // Catch:{ RemoteException -> 0x00b7 }
            r1 = r15
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r0
            com.google.android.gms.internal.mlkit_vision_face.zzf[] r0 = r1.zzf(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ RemoteException -> 0x00b7 }
            r1 = r16
            goto L_0x009d
        L_0x0089:
            r13 = r14
        L_0x008a:
            ah.c r0 = ah.c.f()     // Catch:{ RemoteException -> 0x00b7 }
            r1 = r16
            java.nio.ByteBuffer r0 = r0.d(r1, r12)     // Catch:{ RemoteException -> 0x00b7 }
            pe.a r0 = pe.b.g(r0)     // Catch:{ RemoteException -> 0x00b7 }
            r2 = r15
            com.google.android.gms.internal.mlkit_vision_face.zzf[] r0 = r15.zze(r0, r11)     // Catch:{ RemoteException -> 0x00b7 }
        L_0x009d:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int r3 = r0.length
        L_0x00a3:
            if (r12 >= r3) goto L_0x00b6
            r4 = r0[r12]
            bh.a r5 = new bh.a
            android.graphics.Matrix r6 = r16.f()
            r5.<init>((com.google.android.gms.internal.mlkit_vision_face.zzf) r4, (android.graphics.Matrix) r6)
            r2.add(r5)
            int r12 = r12 + 1
            goto L_0x00a3
        L_0x00b6:
            return r2
        L_0x00b7:
            r0 = move-exception
            goto L_0x00bb
        L_0x00b9:
            r0 = move-exception
            r13 = r14
        L_0x00bb:
            com.google.mlkit.common.MlKitException r1 = new com.google.mlkit.common.MlKitException
            r2 = 13
            java.lang.String r3 = "Failed to detect with legacy face detector"
            r1.<init>(r3, r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.face.internal.j.e(com.google.android.gms.internal.mlkit_vision_face.zzj, zg.a):java.util.List");
    }

    public final Pair a(a aVar) throws MlKitException {
        List list;
        if (this.f21570f == null && this.f21571g == null) {
            zzd();
        }
        zzj zzj = this.f21570f;
        if (zzj == null && this.f21571g == null) {
            throw new MlKitException("Waiting for the face detection module to be downloaded. Please wait.", 14);
        }
        List list2 = null;
        if (zzj != null) {
            list = e(zzj, aVar);
            if (!this.f21567c.g()) {
                g.m(list);
            }
        } else {
            list = null;
        }
        zzj zzj2 = this.f21571g;
        if (zzj2 != null) {
            list2 = e(zzj2, aVar);
            g.m(list2);
        }
        return new Pair(list, list2);
    }

    public final void zzb() {
        zzj zzj = this.f21570f;
        if (zzj != null) {
            try {
                zzj.zzd();
            } catch (RemoteException unused) {
            }
            this.f21570f = null;
        }
        zzj zzj2 = this.f21571g;
        if (zzj2 != null) {
            try {
                zzj2.zzd();
            } catch (RemoteException unused2) {
            }
            this.f21571g = null;
        }
    }

    public final boolean zzd() throws MlKitException {
        if (this.f21570f != null || this.f21571g != null) {
            return false;
        }
        try {
            zzm zza = zzl.zza(DynamiteModule.d(this.f21566b, DynamiteModule.f39208b, "com.google.android.gms.vision.dynamite").c("com.google.android.gms.vision.face.ChimeraNativeFaceDetectorCreator"));
            pe.a g10 = b.g(this.f21566b);
            if (this.f21567c.c() == 2) {
                if (this.f21571g == null) {
                    this.f21571g = zza.zzd(g10, new zzh(2, 2, 0, true, false, this.f21567c.a()));
                }
                if ((this.f21567c.d() == 2 || this.f21567c.b() == 2 || this.f21567c.e() == 2) && this.f21570f == null) {
                    this.f21570f = zza.zzd(g10, new zzh(d(this.f21567c.e()), c(this.f21567c.d()), b(this.f21567c.b()), false, this.f21567c.g(), this.f21567c.a()));
                }
            } else if (this.f21570f == null) {
                this.f21570f = zza.zzd(g10, new zzh(d(this.f21567c.e()), c(this.f21567c.d()), b(this.f21567c.b()), false, this.f21567c.g(), this.f21567c.a()));
            }
            if (this.f21570f == null && this.f21571g == null && !this.f21565a) {
                l.c(this.f21566b, "barcode");
                this.f21565a = true;
            }
            h.c(this.f21569e, false, zzks.NO_ERROR);
            return false;
        } catch (RemoteException e10) {
            throw new MlKitException("Failed to create legacy face detector.", 13, e10);
        } catch (DynamiteModule.LoadingException e11) {
            throw new MlKitException("Failed to load deprecated vision dynamite module.", 13, e11);
        }
    }
}
