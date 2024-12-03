package com.clevertap.android.sdk.pushnotification;

import android.content.Context;
import android.os.Bundle;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import o4.d;

public class h implements o4.a {

    private static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final h f10727a = new h();
    }

    public static d d() {
        return b.f10727a;
    }

    public static boolean e(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString("pt_id");
        if ("0".equals(string) || string == null || string.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean f(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return "signedcall".equals(bundle.getString("source"));
    }

    public boolean a(Context context, String str, String str2) {
        PushConstants.PushType pushType = PushConstants.PushType.FCM;
        if (str2.equals(pushType.h())) {
            CleverTapAPI.f0(context, str, pushType);
            return true;
        }
        PushConstants.PushType pushType2 = PushConstants.PushType.HPS;
        if (str2.equals(pushType2.h())) {
            CleverTapAPI.f0(context, str, pushType2);
            return true;
        }
        PushConstants.PushType pushType3 = PushConstants.PushType.XPS;
        if (!str2.equals(pushType3.h())) {
            return true;
        }
        CleverTapAPI.f0(context, str, pushType3);
        return true;
    }

    public boolean b(Context context, Bundle bundle, int i10) {
        return false;
    }

    public synchronized boolean c(Context context, Bundle bundle, String str) {
        CleverTapAPI x10 = CleverTapAPI.x(context, i.a(bundle));
        if (!CleverTapAPI.B(bundle).f10725a) {
            return false;
        }
        if (x10 != null) {
            CleverTapInstanceConfig e10 = x10.s().e();
            e10.A("PushProvider", str + "received notification from CleverTap: " + bundle.toString());
            if (e(bundle) && CleverTapAPI.A() != null) {
                CleverTapAPI.A().c(context, bundle, str);
            } else if (!f(bundle) || CleverTapAPI.C() == null) {
                x10.Y(new d(), context, bundle);
            } else {
                CleverTapAPI.C().c(context, bundle, str);
            }
        } else {
            p.b("PushProvider", str + "received notification from CleverTap: " + bundle.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" not renderning since cleverTapAPI is null");
            p.b("PushProvider", sb2.toString());
        }
        return true;
    }

    private h() {
    }
}
