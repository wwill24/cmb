package v4;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.inapp.CTInAppNotification;
import com.clevertap.android.sdk.inbox.CTInboxMessage;
import com.clevertap.android.sdk.l;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.b;

public class a {
    public static b a(Bundle bundle) throws JSONException {
        b bVar = new b();
        String string = bundle.getString("wzrk_adunit");
        p.o("Received Display Unit via push payload: " + string);
        org.json.a aVar = new org.json.a();
        bVar.put("adUnit_notifs", (Object) aVar);
        aVar.E(new b(string));
        return bVar;
    }

    public static b b(l lVar, Location location, boolean z10, boolean z11) throws JSONException {
        b bVar = new b();
        bVar.put("Build", (Object) lVar.q() + "");
        bVar.put("Version", (Object) lVar.N());
        bVar.put("OS Version", (Object) lVar.K());
        bVar.put("SDK Version", lVar.L());
        if (location != null) {
            bVar.put("Latitude", location.getLatitude());
            bVar.put("Longitude", location.getLongitude());
        }
        if (lVar.C() != null) {
            String str = "GoogleAdID";
            if (z11) {
                str = "mt_" + str;
            }
            bVar.put(str, (Object) lVar.C());
            bVar.put("GoogleAdIDLimit", lVar.S());
        }
        try {
            bVar.put("Make", (Object) lVar.F());
            bVar.put("Model", (Object) lVar.G());
            bVar.put("Carrier", (Object) lVar.r());
            bVar.put("useIP", z10);
            bVar.put("OS", (Object) lVar.J());
            bVar.put("wdt", lVar.O());
            bVar.put("hgt", lVar.D());
            bVar.put("dpi", lVar.v());
            bVar.put("dt", l.z(lVar.t()));
            if (Build.VERSION.SDK_INT >= 28) {
                bVar.put("abckt", (Object) lVar.m());
            }
            if (lVar.E() != null) {
                bVar.put("lib", (Object) lVar.E());
            }
            if (q.h(lVar.t()).o()) {
                bVar.put("sslpin", true);
            }
            if (!TextUtils.isEmpty(q.h(lVar.t()).g())) {
                bVar.put("fcmsid", true);
            }
            String u10 = lVar.u();
            if (u10 != null && !u10.equals("")) {
                bVar.put("cc", (Object) u10);
            }
            if (z10) {
                Boolean T = lVar.T();
                if (T != null) {
                    bVar.put("wifi", (Object) T);
                }
                Boolean Q = lVar.Q();
                if (Q != null) {
                    bVar.put("BluetoothEnabled", (Object) Q);
                }
                String p10 = lVar.p();
                if (p10 != null) {
                    bVar.put("BluetoothVersion", (Object) p10);
                }
                String H = lVar.H();
                if (H != null) {
                    bVar.put("Radio", (Object) H);
                }
            }
        } catch (Throwable unused) {
        }
        return bVar;
    }

    public static b c(w4.b bVar) {
        b bVar2 = new b();
        try {
            bVar2.put("c", bVar.a());
            bVar2.put("d", (Object) bVar.b());
        } catch (JSONException unused) {
        }
        return bVar2;
    }

    public static org.json.a d(DBAdapter dBAdapter) {
        String[] A = dBAdapter.A();
        org.json.a aVar = new org.json.a();
        for (String str : A) {
            p.o("RTL IDs -" + str);
            aVar.E(str);
        }
        return aVar;
    }

    public static b e(Bundle bundle) throws JSONException {
        b bVar = new b();
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if (obj instanceof Bundle) {
                b e10 = e((Bundle) obj);
                Iterator<String> keys = e10.keys();
                while (keys.hasNext()) {
                    String next2 = keys.next();
                    bVar.put(next2, e10.get(next2));
                }
            } else if (next.startsWith("wzrk_")) {
                bVar.put(next, bundle.get(next));
            }
        }
        return bVar;
    }

    public static b f(CTInAppNotification cTInAppNotification) throws JSONException {
        b bVar = new b();
        b s10 = cTInAppNotification.s();
        Iterator<String> keys = s10.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.startsWith("wzrk_")) {
                bVar.put(next, s10.get(next));
            }
        }
        return bVar;
    }

    public static b g(CTInboxMessage cTInboxMessage) {
        return cTInboxMessage.j();
    }

    public static <T> Object[] h(@NonNull org.json.a aVar) {
        Object[] objArr = new Object[aVar.o()];
        int i10 = 0;
        while (i10 < aVar.o()) {
            try {
                objArr[i10] = aVar.get(i10);
                i10++;
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return objArr;
    }

    public static org.json.a i(@NonNull List<?> list) {
        org.json.a aVar = new org.json.a();
        for (Object next : list) {
            if (next != null) {
                aVar.E(next);
            }
        }
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.b j(java.lang.String r2, com.clevertap.android.sdk.p r3, java.lang.String r4) {
        /*
            if (r2 == 0) goto L_0x0021
            org.json.b r0 = new org.json.b     // Catch:{ all -> 0x0008 }
            r0.<init>((java.lang.String) r2)     // Catch:{ all -> 0x0008 }
            goto L_0x0022
        L_0x0008:
            r2 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error reading guid cache: "
            r0.append(r1)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            r3.t(r4, r2)
        L_0x0021:
            r0 = 0
        L_0x0022:
            if (r0 == 0) goto L_0x0025
            goto L_0x002a
        L_0x0025:
            org.json.b r0 = new org.json.b
            r0.<init>()
        L_0x002a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.a.j(java.lang.String, com.clevertap.android.sdk.p, java.lang.String):org.json.b");
    }

    public static String k(Object obj) {
        try {
            return obj.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static ArrayList<?> l(@NonNull org.json.a aVar) {
        ArrayList<?> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < aVar.o(); i10++) {
            try {
                arrayList.add(aVar.get(i10));
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return arrayList;
    }
}
