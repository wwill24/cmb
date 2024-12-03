package com.coffeemeetsbagel.new_user_experience.new_to_online_dating;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbRadioGroup;
import com.coffeemeetsbagel.new_user_experience.new_to_online_dating.NewToOnlineDatingPresenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.xdata.FormField;
import tj.b;

public final class NewToOnlineDatingPageView {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f35506a;

    /* renamed from: b  reason: collision with root package name */
    private final NewToOnlineDatingPresenter.a f35507b;

    /* renamed from: c  reason: collision with root package name */
    private final NewToOnlineDatingPage f35508c;

    /* renamed from: d  reason: collision with root package name */
    private final NewToOnlineDatingPage f35509d;

    /* renamed from: e  reason: collision with root package name */
    private final ViewGroup f35510e;

    /* renamed from: f  reason: collision with root package name */
    private CmbRadioGroup<Pair<String, NewToOnlineDatingPage>> f35511f;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f35512a;

        /* renamed from: b  reason: collision with root package name */
        private final NewToOnlineDatingPresenter.a f35513b;

        /* renamed from: c  reason: collision with root package name */
        private final NewToOnlineDatingPage f35514c;

        /* renamed from: d  reason: collision with root package name */
        private String f35515d;

        /* renamed from: e  reason: collision with root package name */
        private List<Pair<String, NewToOnlineDatingPage>> f35516e;

        /* renamed from: f  reason: collision with root package name */
        private NewToOnlineDatingPage f35517f;

        public a(ViewGroup viewGroup, NewToOnlineDatingPresenter.a aVar, NewToOnlineDatingPage newToOnlineDatingPage) {
            j.g(viewGroup, "parentView");
            j.g(aVar, "listener");
            j.g(newToOnlineDatingPage, "newToOnlineDatingPage");
            this.f35512a = viewGroup;
            this.f35513b = aVar;
            this.f35514c = newToOnlineDatingPage;
        }

        public final a a(int i10, NewToOnlineDatingPage newToOnlineDatingPage) {
            j.g(newToOnlineDatingPage, "answer");
            String string = this.f35512a.getResources().getString(i10);
            j.f(string, "parentView.resources.getString(optionResourceId)");
            b(string, newToOnlineDatingPage);
            return this;
        }

        public final a b(String str, NewToOnlineDatingPage newToOnlineDatingPage) {
            j.g(str, FormField.Option.ELEMENT);
            j.g(newToOnlineDatingPage, "answer");
            if (this.f35516e == null) {
                this.f35516e = new ArrayList();
            }
            List<Pair<String, NewToOnlineDatingPage>> list = this.f35516e;
            if (list != null) {
                list.add(new Pair(str, newToOnlineDatingPage));
            }
            return this;
        }

        public final NewToOnlineDatingPageView c() {
            return new NewToOnlineDatingPageView(this.f35512a, this.f35513b, this.f35514c, this.f35515d, this.f35516e, this.f35517f, (DefaultConstructorMarker) null);
        }

        public final a d(String str) {
            j.g(str, "message");
            this.f35515d = str;
            return this;
        }

        public final a e(NewToOnlineDatingPage newToOnlineDatingPage) {
            if (newToOnlineDatingPage != null) {
                this.f35517f = newToOnlineDatingPage;
            }
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
            return j.b(this.f35512a, aVar.f35512a) && j.b(this.f35513b, aVar.f35513b) && this.f35514c == aVar.f35514c;
        }

        public int hashCode() {
            return (((this.f35512a.hashCode() * 31) + this.f35513b.hashCode()) * 31) + this.f35514c.hashCode();
        }

