package com.google.android.gms.internal.p003firebaseauthapi;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.a;
import org.json.b;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzain  reason: invalid package */
public final class zzain {
    @NonNull
    public static zzaca zza(@NonNull Exception exc, @NonNull String str, @NonNull String str2) {
        String message = exc.getMessage();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to parse ");
        sb2.append(str);
        sb2.append(" for string [");
        sb2.append(str2);
        sb2.append("] with exception: ");
        sb2.append(message);
        return new zzaca("Failed to parse " + str + " for string [" + str2 + "]", exc);
    }

    @NonNull
    public static List zzb(a aVar) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (!(aVar == null || aVar.o() == 0)) {
            for (int i10 = 0; i10 < aVar.o(); i10++) {
                arrayList.add(aVar.n(i10));
            }
        }
        return arrayList;
    }

    public static void zzc(b bVar) throws JSONException {
        bVar.put("clientType", (Object) "CLIENT_TYPE_ANDROID");
    }

    public static void zzd(b bVar, String str, String str2) throws JSONException {
        bVar.put(str, (Object) str2);
        bVar.put("recaptchaVersion", (Object) "RECAPTCHA_ENTERPRISE");
        bVar.put("clientType", (Object) "CLIENT_TYPE_ANDROID");
    }
}
