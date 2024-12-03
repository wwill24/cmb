package e7;

import a7.a;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import hb.c;
import java.util.HashMap;

public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private b f14584a;

    /* renamed from: b  reason: collision with root package name */
    private final a f14585b;

    /* renamed from: c  reason: collision with root package name */
    private final c f14586c;

    public d(a aVar, Context context, c cVar, String str) {
        this.f14585b = aVar;
        this.f14586c = cVar;
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage != null) {
            ComponentName component = launchIntentForPackage.getComponent();
            if (!TextUtils.isEmpty(str)) {
                this.f14584a = c(context, str, component);
            }
        }
    }

    private static b c(Context context, String str, ComponentName componentName) {
        String lowerCase = str.toLowerCase();
        lowerCase.hashCode();
        char c10 = 65535;
        switch (lowerCase.hashCode()) {
            case -759499589:
                if (lowerCase.equals("xiaomi")) {
                    c10 = 0;
                    break;
                }
                break;
            case 103639:
                if (lowerCase.equals("htc")) {
                    c10 = 1;
                    break;
                }
                break;
            case 107082:
                if (lowerCase.equals("lge")) {
                    c10 = 2;
                    break;
                }
                break;
            case 3003984:
                if (lowerCase.equals("asus")) {
                    c10 = 3;
                    break;
                }
                break;
            case 3536167:
                if (lowerCase.equals("sony")) {
                    c10 = 4;
                    break;
                }
                break;
            case 1864941562:
                if (lowerCase.equals("samsung")) {
                    c10 = 5;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return new j(context, componentName);
            case 1:
                return new f(context, componentName);
            case 2:
                return new g(context, componentName);
            case 3:
                return new a(context, componentName);
            case 4:
                return new i(context, componentName);
            case 5:
                return new h(context, componentName);
            default:
                return null;
        }
    }

    public void a() {
        b bVar = this.f14584a;
        if (bVar != null) {
            try {
                bVar.clear();
                this.f14586c.c("APP_BADGE_COUNT", 0);
                this.f14586c.f("APP_BADGE_SHOWN", false);
            } catch (Exception e10) {
                fa.a.i(e10);
            }
        }
    }

    public void b(int i10) {
        b bVar = this.f14584a;
        if (bVar != null) {
            try {
                bVar.a(i10);
                this.f14586c.c("APP_BADGE_COUNT", i10);
                if (!this.f14586c.n("APP_BADGE_SHOWN", false)) {
                    this.f14585b.trackEvent("App Badge Displayed", new HashMap());
                    this.f14586c.f("APP_BADGE_SHOWN", true);
                }
            } catch (Exception e10) {
                fa.a.i(e10);
            }
        }
    }

    public int getCount() {
        return Math.max(this.f14586c.l("APP_BADGE_COUNT"), 0);
    }
}
