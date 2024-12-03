package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.r;
import org.json.JSONException;
import org.json.a;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahh  reason: invalid package */
public final class zzahh {
    private final List zza;

    public zzahh() {
        this.zza = new ArrayList();
    }

    public static zzahh zza(a aVar) throws JSONException {
        zzahg zzahg;
        if (aVar == null || aVar.o() == 0) {
            return new zzahh(new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < aVar.o(); i10++) {
            b j10 = aVar.j(i10);
            if (j10 == null) {
                zzahg = new zzahg();
            } else {
                zzahg = new zzahg(r.a(j10.optString("federatedId", (String) null)), r.a(j10.optString("displayName", (String) null)), r.a(j10.optString("photoUrl", (String) null)), r.a(j10.optString("providerId", (String) null)), (String) null, r.a(j10.optString("phoneNumber", (String) null)), r.a(j10.optString("email", (String) null)));
            }
            arrayList.add(zzahg);
        }
        return new zzahh(arrayList);
    }

    public static zzahh zzb(zzahh zzahh) {
        zzahh zzahh2 = new zzahh();
        List list = zzahh.zza;
        if (list != null) {
            zzahh2.zza.addAll(list);
        }
        return zzahh2;
    }

    public final List zzc() {
        return this.zza;
    }

    public zzahh(List list) {
        if (!list.isEmpty()) {
            this.zza = Collections.unmodifiableList(list);
        } else {
            this.zza = Collections.emptyList();
        }
    }
}
