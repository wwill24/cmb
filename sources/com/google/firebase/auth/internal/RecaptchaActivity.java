package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.browser.customtabs.d;
import androidx.fragment.app.h;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p003firebaseauthapi.zzaeb;
import com.google.android.gms.internal.p003firebaseauthapi.zzaed;
import com.google.android.gms.internal.p003firebaseauthapi.zzaeo;
import com.google.android.gms.internal.p003firebaseauthapi.zzafx;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.inject.Provider;
import com.mparticle.kits.ReportingMessage;
import fe.b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import me.i;
import me.k;
import n1.a;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

public class RecaptchaActivity extends h implements zzaed {
    private static final String zzb = "RecaptchaActivity";
    private static long zzc;
    private static final zzbz zzd = zzbz.zzc();
    private boolean zze = false;

    static /* synthetic */ Uri zzg(Uri uri, Task task) throws Exception {
        Uri.Builder buildUpon = uri.buildUpon();
        if (task.isSuccessful()) {
            AppCheckTokenResult appCheckTokenResult = (AppCheckTokenResult) task.getResult();
            if (appCheckTokenResult.getError() != null) {
                "Error getting App Check token; using placeholder token instead. Error: ".concat(String.valueOf(appCheckTokenResult.getError()));
            }
            buildUpon.fragment("fac=".concat(String.valueOf(appCheckTokenResult.getToken())));
        } else {
            "Unexpected error getting App Check token: ".concat(String.valueOf(task.getException().getMessage()));
        }
        return buildUpon.build();
    }

    private final void zzi() {
        zzc = 0;
        this.zze = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        a.b(this).d(intent);
        zzd.zzd(this);
        finish();
    }

    private final void zzj(Status status) {
        zzc = 0;
        this.zze = false;
        Intent intent = new Intent();
        int i10 = zzby.zzb;
        b.e(status, intent, "com.google.firebase.auth.internal.STATUS");
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        a.b(this).d(intent);
        zzd.zzd(this);
        finish();
    }

