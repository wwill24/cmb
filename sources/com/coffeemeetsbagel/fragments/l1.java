package com.coffeemeetsbagel.fragments;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivityLogin;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.dialogs.b0;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.models.BannedReason;
import com.coffeemeetsbagel.models.VerificationStatus;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.phone_login.PhoneCodeActivity;
import com.coffeemeetsbagel.util.EmulatorUtil;
import com.coffeemeetsbagel.util.RequestCode;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import h5.l;
import h8.c;
import h8.d;
import h8.f;
import lc.g;
import org.jivesoftware.smack.sm.packet.StreamManagement;

public class l1 extends Fragment implements d, FacebookCallback<LoginResult> {

    /* renamed from: a  reason: collision with root package name */
    private ConstraintLayout f13758a;

    /* renamed from: b  reason: collision with root package name */
    private CmbTextView f13759b;

    /* renamed from: c  reason: collision with root package name */
    private CmbTextView f13760c;

    /* renamed from: d  reason: collision with root package name */
    private CmbTextView f13761d;

    /* renamed from: e  reason: collision with root package name */
    private LoginButton f13762e;

    /* renamed from: f  reason: collision with root package name */
    private b0 f13763f;

    /* renamed from: g  reason: collision with root package name */
    private c f13764g;

    class a extends ClickableSpan {
        a() {
        }

        public void onClick(@NonNull View view) {
            CmbLinks.Companion.launchTermsAndConditions(l1.this.requireActivity());
        }

        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(l1.this.getResources().getColor(R.color.main_light_color));
            textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D0(View view) {
        this.f13764g.B();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E0(View view) {
        this.f13764g.v();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F0(View view) {
        lc.c.h(this.f13763f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G0(View view) {
        lc.c.h(this.f13763f);
    }

    public static l1 H0(boolean z10) {
        l1 l1Var = new l1();
        Bundle bundle = new Bundle();
        bundle.putBoolean(Extra.SHOULD_SHOW_ACCOUNT_DELETED_MESSAGE, z10);
        l1Var.setArguments(bundle);
        return l1Var;
    }

    private void J0(TextView textView) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText(R.string.start_button_facebook));
        int lineHeight = textView.getLineHeight() - textView.getResources().getDimensionPixelOffset(R.dimen.two_dp);
        Drawable drawable = androidx.core.content.a.getDrawable(textView.getContext(), R.drawable.ic_facebook_circular_logo);
        int color = androidx.core.content.a.getColor(textView.getContext(), R.color.main_color);
        if (drawable != null) {
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            drawable.setBounds(0, 0, lineHeight, lineHeight);
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 0, 1, 33);
        }
        textView.setText(spannableStringBuilder);
    }

    private boolean L0() {
        if (getArguments() == null || !getArguments().getBoolean(Extra.DEEP_LINK_TO_PHONE_LOGIN, false)) {
            return false;
        }
        return true;
    }

    private boolean M0() {
        if (!g.b() || !Bakery.w().H().b()) {
            return true;
        }
        EmulatorUtil emulatorUtil = EmulatorUtil.f37578a;
        if (!emulatorUtil.k()) {
            return true;
        }
        fa.a.g("FragmentLogin", "Emulator detected! " + emulatorUtil.e(), new Exception("Emulator Detected"));
        return false;
    }

    public void B() {
        startActivityForResult(new Intent(getActivity(), PhoneCodeActivity.class), RequestCode.PHONE_LOGIN);
    }

    public void D() {
        if (isAdded()) {
            sb.a.f(this.f13758a, R.string.error_login);
            this.f13764g.i();
        }
    }

    /* renamed from: I0 */
    public void onSuccess(LoginResult loginResult) {
        this.f13764g.O(loginResult);
    }

    public void T(int i10) {
        sb.a.f(this.f13758a, i10);
    }

    public void V() {
        ((ActivityLogin) requireActivity()).z1();
    }

    public void i0() {
        this.f13762e.performClick();
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 != 9293 || !isAdded()) {
            l.h().onActivityResult(i10, i11, intent);
            return;
        }
        ActivityLogin activityLogin = (ActivityLogin) requireActivity();
        if (i11 == 61 || i11 == 69) {
            activityLogin.y1();
        } else if (i11 == 71) {
            VerificationStatus fromApiKey = VerificationStatus.Companion.fromApiKey(intent.getStringExtra(Extra.VERIFICATION_STATUS));
            fromApiKey.setReferenceId(intent.getStringExtra(Extra.VERIFICATION_REFERENCE_ID));
            activityLogin.u1(BannedReason.Companion.fromApiKey(intent.getStringExtra(Extra.BANNED_REASON)), fromApiKey);
        } else if (i11 == 65) {
            T(R.string.error_login);
        } else if (i11 == 66) {
            activityLogin.B1();
        }
    }

