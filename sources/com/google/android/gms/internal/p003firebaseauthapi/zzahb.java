package com.google.android.gms.internal.p003firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.facebook.AccessToken;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import me.i;
import me.r;
import org.json.JSONException;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahb  reason: invalid package */
public final class zzahb extends AbstractSafeParcelable implements zzaek<zzahb> {
    public static final Parcelable.Creator<zzahb> CREATOR = new zzahc();
    private static final String zza = zzahb.class.getSimpleName();
    private String zzb;
    private String zzc;
    private Long zzd;
    private String zze;
    private Long zzf;

    public zzahb() {
        this.zzf = Long.valueOf(System.currentTimeMillis());
    }

    public static zzahb zzd(String str) {
        try {
            b bVar = new b(str);
            zzahb zzahb = new zzahb();
            zzahb.zzb = bVar.optString("refresh_token", (String) null);
            zzahb.zzc = bVar.optString("access_token", (String) null);
            zzahb.zzd = Long.valueOf(bVar.optLong(AccessToken.EXPIRES_IN_KEY));
            zzahb.zze = bVar.optString("token_type", (String) null);
            zzahb.zzf = Long.valueOf(bVar.optLong("issued_at"));
            return zzahb;
        } catch (JSONException e10) {
            throw new zzzr(e10);
        }
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 2, this.zzb, false);
        a.C(parcel, 3, this.zzc, false);
        a.x(parcel, 4, Long.valueOf(zzb()), false);
        a.C(parcel, 5, this.zze, false);
        a.x(parcel, 6, Long.valueOf(this.zzf.longValue()), false);
        a.b(parcel, a10);
    }

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        try {
            b bVar = new b(str);
            this.zzb = r.a(bVar.optString("refresh_token"));
            this.zzc = r.a(bVar.optString("access_token"));
            this.zzd = Long.valueOf(bVar.optLong(AccessToken.EXPIRES_IN_KEY, 0));
            this.zze = r.a(bVar.optString("token_type"));
            this.zzf = Long.valueOf(System.currentTimeMillis());
            return this;
        } catch (NullPointerException | JSONException e10) {
            throw zzain.zza(e10, zza, str);
        }
    }

    public final long zzb() {
        Long l10 = this.zzd;
        if (l10 == null) {
            return 0;
        }
        return l10.longValue();
    }

    public final long zzc() {
        return this.zzf.longValue();
    }

    public final String zze() {
        return this.zzc;
    }

    public final String zzf() {
        return this.zzb;
    }

    public final String zzg() {
        return this.zze;
    }

    public final String zzh() {
        b bVar = new b();
        try {
            bVar.put("refresh_token", (Object) this.zzb);
            bVar.put("access_token", (Object) this.zzc);
            bVar.put(AccessToken.EXPIRES_IN_KEY, (Object) this.zzd);
            bVar.put("token_type", (Object) this.zze);
            bVar.put("issued_at", (Object) this.zzf);
            return bVar.toString();
        } catch (JSONException e10) {
            throw new zzzr(e10);
        }
    }

    public final void zzi(String str) {
        this.zzb = p.g(str);
    }

    public final boolean zzj() {
        if (i.c().currentTimeMillis() + 300000 < this.zzf.longValue() + (this.zzd.longValue() * 1000)) {
            return true;
        }
        return false;
    }

    public zzahb(String str, String str2, Long l10, String str3) {
        this(str, str2, l10, str3, Long.valueOf(System.currentTimeMillis()));
    }

    zzahb(String str, String str2, Long l10, String str3, Long l11) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = l10;
        this.zze = str3;
        this.zzf = l11;
    }
}
