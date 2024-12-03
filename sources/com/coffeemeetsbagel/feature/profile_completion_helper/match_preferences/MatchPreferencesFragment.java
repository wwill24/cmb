package com.coffeemeetsbagel.feature.profile_completion_helper.match_preferences;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.lifecycle.i0;
import androidx.lifecycle.l0;
import androidx.lifecycle.u;
import com.appyvet.rangebar.RangeBar;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.dialogs.b;
import com.coffeemeetsbagel.dialogs.f0;
import com.coffeemeetsbagel.dialogs.k;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperActivity;
import com.coffeemeetsbagel.feature.profile_completion_helper.f;
import com.coffeemeetsbagel.match_prefs.MatchPreference$Gender;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.uber.autodispose.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import k6.v;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import qj.q;
import r7.g;

public final class MatchPreferencesFragment extends Fragment implements f {

    /* renamed from: m  reason: collision with root package name */
    public static final a f13273m = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public l f13274a;

    /* renamed from: b  reason: collision with root package name */
    public FeatureFlagRepository f13275b;

    /* renamed from: c  reason: collision with root package name */
    public MatchPreferencesViewModel f13276c;

    /* renamed from: d  reason: collision with root package name */
    public v f13277d;

    /* renamed from: e  reason: collision with root package name */
    private nc.d f13278e;

    /* renamed from: f  reason: collision with root package name */
    private Pair<Float, Float> f13279f;

    /* renamed from: g  reason: collision with root package name */
    private Pair<Float, Float> f13280g;

    /* renamed from: h  reason: collision with root package name */
    private String f13281h;

