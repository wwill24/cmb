package com.clevertap.android.sdk;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.h;
import com.clevertap.android.sdk.inapp.CTInAppNotification;
import com.clevertap.android.sdk.inapp.CTInAppType;
import com.clevertap.android.sdk.inapp.j;
import com.clevertap.android.sdk.inapp.l;
import com.clevertap.android.sdk.inapp.m;
import com.clevertap.android.sdk.inapp.n;
import com.clevertap.android.sdk.inapp.p;
import com.clevertap.android.sdk.inapp.q;
import com.clevertap.android.sdk.inapp.u;
import com.clevertap.android.sdk.inapp.v;
import com.clevertap.android.sdk.inapp.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import net.bytebuddy.jar.asm.Opcodes;

public final class InAppNotificationActivity extends h implements x {

    /* renamed from: d  reason: collision with root package name */
    private static boolean f10096d = false;

    /* renamed from: a  reason: collision with root package name */
    private CleverTapInstanceConfig f10097a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public CTInAppNotification f10098b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<x> f10099c;

    class a implements DialogInterface.OnClickListener {
        a() {
        }

        public void onClick(DialogInterface dialogInterface, int i10) {
            Bundle bundle = new Bundle();
            bundle.putString("wzrk_id", InAppNotificationActivity.this.f10098b.h());
            bundle.putString("wzrk_c2a", InAppNotificationActivity.this.f10098b.g().get(0).g());
            InAppNotificationActivity.this.q0(bundle, (HashMap<String, String>) null);
            String a10 = InAppNotificationActivity.this.f10098b.g().get(0).a();
            if (a10 != null) {
                InAppNotificationActivity.this.t0(a10, bundle);
            } else {
                InAppNotificationActivity.this.r0(bundle);
            }
        }
    }

    class b implements DialogInterface.OnClickListener {
        b() {
        }

        public void onClick(DialogInterface dialogInterface, int i10) {
            Bundle bundle = new Bundle();
            bundle.putString("wzrk_id", InAppNotificationActivity.this.f10098b.h());
            bundle.putString("wzrk_c2a", InAppNotificationActivity.this.f10098b.g().get(1).g());
            InAppNotificationActivity.this.q0(bundle, (HashMap<String, String>) null);
            String a10 = InAppNotificationActivity.this.f10098b.g().get(1).a();
            if (a10 != null) {
                InAppNotificationActivity.this.t0(a10, bundle);
            } else {
                InAppNotificationActivity.this.r0(bundle);
            }
        }
    }

    class c implements DialogInterface.OnClickListener {
        c() {
        }

        public void onClick(DialogInterface dialogInterface, int i10) {
            Bundle bundle = new Bundle();
            bundle.putString("wzrk_id", InAppNotificationActivity.this.f10098b.h());
            bundle.putString("wzrk_c2a", InAppNotificationActivity.this.f10098b.g().get(2).g());
            InAppNotificationActivity.this.q0(bundle, (HashMap<String, String>) null);
            String a10 = InAppNotificationActivity.this.f10098b.g().get(2).a();
            if (a10 != null) {
                InAppNotificationActivity.this.t0(a10, bundle);
            } else {
                InAppNotificationActivity.this.r0(bundle);
            }
        }
    }

