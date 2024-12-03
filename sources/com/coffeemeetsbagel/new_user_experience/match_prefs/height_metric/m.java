package com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant;
import com.jakewharton.rxrelay2.PublishRelay;
import j5.x;
import k6.z;
import kotlin.Pair;
import kotlin.jvm.internal.j;

public final class m extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final z f35442e;

    /* renamed from: f  reason: collision with root package name */
    private final a f35443f;

    /* renamed from: g  reason: collision with root package name */
    private final String f35444g;

    /* renamed from: h  reason: collision with root package name */
    private final PublishRelay<x> f35445h;

    /* renamed from: j  reason: collision with root package name */
    private final NumberPicker.OnValueChangeListener f35446j = new l(this);

    public interface a {
        void e();
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35447a;

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
                f35447a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.match_prefs.height_metric.m.b.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(z zVar, a aVar) {
        super(zVar.getRoot());
        j.g(zVar, "binding");
        j.g(aVar, "userInputListener");
        this.f35442e = zVar;
        this.f35443f = aVar;
        String string = ((ViewGroup) this.f7869c).getResources().getString(R.string.onboarding_save_error);
        j.f(string, "view.resources.getString…ng.onboarding_save_error)");
        this.f35444g = string;
        PublishRelay<x> C0 = PublishRelay.C0();
        j.f(C0, "create<Irrelevant>()");
        this.f35445h = C0;
    }

    /* access modifiers changed from: private */
    public static final void l(m mVar, NumberPicker numberPicker, int i10, int i11) {
        j.g(mVar, "this$0");
        if (mVar.f35442e.f15879g.getValue() < mVar.f35442e.f15878f.getValue()) {
            z zVar = mVar.f35442e;
            zVar.f15878f.setValue(zVar.f15879g.getValue());
        } else if (mVar.f35442e.f15878f.getValue() > mVar.f35442e.f15879g.getValue()) {
            z zVar2 = mVar.f35442e;
            zVar2.f15879g.setValue(zVar2.f15878f.getValue());
        }
        mVar.f35445h.accept(x.a());
    }

    private final void q(View view, boolean z10) {
        view.setEnabled(z10);
        if (!z10) {
            this.f35442e.f15882k.setTextColor(androidx.core.content.a.getColor(view.getContext(), R.color.gray));
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                j.f(childAt, "view.getChildAt(idx)");
                q(childAt, z10);
            }
        }
    }

    public static /* synthetic */ void t(m mVar, Integer num, Integer num2, DealbreakerVariant dealbreakerVariant, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            dealbreakerVariant = DealbreakerVariant.DISABLED;
        }
        DealbreakerVariant dealbreakerVariant2 = dealbreakerVariant;
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        mVar.r(num, num2, dealbreakerVariant2, z10, z11);
    }

    /* access modifiers changed from: private */
    public static final void u(m mVar, View view) {
        j.g(mVar, "this$0");
        mVar.f35443f.e();
    }

    public final PublishRelay<x> m() {
        return this.f35445h;
    }

    public final String n() {
        return this.f35444g;
    }

    public final Pair<Integer, Integer> o() {
        return new Pair<>(Integer.valueOf(this.f35442e.f15878f.getValue()), Integer.valueOf(this.f35442e.f15879g.getValue()));
    }

    public final boolean p() {
        return this.f35442e.f15876d.isChecked();
    }

    public final void r(Integer num, Integer num2, DealbreakerVariant dealbreakerVariant, boolean z10, boolean z11) {
        j.g(dealbreakerVariant, "variant");
        this.f35442e.f15877e.setText(t9.a.onboardingDealbreakersMessageHeight);
        if (num != null) {
            this.f35442e.f15878f.setValue(num.intValue());
        }
        if (num2 != null) {
            this.f35442e.f15879g.setValue(num2.intValue());
        }
        LinearLayout linearLayout = this.f35442e.f15874b;
        j.f(linearLayout, "binding.contents");
        q(linearLayout, !z11);
        this.f35442e.f15879g.setOnValueChangedListener(this.f35446j);
        this.f35442e.f15878f.setOnValueChangedListener(this.f35446j);
        int i10 = b.f35447a[dealbreakerVariant.ordinal()];
        if (i10 == 1) {
            this.f35442e.f15880h.setVisibility(8);
            this.f35442e.f15881j.setVisibility(8);
            this.f35442e.f15876d.setVisibility(8);
        } else if (i10 == 2) {
            TextView textView = this.f35442e.f15880h;
            textView.setVisibility(0);
            textView.setText(R.string.match_prefs_dealbreaker_label_a);
            TextView textView2 = this.f35442e.f15881j;
            textView2.setVisibility(0);
            textView2.setText(R.string.match_prefs_dealbreaker_title_a);
            this.f35442e.f15876d.setVisibility(0);
            this.f35442e.f15876d.setChecked(z10);
        } else if (i10 == 3) {
            this.f35442e.f15880h.setVisibility(8);
            TextView textView3 = this.f35442e.f15881j;
            textView3.setVisibility(0);
            textView3.setText(R.string.match_prefs_dealbreaker_title_b);
            this.f35442e.f15876d.setVisibility(0);
            this.f35442e.f15876d.setChecked(true ^ z10);
        }
        if (z11) {
            this.f35442e.f15884m.setOnClickListener(new k(this));
            this.f35442e.f15883l.setVisibility(0);
            this.f35442e.f15876d.setEnabled(false);
            return;
        }
        this.f35442e.f15883l.setVisibility(8);
    }
}
