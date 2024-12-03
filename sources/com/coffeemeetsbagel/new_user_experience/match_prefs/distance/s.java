package com.coffeemeetsbagel.new_user_experience.match_prefs.distance;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant;
import com.coffeemeetsbagel.new_user_experience.numberPickers.OnboardingPicker;
import com.jakewharton.rxrelay2.PublishRelay;
import j5.x;
import java.util.List;
import k6.j;
import nc.d;

public final class s extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final j f35319e;

    /* renamed from: f  reason: collision with root package name */
    private final String f35320f;

    /* renamed from: g  reason: collision with root package name */
    private final PublishRelay<x> f35321g;

    /* renamed from: h  reason: collision with root package name */
    private final d f35322h;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35323a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant[] r0 = com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant r1 = com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant.DISABLED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant r1 = com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant.VARIANT_A     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant r1 = com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant.VARIANT_B     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f35323a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.match_prefs.distance.s.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(j jVar) {
        super(jVar.getRoot());
        kotlin.jvm.internal.j.g(jVar, "binding");
        this.f35319e = jVar;
        String string = ((ViewGroup) this.f7869c).getResources().getString(R.string.onboarding_save_error);
        kotlin.jvm.internal.j.f(string, "view.resources.getString…ng.onboarding_save_error)");
        this.f35320f = string;
        PublishRelay<x> C0 = PublishRelay.C0();
        kotlin.jvm.internal.j.f(C0, "create<Irrelevant>()");
        this.f35321g = C0;
        Resources resources = jVar.getRoot().getResources();
        kotlin.jvm.internal.j.f(resources, "binding.root.resources");
        this.f35322h = new d(resources);
    }

    public static /* synthetic */ void q(s sVar, Integer num, boolean z10, boolean z11, DealbreakerVariant dealbreakerVariant, boolean z12, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        boolean z13 = z11;
        if ((i10 & 8) != 0) {
            dealbreakerVariant = DealbreakerVariant.DISABLED;
        }
        sVar.p(num, z10, z13, dealbreakerVariant, z12);
    }

    /* access modifiers changed from: private */
    public static final void r(s sVar, NumberPicker numberPicker, int i10, int i11) {
        kotlin.jvm.internal.j.g(sVar, "this$0");
        sVar.f35321g.accept(x.a());
    }

    public final boolean k() {
        return this.f35319e.f15768b.isChecked();
    }

    public final int l() {
        return this.f35322h.d(this.f35319e.f15770d.getValue());
    }

    public final int m() {
        return this.f35322h.f(this.f35319e.f15770d.getValue());
    }

    public final PublishRelay<x> n() {
        return this.f35321g;
    }

    public final String o() {
        return this.f35320f;
    }

    public final void p(Integer num, boolean z10, boolean z11, DealbreakerVariant dealbreakerVariant, boolean z12) {
        kotlin.jvm.internal.j.g(dealbreakerVariant, "variant");
        this.f35319e.f15769c.setText(t9.a.onboardingDealbreakersMessageDistance);
        List<String> b10 = this.f35322h.b(z10);
        OnboardingPicker onboardingPicker = this.f35319e.f15770d;
        onboardingPicker.setMinValue(0);
        onboardingPicker.setMaxValue(b10.size() - 1);
        onboardingPicker.setDisplayedValues((String[]) b10.toArray(new String[0]));
        if (num != null) {
            num.intValue();
            this.f35319e.f15770d.setValue(this.f35322h.c(num.intValue(), z12));
        }
        this.f35319e.f15770d.setOnValueChangedListener(new r(this));
        int i10 = a.f35323a[dealbreakerVariant.ordinal()];
        if (i10 == 1) {
            this.f35319e.f15771e.setVisibility(8);
            this.f35319e.f15772f.setVisibility(8);
            this.f35319e.f15768b.setVisibility(8);
        } else if (i10 == 2) {
            TextView textView = this.f35319e.f15771e;
            textView.setVisibility(0);
            textView.setText(R.string.match_prefs_dealbreaker_label_a);
            TextView textView2 = this.f35319e.f15772f;
            textView2.setVisibility(0);
            textView2.setText(R.string.match_prefs_dealbreaker_title_a);
            this.f35319e.f15768b.setVisibility(0);
            this.f35319e.f15768b.setChecked(z11);
        } else if (i10 == 3) {
            TextView textView3 = this.f35319e.f15771e;
            textView3.setVisibility(0);
            textView3.setText(R.string.match_prefs_dealbreaker_title_b);
            TextView textView4 = this.f35319e.f15772f;
            textView4.setVisibility(0);
            textView4.setText(R.string.match_prefs_dealbreaker_title_b);
            this.f35319e.f15768b.setVisibility(0);
            this.f35319e.f15768b.setChecked(!z11);
        }
    }
}
