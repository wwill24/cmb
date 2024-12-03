package com.coffeemeetsbagel.phone_login.phone_number_input;

import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.lifecycle.i0;
import androidx.lifecycle.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.bakery.i1;
import com.coffeemeetsbagel.country.CmbCountry;
import com.coffeemeetsbagel.country.CountryConstants;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.phone_login.PhoneCodeViewModel;
import com.coffeemeetsbagel.phone_login.PhoneErrorCodes;
import com.coffeemeetsbagel.phone_login.api.models.VerifyPhoneNumberResponse;
import com.coffeemeetsbagel.util.EmulatorUtil;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.mparticle.identity.IdentityHttpResponse;
import fa.a;
import gk.c;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import lc.l;
import xd.d;

public final class PhoneInputFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final String f35712a = "PhoneInputFragment";

    /* renamed from: b  reason: collision with root package name */
    public a7.a f35713b;

    /* renamed from: c  reason: collision with root package name */
    public PhoneCodeViewModel f35714c;

    /* renamed from: d  reason: collision with root package name */
    public PhoneNumberInputView f35715d;

    /* renamed from: e  reason: collision with root package name */
    private final a f35716e = new a(this);

    /* renamed from: f  reason: collision with root package name */
    private final u<VerifyPhoneNumberResponse> f35717f = new b(this);

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhoneInputFragment f35718a;

        a(PhoneInputFragment phoneInputFragment) {
            this.f35718a = phoneInputFragment;
        }

        public void afterTextChanged(Editable editable) {
            j.g(editable, "editable");
            this.f35718a.V0(editable.toString(), this.f35718a.J0());
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            j.g(charSequence, "c");
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            j.g(charSequence, "c");
        }
    }

    static final class b implements u, f {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f35719a;

        b(Function1 function1) {
            j.g(function1, "function");
            this.f35719a = function1;
        }

        public final c<?> a() {
            return this.f35719a;
        }

        public final /* synthetic */ void b(Object obj) {
            this.f35719a.invoke(obj);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof u) || !(obj instanceof f)) {
                return false;
            }
            return j.b(a(), ((f) obj).a());
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    /* access modifiers changed from: private */
    public final Locale J0() {
        try {
            Locale locale = LocaleList.getDefault().get(0);
            j.f(locale, "LocaleList.getDefault()[0]");
            return locale;
        } catch (Exception unused) {
            Locale locale2 = Locale.US;
            j.f(locale2, "US");
            return locale2;
        }
    }

    private final void N0(boolean z10) {
        fa.a.f40771d.a(this.f35712a, "listenForPhoneResults()");
        if (z10) {
            M0().s().i(this, this.f35717f);
        } else {
            M0().s().n(this.f35717f);
        }
    }

    /* access modifiers changed from: private */
    public static final void O0(PhoneInputFragment phoneInputFragment, View view) {
        j.g(phoneInputFragment, "this$0");
        phoneInputFragment.W0();
    }

    /* access modifiers changed from: private */
    public static final void P0(PhoneInputFragment phoneInputFragment, View view) {
        j.g(phoneInputFragment, "this$0");
        phoneInputFragment.X0();
    }

    /* access modifiers changed from: private */
    public static final void Q0(PhoneInputFragment phoneInputFragment, View view) {
        j.g(phoneInputFragment, "this$0");
        phoneInputFragment.X0();
    }

    /* access modifiers changed from: private */
    public static final void R0(PhoneInputFragment phoneInputFragment, View view) {
        j.g(phoneInputFragment, "this$0");
        phoneInputFragment.X0();
    }

    /* access modifiers changed from: private */
    public static final void S0(PhoneInputFragment phoneInputFragment, View view) {
        j.g(phoneInputFragment, "this$0");
        phoneInputFragment.M0().C(PhoneCodeViewModel.ViewState.PHONE);
        h activity = phoneInputFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public static final void T0(PhoneInputFragment phoneInputFragment, View view) {
        j.g(phoneInputFragment, "this$0");
        phoneInputFragment.M0().C(PhoneCodeViewModel.ViewState.COUNTRY);
    }

    /* access modifiers changed from: private */
    public static final void U0(PhoneInputFragment phoneInputFragment, VerifyPhoneNumberResponse verifyPhoneNumberResponse) {
        j.g(phoneInputFragment, "this$0");
        a.C0491a aVar = fa.a.f40771d;
        String str = phoneInputFragment.f35712a;
        aVar.a(str, "phoneResultObserver: " + verifyPhoneNumberResponse);
        if (verifyPhoneNumberResponse != null) {
            if (verifyPhoneNumberResponse.isSuccessful()) {
                phoneInputFragment.M0().y(false);
                phoneInputFragment.M0().C(PhoneCodeViewModel.ViewState.CODE);
            } else {
                String result = verifyPhoneNumberResponse.getResult();
                j.f(result, "phoneNumberResponse.result");
                if (TextUtils.isDigitsOnly(result)) {
                    String result2 = verifyPhoneNumberResponse.getResult();
                    j.f(result2, "phoneNumberResponse.result");
                    if (i1.e(Integer.parseInt(result2))) {
                        phoneInputFragment.M0().C(PhoneCodeViewModel.ViewState.MAINTENANCE);
                    }
                }
                if (verifyPhoneNumberResponse.getError() != PhoneErrorCodes.NONE) {
                    phoneInputFragment.M0().y(true);
                    PhoneErrorCodes error = verifyPhoneNumberResponse.getError();
                    j.f(error, "phoneNumberResponse.error");
                    phoneInputFragment.d1(error);
                }
            }
            phoneInputFragment.e1();
        }
    }

    private final void W0() {
        h activity = getActivity();
        if (activity != null) {
            CmbLinks.Companion.launchPhoneLoginSupport(activity);
        }
    }

    private final void b1() {
        HintRequest a10 = new HintRequest.a().b(true).a();
        j.f(a10, "Builder()\n            .s…rue)\n            .build()");
        d b10 = new d.a().c().b();
        j.f(b10, "Builder()\n            .f…og()\n            .build()");
        xd.c a11 = xd.a.a(requireContext(), b10);
        j.f(a11, "getClient(requireContext(), options)");
        PendingIntent d10 = a11.d(a10);
        j.f(d10, "credentialClient.getHintPickerIntent(hintRequest)");
        androidx.activity.result.c registerForActivityResult = registerForActivityResult(new c.j(), new a(this));
        j.f(registerForActivityResult, "registerForActivityResul…          }\n            }");
        try {
            IntentSender intentSender = d10.getIntentSender();
            j.f(intentSender, "intent.intentSender");
            registerForActivityResult.b(new IntentSenderRequest.a(intentSender).a());
        } catch (IntentSender.SendIntentException e10) {
            a.C0491a aVar = fa.a.f40771d;
            String str = this.f35712a;
            aVar.c(str, "SendIntentException failed: intent=" + d10, e10);
        } catch (ActivityNotFoundException e11) {
            a.C0491a aVar2 = fa.a.f40771d;
            String str2 = this.f35712a;
            aVar2.c(str2, "Pre-populating phone number failed: intent=" + d10, e11);
        }
    }

    /* access modifiers changed from: private */
    public static final void c1(PhoneInputFragment phoneInputFragment, ActivityResult activityResult) {
        Credential credential;
        String str;
        j.g(phoneInputFragment, "this$0");
        if (activityResult != null) {
            Intent a10 = activityResult.a();
            if (a10 != null) {
                credential = (Credential) a10.getParcelableExtra("com.google.android.gms.credentials.Credential");
            } else {
                credential = null;
            }
            if (credential == null || (str = credential.f0()) == null) {
                str = "";
            }
            phoneInputFragment.L0().getPhoneEditText().setText(str);
        }
    }

    private final void d1(PhoneErrorCodes phoneErrorCodes) {
        L0().d(true, true);
        L0().setPhoneNumberErrorState(phoneErrorCodes.c());
    }

    private final void e1() {
        String str;
        PhoneErrorCodes error;
        fa.a.f40771d.a(this.f35712a, "trackPhoneNumberInput()");
        HashMap hashMap = new HashMap();
        hashMap.put("Error", String.valueOf(M0().l()));
        VerifyPhoneNumberResponse f10 = M0().s().f();
        if (!(f10 == null || (error = f10.getError()) == null)) {
            hashMap.put("Error_Code", error.name());
        }
        CmbCountry f11 = M0().i().f();
        if (f11 == null || (str = f11.e()) == null) {
            str = "";
        }
        hashMap.put("Country", str);
        hashMap.put("Error", String.valueOf(M0().l()));
        hashMap.put("has_simcard", String.valueOf(l.e()));
        hashMap.put("is_emulator", String.valueOf(EmulatorUtil.f37578a.k()));
        I0().trackEvent("Phone Number Input", hashMap);
    }

    public final a7.a I0() {
        a7.a aVar = this.f35713b;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final PhoneNumberInputView L0() {
        PhoneNumberInputView phoneNumberInputView = this.f35715d;
        if (phoneNumberInputView != null) {
            return phoneNumberInputView;
        }
        j.y("phoneNumberInputView");
        return null;
    }

    public final PhoneCodeViewModel M0() {
        PhoneCodeViewModel phoneCodeViewModel = this.f35714c;
        if (phoneCodeViewModel != null) {
            return phoneCodeViewModel;
        }
        j.y("viewModel");
        return null;
    }

    public final void V0(String str, Locale locale) {
        j.g(str, ViewHierarchyConstants.HINT_KEY);
        j.g(locale, "currentLocale");
        if (r.J(str, "+", false, 2, (Object) null) && str.length() > 1) {
            StringBuilder sb2 = new StringBuilder();
            int length = str.length();
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = str.charAt(i10);
                if (Character.isDigit(charAt)) {
                    sb2.append(charAt);
                }
            }
            String sb3 = sb2.toString();
            j.f(sb3, "filterTo(StringBuilder(), predicate).toString()");
            CmbCountry f10 = M0().i().f();
            j.d(f10);
            CmbCountry cmbCountry = f10;
            M0().w(CountryConstants.f11583a.e(sb3, cmbCountry, locale));
            String d10 = cmbCountry.d();
            StringBuilder sb4 = new StringBuilder();
            int length2 = d10.length();
            for (int i11 = 0; i11 < length2; i11++) {
                char charAt2 = d10.charAt(i11);
                if (Character.isDigit(charAt2)) {
                    sb4.append(charAt2);
                }
            }
            String sb5 = sb4.toString();
            j.f(sb5, "filterTo(StringBuilder(), predicate).toString()");
            if (r.J(sb3, sb5, false, 2, (Object) null)) {
                L0().getPhoneEditText().removeTextChangedListener(this.f35716e);
                L0().getPhoneEditText().setText(StringsKt__StringsKt.u0(sb3, sb5));
                L0().getPhoneEditText().addTextChangedListener(this.f35716e);
            }
        }
    }

    public final void X0() {
        boolean z10;
        boolean z11 = false;
        L0().d(false, true);
        androidx.core.util.d<String, String> phoneNumberInput = L0().getPhoneNumberInput();
        j.f(phoneNumberInput, "phoneNumberInputView.phoneNumberInput");
        CharSequence charSequence = (CharSequence) phoneNumberInput.f4735a;
        if (charSequence == null || r.w(charSequence)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            CharSequence charSequence2 = (CharSequence) phoneNumberInput.f4736b;
            if (charSequence2 == null || r.w(charSequence2)) {
                z11 = true;
            }
            if (!z11) {
                PhoneCodeViewModel M0 = M0();
                S s10 = phoneNumberInput.f4736b;
                j.f(s10, "pair.second");
                M0.B((String) s10);
                PhoneCodeViewModel M02 = M0();
                F f10 = phoneNumberInput.f4735a;
                j.f(f10, "pair.first");
                M02.E((String) f10);
                return;
            }
        }
        d1(PhoneErrorCodes.INVALID_PHONE_NUMBER);
    }

    public final void Y0(PhoneNumberInputView phoneNumberInputView) {
        j.g(phoneNumberInputView, "<set-?>");
        this.f35715d = phoneNumberInputView;
    }

    public final void Z0(PhoneCodeViewModel phoneCodeViewModel) {
        j.g(phoneCodeViewModel, "<set-?>");
        this.f35714c = phoneCodeViewModel;
    }

    public void onAttach(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        Bakery.j().e1(this);
        b1();
        super.onAttach(context);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        I0().g("Phone Login Phone Number Input");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.phone_number_input_view, viewGroup, false);
        j.e(inflate, "null cannot be cast to non-null type com.coffeemeetsbagel.phone_login.phone_number_input.PhoneNumberInputView");
        Y0((PhoneNumberInputView) inflate);
        return L0();
    }

    public void onResume() {
        super.onResume();
        L0().getContactSupport().setOnClickListener(new c(this));
        L0().getStartedButton().setOnClickListener(new d(this));
        L0().getStartedButton().setOnClickListener(new e(this));
        L0().f35644b.setOnClickListener(new f(this));
        L0().f35643a.setOnClickListener(new g(this));
        L0().f35720c.setOnClickListener(new h(this));
        L0().setFlagAndCode(M0().i().f());
        M0().i().i(this, new b(new PhoneInputFragment$onResume$7(this)));
        if (!r.w(M0().q())) {
            L0().setPreviousPhoneNumberInput(M0().q());
            L0().i();
        }
    }

    public void onStart() {
        super.onStart();
        L0().getPhoneEditText().addTextChangedListener(this.f35716e);
        N0(true);
        if (M0().i().f() == null) {
            PhoneCodeViewModel M0 = M0();
            CountryConstants countryConstants = CountryConstants.f11583a;
            CmbCountry g10 = countryConstants.g();
            Locale locale = LocaleList.getDefault().get(0);
            j.f(locale, "getDefault().get(0)");
            M0.w(countryConstants.d(g10, locale));
        }
    }

    public void onStop() {
        super.onStop();
        PhoneCodeViewModel M0 = M0();
        S s10 = L0().getPhoneNumberInput().f4736b;
        j.f(s10, "phoneNumberInputView.phoneNumberInput.second");
        M0.B((String) s10);
        N0(false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        PhoneCodeViewModel phoneCodeViewModel;
        j.g(view, "view");
        super.onViewCreated(view, bundle);
        h activity = getActivity();
        if (activity == null || (phoneCodeViewModel = (PhoneCodeViewModel) new i0(activity).a(PhoneCodeViewModel.class)) == null) {
            throw new Exception("Invalid Activity");
        }
        Z0(phoneCodeViewModel);
        M0().y(false);
    }
}
