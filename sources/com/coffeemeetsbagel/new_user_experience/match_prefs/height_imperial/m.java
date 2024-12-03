package com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant;
import com.coffeemeetsbagel.new_user_experience.numberPickers.FeetHeightPicker;
import com.coffeemeetsbagel.new_user_experience.numberPickers.InchesHeightPicker;
import com.coffeemeetsbagel.new_user_experience.numberPickers.OnboardingPicker;
import com.jakewharton.rxrelay2.PublishRelay;
import j5.x;
import k6.y;
import kotlin.Pair;
import kotlin.jvm.internal.j;

public final class m extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final y f35409e;

    /* renamed from: f  reason: collision with root package name */
    private final a f35410f;

    /* renamed from: g  reason: collision with root package name */
    private final String f35411g;

    /* renamed from: h  reason: collision with root package name */
    private final PublishRelay<x> f35412h;

    /* renamed from: j  reason: collision with root package name */
    private final NumberPicker.OnValueChangeListener f35413j = new l(this);

    public interface a {
        void e();
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35414a;

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
                f35414a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial.m.b.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(y yVar, a aVar) {
        super(yVar.getRoot());
        j.g(yVar, "binding");
        j.g(aVar, "userInputListener");
        this.f35409e = yVar;
        this.f35410f = aVar;
        String string = ((ViewGroup) this.f7869c).getResources().getString(R.string.onboarding_save_error);
        j.f(string, "view.resources.getString…ng.onboarding_save_error)");
        this.f35411g = string;
        PublishRelay<x> C0 = PublishRelay.C0();
        j.f(C0, "create<Irrelevant>()");
        this.f35412h = C0;
    }

    /* access modifiers changed from: private */
    public static final void l(m mVar, NumberPicker numberPicker, int i10, int i11) {
        boolean z10;
        j.g(mVar, "this$0");
        if (mVar.r(mVar.f35409e).a(mVar.q(mVar.f35409e)) > 0) {
            boolean z11 = true;
            if (j.b(numberPicker, mVar.f35409e.f15862e)) {
                z10 = true;
            } else {
                z10 = j.b(numberPicker, mVar.f35409e.f15864g);
            }
            if (z10) {
                y yVar = mVar.f35409e;
                yVar.f15863f.setValue(yVar.f15862e.getValue());
                y yVar2 = mVar.f35409e;
                yVar2.f15865h.setValue(yVar2.f15864g.getValue());
            } else {
                if (!j.b(numberPicker, mVar.f35409e.f15863f)) {
                    z11 = j.b(numberPicker, mVar.f35409e.f15865h);
                }
                if (z11) {
                    y yVar3 = mVar.f35409e;
                    yVar3.f15862e.setValue(yVar3.f15863f.getValue());
                    y yVar4 = mVar.f35409e;
                    yVar4.f15864g.setValue(yVar4.f15865h.getValue());
                }
            }
        }
        mVar.f35412h.accept(x.a());
    }

    private final o q(y yVar) {
        return new o(yVar.f15863f.getValue(), yVar.f15865h.getValue());
    }

    private final o r(y yVar) {
        return new o(yVar.f15862e.getValue(), yVar.f15864g.getValue());
    }

    private final void t(View view, boolean z10) {
        view.setEnabled(z10);
        if (!z10) {
            this.f35409e.f15868l.setTextColor(androidx.core.content.a.getColor(view.getContext(), R.color.gray));
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                j.f(childAt, "view.getChildAt(idx)");
                t(childAt, z10);
            }
        }
    }

    private final void u(OnboardingPicker onboardingPicker, int i10, NumberPicker.OnValueChangeListener onValueChangeListener) {
        onboardingPicker.setValue(i10);
        onboardingPicker.setOnValueChangedListener(onValueChangeListener);
    }

    /* access modifiers changed from: private */
    public static final void w(m mVar, View view) {
        j.g(mVar, "this$0");
        mVar.f35410f.e();
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        this.f35409e.f15861d.setText(t9.a.onboardingDealbreakersMessageHeight);
    }

    public final PublishRelay<x> m() {
        return this.f35412h;
    }

    public final String n() {
        return this.f35411g;
    }

    public final Pair<o, o> o() {
        return new Pair<>(r(this.f35409e), q(this.f35409e));
    }

    public final boolean p() {
        return this.f35409e.f15860c.isChecked();
    }

    public final void v(Pair<o, o> pair, DealbreakerVariant dealbreakerVariant, boolean z10, boolean z11) {
        j.g(pair, "range");
        j.g(dealbreakerVariant, "variant");
        int i10 = b.f35414a[dealbreakerVariant.ordinal()];
        if (i10 == 1) {
            this.f35409e.f15866j.setVisibility(8);
            this.f35409e.f15867k.setVisibility(8);
            this.f35409e.f15860c.setVisibility(8);
        } else if (i10 == 2) {
            TextView textView = this.f35409e.f15866j;
            textView.setVisibility(0);
            textView.setText(R.string.match_prefs_dealbreaker_label_a);
            TextView textView2 = this.f35409e.f15867k;
            textView2.setVisibility(0);
            textView2.setText(R.string.match_prefs_dealbreaker_title_a);
            this.f35409e.f15860c.setVisibility(0);
            this.f35409e.f15860c.setChecked(z10);
        } else if (i10 == 3) {
            this.f35409e.f15866j.setVisibility(8);
            TextView textView3 = this.f35409e.f15867k;
            textView3.setVisibility(0);
            textView3.setText(R.string.match_prefs_dealbreaker_title_b);
            this.f35409e.f15860c.setVisibility(0);
            this.f35409e.f15860c.setChecked(!z10);
        }
        LinearLayout linearLayout = this.f35409e.f15859b;
        j.f(linearLayout, "binding.contents");
        t(linearLayout, !z11);
        FeetHeightPicker feetHeightPicker = this.f35409e.f15862e;
        j.f(feetHeightPicker, "binding.pickerFeetFrom");
        u(feetHeightPicker, pair.c().b(), this.f35413j);
        InchesHeightPicker inchesHeightPicker = this.f35409e.f15864g;
        j.f(inchesHeightPicker, "binding.pickerInchesFrom");
        u(inchesHeightPicker, pair.c().c(), this.f35413j);
        FeetHeightPicker feetHeightPicker2 = this.f35409e.f15863f;
        j.f(feetHeightPicker2, "binding.pickerFeetTo");
        u(feetHeightPicker2, pair.d().b(), this.f35413j);
        InchesHeightPicker inchesHeightPicker2 = this.f35409e.f15865h;
        j.f(inchesHeightPicker2, "binding.pickerInchesTo");
        u(inchesHeightPicker2, pair.d().c(), this.f35413j);
        if (z11) {
            this.f35409e.f15870n.setOnClickListener(new k(this));
            this.f35409e.f15869m.setVisibility(0);
            this.f35409e.f15860c.setEnabled(false);
            return;
        }
        this.f35409e.f15869m.setVisibility(8);
    }
}
