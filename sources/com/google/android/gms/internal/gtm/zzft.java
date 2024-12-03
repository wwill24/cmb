package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.Locale;

public final class zzft extends zzbs {
    protected String zza;
    protected String zzb;
    protected boolean zzc;
    protected int zzd;
    protected boolean zze;
    protected boolean zzf;

    public zzft(zzbv zzbv) {
        super(zzbv);
    }

    public final String zza() {
        zzW();
        return this.zzb;
    }

    public final String zzb() {
        zzW();
        return this.zza;
    }

    public final boolean zzc() {
        zzW();
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        ApplicationInfo applicationInfo;
        int i10;
        int i11;
        Context zzo = zzo();
        try {
            applicationInfo = zzo.getPackageManager().getApplicationInfo(zzo.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e10) {
            zzS("PackageManager doesn't know about the app package", e10);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            zzR("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && (i10 = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) > 0) {
            zzbv zzt = zzt();
            zzew zzew = (zzew) new zzcs(zzt, new zzev(zzt)).zza(i10);
            if (zzew != null) {
                zzO("Loading global XML config values");
                String str = zzew.zza;
                if (str != null) {
                    this.zzb = str;
                    zzG("XML config - app name", str);
                }
                String str2 = zzew.zzb;
                if (str2 != null) {
                    this.zza = str2;
                    zzG("XML config - app version", str2);
                }
                String str3 = zzew.zzc;
                boolean z10 = false;
                if (str3 != null) {
                    String lowerCase = str3.toLowerCase(Locale.US);
                    if ("verbose".equals(lowerCase)) {
                        i11 = 0;
                    } else if ("info".equals(lowerCase)) {
                        i11 = 1;
                    } else if ("warning".equals(lowerCase)) {
                        i11 = 2;
                    } else if ("error".equals(lowerCase)) {
                        i11 = 3;
                    } else {
                        i11 = -1;
                    }
                    if (i11 >= 0) {
                        zzP("XML config - log level", Integer.valueOf(i11));
                    }
                }
                int i12 = zzew.zzd;
                if (i12 >= 0) {
                    this.zzd = i12;
                    this.zzc = true;
                    zzG("XML config - dispatch period (sec)", Integer.valueOf(i12));
                }
                int i13 = zzew.zze;
                if (i13 != -1) {
                    if (1 == i13) {
                        z10 = true;
                    }
                    this.zzf = z10;
                    this.zze = true;
                    zzG("XML config - dry run", Boolean.valueOf(z10));
                }
            }
        }
    }

    public final boolean zze() {
        zzW();
        return this.zze;
    }

    public final boolean zzf() {
        zzW();
        return false;
    }
}