    public void onCancel() {
        this.f13764g.o();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f fVar = new f(this, Bakery.w().m(), Bakery.w().r(), Bakery.w().z(), Bakery.w().H());
        this.f13764g = fVar;
        fVar.w(bundle);
        this.f13764g.start();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ConstraintLayout constraintLayout = (ConstraintLayout) layoutInflater.inflate(R.layout.fragment_login_experiment, viewGroup, false);
        this.f13758a = constraintLayout;
        this.f13759b = (CmbTextView) constraintLayout.findViewById(R.id.login_facebook_text_view);
        this.f13760c = (CmbTextView) this.f13758a.findViewById(R.id.login_phone_text_view);
        this.f13762e = (LoginButton) this.f13758a.findViewById(R.id.facebook_login_button);
        this.f13761d = (CmbTextView) this.f13758a.findViewById(R.id.terms_and_conditions_text);
        String string = getString(R.string.login_terms_and_conditions);
        String string2 = getString(R.string.login_agreement, string);
        SpannableString spannableString = new SpannableString(string2);
        spannableString.setSpan(new a(), string2.indexOf(string), string2.length(), 18);
        this.f13761d.setText(spannableString);
        this.f13761d.setMovementMethod(LinkMovementMethod.getInstance());
        this.f13762e.setReadPermissions(l.i());
        this.f13762e.setFragment((Fragment) this);
        this.f13759b.setOnClickListener(new h1(this));
        J0(this.f13759b);
        if (M0()) {
            this.f13760c.setVisibility(0);
            this.f13760c.setOnClickListener(new i1(this));
        } else {
            this.f13760c.setVisibility(8);
        }
        this.f13762e.registerCallback(l.h(), this);
        return this.f13758a;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f13764g.stop();
    }

    public void onDestroyView() {
        this.f13762e.unregisterCallback(l.h());
        super.onDestroyView();
    }

    public void onError(FacebookException facebookException) {
        fa.a.g("FragmentLogin", "onError", facebookException);
        this.f13764g.F(facebookException);
    }

    public void onPause() {
        super.onPause();
        this.f13764g.D();
    }

    public void onResume() {
        super.onResume();
        this.f13764g.a();
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f13764g.I(bundle);
    }

    public void onStart() {
        super.onStart();
        if (L0()) {
            getArguments().remove(Extra.DEEP_LINK_TO_PHONE_LOGIN);
            this.f13759b.setVisibility(8);
            B();
            return;
        }
        this.f13759b.setVisibility(0);
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void p0() {
        b0 b0Var = new b0(getContext(), R.string.no_sim_card, R.string.sim_card_required, R.string.ok_short);
        this.f13763f = b0Var;
        b0Var.b(new j1(this));
        this.f13763f.show();
    }

    public void q0(String str) {
        ((ActivityLogin) requireActivity()).U0(StreamManagement.Failed.ELEMENT);
    }

    public void t0() {
        ((ActivityLogin) requireActivity()).l1();
    }

    public void v0() {
        b0 b0Var = new b0(getContext(), R.string.no_internet_connection, R.string.error_internet_connection, R.string.ok_short);
        this.f13763f = b0Var;
        b0Var.b(new k1(this));
        this.f13763f.show();
    }
}
