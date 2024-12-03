package com.coffeemeetsbagel.feature.authentication.api;

import android.text.TextUtils;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.bakery.i1;
import com.coffeemeetsbagel.models.BannedReason;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.VerificationStatus;
import com.coffeemeetsbagel.models.responses.ResponseLogin;
import com.coffeemeetsbagel.transport.SuccessStatus;
import jc.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import lc.g;
import okhttp3.b0;
import retrofit2.r;

final class AuthenticationApi$login$1 extends Lambda implements Function1<r<ResponseLogin>, Unit> {
    final /* synthetic */ b<ResponseLogin> $callBack;
    final /* synthetic */ AuthenticationApi this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthenticationApi$login$1(AuthenticationApi authenticationApi, b<ResponseLogin> bVar) {
        super(1);
        this.this$0 = authenticationApi;
        this.$callBack = bVar;
    }

    public final void a(r<ResponseLogin> rVar) {
        String str;
        j.g(rVar, "response");
        int b10 = rVar.b();
        ResponseLogin a10 = rVar.a();
        if (a10 == null) {
            a10 = new ResponseLogin(this.this$0.f12678a.a(R.string.server_error_internal, new Object[0]), b10);
        }
        if (rVar.g()) {
            String j10 = Bakery.w().M().j(g.c());
            if (g.c() && j10 != null) {
                a10.setProfileId(j10);
            }
            this.$callBack.a(a10, new SuccessStatus("Login successful"));
            if (this.this$0.f12682e != null) {
                tj.b e10 = this.this$0.f12682e;
                j.d(e10);
                e10.dispose();
            }
        } else if (i1.e(b10)) {
            String errorRedirectLink = a10.getErrorRedirectLink();
            String errorMessage = a10.getErrorMessage();
            if (!TextUtils.isEmpty(errorRedirectLink)) {
                this.this$0.j(this.$callBack, new CmbErrorCode(a10.getErrorRedirectLink(), 3));
            } else if (!TextUtils.isEmpty(errorMessage)) {
                this.this$0.j(this.$callBack, new CmbErrorCode(a10.getErrorMessage(), 4));
            } else {
                this.this$0.j(this.$callBack, new CmbErrorCode(Bakery.w().getResources().getString(R.string.server_error_gateway), 4));
            }
        } else if (b10 == 500) {
            this.this$0.j(this.$callBack, new CmbErrorCode(Bakery.w().getResources().getString(R.string.server_error_internal), 4));
        } else if (b10 == 401) {
            BannedReason.Companion companion = BannedReason.Companion;
            b0 e11 = rVar.e();
            String str2 = null;
            if (e11 != null) {
                str = e11.string();
            } else {
                str = null;
            }
            BannedReason fromJsonString = companion.fromJsonString(str);
            VerificationStatus.Companion companion2 = VerificationStatus.Companion;
            b0 e12 = rVar.e();
            if (e12 != null) {
                str2 = e12.string();
            }
            this.this$0.j(this.$callBack, new CmbErrorCode(Bakery.w().getResources().getString(R.string.server_error_internal), 401, fromJsonString, companion2.fromJsonString(str2)));
        } else {
            this.this$0.j(this.$callBack, new CmbErrorCode("Unknown message", 0));
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((r) obj);
        return Unit.f32013a;
    }
}
