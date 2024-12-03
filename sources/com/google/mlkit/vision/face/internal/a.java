package com.google.mlkit.vision.face.internal;

import ah.b;
import ah.c;
import ah.d;
import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Pair;
import bh.e;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_face.zzks;
import com.google.android.gms.internal.mlkit_vision_face.zzoc;
import com.google.android.gms.internal.mlkit_vision_face.zzoq;
import com.google.android.gms.internal.mlkit_vision_face.zzou;
import com.google.android.gms.internal.mlkit_vision_face.zzow;
import com.google.android.gms.internal.mlkit_vision_face.zzoy;
import com.google.android.gms.internal.mlkit_vision_face.zzpa;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.l;
import java.util.ArrayList;
import java.util.List;

final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f21537a;

    /* renamed from: b  reason: collision with root package name */
    private final e f21538b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21539c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21540d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21541e;

    /* renamed from: f  reason: collision with root package name */
    private final zzoc f21542f;

    /* renamed from: g  reason: collision with root package name */
    private zzoy f21543g;

    /* renamed from: h  reason: collision with root package name */
    private zzoy f21544h;

    a(Context context, e eVar, zzoc zzoc) {
        this.f21537a = context;
        this.f21538b = eVar;
        this.f21542f = zzoc;
    }

    static boolean b(Context context) {
        return DynamiteModule.a(context, "com.google.mlkit.dynamite.face") > 0;
    }

    private final void d() throws DynamiteModule.LoadingException, RemoteException {
        if (this.f21538b.c() == 2) {
            if (this.f21543g == null) {
                this.f21543g = e(new zzou(this.f21538b.e(), 1, 1, 2, false, this.f21538b.a()));
            }
            if ((this.f21538b.d() == 2 || this.f21538b.b() == 2 || this.f21538b.e() == 2) && this.f21544h == null) {
                this.f21544h = e(new zzou(this.f21538b.e(), this.f21538b.d(), this.f21538b.b(), 1, this.f21538b.g(), this.f21538b.a()));
            }
        } else if (this.f21544h == null) {
            this.f21544h = e(new zzou(this.f21538b.e(), this.f21538b.d(), this.f21538b.b(), 1, this.f21538b.g(), this.f21538b.a()));
        }
    }

    private final zzoy e(zzou zzou) throws DynamiteModule.LoadingException, RemoteException {
        if (this.f21540d) {
            return c(DynamiteModule.f39209c, "com.google.mlkit.dynamite.face", "com.google.mlkit.vision.face.bundled.internal.ThickFaceDetectorCreator", zzou);
        }
        return c(DynamiteModule.f39208b, "com.google.android.gms.vision.face", "com.google.android.gms.vision.face.mlkit.FaceDetectorCreator", zzou);
    }

    private static List f(zzoy zzoy, zg.a aVar) throws MlKitException {
        if (aVar.g() == -1) {
            aVar = zg.a.b(c.f().d(aVar, false), aVar.l(), aVar.h(), aVar.k(), 17);
        }
        try {
            List<zzow> zzd = zzoy.zzd(d.b().a(aVar), new zzoq(aVar.g(), aVar.l(), aVar.h(), b.a(aVar.k()), SystemClock.elapsedRealtime()));
            ArrayList arrayList = new ArrayList();
            for (zzow aVar2 : zzd) {
                arrayList.add(new bh.a(aVar2, aVar.f()));
            }
            return arrayList;
        } catch (RemoteException e10) {
            throw new MlKitException("Failed to run face detector.", 13, e10);
        }
    }

    public final Pair a(zg.a aVar) throws MlKitException {
        List list;
        if (this.f21544h == null && this.f21543g == null) {
            zzd();
        }
        if (!this.f21539c) {
            try {
                zzoy zzoy = this.f21544h;
                if (zzoy != null) {
                    zzoy.zze();
                }
                zzoy zzoy2 = this.f21543g;
                if (zzoy2 != null) {
                    zzoy2.zze();
                }
                this.f21539c = true;
            } catch (RemoteException e10) {
                throw new MlKitException("Failed to init face detector.", 13, e10);
            }
        }
        zzoy zzoy3 = this.f21544h;
        List list2 = null;
        if (zzoy3 != null) {
            list = f(zzoy3, aVar);
            if (!this.f21538b.g()) {
                g.m(list);
            }
        } else {
            list = null;
        }
        zzoy zzoy4 = this.f21543g;
        if (zzoy4 != null) {
            list2 = f(zzoy4, aVar);
            g.m(list2);
        }
        return new Pair(list, list2);
    }

    /* access modifiers changed from: package-private */
    public final zzoy c(DynamiteModule.a aVar, String str, String str2, zzou zzou) throws DynamiteModule.LoadingException, RemoteException {
        return zzpa.zza(DynamiteModule.d(this.f21537a, aVar, str).c(str2)).zzd(pe.b.g(this.f21537a), zzou);
    }

    public final void zzb() {
        try {
            zzoy zzoy = this.f21544h;
            if (zzoy != null) {
                zzoy.zzf();
                this.f21544h = null;
            }
            zzoy zzoy2 = this.f21543g;
            if (zzoy2 != null) {
                zzoy2.zzf();
                this.f21543g = null;
            }
        } catch (RemoteException unused) {
        }
        this.f21539c = false;
    }

    public final boolean zzd() throws MlKitException {
        if (this.f21544h != null || this.f21543g != null) {
            return this.f21540d;
        }
        if (DynamiteModule.a(this.f21537a, "com.google.mlkit.dynamite.face") > 0) {
            this.f21540d = true;
            try {
                d();
            } catch (DynamiteModule.LoadingException e10) {
                throw new MlKitException("Failed to load the bundled face module.", 13, e10);
            } catch (RemoteException e11) {
                throw new MlKitException("Failed to create thick face detector.", 13, e11);
            }
        } else {
            this.f21540d = false;
            try {
                d();
            } catch (DynamiteModule.LoadingException e12) {
                if (!this.f21541e) {
                    l.c(this.f21537a, "face");
                    this.f21541e = true;
                }
                h.c(this.f21542f, this.f21540d, zzks.OPTIONAL_MODULE_NOT_AVAILABLE);
                throw new MlKitException("Waiting for the face module to be downloaded. Please wait.", 14, e12);
            } catch (RemoteException e13) {
                h.c(this.f21542f, this.f21540d, zzks.OPTIONAL_MODULE_INIT_ERROR);
                throw new MlKitException("Failed to create thin face detector.", 13, e13);
            }
        }
        h.c(this.f21542f, this.f21540d, zzks.NO_ERROR);
        return this.f21540d;
    }
}
