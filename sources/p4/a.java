package p4;

import android.content.Context;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.l;
import w4.c;
import w4.d;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private d f16999a;

    /* renamed from: b  reason: collision with root package name */
    private final g f17000b;

    /* renamed from: c  reason: collision with root package name */
    private final CleverTapInstanceConfig f17001c;

    /* renamed from: d  reason: collision with root package name */
    private final d f17002d;

    public a(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, l lVar, d dVar) {
        this(cleverTapInstanceConfig, new g(context, cleverTapInstanceConfig, lVar), dVar);
    }

    private void c(d dVar, d dVar2) {
        if (!dVar.f() || !dVar2.f() || dVar.equals(dVar2)) {
            CleverTapInstanceConfig cleverTapInstanceConfig = this.f17001c;
            cleverTapInstanceConfig.A("ON_USER_LOGIN", "ConfigurableIdentityRepoNo error found while comparing [Pref:" + dVar + "], [Config:" + dVar2 + "]");
            return;
        }
        this.f17002d.b(c.a(531));
        CleverTapInstanceConfig cleverTapInstanceConfig2 = this.f17001c;
        cleverTapInstanceConfig2.A("ON_USER_LOGIN", "ConfigurableIdentityRepopushing error due to mismatch [Pref:" + dVar + "], [Config:" + dVar2 + "]");
    }

    public boolean a(@NonNull String str) {
        boolean a10 = this.f16999a.a(str);
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f17001c;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "ConfigurableIdentityRepoisIdentity [Key: " + str + " , Value: " + a10 + "]");
        return a10;
    }

    public d b() {
        return this.f16999a;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        d b10 = d.b(this.f17000b.d());
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f17001c;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "ConfigurableIdentityRepoPrefIdentitySet [" + b10 + "]");
        d c10 = d.c(this.f17001c.m());
        CleverTapInstanceConfig cleverTapInstanceConfig2 = this.f17001c;
        cleverTapInstanceConfig2.A("ON_USER_LOGIN", "ConfigurableIdentityRepoConfigIdentitySet [" + c10 + "]");
        c(b10, c10);
        if (b10.f()) {
            this.f16999a = b10;
            CleverTapInstanceConfig cleverTapInstanceConfig3 = this.f17001c;
            cleverTapInstanceConfig3.A("ON_USER_LOGIN", "ConfigurableIdentityRepoIdentity Set activated from Pref[" + this.f16999a + "]");
        } else if (c10.f()) {
            this.f16999a = c10;
            CleverTapInstanceConfig cleverTapInstanceConfig4 = this.f17001c;
            cleverTapInstanceConfig4.A("ON_USER_LOGIN", "ConfigurableIdentityRepoIdentity Set activated from Config[" + this.f16999a + "]");
        } else {
            this.f16999a = d.d();
            CleverTapInstanceConfig cleverTapInstanceConfig5 = this.f17001c;
            cleverTapInstanceConfig5.A("ON_USER_LOGIN", "ConfigurableIdentityRepoIdentity Set activated from Default[" + this.f16999a + "]");
        }
        if (!b10.f()) {
            String dVar = this.f16999a.toString();
            this.f17000b.k(dVar);
            CleverTapInstanceConfig cleverTapInstanceConfig6 = this.f17001c;
            cleverTapInstanceConfig6.A("ON_USER_LOGIN", "ConfigurableIdentityRepoSaving Identity Keys in Pref[" + dVar + "]");
        }
    }

    public a(CleverTapInstanceConfig cleverTapInstanceConfig, g gVar, d dVar) {
        this.f17001c = cleverTapInstanceConfig;
        this.f17000b = gVar;
        this.f17002d = dVar;
        d();
    }
}