    /* renamed from: j  reason: collision with root package name */
    private Integer f13282j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public List<String> f13283k = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public List<String> f13284l = new ArrayList();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MatchPreferencesFragment a(boolean z10) {
            MatchPreferencesFragment matchPreferencesFragment = new MatchPreferencesFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("EXTRA_SHOULD_SHOW_WHAT_DO_YOU_LIKE", z10);
            matchPreferencesFragment.setArguments(bundle);
            return matchPreferencesFragment;
        }
    }

    static final class b implements u, kotlin.jvm.internal.f {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f13285a;

        b(Function1 function1) {
            j.g(function1, "function");
            this.f13285a = function1;
        }

        public final gk.c<?> a() {
            return this.f13285a;
        }

        public final /* synthetic */ void b(Object obj) {
            this.f13285a.invoke(obj);
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
        final /* synthetic */ MatchPreferencesFragment f13286a;

        c(MatchPreferencesFragment matchPreferencesFragment) {
            this.f13286a = matchPreferencesFragment;
        }

        public void onClick(View view) {
            j.g(view, "widget");
            CmbLinks.Companion companion = CmbLinks.Companion;
            h requireActivity = this.f13286a.requireActivity();
            j.f(requireActivity, "requireActivity()");
            companion.launchTermsAndConditions(requireActivity);
        }
    }

    public static final class d implements b.C0132b<k> {
        d() {
        }

        /* renamed from: c */
        public void a(k kVar) {
            j.g(kVar, "item");
        }

        /* renamed from: d */
        public void b(k kVar) {
            j.g(kVar, "item");
        }
    }

    public static final class e implements b.C0132b<k> {
        e() {
        }

        /* renamed from: c */
        public void a(k kVar) {
            j.g(kVar, "item");
        }

        /* renamed from: d */
        public void b(k kVar) {
            j.g(kVar, "item");
        }
    }

    /* access modifiers changed from: private */
    public final void Z0(float f10, float f11, QuestionWAnswers questionWAnswers) {
        float f12;
        float f13;
        Float maxValue;
        Float minValue;
        Answer answer = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
        if (answer == null || (minValue = answer.getMinValue()) == null) {
            f12 = f10;
        } else {
            f12 = minValue.floatValue();
        }
        Answer answer2 = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
        if (answer2 == null || (maxValue = answer2.getMaxValue()) == null) {
            f13 = f11;
        } else {
            f13 = maxValue.floatValue();
        }
        T0().f15833m.r(f12, f13);
        T0().f15823b.setText(g.a(getActivity(), (int) f12, (int) f13));
        T0().f15833m.setOnRangeBarChangeListener(new d(f10, this, f11));
    }

    /* access modifiers changed from: private */
    public static final void b1(float f10, MatchPreferencesFragment matchPreferencesFragment, float f11, RangeBar rangeBar, int i10, int i11, String str, String str2) {
        j.g(matchPreferencesFragment, "this$0");
        j.g(rangeBar, "rangeBar");
        j.g(str, ViewHierarchyConstants.DIMENSION_LEFT_KEY);
        j.g(str2, "right");
        String leftPinValue = rangeBar.getLeftPinValue();
        j.f(leftPinValue, "rangeBar.leftPinValue");
        if (((float) Integer.parseInt(leftPinValue)) < f10) {
            matchPreferencesFragment.T0().f15833m.r(f10, Float.parseFloat(str2));
        }
        String rightPinValue = rangeBar.getRightPinValue();
        j.f(rightPinValue, "rangeBar.rightPinValue");
        if (((float) Integer.parseInt(rightPinValue)) > f11) {
            matchPreferencesFragment.T0().f15833m.r(Float.parseFloat(str), f11);
        }
        float b10 = j.b(f10, Float.parseFloat(str));
        float f12 = j.f(f11, Float.parseFloat(str2));
        matchPreferencesFragment.T0().f15823b.setText(g.a(matchPreferencesFragment.requireActivity(), (int) b10, (int) f12));
        matchPreferencesFragment.f13279f = new Pair<>(Float.valueOf(b10), Float.valueOf(f12));
    }

    private final void c1() {
        if (U0().A("Privacy.GdprCopy.Android")) {
            CmbTextView cmbTextView = T0().f15825d;
            j.f(cmbTextView, "binding.fragmentMyProfilePrefsDisclaimerTextview");
            cmbTextView.setVisibility(0);
            String string = getString(R.string.privacy_policy);
            j.f(string, "getString(R.string.privacy_policy)");
            SpannableString spannableString = new SpannableString(getString(R.string.bagel_preference_disclaimer, string));
            String spannableString2 = spannableString.toString();
            j.f(spannableString2, "disclaimer.toString()");
            int b02 = StringsKt__StringsKt.b0(spannableString2, string, 0, false, 6, (Object) null);
            int length = string.length() + b02;
            spannableString.setSpan(new ForegroundColorSpan(-16776961), b02, length, 18);
            spannableString.setSpan(new c(this), b02, length, 18);
            cmbTextView.setText(spannableString);
            cmbTextView.setClickable(true);
            cmbTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    /* access modifiers changed from: private */
    public final void d1(QuestionWAnswers questionWAnswers, boolean z10) {
        Integer num;
        Answer answer = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
        nc.d dVar = null;
        if (answer != null) {
            num = answer.getIntegerValue();
        } else {
            num = null;
        }
        if (num != null) {
            nc.d dVar2 = this.f13278e;
            if (dVar2 == null) {
                j.y("distanceDisplay");
                dVar2 = null;
            }
            String a10 = dVar2.a(z10, num.intValue(), true);
            nc.d dVar3 = this.f13278e;
            if (dVar3 == null) {
                j.y("distanceDisplay");
            } else {
                dVar = dVar3;
            }
            int c10 = dVar.c(num.intValue(), z10);
            T0().f15824c.setText(a10);
            if (c10 > 0 && c10 < T0().f15834n.getTickCount()) {
                T0().f15834n.setSeekPinByIndex(c10);
            }
        }
        T0().f15834n.setOnRangeBarChangeListener(new c(this, z10));
    }

    /* access modifiers changed from: private */
    public static final void e1(MatchPreferencesFragment matchPreferencesFragment, boolean z10, RangeBar rangeBar, int i10, int i11, String str, String str2) {
        j.g(matchPreferencesFragment, "this$0");
        nc.d dVar = matchPreferencesFragment.f13278e;
        nc.d dVar2 = null;
        if (dVar == null) {
            j.y("distanceDisplay");
            dVar = null;
        }
        matchPreferencesFragment.f13282j = Integer.valueOf(dVar.d(i11));
        CmbTextView cmbTextView = matchPreferencesFragment.T0().f15824c;
        nc.d dVar3 = matchPreferencesFragment.f13278e;
        if (dVar3 == null) {
            j.y("distanceDisplay");
        } else {
            dVar2 = dVar3;
        }
        Integer num = matchPreferencesFragment.f13282j;
        j.d(num);
        cmbTextView.setText(dVar2.a(z10, num.intValue(), true));
    }

    /* access modifiers changed from: private */
    public final void f1(QuestionWAnswers questionWAnswers) {
        String str;
        lc.c.a(getActivity());
        List<Option> options = questionWAnswers.e().getOptions();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(options, 10)), 16));
        for (T next : options) {
            linkedHashMap.put(((Option) next).getId(), next);
        }
        List<String> list = this.f13284l;
        List<Answer> d10 = questionWAnswers.d();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = d10.iterator();
        while (true) {
            String str2 = null;
            if (!it.hasNext()) {
                break;
            }
            Option option = (Option) linkedHashMap.get(((Answer) it.next()).getOptionId());
            if (option != null) {
                str2 = option.getId();
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
        }
        list.addAll(arrayList);
        List<Answer> d11 = questionWAnswers.d();
        ArrayList arrayList2 = new ArrayList();
        for (Answer optionId : d11) {
            Option option2 = (Option) linkedHashMap.get(optionId.getOptionId());
            if (option2 != null) {
                str = option2.getTitle();
            } else {
                str = null;
            }
            if (str != null) {
                arrayList2.add(str);
            }
        }
        T0().f15837t.setText(CollectionsKt___CollectionsKt.W(arrayList2, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        T0().f15837t.setOnClickListener(new b(questionWAnswers, this));
    }

    /* access modifiers changed from: private */
    public static final void g1(QuestionWAnswers questionWAnswers, MatchPreferencesFragment matchPreferencesFragment, View view) {
        j.g(questionWAnswers, "$questionWAnswers");
        j.g(matchPreferencesFragment, "this$0");
        ArrayList arrayList = new ArrayList(questionWAnswers.e().getOptions().size());
        ArrayList arrayList2 = new ArrayList(matchPreferencesFragment.f13284l.size());
        for (Option kVar : questionWAnswers.e().getOptions()) {
            k kVar2 = new k(kVar);
            if (matchPreferencesFragment.f13284l.contains(kVar2.b())) {
                arrayList2.add(kVar2);
            }
            arrayList.add(kVar2);
        }
        f0 f0Var = new f0(matchPreferencesFragment.requireActivity(), matchPreferencesFragment.getString(R.string.advanced_preferences_dialog_ethnicity_title), (String) null, matchPreferencesFragment.getString(R.string.done_dls), new d(), arrayList);
        f0Var.k(arrayList2);
        q a02 = f0Var.i().a0(sj.a.a());
        com.uber.autodispose.android.lifecycle.b d10 = com.uber.autodispose.android.lifecycle.b.d(matchPreferencesFragment);
        j.c(d10, "AndroidLifecycleScopeProvider.from(this)");
        ((p) a02.g(com.uber.autodispose.a.a(d10))).c(new i(new MatchPreferencesFragment$setupEthnicityDialog$2$1(matchPreferencesFragment, f0Var)));
        f0Var.show();
        if (f0Var.getWindow() != null) {
            Window window = f0Var.getWindow();
            j.d(window);
            window.setLayout(-1, -2);
        }
    }

    /* access modifiers changed from: private */
    public static final void h1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void i1(QuestionWAnswers questionWAnswers) {
        String str;
        List<Option> options = questionWAnswers.e().getOptions();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(options, 10)), 16));
        for (T next : options) {
            linkedHashMap.put(((Option) next).getId(), next);
        }
        List<Answer> d10 = questionWAnswers.d();
        ArrayList arrayList = new ArrayList();
        for (Answer optionId : d10) {
            Option option = (Option) linkedHashMap.get(optionId.getOptionId());
            if (option != null) {
                str = option.getTitle();
            } else {
                str = null;
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        String W = CollectionsKt___CollectionsKt.W(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        if (j.b(W, MatchPreference$Gender.MEN.b())) {
            lc.c.k(getContext(), T0().f15829h);
            lc.c.b(getContext(), T0().f15830j);
            lc.c.b(getContext(), T0().f15828g);
        } else if (j.b(W, MatchPreference$Gender.WOMEN.b())) {
            lc.c.b(getContext(), T0().f15829h);
            lc.c.k(getContext(), T0().f15830j);
            lc.c.b(getContext(), T0().f15828g);
        } else if (j.b(W, MatchPreference$Gender.EVERYONE.b())) {
            lc.c.b(getContext(), T0().f15829h);
            lc.c.b(getContext(), T0().f15830j);
            lc.c.k(getContext(), T0().f15828g);
        }
    }

    /* access modifiers changed from: private */
    public final void j1(float f10, float f11, QuestionWAnswers questionWAnswers, boolean z10) {
        float f12;
        float f13;
        Float maxValue;
        Float minValue;
        Answer answer = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
        if (answer == null || (minValue = answer.getMinValue()) == null) {
            f12 = f10;
        } else {
            f12 = minValue.floatValue();
        }
        float b10 = j.b(f10, f12);
        Answer answer2 = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
        if (answer2 == null || (maxValue = answer2.getMaxValue()) == null) {
            f13 = f11;
        } else {
            f13 = maxValue.floatValue();
        }
        float f14 = j.f(f11, f13);
        T0().f15835p.r(b10, f14);
        T0().f15838w.setText(g.b(getActivity(), z10, (int) b10, (int) f14));
        T0().f15835p.setOnRangeBarChangeListener(new e(f10, this, f11, z10));
    }

    /* access modifiers changed from: private */
    public static final void k1(float f10, MatchPreferencesFragment matchPreferencesFragment, float f11, boolean z10, RangeBar rangeBar, int i10, int i11, String str, String str2) {
        j.g(matchPreferencesFragment, "this$0");
        j.g(rangeBar, "rangeBar");
        j.g(str, ViewHierarchyConstants.DIMENSION_LEFT_KEY);
        j.g(str2, "right");
        String leftPinValue = rangeBar.getLeftPinValue();
        j.f(leftPinValue, "rangeBar.leftPinValue");
        if (((float) Integer.parseInt(leftPinValue)) < f10) {
            matchPreferencesFragment.T0().f15835p.r(f10, Float.parseFloat(str2));
        }
        String rightPinValue = rangeBar.getRightPinValue();
        j.f(rightPinValue, "rangeBar.rightPinValue");
        if (((float) Integer.parseInt(rightPinValue)) > f11) {
            matchPreferencesFragment.T0().f15835p.r(Float.parseFloat(str), f11);
        }
        float b10 = j.b(f10, Float.parseFloat(str));
        float f12 = j.f(f11, Float.parseFloat(str2));
        matchPreferencesFragment.T0().f15838w.setText(g.b(matchPreferencesFragment.getActivity(), z10, (int) b10, (int) f12));
        matchPreferencesFragment.f13280g = new Pair<>(Float.valueOf(b10), Float.valueOf(f12));
    }

    /* access modifiers changed from: private */
    public final void l1() {
        CmbTextView cmbTextView = T0().f15830j;
        j.f(cmbTextView, "binding.myProfilePreferenceWomen");
        CmbTextView cmbTextView2 = T0().f15829h;
        j.f(cmbTextView2, "binding.myProfilePreferenceMen");
        CmbTextView cmbTextView3 = T0().f15828g;
        j.f(cmbTextView3, "binding.myProfilePreferenceBoth");
        cmbTextView.setOnClickListener(new f(this, cmbTextView, cmbTextView2, cmbTextView3));
        cmbTextView2.setOnClickListener(new g(this, cmbTextView, cmbTextView2, cmbTextView3));
        cmbTextView3.setOnClickListener(new h(this, cmbTextView, cmbTextView2, cmbTextView3));
    }

    /* access modifiers changed from: private */
    public static final void m1(MatchPreferencesFragment matchPreferencesFragment, CmbTextView cmbTextView, CmbTextView cmbTextView2, CmbTextView cmbTextView3, View view) {
        j.g(matchPreferencesFragment, "this$0");
        j.g(cmbTextView, "$buttonWomen");
        j.g(cmbTextView2, "$buttonMen");
        j.g(cmbTextView3, "$buttonBoth");
        lc.c.k(matchPreferencesFragment.getContext(), cmbTextView);
        lc.c.b(matchPreferencesFragment.getContext(), cmbTextView2);
        lc.c.b(matchPreferencesFragment.getContext(), cmbTextView3);
        matchPreferencesFragment.f13281h = cmbTextView.getTag().toString();
    }

    /* access modifiers changed from: private */
    public static final void n1(MatchPreferencesFragment matchPreferencesFragment, CmbTextView cmbTextView, CmbTextView cmbTextView2, CmbTextView cmbTextView3, View view) {
        j.g(matchPreferencesFragment, "this$0");
        j.g(cmbTextView, "$buttonWomen");
        j.g(cmbTextView2, "$buttonMen");
        j.g(cmbTextView3, "$buttonBoth");
        lc.c.b(matchPreferencesFragment.getContext(), cmbTextView);
        lc.c.k(matchPreferencesFragment.getContext(), cmbTextView2);
        lc.c.b(matchPreferencesFragment.getContext(), cmbTextView3);
        matchPreferencesFragment.f13281h = cmbTextView2.getTag().toString();
    }

    /* access modifiers changed from: private */
    public static final void o1(MatchPreferencesFragment matchPreferencesFragment, CmbTextView cmbTextView, CmbTextView cmbTextView2, CmbTextView cmbTextView3, View view) {
        j.g(matchPreferencesFragment, "this$0");
        j.g(cmbTextView, "$buttonWomen");
        j.g(cmbTextView2, "$buttonMen");
        j.g(cmbTextView3, "$buttonBoth");
        lc.c.b(matchPreferencesFragment.getContext(), cmbTextView);
        lc.c.b(matchPreferencesFragment.getContext(), cmbTextView2);
        lc.c.k(matchPreferencesFragment.getContext(), cmbTextView3);
        matchPreferencesFragment.f13281h = cmbTextView3.getTag().toString();
    }

    /* access modifiers changed from: private */
    public final void p1(QuestionWAnswers questionWAnswers) {
        String str;
        lc.c.a(getActivity());
        List<Option> options = questionWAnswers.e().getOptions();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(options, 10)), 16));
        for (T next : options) {
            linkedHashMap.put(((Option) next).getId(), next);
        }
        List<String> list = this.f13283k;
        List<Answer> d10 = questionWAnswers.d();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = d10.iterator();
        while (true) {
            String str2 = null;
            if (!it.hasNext()) {
                break;
            }
            Option option = (Option) linkedHashMap.get(((Answer) it.next()).getOptionId());
            if (option != null) {
                str2 = option.getId();
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
        }
        list.addAll(arrayList);
        List<Answer> d11 = questionWAnswers.d();
        ArrayList arrayList2 = new ArrayList();
        for (Answer optionId : d11) {
            Option option2 = (Option) linkedHashMap.get(optionId.getOptionId());
            if (option2 != null) {
                str = option2.getTitle();
            } else {
                str = null;
            }
            if (str != null) {
                arrayList2.add(str);
            }
        }
        T0().f15839x.setText(CollectionsKt___CollectionsKt.W(arrayList2, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        T0().f15839x.setOnClickListener(new a(questionWAnswers, this));
    }

    /* access modifiers changed from: private */
    public static final void q1(QuestionWAnswers questionWAnswers, MatchPreferencesFragment matchPreferencesFragment, View view) {
        j.g(questionWAnswers, "$questionWAnswers");
        j.g(matchPreferencesFragment, "this$0");
        ArrayList arrayList = new ArrayList(questionWAnswers.e().getOptions().size());
        ArrayList arrayList2 = new ArrayList(matchPreferencesFragment.f13283k.size());
        for (Option kVar : questionWAnswers.e().getOptions()) {
            k kVar2 = new k(kVar);
            if (matchPreferencesFragment.f13283k.contains(kVar2.b())) {
                arrayList2.add(kVar2);
            }
            arrayList.add(kVar2);
        }
        f0 f0Var = new f0(matchPreferencesFragment.requireActivity(), matchPreferencesFragment.getString(R.string.advanced_preferences_dialog_ethnicity_title), (String) null, matchPreferencesFragment.getString(R.string.done_dls), new e(), arrayList);
        f0Var.k(arrayList2);
        q a02 = f0Var.i().a0(sj.a.a());
        com.uber.autodispose.android.lifecycle.b d10 = com.uber.autodispose.android.lifecycle.b.d(matchPreferencesFragment);
        j.c(d10, "AndroidLifecycleScopeProvider.from(this)");
        ((p) a02.g(com.uber.autodispose.a.a(d10))).c(new j(new MatchPreferencesFragment$setupReligionDialog$2$1(matchPreferencesFragment, f0Var)));
        f0Var.show();
        if (f0Var.getWindow() != null) {
            Window window = f0Var.getWindow();
            j.d(window);
            window.setLayout(-1, -2);
        }
    }

    /* access modifiers changed from: private */
    public static final void r1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final v T0() {
        v vVar = this.f13277d;
        if (vVar != null) {
            return vVar;
        }
        j.y("binding");
        return null;
    }

    public final FeatureFlagRepository U0() {
        FeatureFlagRepository featureFlagRepository = this.f13275b;
        if (featureFlagRepository != null) {
            return featureFlagRepository;
        }
        j.y("featureManager");
        return null;
    }

    public final MatchPreferencesViewModel V0() {
        MatchPreferencesViewModel matchPreferencesViewModel = this.f13276c;
        if (matchPreferencesViewModel != null) {
            return matchPreferencesViewModel;
        }
        j.y("viewModel");
        return null;
    }

    public final l W0() {
        l lVar = this.f13274a;
        if (lVar != null) {
            return lVar;
        }
        j.y("viewModelFactory");
        return null;
    }

    public final void X0(v vVar) {
        j.g(vVar, "<set-?>");
        this.f13277d = vVar;
    }

    public final void Y0(MatchPreferencesViewModel matchPreferencesViewModel) {
        j.g(matchPreferencesViewModel, "<set-?>");
        this.f13276c = matchPreferencesViewModel;
    }

    public void d() {
        if (this.f13279f != null) {
            MatchPreferencesViewModel V0 = V0();
            Pair<Float, Float> pair = this.f13279f;
            j.d(pair);
            V0.s(pair);
        }
        if (this.f13280g != null) {
            MatchPreferencesViewModel V02 = V0();
            Pair<Float, Float> pair2 = this.f13280g;
            j.d(pair2);
            V02.w(pair2);
        }
        if (this.f13281h != null) {
            MatchPreferencesViewModel V03 = V0();
            String str = this.f13281h;
            j.d(str);
            V03.v(str);
        }
        if (this.f13282j != null) {
            MatchPreferencesViewModel V04 = V0();
            Integer num = this.f13282j;
            j.d(num);
            V04.t(num.intValue());
        }
        if (!this.f13283k.isEmpty()) {
            V0().x(this.f13283k);
        }
        if (!this.f13284l.isEmpty()) {
            V0().u(this.f13284l);
        }
        V0().y();
        h requireActivity = requireActivity();
        j.e(requireActivity, "null cannot be cast to non-null type com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperActivity");
        ((ProfileCompletionHelperActivity) requireActivity).next();
    }

    public void onCreate(Bundle bundle) {
        Bakery.j().L1(this);
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        Y0((MatchPreferencesViewModel) new i0((l0) this, (i0.b) W0()).a(MatchPreferencesViewModel.class));
        v c10 = v.c(layoutInflater, viewGroup, false);
        j.f(c10, "inflate(inflater, container, false)");
        X0(c10);
        if (requireArguments().getBoolean("EXTRA_SHOULD_SHOW_WHAT_DO_YOU_LIKE")) {
            T0().f15832l.setVisibility(0);
            T0().f15831k.setVisibility(8);
        } else {
            T0().f15832l.setVisibility(0);
            T0().f15831k.setVisibility(0);
        }
        V0().m().i(getViewLifecycleOwner(), new b(new MatchPreferencesFragment$onCreateView$1(this)));
        V0().p().i(getViewLifecycleOwner(), new b(new MatchPreferencesFragment$onCreateView$2(this)));
        V0().q().i(getViewLifecycleOwner(), new b(new MatchPreferencesFragment$onCreateView$3(this)));
        V0().n().i(getViewLifecycleOwner(), new b(new MatchPreferencesFragment$onCreateView$4(this)));
        V0().r().i(getViewLifecycleOwner(), new b(new MatchPreferencesFragment$onCreateView$5(this)));
        V0().o().i(getViewLifecycleOwner(), new b(new MatchPreferencesFragment$onCreateView$6(this)));
        c1();
        ScrollView b10 = T0().getRoot();
        j.f(b10, "binding.root");
        return b10;
    }

    public void onViewCreated(View view, Bundle bundle) {
        j.g(view, "view");
        super.onViewCreated(view, bundle);
        Resources resources = requireActivity().getResources();
        j.f(resources, "requireActivity().resources");
        this.f13278e = new nc.d(resources);
    }
}
