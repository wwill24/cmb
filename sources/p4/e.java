package p4;

import androidx.annotation.NonNull;
import com.clevertap.android.sdk.CleverTapInstanceConfig;

public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    private d f17004a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapInstanceConfig f17005b;

    public e(CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.f17005b = cleverTapInstanceConfig;
        c();
    }

    private void c() {
        this.f17004a = d.d();
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f17005b;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "LegacyIdentityRepo Setting the default IdentitySet[" + this.f17004a + "]");
    }

    public boolean a(@NonNull String str) {
        boolean a10 = this.f17004a.a(str);
        CleverTapInstanceConfig cleverTapInstanceConfig = this.f17005b;
        cleverTapInstanceConfig.A("ON_USER_LOGIN", "isIdentity [Key: " + str + " , Value: " + a10 + "]");
        return a10;
    }

    public d b() {
        return this.f17004a;
    }
}
