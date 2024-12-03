package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.core.content.g;

final class zzhn implements zzhk {
    private static zzhn zza;
    private final Context zzb;
    private final ContentObserver zzc;

    private zzhn() {
        this.zzb = null;
        this.zzc = null;
    }

    private zzhn(Context context) {
        this.zzb = context;
        zzhm zzhm = new zzhm(this, (Handler) null);
        this.zzc = zzhm;
        context.getContentResolver().registerContentObserver(zzha.zza, true, zzhm);
    }

    static zzhn zza(Context context) {
        zzhn zzhn;
        zzhn zzhn2;
        synchronized (zzhn.class) {
            if (zza == null) {
                if (g.b(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                    zzhn2 = new zzhn(context);
                } else {
                    zzhn2 = new zzhn();
                }
                zza = zzhn2;
            }
            zzhn = zza;
        }
        return zzhn;
    }

    static synchronized void zze() {
        Context context;
        synchronized (zzhn.class) {
            zzhn zzhn = zza;
            if (!(zzhn == null || (context = zzhn.zzb) == null || zzhn.zzc == null)) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    /* renamed from: zzc */
    public final String zzb(String str) {
        Context context = this.zzb;
        if (context != null && !zzhb.zza(context)) {
            try {
                return (String) zzhi.zza(new zzhl(this, str));
            } catch (IllegalStateException | NullPointerException | SecurityException unused) {
                "Unable to read GServices for: ".concat(String.valueOf(str));
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzd(String str) {
        return zzha.zza(this.zzb.getContentResolver(), str, (String) null);
    }
}
