package qa;

import c7.d;
import com.coffeemeetsbagel.models.VerifyCodeBody;
import com.coffeemeetsbagel.models.VerifyPhoneNumberBody;
import com.coffeemeetsbagel.phone_login.api.models.VerifyCodeResponse;
import com.coffeemeetsbagel.phone_login.api.models.VerifyPhoneNumberResponse;
import ga.b;
import kotlin.jvm.internal.j;
import qj.w;
import retrofit2.r;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private d f41795a;

    /* renamed from: b  reason: collision with root package name */
    private b f41796b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f41797c;

    public a(d dVar, b bVar, boolean z10) {
        j.g(dVar, "retrofitManager");
        j.g(bVar, "rlcsCrypto");
        this.f41795a = dVar;
        this.f41796b = bVar;
        this.f41797c = z10;
    }

    public final String a() {
        try {
            String e10 = lc.d.e(this.f41796b.a(String.valueOf(System.currentTimeMillis() / ((long) 1000))));
            j.f(e10, "encode(encrypted)");
            return e10;
        } catch (Exception e11) {
            fa.a.f40771d.c("PhoneLoginApi", "Exception generating VEM.", e11);
            return "";
        }
    }

    public final w<r<VerifyCodeResponse>> b(String str, String str2) {
        j.g(str, "phoneNumber");
        j.g(str2, "code");
        return ((b) this.f41795a.c(b.class)).a(new VerifyCodeBody(str, str2));
    }

    public final w<r<VerifyPhoneNumberResponse>> c(String str) {
        String str2;
        if (this.f41797c) {
            str2 = a();
        } else {
            str2 = "";
        }
        return ((b) this.f41795a.c(b.class)).b(new VerifyPhoneNumberBody(str, str2));
    }
}
