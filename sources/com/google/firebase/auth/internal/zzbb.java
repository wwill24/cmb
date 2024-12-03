package com.google.firebase.auth.internal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzab;
import com.google.android.gms.internal.p003firebaseauthapi.zzj;
import com.google.android.gms.internal.p003firebaseauthapi.zzzr;
import he.a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.c;
import org.json.JSONException;
import org.json.b;

final class zzbb {
    private static final a zza = new a("JSONParser", new String[0]);

    static List zza(org.json.a aVar) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < aVar.o(); i10++) {
            Object obj = aVar.get(i10);
            if (obj instanceof org.json.a) {
                obj = zza((org.json.a) obj);
            } else if (obj instanceof b) {
                obj = zzd((b) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    @NonNull
    public static Map zzb(String str) {
        p.g(str);
        List zzd = zzab.zzb(zzj.zzb('.')).zzd(str);
        if (zzd.size() < 2) {
            zza.c("Invalid idToken ".concat(String.valueOf(str)), new Object[0]);
            return new HashMap();
        }
        try {
            Map zzc = zzc(new String(c.b((String) zzd.get(1)), "UTF-8"));
            if (zzc == null) {
                return new HashMap();
            }
            return zzc;
        } catch (UnsupportedEncodingException e10) {
            zza.b("Unable to decode token", e10, new Object[0]);
            return new HashMap();
        }
    }

    public static Map zzc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            b bVar = new b(str);
            if (bVar != b.NULL) {
                return zzd(bVar);
            }
            return null;
        } catch (Exception e10) {
            throw new zzzr(e10);
        }
    }

    static Map zzd(b bVar) throws JSONException {
        androidx.collection.a aVar = new androidx.collection.a();
        Iterator<String> keys = bVar.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = bVar.get(next);
            if (obj instanceof org.json.a) {
                obj = zza((org.json.a) obj);
            } else if (obj instanceof b) {
                obj = zzd((b) obj);
            }
            aVar.put(next, obj);
        }
        return aVar;
    }
}
