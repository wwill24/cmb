package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.internal.p;
import com.mparticle.kits.ReportingMessage;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public final class a4 {

    /* renamed from: a  reason: collision with root package name */
    private final String f39631a = "default_event_parameters";

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f39632b = new Bundle();

    /* renamed from: c  reason: collision with root package name */
    private Bundle f39633c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ e4 f39634d;

    public a4(e4 e4Var, String str, Bundle bundle) {
        this.f39634d = e4Var;
        p.g("default_event_parameters");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:35|36|47) */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r11.f39634d.f40059a.d().r().a("Error reading value from SharedPreferences. Value dropped");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00a3 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009b A[Catch:{ NumberFormatException | JSONException -> 0x00a3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle a() {
        /*
            r11 = this;
            android.os.Bundle r0 = r11.f39633c
            if (r0 == 0) goto L_0x0006
            goto L_0x00d4
        L_0x0006:
            com.google.android.gms.measurement.internal.e4 r0 = r11.f39634d
            android.content.SharedPreferences r0 = r0.o()
            java.lang.String r1 = r11.f39631a
            r2 = 0
            java.lang.String r0 = r0.getString(r1, r2)
            if (r0 == 0) goto L_0x00cc
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ JSONException -> 0x00bb }
            r1.<init>()     // Catch:{ JSONException -> 0x00bb }
            org.json.a r2 = new org.json.a     // Catch:{ JSONException -> 0x00bb }
            r2.<init>((java.lang.String) r0)     // Catch:{ JSONException -> 0x00bb }
            r0 = 0
            r3 = r0
        L_0x0021:
            int r4 = r2.o()     // Catch:{ JSONException -> 0x00bb }
            if (r3 >= r4) goto L_0x00b8
            org.json.b r4 = r2.j(r3)     // Catch:{ NumberFormatException | JSONException -> 0x00a3 }
            java.lang.String r5 = "n"
            java.lang.String r5 = r4.getString(r5)     // Catch:{ NumberFormatException | JSONException -> 0x00a3 }
            java.lang.String r6 = "t"
            java.lang.String r6 = r4.getString(r6)     // Catch:{ NumberFormatException | JSONException -> 0x00a3 }
            int r7 = r6.hashCode()     // Catch:{ NumberFormatException | JSONException -> 0x00a3 }
            r8 = 100
            r9 = 2
            r10 = 1
            if (r7 == r8) goto L_0x005e
            r8 = 108(0x6c, float:1.51E-43)
            if (r7 == r8) goto L_0x0054
            r8 = 115(0x73, float:1.61E-43)
            if (r7 == r8) goto L_0x004a
            goto L_0x0068
        L_0x004a:
            java.lang.String r7 = "s"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x0068
            r7 = r0
            goto L_0x0069
        L_0x0054:
            java.lang.String r7 = "l"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x0068
            r7 = r9
            goto L_0x0069
        L_0x005e:
            java.lang.String r7 = "d"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x0068
            r7 = r10
            goto L_0x0069
        L_0x0068:
            r7 = -1
        L_0x0069:
            java.lang.String r8 = "v"
            if (r7 == 0) goto L_0x009b
            if (r7 == r10) goto L_0x008f
            if (r7 == r9) goto L_0x0083
            com.google.android.gms.measurement.internal.e4 r4 = r11.f39634d     // Catch:{ NumberFormatException | JSONException -> 0x00a3 }
            com.google.android.gms.measurement.internal.u4 r4 = r4.f40059a     // Catch:{ NumberFormatException | JSONException -> 0x00a3 }
            com.google.android.gms.measurement.internal.q3 r4 = r4.d()     // Catch:{ NumberFormatException | JSONException -> 0x00a3 }
            com.google.android.gms.measurement.internal.o3 r4 = r4.r()     // Catch:{ NumberFormatException | JSONException -> 0x00a3 }
            java.lang.String r5 = "Unrecognized persisted bundle type. Type"
            r4.b(r5, r6)     // Catch:{ NumberFormatException | JSONException -> 0x00a3 }
            goto L_0x00b4
        L_0x0083:
            java.lang.String r4 = r4.getString(r8)     // Catch:{ NumberFormatException | JSONException -> 0x00a3 }
            long r6 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException | JSONException -> 0x00a3 }
            r1.putLong(r5, r6)     // Catch:{ NumberFormatException | JSONException -> 0x00a3 }
            goto L_0x00b4
        L_0x008f:
            java.lang.String r4 = r4.getString(r8)     // Catch:{ NumberFormatException | JSONException -> 0x00a3 }
            double r6 = java.lang.Double.parseDouble(r4)     // Catch:{ NumberFormatException | JSONException -> 0x00a3 }
            r1.putDouble(r5, r6)     // Catch:{ NumberFormatException | JSONException -> 0x00a3 }
            goto L_0x00b4
        L_0x009b:
            java.lang.String r4 = r4.getString(r8)     // Catch:{ NumberFormatException | JSONException -> 0x00a3 }
            r1.putString(r5, r4)     // Catch:{ NumberFormatException | JSONException -> 0x00a3 }
            goto L_0x00b4
        L_0x00a3:
            com.google.android.gms.measurement.internal.e4 r4 = r11.f39634d     // Catch:{ JSONException -> 0x00bb }
            com.google.android.gms.measurement.internal.u4 r4 = r4.f40059a     // Catch:{ JSONException -> 0x00bb }
            com.google.android.gms.measurement.internal.q3 r4 = r4.d()     // Catch:{ JSONException -> 0x00bb }
            com.google.android.gms.measurement.internal.o3 r4 = r4.r()     // Catch:{ JSONException -> 0x00bb }
            java.lang.String r5 = "Error reading value from SharedPreferences. Value dropped"
            r4.a(r5)     // Catch:{ JSONException -> 0x00bb }
        L_0x00b4:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x00b8:
            r11.f39633c = r1     // Catch:{ JSONException -> 0x00bb }
            goto L_0x00cc
        L_0x00bb:
            com.google.android.gms.measurement.internal.e4 r0 = r11.f39634d
            com.google.android.gms.measurement.internal.u4 r0 = r0.f40059a
            com.google.android.gms.measurement.internal.q3 r0 = r0.d()
            com.google.android.gms.measurement.internal.o3 r0 = r0.r()
            java.lang.String r1 = "Error loading bundle from SharedPreferences. Values will be lost"
            r0.a(r1)
        L_0x00cc:
            android.os.Bundle r0 = r11.f39633c
            if (r0 != 0) goto L_0x00d4
            android.os.Bundle r0 = r11.f39632b
            r11.f39633c = r0
        L_0x00d4:
            android.os.Bundle r0 = r11.f39633c
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.a4.a():android.os.Bundle");
    }

    public final void b(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor edit = this.f39634d.o().edit();
        if (bundle.size() == 0) {
            edit.remove(this.f39631a);
        } else {
            String str = this.f39631a;
            a aVar = new a();
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                if (obj != null) {
                    try {
                        b bVar = new b();
                        bVar.put("n", (Object) next);
                        bVar.put(ReportingMessage.MessageType.SCREEN_VIEW, (Object) obj.toString());
                        if (obj instanceof String) {
                            bVar.put("t", (Object) "s");
                        } else if (obj instanceof Long) {
                            bVar.put("t", (Object) "l");
                        } else if (obj instanceof Double) {
                            bVar.put("t", (Object) "d");
                        } else {
                            this.f39634d.f40059a.d().r().b("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        aVar.E(bVar);
                    } catch (JSONException e10) {
                        this.f39634d.f40059a.d().r().b("Cannot serialize bundle value to SharedPreferences", e10);
                    }
                }
            }
            edit.putString(str, aVar.toString());
        }
        edit.apply();
        this.f39633c = bundle;
    }
}
