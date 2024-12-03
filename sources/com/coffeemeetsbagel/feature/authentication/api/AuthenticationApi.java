package com.coffeemeetsbagel.feature.authentication.api;

import android.content.Context;
import android.content.Intent;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.authentication.api.models.AuthenticateBody;
import com.coffeemeetsbagel.feature.authentication.api.models.AuthenticateResponse;
import com.coffeemeetsbagel.feature.authentication.api.models.LoginBody;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.responses.ResponseLogin;
import com.coffeemeetsbagel.services.ServiceApiLogin;
import com.coffeemeetsbagel.transport.OperationResultReceiver;
import com.facebook.AccessToken;
import d7.a;
import h5.l;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import retrofit2.d;
import retrofit2.r;
import tj.b;

public final class AuthenticationApi implements d7.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final bb.a f12678a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f12679b;

    /* renamed from: c  reason: collision with root package name */
    private final e f12680c;

    /* renamed from: d  reason: collision with root package name */
    private final t f12681d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public b f12682e;

    public static final class a implements d<AuthenticateResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.C0153a f12683a;

        a(a.C0153a aVar) {
            this.f12683a = aVar;
        }

        public void onFailure(retrofit2.b<AuthenticateResponse> bVar, Throwable th2) {
            j.g(bVar, "call");
            j.g(th2, "t");
            this.f12683a.a(-1);
        }

        public void onResponse(retrofit2.b<AuthenticateResponse> bVar, r<AuthenticateResponse> rVar) {
            j.g(bVar, "call");
            j.g(rVar, "response");
            if (rVar.g()) {
                AuthenticateResponse a10 = rVar.a();
                if (a10 != null) {
                    this.f12683a.b(a10.token);
                } else {
                    this.f12683a.a(-1);
                }
            } else {
                this.f12683a.a(rVar.b());
            }
        }
    }

    public AuthenticationApi(bb.a aVar, Context context, c7.d dVar, t tVar) {
        j.g(aVar, "stringProvider");
        j.g(context, "appContext");
        j.g(dVar, "retrofitManager");
        j.g(tVar, "remoteConfigManager");
        this.f12678a = aVar;
        this.f12679b = context;
        Object c10 = dVar.c(e.class);
        j.f(c10, "retrofitManager.getApiSe…ice::class.java\n        )");
        this.f12680c = (e) c10;
        this.f12681d = tVar;
    }

    /* access modifiers changed from: private */
    public static final void h(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void i(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void j(jc.b<ResponseLogin> bVar, CmbErrorCode cmbErrorCode) {
        bVar.b(cmbErrorCode);
        b bVar2 = this.f12682e;
        if (bVar2 != null) {
            j.d(bVar2);
            bVar2.dispose();
        }
    }

    public void a(jc.b<ResponseLogin> bVar) {
        Set<String> set;
        j.g(bVar, "callBack");
        if (this.f12681d.s()) {
            AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
            String j10 = l.j();
            if (currentAccessToken != null) {
                set = currentAccessToken.getPermissions();
            } else {
                set = null;
            }
            this.f12682e = this.f12680c.a(new LoginBody(j10, 13778, set)).K(dk.a.c()).E(sj.a.a()).b(new a(new AuthenticationApi$login$1(this, bVar)), new b(new AuthenticationApi$login$2(this, bVar)));
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this.f12679b, ServiceApiLogin.class);
        intent.putExtra("ResultReceiver", new OperationResultReceiver(bVar));
        this.f12679b.startService(intent);
    }

    public void b(String str, a.C0153a aVar) {
        j.g(str, "fbAuthToken");
        j.g(aVar, "authenticateCallback");
        this.f12680c.b(new AuthenticateBody(str)).L(new a(aVar));
    }
}
