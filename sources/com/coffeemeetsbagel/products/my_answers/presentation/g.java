package com.coffeemeetsbagel.products.my_answers.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.h;
import b6.d;
import b6.r;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivityProfileEdit;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.products.my_answers.presentation.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class g extends b6.a<c, ActivityProfileEdit> {

    /* renamed from: d  reason: collision with root package name */
    public static final a f35868d = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    public a7.a f35869b;

    /* renamed from: c  reason: collision with root package name */
    public j0 f35870c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ActivityProfileEdit f35871a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f35872b;

        public b(g gVar, ActivityProfileEdit activityProfileEdit) {
            j.g(activityProfileEdit, "componentActivity");
            this.f35872b = gVar;
            this.f35871a = activityProfileEdit;
        }

        public final c6.b a(androidx.appcompat.app.c cVar) {
            j.g(cVar, "activity");
            if (!(cVar instanceof d)) {
                return new c6.b();
            }
            c6.b F0 = ((d) cVar).F0();
            j.f(F0, "{\n                activi…ultStream()\n            }");
            return F0;
        }

        public final androidx.appcompat.app.c b() {
            return this.f35871a;
        }
    }

    public interface c extends b6.b<ActivityProfileEdit>, m.c {
        void N(g gVar);
    }

    private final void H0() {
        if (getActivity() != null && !requireActivity().isFinishing() && getView() != null) {
            C c10 = this.f7846a;
            if (c10 == null || !(c10 instanceof m.c)) {
                fa.a.f40771d.b("MyAnsweredPromptsDependencyFragment", "Component null or unexpected type");
                return;
            }
            ViewStub viewStub = (ViewStub) requireView().findViewById(R.id.my_prompts_container);
            C c11 = this.f7846a;
            j.d(c11);
            m mVar = new m((m.c) c11);
            j.f(viewStub, "viewContainer");
            G0(mVar.b(viewStub, true, MyAnswersLocation.PROFILE_EDIT));
            r.a(F0());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: D0 */
    public c z0(ActivityProfileEdit activityProfileEdit) {
        j.g(activityProfileEdit, "componentActivity");
        c a10 = b.a().b(new b(this, activityProfileEdit)).c(Bakery.j()).a();
        j.f(a10, "builder()\n            .m…t())\n            .build()");
        return a10;
    }

    public final a7.a E0() {
        a7.a aVar = this.f35869b;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final j0 F0() {
        j0 j0Var = this.f35870c;
        if (j0Var != null) {
            return j0Var;
        }
        j.y("router");
        return null;
    }

    public final void G0(j0 j0Var) {
        j.g(j0Var, "<set-?>");
        this.f35870c = j0Var;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        h activity = getActivity();
        j.e(activity, "null cannot be cast to non-null type com.coffeemeetsbagel.activities.ActivityProfileEdit");
        ActivityProfileEdit activityProfileEdit = (ActivityProfileEdit) activity;
        if (this.f7846a == null) {
            this.f7846a = z0(activityProfileEdit);
        } else {
            C0(activityProfileEdit);
        }
        C c10 = this.f7846a;
        j.d(c10);
        ((c) c10).N(this);
        activityProfileEdit.V1();
        H0();
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        F0().o(i10, i11, intent);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_my_prompts, viewGroup, false);
    }

    public void onResume() {
        super.onResume();
        E0().f("Manage Profile Prompts");
    }
}
