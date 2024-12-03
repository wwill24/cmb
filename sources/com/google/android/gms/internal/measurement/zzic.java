package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.a;
import java.util.Iterator;
import java.util.Map;

public final class zzic implements zzhk {
    private static final Map zza = new a();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    static zzic zza(Context context, String str, Runnable runnable) {
        zzic zzic;
        if (!zzhb.zzb()) {
            synchronized (zzic.class) {
                zzic = (zzic) zza.get((Object) null);
                if (zzic == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        throw null;
                    } catch (Throwable th2) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th2;
                    }
                }
            }
            return zzic;
        }
        throw null;
    }

    static synchronized void zzc() {
        synchronized (zzic.class) {
            Map map = zza;
            Iterator it = map.values().iterator();
            if (!it.hasNext()) {
                map.clear();
            } else {
                SharedPreferences sharedPreferences = ((zzic) it.next()).zzb;
                throw null;
            }
        }
    }

    public final Object zzb(String str) {
        throw null;
    }
}
