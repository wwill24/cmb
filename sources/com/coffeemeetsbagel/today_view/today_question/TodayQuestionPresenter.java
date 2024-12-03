package com.coffeemeetsbagel.today_view.today_question;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbRadioGroup;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Option;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import gk.f;
import java.util.List;
import kotlin.jvm.internal.j;
import r7.h;

public final class TodayQuestionPresenter extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final a f37513e;

    /* renamed from: f  reason: collision with root package name */
    private final f f37514f;

    /* renamed from: g  reason: collision with root package name */
    public CmbRadioGroup<String> f37515g;

    public interface a {
        void A0();

        void H();

        void O();

        void R();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TodayQuestionPresenter(ViewGroup viewGroup, a aVar) {
        super(viewGroup);
        j.g(viewGroup, "view");
        j.g(aVar, "listener");
        this.f37513e = aVar;
        this.f37514f = b.b(new TodayQuestionPresenter$progressDialog$2(viewGroup));
    }

    private final h p() {
        return (h) this.f37514f.getValue();
    }

    /* access modifiers changed from: private */
    public static final void t(TodayQuestionPresenter todayQuestionPresenter, View view) {
        j.g(todayQuestionPresenter, "this$0");
        todayQuestionPresenter.f37513e.H();
    }

    /* access modifiers changed from: private */
    public static final void u(TodayQuestionPresenter todayQuestionPresenter, View view) {
        j.g(todayQuestionPresenter, "this$0");
        todayQuestionPresenter.f37513e.O();
    }

    /* access modifiers changed from: private */
    public static final void y(TodayQuestionPresenter todayQuestionPresenter, View view) {
        j.g(todayQuestionPresenter, "this$0");
        todayQuestionPresenter.f37513e.A0();
    }

    /* access modifiers changed from: private */
    public static final void z(TodayQuestionPresenter todayQuestionPresenter, View view) {
        j.g(todayQuestionPresenter, "this$0");
        todayQuestionPresenter.f37513e.R();
    }

    public final CmbRadioGroup<String> n() {
        CmbRadioGroup<String> cmbRadioGroup = this.f37515g;
        if (cmbRadioGroup != null) {
            return cmbRadioGroup;
        }
        j.y("checkBoxGroup");
        return null;
    }

    public final List<String> o() {
        return n().getCheckedTags();
    }

    public final void q(CmbRadioGroup<String> cmbRadioGroup) {
        j.g(cmbRadioGroup, "<set-?>");
        this.f37515g = cmbRadioGroup;
    }

    public final void r() {
        ((ViewGroup) this.f7869c).removeAllViews();
        View inflate = LayoutInflater.from(((ViewGroup) this.f7869c).getContext()).inflate(R.layout.component_periodic_question_confirmation, (ViewGroup) this.f7869c, false);
        j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        viewGroup.findViewById(R.id.got_it).setOnClickListener(new v(this));
        viewGroup.findViewById(R.id.edit_button).setOnClickListener(new w(this));
        ((ViewGroup) this.f7869c).addView(viewGroup);
    }

    public final void v(boolean z10) {
        if (z10) {
            p().show();
        } else {
            p().dismiss();
        }
    }

    public final void w(String str, List<Option> list, List<Answer> list2, Integer num) {
        j.g(str, "questionText");
        j.g(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        j.g(list2, "answers");
        ((ViewGroup) this.f7869c).removeAllViews();
        View inflate = LayoutInflater.from(((ViewGroup) this.f7869c).getContext()).inflate(R.layout.component_periodic_question, (ViewGroup) this.f7869c, false);
        j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        View findViewById = viewGroup.findViewById(R.id.list_layout);
        j.f(findViewById, "layout.findViewById(R.id.list_layout)");
        q((CmbRadioGroup) findViewById);
        n().removeAllViews();
        if (num != null) {
            n().setMaxOptions(num.intValue());
        }
        LayoutInflater from = LayoutInflater.from(((ViewGroup) this.f7869c).getContext());
        for (Option option : list) {
            View inflate2 = from.inflate(R.layout.cmb_radio_group_checkbox, n(), false);
            j.e(inflate2, "null cannot be cast to non-null type android.widget.CheckBox");
            CheckBox checkBox = (CheckBox) inflate2;
            checkBox.setText(option.getTitle());
            n().b(checkBox, option.getId());
            for (Answer optionId : list2) {
                if (j.b(option.getId(), optionId.getOptionId())) {
                    checkBox.setChecked(true);
                }
            }
        }
        ((TextView) viewGroup.findViewById(R.id.question_text)).setText(str);
        viewGroup.findViewById(R.id.add_button).setOnClickListener(new t(this));
        viewGroup.findViewById(R.id.skip_button).setOnClickListener(new u(this));
        ((ViewGroup) this.f7869c).addView(viewGroup);
    }
}
