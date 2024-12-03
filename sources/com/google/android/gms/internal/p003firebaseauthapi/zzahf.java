package com.google.android.gms.internal.p003firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.a;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahf  reason: invalid package */
public final class zzahf {
    private final String zza;
    @NonNull
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final zzaia zze;
    private String zzf;

    public zzahf(String str, String str2, String str3, long j10, zzaia zzaia) {
        if (TextUtils.isEmpty(str) || zzaia == null) {
            this.zza = str;
            this.zzb = p.g(str2);
            this.zzc = str3;
            this.zzd = j10;
            this.zze = zzaia;
            return;
        }
        throw new IllegalArgumentException("Cannot have both MFA phone_info and totp_info");
    }

    public static zzahf zzb(@NonNull b bVar) {
        zzaia zzaia;
        String optString = bVar.optString("phoneInfo", (String) null);
        String optString2 = bVar.optString("mfaEnrollmentId", (String) null);
        String optString3 = bVar.optString("displayName", (String) null);
        long zzh = zzh(bVar.optString("enrolledAt", ""));
        if (bVar.opt("totpInfo") != null) {
            zzaia = new zzaia();
        } else {
            zzaia = null;
        }
        zzahf zzahf = new zzahf(optString, optString2, optString3, zzh, zzaia);
        zzahf.zzf = bVar.optString("unobfuscatedPhoneInfo");
        return zzahf;
    }

    public static List zzg(a aVar) throws JSONException {
        if (aVar == null || aVar.o() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < aVar.o(); i10++) {
            arrayList.add(zzb(aVar.j(i10)));
        }
        return arrayList;
    }

    private static long zzh(String str) {
        try {
            zzamt zzb2 = zzano.zzb(str);
            zzano.zza(zzb2);
            return zzb2.zzb();
        } catch (ParseException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not parse timestamp as ISOString. Invalid ISOString \"");
            sb2.append(str);
            sb2.append("\"");
            return 0;
        }
    }

    public final long zza() {
        return this.zzd;
    }

    public final zzaia zzc() {
        return this.zze;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zza;
    }
}
