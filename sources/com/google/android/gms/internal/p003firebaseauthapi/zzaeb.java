package com.google.android.gms.internal.p003firebaseauthapi;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.p;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzai;
import he.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaeb  reason: invalid package */
public final class zzaeb extends AsyncTask {
    private static final a zza = new a("FirebaseAuth", "GetAuthDomainTask");
    private final String zzb;
    private final String zzc;
    private final WeakReference zzd;
    private final Uri.Builder zze;
    private final String zzf;
    private final FirebaseApp zzg;

    public zzaeb(String str, String str2, Intent intent, FirebaseApp firebaseApp, zzaed zzaed) {
        this.zzb = p.g(str);
        this.zzg = (FirebaseApp) p.k(firebaseApp);
        p.g(str2);
        p.k(intent);
        String g10 = p.g(intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY"));
        Uri.Builder buildUpon = Uri.parse(zzaed.zzc(g10)).buildUpon();
        buildUpon.appendPath("getProjectConfig").appendQueryParameter(SDKConstants.PARAM_KEY, g10).appendQueryParameter("androidPackageName", str).appendQueryParameter("sha1Cert", (String) p.k(str2));
        this.zzc = buildUpon.build().toString();
        this.zzd = new WeakReference(zzaed);
        this.zze = zzaed.zzb(intent, str, str2);
        this.zzf = intent.getStringExtra("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN");
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final void onPostExecute(zzaea zzaea) {
        String str;
        Uri.Builder builder;
        zzaed zzaed = (zzaed) this.zzd.get();
        String str2 = null;
        if (zzaea != null) {
            str2 = zzaea.zzc();
            str = zzaea.zzd();
        } else {
            str = null;
        }
        if (zzaed == null) {
            zza.c("An error has occurred: the handler reference has returned null.", new Object[0]);
        } else if (TextUtils.isEmpty(str2) || (builder = this.zze) == null) {
            zzaed.zze(this.zzb, zzai.zza(str));
        } else {
            builder.authority(str2);
            zzaed.zzf(this.zze.build(), this.zzb, FirebaseAuth.getInstance(this.zzg).zzE());
        }
    }

    private static byte[] zzb(InputStream inputStream, int i10) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            byteArrayOutputStream.close();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00fa, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00fb, code lost:
        zza.c("ConversionException encountered: ".concat(java.lang.String.valueOf(r1.getMessage())), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0111, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0112, code lost:
        zza.c("Null pointer encountered: ".concat(java.lang.String.valueOf(r1.getMessage())), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0128, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0129, code lost:
        zza.c("IOException occurred: ".concat(java.lang.String.valueOf(r1.getMessage())), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0077 A[Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00fa A[ExcHandler: zzaca (r1v8 'e' com.google.android.gms.internal.firebase-auth-api.zzaca A[CUSTOM_DECLARE]), Splitter:B:4:0x0014] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0111 A[ExcHandler: NullPointerException (r1v4 'e' java.lang.NullPointerException A[CUSTOM_DECLARE]), Splitter:B:4:0x0014] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object doInBackground(java.lang.Object[] r8) {
        /*
            r7 = this;
            java.lang.Void[] r8 = (java.lang.Void[]) r8
            java.lang.String r8 = r7.zzf
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            r0 = 0
            if (r8 != 0) goto L_0x0013
            java.lang.String r8 = r7.zzf
            com.google.android.gms.internal.firebase-auth-api.zzaea r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaea.zza(r8)
            goto L_0x013e
        L_0x0013:
            r8 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.String r2 = r7.zzc     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.ref.WeakReference r2 = r7.zzd     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.Object r2 = r2.get()     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            com.google.android.gms.internal.firebase-auth-api.zzaed r2 = (com.google.android.gms.internal.p003firebaseauthapi.zzaed) r2     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.net.HttpURLConnection r1 = r2.zzd(r1)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/json; charset=UTF-8"
            r1.addRequestProperty(r3, r4)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            r3 = 60000(0xea60, float:8.4078E-41)
            r1.setConnectTimeout(r3)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            com.google.android.gms.internal.firebase-auth-api.zzaen r3 = new com.google.android.gms.internal.firebase-auth-api.zzaen     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            android.content.Context r2 = r2.zza()     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            com.google.firebase.FirebaseApp r4 = r7.zzg     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            com.google.android.gms.internal.firebase-auth-api.zzael r5 = com.google.android.gms.internal.p003firebaseauthapi.zzael.zza()     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.String r5 = r5.zzb()     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            r3.<init>(r2, r4, r5)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            r3.zza(r1)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            int r2 = r1.getResponseCode()     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 128(0x80, float:1.794E-43)
            if (r2 != r3) goto L_0x0093
            com.google.android.gms.internal.firebase-auth-api.zzagy r2 = new com.google.android.gms.internal.firebase-auth-api.zzagy     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            r2.<init>()     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            byte[] r1 = zzb(r1, r4)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            r2.zzb(r3)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.util.List r1 = r2.zzc()     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
        L_0x0071:
            boolean r2 = r1.hasNext()     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            if (r2 == 0) goto L_0x013e
            java.lang.Object r2 = r1.next()     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.String r3 = "firebaseapp.com"
            boolean r3 = r2.endsWith(r3)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            if (r3 != 0) goto L_0x008d
            java.lang.String r3 = "web.app"
            boolean r3 = r2.endsWith(r3)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            if (r3 == 0) goto L_0x0071
        L_0x008d:
            com.google.android.gms.internal.firebase-auth-api.zzaea r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaea.zza(r2)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            goto L_0x013e
        L_0x0093:
            int r3 = r1.getResponseCode()     // Catch:{ IOException -> 0x00c9, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            r5 = 400(0x190, float:5.6E-43)
            if (r3 < r5) goto L_0x00c7
            java.io.InputStream r1 = r1.getErrorStream()     // Catch:{ IOException -> 0x00c9, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            if (r1 != 0) goto L_0x00b5
            java.lang.String r1 = "Could not retrieve the authDomain for this project but did not receive an error response from the network request. Please try again."
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c9, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            r3.<init>()     // Catch:{ IOException -> 0x00c9, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.String r4 = "WEB_INTERNAL_ERROR:"
            r3.append(r4)     // Catch:{ IOException -> 0x00c9, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            r3.append(r1)     // Catch:{ IOException -> 0x00c9, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.String r1 = r3.toString()     // Catch:{ IOException -> 0x00c9, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            goto L_0x00dc
        L_0x00b5:
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x00c9, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            byte[] r1 = zzb(r1, r4)     // Catch:{ IOException -> 0x00c9, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            r3.<init>(r1)     // Catch:{ IOException -> 0x00c9, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            java.lang.Object r1 = com.google.android.gms.internal.p003firebaseauthapi.zzaei.zza(r3, r1)     // Catch:{ IOException -> 0x00c9, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ IOException -> 0x00c9, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            goto L_0x00dc
        L_0x00c7:
            r1 = r0
            goto L_0x00dc
        L_0x00c9:
            r1 = move-exception
            he.a r3 = zza     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.String r4 = "Error parsing error message from response body in getErrorMessageFromBody. "
            java.lang.String r1 = r4.concat(r1)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            r3.h(r1, r4)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            goto L_0x00c7
        L_0x00dc:
            he.a r3 = zza     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.String r4 = "Error getting project config. Failed with %s %s"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            r5[r8] = r1     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            r6 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            r5[r6] = r2     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.String r2 = java.lang.String.format(r4, r5)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            r3.c(r2, r4)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            com.google.android.gms.internal.firebase-auth-api.zzaea r0 = com.google.android.gms.internal.p003firebaseauthapi.zzaea.zzb(r1)     // Catch:{ IOException -> 0x0128, NullPointerException -> 0x0111, zzaca -> 0x00fa }
            goto L_0x013e
        L_0x00fa:
            r1 = move-exception
            he.a r2 = zza
            java.lang.String r1 = r1.getMessage()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.String r3 = "ConversionException encountered: "
            java.lang.String r1 = r3.concat(r1)
            r2.c(r1, r8)
            goto L_0x013e
        L_0x0111:
            r1 = move-exception
            he.a r2 = zza
            java.lang.String r1 = r1.getMessage()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.String r3 = "Null pointer encountered: "
            java.lang.String r1 = r3.concat(r1)
            r2.c(r1, r8)
            goto L_0x013e
        L_0x0128:
            r1 = move-exception
            he.a r2 = zza
            java.lang.String r1 = r1.getMessage()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.String r3 = "IOException occurred: "
            java.lang.String r1 = r3.concat(r1)
            r2.c(r1, r8)
        L_0x013e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p003firebaseauthapi.zzaeb.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onCancelled(Object obj) {
        zzaea zzaea = (zzaea) obj;
        onPostExecute((zzaea) null);
    }
}
