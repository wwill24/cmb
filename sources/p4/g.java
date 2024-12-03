package p4;

import android.content.Context;
import android.text.TextUtils;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.l;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.s;
import java.util.Iterator;
import net.bytebuddy.utility.JavaConstant;
import org.json.b;
import v4.a;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final CleverTapInstanceConfig f17027a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f17028b;

    /* renamed from: c  reason: collision with root package name */
    private final l f17029c;

    public g(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, l lVar) {
        this.f17028b = context;
        this.f17027a = cleverTapInstanceConfig;
        this.f17029c = lVar;
    }

    private boolean g() {
        boolean R = this.f17029c.R();
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f17027a;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "isErrorDeviceId:[" + R + "]");
        return R;
    }

    public void a(String str, String str2, String str3) {
        if (!g() && str != null && str2 != null && str3 != null) {
            String str4 = str2 + JavaConstant.Dynamic.DEFAULT_NAME + str3;
            b c10 = c();
            try {
                c10.put(str4, (Object) str);
                l(c10);
            } catch (Throwable th2) {
                this.f17027a.n().t(this.f17027a.e(), "Error caching guid: " + th2.toString());
            }
        }
    }

    public boolean b() {
        boolean z10 = true;
        if (c().length() <= 1) {
            z10 = false;
        }
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f17027a;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "deviceIsMultiUser:[" + z10 + "]");
        return z10;
    }

    public b c() {
        String k10 = s.k(this.f17028b, this.f17027a, "cachedGUIDsKey", (String) null);
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f17027a;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "getCachedGUIDs:[" + k10 + "]");
        return a.j(k10, this.f17027a.n(), this.f17027a.e());
    }

    public String d() {
        String k10 = s.k(this.f17028b, this.f17027a, "SP_KEY_PROFILE_IDENTITIES", "");
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f17027a;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "getCachedIdentityKeysForAccount:" + k10);
        return k10;
    }

    public String e(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                String string = c().getString(str + JavaConstant.Dynamic.DEFAULT_NAME + str2);
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f17027a;
                cleverTapInstanceConfig.A("ON_USER_LOGIN", "getGUIDForIdentifier:[Key:" + str + ", value:" + string + "]");
                return string;
            } catch (Throwable th2) {
                p n10 = this.f17027a.n();
                String e10 = this.f17027a.e();
                n10.t(e10, "Error reading guid cache: " + th2.toString());
            }
        }
        return null;
    }

    public boolean f() {
        boolean z10;
        if (c().length() <= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f17027a;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "isAnonymousDevice:[" + z10 + "]");
        return z10;
    }

    public boolean h() {
        boolean z10;
        b c10 = c();
        if (c10 == null || c10.length() <= 0 || !TextUtils.isEmpty(d())) {
            z10 = false;
        } else {
            z10 = true;
        }
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f17027a;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "isLegacyProfileLoggedIn:" + z10);
        return z10;
    }

    public void i() {
        try {
            s.r(this.f17028b, s.s(this.f17027a, "cachedGUIDsKey"));
            this.f17027a.A("ON_USER_LOGIN", "removeCachedGUIDs:[]");
        } catch (Throwable th2) {
            p n10 = this.f17027a.n();
            String e10 = this.f17027a.e();
            n10.t(e10, "Error removing guid cache: " + th2.toString());
        }
    }

    public void j(String str, String str2) {
        if (!g() && str != null && str2 != null) {
            b c10 = c();
            try {
                Iterator<String> keys = c10.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.toLowerCase().contains(str2.toLowerCase()) && c10.getString(next).equals(str)) {
                        c10.remove(next);
                        if (c10.length() == 0) {
                            i();
                        } else {
                            l(c10);
                        }
                    }
                }
            } catch (Throwable th2) {
                p n10 = this.f17027a.n();
                String e10 = this.f17027a.e();
                n10.t(e10, "Error removing cached key: " + th2.toString());
            }
        }
    }

    public void k(String str) {
        s.o(this.f17028b, this.f17027a, "SP_KEY_PROFILE_IDENTITIES", str);
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f17027a;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "saveIdentityKeysForAccount:" + str);
    }

    public void l(b bVar) {
        if (bVar != null) {
            try {
                String bVar2 = bVar.toString();
                s.p(this.f17028b, s.s(this.f17027a, "cachedGUIDsKey"), bVar2);
                CleverTapInstanceConfig cleverTapInstanceConfig = this.f17027a;
                cleverTapInstanceConfig.A("ON_USER_LOGIN", "setCachedGUIDs:[" + bVar2 + "]");
            } catch (Throwable th2) {
                p n10 = this.f17027a.n();
                String e10 = this.f17027a.e();
                n10.t(e10, "Error persisting guid cache: " + th2.toString());
            }
        }
    }
}
