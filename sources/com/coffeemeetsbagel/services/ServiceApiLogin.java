package com.coffeemeetsbagel.services;

import android.content.Intent;
import android.text.TextUtils;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.bakery.i1;
import com.coffeemeetsbagel.models.BannedReason;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.VerificationStatus;
import com.coffeemeetsbagel.models.enums.HttpMethod;
import com.coffeemeetsbagel.models.responses.ResponseLogin;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.facebook.AccessToken;
import h5.l;
import java.util.Collection;
import jc.a;
import lc.e;
import lc.g;
import lc.r;
import okhttp3.a0;
import okhttp3.x;
import org.json.JSONException;
import org.json.b;

public class ServiceApiLogin extends a {
    private static ResponseLogin e() {
        x d10 = r.d();
        b bVar = new b();
        try {
            bVar.put("access_token", (Object) l.j());
            bVar.put("app_version", 13778);
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (currentAccessToken != null) {
                bVar.put("permissions", (Object) new org.json.a((Collection<?>) currentAccessToken.getPermissions()));
            }
        } catch (JSONException e10) {
            fa.a.g("ServiceApiLogin", "Invalid #login request body", e10);
        }
        try {
            a0 f10 = d10.a(e.c(i1.b.a(), HttpMethod.POST, bVar.toString(), (String) null)).f();
            int f11 = f10.f();
            String string = f10.a().string();
            ResponseLogin responseLogin = (ResponseLogin) new j6.a().a(string, ResponseLogin.class);
            responseLogin.setStatusCode(f11);
            if (f11 == 200) {
                if (g.c() && Bakery.w().M().j(g.c()) != null) {
                    responseLogin.setProfileId(Bakery.w().M().j(g.c()));
                }
                return responseLogin;
            } else if (i1.e(f11)) {
                String errorRedirectLink = responseLogin.getErrorRedirectLink();
                String errorMessage = responseLogin.getErrorMessage();
                if (!TextUtils.isEmpty(errorRedirectLink)) {
                    responseLogin.setErrorCode(3);
                    return responseLogin;
                } else if (!TextUtils.isEmpty(errorMessage)) {
                    responseLogin.setErrorCode(4);
                    return responseLogin;
                } else {
                    responseLogin.setErrorCode(4);
                    responseLogin.setErrorMessage(Bakery.w().getResources().getString(R.string.server_error_gateway));
                    return responseLogin;
                }
            } else if (f11 == 500) {
                responseLogin.setErrorCode(4);
                responseLogin.setErrorMessage(Bakery.w().getResources().getString(R.string.server_error_internal));
                return responseLogin;
            } else if (f11 == 401) {
                BannedReason fromJsonString = BannedReason.Companion.fromJsonString(string);
                VerificationStatus fromJsonString2 = VerificationStatus.Companion.fromJsonString(string);
                if (fromJsonString != BannedReason.NONE) {
                    responseLogin.setErrorCode(new CmbErrorCode("", 401, fromJsonString, fromJsonString2));
                } else {
                    responseLogin.setErrorCode(401);
                    responseLogin.setErrorMessage(Bakery.w().getResources().getString(R.string.server_error_internal));
                }
                return responseLogin;
            } else {
                responseLogin.setErrorCode(0);
                responseLogin.setErrorMessage("Unknown message");
                return responseLogin;
            }
        } catch (Exception e11) {
            fa.a.g("ServiceApiLogin", "failed to login", e11);
            ResponseLogin responseLogin2 = new ResponseLogin("Error", 500);
            responseLogin2.setErrorCode(0);
            return responseLogin2;
        }
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        super.onHandleIntent(intent);
        ResponseLogin e10 = e();
        if (e10.isSuccessful()) {
            d(this.f41052b, new SuccessStatus("Login successful"), e10);
        } else if (e10.getErrorCode().getErrorCode() == 3) {
            c(this.f41052b, new CmbErrorCode(e10.getErrorRedirectLink(), 3));
        } else if (e10.getErrorCode().getErrorCode() == 4) {
            c(this.f41052b, new CmbErrorCode(e10.getErrorMessage(), 4));
        } else {
            c(this.f41052b, e10.getErrorCode().setErrorMessage("Could not login"));
        }
    }
}
