package com.coffeemeetsbagel.phone_login;

import com.coffeemeetsbagel.phone_login.PhoneErrorCodes;
import com.coffeemeetsbagel.phone_login.api.models.VerifyCodeResponse;
import com.coffeemeetsbagel.phone_login.api.models.VerifyPhoneNumberResponse;
import java.io.IOException;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.h;
import okhttp3.b0;
import org.json.JSONException;
import org.json.b;
import qa.a;

public final class PhoneLoginRepository {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f35692a;

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineDispatcher f35693b;

    /* renamed from: c  reason: collision with root package name */
    private final String f35694c = "PhoneLoginRepository";

    public PhoneLoginRepository(a aVar, CoroutineDispatcher coroutineDispatcher) {
        j.g(aVar, "phoneLoginApi");
        j.g(coroutineDispatcher, "ioDispatcher");
        this.f35692a = aVar;
        this.f35693b = coroutineDispatcher;
    }

    /* access modifiers changed from: private */
    public final PhoneErrorCodes c(b0 b0Var, int i10) {
        String str;
        fa.a.f40771d.a(this.f35694c, "getErrorCodeFromJsonOrHttpCode(): ");
        try {
            if (b0Var == null || (str = b0Var.string()) == null) {
                str = "";
            }
            b bVar = new b(str);
            PhoneErrorCodes.a aVar = PhoneErrorCodes.f35682a;
            String string = bVar.getString("error");
            j.f(string, "errorJSON.getString(\"error\")");
            return aVar.a(string);
        } catch (JSONException unused) {
            if (i10 == 429) {
                return PhoneErrorCodes.TOO_MANY_ATTEMPTS;
            }
            return PhoneErrorCodes.OTHER_ERROR;
        } catch (IOException unused2) {
            if (i10 == 429) {
                return PhoneErrorCodes.TOO_MANY_ATTEMPTS;
            }
            return PhoneErrorCodes.OTHER_ERROR;
        }
    }

    public final Object d(String str, String str2, c<? super VerifyCodeResponse> cVar) {
        return h.g(this.f35693b, new PhoneLoginRepository$verifyCode$2(this, str2, str, (c<? super PhoneLoginRepository$verifyCode$2>) null), cVar);
    }

    public final Object e(String str, c<? super VerifyPhoneNumberResponse> cVar) {
        return h.g(this.f35693b, new PhoneLoginRepository$verifyPhoneNumber$2(this, str, (c<? super PhoneLoginRepository$verifyPhoneNumber$2>) null), cVar);
    }
}
