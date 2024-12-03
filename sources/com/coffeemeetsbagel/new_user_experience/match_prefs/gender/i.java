package com.coffeemeetsbagel.new_user_experience.match_prefs.gender;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbRadioGroup;
import com.coffeemeetsbagel.models.entities.GenderType;
import ia.c;
import kotlin.jvm.internal.j;
import qj.q;
import t9.a;

public final class i extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final c f35374e;

    /* renamed from: f  reason: collision with root package name */
    private final String f35375f;

    /* renamed from: g  reason: collision with root package name */
    private final CmbRadioGroup<GenderType> f35376g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(c cVar) {
        super(cVar.getRoot());
        j.g(cVar, "binding");
        this.f35374e = cVar;
        String string = ((ViewGroup) this.f7869c).getResources().getString(R.string.onboarding_save_error);
        j.f(string, "view.resources.getString…ng.onboarding_save_error)");
        this.f35375f = string;
        CmbRadioGroup<GenderType> cmbRadioGroup = cVar.f40937c;
        j.e(cmbRadioGroup, "null cannot be cast to non-null type com.coffeemeetsbagel.cmb_views.CmbRadioGroup<com.coffeemeetsbagel.models.entities.GenderType>");
        this.f35376g = cmbRadioGroup;
    }

    private final void j(CmbRadioGroup<GenderType> cmbRadioGroup, String str, GenderType genderType, GenderType genderType2) {
        boolean z10 = false;
        View inflate = LayoutInflater.from(cmbRadioGroup.getContext()).inflate(R.layout.cmb_radio_group_checkbox, cmbRadioGroup, false);
        j.e(inflate, "null cannot be cast to non-null type android.widget.CheckBox");
        CheckBox checkBox = (CheckBox) inflate;
        checkBox.setText(str);
        if (genderType == genderType2) {
            z10 = true;
        }
        checkBox.setChecked(z10);
        cmbRadioGroup.b(checkBox, genderType);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        this.f35374e.f40936b.setText(a.onboardingDealbreakersMessageGender);
        CmbRadioGroup<GenderType> cmbRadioGroup = this.f35376g;
        cmbRadioGroup.setMaxOptions(1);
        cmbRadioGroup.setMustSelectOne(true);
    }

    public final GenderType k() {
        return (GenderType) CollectionsKt___CollectionsKt.N(this.f35376g.getCheckedTags());
    }

    public final q<GenderType> l() {
        return this.f35376g.g();
    }

    public final String m() {
        return this.f35375f;
    }

    public final void n(GenderType genderType) {
        boolean z10;
        if (this.f35376g.getChildCount() == 0) {
            String string = ((ViewGroup) this.f7869c).getContext().getString(R.string.match_prefs_gender_option_men);
            j.f(string, "view.context.getString(R…_prefs_gender_option_men)");
            j(this.f35376g, string, GenderType.MALE, genderType);
            String string2 = ((ViewGroup) this.f7869c).getContext().getString(R.string.match_prefs_gender_option_women);
            j.f(string2, "view.context.getString(R…refs_gender_option_women)");
            j(this.f35376g, string2, GenderType.FEMALE, genderType);
            String string3 = ((ViewGroup) this.f7869c).getContext().getString(R.string.match_prefs_gender_option_both);
            j.f(string3, "view.context.getString(R…prefs_gender_option_both)");
            j(this.f35376g, string3, GenderType.BISEXUAL, genderType);
            return;
        }
        int childCount = this.f35376g.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.f35376g.getChildAt(i10);
            j.e(childAt, "null cannot be cast to non-null type android.widget.CheckBox");
            CheckBox checkBox = (CheckBox) childAt;
            if (checkBox.getTag() == genderType) {
                z10 = true;
            } else {
                z10 = false;
            }
            checkBox.setChecked(z10);
        }
    }
}
