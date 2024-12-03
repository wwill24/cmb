package com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbRadioGroup;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.entities.QuestionInteractionPolicy;
import com.coffeemeetsbagel.models.enums.QuestionType;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import gk.f;
import ia.d;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import qj.q;

public final class PremiumPreferencePresenter extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final d f35239e;

    /* renamed from: f  reason: collision with root package name */
    private final a f35240f;

    /* renamed from: g  reason: collision with root package name */
    private final f f35241g = b.b(new PremiumPreferencePresenter$radioGroup$2(this));

    /* renamed from: h  reason: collision with root package name */
    private final String f35242h;

    public interface a {
        void X0();

        void e();
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35243a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant[] r0 = com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant r1 = com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant.VARIANT_A     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant r1 = com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant.VARIANT_B     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant r1 = com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant.DISABLED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f35243a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.PremiumPreferencePresenter.b.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PremiumPreferencePresenter(d dVar, a aVar) {
        super(dVar.getRoot());
        j.g(dVar, "binding");
        j.g(aVar, "userInputListener");
        this.f35239e = dVar;
        this.f35240f = aVar;
        String string = ((ViewGroup) this.f7869c).getResources().getString(R.string.onboarding_save_error);
        j.f(string, "view.resources.getString…ng.onboarding_save_error)");
        this.f35242h = string;
    }

    /* access modifiers changed from: private */
    public static final void n(PremiumPreferencePresenter premiumPreferencePresenter, View view) {
        j.g(premiumPreferencePresenter, "this$0");
        premiumPreferencePresenter.f35240f.X0();
    }

    /* access modifiers changed from: private */
    public static final void o(View view) {
    }

    /* access modifiers changed from: private */
    public static final void p(PremiumPreferencePresenter premiumPreferencePresenter, View view) {
        j.g(premiumPreferencePresenter, "this$0");
        premiumPreferencePresenter.f35240f.e();
    }

    private final CmbRadioGroup<Option> t() {
        return (CmbRadioGroup) this.f35241g.getValue();
    }

    public static /* synthetic */ void z(PremiumPreferencePresenter premiumPreferencePresenter, DealbreakerVariant dealbreakerVariant, Integer num, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            num = null;
        }
        premiumPreferencePresenter.y(dealbreakerVariant, num);
    }

    public final void m(QuestionWAnswers questionWAnswers, boolean z10, boolean z11) {
        boolean z12;
        boolean z13;
        Boolean isDealbreaker;
        Integer maxOptions;
        int i10;
        Integer maxOptions2;
        j.g(questionWAnswers, "question");
        this.f35239e.f40943f.setText(questionWAnswers.e().getText());
        LayoutInflater from = LayoutInflater.from(((ViewGroup) this.f7869c).getContext());
        Iterator<T> it = questionWAnswers.e().getOptions().iterator();
        while (true) {
            z12 = true;
            if (!it.hasNext()) {
                break;
            }
            Option option = (Option) it.next();
            CheckBox checkBox = (CheckBox) t().findViewWithTag(option);
            if (checkBox == null) {
                s5.a c10 = s5.a.c(from, t(), false);
                j.f(c10, "inflate(layoutInflater, radioGroup, false)");
                checkBox = c10.getRoot();
                j.f(checkBox, "binding.root");
                t().b(checkBox, option);
            }
            checkBox.setText(option.getTitle());
            if (z10) {
                checkBox.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, androidx.core.content.a.getDrawable(((ViewGroup) this.f7869c).getContext(), R.drawable.ic_lock), (Drawable) null);
                checkBox.setOnClickListener(new t(this));
            } else {
                checkBox.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, androidx.core.content.a.getDrawable(((ViewGroup) this.f7869c).getContext(), R.drawable.select_circle_filled_button), (Drawable) null);
                for (Answer optionId : questionWAnswers.d()) {
                    if (j.b(option.getId(), optionId.getOptionId())) {
                        checkBox.setChecked(true);
                    }
                }
                checkBox.setOnClickListener(new u());
            }
        }
        if (questionWAnswers.e().getType() == QuestionType.SINGLE_CHOICE) {
            t().setMaxOptions(1);
        } else {
            CmbRadioGroup<Option> t10 = t();
            QuestionInteractionPolicy interactionPolicy = questionWAnswers.e().getInteractionPolicy();
            if (interactionPolicy == null || (maxOptions2 = interactionPolicy.getMaxOptions()) == null) {
                i10 = Integer.MIN_VALUE;
            } else {
                i10 = maxOptions2.intValue();
            }
            t10.setMaxOptions(i10);
        }
        QuestionInteractionPolicy interactionPolicy2 = questionWAnswers.e().getInteractionPolicy();
        if (!(interactionPolicy2 == null || (maxOptions = interactionPolicy2.getMaxOptions()) == null)) {
            t().setMaxOptions(maxOptions.intValue());
        }
        if (z10) {
            this.f35239e.f40945h.setOnClickListener(new v(this));
            this.f35239e.f40944g.setVisibility(0);
            this.f35239e.f40940c.setEnabled(false);
        } else {
            this.f35239e.f40944g.setVisibility(8);
        }
        Answer answer = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
        if (answer == null || (isDealbreaker = answer.isDealbreaker()) == null) {
            z13 = false;
        } else {
            z13 = isDealbreaker.booleanValue();
        }
        SwitchCompat switchCompat = this.f35239e.f40940c;
        if (!z11) {
            z12 = z13;
        } else if (z13) {
            z12 = false;
        }
        switchCompat.setChecked(z12);
    }

    public final d q() {
        return this.f35239e;
    }

    public final boolean r(DealbreakerVariant dealbreakerVariant) {
        j.g(dealbreakerVariant, "variant");
        int i10 = b.f35243a[dealbreakerVariant.ordinal()];
        if (i10 == 1) {
            return this.f35239e.f40940c.isChecked();
        }
        if (i10 == 2 && !this.f35239e.f40940c.isChecked()) {
            return true;
        }
        return false;
    }

    public final List<Option> u() {
        return t().getCheckedTags();
    }

    public final q<Option> v() {
        return t().h();
    }

    public final String w() {
        return this.f35242h;
    }

    public final void y(DealbreakerVariant dealbreakerVariant, Integer num) {
        j.g(dealbreakerVariant, "variant");
        int i10 = b.f35243a[dealbreakerVariant.ordinal()];
        if (i10 == 1) {
            TextView textView = this.f35239e.f40941d;
            textView.setVisibility(0);
            textView.setText(R.string.match_prefs_dealbreaker_label_a);
            TextView textView2 = this.f35239e.f40942e;
            textView2.setVisibility(0);
            textView2.setText(R.string.match_prefs_dealbreaker_title_a);
            this.f35239e.f40940c.setVisibility(0);
        } else if (i10 == 2) {
            TextView textView3 = this.f35239e.f40941d;
            textView3.setVisibility(8);
            if (num != null) {
                num.intValue();
                textView3.setText(textView3.getContext().getString(R.string.match_prefs_dealbreaker_label_b_age, new Object[]{num}));
            }
            TextView textView4 = this.f35239e.f40942e;
            textView4.setVisibility(0);
            textView4.setText(R.string.match_prefs_dealbreaker_title_b);
            this.f35239e.f40940c.setVisibility(0);
        } else if (i10 == 3) {
            this.f35239e.f40941d.setVisibility(8);
            this.f35239e.f40942e.setVisibility(8);
            this.f35239e.f40940c.setVisibility(8);
        }
    }
}
