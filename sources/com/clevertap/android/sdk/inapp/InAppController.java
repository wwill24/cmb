package com.clevertap.android.sdk.inapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.b0;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.InAppNotificationActivity;
import com.clevertap.android.sdk.inapp.CTInAppNotification;
import com.clevertap.android.sdk.j;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.q;
import com.clevertap.android.sdk.s;
import com.mparticle.kits.AppsFlyerKit;
import i4.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.commons.validator.Field;

public class InAppController implements CTInAppNotification.c, x {

    /* renamed from: l  reason: collision with root package name */
    private static CTInAppNotification f10344l;

    /* renamed from: m  reason: collision with root package name */
    private static final List<CTInAppNotification> f10345m = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with root package name */
    private final com.clevertap.android.sdk.c f10346a;

    /* renamed from: b  reason: collision with root package name */
    private final i4.b f10347b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final CleverTapInstanceConfig f10348c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Context f10349d;

    /* renamed from: e  reason: collision with root package name */
    private final i4.i f10350e;

    /* renamed from: f  reason: collision with root package name */
    private final j f10351f;

    /* renamed from: g  reason: collision with root package name */
    private InAppState f10352g;

    /* renamed from: h  reason: collision with root package name */
    private HashSet<String> f10353h = null;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final p f10354j;

    /* renamed from: k  reason: collision with root package name */
    private final u4.a f10355k;

    private enum InAppState {
        DISCARDED(-1),
        SUSPENDED(0),
        RESUMED(1);
        
        final int state;

        private InAppState(int i10) {
            this.state = i10;
        }
    }

    class a implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f10360a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CTInAppNotification f10361b;

        a(Context context, CTInAppNotification cTInAppNotification) {
            this.f10360a = context;
            this.f10361b = cTInAppNotification;
        }

        /* renamed from: a */
        public Void call() {
            InAppController.o(this.f10360a, InAppController.this.f10348c, this.f10361b, InAppController.this);
            InAppController.this.b(this.f10360a);
            return null;
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CTInAppNotification f10363a;

        b(CTInAppNotification cTInAppNotification) {
            this.f10363a = cTInAppNotification;
        }

        public void run() {
            InAppController.this.a(this.f10363a);
        }
    }

    class c implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f10365a;

        c(Context context) {
            this.f10365a = context;
        }

