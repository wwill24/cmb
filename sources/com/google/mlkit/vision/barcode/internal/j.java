package com.google.mlkit.vision.barcode.internal;

import ah.d;
import android.content.Context;
import android.media.Image;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcd;
import com.google.android.gms.internal.mlkit_vision_barcode.zznd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsm;
import com.google.android.gms.internal.mlkit_vision_barcode.zzso;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsw;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsy;
import com.google.android.gms.internal.mlkit_vision_barcode.zztf;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.l;
import java.util.ArrayList;
import java.util.List;
import vg.b;
import zg.a;

final class j implements i {

    /* renamed from: h  reason: collision with root package name */
    private static final zzcd f21502h = zzcd.zzh("com.google.android.gms.vision.barcode", "com.google.android.gms.tflite_dynamite");

    /* renamed from: a  reason: collision with root package name */
    private boolean f21503a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f21504b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21505c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f21506d;

    /* renamed from: e  reason: collision with root package name */
    private final b f21507e;

    /* renamed from: f  reason: collision with root package name */
    private final zzrl f21508f;

    /* renamed from: g  reason: collision with root package name */
    private zzsw f21509g;

    j(Context context, b bVar, zzrl zzrl) {
        this.f21506d = context;
        this.f21507e = bVar;
        this.f21508f = zzrl;
    }

    static boolean b(Context context) {
        return DynamiteModule.a(context, "com.google.mlkit.dynamite.barcode") > 0;
    }

    public final List a(a aVar) throws MlKitException {
        if (this.f21509g == null) {
            zzc();
        }
        zzsw zzsw = (zzsw) p.k(this.f21509g);
        if (!this.f21503a) {
            try {
                zzsw.zze();
                this.f21503a = true;
            } catch (RemoteException e10) {
                throw new MlKitException("Failed to init barcode scanner.", 13, e10);
            }
        }
        int l10 = aVar.l();
        if (aVar.g() == 35) {
            l10 = ((Image.Plane[]) p.k(aVar.j()))[0].getRowStride();
        }
        try {
            List<zzsm> zzd = zzsw.zzd(d.b().a(aVar), new zztf(aVar.g(), l10, aVar.h(), ah.b.a(aVar.k()), SystemClock.elapsedRealtime()));
            ArrayList arrayList = new ArrayList();
            for (zzsm bVar : zzd) {
                arrayList.add(new wg.a(new yg.b(bVar), aVar.f()));
            }
            return arrayList;
        } catch (RemoteException e11) {
            throw new MlKitException("Failed to run barcode scanner.", 13, e11);
        }
    }

    /* access modifiers changed from: package-private */
    public final zzsw c(DynamiteModule.a aVar, String str, String str2) throws DynamiteModule.LoadingException, RemoteException {
        return zzsy.zza(DynamiteModule.d(this.f21506d, aVar, str).c(str2)).zzd(pe.b.g(this.f21506d), new zzso(this.f21507e.a(), this.f21507e.c()));
    }

    public final void zzb() {
        zzsw zzsw = this.f21509g;
        if (zzsw != null) {
            try {
                zzsw.zzf();
            } catch (RemoteException unused) {
            }
            this.f21509g = null;
            this.f21503a = false;
        }
    }

    public final boolean zzc() throws MlKitException {
        if (this.f21509g != null) {
            return this.f21504b;
        }
        if (b(this.f21506d)) {
            this.f21504b = true;
            try {
                this.f21509g = c(DynamiteModule.f39209c, "com.google.mlkit.dynamite.barcode", "com.google.mlkit.vision.barcode.bundled.internal.ThickBarcodeScannerCreator");
            } catch (DynamiteModule.LoadingException e10) {
                throw new MlKitException("Failed to load the bundled barcode module.", 13, e10);
            } catch (RemoteException e11) {
                throw new MlKitException("Failed to create thick barcode scanner.", 13, e11);
            }
        } else {
            this.f21504b = false;
            if (!l.a(this.f21506d, f21502h)) {
                if (!this.f21505c) {
                    l.d(this.f21506d, zzcd.zzh("barcode", "tflite_dynamite"));
                    this.f21505c = true;
                }
                b.e(this.f21508f, zznd.OPTIONAL_MODULE_NOT_AVAILABLE);
                throw new MlKitException("Waiting for the barcode module to be downloaded. Please wait.", 14);
            }
            try {
                this.f21509g = c(DynamiteModule.f39208b, "com.google.android.gms.vision.barcode", "com.google.android.gms.vision.barcode.mlkit.BarcodeScannerCreator");
            } catch (RemoteException | DynamiteModule.LoadingException e12) {
                b.e(this.f21508f, zznd.OPTIONAL_MODULE_INIT_ERROR);
                throw new MlKitException("Failed to create thin barcode scanner.", 13, e12);
            }
        }
        b.e(this.f21508f, zznd.NO_ERROR);
        return this.f21504b;
    }
}
