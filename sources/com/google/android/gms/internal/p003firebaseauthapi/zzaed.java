package com.google.android.gms.internal.p003firebaseauthapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.api.Status;
import com.google.firebase.inject.Provider;
import he.a;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaed  reason: invalid package */
public interface zzaed {
    public static final a zza = new a("FirebaseAuth", "GetAuthDomainTaskResponseHandler");

    Context zza();

    Uri.Builder zzb(Intent intent, String str, String str2);

    String zzc(String str);

    HttpURLConnection zzd(URL url);

    void zze(String str, Status status);

    void zzf(Uri uri, String str, Provider provider);
}