        /* renamed from: a */
        public Void call() {
            InAppController.this.b(this.f10365a);
            return null;
        }
    }

    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CTInAppNotification f10367a;

        d(CTInAppNotification cTInAppNotification) {
            this.f10367a = cTInAppNotification;
        }

        public void run() {
            InAppController.this.n(this.f10367a);
        }
    }

    class e implements Callable<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ org.json.b f10369a;

        e(org.json.b bVar) {
            this.f10369a = bVar;
        }

        /* renamed from: a */
        public Void call() {
            InAppController inAppController = InAppController.this;
            new i(inAppController, this.f10369a).run();
            return null;
        }
    }

    class f implements Callable<Void> {
        f() {
        }

        /* renamed from: a */
        public Void call() {
            InAppController inAppController = InAppController.this;
            inAppController.b(inAppController.f10349d);
            return null;
        }
    }

    class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f10372a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CTInAppNotification f10373b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CleverTapInstanceConfig f10374c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ InAppController f10375d;

        g(Context context, CTInAppNotification cTInAppNotification, CleverTapInstanceConfig cleverTapInstanceConfig, InAppController inAppController) {
            this.f10372a = context;
            this.f10373b = cTInAppNotification;
            this.f10374c = cleverTapInstanceConfig;
            this.f10375d = inAppController;
        }

        public void run() {
            InAppController.q(this.f10372a, this.f10373b, this.f10374c, this.f10375d);
        }
    }

    static /* synthetic */ class h {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10376a;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(3:27|28|30)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.clevertap.android.sdk.inapp.CTInAppType[] r0 = com.clevertap.android.sdk.inapp.CTInAppType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10376a = r0
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeCoverHTML     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10376a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeInterstitialHTML     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10376a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeHalfInterstitialHTML     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10376a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeCover     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f10376a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeHalfInterstitial     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f10376a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeInterstitial     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f10376a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeAlert     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f10376a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeInterstitialImageOnly     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f10376a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeHalfInterstitialImageOnly     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f10376a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeCoverImageOnly     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f10376a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeFooterHTML     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f10376a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeHeaderHTML     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f10376a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeFooter     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f10376a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeHeader     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inapp.InAppController.h.<clinit>():void");
        }
    }

    private final class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<InAppController> f10377a;

        /* renamed from: b  reason: collision with root package name */
        private final org.json.b f10378b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f10379c = x.f15508a;

        i(InAppController inAppController, org.json.b bVar) {
            this.f10377a = new WeakReference<>(inAppController);
            this.f10378b = bVar;
        }

        public void run() {
            CTInAppNotification K = new CTInAppNotification().K(this.f10378b, this.f10379c);
            if (K.getError() != null) {
                p d10 = InAppController.this.f10354j;
                String e10 = InAppController.this.f10348c.e();
                d10.f(e10, "Unable to parse inapp notification " + K.getError());
                return;
            }
            K.f10291a = this.f10377a.get();
            K.W();
        }
    }

    public InAppController(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, u4.a aVar, i4.i iVar, i4.b bVar, com.clevertap.android.sdk.c cVar, j jVar) {
        this.f10349d = context;
        this.f10348c = cleverTapInstanceConfig;
        this.f10354j = cleverTapInstanceConfig.n();
        this.f10355k = aVar;
        this.f10350e = iVar;
        this.f10347b = bVar;
        this.f10346a = cVar;
        this.f10351f = jVar;
        this.f10352g = InAppState.RESUMED;
    }

    /* access modifiers changed from: private */
    public void b(Context context) {
        SharedPreferences g10 = s.g(context);
        try {
            if (!j()) {
                p.o("Not showing notification on blacklisted activity");
            } else if (this.f10352g == InAppState.SUSPENDED) {
                this.f10354j.f(this.f10348c.e(), "InApp Notifications are set to be suspended, not showing the InApp Notification");
            } else {
                m(context, this.f10348c, this);
                org.json.a aVar = new org.json.a(s.k(context, this.f10348c, "inApp", Field.TOKEN_INDEXED));
                if (aVar.o() >= 1) {
                    if (this.f10352g != InAppState.DISCARDED) {
                        p(aVar.j(0));
                    } else {
                        this.f10354j.f(this.f10348c.e(), "InApp Notifications are set to be discarded, dropping the InApp Notification");
                    }
                    org.json.a aVar2 = new org.json.a();
                    for (int i10 = 0; i10 < aVar.o(); i10++) {
                        if (i10 != 0) {
                            aVar2.E(aVar.get(i10));
                        }
                    }
                    s.l(g10.edit().putString(s.s(this.f10348c, "inApp"), aVar2.toString()));
                }
            }
        } catch (Throwable th2) {
            this.f10354j.u(this.f10348c.e(), "InApp: Couldn't parse JSON array string from prefs", th2);
        }
    }

    private boolean j() {
        t();
        Iterator<String> it = this.f10353h.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String j10 = j.j();
            if (j10 != null && j10.contains(next)) {
                return false;
            }
        }
        return true;
    }

    private static void m(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, InAppController inAppController) {
        p.p(cleverTapInstanceConfig.e(), "checking Pending Notifications");
        List<CTInAppNotification> list = f10345m;
        if (list != null && !list.isEmpty()) {
            try {
                list.remove(0);
                new u4.a().post(new g(context, list.get(0), cleverTapInstanceConfig, inAppController));
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void n(CTInAppNotification cTInAppNotification) {
        boolean z10;
        HashMap<String, Object> hashMap;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f10355k.post(new d(cTInAppNotification));
        } else if (this.f10350e.h() == null) {
            p pVar = this.f10354j;
            String e10 = this.f10348c.e();
            pVar.t(e10, "getCoreState().getInAppFCManager() is NULL, not showing " + cTInAppNotification.h());
        } else if (!this.f10350e.h().d(cTInAppNotification)) {
            p pVar2 = this.f10354j;
            String e11 = this.f10348c.e();
            pVar2.t(e11, "InApp has been rejected by FC, not showing " + cTInAppNotification.h());
            r();
        } else {
            this.f10350e.h().g(this.f10349d, cTInAppNotification);
            i4.p g10 = this.f10347b.g();
            if (g10 != null) {
                if (cTInAppNotification.i() != null) {
                    hashMap = x.d(cTInAppNotification.i());
                } else {
                    hashMap = new HashMap<>();
                }
                z10 = g10.a(hashMap);
            } else {
                z10 = true;
            }
            if (!z10) {
                p pVar3 = this.f10354j;
                String e12 = this.f10348c.e();
                pVar3.t(e12, "Application has decided to not show this in-app notification: " + cTInAppNotification.h());
                r();
                return;
            }
            q(this.f10349d, cTInAppNotification, this.f10348c, this);
        }
    }

    /* access modifiers changed from: private */
    public static void o(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, CTInAppNotification cTInAppNotification, InAppController inAppController) {
        p.p(cleverTapInstanceConfig.e(), "Running inAppDidDismiss");
        CTInAppNotification cTInAppNotification2 = f10344l;
        if (cTInAppNotification2 != null && cTInAppNotification2.h().equals(cTInAppNotification.h())) {
            f10344l = null;
            m(context, cleverTapInstanceConfig, inAppController);
        }
    }

    private void p(org.json.b bVar) {
        p pVar = this.f10354j;
        String e10 = this.f10348c.e();
        pVar.f(e10, "Preparing In-App for display: " + bVar.toString());
        com.clevertap.android.sdk.task.a.a(this.f10348c).d("TAG_FEATURE_IN_APPS").f("InappController#prepareNotificationForDisplay", new e(bVar));
    }

    /* access modifiers changed from: private */
    public static void q(Context context, CTInAppNotification cTInAppNotification, CleverTapInstanceConfig cleverTapInstanceConfig, InAppController inAppController) {
        p.p(cleverTapInstanceConfig.e(), "Attempting to show next In-App");
        if (!j.x()) {
            f10345m.add(cTInAppNotification);
            p.p(cleverTapInstanceConfig.e(), "Not in foreground, queueing this In App");
        } else if (f10344l != null) {
            f10345m.add(cTInAppNotification);
            p.p(cleverTapInstanceConfig.e(), "In App already displaying, queueing this In App");
        } else if (System.currentTimeMillis() / 1000 > cTInAppNotification.A()) {
            p.a("InApp has elapsed its time to live, not showing the InApp");
        } else {
            f10344l = cTInAppNotification;
            CTInAppType r10 = cTInAppNotification.r();
            Fragment fragment = null;
            switch (h.f10376a[r10.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    Intent intent = new Intent(context, InAppNotificationActivity.class);
                    intent.putExtra("inApp", cTInAppNotification);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("config", cleverTapInstanceConfig);
                    intent.putExtra("configBundle", bundle);
                    try {
                        Activity i10 = j.i();
                        if (i10 != null) {
                            p n10 = cleverTapInstanceConfig.n();
                            String e10 = cleverTapInstanceConfig.e();
                            n10.t(e10, "calling InAppActivity for notification: " + cTInAppNotification.s());
                            i10.startActivity(intent);
                            p.a("Displaying In-App: " + cTInAppNotification.s());
                            break;
                        } else {
                            throw new IllegalStateException("Current activity reference not found");
                        }
                    } catch (Throwable th2) {
                        p.r("Please verify the integration of your app. It is not setup to support in-app notifications yet.", th2);
                        break;
                    }
                case 11:
                    fragment = new i();
                    break;
                case 12:
                    fragment = new k();
                    break;
                case 13:
                    fragment = new o();
                    break;
                case 14:
                    fragment = new r();
                    break;
                default:
                    String e11 = cleverTapInstanceConfig.e();
                    p.b(e11, "Unknown InApp Type found: " + r10);
                    f10344l = null;
                    return;
            }
            if (fragment != null) {
                p.a("Displaying In-App: " + cTInAppNotification.s());
                try {
                    b0 p10 = ((androidx.fragment.app.h) j.i()).getSupportFragmentManager().p();
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("inApp", cTInAppNotification);
                    bundle2.putParcelable("config", cleverTapInstanceConfig);
                    fragment.setArguments(bundle2);
                    p10.u(17498112, 17498113);
                    p10.c(16908290, fragment, cTInAppNotification.G());
                    String e12 = cleverTapInstanceConfig.e();
                    p.p(e12, "calling InAppFragment " + cTInAppNotification.h());
                    p10.i();
                } catch (ClassCastException e13) {
                    String e14 = cleverTapInstanceConfig.e();
                    p.p(e14, "Fragment not able to render, please ensure your Activity is an instance of AppCompatActivity" + e13.getMessage());
                } catch (Throwable th3) {
                    p.q(cleverTapInstanceConfig.e(), "Fragment not able to render", th3);
                }
            }
        }
    }

    private void r() {
        if (!this.f10348c.p()) {
            com.clevertap.android.sdk.task.a.a(this.f10348c).d("TAG_FEATURE_IN_APPS").f("InAppController#showInAppNotificationIfAny", new f());
        }
    }

    private void t() {
        if (this.f10353h == null) {
            this.f10353h = new HashSet<>();
            try {
                String f10 = q.h(this.f10349d).f();
                if (f10 != null) {
                    for (String trim : f10.split(AppsFlyerKit.COMMA)) {
                        this.f10353h.add(trim.trim());
                    }
                }
            } catch (Throwable unused) {
            }
            this.f10354j.f(this.f10348c.e(), "In-app notifications will not be shown on " + Arrays.toString(this.f10353h.toArray()));
        }
    }

    public void D(Context context, CTInAppNotification cTInAppNotification, Bundle bundle) {
        HashMap<String, Object> hashMap;
        cTInAppNotification.c();
        if (this.f10350e.h() != null) {
            this.f10350e.h().f(cTInAppNotification);
            p pVar = this.f10354j;
            String e10 = this.f10348c.e();
            pVar.t(e10, "InApp Dismissed: " + cTInAppNotification.h());
        } else {
            p pVar2 = this.f10354j;
            String e11 = this.f10348c.e();
            pVar2.t(e11, "Not calling InApp Dismissed: " + cTInAppNotification.h() + " because InAppFCManager is null");
        }
        try {
            i4.p g10 = this.f10347b.g();
            if (g10 != null) {
                if (cTInAppNotification.i() != null) {
                    hashMap = x.d(cTInAppNotification.i());
                } else {
                    hashMap = new HashMap<>();
                }
                p.o("Calling the in-app listener on behalf of " + this.f10351f.t());
                if (bundle != null) {
                    g10.b(hashMap, x.c(bundle));
                } else {
                    g10.b(hashMap, (Map<String, Object>) null);
                }
            }
        } catch (Throwable th2) {
            this.f10354j.u(this.f10348c.e(), "Failed to call the in-app notification listener", th2);
        }
        com.clevertap.android.sdk.task.a.a(this.f10348c).d("TAG_FEATURE_IN_APPS").f("InappController#inAppNotificationDidDismiss", new a(context, cTInAppNotification));
    }

    public void R(CTInAppNotification cTInAppNotification, Bundle bundle) {
        this.f10346a.C(false, cTInAppNotification, bundle);
    }

    public void a(CTInAppNotification cTInAppNotification) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f10355k.post(new b(cTInAppNotification));
        } else if (cTInAppNotification.getError() != null) {
            p pVar = this.f10354j;
            String e10 = this.f10348c.e();
            pVar.f(e10, "Unable to process inapp notification " + cTInAppNotification.getError());
        } else {
            p pVar2 = this.f10354j;
            String e11 = this.f10348c.e();
            pVar2.f(e11, "Notification ready: " + cTInAppNotification.s());
            n(cTInAppNotification);
        }
    }

    public void k(Activity activity) {
        if (j() && f10344l != null && System.currentTimeMillis() / 1000 < f10344l.A()) {
            androidx.fragment.app.h hVar = (androidx.fragment.app.h) activity;
            Fragment s02 = hVar.getSupportFragmentManager().s0(new Bundle(), f10344l.G());
            if (j.i() != null && s02 != null) {
                b0 p10 = hVar.getSupportFragmentManager().p();
                Bundle bundle = new Bundle();
                bundle.putParcelable("inApp", f10344l);
                bundle.putParcelable("config", this.f10348c);
                s02.setArguments(bundle);
                p10.u(17498112, 17498113);
                p10.c(16908290, s02, f10344l.G());
                String e10 = this.f10348c.e();
                p.p(e10, "calling InAppFragment " + f10344l.h());
                p10.i();
            }
        }
    }

    public void l(Activity activity) {
        String str;
        if (!j()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("In-app notifications will not be shown for this activity (");
            if (activity != null) {
                str = activity.getLocalClassName();
            } else {
                str = "";
            }
            sb2.append(str);
            sb2.append(")");
            p.a(sb2.toString());
        } else if (this.f10355k.a() != null) {
            this.f10354j.t(this.f10348c.e(), "Found a pending inapp runnable. Scheduling it");
            u4.a aVar = this.f10355k;
            aVar.postDelayed(aVar.a(), 200);
            this.f10355k.b((Runnable) null);
        } else {
            s(this.f10349d);
        }
    }

    public void s(Context context) {
        if (!this.f10348c.p()) {
            com.clevertap.android.sdk.task.a.a(this.f10348c).d("TAG_FEATURE_IN_APPS").f("InappController#showNotificationIfAvailable", new c(context));
        }
    }

    public void y(CTInAppNotification cTInAppNotification, Bundle bundle, HashMap<String, String> hashMap) {
        this.f10346a.C(true, cTInAppNotification, bundle);
        if (hashMap != null && !hashMap.isEmpty() && this.f10347b.f() != null) {
            this.f10347b.f().a(hashMap);
        }
    }
}
