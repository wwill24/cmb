package com.coffeemeetsbagel.feature.profile_completion_helper.religion;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.lifecycle.i0;
import androidx.lifecycle.l0;
import androidx.lifecycle.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.feature.likepassflow.RowItemView;
import com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperActivity;
import com.coffeemeetsbagel.feature.profile_completion_helper.f;
import java.util.ArrayList;
import java.util.List;
import k6.t;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.p;

public final class ReligionFragment extends Fragment implements f {

    /* renamed from: g  reason: collision with root package name */
    public static final a f13343g = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public FeatureFlagRepository f13344a;

    /* renamed from: b  reason: collision with root package name */
    public f f13345b;

    /* renamed from: c  reason: collision with root package name */
    public ReligionViewModel f13346c;

    /* renamed from: d  reason: collision with root package name */
    public t f13347d;

    /* renamed from: e  reason: collision with root package name */
    private String f13348e = "";

    /* renamed from: f  reason: collision with root package name */
    private final List<RowItemView> f13349f = new ArrayList();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ReligionFragment a() {
            return new ReligionFragment();
        }
    }

    static final class b implements u, kotlin.jvm.internal.f {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f13350a;

        b(Function1 function1) {
            j.g(function1, "function");
            this.f13350a = function1;
        }

        public final gk.c<?> a() {
            return this.f13350a;
        }

        public final /* synthetic */ void b(Object obj) {
            this.f13350a.invoke(obj);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof u) || !(obj instanceof kotlin.jvm.internal.f)) {
                return false;
            }
            return j.b(a(), ((kotlin.jvm.internal.f) obj).a());
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    public static final class c extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReligionFragment f13351a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f13352b;

        c(ReligionFragment religionFragment, int i10) {
            this.f13351a = religionFragment;
            this.f13352b = i10;
        }

        public void onClick(View view) {
            j.g(view, "widget");
            CmbLinks.Companion companion = CmbLinks.Companion;
            h activity = this.f13351a.getActivity();
            j.d(activity);
            companion.launchTermsAndConditions(activity);
        }

        public void updateDrawState(TextPaint textPaint) {
            j.g(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f13352b);
        }
    }

    /* access modifiers changed from: private */
    public final void F0(String str, String str2) {
        boolean z10;
        if (j.b(this.f13348e, str)) {
            str = "";
        }
        this.f13348e = str;
        for (RowItemView rowItemView : this.f13349f) {
            boolean z11 = true;
            if (j.b(str2, rowItemView.getText())) {
                if (this.f13348e.length() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    rowItemView.setChecked(z11);
                }
            }
            z11 = false;
            rowItemView.setChecked(z11);
        }
    }

    private final void I0() {
        CmbTextView cmbTextView = A0().f15815c;
        j.f(cmbTextView, "binding.fragmentMyProfileDisclaimerTextview");
        cmbTextView.setVisibility(0);
        String string = getString(R.string.privacy_policy);
        j.f(string, "getString(R.string.privacy_policy)");
        SpannableString spannableString = new SpannableString(getString(R.string.like_flow_religion_disclaimer, string));
        String spannableString2 = spannableString.toString();
        j.f(spannableString2, "disclaimer.toString()");
        int b02 = StringsKt__StringsKt.b0(spannableString2, string, 0, false, 6, (Object) null);
        spannableString.setSpan(new c(this, getResources().getColor(R.color.main_color)), b02, string.length() + b02, 18);
        cmbTextView.setText(spannableString);
        cmbTextView.setClickable(true);
        cmbTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final t A0() {
        t tVar = this.f13347d;
        if (tVar != null) {
            return tVar;
        }
        j.y("binding");
        return null;
    }

    public final FeatureFlagRepository B0() {
        FeatureFlagRepository featureFlagRepository = this.f13344a;
        if (featureFlagRepository != null) {
            return featureFlagRepository;
        }
        j.y("featureManager");
        return null;
    }

    public final List<RowItemView> C0() {
        return this.f13349f;
    }

    public final ReligionViewModel D0() {
        ReligionViewModel religionViewModel = this.f13346c;
        if (religionViewModel != null) {
            return religionViewModel;
        }
        j.y("viewModel");
        return null;
    }

    public final f E0() {
        f fVar = this.f13345b;
        if (fVar != null) {
            return fVar;
        }
        j.y("viewModelFactory");
        return null;
    }

    public final void G0(t tVar) {
        j.g(tVar, "<set-?>");
        this.f13347d = tVar;
    }

    public final void H0(ReligionViewModel religionViewModel) {
        j.g(religionViewModel, "<set-?>");
        this.f13346c = religionViewModel;
    }

    public void d() {
        boolean z10;
        if (this.f13348e.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            D0().l(p.e(this.f13348e));
            h requireActivity = requireActivity();
            j.e(requireActivity, "null cannot be cast to non-null type com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperActivity");
            ((ProfileCompletionHelperActivity) requireActivity).next();
            return;
        }
        DialogPrimarySecondaryVertical.a aVar = DialogPrimarySecondaryVertical.f12065a;
        Context requireContext = requireContext();
        j.f(requireContext, "requireContext()");
        aVar.a(requireContext, DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL, (Integer) null, R.string.like_flow_religion_empty_title, R.string.like_flow_religion_empty_prompt, R.string.continue_lc, (Function0) p.d(new ReligionFragment$onNext$1(this), 0), Integer.valueOf(R.string.go_back), (Function0<Unit>) null, (Function0<Unit>) null);
    }

    public void onCreate(Bundle bundle) {
        Bakery.j().j1(this);
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        t c10 = t.c(layoutInflater, viewGroup, false);
        j.f(c10, "inflate(inflater, container, false)");
        G0(c10);
        A0().f15816d.setText(getString(R.string.onboarding_title_religion_dls));
        H0((ReligionViewModel) new i0((l0) this, (i0.b) E0()).a(ReligionViewModel.class));
        D0().j().i(getViewLifecycleOwner(), new b(new ReligionFragment$onCreateView$1(this)));
        if (B0().A("Privacy.GdprCopy.Android")) {
            I0();
        }
        ScrollView b10 = A0().getRoot();
        j.f(b10, "binding.root");
        return b10;
    }
}
