package com.clevertap.android.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.mparticle.kits.AppsFlyerKit;
import i4.h;

public class q {

    /* renamed from: b  reason: collision with root package name */
    private static String f10754b;

    /* renamed from: c  reason: collision with root package name */
    private static String f10755c;

    /* renamed from: d  reason: collision with root package name */
    private static String f10756d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f10757e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f10758f;

    /* renamed from: g  reason: collision with root package name */
    private static String f10759g;

    /* renamed from: h  reason: collision with root package name */
    private static q f10760h;

    /* renamed from: i  reason: collision with root package name */
    private static String f10761i;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f10762j;

    /* renamed from: k  reason: collision with root package name */
    private static boolean f10763k;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f10764l;

    /* renamed from: m  reason: collision with root package name */
    private static String f10765m;

    /* renamed from: n  reason: collision with root package name */
    private static String f10766n;

    /* renamed from: o  reason: collision with root package name */
    private static boolean f10767o;

    /* renamed from: p  reason: collision with root package name */
    private static String f10768p;

    /* renamed from: q  reason: collision with root package name */
    private static String f10769q;

    /* renamed from: r  reason: collision with root package name */
    private static String f10770r;

    /* renamed from: a  reason: collision with root package name */
    private final String[] f10771a;

    private q(Context context) {
        Bundle bundle;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (Throwable unused) {
            bundle = null;
        }
        bundle = bundle == null ? new Bundle() : bundle;
        if (f10754b == null) {
            f10754b = a(bundle, "CLEVERTAP_ACCOUNT_ID");
        }
        if (f10755c == null) {
            f10755c = a(bundle, "CLEVERTAP_TOKEN");
        }
        if (f10756d == null) {
            f10756d = a(bundle, "CLEVERTAP_REGION");
        }
        f10759g = a(bundle, "CLEVERTAP_NOTIFICATION_ICON");
        f10757e = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(a(bundle, "CLEVERTAP_USE_GOOGLE_AD_ID"));
        f10758f = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(a(bundle, "CLEVERTAP_DISABLE_APP_LAUNCHED"));
        f10761i = a(bundle, "CLEVERTAP_INAPP_EXCLUDE");
        f10762j = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(a(bundle, "CLEVERTAP_SSL_PINNING"));
        f10763k = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(a(bundle, "CLEVERTAP_BACKGROUND_SYNC"));
        f10764l = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(a(bundle, "CLEVERTAP_USE_CUSTOM_ID"));
        String a10 = a(bundle, "FCM_SENDER_ID");
        f10765m = a10;
        if (a10 != null) {
            f10765m = a10.replace("id:", "");
        }
        f10766n = a(bundle, "CLEVERTAP_APP_PACKAGE");
        f10767o = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(a(bundle, "CLEVERTAP_BETA"));
        if (f10768p == null) {
            f10768p = a(bundle, "CLEVERTAP_INTENT_SERVICE");
        }
        if (f10769q == null) {
            f10769q = a(bundle, "CLEVERTAP_XIAOMI_APP_KEY");
        }
        if (f10770r == null) {
            f10770r = a(bundle, "CLEVERTAP_XIAOMI_APP_ID");
        }
        this.f10771a = p(bundle);
    }

    private static String a(Bundle bundle, String str) {
        try {
            Object obj = bundle.get(str);
            if (obj != null) {
                return obj.toString();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static synchronized q h(Context context) {
        q qVar;
        synchronized (q.class) {
            if (f10760h == null) {
                f10760h = new q(context);
            }
            qVar = f10760h;
        }
        return qVar;
    }

    private String[] p(Bundle bundle) {
        String a10 = a(bundle, "CLEVERTAP_IDENTIFIER");
        if (!TextUtils.isEmpty(a10)) {
            return a10.split(AppsFlyerKit.COMMA);
        }
        return h.f15492e;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return f10767o;
    }

    public String c() {
        return f10754b;
    }

    public String d() {
        p.o("ManifestInfo: getAccountRegion called, returning region:" + f10756d);
        return f10756d;
    }

    /* access modifiers changed from: package-private */
    public String e() {
        return f10755c;
    }

    public String f() {
        return f10761i;
    }

    public String g() {
        return f10765m;
    }

    public String i() {
        return f10768p;
    }

    public String j() {
        return f10759g;
    }

    /* access modifiers changed from: package-private */
    public String k() {
        return f10766n;
    }

    public String[] l() {
        return this.f10771a;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return f10758f;
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return f10763k;
    }

    public boolean o() {
        return f10762j;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return f10764l;
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return f10757e;
    }
}
