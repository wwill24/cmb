package com.coffeemeetsbagel.feature.instagram.login;

import b8.b;
import com.coffeemeetsbagel.feature.instagram.InstagramContract$Manager;

public class a implements b8.a {

    /* renamed from: a  reason: collision with root package name */
    private final InstagramContract$Manager f13032a;

    /* renamed from: b  reason: collision with root package name */
    private b f13033b;

    /* renamed from: com.coffeemeetsbagel.feature.instagram.login.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0138a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13034a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.coffeemeetsbagel.feature.instagram.InstagramContract$Manager$AuthUrlType[] r0 = com.coffeemeetsbagel.feature.instagram.InstagramContract$Manager.AuthUrlType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13034a = r0
                com.coffeemeetsbagel.feature.instagram.InstagramContract$Manager$AuthUrlType r1 = com.coffeemeetsbagel.feature.instagram.InstagramContract$Manager.AuthUrlType.USER_HAS_AUTHED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f13034a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.feature.instagram.InstagramContract$Manager$AuthUrlType r1 = com.coffeemeetsbagel.feature.instagram.InstagramContract$Manager.AuthUrlType.USER_DENIED_AUTH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f13034a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.coffeemeetsbagel.feature.instagram.InstagramContract$Manager$AuthUrlType r1 = com.coffeemeetsbagel.feature.instagram.InstagramContract$Manager.AuthUrlType.AUTH_ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f13034a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.coffeemeetsbagel.feature.instagram.InstagramContract$Manager$AuthUrlType r1 = com.coffeemeetsbagel.feature.instagram.InstagramContract$Manager.AuthUrlType.NONE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.feature.instagram.login.a.C0138a.<clinit>():void");
        }
    }

    a(InstagramContract$Manager instagramContract$Manager, b bVar) {
        this.f13032a = instagramContract$Manager;
        this.f13033b = bVar;
    }

    public boolean a(String str) {
        InstagramContract$Manager.AuthUrlType b10 = this.f13032a.b(str);
        if (b10 == null) {
            return false;
        }
        int i10 = C0138a.f13034a[b10.ordinal()];
        if (i10 == 1) {
            this.f13033b.a();
            return true;
        } else if (i10 == 2) {
            this.f13033b.N();
            return true;
        } else if (i10 != 3) {
            return false;
        } else {
            this.f13033b.C();
            return true;
        }
    }

    public void start() {
        if (this.f13032a.isLoggedIn()) {
            this.f13033b.a();
            return;
        }
        this.f13033b.T();
        this.f13033b.G(this.f13032a.a());
    }

    public void stop() {
        this.f13033b = null;
    }
}
