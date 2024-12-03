package com.google.mlkit.vision.text.internal;

import ah.b;
import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_text_common.zzks;
import com.google.android.gms.internal.mlkit_vision_text_common.zzog;
import com.google.android.gms.internal.mlkit_vision_text_common.zzou;
import com.google.android.gms.internal.mlkit_vision_text_common.zzow;
import com.google.android.gms.internal.mlkit_vision_text_common.zzoy;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.l;
import dh.a;

final class d implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Context f21580a;

    /* renamed from: b  reason: collision with root package name */
    private final dh.d f21581b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21582c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21583d;

    /* renamed from: e  reason: collision with root package name */
    private final zzog f21584e;

    /* renamed from: f  reason: collision with root package name */
    private zzow f21585f;

    d(Context context, dh.d dVar, zzog zzog) {
        this.f21580a = context;
        this.f21581b = dVar;
        this.f21584e = zzog;
    }

    public final a a(zg.a aVar) throws MlKitException {
        if (this.f21585f == null) {
            zzb();
        }
        zzow zzow = (zzow) p.k(this.f21585f);
        if (!this.f21582c) {
            try {
                zzow.zze();
                this.f21582c = true;
            } catch (RemoteException e10) {
                throw new MlKitException("Failed to init text recognizer ".concat(String.valueOf(this.f21581b.b())), 13, e10);
            }
        }
        try {
            return new a(zzow.zzd(ah.d.b().a(aVar), new zzou(aVar.g(), aVar.l(), aVar.h(), b.a(aVar.k()), SystemClock.elapsedRealtime())), aVar.f());
        } catch (RemoteException e11) {
            throw new MlKitException("Failed to run text recognizer ".concat(String.valueOf(this.f21581b.b())), 13, e11);
        }
    }

    public final void zzb() throws MlKitException {
        DynamiteModule.a aVar;
        if (this.f21585f == null) {
            try {
                Context context = this.f21580a;
                if (this.f21581b.c()) {
                    aVar = DynamiteModule.f39209c;
                } else {
                    aVar = DynamiteModule.f39208b;
                }
                this.f21585f = zzoy.zza(DynamiteModule.d(context, aVar, this.f21581b.getModuleId()).c(this.f21581b.f())).zzd(pe.b.g(this.f21580a));
                a.b(this.f21584e, this.f21581b.c(), zzks.NO_ERROR);
            } catch (DynamiteModule.LoadingException e10) {
                a.b(this.f21584e, this.f21581b.c(), zzks.OPTIONAL_MODULE_NOT_AVAILABLE);
                if (!this.f21581b.c()) {
                    if (!this.f21583d) {
                        l.c(this.f21580a, "ocr");
                        this.f21583d = true;
                    }
                    throw new MlKitException("Waiting for the text optional module to be downloaded. Please wait.", 14);
                }
                throw new MlKitException(String.format("Failed to load text module %s. %s", new Object[]{this.f21581b.b(), e10.getMessage()}), 13, e10);
            } catch (RemoteException e11) {
                a.b(this.f21584e, this.f21581b.c(), zzks.OPTIONAL_MODULE_INIT_ERROR);
                throw new MlKitException("Failed to create text recognizer ".concat(String.valueOf(this.f21581b.b())), 13, e11);
            }
        }
    }

    public final void zzc() {
        zzow zzow = this.f21585f;
        if (zzow != null) {
            try {
                zzow.zzf();
            } catch (RemoteException unused) {
                "Failed to release text recognizer ".concat(String.valueOf(this.f21581b.b()));
            }
            this.f21585f = null;
        }
        this.f21582c = false;
    }
}
