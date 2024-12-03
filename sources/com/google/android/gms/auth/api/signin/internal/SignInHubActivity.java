package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.fragment.app.h;
import ce.n;
import ce.v;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;

@KeepName
public class SignInHubActivity extends h {

    /* renamed from: f  reason: collision with root package name */
    private static boolean f38421f = false;

    /* renamed from: a  reason: collision with root package name */
    private boolean f38422a = false;

    /* renamed from: b  reason: collision with root package name */
    private SignInConfiguration f38423b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f38424c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f38425d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Intent f38426e;

    private final void q0() {
        getSupportLoaderManager().d(0, (Bundle) null, new b(this, (v) null));
        f38421f = false;
    }

    private final void r0(int i10) {
        Status status = new Status(i10);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f38421f = false;
    }

    private final void s0(String str) {
        Intent intent = new Intent(str);
        if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent.setPackage("com.google.android.gms");
        } else {
            intent.setPackage(getPackageName());
        }
        intent.putExtra("config", this.f38423b);
        try {
            startActivityForResult(intent, 40962);
        } catch (ActivityNotFoundException unused) {
            this.f38422a = true;
            r0(17);
        }
    }

    public final boolean dispatchPopulateAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i10, int i11, Intent intent) {
        if (!this.f38422a) {
            setResult(0);
            if (i10 == 40962) {
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
                    if (signInAccount != null && signInAccount.S() != null) {
                        GoogleSignInAccount S = signInAccount.S();
                        n a10 = n.a(this);
                        GoogleSignInOptions S2 = this.f38423b.S();
                        S.getClass();
                        a10.c(S2, S);
                        intent.removeExtra("signInAccount");
                        intent.putExtra("googleSignInAccount", S);
                        this.f38424c = true;
                        this.f38425d = i11;
                        this.f38426e = intent;
                        q0();
                        return;
                    } else if (intent.hasExtra("errorCode")) {
                        int intExtra = intent.getIntExtra("errorCode", 8);
                        if (intExtra == 13) {
                            intExtra = 12501;
                        }
                        r0(intExtra);
                        return;
                    }
                }
                r0(8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        action.getClass();
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            r0(12500);
        } else if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") || action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            Bundle bundleExtra = intent.getBundleExtra("config");
            bundleExtra.getClass();
            SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable("config");
            if (signInConfiguration == null) {
                setResult(0);
                finish();
                return;
            }
            this.f38423b = signInConfiguration;
            if (bundle != null) {
                boolean z10 = bundle.getBoolean("signingInGoogleApiClients");
                this.f38424c = z10;
                if (z10) {
                    this.f38425d = bundle.getInt("signInResultCode");
                    Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
                    intent2.getClass();
                    this.f38426e = intent2;
                    q0();
                }
            } else if (f38421f) {
                setResult(0);
                r0(12502);
            } else {
                f38421f = true;
                s0(action);
            }
        } else {
            "Unknown action: ".concat(String.valueOf(intent.getAction()));
            finish();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        f38421f = false;
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f38424c);
        if (this.f38424c) {
            bundle.putInt("signInResultCode", this.f38425d);
            bundle.putParcelable("signInResultData", this.f38426e);
        }
    }
}
