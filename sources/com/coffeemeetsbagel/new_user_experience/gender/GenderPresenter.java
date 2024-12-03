package com.coffeemeetsbagel.new_user_experience.gender;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.view.d;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbRadioGroup;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import fa.a;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class GenderPresenter extends p<ViewGroup> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final a f34996e;

    /* renamed from: f  reason: collision with root package name */
    private final String f34997f;

    /* renamed from: g  reason: collision with root package name */
    private QuestionWAnswers f34998g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public GenderType f34999h = GenderType.UNSPECIFIED;

    public interface a {
        void d();

        void f();

        void o(GenderType genderType);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenderPresenter(ViewGroup viewGroup, a aVar) {
        super(viewGroup);
        j.g(viewGroup, "view");
        j.g(aVar, "listener");
        this.f34996e = aVar;
        String string = viewGroup.getContext().getString(R.string.onboarding_save_error);
        j.f(string, "view.context.getString(R…ng.onboarding_save_error)");
        this.f34997f = string;
    }

    /* access modifiers changed from: private */
    public static final void p(GenderPresenter genderPresenter, View view) {
        j.g(genderPresenter, "this$0");
        genderPresenter.f34996e.d();
    }

    /* access modifiers changed from: private */
    public static final void q(GenderPresenter genderPresenter, View view) {
        j.g(genderPresenter, "this$0");
        genderPresenter.f34996e.f();
    }

    /* access modifiers changed from: private */
    public static final void y(GenderPresenter genderPresenter, View view) {
        j.g(genderPresenter, "this$0");
        view.setVisibility(4);
        QuestionWAnswers questionWAnswers = null;
        view.setOnClickListener((View.OnClickListener) null);
        QuestionWAnswers questionWAnswers2 = genderPresenter.f34998g;
        if (questionWAnswers2 == null) {
            j.y("question");
        } else {
            questionWAnswers = questionWAnswers2;
        }
        genderPresenter.w(questionWAnswers, false);
    }

    /* access modifiers changed from: private */
    public static final void z(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        CmbButton cmbButton = (CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button);
        cmbButton.setEnabled(false);
        cmbButton.setOnClickListener(new o(this));
        ((CmbImageView) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_back_button)).setOnClickListener(new p(this));
    }

    public final void r() {
        ((CmbButton) ((ViewGroup) this.f7869c).findViewById(R.id.onboarding_next_button)).setEnabled(true);
    }

    public final String t() {
        return this.f34997f;
    }

    public final void u(GenderType genderType) {
        boolean z10;
        j.g(genderType, "genderType");
        this.f34999h = genderType;
        CmbRadioGroup cmbRadioGroup = (CmbRadioGroup) ((ViewGroup) this.f7869c).findViewById(R.id.option_list_container);
        int childCount = cmbRadioGroup.getChildCount();
        if (childCount >= 0) {
            int i10 = 0;
            while (true) {
                View childAt = cmbRadioGroup.getChildAt(i10);
                if (childAt != null && (childAt instanceof CompoundButton)) {
                    CompoundButton compoundButton = (CompoundButton) childAt;
                    Object tag = compoundButton.getTag();
                    j.e(tag, "null cannot be cast to non-null type com.coffeemeetsbagel.models.entities.GenderType");
                    if (((GenderType) tag) == genderType) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    compoundButton.setChecked(z10);
                }
                if (i10 == childCount) {
                    break;
                }
                i10++;
            }
        }
        this.f34996e.o(genderType);
    }

    public final void v(String str) {
        j.g(str, "label");
        ((TextView) ((ViewGroup) this.f7869c).findViewById(R.id.message)).setText(str);
    }

    public final void w(QuestionWAnswers questionWAnswers, boolean z10) {
        int i10;
        j.g(questionWAnswers, "question");
        this.f34998g = questionWAnswers;
        CmbRadioGroup cmbRadioGroup = (CmbRadioGroup) ((ViewGroup) this.f7869c).findViewById(R.id.option_list_container);
        cmbRadioGroup.removeAllViews();
        if (z10) {
            i10 = 2;
        } else {
            i10 = questionWAnswers.e().getOptions().size();
        }
        int i11 = i10 - 1;
        if (i11 >= 0) {
            int i12 = 0;
            while (true) {
                Option option = questionWAnswers.e().getOptions().get(i12);
                if (option.getName() != null) {
                    CheckBox checkBox = new CheckBox(new d(cmbRadioGroup.getContext(), (int) R.style.cmb_radio_group_checkbox));
                    checkBox.setTextAppearance(R.style.cmb_radio_group_checkbox);
                    checkBox.setButtonDrawable((Drawable) null);
                    checkBox.setText(option.getTitle());
                    checkBox.setBackground((Drawable) null);
                    a.C0491a aVar = fa.a.f40771d;
                    String name = option.getName();
                    j.d(name);
                    aVar.a("GenderPresenter", name);
                    GenderType.Companion companion = GenderType.Companion;
                    String name2 = option.getName();
                    j.d(name2);
                    cmbRadioGroup.b(checkBox, companion.fromApiKey(name2));
                }
                if (i12 == i11) {
                    break;
                }
                i12++;
            }
        }
        GenderType genderType = this.f34999h;
        if (genderType != GenderType.UNSPECIFIED) {
            u(genderType);
        }
        TextView textView = (TextView) ((ViewGroup) this.f7869c).findViewById(R.id.see_more_identities);
        if (z10) {
            textView.setVisibility(0);
            textView.setOnClickListener(new q(this));
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        ((com.uber.autodispose.p) cmbRadioGroup.h().g(com.uber.autodispose.a.a(this))).c(new r(new GenderPresenter$setQuestion$2(this)));
    }
}
