package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.h;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p003firebaseauthapi.zzaeb;
import com.google.android.gms.internal.p003firebaseauthapi.zzaec;
import com.google.android.gms.internal.p003firebaseauthapi.zzaed;
import com.google.android.gms.internal.p003firebaseauthapi.zzafx;
import com.google.android.gms.internal.p003firebaseauthapi.zzaic;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.inject.Provider;
import com.mparticle.kits.AppsFlyerKit;
import com.mparticle.kits.ReportingMessage;
import fe.b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;
import me.i;
import me.k;
import n1.a;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.json.JSONException;

@KeepName
public class GenericIdpActivity extends h implements zzaed {
    public static final /* synthetic */ int zzb = 0;
    private static long zzc;
    private static final zzbz zzd = zzbz.zzc();
    private boolean zze = false;

    private final void zzh() {
        zzc = 0;
        this.zze = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!a.b(this).d(intent)) {
            zzd.zzf(this, zzai.zza("WEB_CONTEXT_CANCELED"));
        } else {
            zzd.zzd(this);
        }
        finish();
    }

    private final void zzi(Status status) {
        zzc = 0;
        this.zze = false;
        Intent intent = new Intent();
        int i10 = zzby.zzb;
        b.e(status, intent, "com.google.firebase.auth.internal.STATUS");
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!a.b(this).d(intent)) {
            zzd.zzf(getApplicationContext(), status);
        } else {
            zzd.zzd(this);
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public final void onCreate(@NonNull Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(action) || "com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(action) || "com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(action) || "android.intent.action.VIEW".equals(action)) {
            long currentTimeMillis = i.c().currentTimeMillis();
            if (currentTimeMillis - zzc >= 30000) {
                zzc = currentTimeMillis;
                if (bundle != null) {
                    this.zze = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
                    return;
                }
                return;
            }
            return;
        }
        "Could not do operation - unknown action: ".concat(String.valueOf(action));
        zzh();
    }

    public final void onNewIntent(@NonNull Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        if ("android.intent.action.VIEW".equals(getIntent().getAction())) {
            Intent intent = getIntent();
            if (intent.hasExtra("firebaseError")) {
                zzi(zzby.zzb(intent.getStringExtra("firebaseError")));
            } else if (!intent.hasExtra("link") || !intent.hasExtra("eventId")) {
                zzh();
            } else {
                String stringExtra = intent.getStringExtra("link");
                String stringExtra2 = intent.getStringExtra("eventId");
                String packageName = getPackageName();
                boolean booleanExtra = intent.getBooleanExtra("encryptionEnabled", true);
                zzi zza = zzj.zzb().zza(this, packageName, stringExtra2);
                if (zza == null) {
                    zzh();
                }
                if (booleanExtra) {
                    stringExtra = zzk.zza(getApplicationContext(), FirebaseApp.getInstance(zza.zza()).getPersistenceKey()).zzb(stringExtra);
                }
                zzaic zzaic = new zzaic(zza, stringExtra);
                String zze2 = zza.zze();
                String zzb2 = zza.zzb();
                zzaic.zzf(zze2);
                if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(zzb2) || "com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(zzb2) || "com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(zzb2)) {
                    zzc = 0;
                    this.zze = false;
                    Intent intent2 = new Intent();
                    b.e(zzaic, intent2, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST");
                    intent2.putExtra("com.google.firebase.auth.internal.OPERATION", zzb2);
                    intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
                    if (!a.b(this).d(intent2)) {
                        SharedPreferences.Editor edit = getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
                        edit.putString("verifyAssertionRequest", b.f(zzaic));
                        edit.putString("operation", zzb2);
                        edit.putString("tenantId", zze2);
                        edit.putLong("timestamp", i.c().currentTimeMillis());
                        edit.commit();
                    } else {
                        zzd.zzd(this);
                    }
                    finish();
                    return;
                }
                "unsupported operation: ".concat(zzb2);
                zzh();
            }
        } else if (!this.zze) {
            String packageName2 = getPackageName();
            try {
                String lowerCase = k.b(me.a.a(this, packageName2)).toLowerCase(Locale.US);
                FirebaseApp instance = FirebaseApp.getInstance(getIntent().getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME"));
                FirebaseAuth instance2 = FirebaseAuth.getInstance(instance);
                if (!zzafx.zzg(instance)) {
                    new zzaeb(packageName2, lowerCase, getIntent(), instance, this).executeOnExecutor(instance2.zzL(), new Void[0]);
                } else {
                    zzf(zzg(Uri.parse(zzafx.zza(instance.getOptions().getApiKey())).buildUpon(), getIntent(), packageName2, lowerCase).build(), packageName2, instance2.zzE());
                }
            } catch (PackageManager.NameNotFoundException e10) {
                String obj = e10.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not get package signature: ");
                sb2.append(packageName2);
                sb2.append(" ");
                sb2.append(obj);
                zze(packageName2, (Status) null);
            }
            this.zze = true;
        } else {
            zzh();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.zze);
    }

    @NonNull
    public final Context zza() {
        return getApplicationContext();
    }

    public final Uri.Builder zzb(@NonNull Intent intent, @NonNull String str, @NonNull String str2) {
        return zzg(new Uri.Builder().scheme("https").appendPath("__").appendPath(SaslNonza.AuthMechanism.ELEMENT).appendPath("handler"), intent, str, str2);
    }

    @NonNull
    public final String zzc(@NonNull String str) {
        return zzafx.zzb(str);
    }

    public final HttpURLConnection zzd(@NonNull URL url) {
        try {
            return (HttpURLConnection) url.openConnection();
        } catch (IOException unused) {
            return null;
        }
    }

    public final void zze(@NonNull String str, Status status) {
        if (status == null) {
            zzh();
        } else {
            zzi(status);
        }
    }

    public final void zzf(@NonNull Uri uri, @NonNull String str, @NonNull Provider provider) {
        Task<TContinuationResult> task;
        InteropAppCheckTokenProvider interopAppCheckTokenProvider = (InteropAppCheckTokenProvider) provider.get();
        if (interopAppCheckTokenProvider != null) {
            task = interopAppCheckTokenProvider.getToken(false).continueWith(new zzaz(uri));
        } else {
            task = Tasks.forResult(uri);
        }
        task.addOnCompleteListener(new zzay(this, str));
    }

    public final Uri.Builder zzg(@NonNull Uri.Builder builder, @NonNull Intent intent, @NonNull String str, @NonNull String str2) {
        String str3;
        String str4;
        Uri.Builder builder2 = builder;
        Intent intent2 = intent;
        String stringExtra = intent2.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String stringExtra2 = intent2.getStringExtra("com.google.firebase.auth.KEY_PROVIDER_ID");
        String stringExtra3 = intent2.getStringExtra("com.google.firebase.auth.KEY_TENANT_ID");
        String stringExtra4 = intent2.getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME");
        ArrayList<String> stringArrayListExtra = intent2.getStringArrayListExtra("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
        if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
            str3 = null;
        } else {
            str3 = TextUtils.join(AppsFlyerKit.COMMA, stringArrayListExtra);
        }
        Bundle bundleExtra = intent2.getBundleExtra("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS");
        if (bundleExtra == null) {
            str4 = null;
        } else {
            org.json.b bVar = new org.json.b();
            try {
                for (String next : bundleExtra.keySet()) {
                    String string = bundleExtra.getString(next);
                    if (!TextUtils.isEmpty(string)) {
                        bVar.put(next, (Object) string);
                    }
                }
            } catch (JSONException unused) {
            }
            str4 = bVar.toString();
        }
        String uuid = UUID.randomUUID().toString();
        String zza = zzaec.zza(this, UUID.randomUUID().toString());
        String action = intent.getAction();
        String stringExtra5 = intent2.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String str5 = stringExtra;
        String str6 = zza;
        String str7 = uuid;
        String str8 = str4;
        String str9 = str3;
        zzj.zzb().zzd(getApplicationContext(), str, uuid, zza, action, stringExtra2, stringExtra3, stringExtra4);
        String zzc2 = zzk.zza(getApplicationContext(), FirebaseApp.getInstance(stringExtra4).getPersistenceKey()).zzc();
        if (TextUtils.isEmpty(zzc2)) {
            zzi(zzai.zza("Failed to generate/retrieve public encryption key for Generic IDP flow."));
            return null;
        } else if (str6 == null) {
            return null;
        } else {
            builder2.appendQueryParameter("eid", XHTMLText.P).appendQueryParameter(ReportingMessage.MessageType.SCREEN_VIEW, "X".concat(String.valueOf(stringExtra5))).appendQueryParameter("authType", "signInWithRedirect").appendQueryParameter("apiKey", str5).appendQueryParameter("providerId", stringExtra2).appendQueryParameter("sessionId", str6).appendQueryParameter("eventId", str7).appendQueryParameter("apn", str).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", zzc2);
            if (!TextUtils.isEmpty(str9)) {
                builder2.appendQueryParameter("scopes", str9);
            }
            if (!TextUtils.isEmpty(str8)) {
                builder2.appendQueryParameter("customParameters", str8);
            }
            if (!TextUtils.isEmpty(stringExtra3)) {
                builder2.appendQueryParameter("tid", stringExtra3);
            }
            return builder2;
        }
    }
}