    /* access modifiers changed from: protected */
    public final void onCreate(@NonNull Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if ("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(action) || "android.intent.action.VIEW".equals(action)) {
            long currentTimeMillis = i.c().currentTimeMillis();
            if (currentTimeMillis - zzc >= 30000) {
                zzc = currentTimeMillis;
                if (bundle != null) {
                    this.zze = bundle.getBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW");
                    return;
                }
                return;
            }
            return;
        }
        "Could not do operation - unknown action: ".concat(String.valueOf(action));
        zzi();
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
                zzj(zzby.zzb(intent.getStringExtra("firebaseError")));
            } else if (!intent.hasExtra("link") || !intent.hasExtra("eventId")) {
                zzi();
            } else {
                String stringExtra = intent.getStringExtra("link");
                String zzc2 = zzj.zzb().zzc(getApplicationContext(), getPackageName(), intent.getStringExtra("eventId"));
                if (TextUtils.isEmpty(zzc2)) {
                    zzj(zzai.zza("Failed to find registration for this reCAPTCHA event"));
                }
                if (intent.getBooleanExtra("encryptionEnabled", true)) {
                    stringExtra = zzk.zza(getApplicationContext(), FirebaseApp.getInstance(zzc2).getPersistenceKey()).zzb(stringExtra);
                }
                String queryParameter = Uri.parse(stringExtra).getQueryParameter("recaptchaToken");
                zzc = 0;
                this.zze = false;
                Intent intent2 = new Intent();
                intent2.putExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN", queryParameter);
                intent2.putExtra("com.google.firebase.auth.internal.OPERATION", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
                intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
                if (!a.b(this).d(intent2)) {
                    SharedPreferences.Editor edit = getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
                    edit.putString("recaptchaToken", queryParameter);
                    edit.putString("operation", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
                    edit.putLong("timestamp", i.c().currentTimeMillis());
                    edit.commit();
                } else {
                    zzd.zzd(this);
                }
                finish();
            }
        } else if (!this.zze) {
            Intent intent3 = getIntent();
            String packageName = getPackageName();
            try {
                String lowerCase = k.b(me.a.a(this, packageName)).toLowerCase(Locale.US);
                FirebaseApp instance = FirebaseApp.getInstance(intent3.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME"));
                new zzaeb(packageName, lowerCase, intent3, instance, this).executeOnExecutor(FirebaseAuth.getInstance(instance).zzL(), new Void[0]);
            } catch (PackageManager.NameNotFoundException e10) {
                String obj = e10.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not get package signature: ");
                sb2.append(packageName);
                sb2.append(" ");
                sb2.append(obj);
                zze(packageName, (Status) null);
            }
            this.zze = true;
        } else {
            zzi();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW", this.zze);
    }

    @NonNull
    public final Context zza() {
        return getApplicationContext();
    }

    public final Uri.Builder zzb(@NonNull Intent intent, @NonNull String str, @NonNull String str2) {
        String str3;
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String uuid = UUID.randomUUID().toString();
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME");
        FirebaseApp instance = FirebaseApp.getInstance(stringExtra3);
        FirebaseAuth instance2 = FirebaseAuth.getInstance(instance);
        zzj.zzb().zze(getApplicationContext(), str, uuid, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA", stringExtra3);
        String zzc2 = zzk.zza(getApplicationContext(), instance.getPersistenceKey()).zzc();
        if (TextUtils.isEmpty(zzc2)) {
            zzj(zzai.zza("Failed to generate/retrieve public encryption key for reCAPTCHA flow."));
            return null;
        }
        if (!TextUtils.isEmpty(instance2.getLanguageCode())) {
            str3 = instance2.getLanguageCode();
        } else {
            str3 = zzaeo.zza();
        }
        return new Uri.Builder().scheme("https").appendPath("__").appendPath(SaslNonza.AuthMechanism.ELEMENT).appendPath("handler").appendQueryParameter("apiKey", stringExtra).appendQueryParameter("authType", "verifyApp").appendQueryParameter("apn", str).appendQueryParameter("hl", str3).appendQueryParameter("eventId", uuid).appendQueryParameter(ReportingMessage.MessageType.SCREEN_VIEW, "X".concat(String.valueOf(stringExtra2))).appendQueryParameter("eid", XHTMLText.P).appendQueryParameter("appName", stringExtra3).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", zzc2);
    }

    @NonNull
    public final String zzc(@NonNull String str) {
        return zzafx.zzb(str);
    }

    public final HttpURLConnection zzd(@NonNull URL url) {
        try {
            return (HttpURLConnection) url.openConnection();
        } catch (IOException unused) {
            zzaed.zza.c("Error generating connection", new Object[0]);
            return null;
        }
    }

    public final void zze(@NonNull String str, Status status) {
        if (status == null) {
            zzi();
        } else {
            zzj(status);
        }
    }

    public final void zzf(@NonNull Uri uri, @NonNull String str, @NonNull Provider provider) {
        Task<TContinuationResult> task;
        InteropAppCheckTokenProvider interopAppCheckTokenProvider = (InteropAppCheckTokenProvider) provider.get();
        if (interopAppCheckTokenProvider != null) {
            task = interopAppCheckTokenProvider.getToken(false).continueWith(new zzbh(uri));
        } else {
            task = Tasks.forResult(uri);
        }
        task.addOnCompleteListener(new zzbg(this, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(String str, Task task) {
        if (getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) != null) {
            List<ResolveInfo> queryIntentServices = getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                Intent intent = new Intent("android.intent.action.VIEW", (Uri) task.getResult());
                intent.putExtra("com.android.browser.application_id", str);
                intent.addFlags(1073741824);
                intent.addFlags(268435456);
                startActivity(intent);
                return;
            }
            d a10 = new d.a().a();
            a10.f1542a.addFlags(1073741824);
            a10.f1542a.addFlags(268435456);
            a10.a(this, (Uri) task.getResult());
            return;
        }
        zze(str, (Status) null);
    }
}