    static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10103a;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.clevertap.android.sdk.inapp.CTInAppType[] r0 = com.clevertap.android.sdk.inapp.CTInAppType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10103a = r0
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeCoverHTML     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10103a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeInterstitialHTML     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10103a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeHalfInterstitialHTML     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10103a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeCover     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f10103a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeInterstitial     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f10103a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeHalfInterstitial     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f10103a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeCoverImageOnly     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f10103a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeInterstitialImageOnly     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f10103a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeHalfInterstitialImageOnly     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f10103a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeAlert     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.InAppNotificationActivity.d.<clinit>():void");
        }
    }

    private com.clevertap.android.sdk.inapp.b p0() {
        AlertDialog alertDialog;
        CTInAppType r10 = this.f10098b.r();
        switch (d.f10103a[r10.ordinal()]) {
            case 1:
                return new com.clevertap.android.sdk.inapp.h();
            case 2:
                return new l();
            case 3:
                return new j();
            case 4:
                return new m();
            case 5:
                return new u();
            case 6:
                return new p();
            case 7:
                return new n();
            case 8:
                return new v();
            case 9:
                return new q();
            case 10:
                if (this.f10098b.g().size() > 0) {
                    alertDialog = new AlertDialog.Builder(this, 16974394).setCancelable(false).setTitle(this.f10098b.B()).setMessage(this.f10098b.w()).setPositiveButton(this.f10098b.g().get(0).g(), new a()).create();
                    if (this.f10098b.g().size() == 2) {
                        alertDialog.setButton(-2, this.f10098b.g().get(1).g(), new b());
                    }
                    if (this.f10098b.g().size() > 2) {
                        alertDialog.setButton(-3, this.f10098b.g().get(2).g(), new c());
                    }
                } else {
                    alertDialog = null;
                }
                if (alertDialog != null) {
                    alertDialog.show();
                    f10096d = true;
                    s0((Bundle) null);
                    return null;
                }
                this.f10097a.n().e("InAppNotificationActivity: Alert Dialog is null, not showing Alert InApp");
                return null;
            default:
                this.f10097a.n().s("InAppNotificationActivity: Unhandled InApp Type: " + r10);
                return null;
        }
    }

    private String u0() {
        return this.f10097a.e() + ":CT_INAPP_CONTENT_FRAGMENT";
    }

    public void D(Context context, CTInAppNotification cTInAppNotification, Bundle bundle) {
        r0(bundle);
    }

    public void R(CTInAppNotification cTInAppNotification, Bundle bundle) {
        s0(bundle);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(Opcodes.ASM10_EXPERIMENTAL, 17432577);
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(Opcodes.ASM10_EXPERIMENTAL, 17432577);
        finish();
        r0((Bundle) null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i10 = getResources().getConfiguration().orientation;
        if (i10 == 2) {
            getWindow().addFlags(1024);
        }
        try {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.f10098b = (CTInAppNotification) extras.getParcelable("inApp");
                Bundle bundle2 = extras.getBundle("configBundle");
                if (bundle2 != null) {
                    this.f10097a = (CleverTapInstanceConfig) bundle2.getParcelable("config");
                }
                w0(CleverTapAPI.F(this, this.f10097a).s().h());
                CTInAppNotification cTInAppNotification = this.f10098b;
                if (cTInAppNotification == null) {
                    finish();
                    return;
                }
                if (cTInAppNotification.S() && !this.f10098b.R()) {
                    if (i10 == 2) {
                        p.a("App in Landscape, dismissing portrait InApp Notification");
                        finish();
                        r0((Bundle) null);
                        return;
                    }
                    p.a("App in Portrait, displaying InApp Notification anyway");
                }
                if (!this.f10098b.S() && this.f10098b.R()) {
                    if (i10 == 1) {
                        p.a("App in Portrait, dismissing landscape InApp Notification");
                        finish();
                        r0((Bundle) null);
                        return;
                    }
                    p.a("App in Landscape, displaying InApp Notification anyway");
                }
                if (bundle == null) {
                    com.clevertap.android.sdk.inapp.b p02 = p0();
                    if (p02 != null) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putParcelable("inApp", this.f10098b);
                        bundle3.putParcelable("config", this.f10097a);
                        p02.setArguments(bundle3);
                        getSupportFragmentManager().p().u(17498112, 17498113).c(16908290, p02, u0()).i();
                    }
                } else if (f10096d) {
                    p0();
                }
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Throwable th2) {
            p.r("Cannot find a valid notification bundle to show!", th2);
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void q0(Bundle bundle, HashMap<String, String> hashMap) {
        x v02 = v0();
        if (v02 != null) {
            v02.y(this.f10098b, bundle, hashMap);
        }
    }

    /* access modifiers changed from: package-private */
    public void r0(Bundle bundle) {
        if (f10096d) {
            f10096d = false;
        }
        finish();
        x v02 = v0();
        if (v02 != null && getBaseContext() != null) {
            v02.D(getBaseContext(), this.f10098b, bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public void s0(Bundle bundle) {
        x v02 = v0();
        if (v02 != null) {
            v02.R(this.f10098b, bundle);
        }
    }

    public void setTheme(int i10) {
        super.setTheme(16973840);
    }

    /* access modifiers changed from: package-private */
    public void t0(String str, Bundle bundle) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str.replace("\n", "").replace("\r", ""))));
        } catch (Throwable unused) {
        }
        r0(bundle);
    }

    /* access modifiers changed from: package-private */
    public x v0() {
        x xVar;
        try {
            xVar = this.f10099c.get();
        } catch (Throwable unused) {
            xVar = null;
        }
        if (xVar == null) {
            p n10 = this.f10097a.n();
            String e10 = this.f10097a.e();
            n10.t(e10, "InAppActivityListener is null for notification: " + this.f10098b.s());
        }
        return xVar;
    }

    /* access modifiers changed from: package-private */
    public void w0(x xVar) {
        this.f10099c = new WeakReference<>(xVar);
    }

    public void y(CTInAppNotification cTInAppNotification, Bundle bundle, HashMap<String, String> hashMap) {
        q0(bundle, hashMap);
    }
}
