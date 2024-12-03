package com.google.mlkit.vision.text.internal;

import ah.b;
import ah.c;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_text_common.zzd;
import com.google.android.gms.internal.mlkit_vision_text_common.zzh;
import com.google.android.gms.internal.mlkit_vision_text_common.zzj;
import com.google.android.gms.internal.mlkit_vision_text_common.zzp;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.l;
import dh.a;

final class e implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Context f21586a;

    /* renamed from: b  reason: collision with root package name */
    private final zzp f21587b = new zzp((String) null);

    /* renamed from: c  reason: collision with root package name */
    private boolean f21588c;

    /* renamed from: d  reason: collision with root package name */
    private zzh f21589d;

    e(Context context) {
        this.f21586a = context;
    }

    public final a a(zg.a aVar) throws MlKitException {
        int i10;
        Bitmap bitmap;
        if (this.f21589d == null) {
            zzb();
        }
        if (this.f21589d != null) {
            if (aVar.g() == -1) {
                bitmap = aVar.d();
                i10 = b.a(aVar.k());
            } else {
                bitmap = c.f().e(aVar);
                i10 = 0;
            }
            try {
                return h.a(((zzh) p.k(this.f21589d)).zze(pe.b.g(bitmap), new zzd(aVar.l(), aVar.h(), 0, 0, i10)), aVar.f());
            } catch (RemoteException e10) {
                throw new MlKitException("Failed to run legacy text recognizer.", 13, e10);
            }
        } else {
            throw new MlKitException("Waiting for the text recognition module to be downloaded. Please wait.", 14);
        }
    }

    public final void zzb() throws MlKitException {
        if (this.f21589d == null) {
            try {
                zzh zzd = zzj.zza(DynamiteModule.d(this.f21586a, DynamiteModule.f39208b, "com.google.android.gms.vision.dynamite").c("com.google.android.gms.vision.text.ChimeraNativeTextRecognizerCreator")).zzd(pe.b.g(this.f21586a), this.f21587b);
                this.f21589d = zzd;
                if (zzd == null && !this.f21588c) {
                    l.c(this.f21586a, "ocr");
                    this.f21588c = true;
                }
            } catch (RemoteException e10) {
                throw new MlKitException("Failed to create legacy text recognizer.", 13, e10);
            } catch (DynamiteModule.LoadingException e11) {
                throw new MlKitException("Failed to load deprecated vision dynamite module.", 13, e11);
            }
        }
    }

    public final void zzc() {
        zzh zzh = this.f21589d;
        if (zzh != null) {
            try {
                zzh.zzd();
            } catch (RemoteException unused) {
            }
            this.f21589d = null;
        }
    }
}
