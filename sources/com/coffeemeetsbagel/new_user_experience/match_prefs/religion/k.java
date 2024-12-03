package com.coffeemeetsbagel.new_user_experience.match_prefs.religion;

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
    private final b f35476e;

    /* renamed from: f  reason: collision with root package name */
    private final String f35477f;

    /* renamed from: g  reason: collision with root package name */
    private final CmbRadioGroup<Resource> f35478g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(b bVar) {
        super(bVar.getRoot());
        j.g(bVar, "binding");
        this.f35476e = bVar;
        String string = ((ViewGroup) this.f7869c).getResources().getString(R.string.onboarding_save_error);
        j.f(string, "view.resources.getString…ng.onboarding_save_error)");
        this.f35477f = string;
        CmbRadioGroup<Resource> cmbRadioGroup = bVar.f40934d;
        j.e(cmbRadioGroup, "null cannot be cast to non-null type com.coffeemeetsbagel.cmb_views.CmbRadioGroup<com.coffeemeetsbagel.models.Resource>");
        this.f35478g = cmbRadioGroup;
    }

    public final String j() {
        return this.f35477f;
    }

    public final List<Resource> k() {
        return this.f35478g.getCheckedTags();
    }

    public final q<Resource> l() {
        return this.f35478g.g();
    }

    public final void m(o.a aVar) {
        j.g(aVar, "listener");
        Context context = ((ViewGroup) this.f7869c).getContext();
        j.f(context, "view.context");
        new o(aVar, context).show();
    }

    public final void n(List<Resource> list, List<String> list2) {
        this.f35476e.f40933c.setText(a.onboardingDealbreakersMessageReligion);
        if (this.f35478g.getChildCount() == 0) {
            LayoutInflater from = LayoutInflater.from(this.f35478g.getContext());
            if (list != null) {
                for (Resource resource : list) {
                    boolean z10 = false;
                    View inflate = from.inflate(R.layout.cmb_radio_group_checkbox, this.f35478g, false);
                    j.e(inflate, "null cannot be cast to non-null type android.widget.CheckBox");
                    CheckBox checkBox = (CheckBox) inflate;
                    checkBox.setText(resource.getValue());
                    if (list2 != null) {
                        z10 = list2.contains(resource.getValue());
                    }
                    checkBox.setChecked(z10);
                    this.f35478g.b(checkBox, resource);
                }
            }
        }
    }
}