        public String toString() {
            ViewGroup viewGroup = this.f35512a;
            NewToOnlineDatingPresenter.a aVar = this.f35513b;
            NewToOnlineDatingPage newToOnlineDatingPage = this.f35514c;
            return "Builder(parentView=" + viewGroup + ", listener=" + aVar + ", newToOnlineDatingPage=" + newToOnlineDatingPage + ")";
        }
    }

    private NewToOnlineDatingPageView(ViewGroup viewGroup, NewToOnlineDatingPresenter.a aVar, NewToOnlineDatingPage newToOnlineDatingPage, String str, List<? extends Pair<String, ? extends NewToOnlineDatingPage>> list, NewToOnlineDatingPage newToOnlineDatingPage2) {
        boolean z10;
        int i10;
        this.f35506a = viewGroup;
        this.f35507b = aVar;
        this.f35508c = newToOnlineDatingPage;
        this.f35509d = newToOnlineDatingPage2;
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        View inflate = from.inflate(R.layout.onboarding_new_to_online_dating_slide, viewGroup, false);
        j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        this.f35510e = viewGroup2;
        ((TextView) viewGroup2.findViewById(R.id.message_view)).setText(str);
        View findViewById = viewGroup2.findViewById(R.id.option_list_container);
        j.f(findViewById, "rootViewGroup.findViewBy…id.option_list_container)");
        CmbRadioGroup<Pair<String, NewToOnlineDatingPage>> cmbRadioGroup = (CmbRadioGroup) findViewById;
        this.f35511f = cmbRadioGroup;
        if (list == null || list.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        cmbRadioGroup.setVisibility(i10);
        this.f35511f.setMaxOptions(1);
        this.f35511f.setMustSelectOne(true);
        b c10 = this.f35511f.h().c(new h(new NewToOnlineDatingPageView$checkedDisposable$1(this)));
        j.f(c10, "cmbRadioGroup.tagsOnChec…ptionSelected()\n        }");
        b c11 = this.f35511f.i().c(new i(new NewToOnlineDatingPageView$uncheckedDisposable$1(this)));
        j.f(c11, "cmbRadioGroup.tagsOnUnch…ptionSelected()\n        }");
        if (list != null) {
            for (Pair pair : list) {
                View inflate2 = from.inflate(R.layout.cmb_radio_group_checkbox, this.f35506a, false);
                j.e(inflate2, "null cannot be cast to non-null type android.widget.CheckBox");
                CheckBox checkBox = (CheckBox) inflate2;
                checkBox.setText((CharSequence) pair.c());
                NewToOnlineDatingPage newToOnlineDatingPage3 = this.f35509d;
                if (newToOnlineDatingPage3 != null && newToOnlineDatingPage3 == pair.d()) {
                    checkBox.setChecked(true);
                }
                this.f35511f.b(checkBox, pair);
            }
        }
        ((CmbButton) this.f35510e.findViewById(R.id.onboarding_next_button)).setOnClickListener(new j(this, c11, c10));
        NewToOnlineDatingPage newToOnlineDatingPage4 = this.f35508c;
        if (newToOnlineDatingPage4 == NewToOnlineDatingPage.FEMALE_NOT_NEW || newToOnlineDatingPage4 == NewToOnlineDatingPage.FEMALE_NEW || newToOnlineDatingPage4 == NewToOnlineDatingPage.MALE_NOT_NEW || newToOnlineDatingPage4 == NewToOnlineDatingPage.MALE_NEW) {
            ((CmbButton) this.f35510e.findViewById(R.id.onboarding_next_button)).setText(this.f35506a.getContext().getString(R.string.sounds_good));
        }
    }

    public /* synthetic */ NewToOnlineDatingPageView(ViewGroup viewGroup, NewToOnlineDatingPresenter.a aVar, NewToOnlineDatingPage newToOnlineDatingPage, String str, List list, NewToOnlineDatingPage newToOnlineDatingPage2, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, aVar, newToOnlineDatingPage, str, list, newToOnlineDatingPage2);
    }

    /* access modifiers changed from: private */
    public static final void d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void e(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void f(NewToOnlineDatingPageView newToOnlineDatingPageView, b bVar, b bVar2, View view) {
        Unit unit;
        j.g(newToOnlineDatingPageView, "this$0");
        j.g(bVar, "$uncheckedDisposable");
        j.g(bVar2, "$checkedDisposable");
        Pair pair = (Pair) CollectionsKt___CollectionsKt.P(newToOnlineDatingPageView.f35511f.getCheckedTags());
        if (pair != null) {
            newToOnlineDatingPageView.f35507b.O0((NewToOnlineDatingPage) pair.d(), (String) pair.c());
            unit = Unit.f32013a;
        } else {
            unit = null;
        }
        if (unit == null) {
            newToOnlineDatingPageView.f35507b.O0(NewToOnlineDatingPage.DONE, "");
        }
        bVar.dispose();
        bVar2.dispose();
    }

    public final NewToOnlineDatingPresenter.a g() {
        return this.f35507b;
    }

    public final NewToOnlineDatingPage h() {
        return this.f35508c;
    }

    public final ViewGroup i() {
        return this.f35510e;
    }
}
