package com.coffeemeetsbagel.new_user_experience.match_prefs.ethnicity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbRadioGroup;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.new_user_experience.match_prefs.o;
import ia.b;
import java.util.List;
import kotlin.jvm.internal.j;
import qj.q;
import t9.a;

public final class k extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final b f35349e;

    /* renamed from: f  reason: collision with root package name */
    private final String f35350f;

    /* renamed from: g  reason: collision with root package name */
    private final CmbRadioGroup<Resource> f35351g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(b bVar) {
        super(bVar.getRoot());
        j.g(bVar, "binding");
        this.f35349e = bVar;
        String string = ((ViewGroup) this.f7869c).getResources().getString(R.string.onboarding_save_error);
        j.f(string, "view.resources.getString…ng.onboarding_save_error)");
        this.f35350f = string;
        CmbRadioGroup<Resource> cmbRadioGroup = bVar.f40934d;
        j.e(cmbRadioGroup, "null cannot be cast to non-null type com.coffeemeetsbagel.cmb_views.CmbRadioGroup<com.coffeemeetsbagel.models.Resource>");
        this.f35351g = cmbRadioGroup;
    }

    public final List<Resource> j() {
        return this.f35351g.getCheckedTags();
    }

    public final q<Resource> k() {
        return this.f35351g.g();
    }

    public final String l() {
        return this.f35350f;
    }

    public final void m(o.a aVar) {
        j.g(aVar, "listener");
        Context context = ((ViewGroup) this.f7869c).getContext();
        j.f(context, "view.context");
        new o(aVar, context).show();
    }

    public final void n(List<Resource> list, List<String> list2) {
        this.f35349e.f40933c.setText(a.onboardingDealbreakersMessageEthnicity);
        if (this.f35351g.getChildCount() == 0) {
            LayoutInflater from = LayoutInflater.from(this.f35351g.getContext());
            if (list != null) {
                for (Resource resource : list) {
                    boolean z10 = false;
                    View inflate = from.inflate(R.layout.cmb_radio_group_checkbox, this.f35351g, false);
                    j.e(inflate, "null cannot be cast to non-null type android.widget.CheckBox");
                    CheckBox checkBox = (CheckBox) inflate;
                    checkBox.setText(resource.getValue());
                    if (list2 != null) {
                        z10 = list2.contains(resource.getValue());
                    }
                    checkBox.setChecked(z10);
                    this.f35351g.b(checkBox, resource);
                }
            }
        }
    }
}
