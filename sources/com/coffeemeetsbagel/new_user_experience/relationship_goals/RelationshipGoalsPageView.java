package com.coffeemeetsbagel.new_user_experience.relationship_goals;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbRadioGroup;
import com.coffeemeetsbagel.new_user_experience.relationship_goals.RelationshipGoalsPresenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.xdata.FormField;
import tj.b;

public final class RelationshipGoalsPageView {

    /* renamed from: a  reason: collision with root package name */
    private final RelationshipGoalPage f35596a;

    /* renamed from: b  reason: collision with root package name */
    private final RelationshipGoalPage f35597b;

    /* renamed from: c  reason: collision with root package name */
    private final ViewGroup f35598c;

    /* renamed from: d  reason: collision with root package name */
    private b f35599d;

    /* renamed from: e  reason: collision with root package name */
    private CmbRadioGroup<Pair<String, RelationshipGoalPage>> f35600e;

    private RelationshipGoalsPageView(ViewGroup viewGroup, final RelationshipGoalsPresenter.a aVar, RelationshipGoalPage relationshipGoalPage, String str, List<? extends Pair<String, ? extends RelationshipGoalPage>> list, RelationshipGoalPage relationshipGoalPage2, boolean z10, String str2, String str3) {
        boolean z11;
        Unit unit;
        ViewGroup viewGroup2 = viewGroup;
        RelationshipGoalsPresenter.a aVar2 = aVar;
        this.f35596a = relationshipGoalPage;
        this.f35597b = relationshipGoalPage2;
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        View inflate = from.inflate(R.layout.onboarding_relationship_goals_slide, viewGroup, false);
        j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup3 = (ViewGroup) inflate;
        this.f35598c = viewGroup3;
        ((TextView) viewGroup3.findViewById(R.id.message_view)).setText(str);
        Button button = (Button) viewGroup3.findViewById(R.id.onboarding_next_button);
        TextView textView = (TextView) viewGroup3.findViewById(R.id.onboarding_seconday_link);
        View findViewById = viewGroup3.findViewById(R.id.answer_list_container);
        j.f(findViewById, "rootViewGroup.findViewBy…id.answer_list_container)");
        CmbRadioGroup<Pair<String, RelationshipGoalPage>> cmbRadioGroup = (CmbRadioGroup) findViewById;
        this.f35600e = cmbRadioGroup;
        cmbRadioGroup.setMaxOptions(1);
        this.f35600e.setMustSelectOne(true);
        b c10 = this.f35600e.h().c(new h(new Function1<Pair<? extends String, ? extends RelationshipGoalPage>, Unit>() {
            public final void a(Pair<String, ? extends RelationshipGoalPage> pair) {
                aVar.M((RelationshipGoalPage) pair.d());
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Pair) obj);
                return Unit.f32013a;
            }
        }));
        j.f(c10, "checkBoxGroup.tagsOnChec…ed(pair.second)\n        }");
        this.f35599d = c10;
        if (str2.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            button.setText(str2);
        }
        if (z10) {
            textView.setText(str3);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        if (list != null) {
            for (Pair pair : list) {
                View inflate2 = from.inflate(R.layout.cmb_radio_group_checkbox, viewGroup, false);
                j.e(inflate2, "null cannot be cast to non-null type android.widget.CheckBox");
                CheckBox checkBox = (CheckBox) inflate2;
                checkBox.setText((CharSequence) pair.c());
                RelationshipGoalPage relationshipGoalPage3 = this.f35597b;
                if (relationshipGoalPage3 != null && relationshipGoalPage3 == pair.d()) {
                    checkBox.setChecked(true);
                }
                this.f35600e.b(checkBox, pair);
            }
            unit = Unit.f32013a;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.f35600e.setVisibility(4);
        }
        ((CmbButton) this.f35598c.findViewById(R.id.onboarding_next_button)).setOnClickListener(new i(this, aVar));
        ((TextView) this.f35598c.findViewById(R.id.onboarding_seconday_link)).setOnClickListener(new j(aVar));
    }

    public /* synthetic */ RelationshipGoalsPageView(ViewGroup viewGroup, RelationshipGoalsPresenter.a aVar, RelationshipGoalPage relationshipGoalPage, String str, List list, RelationshipGoalPage relationshipGoalPage2, boolean z10, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, aVar, relationshipGoalPage, str, list, relationshipGoalPage2, z10, str2, str3);
    }

    /* access modifiers changed from: private */
    public static final void d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void e(RelationshipGoalsPageView relationshipGoalsPageView, RelationshipGoalsPresenter.a aVar, View view) {
        Unit unit;
        j.g(relationshipGoalsPageView, "this$0");
        j.g(aVar, "$listener");
        Pair pair = (Pair) CollectionsKt___CollectionsKt.P(relationshipGoalsPageView.f35600e.getCheckedTags());
        if (pair != null) {
            aVar.C0((RelationshipGoalPage) pair.d(), (String) pair.c());
            unit = Unit.f32013a;
        } else {
            unit = null;
        }
        if (unit == null) {
            RelationshipGoalsPresenter.a.n1(aVar, RelationshipGoalPage.DONE, (String) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void f(RelationshipGoalsPresenter.a aVar, View view) {
        j.g(aVar, "$listener");
        aVar.N();
    }

    public final RelationshipGoalPage g() {
        return this.f35596a;
    }

    public final ViewGroup h() {
        return this.f35598c;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f35601a;

        /* renamed from: b  reason: collision with root package name */
        private final RelationshipGoalsPresenter.a f35602b;

        /* renamed from: c  reason: collision with root package name */
        private final RelationshipGoalPage f35603c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f35604d;

        /* renamed from: e  reason: collision with root package name */
        private String f35605e;

        /* renamed from: f  reason: collision with root package name */
        private List<Pair<String, RelationshipGoalPage>> f35606f;

        /* renamed from: g  reason: collision with root package name */
        private RelationshipGoalPage f35607g;

        /* renamed from: h  reason: collision with root package name */
        private String f35608h;

        /* renamed from: i  reason: collision with root package name */
        private String f35609i;

        public a(ViewGroup viewGroup, RelationshipGoalsPresenter.a aVar, RelationshipGoalPage relationshipGoalPage, boolean z10) {
            j.g(viewGroup, "parentView");
            j.g(aVar, "listener");
            j.g(relationshipGoalPage, "relationshipGoal");
            this.f35601a = viewGroup;
            this.f35602b = aVar;
            this.f35603c = relationshipGoalPage;
            this.f35604d = z10;
            this.f35608h = "";
            this.f35609i = "";
        }

        public final a a(int i10, RelationshipGoalPage relationshipGoalPage) {
            j.g(relationshipGoalPage, "answer");
            String string = this.f35601a.getResources().getString(i10);
            j.f(string, "parentView.resources.getString(optionResourceId)");
            b(string, relationshipGoalPage);
            return this;
        }

        public final a b(String str, RelationshipGoalPage relationshipGoalPage) {
            j.g(str, FormField.Option.ELEMENT);
            j.g(relationshipGoalPage, "answer");
            if (this.f35606f == null) {
                this.f35606f = new ArrayList();
            }
            List<Pair<String, RelationshipGoalPage>> list = this.f35606f;
            if (list != null) {
                list.add(new Pair(str, relationshipGoalPage));
            }
            return this;
        }

        public final RelationshipGoalsPageView c() {
            return new RelationshipGoalsPageView(this.f35601a, this.f35602b, this.f35603c, this.f35605e, this.f35606f, this.f35607g, this.f35604d, this.f35608h, this.f35609i, (DefaultConstructorMarker) null);
        }

        public final a d(int i10) {
            this.f35605e = this.f35601a.getResources().getString(i10);
            return this;
        }

        public final a e(String str) {
            j.g(str, "message");
            this.f35605e = str;
            return this;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return j.b(this.f35601a, aVar.f35601a) && j.b(this.f35602b, aVar.f35602b) && this.f35603c == aVar.f35603c && this.f35604d == aVar.f35604d;
        }

        public final a f(int i10) {
            String string = this.f35601a.getResources().getString(i10);
            j.f(string, "parentView.resources.get…ring(primaryCtaTextResId)");
            this.f35608h = string;
            return this;
        }

        public final a g(int i10) {
            String string = this.f35601a.getResources().getString(i10);
            j.f(string, "parentView.resources.get…ng(secondaryCtaTextResId)");
            this.f35609i = string;
            return this;
        }

        public final a h(RelationshipGoalPage relationshipGoalPage) {
            if (relationshipGoalPage != null) {
                this.f35607g = relationshipGoalPage;
            }
            return this;
        }

        public int hashCode() {
            int hashCode = ((((this.f35601a.hashCode() * 31) + this.f35602b.hashCode()) * 31) + this.f35603c.hashCode()) * 31;
            boolean z10 = this.f35604d;
            if (z10) {
                z10 = true;
            }
            return hashCode + (z10 ? 1 : 0);
        }

        public String toString() {
            ViewGroup viewGroup = this.f35601a;
            RelationshipGoalsPresenter.a aVar = this.f35602b;
            RelationshipGoalPage relationshipGoalPage = this.f35603c;
            boolean z10 = this.f35604d;
            return "Builder(parentView=" + viewGroup + ", listener=" + aVar + ", relationshipGoal=" + relationshipGoalPage + ", showSecondaryCta=" + z10 + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(ViewGroup viewGroup, RelationshipGoalsPresenter.a aVar, RelationshipGoalPage relationshipGoalPage, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(viewGroup, aVar, relationshipGoalPage, (i10 & 8) != 0 ? false : z10);
        }
    }
}
