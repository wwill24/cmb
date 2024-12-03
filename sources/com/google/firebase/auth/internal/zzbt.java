package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzahb;
import com.google.android.gms.internal.p003firebaseauthapi.zzzr;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import he.a;
import java.util.List;
import org.json.b;

public final class zzbt {
    private final Context zza;
    private final String zzb;
    private final SharedPreferences zzc;
    private final a zzd = new a("StorageHelpers", new String[0]);

    public zzbt(Context context, String str) {
        p.k(context);
        String g10 = p.g(str);
        this.zzb = g10;
        Context applicationContext = context.getApplicationContext();
        this.zza = applicationContext;
        this.zzc = applicationContext.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", new Object[]{g10}), 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r15v6, types: [com.google.firebase.auth.TotpMultiFactorInfo] */
    /* JADX WARNING: type inference failed for: r15v7, types: [com.google.firebase.auth.PhoneMultiFactorInfo] */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0177, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c9 A[SYNTHETIC, Splitter:B:36:0x00c9] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0177 A[ExcHandler: zzzr | ArrayIndexOutOfBoundsException | IllegalArgumentException (e java.lang.Throwable), Splitter:B:1:0x0009] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.firebase.auth.internal.zzx zzf(org.json.b r27) {
        /*
            r26 = this;
            r0 = r27
            java.lang.String r1 = "userMultiFactorInfo"
            java.lang.String r2 = "userMetadata"
            r3 = 0
            java.lang.String r4 = "cachedTokenState"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r5 = "applicationName"
            java.lang.String r5 = r0.getString(r5)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r6 = "anonymous"
            boolean r6 = r0.getBoolean(r6)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r7 = "2"
            java.lang.String r8 = "version"
            java.lang.String r8 = r0.getString(r8)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            if (r8 == 0) goto L_0x0024
            r7 = r8
        L_0x0024:
            java.lang.String r8 = "userInfos"
            org.json.a r8 = r0.getJSONArray(r8)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            int r9 = r8.o()     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            if (r9 != 0) goto L_0x0031
            return r3
        L_0x0031:
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            r10.<init>(r9)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            r12 = 0
        L_0x0037:
            java.lang.String r13 = "phoneNumber"
            java.lang.String r14 = "displayName"
            if (r12 >= r9) goto L_0x0088
            java.lang.String r15 = r8.n(r12)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzt> r16 = com.google.firebase.auth.internal.zzt.CREATOR     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            org.json.b r11 = new org.json.b     // Catch:{ JSONException -> 0x0081, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            r11.<init>((java.lang.String) r15)     // Catch:{ JSONException -> 0x0081, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r15 = "userId"
            java.lang.String r18 = r11.optString(r15)     // Catch:{ JSONException -> 0x0081, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r15 = "providerId"
            java.lang.String r19 = r11.optString(r15)     // Catch:{ JSONException -> 0x0081, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r15 = "email"
            java.lang.String r20 = r11.optString(r15)     // Catch:{ JSONException -> 0x0081, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r21 = r11.optString(r13)     // Catch:{ JSONException -> 0x0081, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r22 = r11.optString(r14)     // Catch:{ JSONException -> 0x0081, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r13 = "photoUrl"
            java.lang.String r23 = r11.optString(r13)     // Catch:{ JSONException -> 0x0081, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r13 = "isEmailVerified"
            boolean r24 = r11.optBoolean(r13)     // Catch:{ JSONException -> 0x0081, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r13 = "rawUserInfo"
            java.lang.String r25 = r11.optString(r13)     // Catch:{ JSONException -> 0x0081, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            com.google.firebase.auth.internal.zzt r11 = new com.google.firebase.auth.internal.zzt     // Catch:{ JSONException -> 0x0081, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            r17 = r11
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ JSONException -> 0x0081, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            r10.add(r11)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            int r12 = r12 + 1
            goto L_0x0037
        L_0x0081:
            r0 = move-exception
            com.google.android.gms.internal.firebase-auth-api.zzzr r1 = new com.google.android.gms.internal.firebase-auth-api.zzzr     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            throw r1     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
        L_0x0088:
            com.google.firebase.FirebaseApp r5 = com.google.firebase.FirebaseApp.getInstance(r5)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            com.google.firebase.auth.internal.zzx r8 = new com.google.firebase.auth.internal.zzx     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            r8.<init>(r5, r10)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            if (r5 != 0) goto L_0x009e
            com.google.android.gms.internal.firebase-auth-api.zzahb r4 = com.google.android.gms.internal.p003firebaseauthapi.zzahb.zzd(r4)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            r8.zzh(r4)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
        L_0x009e:
            if (r6 != 0) goto L_0x00a3
            r8.zzm()     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
        L_0x00a3:
            r8.zzl(r7)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            boolean r4 = r0.has(r2)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            if (r4 == 0) goto L_0x00cc
            org.json.b r2 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzz> r4 = com.google.firebase.auth.internal.zzz.CREATOR     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            if (r2 != 0) goto L_0x00b6
        L_0x00b4:
            r2 = r3
            goto L_0x00c7
        L_0x00b6:
            java.lang.String r4 = "lastSignInTimestamp"
            long r4 = r2.getLong(r4)     // Catch:{ JSONException -> 0x00b4, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r6 = "creationTimestamp"
            long r6 = r2.getLong(r6)     // Catch:{ JSONException -> 0x00b4, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            com.google.firebase.auth.internal.zzz r2 = new com.google.firebase.auth.internal.zzz     // Catch:{ JSONException -> 0x00b4, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            r2.<init>(r4, r6)     // Catch:{ JSONException -> 0x00b4, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
        L_0x00c7:
            if (r2 == 0) goto L_0x00cc
            r8.zzr(r2)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
        L_0x00cc:
            boolean r2 = r0.has(r1)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            if (r2 == 0) goto L_0x0176
            org.json.a r0 = r0.getJSONArray(r1)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            if (r0 == 0) goto L_0x0176
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            r1.<init>()     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            r11 = 0
        L_0x00de:
            int r2 = r0.o()     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            if (r11 >= r2) goto L_0x0173
            java.lang.String r2 = r0.n(r11)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            org.json.b r4 = new org.json.b     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            r4.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r2 = "factorIdKey"
            java.lang.String r2 = r4.optString(r2)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r5 = "phone"
            boolean r5 = r5.equals(r2)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r6 = "uid"
            java.lang.String r7 = "enrollmentTimestamp"
            if (r5 == 0) goto L_0x0126
            android.os.Parcelable$Creator<com.google.firebase.auth.PhoneMultiFactorInfo> r2 = com.google.firebase.auth.PhoneMultiFactorInfo.CREATOR     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            boolean r2 = r4.has(r7)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            if (r2 == 0) goto L_0x011e
            java.lang.String r16 = r4.optString(r6)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r17 = r4.optString(r14)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            long r18 = r4.optLong(r7)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r20 = r4.optString(r13)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            com.google.firebase.auth.PhoneMultiFactorInfo r2 = new com.google.firebase.auth.PhoneMultiFactorInfo     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            r15 = r2
            r15.<init>(r16, r17, r18, r20)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            goto L_0x015c
        L_0x011e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r1 = "An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance."
            r0.<init>(r1)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            throw r0     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
        L_0x0126:
            java.lang.String r5 = "totp"
            if (r2 == r5) goto L_0x0135
            if (r2 == 0) goto L_0x0133
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            if (r2 == 0) goto L_0x0133
            goto L_0x0135
        L_0x0133:
            r2 = r3
            goto L_0x015c
        L_0x0135:
            android.os.Parcelable$Creator<com.google.firebase.auth.TotpMultiFactorInfo> r2 = com.google.firebase.auth.TotpMultiFactorInfo.CREATOR     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            boolean r2 = r4.has(r7)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            if (r2 == 0) goto L_0x016b
            long r18 = r4.optLong(r7)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r2 = "totpInfo"
            java.lang.Object r2 = r4.opt(r2)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            if (r2 == 0) goto L_0x0163
            com.google.android.gms.internal.firebase-auth-api.zzaia r20 = new com.google.android.gms.internal.firebase-auth-api.zzaia     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            r20.<init>()     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r16 = r4.optString(r6)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r17 = r4.optString(r14)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            com.google.firebase.auth.TotpMultiFactorInfo r2 = new com.google.firebase.auth.TotpMultiFactorInfo     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            r15 = r2
            r15.<init>(r16, r17, r18, r20)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
        L_0x015c:
            r1.add(r2)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            int r11 = r11 + 1
            goto L_0x00de
        L_0x0163:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r1 = "A totpInfo is required to build a TotpMultiFactorInfo instance."
            r0.<init>(r1)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            throw r0     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
        L_0x016b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            java.lang.String r1 = "An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a TotpMultiFactorInfo instance."
            r0.<init>(r1)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
            throw r0     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
        L_0x0173:
            r8.zzi(r1)     // Catch:{ JSONException -> 0x017d, ArrayIndexOutOfBoundsException -> 0x017b, IllegalArgumentException -> 0x0179, zzzr -> 0x0177 }
        L_0x0176:
            return r8
        L_0x0177:
            r0 = move-exception
            goto L_0x017e
        L_0x0179:
            r0 = move-exception
            goto L_0x017e
        L_0x017b:
            r0 = move-exception
            goto L_0x017e
        L_0x017d:
            r0 = move-exception
        L_0x017e:
            r1 = r26
            he.a r2 = r1.zzd
            r2.j(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzbt.zzf(org.json.b):com.google.firebase.auth.internal.zzx");
    }

    public final FirebaseUser zza() {
        String string = this.zzc.getString("com.google.firebase.auth.FIREBASE_USER", (String) null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            b bVar = new b(string);
            if (bVar.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(bVar.optString("type"))) {
                return zzf(bVar);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final zzahb zzb(FirebaseUser firebaseUser) {
        p.k(firebaseUser);
        String string = this.zzc.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), (String) null);
        if (string != null) {
            return zzahb.zzd(string);
        }
        return null;
    }

    public final void zzc(String str) {
        this.zzc.edit().remove(str).apply();
    }

    public final void zzd(FirebaseUser firebaseUser) {
        String str;
        p.k(firebaseUser);
        b bVar = new b();
        if (zzx.class.isAssignableFrom(firebaseUser.getClass())) {
            zzx zzx = (zzx) firebaseUser;
            try {
                bVar.put("cachedTokenState", (Object) zzx.zzf());
                bVar.put("applicationName", (Object) zzx.zza().getName());
                bVar.put("type", (Object) "com.google.firebase.auth.internal.DefaultFirebaseUser");
                if (zzx.zzo() != null) {
                    org.json.a aVar = new org.json.a();
                    List<zzt> zzo = zzx.zzo();
                    int size = zzo.size();
                    if (zzo.size() > 30) {
                        this.zzd.h("Provider user info list size larger than max size, truncating list to %d. Actual list size: %d", 30, Integer.valueOf(zzo.size()));
                        size = 30;
                    }
                    boolean z10 = false;
                    for (int i10 = 0; i10 < size; i10++) {
                        zzt zzt = (zzt) zzo.get(i10);
                        z10 |= zzt.getProviderId().equals("firebase");
                        if (i10 == size - 1 && !z10) {
                            break;
                        }
                        aVar.E(zzt.zzb());
                    }
                    if (!z10) {
                        int i11 = size - 1;
                        while (true) {
                            if (i11 >= zzo.size() || i11 < 0) {
                                this.zzd.h("Malformed user object! No Firebase Auth provider id found. Provider user info list size: %d, trimmed size: %d", Integer.valueOf(zzo.size()), Integer.valueOf(size));
                            } else {
                                zzt zzt2 = (zzt) zzo.get(i11);
                                if (zzt2.getProviderId().equals("firebase")) {
                                    aVar.E(zzt2.zzb());
                                    break;
                                }
                                if (i11 == zzo.size() - 1) {
                                    aVar.E(zzt2.zzb());
                                }
                                i11++;
                            }
                        }
                        this.zzd.h("Malformed user object! No Firebase Auth provider id found. Provider user info list size: %d, trimmed size: %d", Integer.valueOf(zzo.size()), Integer.valueOf(size));
                        if (zzo.size() < 5) {
                            StringBuilder sb2 = new StringBuilder("Provider user info list:\n");
                            for (zzt providerId : zzo) {
                                sb2.append(String.format("Provider - %s\n", new Object[]{providerId.getProviderId()}));
                            }
                            this.zzd.h(sb2.toString(), new Object[0]);
                        }
                    }
                    bVar.put("userInfos", (Object) aVar);
                }
                bVar.put("anonymous", zzx.isAnonymous());
                bVar.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, (Object) "2");
                if (zzx.getMetadata() != null) {
                    bVar.put("userMetadata", (Object) ((zzz) zzx.getMetadata()).zza());
                }
                List<MultiFactorInfo> enrolledFactors = new zzac(zzx).getEnrolledFactors();
                if (!enrolledFactors.isEmpty()) {
                    org.json.a aVar2 = new org.json.a();
                    for (int i12 = 0; i12 < enrolledFactors.size(); i12++) {
                        aVar2.E(enrolledFactors.get(i12).toJson());
                    }
                    bVar.put("userMultiFactorInfo", (Object) aVar2);
                }
                str = bVar.toString();
            } catch (Exception e10) {
                this.zzd.i("Failed to turn object into JSON", e10, new Object[0]);
                throw new zzzr(e10);
            }
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            this.zzc.edit().putString("com.google.firebase.auth.FIREBASE_USER", str).apply();
        }
    }

    public final void zze(FirebaseUser firebaseUser, zzahb zzahb) {
        p.k(firebaseUser);
        p.k(zzahb);
        this.zzc.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), zzahb.zzh()).apply();
    }
}
