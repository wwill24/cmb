package com.coffeemeetsbagel.new_user_experience.match_prefs.age;

import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant;
import com.coffeemeetsbagel.new_user_experience.numberPickers.OnboardingPicker;
import com.jakewharton.rxrelay2.PublishRelay;
import j5.x;
import k6.e;
import kotlin.Pair;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;

public final class k extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final e f35190e;

    /* renamed from: f  reason: collision with root package name */
    private final String f35191f;

    /* renamed from: g  reason: collision with root package name */
    private final PublishRelay<x> f35192g;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35193a;

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
                f35193a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.match_prefs.age.k.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(e eVar) {
        super(eVar.getRoot());
        j.g(eVar, "binding");
        this.f35190e = eVar;
        String string = ((ViewGroup) this.f7869c).getResources().getString(R.string.onboarding_save_error);
        j.f(string, "view.resources.getString…ng.onboarding_save_error)");
        this.f35191f = string;
        PublishRelay<x> C0 = PublishRelay.C0();
        j.f(C0, "create<Irrelevant>()");
        this.f35192g = C0;
    }

    private final void p(NumberPicker numberPicker, int i10) {
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setDescendantFocusability(Opcodes.ASM6);
        numberPicker.setMaxValue(99);
        numberPicker.setMinValue(18);
        numberPicker.setValue(i10);
    }

    /* access modifiers changed from: private */
    public static final void r(k kVar, NumberPicker numberPicker, int i10, int i11) {
        j.g(kVar, "this$0");
        if (kVar.f35190e.f15726c.getValue() > kVar.f35190e.f15725b.getValue()) {
            OnboardingPicker onboardingPicker = kVar.f35190e.f15725b;
            j.f(onboardingPicker, "binding.ageHigh");
            kVar.p(onboardingPicker, kVar.f35190e.f15726c.getValue());
        }
    }

    /* access modifiers changed from: private */
    public static final void t(k kVar, NumberPicker numberPicker, int i10, int i11) {
        j.g(kVar, "this$0");
        if (kVar.f35190e.f15725b.getValue() < kVar.f35190e.f15726c.getValue()) {
            OnboardingPicker onboardingPicker = kVar.f35190e.f15726c;
            j.f(onboardingPicker, "binding.ageLow");
            kVar.p(onboardingPicker, kVar.f35190e.f15725b.getValue());
        }
    }

    public final Pair<Integer, Integer> l() {
        return new Pair<>(Integer.valueOf(this.f35190e.f15726c.getValue()), Integer.valueOf(this.f35190e.f15725b.getValue()));
    }

    public final boolean m() {
        return this.f35190e.f15728e.isChecked();
    }

    public final PublishRelay<x> n() {
        return this.f35192g;
    }

    public final String o() {
        return this.f35191f;
    }

    public final void q(int i10, int i11, boolean z10, DealbreakerVariant dealbreakerVariant, Integer num) {
        j.g(dealbreakerVariant, "variant");
        this.f35190e.f15729f.setText(t9.a.onboardingDealbreakersMessageAge);
        int i12 = a.f35193a[dealbreakerVariant.ordinal()];
        if (i12 == 1) {
            this.f35190e.f15730g.setVisibility(8);
            this.f35190e.f15731h.setVisibility(8);
            this.f35190e.f15728e.setVisibility(8);
        } else if (i12 == 2) {
            TextView textView = this.f35190e.f15730g;
            textView.setVisibility(0);
            textView.setText(R.string.match_prefs_dealbreaker_label_a);
            TextView textView2 = this.f35190e.f15731h;
            textView2.setVisibility(0);
            textView2.setText(R.string.match_prefs_dealbreaker_title_a);
            this.f35190e.f15728e.setVisibility(0);
            this.f35190e.f15728e.setChecked(z10);
        } else if (i12 == 3) {
            TextView textView3 = this.f35190e.f15730g;
            textView3.setVisibility(0);
            textView3.setText(textView3.getContext().getString(R.string.match_prefs_dealbreaker_label_b_age, new Object[]{num}));
            TextView textView4 = this.f35190e.f15731h;
            textView4.setVisibility(0);
            textView4.setText(R.string.match_prefs_dealbreaker_title_b);
            this.f35190e.f15728e.setVisibility(0);
            this.f35190e.f15728e.setChecked(!z10);
        }
        OnboardingPicker onboardingPicker = this.f35190e.f15726c;
        j.f(onboardingPicker, "binding.ageLow");
        p(onboardingPicker, i10);
        this.f35190e.f15726c.setOnValueChangedListener(new i(this));
        OnboardingPicker onboardingPicker2 = this.f35190e.f15725b;
        j.f(onboardingPicker2, "binding.ageHigh");
        p(onboardingPicker2, i11);
        this.f35190e.f15725b.setOnValueChangedListener(new j(this));
        this.f35192g.accept(x.a());
    }
}
