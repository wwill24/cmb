package com.coffeemeetsbagel.phone_login.verification_code;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.lifecycle.i0;
import androidx.lifecycle.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.bakery.g1;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.models.BannedReason;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.enums.UpgradeAvailability;
import com.coffeemeetsbagel.phone_login.PhoneCodeViewModel;
import com.coffeemeetsbagel.phone_login.PhoneErrorCodes;
import com.coffeemeetsbagel.phone_login.api.models.VerifyCodeResponse;
import com.coffeemeetsbagel.phone_login.api.models.VerifyPhoneNumberResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.api.Status;
import com.mparticle.identity.IdentityHttpResponse;
import d7.c;
import d7.g;
import fa.a;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.mam.element.MamElements;

public final class VerificationCodeFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public g f35738a;

    /* renamed from: b  reason: collision with root package name */
    public a7.a f35739b;

    /* renamed from: c  reason: collision with root package name */
    public t f35740c;

    /* renamed from: d  reason: collision with root package name */
    public PhoneCodeViewModel f35741d;

    /* renamed from: e  reason: collision with root package name */
    public VerificationCodeView f35742e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f35743f = "VerificationCodeFragment";

    /* renamed from: g  reason: collision with root package name */
    private CountDownTimer f35744g;

    /* renamed from: h  reason: collision with root package name */
    private final int f35745h = 9809234;

    /* renamed from: j  reason: collision with root package name */
    private final u<VerifyCodeResponse> f35746j = new f(this);
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final b f35747k = new b(this);

    public static final class a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerificationCodeFragment f35748a;

        a(VerificationCodeFragment verificationCodeFragment) {
            this.f35748a = verificationCodeFragment;
        }

        public void a(CmbErrorCode cmbErrorCode) {
            j.g(cmbErrorCode, "errorStatus");
            this.f35748a.U0().z(false);
            this.f35748a.l1(false);
            if (cmbErrorCode.getErrorCode() != 401 || cmbErrorCode.getBannedReason() == BannedReason.NONE) {
                this.f35748a.j1(PhoneErrorCodes.OTHER_ERROR);
                this.f35748a.U0().C(PhoneCodeViewModel.ViewState.AUTH_FAILED);
                return;
            }
            this.f35748a.U0().v(cmbErrorCode);
            this.f35748a.U0().C(PhoneCodeViewModel.ViewState.BANNED);
            this.f35748a.j1(PhoneErrorCodes.BLOCKED_FOR_SECURITY);
        }

        public void b(UpgradeAvailability upgradeAvailability, String str) {
            j.g(upgradeAvailability, "upgrade");
            j.g(str, "profileId");
            lc.c.a(this.f35748a.getActivity());
            this.f35748a.U0().z(true);
            this.f35748a.l1(true);
            this.f35748a.U0().C(PhoneCodeViewModel.ViewState.AUTHENTICATED);
        }
    }

    public static final class b extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ VerificationCodeFragment f35749a;

        b(VerificationCodeFragment verificationCodeFragment) {
            this.f35749a = verificationCodeFragment;
        }

        public void onReceive(Context context, Intent intent) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            j.g(intent, SDKConstants.PARAM_INTENT);
            if (j.b("com.google.android.gms.auth.api.phone.SMS_RETRIEVED", intent.getAction())) {
                this.f35749a.d1(intent);
            }
        }
    }

    public static final class c extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f35750a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ VerificationCodeFragment f35751b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f35752c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f35753d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f35754e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(long j10, long j11, VerificationCodeFragment verificationCodeFragment, boolean z10, String str, int i10) {
            super(j10, j11);
            this.f35750a = j11;
            this.f35751b = verificationCodeFragment;
            this.f35752c = z10;
            this.f35753d = str;
            this.f35754e = i10;
        }

        /* access modifiers changed from: private */
        public static final void b(VerificationCodeFragment verificationCodeFragment, String str, View view) {
            j.g(verificationCodeFragment, "this$0");
            j.g(str, "$phoneNumberInput");
            verificationCodeFragment.T0().i();
            verificationCodeFragment.T0().m();
            verificationCodeFragment.U0().E(str);
            verificationCodeFragment.k1(str);
        }

        public void onFinish() {
            this.f35751b.T0().setTimeRemainingText(this.f35751b.S0((long) this.f35754e, this.f35752c, this.f35753d));
            this.f35751b.T0().p();
            this.f35751b.T0().getResendCodeButton().setOnClickListener(new g(this.f35751b, this.f35753d));
        }

        public void onTick(long j10) {
            this.f35751b.T0().setTimeRemainingText(this.f35751b.S0((long) ((int) (j10 / this.f35750a)), this.f35752c, this.f35753d));
        }
    }

    private final void N0(String str) {
        Q0().z(str, new a(this));
    }

    private final void O0() {
        CountDownTimer countDownTimer = this.f35744g;
        if (countDownTimer != null) {
            j.d(countDownTimer);
            countDownTimer.cancel();
        }
    }

    /* access modifiers changed from: private */
    public final String S0(long j10, boolean z10, String str) {
        VerifyPhoneNumberResponse.VerifyType verifyType;
        if (U0().s().f() != null) {
            VerifyPhoneNumberResponse f10 = U0().s().f();
            j.d(f10);
            verifyType = f10.getVerifyType();
        } else {
            verifyType = VerifyPhoneNumberResponse.VerifyType.SMS;
        }
        if (z10) {
            if (verifyType == VerifyPhoneNumberResponse.VerifyType.PHONE_CALL) {
                String string = T0().getContext().getString(R.string.new_call_should_arrive_in, new Object[]{str, Long.valueOf(j10)});
                j.f(string, "{\n                verifi…          )\n            }");
                return string;
            }
            String string2 = T0().getContext().getString(R.string.new_text_should_arrive_in, new Object[]{str, Long.valueOf(j10)});
            j.f(string2, "{\n                verifi…          )\n            }");
            return string2;
        } else if (verifyType == VerifyPhoneNumberResponse.VerifyType.PHONE_CALL) {
            String string3 = T0().getContext().getString(R.string.call_should_arrive_in, new Object[]{str, Long.valueOf(j10)});
            j.f(string3, "{\n                verifi…          )\n            }");
            return string3;
        } else {
            String string4 = T0().getContext().getString(R.string.text_should_arrive_in, new Object[]{str, Long.valueOf(j10)});
            j.f(string4, "{\n                verifi…          )\n            }");
            return string4;
        }
    }

    private final void V0(boolean z10) {
        if (z10) {
            U0().r().i(this, this.f35746j);
        } else {
            U0().r().n(this.f35746j);
        }
    }

    /* access modifiers changed from: private */
    public static final void W0(VerificationCodeFragment verificationCodeFragment, View view) {
        j.g(verificationCodeFragment, "this$0");
        verificationCodeFragment.b1();
    }

    /* access modifiers changed from: private */
    public static final void X0(VerificationCodeFragment verificationCodeFragment, View view) {
        j.g(verificationCodeFragment, "this$0");
        verificationCodeFragment.U0().C(PhoneCodeViewModel.ViewState.PHONE);
    }

    /* access modifiers changed from: private */
    public static final void Y0(VerificationCodeFragment verificationCodeFragment, View view) {
        j.g(verificationCodeFragment, "this$0");
        verificationCodeFragment.b1();
    }

    /* access modifiers changed from: private */
    public static final void Z0(VerificationCodeFragment verificationCodeFragment, VerifyCodeResponse verifyCodeResponse) {
        j.g(verificationCodeFragment, "this$0");
        a.C0491a aVar = fa.a.f40771d;
        String str = verificationCodeFragment.f35743f;
        aVar.a(str, "phoneCodeObserver: " + verifyCodeResponse);
        if (verifyCodeResponse != null) {
            PhoneCodeViewModel U0 = verificationCodeFragment.U0();
            U0.A(U0.o() + 1);
            if (verifyCodeResponse.getError() == PhoneErrorCodes.NONE) {
                String token = verifyCodeResponse.getToken();
                j.f(token, "verifyCodeResponse.token");
                if (!r.w(token)) {
                    verificationCodeFragment.U0().x(false);
                    verificationCodeFragment.m1();
                    String token2 = verifyCodeResponse.getToken();
                    j.f(token2, "verifyCodeResponse.token");
                    verificationCodeFragment.N0(token2);
                    return;
                }
            }
            verificationCodeFragment.U0().x(true);
            verificationCodeFragment.n1();
            PhoneErrorCodes error = verifyCodeResponse.getError();
            j.f(error, "verifyCodeResponse.error");
            verificationCodeFragment.j1(error);
        }
    }

    private final void b1() {
        boolean z10 = false;
        T0().d(false, true);
        String codeInput = T0().getCodeInput();
        if (codeInput == null || r.w(codeInput)) {
            z10 = true;
        }
        if (z10) {
            j1(PhoneErrorCodes.INVALID_AUTH_CODE);
            return;
        }
        PhoneCodeViewModel U0 = U0();
        j.f(codeInput, "code");
        U0.D(codeInput);
    }

    private final void c1(String str) {
        a.C0491a aVar = fa.a.f40771d;
        String str2 = this.f35743f;
        aVar.a(str2, "processSmsMessage: " + str);
        Matcher matcher = Pattern.compile("([0-9]{4,6})").matcher(str);
        if (matcher.find()) {
            String group = matcher.group();
            String str3 = this.f35743f;
            aVar.a(str3, "auto verifying phone with code " + group);
            T0().setSmsCode(group);
            T0().f35644b.performClick();
        }
    }

    /* access modifiers changed from: private */
    public final void d1(Intent intent) {
        Object obj;
        boolean z10;
        Bundle extras = intent.getExtras();
        if (extras != null) {
            obj = extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
        } else {
            obj = null;
        }
        j.e(obj, "null cannot be cast to non-null type com.google.android.gms.common.api.Status");
        if (((Status) obj).Y() == 0) {
            Intent intent2 = (Intent) extras.getParcelable("com.google.android.gms.auth.api.phone.EXTRA_CONSENT_INTENT");
            if (intent2 != null) {
                try {
                    startActivityForResult(intent2, this.f35745h);
                } catch (ActivityNotFoundException e10) {
                    fa.a.f40771d.c(this.f35743f, "Can't launch the SMS consent intent ", e10);
                }
            } else {
                String str = (String) extras.get("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
                if (str == null || r.w(str)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    c1(str);
                } else {
                    fa.a.f40771d.l(this.f35743f, "SmsBroadcastReceiver: Empty SMS received.");
                }
            }
        }
    }

    private final void e1() {
        if (R0().a()) {
            zd.a.a(requireActivity()).startSmsUserConsent((String) null).addOnFailureListener(new d(this)).addOnSuccessListener(new e(new VerificationCodeFragment$registerForSmsMessage$2(this)));
        } else {
            fa.a.f40771d.l(this.f35743f, "not auto verifying phone because feature flag is turned off");
        }
    }

    /* access modifiers changed from: private */
    public static final void f1(VerificationCodeFragment verificationCodeFragment, Exception exc) {
        j.g(verificationCodeFragment, "this$0");
        j.g(exc, "it");
        fa.a.f40771d.l(verificationCodeFragment.f35743f, "SMS LISTENING_FAILURE");
    }

    /* access modifiers changed from: private */
    public static final void g1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void j1(PhoneErrorCodes phoneErrorCodes) {
        T0().d(true, true);
        T0().q(phoneErrorCodes.c());
        T0().l();
    }

    /* access modifiers changed from: private */
    public final void k1(String str) {
        boolean z10;
        O0();
        long max = Math.max(R0().v(), 30000);
        if (this.f35744g == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        c cVar = new c(max, 1000, this, z10, str, 0);
        this.f35744g = cVar;
        j.e(cVar, "null cannot be cast to non-null type android.os.CountDownTimer");
        cVar.start();
    }

    /* access modifiers changed from: private */
    public final void l1(boolean z10) {
        HashMap hashMap = new HashMap();
        if (z10) {
            hashMap.put(MamElements.MamResultExtension.ELEMENT, "succeeded");
        } else {
            hashMap.put(MamElements.MamResultExtension.ELEMENT, StreamManagement.Failed.ELEMENT);
        }
        P0().j("Phone Login", hashMap);
    }

    private final void m1() {
        HashMap hashMap = new HashMap();
        hashMap.put("Error", String.valueOf(U0().k()));
        P0().trackEvent("Verification Code Input", hashMap);
    }

    private final void n1() {
        HashMap hashMap = new HashMap();
        hashMap.put(MamElements.MamResultExtension.ELEMENT, StreamManagement.Failed.ELEMENT);
        P0().j("Phone Login", hashMap);
    }

    public final a7.a P0() {
        a7.a aVar = this.f35739b;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final g Q0() {
        g gVar = this.f35738a;
        if (gVar != null) {
            return gVar;
        }
        j.y("authenticationManager");
        return null;
    }

    public final t R0() {
        t tVar = this.f35740c;
        if (tVar != null) {
            return tVar;
        }
        j.y("remoteConfigManager");
        return null;
    }

    public final VerificationCodeView T0() {
        VerificationCodeView verificationCodeView = this.f35742e;
        if (verificationCodeView != null) {
            return verificationCodeView;
        }
        j.y("verificationCodeView");
        return null;
    }

    public final PhoneCodeViewModel U0() {
        PhoneCodeViewModel phoneCodeViewModel = this.f35741d;
        if (phoneCodeViewModel != null) {
            return phoneCodeViewModel;
        }
        j.y("viewModel");
        return null;
    }

    public final void h1(VerificationCodeView verificationCodeView) {
        j.g(verificationCodeView, "<set-?>");
        this.f35742e = verificationCodeView;
    }

    public final void i1(PhoneCodeViewModel phoneCodeViewModel) {
        j.g(phoneCodeViewModel, "<set-?>");
        this.f35741d = phoneCodeViewModel;
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 != this.f35745h) {
            return;
        }
        if (i11 != -1 || intent == null) {
            fa.a.f40771d.l(this.f35743f, "User declined to let us read the message.");
            return;
        }
        String stringExtra = intent.getStringExtra("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
        if (stringExtra != null) {
            c1(stringExtra);
        }
    }

    public void onAttach(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        Bakery.j().w1(this);
        super.onAttach(context);
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        if (R0().a()) {
            str = "phone_login_verification_auto";
        } else {
            str = "phone_login_verification_manual";
        }
        g1.c(str);
        e1();
        P0().g("Phone Login Verification Code Input");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.verification_code_view, viewGroup, false);
        j.e(inflate, "null cannot be cast to non-null type com.coffeemeetsbagel.phone_login.verification_code.VerificationCodeView");
        h1((VerificationCodeView) inflate);
        return T0();
    }

    public void onDestroy() {
        try {
            requireActivity().unregisterReceiver(this.f35747k);
        } catch (IllegalArgumentException unused) {
            fa.a.f40771d.a(this.f35743f, "SMS auto completion failed. No receiver registered.");
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        T0().k();
        VerificationCodeView T0 = T0();
        VerifyPhoneNumberResponse f10 = U0().s().f();
        j.d(f10);
        T0.setNumberOfAuthCodeInputs(f10.getAuthCodeLength());
        T0().f35644b.setOnClickListener(new a(this));
        T0().setBackButtonEnabled(true);
        T0().f35643a.setOnClickListener(new b(this));
        T0().getVerify().setOnClickListener(new c(this));
        k1(U0().n());
    }

    public void onStart() {
        super.onStart();
        V0(true);
    }

    public void onStop() {
        O0();
        V0(false);
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        PhoneCodeViewModel phoneCodeViewModel;
        j.g(view, "view");
        super.onViewCreated(view, bundle);
        h activity = getActivity();
        if (activity == null || (phoneCodeViewModel = (PhoneCodeViewModel) new i0(activity).a(PhoneCodeViewModel.class)) == null) {
            throw new Exception("Invalid Activity");
        }
        i1(phoneCodeViewModel);
        U0().x(false);
    }
}
