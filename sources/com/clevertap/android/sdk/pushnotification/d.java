package com.clevertap.android.sdk.pushnotification;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.p;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.facebook.internal.ServerProtocol;
import i4.x;
import o4.b;
import org.json.a;

public class d implements e, b {

    /* renamed from: a  reason: collision with root package name */
    private String f10717a;

    /* renamed from: b  reason: collision with root package name */
    private String f10718b;

    /* renamed from: c  reason: collision with root package name */
    private int f10719c;

    public p.e a(Context context, Bundle bundle, p.e eVar, CleverTapInstanceConfig cleverTapInstanceConfig) {
        try {
            if (bundle.containsKey("wzrk_sound")) {
                Uri uri = null;
                Object obj = bundle.get("wzrk_sound");
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    uri = RingtoneManager.getDefaultUri(2);
                } else if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        uri = RingtoneManager.getDefaultUri(2);
                    } else if (!str.isEmpty()) {
                        if (str.contains(".mp3") || str.contains(".ogg") || str.contains(".wav")) {
                            str = str.substring(0, str.length() - 4);
                        }
                        uri = Uri.parse("android.resource://" + context.getPackageName() + "/raw/" + str);
                    }
                }
                if (uri != null) {
                    eVar.y(uri);
                }
            }
        } catch (Throwable th2) {
            cleverTapInstanceConfig.n().g(cleverTapInstanceConfig.e(), "Could not process sound parameter", th2);
        }
        return eVar;
    }

    public String c(Bundle bundle, Context context) {
        String string = bundle.getString("nt", "");
        if (string.isEmpty()) {
            string = context.getApplicationInfo().name;
        }
        this.f10718b = string;
        return string;
    }

    public String d() {
        return "ico";
    }

    public p.e e(Bundle bundle, Context context, p.e eVar, CleverTapInstanceConfig cleverTapInstanceConfig, int i10) {
        p.f fVar;
        a aVar;
        String string = bundle.getString("ico");
        String string2 = bundle.getString("wzrk_bp");
        boolean z10 = false;
        if (string2 == null || !string2.startsWith("http")) {
            fVar = new p.c().h(this.f10717a);
        } else {
            try {
                Bitmap n10 = x.n(string2, false, context);
                if (n10 == null) {
                    throw new Exception("Failed to fetch big picture!");
                } else if (bundle.containsKey("wzrk_nms")) {
                    fVar = new p.b().k(bundle.getString("wzrk_nms")).i(n10);
                } else {
                    fVar = new p.b().k(this.f10717a).i(n10);
                }
            } catch (Throwable th2) {
                p.c h10 = new p.c().h(this.f10717a);
                cleverTapInstanceConfig.n().u(cleverTapInstanceConfig.e(), "Falling back to big text notification, couldn't fetch big picture", th2);
                fVar = h10;
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            z10 = true;
        }
        if (z10 && bundle.containsKey("wzrk_st")) {
            eVar.A(bundle.getString("wzrk_st"));
        }
        if (bundle.containsKey("wzrk_clr")) {
            eVar.i(Color.parseColor(bundle.getString("wzrk_clr")));
            eVar.j(true);
        }
        eVar.m(this.f10718b).l(this.f10717a).k(f.b(bundle, context)).f(true).z(fVar).x(this.f10719c);
        eVar.q(x.n(string, true, context));
        String string3 = bundle.getString("wzrk_acts");
        if (string3 != null) {
            try {
                aVar = new a(string3);
            } catch (Throwable th3) {
                cleverTapInstanceConfig.n().f(cleverTapInstanceConfig.e(), "error parsing notification actions: " + th3.getLocalizedMessage());
            }
            b(context, bundle, i10, eVar, aVar);
            return eVar;
        }
        aVar = null;
        b(context, bundle, i10, eVar, aVar);
        return eVar;
    }

    public void f(int i10, Context context) {
        this.f10719c = i10;
    }

    public Object g(Bundle bundle) {
        return bundle.get("wzrk_ck");
    }

    public String h(Bundle bundle) {
        String string = bundle.getString("nm");
        this.f10717a = string;
        return string;
    }
}
