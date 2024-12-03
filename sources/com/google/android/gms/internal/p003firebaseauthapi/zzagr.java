package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.List;
import me.r;
import org.json.JSONException;
import org.json.a;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagr  reason: invalid package */
public final class zzagr implements zzaek {
    private static final String zza = "zzagr";
    private zzagt zzb;

    public final /* bridge */ /* synthetic */ zzaek zza(String str) throws zzaca {
        zzagt zzagt;
        int i10;
        zzags zzags;
        String str2 = str;
        try {
            b bVar = new b(str2);
            if (!bVar.has("users")) {
                this.zzb = new zzagt();
            } else {
                a optJSONArray = bVar.optJSONArray("users");
                if (optJSONArray != null) {
                    if (optJSONArray.o() != 0) {
                        ArrayList arrayList = new ArrayList(optJSONArray.o());
                        boolean z10 = false;
                        int i11 = 0;
                        while (i11 < optJSONArray.o()) {
                            b j10 = optJSONArray.j(i11);
                            if (j10 == null) {
                                zzags = new zzags();
                                i10 = i11;
                            } else {
                                i10 = i11;
                                zzags = new zzags(r.a(j10.optString("localId", (String) null)), r.a(j10.optString("email", (String) null)), j10.optBoolean("emailVerified", z10), r.a(j10.optString("displayName", (String) null)), r.a(j10.optString("photoUrl", (String) null)), zzahh.zza(j10.optJSONArray("providerUserInfo")), r.a(j10.optString("rawPassword", (String) null)), r.a(j10.optString("phoneNumber", (String) null)), j10.optLong("createdAt", 0), j10.optLong("lastLoginAt", 0), false, (zze) null, zzahf.zzg(j10.optJSONArray("mfaInfo")));
                            }
                            arrayList.add(zzags);
                            i11 = i10 + 1;
                            z10 = false;
                        }
                        zzagt = new zzagt(arrayList);
                        this.zzb = zzagt;
                    }
                }
                zzagt = new zzagt(new ArrayList());
                this.zzb = zzagt;
            }
            return this;
        } catch (NullPointerException | JSONException e10) {
            throw zzain.zza(e10, zza, str2);
        }
    }

    public final List zzb() {
        return this.zzb.zza();
    }
}
