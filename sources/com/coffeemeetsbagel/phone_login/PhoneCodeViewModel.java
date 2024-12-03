package com.coffeemeetsbagel.phone_login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.t;
import com.coffeemeetsbagel.country.CmbCountry;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.phone_login.api.models.VerifyCodeResponse;
import com.coffeemeetsbagel.phone_login.api.models.VerifyPhoneNumberResponse;
import fa.a;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.s1;

public final class PhoneCodeViewModel extends f0 {

    /* renamed from: d  reason: collision with root package name */
    private final PhoneLoginRepository f35652d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final t<VerifyPhoneNumberResponse> f35653e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final t<VerifyCodeResponse> f35654f;

    /* renamed from: g  reason: collision with root package name */
    private final t<ViewState> f35655g;

    /* renamed from: h  reason: collision with root package name */
    private final t<CmbErrorCode> f35656h;

    /* renamed from: i  reason: collision with root package name */
    private final t<CmbCountry> f35657i;

    /* renamed from: j  reason: collision with root package name */
    private final LiveData<VerifyPhoneNumberResponse> f35658j;

    /* renamed from: k  reason: collision with root package name */
    private final LiveData<VerifyCodeResponse> f35659k;

    /* renamed from: l  reason: collision with root package name */
    private final LiveData<ViewState> f35660l;

    /* renamed from: m  reason: collision with root package name */
    private final LiveData<CmbErrorCode> f35661m;

    /* renamed from: n  reason: collision with root package name */
    private final LiveData<CmbCountry> f35662n;

    /* renamed from: o  reason: collision with root package name */
    private String f35663o = "";

    /* renamed from: p  reason: collision with root package name */
    private String f35664p = "";

    /* renamed from: q  reason: collision with root package name */
    private boolean f35665q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f35666r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f35667s;

    /* renamed from: t  reason: collision with root package name */
    private int f35668t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public final String f35669u = "PhoneCodeViewModel";

    /* renamed from: v  reason: collision with root package name */
    private final g0 f35670v;

    /* renamed from: w  reason: collision with root package name */
    private final g0 f35671w;

    public enum ViewState {
        PHONE,
        CODE,
        COUNTRY,
        MAINTENANCE,
        AUTHENTICATED,
        AUTH_FAILED,
        BANNED
    }

    public static final class a extends kotlin.coroutines.a implements g0 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PhoneCodeViewModel f35680b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g0.a aVar, PhoneCodeViewModel phoneCodeViewModel) {
            super(aVar);
            this.f35680b = phoneCodeViewModel;
        }

        public void P(CoroutineContext coroutineContext, Throwable th2) {
            fa.a.f40771d.c(this.f35680b.f35669u, "Error in verifyPhoneNumber", th2);
            this.f35680b.f35653e.o(new VerifyPhoneNumberResponse(th2.getMessage(), "0", PhoneErrorCodes.OTHER_ERROR.b(), VerifyPhoneNumberResponse.VerifyType.SMS.name()));
        }
    }

    public static final class b extends kotlin.coroutines.a implements g0 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PhoneCodeViewModel f35681b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g0.a aVar, PhoneCodeViewModel phoneCodeViewModel) {
            super(aVar);
            this.f35681b = phoneCodeViewModel;
        }

        public void P(CoroutineContext coroutineContext, Throwable th2) {
            fa.a.f40771d.c(this.f35681b.f35669u, "Error in verifyPhoneCode", th2);
            this.f35681b.f35654f.o(new VerifyCodeResponse("", PhoneErrorCodes.OTHER_ERROR.b()));
        }
    }

    public PhoneCodeViewModel(PhoneLoginRepository phoneLoginRepository) {
        j.g(phoneLoginRepository, "loginRepository");
        this.f35652d = phoneLoginRepository;
        t<VerifyPhoneNumberResponse> tVar = new t<>();
        this.f35653e = tVar;
        t<VerifyCodeResponse> tVar2 = new t<>();
        this.f35654f = tVar2;
        t<ViewState> tVar3 = new t<>(ViewState.PHONE);
        this.f35655g = tVar3;
        t<CmbErrorCode> tVar4 = new t<>();
        this.f35656h = tVar4;
        t<CmbCountry> tVar5 = new t<>();
        this.f35657i = tVar5;
        this.f35658j = tVar;
        this.f35659k = tVar2;
        this.f35660l = tVar3;
        this.f35661m = tVar4;
        this.f35662n = tVar5;
        g0.a aVar = g0.f32489u;
        this.f35670v = new a(aVar, this);
        this.f35671w = new b(aVar, this);
    }

    public final void A(int i10) {
        this.f35668t = i10;
    }

    public final void B(String str) {
        j.g(str, "<set-?>");
        this.f35663o = str;
    }

    public final void C(ViewState viewState) {
        j.g(viewState, "state");
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f35669u;
        aVar.a(str, "setViewState: " + viewState);
        this.f35655g.o(viewState);
    }

    public final void D(String str) {
        j.g(str, "code");
        s1 unused = j.d(androidx.lifecycle.g0.a(this), this.f35671w, (CoroutineStart) null, new PhoneCodeViewModel$verifyPhoneCode$1(this, str, (c<? super PhoneCodeViewModel$verifyPhoneCode$1>) null), 2, (Object) null);
    }

    public final void E(String str) {
        j.g(str, "formatttedPhoneNumber");
        this.f35664p = str;
        s1 unused = j.d(androidx.lifecycle.g0.a(this), this.f35670v, (CoroutineStart) null, new PhoneCodeViewModel$verifyPhoneNumber$1(this, str, (c<? super PhoneCodeViewModel$verifyPhoneNumber$1>) null), 2, (Object) null);
    }

    public final LiveData<CmbCountry> i() {
        return this.f35662n;
    }

    public final LiveData<CmbErrorCode> j() {
        return this.f35661m;
    }

    public final boolean k() {
        return this.f35666r;
    }

    public final boolean l() {
        return this.f35665q;
    }

    public final boolean m() {
        return this.f35667s;
    }

    public final String n() {
        return this.f35664p;
    }

    public final int o() {
        return this.f35668t;
    }

    public final PhoneLoginRepository p() {
        return this.f35652d;
    }

    public final String q() {
        return this.f35663o;
    }

    public final LiveData<VerifyCodeResponse> r() {
        return this.f35659k;
    }

    public final LiveData<VerifyPhoneNumberResponse> s() {
        return this.f35658j;
    }

    public final LiveData<ViewState> t() {
        return this.f35660l;
    }

    public final void u() {
        this.f35654f.o(null);
        this.f35653e.o(null);
    }

    public final void v(CmbErrorCode cmbErrorCode) {
        j.g(cmbErrorCode, "cmbErrorCode");
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f35669u;
        aVar.a(str, "setCmbError: " + cmbErrorCode);
        this.f35656h.o(cmbErrorCode);
    }

    public final void w(CmbCountry cmbCountry) {
        j.g(cmbCountry, "supportedCountry");
        this.f35657i.o(cmbCountry);
    }

    public final void x(boolean z10) {
        this.f35666r = z10;
    }

    public final void y(boolean z10) {
        this.f35665q = z10;
    }

    public final void z(boolean z10) {
        this.f35667s = z10;
    }
}
