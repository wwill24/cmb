package com.coffeemeetsbagel.feature.profile_completion_helper.occupation;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.lifecycle.i0;
import androidx.lifecycle.l0;
import androidx.lifecycle.m;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperActivity;
import com.coffeemeetsbagel.feature.profile_completion_helper.f;
import k6.u;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class a extends Fragment implements f {

    /* renamed from: d  reason: collision with root package name */
    public static final C0141a f13336d = new C0141a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public c f13337a;

    /* renamed from: b  reason: collision with root package name */
    public OccupationViewModel f13338b;

    /* renamed from: c  reason: collision with root package name */
    public u f13339c;

    /* renamed from: com.coffeemeetsbagel.feature.profile_completion_helper.occupation.a$a  reason: collision with other inner class name */
    public static final class C0141a {
        private C0141a() {
        }

        public /* synthetic */ C0141a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            return new a();
        }
    }

    public final OccupationViewModel A0() {
        OccupationViewModel occupationViewModel = this.f13338b;
        if (occupationViewModel != null) {
            return occupationViewModel;
        }
        j.y("viewModel");
        return null;
    }

    public final c B0() {
        c cVar = this.f13337a;
        if (cVar != null) {
            return cVar;
        }
        j.y("viewModelFactory");
        return null;
    }

    public final void C0(u uVar) {
        j.g(uVar, "<set-?>");
        this.f13339c = uVar;
    }

    public final void D0(OccupationViewModel occupationViewModel) {
        j.g(occupationViewModel, "<set-?>");
        this.f13338b = occupationViewModel;
    }

    public void d() {
        boolean z10;
        Editable text = z0().f15819c.getText();
        Editable text2 = z0().f15818b.getText();
        j.d(text2);
        boolean z11 = true;
        if (text2.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            j.d(text);
            if (text.length() <= 0) {
                z11 = false;
            }
            if (z11) {
                OccupationViewModel A0 = A0();
                h requireActivity = requireActivity();
                j.f(requireActivity, "requireActivity()");
                A0.h(m.a(requireActivity), text.toString(), text2.toString());
                h requireActivity2 = requireActivity();
                j.e(requireActivity2, "null cannot be cast to non-null type com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperActivity");
                ((ProfileCompletionHelperActivity) requireActivity2).next();
                return;
            }
        }
        View requireView = requireView();
        j.f(requireView, "requireView()");
        sb.a.k(requireView, R.string.error_occupation_required);
    }

    public void onCreate(Bundle bundle) {
        Bakery.j().V0(this);
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        u c10 = u.c(layoutInflater, viewGroup, false);
        j.f(c10, "inflate(inflater, container, false)");
        C0(c10);
        D0((OccupationViewModel) new i0((l0) this, (i0.b) B0()).a(OccupationViewModel.class));
        ScrollView b10 = z0().getRoot();
        j.f(b10, "binding.root");
        return b10;
    }

    public final u z0() {
        u uVar = this.f13339c;
        if (uVar != null) {
            return uVar;
        }
        j.y("binding");
        return null;
    }
}
