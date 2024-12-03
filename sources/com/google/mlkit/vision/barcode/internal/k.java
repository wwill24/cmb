package com.google.mlkit.vision.barcode.internal;

import ah.c;
import android.content.Context;
import android.media.Image;
import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_barcode.zzad;
import com.google.android.gms.internal.mlkit_vision_barcode.zzaf;
import com.google.android.gms.internal.mlkit_vision_barcode.zzah;
import com.google.android.gms.internal.mlkit_vision_barcode.zzaj;
import com.google.android.gms.internal.mlkit_vision_barcode.zznd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrl;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.l;
import java.util.ArrayList;
import java.util.List;
import vg.b;
import zg.a;

final class k implements i {

    /* renamed from: a  reason: collision with root package name */
    private boolean f21510a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f21511b;

    /* renamed from: c  reason: collision with root package name */
    private final zzad f21512c;

    /* renamed from: d  reason: collision with root package name */
    private final zzrl f21513d;

    /* renamed from: e  reason: collision with root package name */
    private zzaf f21514e;

    k(Context context, b bVar, zzrl zzrl) {
        zzad zzad = new zzad();
        this.f21512c = zzad;
        this.f21511b = context;
        zzad.zza = bVar.a();
        this.f21513d = zzrl;
    }

    public final List a(a aVar) throws MlKitException {
        zzq[] zzqArr;
        if (this.f21514e == null) {
            zzc();
        }
        zzaf zzaf = this.f21514e;
        if (zzaf != null) {
            zzaf zzaf2 = (zzaf) p.k(zzaf);
            zzaj zzaj = new zzaj(aVar.l(), aVar.h(), 0, 0, ah.b.a(aVar.k()));
            try {
                int g10 = aVar.g();
                if (g10 == -1) {
                    zzqArr = zzaf2.zzf(pe.b.g(aVar.d()), zzaj);
                } else if (g10 == 17) {
                    zzqArr = zzaf2.zze(pe.b.g(aVar.e()), zzaj);
                } else if (g10 == 35) {
                    Image.Plane[] planeArr = (Image.Plane[]) p.k(aVar.j());
                    zzaj.zza = planeArr[0].getRowStride();
                    zzqArr = zzaf2.zze(pe.b.g(planeArr[0].getBuffer()), zzaj);
                } else if (g10 == 842094169) {
                    zzqArr = zzaf2.zze(pe.b.g(c.f().d(aVar, false)), zzaj);
                } else {
                    throw new MlKitException("Unsupported image format: " + aVar.g(), 3);
                }
                ArrayList arrayList = new ArrayList();
                for (zzq cVar : zzqArr) {
                    arrayList.add(new wg.a(new yg.c(cVar), aVar.f()));
                }
                return arrayList;
            } catch (RemoteException e10) {
                throw new MlKitException("Failed to detect with legacy barcode detector", 13, e10);
            }
        } else {
            throw new MlKitException("Error initializing the legacy barcode scanner.", 14);
        }
    }

    public final void zzb() {
        zzaf zzaf = this.f21514e;
        if (zzaf != null) {
            try {
                zzaf.zzd();
            } catch (RemoteException unused) {
            }
            this.f21514e = null;
        }
    }

    public final boolean zzc() throws MlKitException {
        if (this.f21514e != null) {
            return false;
        }
        try {
            zzaf zzd = zzah.zza(DynamiteModule.d(this.f21511b, DynamiteModule.f39208b, "com.google.android.gms.vision.dynamite").c("com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator")).zzd(pe.b.g(this.f21511b), this.f21512c);
            this.f21514e = zzd;
            if (zzd == null) {
                if (!this.f21510a) {
                    l.c(this.f21511b, "barcode");
                    this.f21510a = true;
                    b.e(this.f21513d, zznd.OPTIONAL_MODULE_NOT_AVAILABLE);
                    throw new MlKitException("Waiting for the barcode module to be downloaded. Please wait.", 14);
                }
            }
            b.e(this.f21513d, zznd.NO_ERROR);
            return false;
        } catch (RemoteException e10) {
            throw new MlKitException("Failed to create legacy barcode detector.", 13, e10);
        } catch (DynamiteModule.LoadingException e11) {
            throw new MlKitException("Failed to load deprecated vision dynamite module.", 13, e11);
        }
    }
}
